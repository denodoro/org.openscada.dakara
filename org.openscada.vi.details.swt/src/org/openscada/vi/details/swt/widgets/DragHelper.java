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

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.openscada.core.ui.connection.login.SessionManager;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.connection.dnd.ItemTransfer;
import org.openscada.vi.details.swt.data.DataItemDescriptor;

public final class DragHelper
{
    private DragHelper ()
    {
    }

    public static void style ( final Composite parent, final Control control, final DataItemDescriptor descriptor )
    {
        final Color backgroundDefault = control.getBackground ();

        // TODO: make properties
        if ( SessionManager.getDefault ().hasRole ( "admin" ) )
        {
            if ( SessionManager.getDefault ().hasRole ( "developer" ) ) //$NON-NLS-1$
            {
                control.setToolTipText ( Messages.LabelOpenscadaDialog_descriptor + descriptor );
            }

            control.addMouseTrackListener ( new MouseTrackAdapter () {

                @Override
                public void mouseExit ( final MouseEvent event )
                {
                    // control.setForeground ( control.getDisplay ().getSystemColor ( SWT.COLOR_BLACK ) );
                    control.setBackground ( backgroundDefault );
                }

                @Override
                public void mouseEnter ( final MouseEvent event )
                {
                    // control.setForeground ( control.getDisplay ().getSystemColor ( SWT.COLOR_WHITE ) );
                    control.setBackground ( control.getDisplay ().getSystemColor ( SWT.COLOR_DARK_GRAY ) );
                }

            } );
        }

        DragHelper.addDragSupport ( control, descriptor );
    }

    public static void addDragSupport ( final Control control, final DataItemDescriptor descriptor )
    {
        final Transfer[] types = new Transfer[] { ItemTransfer.getInstance () };

        final DragSource source = new DragSource ( control, DND.DROP_LINK | DND.DROP_MOVE | DND.DROP_COPY );
        source.setTransfer ( types );
        source.addDragListener ( new DragSourceAdapter () {
            @Override
            public void dragSetData ( final DragSourceEvent event )
            {
                final Item item = new Item ( descriptor.getConnectionInformation (), descriptor.getItemId (), isUri ( descriptor.getConnectionInformation () ) ? Item.Type.URI : Item.Type.ID );
                event.data = new Item[] { item };
            }

            private boolean isUri ( final String connectionInformation )
            {
                try
                {
                    final URI uri = new URI ( connectionInformation );
                    if ( uri.getScheme () == null )
                    {
                        return false;
                    }
                    return true;
                }
                catch ( final URISyntaxException e )
                {
                    return false;
                }
            }

        } );
    }
}
