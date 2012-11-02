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
package org.openscada.vi.ui.viewer.ext.item;

import java.util.Hashtable;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.openscada.core.Variant;
import org.openscada.ui.databinding.VariantToStringConverter;
import org.openscada.ui.databinding.item.DataItemObservableValue;
import org.openscada.vi.ui.user.viewer.ViewManager;
import org.openscada.vi.ui.user.viewer.ext.ViewerExtension;
import org.openscada.vi.ui.viewer.ext.Activator;

public class ItemExtension implements ViewerExtension, IExecutableExtension
{

    public static class DataItemLabel
    {
        private final CLabel label;

        private final DataItemObservableValue dataItem;

        private final DataBindingContext dbc;

        private final IObservableValue model;

        public DataItemLabel ( final Composite composite, final String connectionId, final String itemId )
        {
            this.label = new CLabel ( composite, SWT.NONE );
            this.dataItem = new DataItemObservableValue ( Activator.getDefault ().getBundle ().getBundleContext (), connectionId, itemId );
            this.label.addDisposeListener ( new DisposeListener () {

                @Override
                public void widgetDisposed ( final DisposeEvent e )
                {
                    handleDispose ();
                }
            } );
            this.model = PojoObservables.observeDetailValue ( this.dataItem, "value", Variant.class ); //$NON-NLS-1$
            this.dbc = new DataBindingContext ();
            this.dbc.bindValue ( SWTObservables.observeText ( this.label ), this.model, null, new UpdateValueStrategy ().setConverter ( new VariantToStringConverter () ) );
            this.model.addValueChangeListener ( new IValueChangeListener () {

                @Override
                public void handleValueChange ( final ValueChangeEvent event )
                {
                    if ( !DataItemLabel.this.label.isDisposed () )
                    {
                        DataItemLabel.this.label.getParent ().layout ();
                    }
                }
            } );
        }

        protected void handleDispose ()
        {
            this.dbc.dispose ();
            this.model.dispose ();
            this.dataItem.dispose ();
        }

        public Control getControl ()
        {
            return this.label;
        }
    }

    private String connectionId;

    private String itemId;

    @Override
    public Control create ( final Composite composite, final ViewManager viewManager, final boolean horizontal )
    {
        return new DataItemLabel ( composite, this.connectionId, this.itemId ).getControl ();
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {

        if ( data instanceof String )
        {
            final String str = (String)data;
            if ( str.contains ( "#" ) )
            {
                final String[] tok = str.split ( "\\#", 2 );
                this.connectionId = tok[0];
                this.itemId = tok[1];
            }
        }
        if ( data instanceof Hashtable<?, ?> )
        {
            final Hashtable<?, ?> props = (Hashtable<?, ?>)data;

            this.connectionId = "" + props.get ( "connectionId" );
            this.itemId = "" + props.get ( "itemId" );
        }

    }
}
