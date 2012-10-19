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
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.openscada.core.Variant;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueComposite extends ReadableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ValueComposite.class );

    private final Label dataLabel;

    private final Boolean isDate;

    private final ControlImage controlImage;

    public ValueComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String decimal, final String attribute, final Boolean isDate, final String hdConnectionId, final String hdItemId, final String queryString )
    {
        super ( parent, style, format, decimal, attribute );

        this.isDate = isDate;

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 7;
        layout.pack = true;
        setLayout ( layout );

        this.controlImage = new ControlImage ( this, this.registrationManager );
        Helper.createTrendButton ( this.controlImage, hdConnectionId, hdItemId, queryString );

        this.dataLabel = new Label ( this, SWT.NONE );
        final RowData rowData = new RowData ( 80, SWT.DEFAULT );
        this.dataLabel.setAlignment ( SWT.RIGHT );
        this.dataLabel.setLayoutData ( rowData );
        this.dataLabel.setText ( "" ); //$NON-NLS-1$
        new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
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

        Variant value;

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

        if ( value.isDouble () )
        {
            this.dataLabel.setText ( getTextDecimal ( values, getAttribute () ) );
        }
        else if ( value.isString () )
        {
            this.dataLabel.setText ( getText ( values, getAttribute () ) );
        }
        else if ( value.isLong () )
        {
            if ( this.isDate == null )
            {
                this.dataLabel.setText ( getText ( values, getAttribute () ) );
            }
            else if ( this.isDate )
            {
                this.dataLabel.setText ( getDateAsString ( values, getAttribute () ) );
            }
            else
            {
                this.dataLabel.setText ( getText ( values, getAttribute () ) );
            }
        }
        else if ( value.isNull () )
        {
            this.dataLabel.setText ( "" ); //$NON-NLS-1$
        }
        else
        {
            this.dataLabel.setText ( getText ( values, getAttribute () ) );
        }
    }

}
