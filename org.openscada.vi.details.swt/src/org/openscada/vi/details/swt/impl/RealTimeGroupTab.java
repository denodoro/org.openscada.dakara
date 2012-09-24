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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.openscada.da.client.dataitem.details.dialog.DataItemDetailsDialog;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.connection.data.Item.Type;
import org.openscada.da.ui.widgets.realtime.ListEntry;
import org.openscada.da.ui.widgets.realtime.RealTimeListViewer;
import org.openscada.vi.details.model.DetailView.Visibility;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.impl.visibility.VisibilityProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RealTimeGroupTab implements GroupTab
{
    private static final Logger logger = LoggerFactory.getLogger ( RealTimeGroupTab.class );

    private RealTimeListViewer viewer;

    private Shell shell;

    private IObservableSet input;

    private final Map<Item, ListEntry> entryMap = new HashMap<Item, ListEntry> ();

    private final ISetChangeListener setListener;

    public RealTimeGroupTab ()
    {
        this.setListener = new ISetChangeListener () {

            @Override
            public void handleSetChange ( final SetChangeEvent event )
            {
                for ( final Object object : event.diff.getAdditions () )
                {
                    final DataItemDescriptor item = (DataItemDescriptor)object;
                    addItem ( item );
                }

                for ( final Object object : event.diff.getRemovals () )
                {
                    final DataItemDescriptor item = (DataItemDescriptor)object;
                    removeItem ( item );
                }
            }
        };
    }

    @Override
    public void dispose ()
    {
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
        }
        if ( this.input != null )
        {
            this.input.dispose ();
            this.input = null;
        }
    }

    @Override
    public String getLabel ()
    {
        return Messages.RealTimeGroupTab_TabLabel;
    }

    @Override
    public void init ( final VisibilityProviderFactory factory, final Composite parent, final Map<String, String> properties )
    {
        this.shell = parent.getShell ();

        this.viewer = new RealTimeListViewer ();
        this.viewer.createControl ( parent );
        this.viewer.addDoubleClickListener ( new IDoubleClickListener () {

            @Override
            public void doubleClick ( final DoubleClickEvent event )
            {
                RealTimeGroupTab.this.handleDoubleClick ( event );
            }
        } );

        if ( this.input != null )
        {
            attachInput ();
        }
    }

    private void attachInput ()
    {
        this.input.addSetChangeListener ( this.setListener );

        // load initial items
        for ( final Object object : this.input )
        {
            final DataItemDescriptor item = (DataItemDescriptor)object;
            // FIXME: why are some objects null? Fix the root cause!
            if ( item != null )
            {
                addItem ( item );
            }
            else
            {
                logger.warn ( "DataItemDescriptor was null" );
            }
        }
    }

    protected void addItem ( final DataItemDescriptor descriptor )
    {
        if ( this.viewer == null )
        {
            return;
        }

        final Item item = convertItem ( descriptor );

        if ( this.entryMap.containsKey ( item ) )
        {
            return;
        }

        final ListEntry entry = new ListEntry ();
        entry.setDataItem ( item );
        this.viewer.add ( entry );
        this.entryMap.put ( item, entry );
    }

    protected void removeItem ( final DataItemDescriptor descriptor )
    {
        if ( this.viewer == null )
        {
            return;
        }

        final Item item = convertItem ( descriptor );

        final ListEntry entry = this.entryMap.remove ( item );
        if ( entry == null )
        {
            return;
        }

        this.viewer.remove ( entry );
    }

    private void detachInput ()
    {
        if ( this.input != null )
        {
            this.input.removeSetChangeListener ( this.setListener );
        }
        this.viewer.clear ();
    }

    protected void handleDoubleClick ( final DoubleClickEvent event )
    {
        if ( event.getSelection () instanceof IStructuredSelection )
        {
            final Object o = ( (IStructuredSelection)event.getSelection () ).getFirstElement ();
            if ( o instanceof ListEntry )
            {
                final DataItemDetailsDialog dlg = new DataItemDetailsDialog ( this.shell, ( (ListEntry)o ).getItem () );
                dlg.open ();
            }
        }
    }

    /**
     * Set the new input set
     * <p>
     * The old input set will be returned but not disposed
     * </p>
     * 
     * @param input
     *            the new input set or <code>null</code> to set none
     * @return the old input set or <code>null</code> if none was present
     */
    public IObservableSet setInput ( final IObservableSet input )
    {
        final IObservableSet oldInput = this.input;

        if ( this.input != null )
        {
            detachInput ();
        }

        if ( this.viewer != null && input != null )
        {
            this.input = input;
            attachInput ();
        }

        return oldInput;
    }

    private static Item convertItem ( final DataItemDescriptor item )
    {
        return new Item ( item.getConnectionInformation ().toString (), item.getItemId (), Type.ID );
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        // we only consume the other items, not provide them again
        return Observables.emptyObservableSet ();
    }

    @Override
    public Visibility getVisibility ()
    {
        return null;
    }

    @Override
    public void start ()
    {
        // no-op
    }

    @Override
    public void stop ()
    {
        // no-op
    }
}