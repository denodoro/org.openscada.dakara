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

    private final AtomicReference<Map<String, DataItemValue>> currentValues = new AtomicReference<Map<String, DataItemValue>> ( Collections.<String, DataItemValue> emptyMap () );

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

    public void registerItem ( final String name, final String itemId, final String connectionId )
    {
        notifyChange ( name, DataItemValue.DISCONNECTED );
        final DataItemRegistration oldRegistration = this.registrations.put ( name, new DataItemRegistration ( this, name, itemId, connectionId ) );
        if ( oldRegistration != null )
        {
            oldRegistration.dispose ();
        }
    }

    public void notifyChange ( final String name, final DataItemValue value )
    {
        Map<String, DataItemValue> currentMap;
        Map<String, DataItemValue> newMap;
        do
        {
            currentMap = this.currentValues.get ();
            newMap = new LinkedHashMap<String, DataItemValue> ( currentMap );
            newMap.put ( name, value );
        } while ( !this.currentValues.compareAndSet ( currentMap, newMap ) );

        this.controller.triggerDataUpdate ();
    }

    public Map<String, DataItemValue> getData ()
    {
        return this.currentValues.get ();
    }
}
