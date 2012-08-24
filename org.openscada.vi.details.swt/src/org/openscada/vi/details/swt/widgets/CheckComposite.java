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
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataController;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckComposite extends GenericComposite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( CheckComposite.class );

    private final AttributeLockImage attributeLabel;

    private final DataController controller;

    private final Button button;

    private final String attribute;

    private final DataItemDescriptor descriptor;

    private final DataItemDescriptor readDescriptor;

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

        this.attributeLabel = new AttributeLockImage ( this, SWT.NONE, descriptor, null, null );
        this.button = new Button ( this, SWT.CHECK );
        this.button.addSelectionListener ( new SelectionAdapter () {

            @Override
            public void widgetSelected ( final SelectionEvent event )
            {
                CheckComposite.this.write ();
            }

        } );

        this.button.setText ( format );

        this.controller = new DataController ( this );

        if ( this.readDescriptor != null )
        {
            this.controller.registerItem ( "value", this.readDescriptor, true ); //$NON-NLS-1$
        }
        else if ( this.descriptor != null )
        {
            this.controller.registerItem ( "value", this.descriptor, true ); //$NON-NLS-1$
        }
    }

    protected void write ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        this.button.setEnabled ( false );
        if ( this.attribute == null || this.attribute.equals ( "" ) ) //$NON-NLS-1$
        {
            this.controller.writeOperation ( Variant.valueOf ( this.button.getSelection () ), this.descriptor );
        }
        else
        {
            final Map<String, Variant> map = new HashMap<String, Variant> ();
            map.put ( this.attribute, Variant.valueOf ( this.button.getSelection () ) );
            this.controller.writeOperation ( map, this.descriptor );
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

        Variant value;
        if ( this.attribute == null )
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
                value = values.get ( "value" ).getAttributes ().get ( this.attribute ); //$NON-NLS-1$
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
            return;
        }

        this.button.setSelection ( value.asBoolean () );
        this.button.setEnabled ( !state.isBlocked () );
    }
}
