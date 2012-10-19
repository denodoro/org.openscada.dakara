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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.openscada.core.Variant;
import org.openscada.core.VariantType;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.control.BlockControlImage;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextInputComposite extends WriteableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( TextInputComposite.class );

    private final Text data;

    private final DataItemDescriptor descriptor;

    private final ControlImage controlImage;

    private final BlockControlImage blockImage;

    public TextInputComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final Double ceil, final double floor, final String decimal, final String attribute, final DataItemDescriptor readDescriptor, final String hdConnectionId, final String hdItemId, int width )
    {
        super ( parent, style, format, decimal, ceil, floor, attribute, hdConnectionId, hdItemId );
        this.descriptor = descriptor;

        if ( width == 0 )
        {
            width = 60;
        }

        final GridLayout layout = new GridLayout ( 3, false );

        setLayout ( layout );

        this.controlImage = new ControlImage ( this, this.registrationManager );
        this.blockImage = new BlockControlImage ( this.controlImage, SWT.NONE, this.registrationManager );
        Helper.createTrendButton ( this.controlImage, hdConnectionId, hdItemId );

        this.data = new Text ( this, SWT.BORDER | SWT.SINGLE | SWT.RIGHT );
        final GridData data = new GridData ( SWT.LEFT, SWT.CENTER, false, true );
        data.widthHint = data.minimumWidth = width;
        data.heightHint = data.minimumHeight = SWT.DEFAULT;

        this.data.setLayoutData ( data );
        this.data.setEnabled ( true );

        this.data.setText ( "" ); //$NON-NLS-1$
        final LabelOpenscadaDialog label = new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );
        final GridData labelData = new GridData ( SWT.FILL, SWT.CENTER, true, false );
        labelData.minimumWidth = 100;
        label.setLayoutData ( labelData );
        addDefaultKeyListener ( this.data );

        if ( descriptor != null )
        {
            if ( readDescriptor != null )
            {
                this.registrationManager.registerItem ( "value", readDescriptor.getItemId (), readDescriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
                this.registrationManager.registerItem ( "valueWrite", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
            }
            else
            {
                this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
            }
            this.blockImage.setBlockItem ( descriptor.asItem () );
            this.controlImage.setDetailItem ( descriptor.asItem () );
        }
    }

    @Override
    protected void triggerCommand ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        try
        {
            this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_DARK_YELLOW ) );
            if ( getAttribute () == null )
            {
                this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.valueOf ( Double.parseDouble ( this.data.getText ().replace ( ",", "." ) ) ) );
            }
            else
            {
                final Map<String, Variant> attributes = new HashMap<String, Variant> ();
                final Variant variant = Variant.valueOf ( Double.parseDouble ( this.data.getText ().replace ( ",", "." ) ) ); //$NON-NLS-1$ //$NON-NLS-2$
                attributes.put ( getAttribute (), variant );
                this.registrationManager.startWriteAttributes ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), attributes );
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

        final DataItemValue value = values.get ( "value" ).getValue (); //$NON-NLS-1$

        setCeil ( value );
        setFloor ( value );

        if ( !this.data.isFocusControl () )
        {
            this.data.setText ( getTextDecimal ( values, getAttribute () ) );
            //            this.setTextDecimal ( this.data, value );
            this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK ) );
            this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );
        }
        else
        {
            this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_YELLOW ) );
        }

        this.data.setEnabled ( !state.isBlocked () );
    }

    protected void writeSCADA ( final Variant value, final Map<String, Variant> attributes, final String type )
    {
        if ( type.equals ( VariantType.BOOLEAN.toString () ) )
        {

        }
    }
}
