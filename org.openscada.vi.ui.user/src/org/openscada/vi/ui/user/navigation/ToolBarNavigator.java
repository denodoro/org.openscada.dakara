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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.openscada.vi.ui.user.viewer.ViewInstance;
import org.openscada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.openscada.vi.ui.user.viewer.ViewManager;
import org.openscada.vi.ui.user.viewer.ViewManagerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToolBarNavigator implements ViewManagerListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ToolBarNavigator.class );

    private final ToolBar toolbar;

    private final ViewManager viewManager;

    private final Map<ViewInstanceDescriptor, ToolBarNavigatorItem> itemMap = new HashMap<ViewInstanceDescriptor, ToolBarNavigatorItem> ();

    private final LocalResourceManager resourceManager;

    private final Set<ViewInstanceDescriptor> visibleDescriptors = new HashSet<ViewInstanceDescriptor> ();

    public ToolBarNavigator ( final Composite parent, final int style, final ViewManager viewManager )
    {
        this.viewManager = viewManager;
        this.toolbar = new ToolBar ( parent, style );
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( parent.getDisplay () ) );

        this.toolbar.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        viewManager.addViewManagerListener ( this );
    }

    public void dispose ()
    {
        this.toolbar.dispose ();
    }

    protected void handleDispose ()
    {
        this.resourceManager.dispose ();
    }

    public void setLayoutData ( final Object layoutData )
    {
        this.toolbar.setLayoutData ( layoutData );
    }

    public Control getControl ()
    {
        return this.toolbar;
    }

    protected boolean hasButton ( final ViewInstanceDescriptor descriptor )
    {
        return descriptor.getParentId () == null || descriptor.getParentId ().isEmpty ();
    }

    @Override
    public void viewVisibilityChanged ( final ViewInstance viewInstance, final boolean visible )
    {
        logger.debug ( "Visibility changed: {} - {}", viewInstance.getDescriptor (), visible );

        final ViewInstanceDescriptor descriptor = viewInstance.getDescriptor ();

        if ( !isMain ( descriptor ) )
        {
            return;
        }

        if ( visible )
        {
            this.visibleDescriptors.add ( descriptor );
            ToolBarNavigatorItem item = this.itemMap.get ( descriptor );
            if ( item == null )
            {
                final int index = calculateToolbarIndex ( descriptor );
                logger.info ( "Adding view at index {}", index );
                item = new ToolBarNavigatorItem ( this, this.toolbar, index, this.viewManager, viewInstance, this.resourceManager );
                this.itemMap.put ( descriptor, item );
                this.toolbar.getParent ().getParent ().layout ();
            }
        }
        else
        {
            this.visibleDescriptors.remove ( descriptor );
            final ToolBarNavigatorItem item = this.itemMap.remove ( descriptor );
            if ( item != null )
            {
                item.dispose ();
            }
        }

    }

    @Override
    public void viewLazynessChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "Lazyness changed: {} - {}", viewInstance.getDescriptor (), state );

        final ToolBarNavigatorItem item = this.itemMap.get ( viewInstance.getDescriptor () );
        if ( item != null )
        {
            item.setLazy ( state );
        }
    }

    @Override
    public void viewDefaultChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "Default changed: {} - {}", viewInstance.getDescriptor (), state );
    }

    @Override
    public void viewActiveChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "Active changed: {} - {}", viewInstance.getDescriptor (), state );

        final ToolBarNavigatorItem item = this.itemMap.get ( viewInstance.getDescriptor () );
        if ( item != null )
        {
            item.setActive ( state );
        }
    }

    @Override
    public void viewControlChanged ( final ViewInstance viewInstance )
    {
    }

    public int calculateToolbarIndex ( final ViewInstanceDescriptor descriptor )
    {
        if ( !isMain ( descriptor ) )
        {
            logger.debug ( "Has parent: {}", descriptor );
            return -1;
        }

        final List<ViewInstanceDescriptor> data = new ArrayList<ViewInstanceDescriptor> ( this.visibleDescriptors );

        // remove all views with a parent
        final Iterator<ViewInstanceDescriptor> i = data.iterator ();
        while ( i.hasNext () )
        {
            if ( !isMain ( i.next () ) )
            {
                logger.debug ( "{} has parent, remove: ", descriptor );
                i.remove ();
            }
        }

        data.add ( descriptor );
        Collections.sort ( data, ViewInstanceDescriptor.DESCRIPTOR_ORDER_COMPARATOR );

        logger.debug ( "Sort order: {}", data );

        final int result = data.indexOf ( descriptor );
        logger.debug ( "Index is: {}", result );
        return result;
    }

    protected boolean isMain ( final ViewInstanceDescriptor descriptor )
    {
        return descriptor.isMainView ();
    }

}
