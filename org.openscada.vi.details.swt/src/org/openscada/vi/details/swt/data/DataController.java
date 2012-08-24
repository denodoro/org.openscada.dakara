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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Display;
import org.openscada.core.Variant;
import org.openscada.core.connection.provider.ConnectionIdTracker;
import org.openscada.core.connection.provider.ConnectionTracker;
import org.openscada.da.client.DataItemValue;
import org.openscada.da.connection.provider.ConnectionService;
import org.openscada.vi.details.swt.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataController
{
    private static final Logger logger = LoggerFactory.getLogger ( DataController.class );

    private final Map<Object, SCADAAttributes> attributeMap = new HashMap<Object, SCADAAttributes> ();

    private final Map<Object, ItemRegistration> items = new HashMap<Object, ItemRegistration> ();

    private final Map<Object, DataItemValue> valueCache = new HashMap<Object, DataItemValue> ();

    private SCADAAttributes aggregatedState;

    private final ControllerListener listener;

    private boolean started = false;

    public DataController ( final ControllerListener listener )
    {
        this.listener = listener;
    }

    public void registerItem ( final Object key, final DataItemDescriptor item, final boolean aggregateState )
    {
        logger.info ( "Registering: {} -> {}", new Object[] { key, item } ); //$NON-NLS-1$

        final ItemRegistration newItem = new ItemRegistration ( key, item, new ItemListener () {

            @Override
            public void dataItemUpdate ( final Object key, final DataItemValue value )
            {
                DataController.this.handleDataItemUpdate ( key, value, aggregateState );
            }
        } );

        final ItemRegistration oldItem = this.items.put ( key, newItem );
        if ( oldItem != null )
        {
            logger.warn ( "Duplicate registration of {}. Disposing old entry", new Object[] { key } ); //$NON-NLS-1$
            oldItem.close ();
        }

        if ( this.started )
        {
            newItem.open ();
        }
    }

    public void start ()
    {
        if ( this.started )
        {
            return;
        }

        this.started = true;

        for ( final ItemRegistration item : this.items.values () )
        {
            item.open ();
        }
    }

    public void stop ()
    {
        if ( !this.started )
        {
            return;
        }

        this.started = false;

        for ( final ItemRegistration item : this.items.values () )
        {
            item.close ();
        }
    }

    protected void handleDataItemUpdate ( final Object key, final DataItemValue value, final boolean aggregateState )
    {
        if ( aggregateState )
        {
            // update state only if the item requests us to
            final SCADAAttributes attributes = new SCADAAttributes ( value );
            this.attributeMap.put ( key, attributes );
            aggregate ();
        }

        // add the value to the cache for complete transmission to the listener
        this.valueCache.put ( key, value );

        // forward the event to all others : use a clone
        update ( key, new HashMap<Object, DataItemValue> ( this.valueCache ), this.aggregatedState );
    }

    protected void update ( final Object key, final Map<Object, DataItemValue> values, final SCADAAttributes state )
    {
        Display.getDefault ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                DataController.this.listener.updateView ( key, values, state );
            }
        } );
    }

    private void aggregate ()
    {
        this.aggregatedState = SCADAAttributes.aggregate ( this.attributeMap.values () );
    }

    public DataItemValue getCurrentItemValue ( final Object key )
    {
        final ItemRegistration item = this.items.get ( key );
        if ( item != null )
        {
            return item.getCurrentValue ();
        }
        else
        {
            return null;
        }
    }

    public Variant getItemAttribute ( final Object key, final String attributeName )
    {
        final DataItemValue value = getCurrentItemValue ( key );
        if ( value == null )
        {
            return Variant.NULL;
        }
        else
        {
            return value.getAttributes ().get ( attributeName );
        }
    }

    public Variant getItemValue ( final Object key )
    {
        final DataItemValue value = getCurrentItemValue ( key );
        if ( value == null )
        {
            return Variant.NULL;
        }
        else
        {
            return value.getValue ();
        }
    }

    protected void unregisterAll ()
    {
        for ( final ItemRegistration item : this.items.values () )
        {
            item.close ();
        }
        this.items.clear ();
    }

    public void akn ( final DataItemDescriptor descriptor, final Date timestamp )
    {
        akn ( descriptor.getConnectionInformation (), descriptor.getItemId (), timestamp );
    }

    public void akn ( final String serviceId, final String source, final Date timestamp )
    {
        final ConnectionTracker tracker = new ConnectionIdTracker ( Activator.getDefault ().getBundle ().getBundleContext (), serviceId, null );

        try
        {
            tracker.open ();
            tracker.waitForService ( 100 );

            ( (org.openscada.ae.connection.provider.ConnectionService)tracker.getService () ).getConnection ().acknowledge ( source, timestamp );
        }
        catch ( final InterruptedException e )
        {
            logger.warn ( "Failed to write", e ); //$NON-NLS-1$
        }
        finally
        {
            tracker.close ();
        }
    }

    /**
     * Write value only
     * 
     * @param value
     *            the value to write
     * @param descriptor
     *            the item descriptor to which it will write
     * @param descriptor
     */
    public void writeOperation ( final Variant value, final DataItemDescriptor descriptor )
    {
        writeOperation ( value, null, descriptor );
    }

    public void writeOperation ( final Map<String, Variant> attributes, final DataItemDescriptor descriptor )
    {
        writeOperation ( null, attributes, descriptor );
    }

    /**
     * Write value and/or attributes
     * 
     * @param value
     *            the value to write or <code>null</code> if no value should be written
     * @param attributes
     *            the attributes to write or <code>null</code> if no attributes should be written
     * @param descriptor
     *            the item descriptor to which it will write
     */
    public void writeOperation ( final Variant value, final Map<String, Variant> attributes, final DataItemDescriptor descriptor )
    {
        final ConnectionTracker tracker = new ConnectionIdTracker ( Activator.getDefault ().getBundle ().getBundleContext (), descriptor.getConnectionInformation (), null );

        try
        {
            tracker.open ();
            tracker.waitForService ( 100 );

            if ( value != null )
            {
                ( (ConnectionService)tracker.getService () ).getConnection ().write ( descriptor.getItemId (), value, null );
            }
            if ( attributes != null )
            {
                ( (ConnectionService)tracker.getService () ).getConnection ().writeAttributes ( descriptor.getItemId (), attributes, null );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to write", e ); //$NON-NLS-1$
        }
        finally
        {
            tracker.close ();
        }
    }

    protected SCADAAttributes getAggregatedState ()
    {
        return this.aggregatedState;
    }

    public void dispose ()
    {
        unregisterAll ();
    }

}
