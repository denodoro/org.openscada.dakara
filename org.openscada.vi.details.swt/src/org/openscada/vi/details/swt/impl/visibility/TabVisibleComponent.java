/*
 * This file is part of the openSCADA project
 * Copyright (C) 2011-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

package org.openscada.vi.details.swt.impl.visibility;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.openscada.vi.details.swt.impl.GroupTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A visibility component for TabFolders
 * <p>
 * The provided control will be disposed when this component is disposed.
 * </p>
 * 
 * @author Jens Reimann
 */
public class TabVisibleComponent implements VisibleComponent
{

    private final static Logger logger = LoggerFactory.getLogger ( TabVisibleComponent.class );

    private final TabFolder folder;

    private final Control control;

    private TabItem item;

    private final int index;

    private final GroupTab groupTab;

    public TabVisibleComponent ( final TabFolder folder, final int index, final GroupTab groupTab, final Control control )
    {
        this.folder = folder;
        this.index = index;
        this.control = control;
        this.groupTab = groupTab;
    }

    @Override
    public void show ()
    {
        logger.debug ( "Showing tab ... " );

        final int tabIndex = findIndex ();

        if ( tabIndex < 0 )
        {
            this.item = new TabItem ( this.folder, SWT.NONE );
            this.item.setData ( "order", this.index );
        }
        else
        {
            this.item = new TabItem ( this.folder, SWT.NONE, tabIndex );
            this.item.setData ( "order", this.index );
        }
        this.item.setText ( this.groupTab.getLabel () );
        this.item.setControl ( this.control );
    }

    private int findIndex ()
    {
        final TabItem[] items = this.folder.getItems ();
        for ( int i = 0; i < items.length; i++ )
        {
            final TabItem item = items[i];
            final int order = (Integer)item.getData ( "order" );
            if ( order > this.index )
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void hide ()
    {
        this.item.dispose ();
    }

    @Override
    public void create ()
    {
        show ();
    }

    @Override
    public void dispose ()
    {
        hide ();
        this.control.dispose ();
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        return this.groupTab.getDescriptors ();
    }

    @Override
    public void start ()
    {
        this.groupTab.start ();
    }

    @Override
    public void stop ()
    {
        this.groupTab.stop ();
    }

}
