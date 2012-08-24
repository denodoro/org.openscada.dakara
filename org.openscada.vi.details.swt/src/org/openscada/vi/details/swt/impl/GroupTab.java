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

import java.util.Map;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.swt.widgets.Composite;
import org.openscada.vi.details.model.DetailView.Visibility;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.impl.visibility.VisibilityProviderFactory;

public interface GroupTab
{
    public void dispose ();

    public String getLabel ();

    public void init ( final VisibilityProviderFactory factory, final Composite parent, final Map<String, String> properties );

    /**
     * get descriptors
     * 
     * @return an obversable set of {@link DataItemDescriptor}s
     */
    public IObservableSet getDescriptors ();

    public Visibility getVisibility ();

    public void start ();

    public void stop ();
}