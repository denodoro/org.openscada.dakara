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
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;
import org.openscada.core.NotConvertableException;
import org.openscada.core.NullValueException;
import org.openscada.core.Variant;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressComposite extends ReadableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ProgressComposite.class );

    private final ProgressBar progressBar;

    private final Text text;

    //    private final Font font;

    private double max = 100.0;

    private double min = 0.0;

    private double factor = 1.0;

    private final int textWidth = 40;

    private final int textHeight = SWT.DEFAULT;

    //intended to be the width for the whole component. it should be easy to configure the width in the xmi.
    private int width = 100;

    private int progressWidth;

    private final ControlImage controlImage;

    public ProgressComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String decimal, final String attribute, final double max, final double min, final double factor, final int width, final String hdConnectionId, final String hdItemId, final String queryString )
    {
        super ( parent, style, format, decimal, attribute );

        if ( max != 0 )
        {
            this.max = max;
        }

        if ( min != 0 )
        {
            this.min = min;
        }

        if ( factor != 0 )
        {
            this.factor = factor;
        }

        if ( width > 0 )
        {
            this.width = width;
        }

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                ProgressComposite.this.handleDispose ();
            }
        } );

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 7;
        layout.pack = true;
        setLayout ( layout );

        this.progressWidth = this.width - this.textWidth - layout.spacing;
        if ( this.progressWidth < 1 )
        {
            this.progressWidth = 1;
        }

        this.controlImage = new ControlImage ( this, this.registrationManager );
        Helper.createTrendButton ( this.controlImage, hdConnectionId, hdItemId, queryString );

        this.progressBar = new ProgressBar ( this, SWT.NONE );
        //        this.progressBar.setSize ( this.progressWidth, this.textHeight );
        final RowData progressData = new RowData ( this.progressWidth, SWT.DEFAULT );
        this.progressBar.setLayoutData ( progressData );
        final int minimum = (int)Math.round ( this.min );
        final int maximum = (int)Math.round ( this.max );
        this.progressBar.setMinimum ( minimum );
        this.progressBar.setMaximum ( maximum );

        this.text = new Text ( this, SWT.MULTI | SWT.WRAP | SWT.RIGHT );
        //        final RowData rowData = new RowData ( 60, SWT.DEFAULT );
        //        this.font = new Font ( getDisplay (), new FontData ( "Arial", 10, 0 ) ); //$NON-NLS-1$
        //        this.text.setFont ( this.font );
        final RowData rowData = new RowData ( this.textWidth, this.textHeight );
        //        this.dataText.setAlignment ( SWT.RIGHT );
        this.text.setLayoutData ( rowData );
        this.text.setEnabled ( true );
        this.text.setEditable ( false );

        this.text.setText ( "" ); //$NON-NLS-1$
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
            this.text.setText ( "" ); //$NON-NLS-1$
        }
        else if ( value.isDouble () )
        {
            this.text.setText ( getTextDecimal ( values.get ( "value" ).getValue (), getAttribute (), this.factor ) );

            int progress = 0;
            try
            {
                progress = (int) ( value.asDouble () * this.factor ); //do not use Math.round. We want to see the ProgressBar be active until it reaches 100.0 percent. (I.e. Do not show inactive for 99.5 %).
            }
            catch ( final NullValueException e )
            {
                logger.warn ( "progress could not be set" );
            }
            catch ( final NotConvertableException e )
            {
                logger.error ( "value is not convertable. Can't set progress" );
            }
            this.progressBar.setSelection ( progress );
        }
        else
        //the ProgreesComposite supports double only at the moment
        {
            this.text.setText ( "" ); //$NON-NLS-1$
            this.progressBar.setSelection ( 0 );
        }
    }

}
