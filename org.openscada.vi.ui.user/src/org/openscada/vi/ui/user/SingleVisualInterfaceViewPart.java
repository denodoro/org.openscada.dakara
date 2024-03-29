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

package org.openscada.vi.ui.user;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.part.ViewPart;
import org.openscada.core.Variant;
import org.openscada.ui.databinding.DataItemObservableValue;
import org.openscada.ui.databinding.VariantToStringConverter;
import org.openscada.vi.ui.user.preferences.PreferenceConstants;

public class SingleVisualInterfaceViewPart extends ViewPart implements ViewManager
{

    private Composite viewHolder;

    private ToolBar toolBar;

    private final Map<String, ViewInstance> instances = new LinkedHashMap<String, ViewInstance> ( 1 );

    private ViewInstance currentInstance;

    private StackLayout stackLayout;

    private ResourceManager manager;

    private Label timeLabel;

    private DataItemObservableValue dataItem;

    private DataBindingContext dbc;

    private Image image;

    public SingleVisualInterfaceViewPart ()
    {
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.manager = new LocalResourceManager ( JFaceResources.getResources () );
        this.dbc = new DataBindingContext ();

        parent.setLayout ( new FillLayout () );
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        final GridLayout layout = new GridLayout ( 1, true );
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        layout.marginHeight = layout.marginWidth = 0;
        wrapper.setLayout ( layout );

        final Composite toolWrapper = new Composite ( wrapper, SWT.NONE );
        toolWrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
        final GridLayout toolLayout = new GridLayout ( 1 + ( hasTime () ? 1 : 0 ) + ( hasLogo () ? 1 : 0 ), false );
        toolLayout.marginHeight = toolLayout.marginWidth = 0;
        toolWrapper.setLayout ( toolLayout );

        this.toolBar = new ToolBar ( toolWrapper, SWT.HORIZONTAL | SWT.WRAP );
        this.toolBar.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        createTime ( toolWrapper );
        createLogo ( toolWrapper );

        this.viewHolder = new Composite ( wrapper, SWT.NONE );
        this.viewHolder.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        this.viewHolder.setLayout ( this.stackLayout = new StackLayout () );
        for ( final ViewInstanceDescriptor descriptor : Activator.getDescriptors () )
        {
            addView ( descriptor );
            if ( descriptor.isDefaultInstance () )
            {
                showView ( descriptor.getId () );
            }
        }
    }

    protected ImageDescriptor getLogoDescriptor ()
    {
        final String logoUri = Activator.getDefault ().getPreferenceStore ().getString ( PreferenceConstants.P_IMG_LOGO );

        if ( logoUri != null && !logoUri.isEmpty () )
        {
            try
            {
                return ImageDescriptor.createFromURL ( new URL ( logoUri ) );
            }
            catch ( final MalformedURLException e )
            {
                return ImageDescriptor.getMissingImageDescriptor ();
            }
        }

        return Activator.findLogoDescriptor ();
    }

    private boolean hasLogo ()
    {
        return getLogoDescriptor () != null;
    }

    protected void createLogo ( final Composite parent )
    {
        final ImageDescriptor descriptor = getLogoDescriptor ();

        if ( descriptor == null )
        {
            return;
        }

        final Label label = new Label ( parent, SWT.NONE );
        this.image = this.manager.createImageWithDefault ( descriptor );
        label.setImage ( this.image );
        label.setLayoutData ( new GridData ( SWT.CENTER, SWT.CENTER, false, false ) );

        label.addMouseListener ( new MouseAdapter () {

            @Override
            public void mouseDoubleClick ( final MouseEvent e )
            {
                if ( ( e.stateMask & SWT.MOD1 ) == 0 && e.button != 3 )
                {
                    return;
                }

                if ( SingleVisualInterfaceViewPart.this.currentInstance != null )
                {
                    SingleVisualInterfaceViewPart.this.currentInstance.reload ();
                }
            }
        } );
    }

    protected boolean hasTime ()
    {
        final String connectionId = Activator.getDefault ().getPreferenceStore ().getString ( PreferenceConstants.P_TIME_CONNECTION_ID );
        final String dataItemId = Activator.getDefault ().getPreferenceStore ().getString ( PreferenceConstants.P_TIME_DATA_ITEM );

        if ( connectionId == null || dataItemId == null || connectionId.isEmpty () || dataItemId.isEmpty () )
        {
            return false;
        }
        return true;
    }

    protected void createTime ( final Composite parent )
    {
        if ( !hasTime () )
        {
            return;
        }

        final String connectionId = Activator.getDefault ().getPreferenceStore ().getString ( PreferenceConstants.P_TIME_CONNECTION_ID );
        final String dataItemId = Activator.getDefault ().getPreferenceStore ().getString ( PreferenceConstants.P_TIME_DATA_ITEM );

        this.timeLabel = new Label ( parent, SWT.NONE );
        this.timeLabel.setLayoutData ( new GridData ( SWT.CENTER, SWT.CENTER, false, false ) );

        this.dataItem = new DataItemObservableValue ( Activator.getDefault ().getBundle ().getBundleContext (), connectionId, dataItemId );
        final IObservableValue model = PojoObservables.observeDetailValue ( this.dataItem, "value", Variant.class ); //$NON-NLS-1$
        this.dbc.bindValue ( SWTObservables.observeText ( this.timeLabel ), model, null, new UpdateValueStrategy ().setConverter ( new VariantToStringConverter () ) );
        model.addValueChangeListener ( new IValueChangeListener () {

            @Override
            public void handleValueChange ( final ValueChangeEvent event )
            {
                SingleVisualInterfaceViewPart.this.timeLabel.getParent ().layout ( new Control[] { SingleVisualInterfaceViewPart.this.timeLabel } );
            }
        } );
    }

    @Override
    public void dispose ()
    {
        if ( this.dataItem != null )
        {
            this.dataItem.dispose ();
            this.dataItem = null;
        }
        super.dispose ();
        this.manager.dispose ();
    }

    private void addView ( final ViewInstanceDescriptor descriptor )
    {
        final ViewInstance instance = new ViewInstance ( this, this.viewHolder, this.toolBar, descriptor, this.manager );
        this.instances.put ( descriptor.getId (), instance );
    }

    @Override
    public void showView ( final String id )
    {
        showView ( id, false );
    }

    @Override
    public void showView ( final String id, final boolean force )
    {
        final ViewInstance instance = this.instances.get ( id );
        if ( instance == null )
        {
            return;
        }
        if ( this.currentInstance == instance && !force )
        {
            return;
        }

        if ( this.currentInstance != null )
        {
            this.currentInstance.deactivate ();
        }

        this.currentInstance = instance;
        this.currentInstance.activate ();

        this.stackLayout.topControl = this.currentInstance.getControl ();
        this.viewHolder.layout ();
    }

    @Override
    public void setFocus ()
    {
        if ( this.currentInstance != null )
        {
            this.currentInstance.setFocus ();
        }
    }

}
