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

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LockMessageDialog extends TitleAreaDialog
{

    private Text text;

    private String textString;

    public LockMessageDialog ( final Shell shell, final String defaultString )
    {
        super ( shell );
        setBlockOnOpen ( true );
        this.textString = defaultString;
    }

    public String openDialog ()
    {
        if ( open () == Window.OK )
        {
            return getText ();
        }
        else
        {
            return null;
        }
    }

    @Override
    protected void okPressed ()
    {
        this.textString = this.text.getText ();
        super.okPressed ();
    }

    public String getText ()
    {
        return this.textString;
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        setMessage ( Messages.LockMessageDialog_DialogMessage );
        setTitle ( Messages.LockMessageDialog_DialogTitle );
        getShell ().setText ( Messages.LockMessageDialog_DialogTitle );

        final Composite wrapper = (Composite)super.createDialogArea ( parent );

        this.text = new Text ( wrapper, SWT.BORDER | SWT.MULTI );
        this.text.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        if ( this.textString != null )
        {
            this.text.setText ( this.textString );
            this.text.setSelection ( 0, this.text.getText ().length () );
        }

        return wrapper;
    }

}
