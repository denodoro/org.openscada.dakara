package org.openscada.vi.ui.draw2d;

import java.util.Map;

import org.openscada.da.client.DataItemValue;

public class SummaryInformation
{

    private final Map<String, DataItemValue> data;

    public SummaryInformation ( final Map<String, DataItemValue> data )
    {
        this.data = data;
    }

    public boolean isValid ()
    {
        for ( final Map.Entry<String, DataItemValue> entry : this.data.entrySet () )
        {
            if ( !entry.getValue ().isConnected () || entry.getValue ().isError () || entry.getValue ().getValue () == null || entry.getValue ().getValue ().isNull () )
            {
                return false;
            }
        }
        return true;
    }

    public boolean isError ()
    {
        return isAttribute ( "error" );
    }

    public boolean isAlarm ()
    {
        return isAttribute ( "alarm" );
    }

    public boolean isManual ()
    {
        return isAttribute ( "manual" );
    }

    public boolean isBlocked ()
    {
        return isAttribute ( "blocked" );
    }

    public boolean isAttribute ( final String attributeName )
    {
        for ( final DataItemValue value : this.data.values () )
        {
            if ( value.isAttribute ( attributeName ) )
            {
                return true;
            }
        }
        return false;
    }
}
