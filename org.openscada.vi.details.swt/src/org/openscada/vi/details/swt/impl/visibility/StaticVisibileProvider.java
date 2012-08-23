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

/**
 * Provide an implementation that has a static visible state
 * 
 * @author Jens Reimann
 */
public class StaticVisibileProvider implements VisibilityProvider
{
    /**
     * Provide an instance that is always visible
     */
    public static StaticVisibileProvider VISIBLE_INSTANCE = new StaticVisibileProvider ( true );

    /**
     * Provide an instance that is never visible
     */
    public static StaticVisibileProvider INVISIBLE_INSTANCE = new StaticVisibileProvider ( false );

    private final boolean state;

    private StaticVisibileProvider ( final boolean state )
    {
        this.state = state;
    }

    @Override
    public void addListener ( final Listener listener )
    {
        listener.visibilityChanged ( this.state );
    }

    @Override
    public void removeListener ( final Listener listener )
    {
    }

    @Override
    public void dispose ()
    {
    }

}
