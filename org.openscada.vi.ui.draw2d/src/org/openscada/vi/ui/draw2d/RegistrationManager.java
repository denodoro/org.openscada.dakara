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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.openscada.da.client.DataItemValue;

public class RegistrationManager
{
    private final SymbolController controller;

    private final Map<String, DataItemRegistration> registrations = new LinkedHashMap<String, DataItemRegistration> ();

    private final AtomicReference<Map<String, DataValue>> currentValues = new AtomicReference<Map<String, DataValue>> ( Collections.<String, DataValue> emptyMap () );

    public RegistrationManager ( final SymbolController symbolController )
    {
        this.controller = symbolController;
    }

    public void dispose ()
    {
        for ( final DataItemRegistration registration : this.registrations.values () )
        {
            registration.dispose ();
        }
        this.registrations.clear ();
    }

    public void unregisterItem ( final String name )
    {
        final DataItemRegistration registration = this.registrations.remove ( name );
        if ( registration != null )
        {
            registration.dispose ();
        }
    }

    public void registerItem ( final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        if ( itemId == null )
        {
            throw new IllegalArgumentException ( String.format ( "'itemId' must not be null" ) );
        }

        notifyChange ( name, DataItemValue.DISCONNECTED, ignoreSummary, nullInvalid );
        final DataItemRegistration oldRegistration = this.registrations.put ( name, new DataItemRegistration ( this, name, itemId, connectionId, ignoreSummary, nullInvalid ) );
        if ( oldRegistration != null )
        {
            oldRegistration.dispose ();
        }
    }

    public void notifyChange ( final String name, final DataItemValue value, final boolean ignoreSummary, final boolean nullInvalid )
    {
        Map<String, DataValue> currentMap;
        Map<String, DataValue> newMap;
        do
        {
            currentMap = this.currentValues.get ();
            newMap = new LinkedHashMap<String, DataValue> ( currentMap );
            newMap.put ( name, new DataValue ( value, ignoreSummary, nullInvalid ) );
        } while ( !this.currentValues.compareAndSet ( currentMap, newMap ) );

        this.controller.triggerDataUpdate ();
    }

    public Map<String, DataValue> getData ()
    {
        return Collections.unmodifiableMap ( this.currentValues.get () );
    }
}
