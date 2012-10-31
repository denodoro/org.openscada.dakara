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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.openscada.vi.ui.user.viewer.ViewInstance;
import org.openscada.vi.ui.user.viewer.ViewInstanceDescriptor;

public class ErrorView implements ViewInstance
{

    private final Label label;

    private final ViewInstanceDescriptor descriptor;

    public ErrorView ( final Composite parent, final ViewInstanceDescriptor descriptor )
    {
        this.descriptor = descriptor;

        this.label = new Label ( parent, SWT.NONE );
        this.label.setText ( "Error" );
    }

    @Override
    public void reload ()
    {
    }

    @Override
    public void deactivate ()
    {
    }

    @Override
    public void activate ()
    {
    }

    @Override
    public void setFocus ()
    {
        this.label.setFocus ();
    }

    @Override
    public Control getControl ()
    {
        return this.label;
    }

    @Override
    public boolean isDefaultInstance ()
    {
        return false;
    }

    @Override
    public ViewInstanceDescriptor getDescriptor ()
    {
        return this.descriptor;
    }

}
