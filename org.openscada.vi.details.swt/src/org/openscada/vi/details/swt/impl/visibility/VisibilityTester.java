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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

public class VisibilityTester
{
    private Shell dialog;

    public Button createTester ( final String label )
    {
        checkCreateDialog ();

        final Button result = new Button ( this.dialog, SWT.CHECK );
        result.setText ( label );
        this.dialog.layout ();
        return result;
    }

    public void removeTester ( final Button button )
    {
        button.dispose ();
        if ( this.dialog != null )
        {
            this.dialog.layout ();
        }
        checkDisposeDialog ();
    }

    private void checkDisposeDialog ()
    {
        if ( this.dialog == null || this.dialog.isDisposed () )
        {
            return;
        }

        if ( this.dialog.getChildren ().length == 0 )
        {
            this.dialog.dispose ();
            this.dialog = null;
        }
    }

    private void checkCreateDialog ()
    {
        if ( this.dialog != null )
        {
            return;
        }

        this.dialog = new Shell ();
        this.dialog.setText ( "Visibility Tester" );
        this.dialog.open ();
        this.dialog.setLayout ( new GridLayout ( 1, false ) );
        this.dialog.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                VisibilityTester.this.dialog = null;
            }
        } );
    }

    public void dispose ()
    {
        if ( this.dialog != null )
        {
            this.dialog.dispose ();
            this.dialog = null;
        }
    }
}
