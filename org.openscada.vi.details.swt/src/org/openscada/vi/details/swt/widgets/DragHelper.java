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

package org.openscada.vi.details.swt.widgets;

import java.util.Collection;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.connection.dnd.ItemTransfer;
import org.openscada.vi.data.RegistrationManager;

public final class DragHelper
{
    private DragHelper ()
    {
    }

    protected static void setItemUriData ( final DragSourceEvent event, final Collection<Item> items )
    {
        final StringBuilder sb = new StringBuilder ();
        int cnt = 0;
        for ( final Item item : items )
        {
            if ( cnt > 0 )
            {
                sb.append ( "\n" ); //$NON-NLS-1$
            }

            sb.append ( item.getConnectionString () );
            sb.append ( "#" ); //$NON-NLS-1$
            sb.append ( item.getId () );

            cnt++;
        }
        event.data = sb.toString ();
    }

    public static void addDragSupport ( final Control control, final RegistrationManager registrationManager )
    {
        final Transfer[] types = new Transfer[] { ItemTransfer.getInstance (), TextTransfer.getInstance () };

        final DragSource source = new DragSource ( control, DND.DROP_LINK | DND.DROP_MOVE | DND.DROP_COPY );
        source.setTransfer ( types );
        source.addDragListener ( new DragSourceAdapter () {

            @Override
            public void dragStart ( final DragSourceEvent event )
            {
                if ( registrationManager.getItems ().isEmpty () )
                {
                    event.doit = false;
                }
            };

            @Override
            public void dragSetData ( final DragSourceEvent event )
            {
                final Collection<Item> items = registrationManager.getItems ();
                if ( ItemTransfer.getInstance ().isSupportedType ( event.dataType ) )
                {
                    event.data = items.toArray ( new Item[items.size ()] );
                }
                else if ( TextTransfer.getInstance ().isSupportedType ( event.dataType ) )
                {
                    setItemUriData ( event, items );
                }
            }
        } );
    }
}
