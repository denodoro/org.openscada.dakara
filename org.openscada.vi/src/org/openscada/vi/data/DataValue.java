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

import java.io.PrintStream;

import org.openscada.da.client.DataItemValue;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.utils.lang.Immutable;

@Immutable
public class DataValue
{
    private final DataItemValue value;

    private final boolean ignoreSummary;

    private final boolean nullInvalid;

    private final Item item;

    public DataValue ( final DataItemValue value, final Item item, final boolean ignoreSummary, final boolean nullInvalid )
    {
        super ();
        this.value = value;
        this.item = new Item ( item );
        this.ignoreSummary = ignoreSummary;
        this.nullInvalid = nullInvalid;
    }

    public Item getItem ()
    {
        return new Item ( this.item );
    }

    public DataItemValue getValue ()
    {
        return this.value;
    }

    public boolean isIgnoreSummary ()
    {
        return this.ignoreSummary;
    }

    public boolean isNullInvalid ()
    {
        return this.nullInvalid;
    }

    @Override
    public String toString ()
    {
        return this.value != null ? this.value.toString () : "<null>";
    }

    public void dump ( final PrintStream out )
    {
        out.print ( String.format ( "item: '%s', value: '%s', ignoreSummary: %s, nullInvalid: %s", this.item, this.value, this.ignoreSummary, this.nullInvalid ) );
    }
}
