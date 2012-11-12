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
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.openscada.core.Variant;
import org.openscada.eclipse.swt.CLabel;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.RegistrationManager.Listener;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.control.BlockControlImage;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextComposite extends ReadableComposite implements Listener
{
    private static final Logger logger = LoggerFactory.getLogger ( TextComposite.class );

    private final CLabel dataText;

    private final boolean date;

    private Font font;

    private final Map<String, String> map;

    private final ControlImage controlImage;

    private final BlockControlImage blockImage;

    public TextComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String decimal, final String attribute, int width, int height, final boolean date, final int textHeight, final String textMap, final String hdConnectionId, final String hdItemId, final String queryString )
    {
        super ( parent, style, format, decimal, attribute );

        this.date = date;

        this.map = stringToMap ( textMap );

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

        this.controlImage = new ControlImage ( this, this.registrationManager );
        Helper.createTrendButton ( this.controlImage, hdConnectionId, hdItemId, queryString );

        this.blockImage = new BlockControlImage ( this.controlImage, SWT.NONE, this.registrationManager );

        this.dataText = new CLabel ( this, SWT.MULTI | SWT.WRAP | SWT.RIGHT | SWT.SHADOW_IN );
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

        this.dataText.setText ( "" ); //$NON-NLS-1$
        final LabelOpenscadaDialog label = new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );
        final GridData labelData = new GridData ( SWT.FILL, SWT.CENTER, true, false );
        labelData.minimumWidth = 100;
        label.setLayoutData ( labelData );

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.blockImage.setBlockItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }
    }

    @Override
    protected void handleDispose ()
    {
        if ( this.font != null )
        {
            this.font.dispose ();
        }
        super.handleDispose ();
    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        if ( isDisposed () )
        {
            logger.trace ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        Variant value = null;
        if ( getAttribute () == null )
        {
            try
            {
                value = values.get ( "value" ).getValue ().getValue (); //$NON-NLS-1$
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
                value = values.get ( "value" ).getValue ().getAttributes ().get ( getAttribute () ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

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
            String convertedText = this.map.get ( value.asString ( "" ) );
            if ( convertedText == null )
            {
                convertedText = value.asString ( "" );
            }
            this.dataText.setText ( convertedText + " (" + value.asString ( "" ) + ")" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else if ( value.isDouble () )
        {
            this.dataText.setText ( getTextDecimal ( values, getAttribute () ) );
        }
        else
        {
            this.dataText.setText ( value.asString ( "" ) );
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
            logger.debug ( "Text map: {} {}", entry[0], entry[1] ); //$NON-NLS-1$
        }
        return map;
    }
}
