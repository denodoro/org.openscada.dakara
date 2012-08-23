/*
 * This file is part of the openSCADA project
 * Copyright (C) 2011-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

package org.openscada.vi.details.swt.impl.visibility;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.openscada.vi.details.swt.DetailComponent;

public abstract class SubTrackingVisibleComponent extends TrackingVisibleComponent
{
    private final Set<DetailComponent> subs = new HashSet<DetailComponent> ();

    private final Collection<DetailComponent> parentCollection;

    public SubTrackingVisibleComponent ( final Collection<DetailComponent> parentCollection )
    {
        this.parentCollection = parentCollection;
    }

    protected void trackSub ( final DetailComponent subComponent )
    {
        if ( this.subs.add ( subComponent ) )
        {
            this.parentCollection.add ( subComponent );
        }
    }

    protected void untrackSub ( final DetailComponent subComponent )
    {
        if ( this.subs.remove ( subComponent ) )
        {
            this.parentCollection.remove ( subComponent );
        }
    }

    @Override
    public void dispose ()
    {
        this.parentCollection.removeAll ( this.subs );
        for ( final DetailComponent sub : this.subs )
        {
            sub.dispose ();
        }
        super.dispose ();
    }
}
