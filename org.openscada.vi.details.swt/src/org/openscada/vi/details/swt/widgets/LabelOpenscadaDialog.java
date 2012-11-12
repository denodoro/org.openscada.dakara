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

package org.openscada.vi.details.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.openscada.core.ui.connection.login.SessionManager;
import org.openscada.vi.details.swt.data.DataItemDescriptor;

public class LabelOpenscadaDialog extends Composite
{
    private String format;

    private final Label label;

    public LabelOpenscadaDialog ( final Composite parent, final int style, final String format, final DataItemDescriptor descriptor )
    {
        super ( parent, SWT.NONE );

        setLayout ( new FillLayout () );
        this.label = new Label ( this, style );

        this.format = format;

        if ( this.format == null )
        {
            this.format = "MISSING LABEL"; //$NON-NLS-1$
        }
        this.label.setText ( this.format );

        // TODO: make properties
        if ( SessionManager.getDefault ().hasRole ( "developer" ) )
        {
            this.label.setToolTipText ( Messages.LabelOpenscadaDialog_descriptor + descriptor );
        }

    }
}
