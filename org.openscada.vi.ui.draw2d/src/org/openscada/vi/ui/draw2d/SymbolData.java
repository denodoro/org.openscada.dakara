package org.openscada.vi.ui.draw2d;

import java.util.Map;

import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;

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
        return new SummaryInformation ( this.controller.getData () );
    }

}
