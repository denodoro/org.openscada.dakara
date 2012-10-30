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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openscada.core.Variant;
import org.openscada.core.subscription.SubscriptionState;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.source.ValueSourceController;

public abstract class CompositeTransformerController implements ValueSourceController
{

    private static final String[] SEVERITIES = new String[] { "error", "alarm", "warning" };

    protected final List<ValueSourceController> values;

    protected SummaryInformation state;

    public CompositeTransformerController ( final List<ValueSourceController> values )
    {
        this.values = values;
    }

    @Override
    public abstract DataItemValue value ();

    @Override
    public void updateData ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        for ( final ValueSourceController controller : this.values )
        {
            controller.updateData ( values, state );
        }
        this.state = state;
    }

    protected SubscriptionState createState ()
    {
        final SubscriptionState state = !this.state.isConnected () ? SubscriptionState.DISCONNECTED : SubscriptionState.CONNECTED;
        return state;
    }

    protected Map<String, Variant> createAttributes ()
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "error", Variant.valueOf ( this.state.isError () ) ); //$NON-NLS-1$
        attributes.put ( "manual", Variant.valueOf ( this.state.isManual () ) ); //$NON-NLS-1$
        attributes.put ( "alarm", Variant.valueOf ( this.state.isAlarm () ) ); //$NON-NLS-1$

        for ( final String severity : SEVERITIES )
        {
            attributes.put ( severity + ".ackRequired", Variant.valueOf ( this.state.isAckRequired ( severity ) ) ); //$NON-NLS-1$    
        }

        return attributes;
    }

}