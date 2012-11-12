/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
 *
 * openSCADA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * only, as published by the Free Software Foundation.
 *
 * openSCADA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License version 3 for more details
 * (a copy is included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with openSCADA. If not, see
 * <http://opensource.org/licenses/lgpl-3.0.html> for a copy of the LGPLv3 License.
 */

package org.openscada.vi.details.swt.impl;

import java.net.URL;
import java.util.Collection;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import javax.script.SimpleScriptContext;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.UnionSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.openscada.core.ui.connection.login.SessionManager;
import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.details.model.DetailView.Component;
import org.openscada.vi.details.model.DetailView.GroupEntry;
import org.openscada.vi.details.model.DetailView.HiddenComponent;
import org.openscada.vi.details.model.DetailView.ScriptModule;
import org.openscada.vi.details.model.DetailView.View;
import org.openscada.vi.details.swt.Activator;
import org.openscada.vi.details.swt.DetailComponent;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.impl.visibility.ComponentVisibility;
import org.openscada.vi.details.swt.impl.visibility.TabVisibleComponent;
import org.openscada.vi.details.swt.impl.visibility.VisibilityProvider;
import org.openscada.vi.details.swt.impl.visibility.VisibilityProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailViewImpl implements org.openscada.vi.details.DetailView, IExecutableExtension
{

    private static final Logger logger = LoggerFactory.getLogger ( DetailViewImpl.class );

    private static final String realtimeListRole = System.getProperty ( "org.openscada.vi.details.swt.impl.roles.realtimeList", "admin" );

    private String uri;

    private DetailComponent header;

    private final List<GroupTab> groups = new LinkedList<GroupTab> ();

    private RealTimeGroupTab realTimeTab;

    private EList<HiddenComponent> hiddenItems;

    private VisibilityProviderFactory visibleFactory;

    private final Collection<ComponentVisibility> visibilities = new LinkedList<ComponentVisibility> ();

    private EList<ScriptModule> scriptModuels;

    public DetailViewImpl ()
    {
    }

    @Override
    public void dispose ()
    {
        if ( this.header != null )
        {
            this.header.dispose ();
        }
        for ( final GroupTab group : this.groups )
        {
            group.dispose ();
        }
        for ( final ComponentVisibility visibility : this.visibilities )
        {
            visibility.dispose ();
        }
    }

    @Override
    public void init ( final Composite parent, final Map<String, String> properties )
    {
        try
        {
            final ScriptEngineManager engineManager = new ScriptEngineManager ( Activator.class.getClassLoader () );
            final ScriptContext scriptContext = new SimpleScriptContext ();
            scriptContext.setBindings ( new SimpleBindings (), ScriptContext.GLOBAL_SCOPE );
            scriptContext.setAttribute ( "properties", properties, ScriptContext.GLOBAL_SCOPE ); //$NON-NLS-1$

            this.visibleFactory = new VisibilityProviderFactory ( engineManager, scriptContext );

            load ();

            // load script modules
            for ( final ScriptModule module : this.scriptModuels )
            {
                loadScriptModule ( engineManager, scriptContext, module );
            }

            final Composite box = new Composite ( parent, SWT.NONE );
            box.setLayout ( new GridLayout ( 1, false ) );

            final List<IObservableSet> lists = new LinkedList<IObservableSet> ();

            final WritableSet hiddenItems = new WritableSet ();
            lists.add ( hiddenItems );

            // add hidden
            for ( final HiddenComponent hidden : this.hiddenItems )
            {
                final String item = DetailComponentImpl.resolve ( hidden.getDescriptor (), properties );
                hiddenItems.add ( DataItemDescriptor.create ( item ) );
            }

            // init
            if ( this.header != null )
            {
                final Composite wrapper = new Composite ( box, SWT.NONE );
                wrapper.setLayout ( new FillLayout () );
                wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
                this.header.init ( this.visibleFactory, wrapper, properties );
                lists.add ( this.header.getDescriptors () );
                this.header.start ();
            }

            final TabFolder folder = new TabFolder ( box, SWT.NONE );
            folder.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
            int i = 0;
            for ( final GroupTab group : this.groups )
            {
                final Composite wrapper = new Composite ( folder, SWT.NONE );
                wrapper.setLayout ( new FillLayout () );
                group.init ( this.visibleFactory, wrapper, properties );

                final VisibilityProvider provider = this.visibleFactory.createProvider ( group.getVisibility () );
                final TabVisibleComponent component = new TabVisibleComponent ( folder, i, group, wrapper );
                final ComponentVisibility visibility = new ComponentVisibility ( provider, component );
                addVisibility ( visibility );

                lists.add ( visibility.getDescriptors () );
                i++;
            }

            // hook up realtime list to observable list
            this.realTimeTab.setInput ( new UnionSet ( lists.toArray ( new IObservableSet[lists.size ()] ) ) );

        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to load view", e ); //$NON-NLS-1$
            return;
        }
    }

    private void loadScriptModule ( final ScriptEngineManager engineManager, final ScriptContext scriptContext, final ScriptModule module ) throws Exception
    {
        String engineName = module.getScriptLanguage ();

        if ( engineName == null || engineName.isEmpty () )
        {
            engineName = "JavaScript";
        }

        if ( module.getCode () != null && !module.getCode ().isEmpty () )
        {
            new ScriptExecutor ( engineManager, engineName, module.getCode (), Activator.class.getClassLoader () ).execute ( scriptContext );
        }
        if ( module.getCodeUri () != null && !module.getCodeUri ().isEmpty () )
        {
            new ScriptExecutor ( engineManager, engineName, new URL ( module.getCodeUri () ), Activator.class.getClassLoader () ).execute ( scriptContext );
        }
    }

    private void addVisibility ( final ComponentVisibility visibility )
    {
        this.visibilities.add ( visibility );
        visibility.start ();
    }

    private void load ()
    {
        logger.info ( "Loading: {}", this.uri ); //$NON-NLS-1$

        final ResourceSet resourceSet = new ResourceSetImpl ();

        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new XMIResourceFactoryImpl () ); //$NON-NLS-1$

        final URI file = URI.createURI ( this.uri );
        final Resource resource = resourceSet.getResource ( file, true );

        for ( final EObject o : resource.getContents () )
        {
            if ( o instanceof View )
            {
                createView ( (View)o );
            }
        }
    }

    private void createView ( final View view )
    {
        this.scriptModuels = view.getScriptModule ();
        this.hiddenItems = view.getHiddenComponent ();

        this.header = createComponent ( view.getHeaderComponent () );

        this.realTimeTab = new RealTimeGroupTab ();

        for ( final GroupEntry group : view.getGroups () )
        {
            final DetailComponent component = createComponent ( group.getComponent () );

            if ( component != null )
            {
                final GroupTab groupTab = new GroupTabImpl ( group.getLabel (), component, group.getVisibility () );
                if ( group.getPermission () == null )
                {
                    //there are no special user rights available, so just show the TAB
                    this.groups.add ( groupTab );
                }
                else if ( SessionManager.getDefault ().hasRole ( group.getPermission () ) )
                {
                    this.groups.add ( groupTab );
                }
            }
        }
        if ( SessionManager.getDefault ().hasRole ( realtimeListRole ) )
        {
            this.groups.add ( this.realTimeTab );
        }
    }

    private DetailComponent createComponent ( final Component component )
    {
        if ( component == null )
        {
            return null;
        }

        return new DetailComponentImpl ( component );
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        if ( data instanceof String )
        {
            this.uri = "" + data; //$NON-NLS-1$
        }
        else if ( data instanceof Dictionary<?, ?> )
        {
            this.uri = "" + ( (Dictionary<?, ?>)data ).get ( "uri" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

    }
}
