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

package org.openscada.vi.details.handler;

import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.openscada.ui.databinding.AbstractSelectionHandler;
import org.openscada.vi.details.DetailViewDialog;

public class ShowDetailDialog extends AbstractSelectionHandler
{

    private final boolean useWaitShell = !Boolean.getBoolean ( "org.openscada.vi.details.handler.disableWaitShell" );

    @SuppressWarnings ( "unchecked" )
    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final String detailViewId = event.getParameter ( "org.openscada.vi.details.showDetailDialog.id" );
        final Map<String, String> parameters = (Map<String, String>)event.getObjectParameterForExecution ( "org.openscada.vi.details.showDetailDialog.parameters" );

        if ( this.useWaitShell )
        {
            openWithWaitShell ( getShell (), detailViewId, parameters );
        }
        else
        {
            open ( getShell (), detailViewId, parameters );
        }

        return null;
    }

    protected void openWithWaitShell ( final Shell parentShell, final String detailViewId, final Map<String, String> parameters )
    {

        final Shell waitShell = new Shell ( parentShell, SWT.PRIMARY_MODAL | SWT.BORDER );
        waitShell.setLayout ( new FillLayout () );
        final Label label = new Label ( waitShell, SWT.NONE );
        label.setText ( "Opening view…" );

        waitShell.pack ();
        waitShell.open ();

        // make sure the text is visible
        waitShell.getDisplay ().update ();

        try
        {
            open ( parentShell, detailViewId, parameters );
        }
        finally
        {
            // close the wait shell
            waitShell.close ();
        }

    }

    protected void open ( final Shell parentShell, final String detailViewId, final Map<String, String> parameters )
    {
        // now open the real dialog
        final DetailViewDialog dlg = new DetailViewDialog ( parentShell, detailViewId, parameters );
        dlg.open ();
    }

}
