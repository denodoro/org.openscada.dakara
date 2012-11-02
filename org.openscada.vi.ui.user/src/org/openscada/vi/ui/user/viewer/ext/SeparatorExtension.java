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

import java.util.Hashtable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.openscada.vi.ui.user.viewer.ViewManager;

public class SeparatorExtension implements ViewerExtension, IExecutableExtension
{

    private boolean visibile = true;

    @Override
    public Control create ( final Composite parent, final ViewManager viewManager, final boolean horizontal )
    {
        return new Label ( parent, this.visibile ? SWT.SEPARATOR : SWT.NONE );
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        if ( data instanceof Hashtable<?, ?> )
        {
            this.visibile = ! ( (Hashtable<?, ?>)data ).containsKey ( "invisible" );
        }
    }

}
