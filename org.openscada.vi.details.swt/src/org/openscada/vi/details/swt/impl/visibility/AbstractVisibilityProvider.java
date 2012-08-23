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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;

public abstract class AbstractVisibilityProvider implements VisibilityProvider
{
    private final Set<Listener> listeners = new HashSet<Listener> ();

    private boolean state;

    /**
     * Fire visibility change
     * <p>
     * The change will only be fired if the state really changed.
     * </p>
     * 
     * @param state
     *            the new state
     */
    protected void fireChange ( final boolean state )
    {
        if ( this.state == state )
        {
            return;
        }

        this.state = state;
        for ( final Listener listener : this.listeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.visibilityChanged ( state );
                }
            } );
        }
    }

    @Override
    public void addListener ( final Listener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            listener.visibilityChanged ( this.state );
        }
    }

    @Override
    public void removeListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

}