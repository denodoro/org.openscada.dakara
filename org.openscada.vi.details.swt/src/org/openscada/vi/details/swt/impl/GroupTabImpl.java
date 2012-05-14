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

package org.openscada.vi.details.swt.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.openscada.vi.details.swt.DetailComponent;
import org.openscada.vi.details.swt.data.DataItemDescriptor;

class GroupTabImpl implements GroupTab
{
    private final DetailComponent component;

    private final String label;

    public GroupTabImpl ( final String label, final DetailComponent component )
    {
        this.label = label;
        this.component = component;
    }

    @Override
    public void dispose ()
    {
        this.component.dispose ();
    }

    @Override
    public void init ( final Composite parent, final Map<String, String> properties )
    {
        this.component.init ( parent, properties );
    }

    @Override
    public String getLabel ()
    {
        return this.label;
    }

    @Override
    public Collection<DataItemDescriptor> getDescriptors ()
    {
        return this.component.listDescriptors ();
    }
}