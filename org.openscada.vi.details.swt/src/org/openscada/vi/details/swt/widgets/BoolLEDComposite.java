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
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoolLEDComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( BoolLEDComposite.class );

    private final ResourceManager resourceManager;

    private final Label signalLabel;

    private final boolean expectedValue;

    private final boolean isAlarm;

    private final boolean isOnOff;

    private final Image imageGreen;

    private final Image imageRed;

    private final Image imageGray;

    private final Image imageOn;

    private final Image imageOff;

    private final String attribute;

    private final ControlImage controlImage;

    public BoolLEDComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final boolean expectedValue, final boolean isAlarm, final boolean isOnOff, final String attribute )
    {
        super ( parent, style, null, null );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );
        this.imageGreen = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledGreen.png" ) ); //$NON-NLS-1$
        this.imageGray = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledGray.png" ) ); //$NON-NLS-1$
        this.imageRed = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledRed.png" ) ); //$NON-NLS-1$
        this.imageOn = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/on.png" ) ); //$NON-NLS-1$
        this.imageOff = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/off.png" ) ); //$NON-NLS-1$

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        setLayout ( layout );

        this.expectedValue = expectedValue;
        this.isAlarm = isAlarm;
        this.isOnOff = isOnOff;
        this.attribute = attribute;

        this.controlImage = new ControlImage ( this, this.registrationManager );
        this.controlImage.setDetailItem ( descriptor.asItem () );

        this.signalLabel = new Label ( this, SWT.NONE );
        this.signalLabel.setImage ( this.imageGray );
        new LabelOpenscadaDialog ( this, SWT.NONE, format, descriptor );

        if ( descriptor != null )
        {
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }

        if ( Boolean.getBoolean ( "org.openscada.developer" ) ) //$NON-NLS-1$
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
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation summaryInformation )
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

        if ( this.isOnOff )
        {
            if ( value.asBoolean () )
            {
                this.signalLabel.setImage ( this.imageOn );
            }
            else
            {
                this.signalLabel.setImage ( this.imageOff );
            }
        }
        else
        {
            if ( value.asBoolean () == this.expectedValue )
            {
                this.signalLabel.setImage ( this.imageGray );
            }
            else
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
        }
    }
}
