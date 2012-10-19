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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.openscada.core.Variant;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextInputMultiComposite extends WriteableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( TextInputMultiComposite.class );

    private final Text data;

    private final DataItemDescriptor descriptor;

    private final String attribute;

    private final Button button;

    private final Button buttonClear;

    private final ControlImage controlImage;

    public TextInputMultiComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String attribute, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, null, null, null, attribute, hdConnectionId, hdItemId );

        this.descriptor = descriptor;
        this.attribute = attribute;

        GridLayoutFactory.fillDefaults ().numColumns ( 5 ).margins ( 5, 5 ).spacing ( 0, 0 ).equalWidth ( false ).applyTo ( this );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );

        //        final Composite composite = new Composite ( this, SWT.NONE );
        //        composite.setLayout ( new FillLayout () );
        //        final ScrolledComposite scrolledComposite = new ScrolledComposite ( composite, SWT.V_SCROLL );
        this.data = new Text ( this, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.LEFT );
        this.data.addFocusListener ( new FocusListener () {

            @Override
            public void focusLost ( final FocusEvent arg0 )
            {
            }

            @Override
            public void focusGained ( final FocusEvent arg0 )
            {
                TextInputMultiComposite.this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_MAGENTA ) );
            }
        } );
        GridDataFactory.fillDefaults ().grab ( true, false ).hint ( 160, 50 ).applyTo ( this.data );

        this.button = new Button ( this, SWT.NONE );
        this.button.setText ( Messages.TextInputMultiComposite_send );
        this.button.addSelectionListener ( new SelectionListener () {

            @Override
            public void widgetSelected ( final SelectionEvent arg0 )
            {
                TextInputMultiComposite.this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );
                triggerCommand ( TextInputMultiComposite.this.data.getText () );
            }

            @Override
            public void widgetDefaultSelected ( final SelectionEvent arg0 )
            {
            }
        } );

        this.buttonClear = new Button ( this, SWT.NONE );
        this.buttonClear.setText ( Messages.TextInputMultiComposite_clear );
        this.buttonClear.addSelectionListener ( new SelectionListener () {

            @Override
            public void widgetSelected ( final SelectionEvent arg0 )
            {
                TextInputMultiComposite.this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );
                triggerCommand ( "" ); //$NON-NLS-1$
            }

            @Override
            public void widgetDefaultSelected ( final SelectionEvent arg0 )
            {
            }
        } );

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }
    }

    protected void triggerCommand ( final String string )
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        try
        {
            this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_DARK_YELLOW ) );
            if ( this.attribute == null || this.attribute.equals ( "" ) ) //$NON-NLS-1$
            {
                if ( string == null )
                {
                    this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.NULL );
                }
                else
                {
                    this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.valueOf ( string ) );
                }
            }
            else
            {
                final Map<String, Variant> map = new HashMap<String, Variant> ();
                if ( string == null )
                {
                    map.put ( this.attribute, Variant.NULL );
                }
                else
                {
                    map.put ( this.attribute, Variant.valueOf ( string ) );
                }
                this.registrationManager.startWriteAttributes ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), map );
            }
            getShell ().setFocus ();
        }
        catch ( final Exception e )
        {
            // FIXME: log error
        }
    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        setText ( this.data, values, this.attribute );
        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK ) );

        this.data.setEnabled ( !state.isBlocked () );
    }

    @Override
    protected void triggerCommand ()
    {
        triggerCommand ( this.data.getText () );
    }

}
