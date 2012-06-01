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
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.services.IEvaluationReference;
import org.eclipse.ui.services.IEvaluationService;
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

    private final Blinker blinker;

    private final Image imageAlarm0;

    private final Image imageAlarm1;

    private final Image imageInactive;

    private final Composite parent;

    private final ViewInstanceDescriptor descriptor;

    private final LinkedHashMap<String, Object> scriptObjects;

    private IEvaluationReference visibileRef;

    private IEvaluationReference lazyRef;

    private IEvaluationReference defaultInstanceRef;

    private final IEvaluationService evaluationService;

    private final ToolBar toolbar;

    private boolean visible;

    private State currentButtonState;

    private final ViewManagerContext viewManagerContext;

    private boolean lazy = true;

    private boolean active;

    private boolean defaultInstance;

    public ViewInstance ( final ViewManager viewManager, final ViewManagerContext viewManagerContext, final Composite parent, final ToolBar toolbar, final ViewInstanceDescriptor descriptor, final ResourceManager manager, final IEvaluationService evaluationService )
    {
        this.parent = parent;
        this.viewManager = viewManager;
        this.descriptor = descriptor;
        this.manager = manager;
        this.evaluationService = evaluationService;
        this.toolbar = toolbar;
        this.viewManagerContext = viewManagerContext;

        this.imageOk = createImage ( PreferenceConstants.P_IMG_OK );
        this.imageInvalid = createImage ( PreferenceConstants.P_IMG_INVALID );
        this.imageAlarm = createImage ( PreferenceConstants.P_IMG_ALARM );
        this.imageManual = createImage ( PreferenceConstants.P_IMG_MANUAL );
        this.imageBlocked = createImage ( PreferenceConstants.P_IMG_BLOCKED );
        this.imageAlarm0 = createImage ( PreferenceConstants.P_IMG_ALARM_0 );
        this.imageAlarm1 = createImage ( PreferenceConstants.P_IMG_ALARM_1 );
        this.imageInactive = createImage ( PreferenceConstants.P_IMG_INACTIVE );

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

        attachVisibleExpression ( descriptor, evaluationService );
        attachLazyExpression ( descriptor, evaluationService );
        attachDefaultInstanceExpression ( descriptor, evaluationService );
    }

    private void attachVisibleExpression ( final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        if ( descriptor.getVisibleExpression () != null )
        {
            this.visibileRef = evaluationService.addEvaluationListener ( descriptor.getVisibleExpression (), new IPropertyChangeListener () {

                @Override
                public void propertyChange ( final PropertyChangeEvent event )
                {
                    if ( "visible".equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setVisibleState ( (Boolean)event.getNewValue () );
                    }
                }
            }, "visible" );
        }
        else
        {
            setVisibleState ( true );
        }
    }

    private void attachLazyExpression ( final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        if ( descriptor.getLazyExpression () != null )
        {
            this.lazyRef = evaluationService.addEvaluationListener ( descriptor.getLazyExpression (), new IPropertyChangeListener () {

                @Override
                public void propertyChange ( final PropertyChangeEvent event )
                {
                    if ( "lazy".equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setLazy ( (Boolean)event.getNewValue () );
                    }
                }
            }, "lazy" );
        }
        else
        {
            setLazy ( false );
        }
    }

    private void attachDefaultInstanceExpression ( final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        if ( descriptor.getDefaultInstanceExpression () != null )
        {
            this.defaultInstanceRef = evaluationService.addEvaluationListener ( descriptor.getDefaultInstanceExpression (), new IPropertyChangeListener () {

                @Override
                public void propertyChange ( final PropertyChangeEvent event )
                {
                    if ( "defaultInstance".equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setDefaultInstance ( (Boolean)event.getNewValue () );
                    }
                }
            }, "defaultInstance" );
        }
        else
        {
            setDefaultInstance ( descriptor.isDefaultInstance () );
        }
    }

    protected void setDefaultInstance ( final boolean defaultInstance )
    {
        this.defaultInstance = defaultInstance;
        fireDefaultStateChanged ( defaultInstance );
    }

    public boolean isDefaultInstance ()
    {
        return this.defaultInstance;
    }

    protected void setLazy ( final boolean lazy )
    {
        if ( this.lazy == lazy )
        {
            return;
        }

        if ( this.lazy )
        {
            activateView ();
        }
        else if ( !this.active )
        {
            deactivateView ();
        }

        this.lazy = lazy;
    }

    public ViewInstanceDescriptor getDescriptor ()
    {
        return this.descriptor;
    }

    private void createToolbarButton ()
    {
        if ( this.button == null )
        {
            final int index = this.viewManagerContext.calculateToolbarIndex ( this.descriptor );

            if ( index < 0 )
            {
                return;
            }

            this.button = new ToolItem ( this.toolbar, SWT.RADIO, index );
            this.button.setText ( this.descriptor.getName () );
            this.button.setImage ( this.lazy ? this.imageInactive : this.imageOk );
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final org.eclipse.swt.events.SelectionEvent e )
                {
                    showView ( ViewInstance.this.descriptor.getId () );
                };
            } );
            setToolbarButtonState ( this.currentButtonState );
        }
    }

    private void disposeToolbarButton ()
    {
        if ( this.button != null )
        {
            this.button.dispose ();
            this.button = null;
        }
    }

    public boolean isVisible ()
    {
        return this.visible;
    }

    protected void setVisibleState ( final boolean state )
    {
        if ( this.visible == state )
        {
            return;
        }

        this.visible = state;

        if ( state )
        {
            createToolbarButton ();
        }
        else
        {
            disposeToolbarButton ();
        }

        fireVisibleStateChanged ( state );
    }

    private void fireVisibleStateChanged ( final boolean state )
    {
        if ( this.viewManagerContext != null )
        {
            this.viewManagerContext.viewVisibilityChanged ( this, state );
        }
    }

    private void fireDefaultStateChanged ( final boolean state )
    {
        if ( this.viewManagerContext != null )
        {
            this.viewManagerContext.viewDefaultChanged ( this, state );
        }
    }

    public void reload ()
    {
        // dispose first
        deactivateView ();

        // now create
        activateView ();
    }

    private void activateView ()
    {
        if ( this.viewer != null )
        {
            return;
        }

        this.viewer = new VisualInterfaceViewer ( this.parent, SWT.NONE, this.descriptor.getUri (), this.scriptObjects, this.descriptor.getProperties () );
        this.viewer.setZooming ( this.descriptor.getZooming () );
        this.viewer.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        // always add summary listener if we are active
        this.viewer.addSummaryListener ( this );
    }

    private void deactivateView ()
    {
        if ( this.viewer != null )
        {
            this.viewer.removeSummaryListener ( this );
            if ( this.button != null )
            {
                this.button.setImage ( this.imageInactive );
            }

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

    public void dispose ()
    {
        if ( this.visibileRef != null )
        {
            this.evaluationService.removeEvaluationListener ( this.visibileRef );
            this.visibileRef = null;
        }

        if ( this.lazyRef != null )
        {
            this.evaluationService.removeEvaluationListener ( this.lazyRef );
            this.lazyRef = null;
        }

        if ( this.defaultInstanceRef != null )
        {
            this.evaluationService.removeEvaluationListener ( this.defaultInstanceRef );
            this.defaultInstanceRef = null;
        }

        this.blinker.dispose ();

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
        this.active = false;

        if ( this.button != null )
        {
            this.button.setSelection ( false );
        }

        if ( this.lazy )
        {
            deactivateView ();
        }
    }

    public void activate ()
    {
        this.active = true;

        if ( this.button != null )
        {
            this.button.setSelection ( true );
        }

        if ( this.lazy )
        {
            activateView ();
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
        this.currentButtonState = state;
        setToolbarButtonState ( state );
    }

    private void setToolbarButtonState ( final State state )
    {
        if ( this.button == null )
        {
            return;
        }

        if ( state == null )
        {
            this.button.setImage ( this.lazy ? this.imageInactive : this.imageOk );
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
