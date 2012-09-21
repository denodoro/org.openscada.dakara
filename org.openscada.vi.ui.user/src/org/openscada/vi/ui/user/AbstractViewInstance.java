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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.services.IEvaluationReference;
import org.eclipse.ui.services.IEvaluationService;
import org.openscada.core.ui.styles.StyleBlinker;
import org.openscada.vi.ui.user.preferences.PreferenceConstants;

public abstract class AbstractViewInstance implements ViewInstance
{

    private static final String PROP_DEFAULT_INSTANCE = "defaultInstance";

    private static final String PROP_LAZY = "lazy";

    private static final String PROP_VISIBLE = "visible";

    private IEvaluationReference visibileRef;

    private IEvaluationReference lazyRef;

    private IEvaluationReference defaultInstanceRef;

    private final IEvaluationService evaluationService;

    private boolean lazy = true;

    private boolean active;

    private boolean defaultInstance;

    private boolean visible;

    private final ViewManagerContext viewManagerContext;

    private final ToolBar toolbar;

    private boolean suppressActiveEvent = false;

    private ToolItem button;

    protected final ViewInstanceDescriptor descriptor;

    private final ViewManager viewManager;

    protected final StyleBlinker blinker;

    private final Image imageOk;

    private final Image imageInactive;

    private Image currentButtonImage;

    private final ResourceManager manager;

    public AbstractViewInstance ( final ViewManagerContext viewManagerContext, final ViewManager viewManager, final ResourceManager manager, final ViewInstanceDescriptor descriptor, final ToolBar toolBar, final IEvaluationService evaluationService )
    {
        this.viewManager = viewManager;
        this.viewManagerContext = viewManagerContext;
        this.evaluationService = evaluationService;
        this.toolbar = toolBar;
        this.manager = manager;
        this.descriptor = descriptor;

        // create resources

        this.imageOk = createImage ( PreferenceConstants.P_IMG_OK );
        this.imageInactive = createImage ( PreferenceConstants.P_IMG_INACTIVE );

        // create the blinker

        this.blinker = new StyleBlinker () {
            @Override
            public void update ( final Image image, final Color foreground, final Color background, final Font font )
            {
                handleUpdateStyle ( image, foreground, background, font );
            }
        };
        this.blinker.setStyle ( null );
    }

    public void init ()
    {
        attachVisibleExpression ( this.descriptor, this.evaluationService );
        attachLazyExpression ( this.descriptor, this.evaluationService );
        attachDefaultInstanceExpression ( this.descriptor, this.evaluationService );
    }

    protected abstract void activateView ();

    protected abstract void deactivateView ();

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

        if ( this.button != null )
        {
            this.button.dispose ();
            this.button = null;
        }
    }

    private void attachVisibleExpression ( final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        if ( descriptor.getVisibleExpression () != null )
        {
            this.visibileRef = evaluationService.addEvaluationListener ( descriptor.getVisibleExpression (), new IPropertyChangeListener () {

                @Override
                public void propertyChange ( final PropertyChangeEvent event )
                {
                    if ( PROP_VISIBLE.equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setVisibleState ( (Boolean)event.getNewValue () );
                    }
                }
            }, PROP_VISIBLE );
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
                    if ( PROP_LAZY.equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setLazy ( (Boolean)event.getNewValue () );
                    }
                }
            }, PROP_LAZY );
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
                    if ( PROP_DEFAULT_INSTANCE.equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setDefaultInstance ( (Boolean)event.getNewValue () );
                    }
                }
            }, PROP_DEFAULT_INSTANCE );
        }
        else
        {
            setDefaultInstance ( descriptor.isDefaultInstance () );
        }
    }

    @Override
    public ViewInstanceDescriptor getDescriptor ()
    {
        return this.descriptor;
    }

    protected void setDefaultInstance ( final boolean defaultInstance )
    {
        this.defaultInstance = defaultInstance;
        fireDefaultStateChanged ( defaultInstance );
    }

    @Override
    public boolean isDefaultInstance ()
    {
        return this.defaultInstance;
    }

    protected void setLazy ( final boolean lazy )
    {
        if ( this.lazy == lazy )
        {
            // if nothing changes, we pass
            return;
        }

        if ( this.lazy )
        {
            // if we were lazy, but are non-lazy now, we need to activate
            activateView ();
        }
        else if ( !this.active )
        {
            // if we were not lazy, are lazy now and are not active, we deactivate
            deactivateView ();
        }

        this.lazy = lazy;
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

    protected void fireActiveStateChanged ( final boolean state )
    {
        if ( this.viewManagerContext != null && !this.suppressActiveEvent )
        {
            this.viewManagerContext.viewActiveChanged ( this, state );
        }
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
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final org.eclipse.swt.events.SelectionEvent e )
                {
                    showView ( AbstractViewInstance.this.descriptor.getId () );
                };
            } );
            // set current state
            this.button.setImage ( this.currentButtonImage );
        }
    }

    protected void showView ( final String id )
    {
        this.viewManager.showView ( id );
    }

    private void disposeToolbarButton ()
    {
        if ( this.button != null )
        {
            this.button.dispose ();
            this.button = null;
        }
    }

    @Override
    public void reload ()
    {
        try
        {
            this.suppressActiveEvent = true;

            // dispose first
            deactivateView ();

            // now create
            activateView ();

            // notify that our control changed
            fireControlChanged ();
        }
        finally
        {
            this.suppressActiveEvent = false;
        }
    }

    private void fireControlChanged ()
    {
        if ( this.viewManagerContext != null )
        {
            this.viewManagerContext.viewControlChanged ( this );
        }
    }

    @Override
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

    @Override
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

    protected void handleUpdateStyle ( final Image image, final Color foreground, final Color background, final Font font )
    {
        if ( image == null )
        {
            this.currentButtonImage = this.lazy ? this.imageInactive : this.imageOk;
        }
        else
        {
            this.currentButtonImage = image;
        }

        if ( this.button == null )
        {
            return;
        }

        if ( !this.button.isDisposed () )
        {
            this.button.setImage ( this.currentButtonImage );
        }
    }

}
