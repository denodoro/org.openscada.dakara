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

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.openscada.core.NotConvertableException;
import org.openscada.core.NullValueException;
import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ReadableComposite extends GenericComposite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( ReadableComposite.class );

    private DecimalFormat decimalFormat;

    private final String attribute;

    public ReadableComposite ( final Composite parent, final int style, final String format, final String decimal, final String attribute, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, null, null );

        this.attribute = attribute;
        if ( decimal == null )
        {
            this.decimalFormat = new DecimalFormat ( "0.0" ); //$NON-NLS-1$
        }
        else
        {
            this.decimalFormat = new DecimalFormat ( decimal );
        }

    }

    protected String getText ( final Map<Object, DataItemValue> values, final String attribute )
    {
        Variant value;

        if ( attribute == null )
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
                value = values.get ( "value" ).getAttributes ().get ( attribute ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        String ret;
        try
        {
            ret = value.asString ();
        }
        catch ( final NullValueException e )
        {
            ret = "null"; //$NON-NLS-1$
        }
        catch ( final NullPointerException e )
        {
            ret = "null"; //$NON-NLS-1$
        }
        return ret;
    }

    protected String getDateAsString ( final Map<Object, DataItemValue> values, final String attribute )
    {
        Variant value;

        if ( attribute == null )
        {
            try
            {
                value = values.get ( "value" ).getValue (); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                value = Variant.NULL;
                ;
            }
        }
        else
        {
            try
            {

                value = values.get ( "value" ).getAttributes ().get ( attribute ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
                ;
            }
        }

        Date date;
        try
        {
            date = new Date ( value.asLong () );
        }
        catch ( final NullValueException e )
        {
            date = new Date ( 0 );
            logger.error ( "value is null. can't convert to date: ", e ); //$NON-NLS-1$
        }
        catch ( final NotConvertableException e )
        {
            date = new Date ( 0 );
            logger.error ( "could not convert value to date: ", e ); //$NON-NLS-1$
        }
        return date.toString ();
    }

    protected String getTextDecimal ( final Map<Object, DataItemValue> values, final String attribute )
    {
        return getTextDecimal ( values.get ( "value" ), attribute );
    }

    protected String getTextDecimal ( final DataItemValue value, final String attribute )
    {
        return getTextDecimal ( value, attribute, 1.0 );
    }

    protected String getTextDecimal ( final DataItemValue value, final String attribute, final double factor )
    {
        Variant var;

        if ( attribute == null )
        {
            try
            {
                var = value.getValue ();
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                var = Variant.NULL;
            }
        }
        else
        {
            try
            {
                var = value.getAttributes ().get ( attribute );
                if ( var == null )
                {
                    //var may be null, if no manual value has been set
                    logger.info ( "no attribute" ); //$NON-NLS-1$
                    var = Variant.NULL;
                }
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                var = Variant.NULL;
            }
        }

        if ( value == null )
        {
            return "null"; //$NON-NLS-1$
        }

        String ret;
        try
        {
            if ( this.decimalFormat == null )
            {
                ret = var.asString ();
            }
            else
            {
                try
                {
                    ret = this.decimalFormat.format ( var.asDouble () * factor );
                }
                catch ( final NotConvertableException e )
                {
                    ret = "?"; //$NON-NLS-1$
                    logger.error ( "Could not convert and show double value: {}", e ); //$NON-NLS-1$
                }
            }
        }
        catch ( final NullValueException e )
        {
            ret = ""; //$NON-NLS-1$
            logger.info ( "No valid data to show value" ); //$NON-NLS-1$
        }

        return ret;
    }

    protected String getAttribute ()
    {
        return this.attribute;
    }
}
