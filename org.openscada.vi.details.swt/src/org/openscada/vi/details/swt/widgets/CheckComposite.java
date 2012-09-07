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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.openscada.core.Variant;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( CheckComposite.class );

    private final Button button;

    private final String attribute;

    private final DataItemDescriptor descriptor;

    private final DataItemDescriptor readDescriptor;

    private final ControlImage controlImage;

    public CheckComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String attribute, final DataItemDescriptor readDescriptor )
    {
        super ( parent, style, null, null );

        this.attribute = attribute;
        this.descriptor = descriptor;
        this.readDescriptor = readDescriptor;

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        layout.pack = true;
        setLayout ( layout );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        this.button = new Button ( this, SWT.CHECK );
        this.button.addSelectionListener ( new SelectionAdapter () {

            @Override
            public void widgetSelected ( final SelectionEvent event )
            {
                CheckComposite.this.write ();
            }

        } );

        this.button.setText ( format );

        if ( this.readDescriptor != null )
        {
            this.controlImage.setDetailItem ( readDescriptor.asItem () );
            this.registrationManager.registerItem ( "value", readDescriptor.getItemId (), readDescriptor.getConnectionInformation (), false, false );
        }
        else if ( this.descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), readDescriptor.getConnectionInformation (), false, false );
        }
    }

    protected void write ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        try
        {
            this.button.setEnabled ( false );
            if ( this.attribute == null || this.attribute.equals ( "" ) ) //$NON-NLS-1$
            {
                this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.valueOf ( this.button.getSelection () ) );
            }
            else
            {
                final Map<String, Variant> map = new HashMap<String, Variant> ();
                map.put ( this.attribute, Variant.valueOf ( this.button.getSelection () ) );
                this.registrationManager.startWriteAttributes ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), map );
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

        Variant value;
        if ( this.attribute == null )
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
                value = values.get ( "value" ).getValue ().getAttributes ().get ( this.attribute ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        if ( value == null )
        {
            return;
        }

        this.button.setSelection ( value.asBoolean () );
        this.button.setEnabled ( !state.isBlocked () );
    }

}
