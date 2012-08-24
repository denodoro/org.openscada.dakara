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

package org.openscada.vi.details.swt.data;

import java.util.Observable;
import java.util.Observer;

import org.openscada.core.connection.provider.ConnectionIdTracker;
import org.openscada.core.connection.provider.ConnectionTracker;
import org.openscada.core.connection.provider.ConnectionTracker.Listener;
import org.openscada.da.client.DataItem;
import org.openscada.da.client.DataItemValue;
import org.openscada.da.connection.provider.ConnectionService;
import org.openscada.vi.details.swt.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemRegistration
{

    private static final Logger logger = LoggerFactory.getLogger ( ItemRegistration.class );

    private final Object key;

    private final ItemListener listener;

    private final ConnectionTracker tracker;

    private DataItem item;

    private DataItemValue currentValue;

    private final DataItemDescriptor itemDescriptor;

    public ItemRegistration ( final Object key, final DataItemDescriptor itemDescriptor, final ItemListener listener )
    {
        this.key = key;
        this.listener = listener;
        this.itemDescriptor = itemDescriptor;

        this.tracker = new ConnectionIdTracker ( Activator.getDefault ().getBundle ().getBundleContext (), itemDescriptor.getConnectionInformation (), new Listener () {

            @Override
            public void setConnection ( final org.openscada.core.connection.provider.ConnectionService connectionService )
            {
                ItemRegistration.this.handleSetConnection ( (ConnectionService)connectionService );
            }
        } );
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }

    protected void handleSetConnection ( final ConnectionService connectionService )
    {
        logger.info ( "Connection Set: {}", connectionService ); //$NON-NLS-1$

        if ( connectionService != null )
        {
            attach ( connectionService );
        }
        else
        {
            detach ();
        }

    }

    private void detach ()
    {
        if ( this.item != null )
        {
            this.item.unregister ();
            this.item = null;
            fireUpdate ( null );
        }
    }

    private void attach ( final ConnectionService connectionService )
    {
        detach ();

        this.item = new DataItem ( this.itemDescriptor.getItemId () );
        this.item.addObserver ( new Observer () {

            @Override
            public void update ( final Observable o, final Object arg )
            {
                ItemRegistration.this.handleUpdate ( (DataItemValue)arg );
            }
        } );
        this.item.register ( connectionService.getItemManager () );
    }

    protected void handleUpdate ( final DataItemValue value )
    {
        this.currentValue = value;
        fireUpdate ( value );
    }

    private void fireUpdate ( final DataItemValue value )
    {
        if ( this.listener != null )
        {
            try
            {
                this.listener.dataItemUpdate ( this.key, value );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to fire update", e ); //$NON-NLS-1$
            }
        }
    }

    public DataItemValue getCurrentValue ()
    {
        return this.currentValue;
    }
}