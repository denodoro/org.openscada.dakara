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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.UnionSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.openscada.core.ui.connection.login.SessionManager;
import org.openscada.vi.details.model.DetailView.AndTransformer;
import org.openscada.vi.details.model.DetailView.BoolLEDComponent;
import org.openscada.vi.details.model.DetailView.ButtonComponent;
import org.openscada.vi.details.model.DetailView.CheckComponent;
import org.openscada.vi.details.model.DetailView.Component;
import org.openscada.vi.details.model.DetailView.CompositeTransformer;
import org.openscada.vi.details.model.DetailView.FillLayoutComponent;
import org.openscada.vi.details.model.DetailView.GroupGridComponent;
import org.openscada.vi.details.model.DetailView.GroupGridEntry;
import org.openscada.vi.details.model.DetailView.HiddenComponent;
import org.openscada.vi.details.model.DetailView.ItemValueSource;
import org.openscada.vi.details.model.DetailView.LabelComponent;
import org.openscada.vi.details.model.DetailView.LinkComponent;
import org.openscada.vi.details.model.DetailView.NotTransformer;
import org.openscada.vi.details.model.DetailView.OrTransformer;
import org.openscada.vi.details.model.DetailView.ProgressComponent;
import org.openscada.vi.details.model.DetailView.SimpleGridComponent;
import org.openscada.vi.details.model.DetailView.TextComponent;
import org.openscada.vi.details.model.DetailView.TextInputComponent;
import org.openscada.vi.details.model.DetailView.TextInputMultiComponent;
import org.openscada.vi.details.model.DetailView.URLImageComponent;
import org.openscada.vi.details.model.DetailView.ValueComponent;
import org.openscada.vi.details.model.DetailView.ValueSetComponent;
import org.openscada.vi.details.model.DetailView.ValueSource;
import org.openscada.vi.details.swt.DetailComponent;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.impl.visibility.ComponentVisibility;
import org.openscada.vi.details.swt.impl.visibility.SubTrackingVisibleComponent;
import org.openscada.vi.details.swt.impl.visibility.TrackingVisibleComponent;
import org.openscada.vi.details.swt.impl.visibility.VisibilityProvider;
import org.openscada.vi.details.swt.impl.visibility.VisibilityProviderFactory;
import org.openscada.vi.details.swt.source.ItemValueSourceController;
import org.openscada.vi.details.swt.source.NotEvaluatorController;
import org.openscada.vi.details.swt.source.ValueSourceController;
import org.openscada.vi.details.swt.widgets.BoolLEDComposite;
import org.openscada.vi.details.swt.widgets.ButtonComposite;
import org.openscada.vi.details.swt.widgets.CheckComposite;
import org.openscada.vi.details.swt.widgets.LabelComposite;
import org.openscada.vi.details.swt.widgets.LinkComposite;
import org.openscada.vi.details.swt.widgets.ProgressComposite;
import org.openscada.vi.details.swt.widgets.TextComposite;
import org.openscada.vi.details.swt.widgets.TextInputComposite;
import org.openscada.vi.details.swt.widgets.TextInputMultiComposite;
import org.openscada.vi.details.swt.widgets.URLImageLabel;
import org.openscada.vi.details.swt.widgets.ValueComposite;
import org.openscada.vi.details.swt.widgets.ValueSetComposite;

public class DetailComponentImpl implements DetailComponent
{
    private final Component component;

    private final List<ComponentVisibility> visibilites = new LinkedList<ComponentVisibility> ();

    private VisibilityProviderFactory visibleFactory;

    private final WritableSet descriptors = new WritableSet ();

    public DetailComponentImpl ( final Component component )
    {
        this.component = component;
    }

    @Override
    public void dispose ()
    {
        for ( final ComponentVisibility visibility : this.visibilites )
        {
            visibility.dispose ();
        }
    }

    @Override
    public void start ()
    {
        for ( final ComponentVisibility visibility : this.visibilites )
        {
            visibility.start ();
        }
    }

    @Override
    public void stop ()
    {
        for ( final ComponentVisibility visibility : this.visibilites )
        {
            visibility.stop ();
        }
    }

    /**
     * Returns a list of descriptors used by this and all sub components
     * 
     * @return the list of descriptors. It never returns <code>null</code>.
     */
    @Override
    public IObservableSet getDescriptors ()
    {
        final List<IObservableSet> lists = new LinkedList<IObservableSet> ();

        lists.add ( this.descriptors );

        for ( final ComponentVisibility visibility : this.visibilites )
        {
            lists.add ( visibility.getDescriptors () );
        }

        return new UnionSet ( lists.toArray ( new IObservableSet[lists.size ()] ) );
    }

