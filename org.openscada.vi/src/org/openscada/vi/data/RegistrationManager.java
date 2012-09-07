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

package org.openscada.vi.data;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import org.openscada.core.Variant;
import org.openscada.core.connection.provider.ConnectionIdTracker;
import org.openscada.da.client.DataItemValue;
import org.openscada.da.connection.provider.ConnectionService;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.connection.data.Item.Type;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationManager
{
    private static final long SERVICE_TIMEOUT = Long.getLong ( "org.openscada.vi.data", 1000 );

    private final static Logger logger = LoggerFactory.getLogger ( RegistrationManager.class );

    public interface Listener
    {
        public void triggerDataUpdate ();
    }

    private final Set<Listener> listeners = new LinkedHashSet<RegistrationManager.Listener> ();

    private final Map<String, DataItemRegistration> registrations = new LinkedHashMap<String, DataItemRegistration> ();

    private final AtomicReference<Map<String, DataValue>> currentValues = new AtomicReference<Map<String, DataValue>> ( Collections.<String, DataValue> emptyMap () );

    private final BundleContext context;

    private boolean open;

    public RegistrationManager ( final BundleContext context )
    {
        this.context = context;
    }

    public void addListener ( final Listener listener )
    {
        this.listeners.add ( listener );
    }

    public void removeListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

    public void dispose ()
    {
        close ();
        this.registrations.clear ();
    }

    public void unregisterItem ( final String name )
    {
        final DataItemRegistration registration = this.registrations.remove ( name );
        if ( registration != null )
        {
            if ( this.open )
            {
                registration.close ();
            }
        }
    }

    public void open ()
    {
        if ( this.open )
        {
            return;
        }

        this.open = true;

        for ( final DataItemRegistration registration : this.registrations.values () )
        {
            registration.open ();
        }
    }

    public void close ()
    {
        if ( !this.open )
        {
            return;
        }

        this.open = false;

        for ( final DataItemRegistration registration : this.registrations.values () )
        {
            registration.close ();
        }
    }

    public void registerItem ( final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        if ( itemId == null )
        {
            throw new IllegalArgumentException ( String.format ( "'itemId' must not be null" ) );
        }

        notifyChange ( name, new Item ( connectionId, itemId, Type.ID ), DataItemValue.DISCONNECTED, ignoreSummary, nullInvalid );
        final DataItemRegistration newRegistration = new DataItemRegistration ( this, this.context, name, itemId, connectionId, ignoreSummary, nullInvalid );
        final DataItemRegistration oldRegistration = this.registrations.put ( name, newRegistration );
        if ( this.open )
        {
            if ( oldRegistration != null )
            {
                oldRegistration.close ();
            }

            newRegistration.open ();
        }
    }

    public void notifyChange ( final String name, final Item item, final DataItemValue value, final boolean ignoreSummary, final boolean nullInvalid )
    {
        Map<String, DataValue> currentMap;
        Map<String, DataValue> newMap;
        do
        {
            currentMap = this.currentValues.get ();
            newMap = new LinkedHashMap<String, DataValue> ( currentMap );
            newMap.put ( name, new DataValue ( value, item, ignoreSummary, nullInvalid ) );
        } while ( !this.currentValues.compareAndSet ( currentMap, newMap ) );

        for ( final Listener listener : this.listeners )
        {
            try
            {
                listener.triggerDataUpdate ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to notify", e );
            }
        }
    }

    public Map<String, DataValue> getData ()
    {
        return Collections.unmodifiableMap ( this.currentValues.get () );
    }

    public void startWrite ( final String connectionId, final String itemId, final Variant value ) throws InterruptedException
    {
        final ConnectionIdTracker connectionTracker = new ConnectionIdTracker ( this.context, connectionId, null, ConnectionService.class );
        connectionTracker.open ();
        try
        {
            final ConnectionService service = (ConnectionService)connectionTracker.waitForService ( SERVICE_TIMEOUT );
            service.getConnection ().write ( itemId, value, null, null );
        }
        finally
        {
            connectionTracker.close ();
        }
    }

    public void startWriteAttributes ( final String connectionId, final String itemId, final Map<String, Variant> attributes ) throws InterruptedException
    {
        final ConnectionIdTracker connectionTracker = new ConnectionIdTracker ( this.context, connectionId, null, ConnectionService.class );
        connectionTracker.open ();
        try
        {
            final ConnectionService service = (ConnectionService)connectionTracker.waitForService ( SERVICE_TIMEOUT );
            service.getConnection ().writeAttributes ( itemId, attributes, null, null );
        }
        finally
        {
            connectionTracker.close ();
        }
    }

    public Collection<Item> getItems ()
    {
        final Set<Item> result = new LinkedHashSet<Item> ( this.registrations.size () );

        for ( final DataItemRegistration reg : this.registrations.values () )
        {
            result.add ( reg.getItem () );
        }

        return result;
    }
}
