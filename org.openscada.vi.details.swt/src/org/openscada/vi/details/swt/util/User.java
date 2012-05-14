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

package org.openscada.vi.details.swt.util;

import java.util.Map;

import org.openscada.core.connection.provider.ConnectionIdTracker;
import org.openscada.core.connection.provider.ConnectionTracker;
import org.openscada.vi.details.swt.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User
{

    private static final Logger logger = LoggerFactory.getLogger ( User.class );

    public static final String PRIV_ADMIN = "session.privilege.admin"; //$NON-NLS-1$

    public static final String PRIV_OPERATOR = "session.privilege.operator"; //$NON-NLS-1$

    public static boolean isAdmin ()
    {
        return isPermitted ( PRIV_ADMIN );
    }

    public static boolean isOperator ()
    {
        return isPermitted ( PRIV_OPERATOR );
    }

    synchronized public static boolean isPermitted ( final String permission )
    {
        //session.priviledge.admin=true will be checked, if configured in com.invare.gui.client.sphinx.resources.ossi plugin.xml
        if ( Boolean.getBoolean ( "org.openscada.developer" ) ) //$NON-NLS-1$
        {
            return true;
        }

        if ( Boolean.getBoolean ( "org.openscada.operator" ) ) //$NON-NLS-1$
        { //we need this to test client without authentication service
            if ( permission == null )
            {
                return true;
            }
            if ( permission.equals ( PRIV_OPERATOR ) )
            {
                return true;
            }
            return false;
        }

        Map<String, String> properties = null;
        final ConnectionTracker tracker = new ConnectionIdTracker ( Activator.getDefault ().getBundle ().getBundleContext (), "connection.master", null ); //$NON-NLS-1$
        tracker.open ();
        try
        {
            properties = tracker.getService ().getConnection ().getSessionProperties ();
        }
        catch ( final NullPointerException e )
        {

        }
        finally
        {
            tracker.close ();
        }

        if ( properties == null )
        {
            logger.warn ( "No properties" ); //$NON-NLS-1$
            return false;
        }
        else
        {
            final boolean result = properties.containsKey ( permission );
            logger.info ( "Result: {} -> {}", result, properties ); //$NON-NLS-1$
            return result;
        }
    }
}
