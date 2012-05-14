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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.openscada.vi.details.swt.data.DataItemDescriptor;

class RealTimeGroupTab implements GroupTab
{
    private RealTimeListViewer viewer;

    private final Set<Item> initItems = new HashSet<Item> ();

    private Shell shell;

    @Override
    public void dispose ()
    {
        this.viewer.dispose ();
    }

    @Override
    public String getLabel ()
    {
        return Messages.RealTimeGroupTab_TabLabel;
    }

    @Override
    public void init ( final Composite parent, final Map<String, String> properties )
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

        for ( final Item item : this.initItems )
        {
            final ListEntry entry = new ListEntry ();
            entry.setDataItem ( item );
            this.viewer.add ( entry );
        }
        this.initItems.clear ();
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

    public void addItems ( final Collection<DataItemDescriptor> items )
    {
        if ( this.viewer == null )
        {
            for ( final DataItemDescriptor item : items )
            {
                this.initItems.add ( convertItem ( item ) );
            }
        }
        else
        {
            for ( final DataItemDescriptor item : items )
            {
                final ListEntry entry = new ListEntry ();
                entry.setDataItem ( convertItem ( item ) );
                this.viewer.add ( entry );
            }
        }
    }

    private static Item convertItem ( final DataItemDescriptor item )
    {
        return new Item ( item.getConnectionInformation ().toString (), item.getItemId (), Type.ID );
    }

    @Override
    public Collection<DataItemDescriptor> getDescriptors ()
    {
        return Collections.emptyList ();
    }
}