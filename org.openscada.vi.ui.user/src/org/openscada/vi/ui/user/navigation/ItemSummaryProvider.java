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

package org.openscada.vi.ui.user.navigation;

import java.util.EnumSet;
import java.util.Set;

import org.openscada.core.ui.styles.StateInformation;
import org.openscada.da.client.DataItemValue;
import org.openscada.da.ui.connection.data.DataItemHolder;
import org.openscada.da.ui.connection.data.DataSourceListener;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.styles.DataItemValueStateExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemSummaryProvider implements StateProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( ItemSummaryProvider.class );

    private final StateListener stateListener;

    private final DataSourceListener listener = new DataSourceListener () {

        @Override
        public void updateData ( final DataItemValue value )
        {
            handleValueChange ( value );
        }
    };

    private final DataItemHolder itemHolder;

    public ItemSummaryProvider ( final StateListener stateListener, final Item item )
    {
        this.stateListener = stateListener;

        // initialize with DISCONNECTED
        stateListener.stateChange ( new StateInformation () {

            @Override
            public Set<State> getStates ()
            {
                return EnumSet.of ( State.DISCONNECTED );
            }
        } );
        this.itemHolder = new DataItemHolder ( org.openscada.vi.ui.user.Activator.getDefault ().getBundle ().getBundleContext (), item, this.listener );
    }

    protected void handleValueChange ( final DataItemValue value )
    {
        logger.debug ( "Summary item value changed: {}", value );

        if ( this.listener == null )
        {
            return;
        }
        this.stateListener.stateChange ( new DataItemValueStateExtractor ( value ) );
    }

    @Override
    public void dispose ()
    {
        this.itemHolder.dispose ();
    }

}
