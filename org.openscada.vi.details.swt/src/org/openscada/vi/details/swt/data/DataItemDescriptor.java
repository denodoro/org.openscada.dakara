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

import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.connection.data.Item.Type;

public class DataItemDescriptor
{

    private final String connectionInformation;

    private final String itemId;

    private final String descriptor;

    public DataItemDescriptor ( final String connectionInformation, final String itemId, final String descriptor )
    {
        this.connectionInformation = connectionInformation;
        this.itemId = itemId;
        this.descriptor = descriptor;
    }

    public String getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    public String getItemId ()
    {
        return this.itemId;
    }

    public static DataItemDescriptor create ( final String descriptor )
    {
        if ( descriptor == null )
        {
            return null;
        }

        final String[] toks = descriptor.split ( "\\#", 2 ); //$NON-NLS-1$

        if ( toks.length != 2 )
        {
            return null;
        }

        return new DataItemDescriptor ( toks[0], toks[1], descriptor );
    }

    public String getDescriptor ()
    {
        return this.descriptor;
    }

    @Override
    public String toString ()
    {
        return this.connectionInformation + "#" + this.itemId; //$NON-NLS-1$
    }

    public Item asItem ()
    {
        return new Item ( this.connectionInformation, this.itemId, Type.ID );
    }
}
