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
import org.openscada.core.ui.styles.StateInformation;
import org.openscada.core.ui.styles.StyleBlinker;
import org.openscada.da.ui.connection.data.Item;
import org.openscada.da.ui.connection.data.Item.Type;
import org.openscada.vi.ui.user.Activator;
import org.openscada.vi.ui.user.preferences.PreferenceConstants;
import org.openscada.vi.ui.user.viewer.ViewInstance;
import org.openscada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.openscada.vi.ui.user.viewer.ViewManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToolBarNavigatorItem implements StateListener
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

    private StateProvider summaryProvider;

    private Image styleImage;

    private boolean lazySummary;

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
        this.button.setImage ( this.imageInactive );

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

        // initialize

        this.lazy = viewInstance.isLazy ();
        this.active = viewInstance.isActive ();

        this.blinker.setStyle ( null );

        // connect summary

        if ( this.descriptor.getSummaryConnectionId () != null && this.descriptor.getSummaryItemId () != null )
        {
            logger.info ( "Creating summary provider using item: {} - {}", this.descriptor.getSummaryConnectionId (), this.descriptor.getSummaryItemId () );
            this.summaryProvider = new ItemSummaryProvider ( this, new Item ( this.descriptor.getSummaryConnectionId (), this.descriptor.getSummaryItemId (), Type.ID ) );
        }
        else if ( this.instance instanceof org.openscada.vi.data.SummaryProvider )
        {
            logger.info ( "Creating summary provider using view summary information" );
            this.summaryProvider = new DelegatingSummaryProvider ( (org.openscada.vi.data.SummaryProvider)this.instance, this );
            this.lazySummary = true;
        }
    }

    public void dispose ()
    {
        if ( this.summaryProvider != null )
        {
            this.summaryProvider.dispose ();
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

        // update button image
        setButtonImage ( this.styleImage );
    }

    public void setActive ( final boolean active )
    {
        this.button.setSelection ( active );
        this.active = active;

        // update button image
        setButtonImage ( this.styleImage );
    }

    protected void handleUpdateStyle ( final Image image, final Color foreground, final Color background, final Font font )
    {
        logger.debug ( "Update Style" );

        this.styleImage = image;
        setButtonImage ( this.styleImage );
    }

    private void setButtonImage ( final Image image )
    {
        logger.debug ( "Setting button image for {} - image: {}, lazy: {}, active: {}", new Object[] { this.descriptor, image, this.lazy, this.active } );

        if ( image == null )
        {
            this.currentButtonImage = this.lazy && this.lazySummary && !this.active ? this.imageInactive : this.imageOk;
        }
        else
        {
            this.currentButtonImage = image;
        }

        if ( this.button != null && !this.button.isDisposed () )
        {
            this.button.setImage ( this.currentButtonImage );
        }
    }

    @Override
    public void stateChange ( final StateInformation stateInformation )
    {
        logger.debug ( "Summary state changed: {}", stateInformation );
        this.blinker.setStyle ( org.openscada.core.ui.styles.Activator.getDefaultStyleGenerator ().generateStyle ( stateInformation ) );
    }

}
