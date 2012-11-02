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
package org.openscada.vi.ui.user.navigation;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.openscada.core.ui.styles.StyleBlinker;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.data.SummaryListener;
import org.openscada.vi.data.SummaryProvider;
import org.openscada.vi.ui.user.Activator;
import org.openscada.vi.ui.user.preferences.PreferenceConstants;
import org.openscada.vi.ui.user.viewer.ViewInstance;
import org.openscada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.openscada.vi.ui.user.viewer.ViewManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToolBarNavigatorItem implements SummaryListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ToolBarNavigatorItem.class );

    private ToolItem button;

    private final ViewManager viewManager;

    private final ResourceManager manager;

    private final Image imageOk;

    private final Image imageInactive;

    private final StyleBlinker blinker;

    private final ViewInstanceDescriptor descriptor;

    private final ToolBar toolbar;

    private Image currentButtonImage;

    private boolean lazy = true;

    private boolean active;

    private final ToolBarNavigator toolBarNavigator;

    private final ViewInstance instance;

    public ToolBarNavigatorItem ( final ToolBarNavigator toolBarNavigator, final ToolBar toolbar, final int index, final ViewManager viewManager, final ViewInstance viewInstance, final ResourceManager manager )
    {
        this.toolBarNavigator = toolBarNavigator;
        this.toolbar = toolbar;
        this.viewManager = viewManager;
        this.manager = manager;

        this.instance = viewInstance;
        this.descriptor = viewInstance.getDescriptor ();

        this.button = new ToolItem ( toolbar, SWT.RADIO, index );
        this.button.setText ( this.descriptor.getName () );

        this.button.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final org.eclipse.swt.events.SelectionEvent e )
            {
                showView ( ToolBarNavigatorItem.this.descriptor.getId () );
            };
        } );

        // create resources

        this.imageOk = createImage ( PreferenceConstants.P_IMG_OK );
        this.imageInactive = createImage ( PreferenceConstants.P_IMG_INACTIVE );

        // create the button

        createToolbarButton ();

        // create the blinker

        this.blinker = new StyleBlinker () {
            @Override
            public void update ( final Image image, final Color foreground, final Color background, final Font font )
            {
                handleUpdateStyle ( image, foreground, background, font );
            }
        };
        this.blinker.setStyle ( null );

        if ( this.instance instanceof SummaryProvider )
        {
            ( (SummaryProvider)this.instance ).addSummaryListener ( this );
            final SummaryInformation summary = ( (SummaryProvider)this.instance ).getSummary ();
            if ( summary != null )
            {
                this.blinker.setStyle ( org.openscada.core.ui.styles.Activator.getDefaultStyleGenerator ().generateStyle ( summary.getStateInformation () ) );
            }
        }
    }

    public void dispose ()
    {
        if ( this.instance instanceof SummaryProvider )
        {
            ( (SummaryProvider)this.instance ).removeSummaryListener ( this );
        }
        this.blinker.dispose ();
        this.button.dispose ();
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

    private void createToolbarButton ()
    {
        if ( this.button == null )
        {
            final int index = this.toolBarNavigator.calculateToolbarIndex ( this.descriptor );

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
                    showView ( ToolBarNavigatorItem.this.descriptor.getId () );
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

    public void setLazy ( final boolean lazy )
    {
        this.lazy = lazy;
    }

    public void setActive ( final boolean active )
    {
        this.button.setSelection ( active );
        this.active = active;
        if ( !active )
        {
            this.blinker.setStyle ( null );
        }
    }

    protected void handleUpdateStyle ( final Image image, final Color foreground, final Color background, final Font font )
    {
        if ( image == null )
        {
            this.currentButtonImage = this.lazy && !this.active ? this.imageInactive : this.imageOk;
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

    @Override
    public void summaryChanged ( final SummaryInformation summary )
    {
        logger.debug ( "Summary changed: {}", summary );
        this.blinker.setStyle ( org.openscada.core.ui.styles.Activator.getDefaultStyleGenerator ().generateStyle ( summary.getStateInformation () ) );
    }
}
