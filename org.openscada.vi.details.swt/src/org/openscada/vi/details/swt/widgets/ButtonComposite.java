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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.openscada.core.Variant;
import org.openscada.core.VariantEditor;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.model.DetailView.Registration;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.openscada.vi.details.swt.source.ValueSourceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ButtonComposite extends GenericComposite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( ButtonComposite.class );

    private final Button button;

    private final String format;

    private final Variant value;

    private final AttributeLockImage attributeLabel;

    private final DataItemDescriptor writeDescriptor;

    private final ValueSourceController active;

    private final String attribute;

    private Font myFont;

    public ButtonComposite ( final Composite parent, final int style, final DataItemDescriptor readDescriptor, final DataItemDescriptor writeDescriptor, final String format, final String value, final ValueSourceController active, final Collection<Registration> registrations, final Map<String, String> properties, final String attribute, final int textHeight )
    {
        super ( parent, style, registrations, properties );

        this.attribute = attribute;

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 2;
        layout.pack = true;
        setLayout ( layout );

        this.attributeLabel = new AttributeLockImage ( this, SWT.NONE, writeDescriptor, null, null );

        if ( textHeight != 0 )
        {
            this.button = new Button ( this, SWT.PUSH | SWT.FLAT );
            this.myFont = new Font ( getDisplay (), new FontData ( "Arial", textHeight, 0 ) ); //$NON-NLS-1$
            this.button.setFont ( this.myFont );
        }
        else
        {
            this.button = new Button ( this, SWT.PUSH );
        }

        //        setLayout ( new FillLayout () );

        this.active = active;

        this.format = format;

        if ( value != null )
        {
            final VariantEditor ve = new VariantEditor ();
            ve.setAsText ( value );
            this.value = (Variant)ve.getValue ();
        }
        else
        {
            this.value = null;
        }

        if ( readDescriptor != null )
        {
            this.controller.registerItem ( "value", readDescriptor, true ); //$NON-NLS-1$
        }
        else
        {
            this.controller.registerItem ( "value", writeDescriptor, true ); //$NON-NLS-1$
            this.button.setText ( format );
        }
        this.writeDescriptor = writeDescriptor;
        this.button.setToolTipText ( "Read descriptor: " + readDescriptor + "\nWrite descriptor: " + writeDescriptor ); //$NON-NLS-1$ //$NON-NLS-2$

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                ButtonComposite.this.handleDispose ();
            }
        } );

        this.button.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                ButtonComposite.this.handleButton ();
            }
        } );
    }

    protected void handleButton ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        if ( this.attribute == null )
        {
            this.controller.writeOperation ( this.value, this.writeDescriptor );
        }
        else
        {
            final Map<String, Variant> attributes = new HashMap<String, Variant> ();
            attributes.put ( this.attribute, this.value );
            this.controller.writeOperation ( null, attributes, this.writeDescriptor );
        }
    }

    protected void handleDispose ()
    {
        this.controller.dispose ();
    }

    @Override
    public void updateView ( final Object key, final Map<Object, DataItemValue> values, final SCADAAttributes state )
    {
        if ( this.button.isDisposed () )
        {
            return;
        }

        if ( this.active != null )
        {
            this.active.updateData ( values, state );
            this.button.setEnabled ( this.active.value ().getValue ().asBoolean () && !state.isBlockedNative () );
        }
        else
        {
            if ( state == null )
            {
                this.button.setEnabled ( true );
            }
            else
            {

                if ( state.isBlockedNative () != null )
                {
                    this.button.setEnabled ( !state.isBlockedNative () );
                }
                else
                {
                    this.button.setEnabled ( true );
                }
            }
        }

        this.attributeLabel.updateStatusView ( state );

        final DataItemValue value = values.get ( "value" ); //$NON-NLS-1$

        if ( value == null )
        {
            return;
        }

        this.button.setText ( String.format ( this.format, value.getValue ().toLabel () ) );
        logger.info ( "update View for ButtonComposite: {}", this.writeDescriptor ); //$NON-NLS-1$
    }
}
