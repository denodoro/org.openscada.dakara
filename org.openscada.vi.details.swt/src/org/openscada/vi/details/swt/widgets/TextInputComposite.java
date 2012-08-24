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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.openscada.core.Variant;
import org.openscada.core.VariantType;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextInputComposite extends WriteableComposite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( TextInputComposite.class );

    private final Text data;

    private final AttributeLockImage attributeLabel;

    private final DataItemDescriptor descriptor;

    public TextInputComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final Double ceil, final double floor, final String decimal, final String attribute, final DataItemDescriptor readDescriptor, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, decimal, ceil, floor, attribute, hdConnectionId, hdItemId );

        this.descriptor = descriptor;

        GridLayoutFactory.fillDefaults ().numColumns ( 3 ).margins ( 5, 5 ).spacing ( 0, 0 ).equalWidth ( false ).applyTo ( this );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this );

        this.attributeLabel = new AttributeLockImage ( this, 0, descriptor, hdConnectionId, hdItemId );

        this.data = new Text ( this, SWT.BORDER | SWT.SINGLE | SWT.CENTER );
        GridDataFactory.fillDefaults ().grab ( false, false ).hint ( 80, 10 ).applyTo ( this.data );
        addDefaultKeyListener ( this.data );

        new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );

        if ( readDescriptor != null )
        {
            this.controller.registerItem ( "value", readDescriptor, true ); //$NON-NLS-1$
        }
        else if ( descriptor != null )
        {
            this.controller.registerItem ( "value", descriptor, true ); //$NON-NLS-1$
        }
    }

    @Override
    protected void triggerCommand ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_DARK_YELLOW ) );
        if ( getAttribute () == null )
        {
            this.controller.writeOperation ( Variant.valueOf ( Double.parseDouble ( this.data.getText ().replace ( ",", "." ) ) ), this.descriptor ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            final Map<String, Variant> attributes = new HashMap<String, Variant> ();
            final Variant variant = Variant.valueOf ( Double.parseDouble ( this.data.getText ().replace ( ",", "." ) ) ); //$NON-NLS-1$ //$NON-NLS-2$
            attributes.put ( getAttribute (), variant );
            this.controller.writeOperation ( null, attributes, this.descriptor );
        }
        getShell ().setFocus ();
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
