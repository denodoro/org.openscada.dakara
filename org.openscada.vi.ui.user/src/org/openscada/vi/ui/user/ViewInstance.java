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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.openscada.ui.utils.blink.Blinker;
import org.openscada.ui.utils.blink.Blinker.Handler;
import org.openscada.ui.utils.blink.Blinker.State;
import org.openscada.vi.ui.draw2d.SummaryInformation;
import org.openscada.vi.ui.draw2d.SummaryListener;
import org.openscada.vi.ui.draw2d.VisualInterfaceViewer;
import org.openscada.vi.ui.user.preferences.PreferenceConstants;

public class ViewInstance implements SummaryListener
{
    private ToolItem button;

    private final ViewManager viewManager;

    private VisualInterfaceViewer viewer;

    private final ResourceManager manager;

    private final Image imageOk;

    private final Image imageInvalid;

    private final Image imageAlarm;

    private final Image imageManual;

    private final Image imageBlocked;

    private Blinker blinker;

    private final Image imageAlarm0;

    private final Image imageAlarm1;

    private final Image imageInactive;

    private final Composite parent;

    private final ViewInstanceDescriptor descriptor;

    private final LinkedHashMap<String, Object> scriptObjects;

    private final DisposeListener disposeListener;

    public ViewInstance ( final ViewManager viewManager, final Composite parent, final ToolBar toolbar, final ViewInstanceDescriptor descriptor, final ResourceManager manager )
    {
        this.parent = parent;
        this.viewManager = viewManager;
        this.descriptor = descriptor;
        this.manager = manager;

        this.imageOk = createImage ( PreferenceConstants.P_IMG_OK );
        this.imageInvalid = createImage ( PreferenceConstants.P_IMG_INVALID );
        this.imageAlarm = createImage ( PreferenceConstants.P_IMG_ALARM );
        this.imageManual = createImage ( PreferenceConstants.P_IMG_MANUAL );
        this.imageBlocked = createImage ( PreferenceConstants.P_IMG_BLOCKED );
        this.imageAlarm0 = createImage ( PreferenceConstants.P_IMG_ALARM_0 );
        this.imageAlarm1 = createImage ( PreferenceConstants.P_IMG_ALARM_1 );
        this.imageInactive = null;

        this.disposeListener = new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                internalDispose ();
            }
        };

        // create the main button
        if ( descriptor.getParentId () == null || descriptor.getParentId ().isEmpty () )
        {
            this.button = new ToolItem ( toolbar, SWT.RADIO );
            this.button.setText ( descriptor.getName () );
            this.button.setImage ( descriptor.isLazyActivation () ? this.imageInactive : this.imageOk );
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final org.eclipse.swt.events.SelectionEvent e )
                {
                    showView ( descriptor.getId () );
                };
            } );
        }
        else
        {
            this.button = null;
        }

        // create the blinker

        this.blinker = new Blinker ( new Handler () {

            @Override
            public void setState ( final State state )
            {
                handleBlink ( state );
            }
        } );

        // create the visual interface view

        this.scriptObjects = new LinkedHashMap<String, Object> ();
        this.scriptObjects.put ( "viewManager", viewManager );

        if ( !this.descriptor.isLazyActivation () )
        {
            activateView ( false );
        }
    }

    public void reload ()
    {
        // dispose first
        deactivateView ();

        // now create
        activateView ( true );
    }

    private void activateView ( final boolean forceSet )
    {
        if ( this.viewer != null )
        {
            return;
        }

        this.viewer = new VisualInterfaceViewer ( this.parent, SWT.NONE, this.descriptor.getUri (), this.scriptObjects, this.descriptor.getProperties () );
        this.viewer.setZooming ( this.descriptor.getZooming () );
        this.viewer.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        if ( this.button != null )
        {
            this.viewer.addSummaryListener ( this );
        }

        // re-add listener
        this.viewer.addDisposeListener ( this.disposeListener );

        // we need to force set ourself when reloading
        if ( forceSet )
        {
            this.viewManager.showView ( this.descriptor.getId (), true );
        }
    }

    private void deactivateView ()
    {
        if ( this.viewer != null )
        {
            if ( this.button != null )
            {
                this.viewer.removeSummaryListener ( this );
                this.button.setImage ( this.imageInactive );
            }

            // no need to dispose when changing the viewer
            this.viewer.removeDisposeListener ( this.disposeListener );
            this.viewer.dispose ();
            this.viewer = null;
        }
    }

    private Image createImage ( final String key )
    {
        try
        {
            final String uri = Activator.getDefault ().getPreferenceStore ().getString ( key );
            return this.manager.createImageWithDefault ( ImageDescriptor.createFromURL ( new URL ( uri ) ) );
        }
        catch ( final MalformedURLException e )
        {
            return this.manager.createImageWithDefault ( ImageDescriptor.getMissingImageDescriptor () );
        }
    }

    protected void showView ( final String id )
    {
        this.viewManager.showView ( id );
    }

    protected void internalDispose ()
    {
        if ( this.blinker != null )
        {
            this.blinker.dispose ();
            this.blinker = null;
        }
    }

    public void dispose ()
    {
        if ( this.button != null )
        {
            this.viewer.removeSummaryListener ( this );
            this.button.dispose ();
            this.button = null;
        }
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
            this.viewer = null;
        }
    }

    public void deactivate ()
    {
        if ( this.button != null )
        {
            this.button.setSelection ( false );
        }

        if ( this.descriptor.isLazyActivation () )
        {
            deactivateView ();
        }
    }

    public void activate ()
    {
        if ( this.button != null )
        {
            this.button.setSelection ( true );
        }

        if ( this.descriptor.isLazyActivation () )
        {
            activateView ( false );
        }
    }

    public void setFocus ()
    {
        this.viewer.setFocus ();
    }

    public Control getControl ()
    {
        return this.viewer;
    }

    protected void handleBlink ( final State state )
    {
        if ( this.button == null )
        {
            return;
        }

        switch ( state )
        {
            case ALARM_0:
                this.button.setImage ( this.imageAlarm0 );
                break;
            case ALARM_1:
                this.button.setImage ( this.imageAlarm1 );
                break;
            case DISCONNECTED:
            case ERROR:
                this.button.setImage ( this.imageInvalid );
                break;
            case MANUAL:
                this.button.setImage ( this.imageManual );
                break;
            case BLOCKED:
                this.button.setImage ( this.imageBlocked );
                break;
            case ALARM:
                this.button.setImage ( this.imageAlarm );
                break;
            case OK:
                this.button.setImage ( this.imageOk );
                break;
        }
    }

    @Override
    public void summaryChanged ( final SummaryInformation summary )
    {
        this.blinker.setState ( summary.isAlarm (), summary.isAckRequired (), summary.isManual (), !summary.isConnected (), summary.isError (), summary.isBlocked () );
    }
}
