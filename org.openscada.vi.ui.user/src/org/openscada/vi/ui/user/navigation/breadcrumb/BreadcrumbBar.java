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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class BreadcrumbBar
{
    private final Composite composite;

    private final boolean horizontal;

    private final ArrayList<BreadcrumbItem> items = new ArrayList<BreadcrumbItem> ();

    public interface BreadcrumbSelectionListener
    {
        public void selectionChanged ( BreadcrumbItem item );
    }

    private final Set<BreadcrumbSelectionListener> selectionListeners = new LinkedHashSet<BreadcrumbSelectionListener> ();

    public BreadcrumbBar ( final Composite parent, final int style )
    {
        this.composite = new Composite ( parent, SWT.NONE );
        this.composite.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
        this.horizontal = ( style & SWT.HORIZONTAL ) != 0;

        final GridLayout layout = new GridLayout ( 1, false );
        layout.marginHeight = layout.marginWidth = 0;
        layout.horizontalSpacing = layout.verticalSpacing = 0;

        if ( this.horizontal )
        {
            layout.marginWidth = 5;
            layout.horizontalSpacing = 5;
        }
        else
        {
            layout.marginHeight = 5;
            layout.verticalSpacing = 5;
        }

        this.composite.setLayout ( layout );
    }

    public void addSelectionListener ( final BreadcrumbSelectionListener listener )
    {
        this.selectionListeners.add ( listener );
    }

    public void removeSelectionListener ( final BreadcrumbSelectionListener listener )
    {
        this.selectionListeners.remove ( listener );
    }

    protected void fireSelectionEvent ( final BreadcrumbItem item )
    {
        for ( final BreadcrumbSelectionListener listener : this.selectionListeners )
        {
            SafeRunner.run ( new SafeRunnable () {
                @Override
                public void run () throws Exception
                {
                    listener.selectionChanged ( item );
                }
            } );
        }
    }

    protected void handleDispose ()
    {
        // free all resources
        this.selectionListeners.clear ();
    }

    public BreadcrumbItem[] getItems ()
    {
        return this.items.toArray ( new BreadcrumbItem[this.items.size ()] );
    }

    public void setSelectionIndex ( final int selectionIndex )
    {
        selectItem ( this.items.get ( selectionIndex ), true );
    }

    public void dispose ()
    {
        this.composite.dispose ();
    }

    Composite getComposite ()
    {
        return this.composite;
    }

    public Control getControl ()
    {
        return this.composite;
    }

    void addChild ( final BreadcrumbItem item )
    {
        this.items.add ( item );

        if ( this.horizontal )
        {
            ( (GridLayout)this.composite.getLayout () ).numColumns = this.items.size ();
        }
        this.composite.layout ();
    }

    void removeChild ( final BreadcrumbItem item )
    {
        this.items.remove ( item );

        if ( this.horizontal )
        {
            ( (GridLayout)this.composite.getLayout () ).numColumns = this.items.size ();
        }
        this.composite.layout ();
    }

    boolean isHorizontal ()
    {
        return this.horizontal;
    }

    public void layout ()
    {
        this.composite.layout ();
    }

    public void selectItem ( final BreadcrumbItem item, final boolean selected )
    {
        if ( !this.items.contains ( item ) )
        {
            return;
        }

        for ( final BreadcrumbItem otherItem : this.items )
        {
            if ( otherItem != item )
            {
                otherItem.handleSetSelection ( false );
            }
        }

        item.handleSetSelection ( selected );

        if ( selected )
        {
            fireSelectionEvent ( item );
        }
    }

}
