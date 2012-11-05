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

package org.openscada.vi.ui.user.navigation.breadcrumb;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class BreadcrumbItem
{
    private final Composite wrapper;

    private final CLabel item;

    private final BreadcrumbBar parent;

    private final boolean horizontal;

    private final Map<String, Object> data = new HashMap<String, Object> ();

    public BreadcrumbItem ( final BreadcrumbBar parent, final boolean last )
    {
        this.horizontal = parent.isHorizontal ();

        this.parent = parent;
        this.wrapper = new Composite ( parent.getComposite (), SWT.NONE );

        parent.addChild ( this );

        final GridLayout layout = new GridLayout ( last ? 1 : 2, false );
        layout.marginHeight = layout.marginWidth = 0;
        layout.horizontalSpacing = layout.verticalSpacing = 0;

        if ( this.horizontal )
        {
            layout.horizontalSpacing = 5;
        }
        else
        {
            layout.verticalSpacing = 5;
        }

        this.wrapper.setLayout ( layout );

        this.item = new CLabel ( this.wrapper, SWT.NONE );
        this.item.setLayoutData ( new GridData ( SWT.CENTER, SWT.CENTER, true, true ) );

        if ( !last )
        {
            final Label label = new Label ( this.wrapper, SWT.NONE );
            if ( this.horizontal )
            {
                label.setText ( Messages.BreadcrumbNavigator_Splitter_Horizontal );
            }
            else
            {
                label.setText ( Messages.BreadcrumbNavigator_Splitter_Vertical );
            }
            label.setLayoutData ( new GridData ( SWT.CENTER, SWT.CENTER, true, true ) );
        }

        if ( this.horizontal )
        {
            this.wrapper.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.CENTER, false, true ) );
        }
        else
        {
            this.wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );
        }

        this.item.addMouseListener ( new MouseAdapter () {
            @Override
            public void mouseUp ( final MouseEvent e )
            {
                handleSelected ();
            }
        } );
    }

    protected void handleSelected ()
    {
        this.parent.selectItem ( this, true );
    }

    public void setText ( final String text )
    {
        this.item.setText ( text );
    }

    public void setImage ( final Image image )
    {
        this.item.setImage ( image );
    }

    public void dispose ()
    {
        this.parent.removeChild ( this );
        this.wrapper.dispose ();
    }

    public void setData ( final String key, final Object value )
    {
        this.data.put ( key, value );
    }

    public Object getData ( final String key )
    {
        return this.data.get ( key );
    }

    public void setSelected ( final boolean selected )
    {
        this.parent.selectItem ( this, selected );
    }

    void handleSetSelection ( final boolean selected )
    {
        if ( selected )
        {
            this.item.setBackground ( this.item.getDisplay ().getSystemColor ( SWT.COLOR_LIST_SELECTION ) );
            this.item.setForeground ( this.item.getDisplay ().getSystemColor ( SWT.COLOR_LIST_SELECTION_TEXT ) );

            this.item.setCursor ( null );
        }
        else
        {
            this.item.setBackground ( (Color)null );
            this.item.setForeground ( null );

            this.item.setCursor ( this.item.getDisplay ().getSystemCursor ( SWT.CURSOR_HAND ) );
        }
    }
}