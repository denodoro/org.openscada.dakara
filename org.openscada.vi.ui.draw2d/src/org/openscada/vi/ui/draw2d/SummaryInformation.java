package org.openscada.vi.ui.draw2d;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.openscada.da.client.DataItemValue;

public class SummaryInformation
{

    private final Map<String, DataItemValue> data;

    private final Collection<SummaryInformation> childData;

    public SummaryInformation ( final Map<String, DataItemValue> data, final Collection<SummaryInformation> childData )
    {
        this.data = data;
        this.childData = childData == null ? Collections.<SummaryInformation> emptyList () : childData;
    }

    public SummaryInformation ( final Map<String, DataItemValue> data )
    {
        this ( data, Collections.<SummaryInformation> emptyList () );
    }

    public boolean isValid ()
    {
        for ( final Map.Entry<String, DataItemValue> entry : this.data.entrySet () )
        {
            if ( entry.getValue () == null || !entry.getValue ().isConnected () || entry.getValue ().isError () || entry.getValue ().getValue () == null || entry.getValue ().getValue ().isNull () )
            {
                return false;
            }
        }

        for ( final SummaryInformation child : this.childData )
        {
            if ( !child.isValid () )
            {
                return false;
            }
        }

        return true;
    }

    public boolean isConnected ()
    {
        for ( final Map.Entry<String, DataItemValue> entry : this.data.entrySet () )
        {
            if ( !entry.getValue ().isConnected () )
            {
                return false;
            }
        }

        for ( final SummaryInformation child : this.childData )
        {
            if ( !child.isConnected () )
            {
                return false;
            }
        }

        return true;
    }

    public boolean isError ()
    {
        return isAttribute ( "error", false );
    }

    public boolean isAlarm ()
    {
        return isAttribute ( "alarm", false );
    }

    public boolean isManual ()
    {
        return isAttribute ( "manual", false );
    }

    public boolean isBlocked ()
    {
        return isAttribute ( "blocked", false );
    }

    public boolean isAckRequired ()
    {
        return isAttribute ( "ackRequired", false );
    }

    public boolean isAttribute ( final String attributeName, final boolean defaultValue )
    {
        for ( final DataItemValue value : this.data.values () )
        {
            if ( value == null )
            {
                continue;
            }

            if ( value.isAttribute ( attributeName, defaultValue ) )
            {
                return true;
            }
        }
        for ( final SummaryInformation child : this.childData )
        {
            if ( child.isAttribute ( attributeName, defaultValue ) )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "[attrs: " + this.data.size () );
        sb.append ( ", childs: " + this.childData.size () );

        sb.append ( ", valid: " + isValid () );

        sb.append ( ", error: " + isError () );
        sb.append ( ", alarm: " + isAlarm () );
        sb.append ( ", manual: " + isManual () );
        sb.append ( ", blocked: " + isBlocked () );

        sb.append ( "]" );

        return sb.toString ();
    }
}
