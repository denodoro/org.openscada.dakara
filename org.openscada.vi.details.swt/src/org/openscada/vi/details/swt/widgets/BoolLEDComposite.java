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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoolLEDComposite extends GenericComposite implements ControllerListener
{
    private static final Logger logger = LoggerFactory.getLogger ( BoolLEDComposite.class );

    private final ResourceManager resourceManager;

    private final Label signalLabel;

    private final AttributeImage attributeLabel;

    private final boolean isAlarm;

    private final Image imageGreen;

    private final Image imageRed;

    private final Image imageGray;

    private final String attribute;

    public BoolLEDComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final boolean isAlarm, final String attribute )
    {
        super ( parent, style, null, null );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );
        this.imageGreen = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledGreen.png" ) ); //$NON-NLS-1$
        this.imageGray = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledGray.png" ) ); //$NON-NLS-1$
        this.imageRed = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledRed.png" ) ); //$NON-NLS-1$

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        layout.pack = true;
        setLayout ( layout );

        this.isAlarm = isAlarm;
        this.attribute = attribute;

        this.attributeLabel = new AttributeLockImage ( this, SWT.NONE, descriptor, null, null );
        this.signalLabel = new Label ( this, SWT.NONE );
        this.signalLabel.setImage ( this.imageGray );
        new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );

        if ( descriptor != null )
        {
            this.controller.registerItem ( "value", descriptor, true ); //$NON-NLS-1$
        }

        if ( Boolean.getBoolean ( "org.openscada.developer" ) )
        {

            if ( this.isAlarm == true )
            {
                this.signalLabel.setToolTipText ( "Red" );
            }
            else
            {
                this.signalLabel.setToolTipText ( "Green" );
            }
        }
    }

    @Override
    protected void handleDispose ()
    {
        this.resourceManager.dispose ();
        super.handleDispose ();
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

        if ( value.asBoolean () == true )
        {
            if ( this.isAlarm )
            {
                this.signalLabel.setImage ( this.imageRed );
            }
            else
            {
                this.signalLabel.setImage ( this.imageGreen );
            }
        }
        else
        {
            this.signalLabel.setImage ( this.imageGray );
        }
    }
}
