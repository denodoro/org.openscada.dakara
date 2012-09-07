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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( LabelComposite.class );

    private final Label label;

    private final String format;

    public LabelComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format )
    {
        super ( parent, style, null, null );

        setLayout ( new FillLayout () );
        this.label = new Label ( this, SWT.NONE );

        this.format = format;
        if ( descriptor != null )
        {
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }
        else
        {
            this.label.setText ( format );
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

        if ( value == null )
        {
            return;
        }

        this.label.setText ( String.format ( this.format, value.getValue ().toLabel () ) );
        if ( state.isError () )
        {
            this.label.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_RED ) );
        }
        else
        {
            this.label.setBackground ( null );
        }
    }

}
