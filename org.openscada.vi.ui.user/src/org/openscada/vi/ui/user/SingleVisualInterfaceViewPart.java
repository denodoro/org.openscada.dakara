/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2011 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.part.ViewPart;

public class SingleVisualInterfaceViewPart extends ViewPart implements ViewManager
{

    private Composite viewHolder;

    private ToolBar toolBar;

    private final Map<String, ViewInstance> instances = new LinkedHashMap<String, ViewInstance> ( 1 );

    private ViewInstance currentInstance;

    private StackLayout stackLayout;

    private ResourceManager manager;

    public SingleVisualInterfaceViewPart ()
    {
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.manager = new LocalResourceManager ( JFaceResources.getResources () );

        parent.setLayout ( new FillLayout () );
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        final GridLayout layout = new GridLayout ( 1, true );
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        layout.marginHeight = layout.marginWidth = 0;
        wrapper.setLayout ( layout );

        this.toolBar = new ToolBar ( wrapper, SWT.HORIZONTAL | SWT.WRAP );
        this.toolBar.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );

        this.viewHolder = new Composite ( wrapper, SWT.NONE );
        this.viewHolder.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        this.viewHolder.setLayout ( this.stackLayout = new StackLayout () );
        for ( final ViewInstanceDescriptor descriptor : Activator.getDescriptors () )
        {
            addView ( descriptor );
            if ( descriptor.isDefaultInstance () )
            {
                showView ( descriptor.getId () );
            }
        }
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        this.manager.dispose ();
    }

    private void addView ( final ViewInstanceDescriptor descriptor )
    {
        final ViewInstance instance = new ViewInstance ( this, this.viewHolder, this.toolBar, descriptor, this.manager );
        this.instances.put ( descriptor.getId (), instance );
    }

    @Override
    public void showView ( final String id )
    {
        final ViewInstance instance = this.instances.get ( id );
        if ( instance == null )
        {
            return;
        }
        if ( this.currentInstance == instance )
        {
            return;
        }

        if ( this.currentInstance != null )
        {
            this.currentInstance.deactivate ();
        }

        this.currentInstance = instance;
        this.currentInstance.activate ();

        this.stackLayout.topControl = this.currentInstance.getControl ();
        this.viewHolder.layout ();
    }

    @Override
    public void setFocus ()
    {
        if ( this.currentInstance != null )
        {
            this.currentInstance.setFocus ();
        }
    }

}
