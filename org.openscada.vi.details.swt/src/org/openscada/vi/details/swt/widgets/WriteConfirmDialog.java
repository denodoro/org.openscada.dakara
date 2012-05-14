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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.openscada.vi.details.swt.util.User;

public class WriteConfirmDialog
{
    static public boolean create ( final Shell shell )
    {
        final String value = System.getProperty ( "org.openscada.developer" ); //$NON-NLS-1$
        if ( value != null )
        {
            if ( value.toLowerCase ().equals ( "true" ) ) //$NON-NLS-1$
            {
                return true;
            }
        }
        if ( User.isAdmin () )
        {
            return true;
        }
        if ( shell == null )
        {
            return MessageDialog.openQuestion ( org.openscada.vi.details.swt.Activator.getDefault ().getWorkbench ().getActiveWorkbenchWindow ().getShell (), Messages.WriteConfirmDialog_sendData, Messages.WriteConfirmDialog_confirmOperation );
        }
        else
        {
            return MessageDialog.openQuestion ( shell, Messages.WriteConfirmDialog_sendData, Messages.WriteConfirmDialog_confirmOperation );
        }

    }
}