    private void addDescriptor ( final DataItemDescriptor descriptor )
    {
        if ( descriptor != null )
        {
            this.descriptors.add ( descriptor );
        }
    }

    @Override
    public void init ( final VisibilityProviderFactory visibleFactory, final Composite parent, final Map<String, String> properties )
    {
        this.visibleFactory = visibleFactory;

        // create widgets
        if ( this.component instanceof LabelComponent )
        {
            createLabel ( parent, (LabelComponent)this.component, properties );
        }
        else if ( this.component instanceof FillLayoutComponent )
        {
            createFillLayout ( parent, (FillLayoutComponent)this.component, properties );
        }
        else if ( this.component instanceof SimpleGridComponent )
        {
            createSimpleGrid ( parent, (SimpleGridComponent)this.component, properties );
        }
        else if ( this.component instanceof GroupGridComponent )
        {
            createGroupGrid ( parent, (GroupGridComponent)this.component, properties );
        }
        else if ( this.component instanceof ButtonComponent )
        {
            createButton ( parent, (ButtonComponent)this.component, properties );
        }
        else if ( this.component instanceof BoolLEDComponent )
        {
            createBoolLED ( parent, (BoolLEDComponent)this.component, properties );
        }
        else if ( this.component instanceof ValueSetComponent )
        {
            createValueSet ( parent, (ValueSetComponent)this.component, properties );
        }
        else if ( this.component instanceof ValueComponent )
        {
            createValue ( parent, (ValueComponent)this.component, properties );
        }
        else if ( this.component instanceof TextComponent )
        {
            createText ( parent, (TextComponent)this.component, properties );
        }
        else if ( this.component instanceof TextInputComponent )
        {
            createTextInput ( parent, (TextInputComponent)this.component, properties );
        }
        else if ( this.component instanceof TextInputMultiComponent )
        {
            createTextInputMulti ( parent, (TextInputMultiComponent)this.component, properties );
        }
        else if ( this.component instanceof CheckComponent )
        {
            createCheck ( parent, (CheckComponent)this.component, properties );
        }
        else if ( this.component instanceof LinkComponent )
        {
            createLink ( parent, (LinkComponent)this.component, properties );
        }
        else if ( this.component instanceof ProgressComponent )
        {
            createProgress ( parent, (ProgressComponent)this.component, properties );
        }
        else if ( this.component instanceof URLImageComponent )
        {
            createURLImage ( parent, (URLImageComponent)this.component, properties );
        }
        else if ( this.component instanceof HiddenComponent )
        {
            createHidden ( (HiddenComponent)this.component, properties );
        }
    }

    private void createHidden ( final HiddenComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor descriptor = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        addDescriptor ( descriptor );
    }

