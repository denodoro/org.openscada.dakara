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

package org.openscada.vi.data;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openscada.core.ui.styles.StateInformation;
import org.openscada.da.client.DataItemValue;

public class SummaryInformation
{

    private final Map<String, DataValue> data;

    private final Collection<SummaryInformation> childData;

    private final List<String> nameHierarchy;

    public SummaryInformation ( final List<String> nameHierarchy, final Map<String, DataValue> data, final Collection<SummaryInformation> childData )
    {
        this.nameHierarchy = nameHierarchy;
        this.data = data;
        this.childData = childData == null ? Collections.<SummaryInformation> emptyList () : childData;
    }

    public SummaryInformation ( final Map<String, DataValue> data )
    {
        this ( Collections.<String> emptyList (), data, Collections.<SummaryInformation> emptyList () );
    }

    public boolean isValid ()
    {
        for ( final Map.Entry<String, DataValue> entry : this.data.entrySet () )
        {
            if ( entry.getValue () == null || entry.getValue ().isIgnoreSummary () )
            {
                continue;
            }

            final DataItemValue value = entry.getValue ().getValue ();
            if ( value == null || !value.isConnected () || value.isError () || value.getValue () == null || value.getValue ().isNull () && entry.getValue ().isNullInvalid () )
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
        for ( final Map.Entry<String, DataValue> entry : this.data.entrySet () )
        {
            if ( entry.getValue () == null || entry.getValue ().isIgnoreSummary () )
            {
                continue;

            }
            if ( !entry.getValue ().getValue ().isConnected () )
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

    public boolean isWarning ()
    {
        return isAttribute ( "warning", false );
    }

    public boolean isManual ()
    {
        return isAttribute ( "manual", false );
    }

    public boolean isBlocked ()
    {
        return isAttribute ( "blocked", false );
    }

    public boolean isAckRequired ( final String severity )
    {
        return isAttribute ( severity + ".ackRequired", false );
    }

    public boolean isAttribute ( final String attributeName, final boolean defaultValue )
    {
        for ( final DataValue value : this.data.values () )
        {
            if ( value == null || value.getValue () == null || value.isIgnoreSummary () )
            {
                continue;
            }

            if ( value.getValue ().isAttribute ( attributeName, defaultValue ) )
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

    public StateInformation getStateInformation ()
    {
        return new SummaryStateInformation ( this );
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

    public void dump ( final PrintStream out )
    {
        dump ( "", out );
    }

    private static String PAD = "   ";

    protected void dump ( final String in, final PrintStream out )
    {
        out.println ( in + PAD + "name: " + this.nameHierarchy );
        out.print ( in + PAD + "valid: " + isValid () );
        out.print ( ", connected: " + isConnected () );
        out.print ( ", error: " + isError () );
        out.print ( ", alarm: " + isAlarm () );
        out.print ( ", warning: " + isWarning () );
        out.print ( ", manual: " + isManual () );
        out.print ( ", blocked: " + isBlocked () );
        out.println ();
        if ( !this.data.isEmpty () )
        {
            out.println ( in + PAD + "data:" );
            for ( final Map.Entry<String, DataValue> entry : this.data.entrySet () )
            {
                out.print ( in + PAD + PAD + entry.getKey () + "=>" );
                entry.getValue ().dump ( out );
                out.println ();
            }
        }
        if ( !this.childData.isEmpty () )
        {
            out.println ( in + PAD + "children:" );
            for ( final SummaryInformation child : this.childData )
            {
                child.dump ( in + PAD + PAD, out );
            }
        }
    }
}
