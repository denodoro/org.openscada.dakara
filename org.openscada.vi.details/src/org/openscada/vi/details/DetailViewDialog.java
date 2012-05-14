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

package org.openscada.vi.details;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.openscada.core.ui.connection.login.LoginSession;
import org.openscada.core.ui.connection.login.SessionListener;
import org.openscada.core.ui.connection.login.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailViewDialog implements SessionListener
{

    private static final Logger logger = LoggerFactory.getLogger ( DetailViewDialog.class );

    private Shell shell;

    private final Shell parentShell;

    private final Map<String, String> properties;

    private final String id;

    private DetailView detailView;

    private LoginSession session;

    public DetailViewDialog ( final Shell parentShell, final String id, final Map<String, String> properties )
    {
        this.parentShell = parentShell;
        this.id = id;
        this.properties = new HashMap<String, String> ( properties );
        this.session = SessionManager.getDefault ().getSession ();
    }

    public void open ()
    {
        try
        {
            if ( !Boolean.getBoolean ( "org.openscada.developer" ) && !Boolean.getBoolean ( "org.openscada.operator" ) ) //$NON-NLS-1$ //$NON-NLS-2$
            {
                if ( this.session == null )
                {
                    ErrorDialog.openError ( this.parentShell, Messages.DetailViewDialog_ErrorDialog_Title, Messages.DetailViewDialog_ErrorDialog_NoSession, new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( Messages.DetailViewDialog_ErrorMessage_NoSession, this.id ) ) );
                    return;
                }
            }

            this.detailView = DetailViewManager.openView ( this.id, this.properties );

            if ( this.detailView == null )
            {
                ErrorDialog.openError ( this.parentShell, Messages.DetailViewDialog_ErrorDialog_Title, Messages.DetailViewDialog_ErrorDialog_Message_NotFound, new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( Messages.DetailViewDialog_ErrorMessage_NotFound, this.id ) ) );
                return;
            }
        }
        catch ( final CoreException e )
        {
            logger.warn ( "Failed to load view", e ); //$NON-NLS-1$
            ErrorDialog.openError ( this.parentShell, Messages.DetailViewDialog_ErrorDialog_Title, Messages.DetailViewDialog_ExceptionDialog_Message, e.getStatus () );
            return;
        }

        this.shell = new Shell ( this.parentShell, SWT.RESIZE | SWT.CLOSE | SWT.BORDER | SWT.TITLE | SWT.MODELESS );
        this.shell.setMinimumSize ( 400, 100 );
        this.shell.setText ( this.properties.get ( "linkName" ) + " | " + this.properties.get ( "linkDetailView" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.shell.setToolTipText ( "" ); //$NON-NLS-1$
        if ( Boolean.getBoolean ( "org.openscada.developer" ) ) //$NON-NLS-1$
        {
            for ( final String key : this.properties.keySet () )
            {
                this.shell.setToolTipText ( this.shell.getToolTipText () + this.properties.get ( key ) + "\n" ); //$NON-NLS-1$
            }
        }
        //        this.shell.setToolTipText ( "Properties: " + this.properties );

        this.shell.addShellListener ( new ShellAdapter () {
            @Override
            public void shellClosed ( final ShellEvent e )
            {
                dispose ();
            }
        } );

        this.shell.setLayout ( new FillLayout () );

        this.detailView.init ( this.shell, this.properties );
        //        final Label label = new Label ( this.shell, 0 );
        //        label.setText ( "target: " + this.properties.get ( "linkTarget" ) ); //for testing only

        this.shell.pack ();
        this.shell.open ();
        this.shell.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent arg0 )
            {
                SessionManager.getDefault ().removeListener ( DetailViewDialog.this );
            }
        } );
        SessionManager.getDefault ().addListener ( this );

    }

    public void dispose ()
    {
        this.detailView.dispose ();

        if ( this.shell != null )
        {
            if ( !this.shell.isDisposed () )
            {
                this.shell.dispose ();
            }
        }
    }

    @Override
    public void sessionChanged ( final LoginSession session )
    {
        this.session = session;

        if ( Boolean.getBoolean ( "org.openscada.developer" ) || Boolean.getBoolean ( "org.openscada.operator" ) ) //$NON-NLS-1$ //$NON-NLS-2$
        {
            return;
        }

        if ( this.session == null )
        {
            this.shell.getDisplay ().asyncExec ( new Runnable () {

                @Override
                public void run ()
                {
                    DetailViewDialog.this.dispose ();
                }
            } );
        }
    }
}
