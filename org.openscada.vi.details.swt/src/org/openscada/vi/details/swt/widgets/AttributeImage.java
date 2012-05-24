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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.core.Variant;
import org.openscada.core.ui.connection.login.SessionManager;
import org.openscada.da.client.DataItemValue;
import org.openscada.da.client.dataitem.details.dialog.DataItemDetailsDialog;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.connection.data.Item.Type;
import org.openscada.ui.utils.blink.Blinker;
import org.openscada.ui.utils.blink.Blinker.Handler;
import org.openscada.ui.utils.blink.Blinker.State;
import org.openscada.vi.details.swt.Activator;
import org.openscada.vi.details.swt.data.DataController;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributeImage extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( AttributeImage.class );

    private static final String detailsDialogRole = System.getProperty ( " org.openscada.vi.details.swt.widgets.roles.detailsDialog", "admin" );

    private Label attributeLabel;

    private ResourceManager resourceManager;

    private Image imageACK;

    private Image imageAlarm;

    private Image imageError;

    private Image imageDisconnected;

    private Image imageManual;

    private Image imageEmpty;

    private Image imageWhite;

    private Image imageOk;

    private Image imageBlock;

    private final DataController dataController;

    private final DataItemDescriptor descriptor;

    private Blinker blinker;

    private final String hdConnectionId;

    private final String hdItemId;

    public AttributeImage ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, null, null );
        this.dataController = new DataController ( this );
        this.descriptor = descriptor;

        // set the hd connection information .. either using combined descriptor in item id
        // or using separate connection and item information
        final DataItemDescriptor hdDescriptor = DataItemDescriptor.create ( hdItemId );
        if ( hdDescriptor == null )
        {
            this.hdConnectionId = hdConnectionId;
            this.hdItemId = hdItemId;
        }
        else
        {
            this.hdItemId = hdDescriptor.getItemId ();
            if ( hdConnectionId == null )
            {
                this.hdConnectionId = hdDescriptor.getConnectionInformation ();
            }
            else
            {
                this.hdConnectionId = hdConnectionId;
            }
        }

        initResources ();
        initBlinker ();
        initLabels ();
        initRowLayout ();

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                AttributeImage.this.dataController.dispose ();
            }
        } );
    }

    protected void createTrendButton ( final Composite parent )
    {
        if ( this.hdConnectionId != null && this.hdItemId != null && !this.hdConnectionId.isEmpty () && !this.hdItemId.isEmpty () )
        {
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
    }

    protected void startHdView ()
    {
        try
        {
            final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench ().getService ( ICommandService.class );
            final IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench ().getService ( IHandlerService.class );

            final Command command = commandService.getCommand ( "org.openscada.hd.ui.createManagedTrendView" ); //$NON-NLS-1$

            final Parameterization[] parameterizations = new Parameterization[3];
            parameterizations[0] = new Parameterization ( command.getParameter ( "org.openscada.hd.ui.connectionId" ), this.hdConnectionId ); //$NON-NLS-1$
            parameterizations[1] = new Parameterization ( command.getParameter ( "org.openscada.hd.ui.storageName" ), this.hdItemId ); //$NON-NLS-1$
            parameterizations[2] = new Parameterization ( command.getParameter ( "org.openscada.hd.ui.queryTimespec" ), "40:10:200" ); //$NON-NLS-1$ //$NON-NLS-2$
            final ParameterizedCommand parameterCommand = new ParameterizedCommand ( command, parameterizations );

            handlerService.executeCommand ( parameterCommand, null );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.AttributeImage_TrendError, e ), StatusManager.BLOCK );
        }
    }

    protected void initRowLayout ()
    {
        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        layout.pack = true;
        setLayout ( layout );
    }

    protected void initLabels ()
    {
        this.attributeLabel = new Label ( this, 0 );
        this.attributeLabel.setImage ( this.imageEmpty );
        this.attributeLabel.addMouseListener ( new MouseAdapter () {

            @Override
            public void mouseDown ( final org.eclipse.swt.events.MouseEvent e )
            {
                if ( ( e.stateMask & SWT.MOD1 ) > 0 )
                {
                    AttributeImage.this.ack ();
                }
            }

            @Override
            public void mouseDoubleClick ( final org.eclipse.swt.events.MouseEvent e )
            {
                if ( SessionManager.getDefault ().hasRole ( detailsDialogRole ) )
                {
                    final DataItemDetailsDialog dlg = new DataItemDetailsDialog ( getShell (), new Item ( AttributeImage.this.descriptor.getConnectionInformation ().toString (), AttributeImage.this.descriptor.getItemId (), Type.ID ) );
                    dlg.open ();
                }
            };

        } );

        DragHelper.addDragSupport ( this.attributeLabel, this.descriptor );

        createTrendButton ( this );
    }

    protected void initBlinker ()
    {
        this.blinker = new Blinker ( new Handler () {

            @Override
            public void setState ( final State state )
            {
                AttributeImage.this.handleBlink ( state );
            }
        } );
    }

    protected void initResources ()
    {
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.imageACK = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/ack.png" ) ); //$NON-NLS-1$
        this.imageAlarm = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/alarm.png" ) ); //$NON-NLS-1$
        this.imageError = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/disconnected.png" ) ); //$NON-NLS-1$
        this.imageDisconnected = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/disconnected.png" ) ); //$NON-NLS-1$
        this.imageManual = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/manual.png" ) ); //$NON-NLS-1$
        this.imageEmpty = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/empty.png" ) ); //$NON-NLS-1$
        this.imageWhite = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/white.png" ) ); //$NON-NLS-1$
        this.imageOk = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/ok.png" ) ); //$NON-NLS-1$
        this.imageBlock = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeImage.class, "icons/block.png" ) ); //$NON-NLS-1$
    }

    protected ResourceManager getResourceManager ()
    {
        return this.resourceManager;
    }

    protected Image getImageEmpty ()
    {
        return this.imageEmpty;
    }

    protected DataController getDataController ()
    {
        return this.dataController;
    }

    private void ack ()
    {
        final Map<String, Variant> map = new HashMap<String, Variant> ( 1 );
        final Variant variant = Variant.TRUE;

        map.put ( "remote.ackRequired", variant ); //$NON-NLS-1$

        this.dataController.writeOperation ( map, this.descriptor );
        logger.info ( "remote.ackRequired written" ); //$NON-NLS-1$
    }

    protected void performDispose ()
    {
        logger.debug ( "Disposing" ); //$NON-NLS-1$

        this.blinker.dispose ();

        this.dataController.dispose ();

        this.resourceManager.dispose ();
    }

    @Override
    public void dispose ()
    {
        performDispose ();
        super.dispose ();
    }

    protected void handleBlink ( final State state )
    {
        if ( this.attributeLabel.isDisposed () )
        {
            return;
        }

        switch ( state )
        {
            case ALARM_0:
                setNewAttributeImage ( this.imageWhite );
                break;
            case ALARM_1:
                setNewAttributeImage ( this.imageACK );
                break;
            case ALARM:
                setNewAttributeImage ( this.imageAlarm );
                break;
            case ERROR:
                setNewAttributeImage ( this.imageError );
                break;
            case MANUAL:
                setNewAttributeImage ( this.imageManual );
                break;
            case DISCONNECTED:
                setNewAttributeImage ( this.imageDisconnected );
                break;
            case BLOCKED:
                setNewAttributeImage ( this.imageBlock );
                break;
            case OK:
                setNewAttributeImage ( this.imageOk );
                break;
        }
    }

    public void updateStatusView ( final SCADAAttributes state )
    {
        logger.debug ( "BooleanSignal.updateStatusView: isAlarm: {}; isAckRequired: {}", state.isAlarm (), state.isAckRequired () ); //$NON-NLS-1$

        this.blinker.setState ( state.isAlarm (), state.isAckRequired (), state.isManualActive (), state.isDisconnected (), state.isError (), state.isBlocked () );
    }

    private void setNewAttributeImage ( final Image image )
    {
        if ( this.attributeLabel.getImage () != image )
        {
            this.attributeLabel.setImage ( image );
        }
    }

    @Override
    public void updateView ( final Object key, final Map<Object, DataItemValue> values, final SCADAAttributes aggregatedState )
    {
        // DataController is needed for write operation only
        logger.debug ( "updateView" ); //$NON-NLS-1$
    }

}
