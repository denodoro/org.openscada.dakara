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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueSetComposite extends WriteableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ValueSetComposite.class );

    private final Composite label;

    private final Text data;

    private final Button setButton;

    private final Button resetButton;

    private final DataItemDescriptor diDescriptorText;

    private final DataItemDescriptor diDescriptorButtonSet;

    private final DataItemDescriptor diDescriptorButtonReset;

    private final ControlImage controlImage;

    public ValueSetComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final DataItemDescriptor setDescriptor, final DataItemDescriptor resetDescriptor, final String format, final Double ceil, final Double floor, final String decimal, final String attribute, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, decimal, ceil, floor, attribute, hdConnectionId, hdItemId );

        this.diDescriptorButtonReset = resetDescriptor;
        this.diDescriptorButtonSet = setDescriptor;
        this.diDescriptorText = descriptor;

        GridLayoutFactory.fillDefaults ().numColumns ( 4 ).margins ( 5, 5 ).spacing ( 0, 0 ).equalWidth ( false ).applyTo ( this );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this );

        this.label = new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );
        this.label.setToolTipText ( Messages.ValueSetComposite_valueDescriptor + descriptor + Messages.ValueSetComposite_setDescriptor + setDescriptor + Messages.ValueSetComposite_resetDescriptor + resetDescriptor );

        this.layout ();
        final int width = this.label.getBounds ().width;
        GridDataFactory.fillDefaults ().grab ( true, false ).span ( 4, 1 ).hint ( width, 20 ).applyTo ( this.label );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        this.data = new Text ( this, SWT.BORDER | SWT.SINGLE | SWT.CENTER );
        GridDataFactory.fillDefaults ().grab ( false, false ).hint ( 60, 10 ).applyTo ( this.data );
        addDefaultKeyListener ( this.data );

        this.setButton = new Button ( this, 0 );
        this.setButton.setText ( Messages.ValueSetComposite_set );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this.setButton );

        this.setButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                triggerCommand ( e );
            }
        } );

        this.resetButton = new Button ( this, 0 );
        this.resetButton.setText ( Messages.ValueSetComposite_reset );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this.resetButton );

        this.resetButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                triggerCommand ( e );
            }
        } );

        this.pack ();

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }

    }

    @Override
    protected void makeWarnDialog ()
    {
        super.makeWarnDialog ();
        this.setButton.setEnabled ( false );
        this.resetButton.setEnabled ( false );
    }

    @Override
    protected void triggerCommand ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_DARK_YELLOW ) );
        this.setButton.setEnabled ( true );
        this.resetButton.setEnabled ( true );
        try
        {
            this.registrationManager.startWrite ( this.diDescriptorText.getConnectionInformation (), this.diDescriptorText.getItemId (), Variant.valueOf ( Double.parseDouble ( this.data.getText ().replace ( ",", "." ) ) ) );
        }
        catch ( final Exception e )
        {
            // FIXME: log error
        }
        getShell ().setFocus ();
    }

    // FIXME: implement using anonymous classes to prevent "if"
    private void triggerCommand ( final SelectionEvent evt )
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        try
        {
            if ( evt.getSource ().equals ( this.setButton ) )
            {
                this.registrationManager.startWrite ( this.diDescriptorButtonSet.getConnectionInformation (), this.diDescriptorButtonSet.getItemId (), Variant.TRUE );
            }
            else if ( evt.getSource ().equals ( this.resetButton ) )
            {
                this.registrationManager.startWrite ( this.diDescriptorButtonReset.getConnectionInformation (), this.diDescriptorButtonReset.getItemId (), Variant.TRUE );
            }
            else
            {
                logger.warn ( "Missing click item for write operation" ); //$NON-NLS-1$
            }
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

        final DataItemValue value = values.get ( "value" ).getValue (); //$NON-NLS-1$

        setCeil ( value );
        setFloor ( value );

        setTextDecimal ( this.data, value );

        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK ) );
    }

}
