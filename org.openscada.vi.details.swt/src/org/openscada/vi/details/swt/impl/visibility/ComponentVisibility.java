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

import org.openscada.vi.details.swt.impl.visibility.VisibilityProvider.Listener;

public class ComponentVisibility
{
    private final VisibilityProvider provider;

    private final Listener listener;

    private boolean state = true;

    private final VisibleComponent component;

    public ComponentVisibility ( final VisibilityProvider provider, final VisibleComponent component )
    {
        this.provider = provider;
        this.component = component;

        component.create ();

        this.listener = new Listener () {

            @Override
            public void visibilityChanged ( final boolean state )
            {
                handleVisibilityChanged ( state );
            }
        };
        this.provider.addListener ( this.listener );
    }

    protected void handleVisibilityChanged ( final boolean state )
    {
        if ( this.state == state )
        {
            return;
        }

        this.state = state;

        if ( state )
        {
            show ();
        }
        else
        {
            hide ();
        }
    }

    protected void hide ()
    {
        this.component.hide ();
    }

    protected void show ()
    {
        this.component.show ();
    }

    public void dispose ()
    {
        this.provider.dispose ();
        this.component.dispose ();
    }
}
