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

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;

import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.details.swt.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptVisibilityProviderImpl extends AbstractVisibilityProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( ScriptVisibilityProviderImpl.class );

    public ScriptVisibilityProviderImpl ( final ScriptEngineManager scriptEngineManager, final ScriptContext scriptContext, String engineName, final String scriptCode )
    {
        fireChange ( false );

        if ( engineName == null || engineName.isEmpty () )
        {
            engineName = "JavaScript";
        }

        try
        {
            final ScriptExecutor executor = new ScriptExecutor ( scriptEngineManager, engineName, scriptCode, Activator.class.getClassLoader () );
            fireChange ( makeResult ( executor.execute ( scriptContext ) ) );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to eval visibility", e );
        }
    }

    private boolean makeResult ( final Object result )
    {
        if ( result == null )
        {
            return false;
        }
        if ( result instanceof Boolean )
        {
            return (Boolean)result;
        }
        if ( result instanceof Number )
        {
            return ( (Number)result ).longValue () != 0;
        }
        return Boolean.parseBoolean ( result.toString () );
    }

    @Override
    public void dispose ()
    {
    }

}
