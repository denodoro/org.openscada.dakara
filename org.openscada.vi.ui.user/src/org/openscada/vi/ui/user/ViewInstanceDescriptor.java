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

package org.openscada.vi.ui.user;

import java.net.URI;
import java.util.Map;

import org.eclipse.core.expressions.Expression;

public class ViewInstanceDescriptor
{
    private final String id;

    private final String parentId;

    private final URI uri;

    private final String name;

    private final Map<String, String> properties;

    private final Boolean zooming;

    private final Expression visibleExpression;

    private final Expression lazyExpression;

    private final int order;

    private final boolean defaultInstance;

    private final Expression defaultInstanceExpression;

    private final ViewInstanceFactory factory;

    public ViewInstanceDescriptor ( final String id, final String parentId, final ViewInstanceFactory factory, final URI uri, final String name, final int order, final boolean defaultInstance, final Boolean zooming, final Expression lazyExpression, final Expression visibleExpression, final Expression defaultInstanceExpression, final Map<String, String> properties )
    {
        super ();
        this.id = id;
        this.parentId = parentId;
        this.factory = factory;
        this.uri = uri;
        this.name = name;
        this.properties = properties;
        this.order = order;
        this.defaultInstance = defaultInstance;
        this.zooming = zooming;
        this.lazyExpression = lazyExpression;
        this.visibleExpression = visibleExpression;
        this.defaultInstanceExpression = defaultInstanceExpression;
    }

    public boolean isDefaultInstance ()
    {
        return this.defaultInstance;
    }

    public Expression getDefaultInstanceExpression ()
    {
        return this.defaultInstanceExpression;
    }

    public Expression getLazyExpression ()
    {
        return this.lazyExpression;
    }

    public Expression getVisibleExpression ()
    {
        return this.visibleExpression;
    }

    public Boolean getZooming ()
    {
        return this.zooming;
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

    public int getOrder ()
    {
        return this.order;
    }

    public ViewInstanceFactory getFactory ()
    {
        return this.factory;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final ViewInstanceDescriptor other = (ViewInstanceDescriptor)obj;
        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }
        return true;
    }
}
