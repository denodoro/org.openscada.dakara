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

import org.openscada.vi.details.model.DetailView.Invisible;
import org.openscada.vi.details.model.DetailView.PermissionVisibility;
import org.openscada.vi.details.model.DetailView.ScriptVisibility;
import org.openscada.vi.details.model.DetailView.TestVisibility;
import org.openscada.vi.details.model.DetailView.Visibility;

public class VisibilityProviderFactory
{
    private final ScriptEngineManager scriptEngineManager;

    private final ScriptContext scriptContext;

    public VisibilityProviderFactory ( final ScriptEngineManager scriptEngineManager, final ScriptContext scriptContext )
    {
        this.scriptEngineManager = scriptEngineManager;
        this.scriptContext = scriptContext;
    }

    /**
     * Create a visibility provider
     * 
     * @param object
     *            the model object on which the instance should be created
     * @return never returns <code>null</code>
     */
    public VisibilityProvider createProvider ( final Visibility object )
    {
        if ( object == null )
        {
            return StaticVisibileProvider.VISIBLE_INSTANCE;
        }
        if ( object instanceof PermissionVisibility )
        {
            return new PermissionVisibilityProviderImpl ( ( (PermissionVisibility)object ).getRequiredPermission () );
        }
        if ( object instanceof ScriptVisibility )
        {
            return new ScriptVisibilityProviderImpl ( this.scriptEngineManager, this.scriptContext, ( (ScriptVisibility)object ).getScriptLanguage (), ( (ScriptVisibility)object ).getScript () );
        }
        if ( object instanceof Invisible )
        {
            return StaticVisibileProvider.INVISIBLE_INSTANCE;
        }
        if ( object instanceof TestVisibility )
        {
            return new TestVisibilityImpl ( ( (TestVisibility)object ).getId () );
        }

        return StaticVisibileProvider.INVISIBLE_INSTANCE;
    }
}
