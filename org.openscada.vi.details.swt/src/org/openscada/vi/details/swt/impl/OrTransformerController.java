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

package org.openscada.vi.details.swt.impl;

import java.util.List;
import java.util.Map;

import org.openscada.core.Variant;
import org.openscada.core.subscription.SubscriptionState;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.source.ValueSourceController;

public class OrTransformerController extends CompositeTransformerController
{

    public OrTransformerController ( final List<ValueSourceController> values )
    {
        super ( values );
    }

    @Override
    public DataItemValue value ()
    {
        final Map<String, Variant> attributes = createAttributes ();
        final SubscriptionState state = createState ();

        for ( final ValueSourceController controller : this.values )
        {
            final DataItemValue value = controller.value ();
            if ( value.getValue ().asBoolean () )
            {
                return new DataItemValue ( Variant.TRUE, attributes, state );
            }
        }
        return new DataItemValue ( Variant.FALSE, attributes, state );
    }

}