    private void createURLImage ( final Composite parent, final URLImageComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor descriptor = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final Composite image = new URLImageLabel ( parent, SWT.NONE, descriptor, component );

                trackControl ( image );
                trackItem ( descriptor );
            }

        } );

        addComponent ( visibility );
    }

    private void createProgress ( final Composite parent, final ProgressComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor progressItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ProgressComposite progress = new ProgressComposite ( parent, SWT.NONE, progressItem, resolve ( component.getFormat (), properties ), component.getDecimal (), component.getAttribute (), component.getMax (), component.getMin (), component.getFactor (), component.getWidth (), component.getHdConnectionid (), resolve ( component.getHdItemId (), properties ) );

                trackControl ( progress );
                trackItem ( progressItem );
            }

        } );

        addComponent ( visibility );
    }

    private void createLink ( final Composite parent, final LinkComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final LinkComposite link = new LinkComposite ( parent, SWT.NONE, resolve ( component.getFormat (), properties ) );
                trackControl ( link );
            }

        } );

        addComponent ( visibility );
    }

    private void createCheck ( final Composite parent, final CheckComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor descriptor = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );
        final DataItemDescriptor readDescriptor = DataItemDescriptor.create ( resolve ( component.getReadDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final CheckComposite check = new CheckComposite ( parent, SWT.NONE, descriptor, resolve ( component.getFormat (), properties ), component.getAttribute (), readDescriptor );

                trackControl ( check );
                trackItem ( descriptor );
                trackItem ( readDescriptor );
            }
        } );

        addComponent ( visibility );
    }

    private void createText ( final Composite parent, final TextComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor textItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final TextComposite text = new TextComposite ( parent, SWT.NONE, textItem, resolve ( component.getFormat (), properties ), component.getDecimal (), component.getAttribute (), component.getWidth (), component.getHeight (), component.isDate (), component.getTextHeight (), component.getTextMap (), component.getHdConnectionid (), component.getHdItemId () );

                trackControl ( text );
                trackItem ( textItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createTextInput ( final Composite parent, final TextInputComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor textInputItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );
        final DataItemDescriptor readItem = DataItemDescriptor.create ( resolve ( component.getReadDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final TextInputComposite valueSet = new TextInputComposite ( parent, SWT.NONE, textInputItem, resolve ( component.getFormat (), properties ), component.getCeil (), component.getFloor (), component.getDecimal (), component.getAttribute (), readItem, component.getHdConnectionid (), resolve ( component.getHdItemId (), properties ), component.getWidth ()  );

                trackControl ( valueSet );
                trackItem ( textInputItem );
                trackItem ( readItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createTextInputMulti ( final Composite parent, final TextInputMultiComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor textInputItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final TextInputMultiComposite text = new TextInputMultiComposite ( parent, SWT.NONE, textInputItem, resolve ( component.getFormat (), properties ), component.getAttribute (), component.getHdConnectionid (), resolve ( component.getHdItemId (), properties ) );

                trackControl ( text );
                trackItem ( textInputItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createValue ( final Composite parent, final ValueComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor item = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ValueComposite value = new ValueComposite ( parent, SWT.NONE, item, resolve ( component.getFormat (), properties ), component.getDecimal (), component.getAttribute (), component.getDate (), component.getHdConnectionid (), resolve ( component.getHdItemId (), properties ) );

                trackControl ( value );
                trackItem ( item );
            }
        } );

        addComponent ( visibility );
    }

    private void createValueSet ( final Composite parent, final ValueSetComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor valueItem = DataItemDescriptor.create ( resolve ( component.getValueDescriptor (), properties ) );
        final DataItemDescriptor setItem = DataItemDescriptor.create ( resolve ( component.getSetDescriptor (), properties ) );
        final DataItemDescriptor resetItem = DataItemDescriptor.create ( resolve ( component.getResetDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ValueSetComposite valueSet = new ValueSetComposite ( parent, SWT.NONE, valueItem, setItem, resetItem, resolve ( component.getFormat (), properties ), component.getCeil (), component.getFloor (), component.getDecimal (), component.getAttribute (), component.getHdConnectionid (), resolve ( component.getHdItemId (), properties ) );

                trackControl ( valueSet );
                trackItem ( valueItem );
                trackItem ( setItem );
                trackItem ( resetItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createGroupGrid ( final Composite parent, final GroupGridComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {

                final Composite childParent = new Composite ( parent, SWT.NONE );
                childParent.setLayout ( new GridLayout ( component.getCols (), component.isEqually () ) );

                for ( final GroupGridEntry groupEntry : component.getGroups () )
                {
                    if ( groupEntry.getPermission () == null )
                    {
                        // there are no special user rights available, so just show the TAB
                        createGroupGridEntry ( properties, childParent, groupEntry );
                    }
                    else if ( SessionManager.getDefault ().hasRole ( groupEntry.getPermission () ) )
                    {
                        createGroupGridEntry ( properties, childParent, groupEntry );
                    }
                }
                trackControl ( childParent );
            }
        } );

        addComponent ( visibility );
    }

    private void createGroupGridEntry ( final Map<String, String> properties, final Composite childParent, final GroupGridEntry groupEntry )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( groupEntry.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new SubTrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final Group groupWidget = new Group ( childParent, SWT.NONE );

                groupWidget.setLayout ( new GridLayout ( 1, false ) );
                groupWidget.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );

                final String label = groupEntry.getLabel ();
                if ( label != null )
                {
                    groupWidget.setText ( label );
                }

                for ( final Component child : groupEntry.getComponents () )
                {
                    final DetailComponentImpl comp = new DetailComponentImpl ( child );

                    final Composite wrapper = new Composite ( groupWidget, SWT.NONE );
                    wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
                    wrapper.setLayout ( new FillLayout () );

                    comp.init ( DetailComponentImpl.this.visibleFactory, wrapper, properties );

                    trackSub ( comp );
                }

                trackControl ( groupWidget );
            }
        } );

        addComponent ( visibility );
    }

    private void createSimpleGrid ( final Composite parent, final SimpleGridComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new SubTrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final Composite childParent = new Composite ( parent, SWT.NONE );
                childParent.setLayout ( new GridLayout ( component.getCols (), component.isEqually () ) );

                for ( final Component child : component.getChildren () )
                {
                    final DetailComponentImpl comp = new DetailComponentImpl ( child );
                    trackSub ( comp );

                    final Composite wrapper = new Composite ( childParent, SWT.NONE );
                    wrapper.setLayout ( new FillLayout () );
                    wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
                    comp.init ( DetailComponentImpl.this.visibleFactory, wrapper, properties );
                }

                trackControl ( childParent );
            }
        } );

        addComponent ( visibility );
    }

    private void createBoolLED ( final Composite parent, final BoolLEDComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor item = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final BoolLEDComposite led = new BoolLEDComposite ( parent, SWT.NONE, item, resolve ( component.getFormat (), properties ), component.isExpectedValue(), component.isAlarm (), component.getAttribute () );

                trackControl ( led );
                trackItem ( item );
            }
        } );

        addComponent ( visibility );
    }

    private void createButton ( final Composite parent, final ButtonComponent component, final Map<String, String> properties )
    {
        final String readDescriptor = component.getReadDescriptor ();
        final DataItemDescriptor readItem;
        if ( readDescriptor != null && !readDescriptor.equals ( "" ) ) //$NON-NLS-1$
        {
            readItem = DataItemDescriptor.create ( resolve ( component.getReadDescriptor (), properties ) );
        }
        else
        {
            readItem = null;
        }

        final DataItemDescriptor writeItem = DataItemDescriptor.create ( resolve ( component.getWriteDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ButtonComposite button = new ButtonComposite ( parent, SWT.NONE, readItem, writeItem, resolve ( component.getFormat (), properties ), resolve ( component.getValue (), properties ), createValueSource ( component.getActive (), properties ), component.getRegistrations (), properties, component.getAttribute (), component.getTextHeight () );

                trackControl ( button );
                trackItem ( writeItem );
                trackItem ( readItem );
            }
        } );

        addComponent ( visibility );
    }

    private static ValueSourceController createValueSource ( final ValueSource valueSource, final Map<String, String> properties )
    {
        if ( valueSource instanceof NotTransformer )
        {
            return new NotEvaluatorController ( createValueSource ( ( (NotTransformer)valueSource ).getValue (), properties ) );
        }
        else if ( valueSource instanceof AndTransformer )
        {
            return new AndTransformerController ( createValueSources ( ( (CompositeTransformer)valueSource ).getValues (), properties ) );
        }
        else if ( valueSource instanceof OrTransformer )
        {
            return new OrTransformerController ( createValueSources ( ( (CompositeTransformer)valueSource ).getValues (), properties ) );
        }
        else if ( valueSource instanceof ItemValueSource )
        {
            final ItemValueSource itemSource = (ItemValueSource)valueSource;
            return new ItemValueSourceController ( resolve ( itemSource.getValueKey (), properties ) );
        }
        else
        {
            return null;
        }
    }

    private static List<ValueSourceController> createValueSources ( final List<ValueSource> values, final Map<String, String> properties )
    {
        final List<ValueSourceController> result = new LinkedList<ValueSourceController> ();

        for ( final ValueSource source : values )
        {
            result.add ( createValueSource ( source, properties ) );
        }

        return result;
    }

    private void createFillLayout ( final Composite parent, final FillLayoutComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new SubTrackingVisibleComponent () {

            @Override
            public void create ()
            {

                final Composite childParent = new Composite ( parent, SWT.NONE );
                childParent.setLayout ( new FillLayout ( SWT.VERTICAL ) );

                for ( final Component child : component.getChildren () )
                {
                    final DetailComponentImpl comp = new DetailComponentImpl ( child );
                    comp.init ( DetailComponentImpl.this.visibleFactory, childParent, properties );
                    trackSub ( comp );
                }
                trackControl ( childParent );
            }

        } );

        addComponent ( visibility );
    }

    private void createLabel ( final Composite parent, final LabelComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor item = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final LabelComposite label = new LabelComposite ( parent, SWT.NONE, item, resolve ( component.getFormat (), properties ) );
                trackControl ( label );
                trackItem ( item );
            }

        } );

        addComponent ( visibility );
    }

    public static String resolve ( final String input, final Map<String, String> properties )
    {
        final StringTemplate template = new StringTemplate ( input );
        template.setAttributes ( properties );
        return template.toString ();
    }

    private void addComponent ( final ComponentVisibility visibility )
    {
        this.visibilites.add ( visibility );
    }

}
