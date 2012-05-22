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

import java.util.Map;

import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;

/**
 * Holds the data of the registered items for one symbol
 * <p>
 * All items that are registered for one symbol will provide the data to the symbols SymbolData instance. The information can be accessed by calling methods like {@link #getPrimaryValue(String)} or
 * {@link #getValue(String)}.
 * </p>
 * <p>
 * If the item was registered using {@link SymbolContext#registerItem(String, String, String, boolean, boolean)} with
 * <q>ignoreSummary</q> set to <code>true</code> then the value of this dataitem will not be considered for the summary state.
 * </p>
 * 
 * @author Jens Reimann
 * @since 0.17.0
 */
public class SymbolData
{
    private final SymbolController controller;

    public SymbolData ( final SymbolController symbolController )
    {
        this.controller = symbolController;
    }

    public Map<String, DataItemValue> getValues ()
    {
        return this.controller.getData ();
    }

    public DataItemValue getValue ( final String name )
    {
        return this.controller.getData ().get ( name );
    }

    public Variant getPrimaryValue ( final String name )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return Variant.NULL;
        }
        else
        {
            return div.getValue ();
        }
    }

    public boolean isError ( final String name )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return true;
        }
        else
        {
            if ( !div.isConnected () || div.isError () )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean isAlarm ( final String name )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isAlarm ();
        }
    }

    public boolean isManual ( final String name )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isManual ();
        }
    }

    public boolean isBlocked ( final String name )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isBlocked ();
        }
    }

    public boolean isAckRequired ( final String name )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            return div.isAttribute ( "ackRequired", false );
        }
    }

    public boolean isValid ( final String name )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return false;
        }
        else
        {
            if ( !div.isConnected () || div.isError () || div.getValue () == null || div.getValue ().isNull () )
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean isAttributeWithDefault ( final String name, final String attributeName, final boolean defaultValue )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return defaultValue;
        }
        else
        {
            final Variant attr = div.getAttributes ().get ( attributeName );
            if ( attr == null || attr.isNull () )
            {
                return defaultValue;
            }
            else
            {
                return attr.asBoolean ();
            }
        }
    }

    public Variant getAttributeValue ( final String name, final String attributeName )
    {
        final DataItemValue div = this.controller.getData ().get ( name );
        if ( div == null )
        {
            return Variant.NULL;
        }
        else
        {
            final Variant attr = div.getAttributes ().get ( attributeName );
            if ( attr == null )
            {
                return Variant.NULL;
            }
            else
            {
                return attr;
            }
        }
    }

    public SummaryInformation getSummary ()
    {
        return this.controller.getSummaryInformation ();
    }

}
