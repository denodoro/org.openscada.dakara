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

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataController;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelComposite extends Composite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( LabelComposite.class );

    private final Label label;

    private final DataController controller;

    private final String format;

    public LabelComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format )
    {
        super ( parent, style );

        setLayout ( new FillLayout () );
        this.label = new Label ( this, SWT.NONE );

        this.format = format;
        this.controller = new DataController ( this );

        if ( descriptor != null )
        {
            this.controller.registerItem ( "value", descriptor, true ); //$NON-NLS-1$
        }
        else
        {
            this.label.setText ( format );
        }

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                LabelComposite.this.handleDispose ();
            }
        } );
    }

    protected void handleDispose ()
    {
        this.controller.dispose ();
    }

    @Override
    public void updateView ( final Object key, final Map<Object, DataItemValue> values, final SCADAAttributes state )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        final DataItemValue value = values.get ( "value" ); //$NON-NLS-1$

        if ( value == null )
        {
            return;
        }

        this.label.setText ( String.format ( this.format, value.getValue ().toLabel () ) );
        if ( state.isError () )
        {
            this.label.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_RED ) );
        }
        else
        {
            this.label.setBackground ( null );
        }
    }
}
