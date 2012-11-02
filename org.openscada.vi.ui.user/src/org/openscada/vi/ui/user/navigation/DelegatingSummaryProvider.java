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

import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.data.SummaryListener;

public class DelegatingSummaryProvider implements StateProvider
{
    private final org.openscada.vi.data.SummaryProvider summaryProvider;

    private final StateListener listener;

    private final SummaryListener summaryListener = new SummaryListener () {

        @Override
        public void summaryChanged ( final SummaryInformation summaryInformation )
        {
            handleSummaryChanged ( summaryInformation );
        }
    };

    public DelegatingSummaryProvider ( final org.openscada.vi.data.SummaryProvider summaryProvider, final StateListener listener )
    {
        this.summaryProvider = summaryProvider;
        this.listener = listener;

        this.summaryProvider.addSummaryListener ( this.summaryListener );
        final SummaryInformation currentSummary = summaryProvider.getSummary ();
        if ( currentSummary != null && listener != null )
        {
            listener.stateChange ( currentSummary.getStateInformation () );
        }
    }

    protected void handleSummaryChanged ( final SummaryInformation summaryInformation )
    {
        if ( this.listener != null && summaryInformation != null )
        {
            this.listener.stateChange ( summaryInformation.getStateInformation () );
        }
    }

    @Override
    public void dispose ()
    {
        this.summaryProvider.removeSummaryListener ( this.summaryListener );
    }

}
