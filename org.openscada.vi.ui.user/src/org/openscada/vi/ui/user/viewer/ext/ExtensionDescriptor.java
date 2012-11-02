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

package org.openscada.vi.ui.user.viewer.ext;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

public class ExtensionDescriptor
{
    private final IConfigurationElement element;

    public ExtensionDescriptor ( final IConfigurationElement element )
    {
        this.element = element;
    }

    public String getLocation ()
    {
        return this.element.getAttribute ( "location" );
    }

    public String getAlign ()
    {
        return this.element.getAttribute ( "align" );
    }

    public ViewerExtension createExtension () throws CoreException
    {
        final Object result = this.element.createExecutableExtension ( "class" );
        if ( result instanceof ViewerExtension )
        {
            return (ViewerExtension)result;
        }
        return null;
    }
}
