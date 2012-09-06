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

package org.openscada.vi.ui.draw2d;

import java.util.EnumSet;
import java.util.Set;

import org.openscada.core.ui.styles.AbstractStateInformation;

class SummaryStateInformation extends AbstractStateInformation
{
    public SummaryStateInformation ( final SummaryInformation info )
    {
        super ( extract ( info ) );
    }

    private static Set<State> extract ( final SummaryInformation info )
    {
        final EnumSet<State> result = EnumSet.noneOf ( State.class );

        if ( info.isAckRequired () )
        {
            result.add ( State.ACK );
        }
        if ( info.isManual () )
        {
            result.add ( State.MANUAL );
        }
        if ( info.isBlocked () )
        {
            result.add ( State.BLOCK );
        }
        if ( !info.isConnected () )
        {
            result.add ( State.DISCONNECTED );
        }
        if ( info.isWarning () )
        {
            result.add ( State.WARNING );
        }
        if ( info.isAlarm () )
        {
            result.add ( State.ALARM );
        }
        if ( info.isError () )
        {
            result.add ( State.ERROR );
        }

        return result;
    }
}