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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataController;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueSetComposite extends WriteableComposite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( ValueSetComposite.class );

    private final Composite label;

    private final Text data;

    private final DataController controller;

    private final Button setButton;

    private final Button resetButton;

    private final DataItemDescriptor diDescriptorText;

    private final DataItemDescriptor diDescriptorButtonSet;

    private final DataItemDescriptor diDescriptorButtonReset;

    private final AttributeImage attributeLabel;

    public ValueSetComposite ( final Composite parent, final int style, final DataItemDescriptor valueDescriptor, final DataItemDescriptor setDescriptor, final DataItemDescriptor resetDescriptor, final String format, final Double ceil, final Double floor, final String decimal, final String attribute, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, decimal, ceil, floor, attribute, hdConnectionId, hdItemId );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                ValueSetComposite.this.handleDispose ();
            }
        } );

        this.diDescriptorButtonReset = resetDescriptor;
        this.diDescriptorButtonSet = setDescriptor;
        this.diDescriptorText = valueDescriptor;

        this.controller = new DataController ( this );

        GridLayoutFactory.fillDefaults ().numColumns ( 4 ).margins ( 5, 5 ).spacing ( 0, 0 ).equalWidth ( false ).applyTo ( this );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this );

        this.label = new LabelOpenscadaDialog ( this, SWT.NONE, format, valueDescriptor );
        this.label.setToolTipText ( Messages.ValueSetComposite_valueDescriptor + valueDescriptor + Messages.ValueSetComposite_setDescriptor + setDescriptor + Messages.ValueSetComposite_resetDescriptor + resetDescriptor );

        this.layout ();
        final int width = this.label.getBounds ().width;
        GridDataFactory.fillDefaults ().grab ( true, false ).span ( 4, 1 ).hint ( width, 20 ).applyTo ( this.label );

        this.attributeLabel = new AttributeImage ( this, 0, this.diDescriptorText, hdConnectionId, hdItemId );

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

        if ( valueDescriptor != null )
        {
            this.controller.registerItem ( "value", valueDescriptor, true ); //$NON-NLS-1$
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
        this.controller.writeOperation ( Variant.valueOf ( Double.parseDouble ( this.data.getText ().replace ( ",", "." ) ) ), this.diDescriptorText ); //$NON-NLS-1$ //$NON-NLS-2$
        getShell ().setFocus ();
    }

    private void triggerCommand ( final SelectionEvent e )
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        if ( e.getSource ().equals ( this.setButton ) )
        {
            this.controller.writeOperation ( Variant.TRUE, this.diDescriptorButtonSet );
            //            Activator.getDefault ().writeConfirmed ( this.diDescriptorButtonSet.getConnectionInformation (), this.diDescriptorButtonSet.getItemId (), new Variant ( true ) );
        }
        else if ( e.getSource ().equals ( this.resetButton ) )
        {
            this.controller.writeOperation ( Variant.TRUE, this.diDescriptorButtonReset );
            //            Activator.getDefault ().writeConfirmed ( this.diDescriptorButtonReset.getConnectionInformation (), this.diDescriptorButtonReset.getItemId (), new Variant ( true ) );
        }
        else
        {
            logger.warn ( "Missing click item for write operation" ); //$NON-NLS-1$
        }
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
        this.attributeLabel.updateStatusView ( state );

        setCeil ( value );
        setFloor ( value );

        setTextDecimal ( this.data, value );

        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK ) );
    }

}
