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

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.vi.details.swt.Activator;

public class TrendControlImage extends Composite
{

    private final String connectionId;

    private final String itemId;

    public TrendControlImage ( final Composite parent, final int style, final String connectionId, final String itemId )
    {
        super ( parent, style );

        this.connectionId = connectionId;
        this.itemId = itemId;

        setLayout ( new FillLayout () );

        final Button button = new Button ( parent, SWT.PUSH | SWT.FLAT );
        button.setImage ( org.openscada.vi.details.swt.Activator.getDefault ().getImageRegistry ().get ( org.openscada.vi.details.swt.Activator.IMG_TREND ) );
        button.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                startHdView ();
            }
        } );
    }

    protected void startHdView ()
    {
        try
        {
            final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench ().getService ( ICommandService.class );
            final IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench ().getService ( IHandlerService.class );

            final Command command = commandService.getCommand ( "org.openscada.hd.ui.createManagedTrendView" ); //$NON-NLS-1$

            final Parameterization[] parameterizations = new Parameterization[3];
            parameterizations[0] = new Parameterization ( command.getParameter ( "org.openscada.hd.ui.connectionId" ), this.connectionId ); //$NON-NLS-1$
            parameterizations[1] = new Parameterization ( command.getParameter ( "org.openscada.hd.ui.storageName" ), this.itemId ); //$NON-NLS-1$
            parameterizations[2] = new Parameterization ( command.getParameter ( "org.openscada.hd.ui.queryTimespec" ), "40:10:200" ); //$NON-NLS-1$ //$NON-NLS-2$
            final ParameterizedCommand parameterCommand = new ParameterizedCommand ( command, parameterizations );

            handlerService.executeCommand ( parameterCommand, null );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.TrendControlImage_TrendError, e ), StatusManager.BLOCK );
        }
    }
}
