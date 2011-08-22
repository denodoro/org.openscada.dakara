/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2011 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

package org.openscada.vi.ui.user;

import java.net.URI;
import java.util.Map;

public class ViewInstanceDescriptor
{
    private final String id;

    private final String parentId;

    private final URI uri;

    private final String name;

    private final Map<String, String> properties;

    private final boolean defaultInstance;

    public ViewInstanceDescriptor ( final String id, final String parentId, final URI uri, final String name, final boolean defaultInstance, final Map<String, String> properties )
    {
        super ();
        this.id = id;
        this.parentId = parentId;
        this.uri = uri;
        this.name = name;
        this.properties = properties;
        this.defaultInstance = defaultInstance;
    }

    public String getId ()
    {
        return this.id;
    }

    public String getParentId ()
    {
        return this.parentId;
    }

    public URI getUri ()
    {
        return this.uri;
    }

    public String getName ()
    {
        return this.name;
    }

    public Map<String, String> getProperties ()
    {
        return this.properties;
    }

    public boolean isDefaultInstance ()
    {
        return this.defaultInstance;
    }
}
