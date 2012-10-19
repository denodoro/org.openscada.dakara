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

package org.openscada.vi.details.swt.widgets.control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.openscada.core.ui.connection.login.SessionManager;
import org.openscada.core.ui.styles.Activator;
import org.openscada.core.ui.styles.StyleBlinker;
import org.openscada.da.client.dataitem.details.dialog.DataItemDetailsDialog;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.vi.data.RegistrationManager;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.widgets.DragHelper;

public class ControlImage extends Composite implements RegistrationManager.Listener
{

    private static final String detailsDialogRole = System.getProperty ( "org.openscada.vi.details.swt.widgets.roles.detailsDialog", "admin" );

    private final Label state;

    private Composite clientSpace;

    private final StyleBlinker blinker;

    private Item detailItem;

    private final RegistrationManager registrationManager;

    public ControlImage ( final Composite parent, final RegistrationManager registrationManager )
    {
        this ( parent, SWT.NONE, registrationManager );
    }

    public ControlImage ( final Composite parent, final int style, final RegistrationManager registrationManager )
    {
        super ( parent, style );

        this.registrationManager = registrationManager;
        registrationManager.addListener ( this );

        final RowLayout layout = new RowLayout ( SWT.HORIZONTAL );
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        layout.pack = true;
        setLayout ( layout );

        this.state = new Label ( this, SWT.NONE );
        DragHelper.addDragSupport ( this.state, registrationManager );

        this.state.addMouseListener ( new MouseAdapter () {
            @Override
            public void mouseDoubleClick ( final org.eclipse.swt.events.MouseEvent e )
            {
                openDetails ();
            };
        } );

        this.blinker = new StyleBlinker () {

            @Override
            public void update ( final Image image, final Color foreground, final Color background, final Font font )
            {
                handleStyleUpdate ( image, foreground, background, font );
            }
        };

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
    }

    public void setDetailItem ( final Item detailItem )
    {
        this.detailItem = detailItem;
    }

    public Item getDetailItem ()
    {
        return this.detailItem;
    }

    protected void openDetails ()
    {
        if ( this.detailItem == null )
        {
            return;
        }

        if ( SessionManager.getDefault ().hasRole ( detailsDialogRole ) )
        {
            final DataItemDetailsDialog dlg = new DataItemDetailsDialog ( getShell (), this.detailItem );
            dlg.open ();
        }
    }

    protected void handleStyleUpdate ( final Image image, final Color foreground, final Color background, final Font font )
    {
        if ( this.state.isDisposed () )
        {
            return;
        }

        if ( image == null )
        {
            this.state.setImage ( org.openscada.vi.details.swt.Activator.getDefault ().getImageRegistry ().get ( org.openscada.vi.details.swt.Activator.IMG_ATTR_OK ) );
        }
        else
        {
            this.state.setImage ( image );
        }

        getParent ().layout ();
    }

    protected void handleDispose ()
    {
        this.registrationManager.removeListener ( this );
        this.blinker.dispose ();
    }

    /**
     * Get the client space and create if it does not yet exists.
     * <p>
     * Note that if the client space is not filled, the default size of the empty composite will be 64x64 due to some strange SWT philosophy.
     * </p>
     * 
     * @return The client space composite
     */
    public Composite getClientSpace ()
    {
        if ( this.clientSpace == null )
        {
            this.clientSpace = new Composite ( this, SWT.NONE );
            this.clientSpace.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );
        }
        return this.clientSpace;
    }

    @Override
    public void triggerDataUpdate ()
    {
        final SummaryInformation summaryInformation = new SummaryInformation ( this.registrationManager.getData () );
        this.blinker.setStyle ( Activator.getDefaultStyleGenerator ().generateStyle ( summaryInformation.getStateInformation () ) );
    }
}
