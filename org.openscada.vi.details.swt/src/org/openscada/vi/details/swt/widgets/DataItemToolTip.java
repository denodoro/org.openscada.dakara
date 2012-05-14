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

package org.openscada.vi.details.swt.widgets;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.openscada.vi.details.swt.Activator;
import org.openscada.vi.details.swt.data.DataItemDescriptor;

public class DataItemToolTip extends ToolTip
{
    private final DataItemDescriptor descriptor;

    private Label headerLabel;

    private StyledText text;

    private StyledString currentText;

    private final LocalResourceManager resourceManager;

    public DataItemToolTip ( final Control control, final int style, final boolean manualActivation, final DataItemDescriptor descriptor )
    {
        super ( control, style, manualActivation );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.descriptor = descriptor;
    }

    public DataItemToolTip ( final Control control, final DataItemDescriptor descriptor )
    {
        super ( control );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.descriptor = descriptor;
    }

    @Override
    protected Composite createToolTipContentArea ( final Event event, final Composite parent )
    {
        parent.setLayout ( new FillLayout () );
        final Composite wrapper = new Composite ( parent, SWT.NONE );

        wrapper.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                DataItemToolTip.this.resourceManager.dispose ();
            }
        } );

        final GridLayout layout = new GridLayout ( 2, false );
        layout.marginHeight = 10;
        layout.marginWidth = 10;
        layout.horizontalSpacing = 20;
        layout.verticalSpacing = 20;

        wrapper.setLayout ( layout );
        wrapper.setBackground ( wrapper.getDisplay ().getSystemColor ( SWT.COLOR_WHITE ) );
        wrapper.setBackgroundMode ( SWT.INHERIT_DEFAULT );

        this.headerLabel = new Label ( wrapper, SWT.NONE );
        this.headerLabel.setText ( this.descriptor.getItemId () );
        this.headerLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false, 2, 1 ) );
        this.headerLabel.setFont ( JFaceResources.getHeaderFont () );

        final Label warnIcon = new Label ( wrapper, SWT.NONE );
        warnIcon.setLayoutData ( new GridData ( SWT.CENTER, SWT.CENTER, false, false ) );
        warnIcon.setImage ( Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_WARN_BIG ) );

        this.text = new StyledText ( wrapper, SWT.MULTI );
        this.text.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        if ( this.currentText != null )
        {
            this.text.setText ( this.currentText.getString () );
            this.text.setStyleRanges ( this.currentText.getStyleRanges () );
        }

        return wrapper;
    }

    public void setText ( final StyledString text )
    {
        this.currentText = new StyledString ();
        this.currentText.append ( text );

        //don't set the text. this may lead to a widget disposed exception, if the Tooltip is currently not shown.
        /*        if ( this.text != null )
                {
                    this.text.setText ( text.getString () );
                    this.text.setStyleRanges ( text.getStyleRanges () );
                }
          */
    }

    public StyledString getCurrentText ()
    {
        return this.currentText;
    }
}
