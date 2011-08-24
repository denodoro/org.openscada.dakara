/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2011 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

package org.openscada.vi.ui.draw2d;

import java.util.Observable;
import java.util.Observer;

import org.openscada.core.connection.provider.ConnectionIdTracker;
import org.openscada.core.connection.provider.ConnectionService;
import org.openscada.da.client.DataItem;
import org.openscada.da.client.DataItemValue;

public class DataItemRegistration implements Observer
{
    private final RegistrationManager registrationManager;

    private final String name;

    private final ConnectionIdTracker connectionTracker;

    private org.openscada.da.connection.provider.ConnectionService connectionService;

    private final String itemId;

    private DataItem dataItem;

    public DataItemRegistration ( final RegistrationManager registrationManager, final String name, final String itemId, final String connectionId )
    {
        this.registrationManager = registrationManager;
        this.name = name;
        this.itemId = itemId;

        this.connectionTracker = new ConnectionIdTracker ( Activator.getDefault ().getBundle ().getBundleContext (), connectionId, new ConnectionIdTracker.Listener () {

            @Override
            public void setConnection ( final ConnectionService connectionService )
            {
                DataItemRegistration.this.setConnection ( connectionService );
            }
        } );
        this.connectionTracker.open ();
    }

    protected synchronized void setConnection ( final ConnectionService connectionService )
    {
        disconnect ();

        if ( connectionService instanceof org.openscada.da.connection.provider.ConnectionService )
        {
            this.connectionService = (org.openscada.da.connection.provider.ConnectionService)connectionService;
            this.dataItem = new DataItem ( this.itemId );
            this.dataItem.addObserver ( this );
            this.dataItem.register ( this.connectionService.getItemManager () );
        }
    }

    private void disconnect ()
    {
        if ( this.connectionService != null )
        {
            this.connectionService = null;
        }
        if ( this.dataItem != null )
        {
            this.dataItem.deleteObservers ();
            this.dataItem.unregister ();
            this.dataItem = null;
        }
    }

    public void dispose ()
    {
        this.connectionTracker.close ();
        disconnect ();
        notifyChange ( DataItemValue.DISCONNECTED );
    }

    public void notifyChange ( final DataItemValue value )
    {
        this.registrationManager.notifyChange ( this.name, value );
    }

    @Override
    public void update ( final Observable o, final Object arg )
    {
        if ( o == this.dataItem && arg instanceof DataItemValue )
        {
            notifyChange ( (DataItemValue)arg );
        }
    }
}
