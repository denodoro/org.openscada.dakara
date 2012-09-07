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

package org.openscada.vi.details.swt.source;

import java.util.Map;

import org.openscada.da.client.DataItemValue;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;

public class ItemValueSourceController implements ValueSourceController
{
    private final String valueKey;

    private Map<String, DataValue> values;

    public ItemValueSourceController ( final String valueKey )
    {
        this.valueKey = valueKey;
    }

    @Override
    public DataItemValue value ()
    {
        final DataItemValue value = this.values.get ( this.valueKey ).getValue ();

        if ( value == null )
        {
            return DataItemValue.DISCONNECTED;
        }
        else
        {
            return value;
        }
    }

    @Override
    public void updateData ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        this.values = values;
    }

}
