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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.openscada.core.NullValueException;
import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.openscada.eclipse.swt.CLabel;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataController;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextComposite extends ReadableComposite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( TextComposite.class );

    private final CLabel dataText;

    private final DataController controller;

    private final AttributeImage attributeLabel;

    private final boolean date;

    private Font font;

    private final Map<String, String> map;

    public TextComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String decimal, final String attribute, int width, int height, final boolean date, final int textHeight, final String textMap, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, decimal, attribute, hdConnectionId, hdItemId );

        this.date = date;

        this.map = stringToMap ( textMap );

        this.controller = new DataController ( this );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                TextComposite.this.handleDispose ();
            }
        } );

        if ( width == 0 )
        {
            width = 60;
        }
        if ( height == 0 )
        {
            height = SWT.DEFAULT;
        }

        final GridLayout layout = new GridLayout ( 3, false );

        setLayout ( layout );

        this.attributeLabel = new AttributeImage ( this, 0, descriptor, hdConnectionId, hdItemId );
        this.dataText = new CLabel ( this, SWT.MULTI | SWT.WRAP | SWT.RIGHT );
        if ( textHeight != 0 )
        {
            this.font = new Font ( getDisplay (), new FontData ( "Arial", textHeight, 0 ) ); //$NON-NLS-1$
            this.dataText.setFont ( this.font );
        }
        final GridData data = new GridData ( SWT.FILL, SWT.CENTER, false, false );
        data.widthHint = data.minimumWidth = width;
        data.heightHint = data.minimumHeight = height;

        this.dataText.setLayoutData ( data );
        this.dataText.setEnabled ( true );
        this.dataText.setEllipsis ( "…" );
        this.dataText.setEllipsisAlignment ( SWT.END );
        this.dataText.setBackground ( this.dataText.getDisplay ().getSystemColor ( SWT.COLOR_LIST_BACKGROUND ) );

        this.dataText.setText ( "" ); //$NON-NLS-1$
        final LabelOpenscadaDialog label = new LabelOpenscadaDialog ( this, SWT.WRAP, format, descriptor );
        final GridData labelData = new GridData ( SWT.FILL, SWT.CENTER, true, false );
        labelData.minimumWidth = 100;
        label.setLayoutData ( labelData );

        if ( descriptor != null )
        {
            this.controller.registerItem ( "value", descriptor, true ); //$NON-NLS-1$
        }
    }

    protected void handleDispose ()
    {
        this.controller.dispose ();
        if ( this.font != null )
        {
            this.font.dispose ();
        }
    }

    @Override
    public void updateView ( final Object key, final Map<Object, DataItemValue> values, final SCADAAttributes state )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        Variant value = null;
        if ( getAttribute () == null )
        {
            try
            {
                value = values.get ( "value" ).getValue (); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }
        else
        {
            try
            {
                value = values.get ( "value" ).getAttributes ().get ( getAttribute () ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        this.attributeLabel.updateStatusView ( state );

        if ( value == null )
        {
            this.dataText.setText ( "" ); //$NON-NLS-1$
        }
        else if ( this.date == true )
        {
            this.dataText.setText ( getDateAsString ( values, getAttribute () ) );
        }
        else if ( this.map != null )
        {
            try
            {
                String convertedText = this.map.get ( value.asString () );
                if ( convertedText == null )
                {
                    convertedText = value.asString ();
                }
                this.dataText.setText ( convertedText + " (" + value.asString () + ")" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            catch ( final NullValueException e )
            {
                this.dataText.setText ( "" ); //$NON-NLS-1$
                logger.info ( "No valid data to show value" ); //$NON-NLS-1$
            }
        }
        else if ( value.isDouble () )
        {
            this.dataText.setText ( getTextDecimal ( values, getAttribute () ) );
        }
        else
        {
            try
            {
                this.dataText.setText ( value.asString () );
            }
            catch ( final NullValueException e )
            {
                this.dataText.setText ( "" ); //$NON-NLS-1$
                logger.info ( "No valid data to show value" ); //$NON-NLS-1$
            }
        }
    }

    private Map<String, String> stringToMap ( final String string )
    {
        if ( string == null )
        {
            return null;
        }
        final Map<String, String> map = new HashMap<String, String> ();
        final String[] parts = string.split ( ";" ); //$NON-NLS-1$

        for ( int i = 0; i < parts.length; ++i )
        {
            final String[] entry = parts[i].split ( "=" ); //$NON-NLS-1$
            map.put ( entry[0], entry[1] );
            //            System.out.println ( "Text map: " + entry[0] + " " + entry[1] ); //for easily printing out list, only
            logger.debug ( "Text map: {} {}", entry[0], entry[1] ); //$NON-NLS-1$
        }
        return map;
    }
}
