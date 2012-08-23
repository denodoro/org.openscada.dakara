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

import org.openscada.core.ui.connection.login.LoginSession;
import org.openscada.core.ui.connection.login.SessionListener;
import org.openscada.core.ui.connection.login.SessionManager;

public class PermissionVisibilityProviderImpl extends AbstractVisibilityProvider implements SessionListener
{

    private final String permission;

    public PermissionVisibilityProviderImpl ( final String permission )
    {
        this.permission = permission;
        SessionManager.getDefault ().addListener ( this );
    }

    protected boolean evalPermission ()
    {
        return SessionManager.getDefault ().hasRole ( this.permission );
    }

    @Override
    public void dispose ()
    {
        SessionManager.getDefault ().removeListener ( this );
    }

    @Override
    public void sessionChanged ( final LoginSession session )
    {
        fireChange ( evalPermission () );
    }

}
