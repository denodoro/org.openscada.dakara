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

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.details.model.DetailView.URLImageComponent;
import org.openscada.vi.details.swt.Activator;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URLImageLabel extends GenericComposite
{

    private static final Logger logger = LoggerFactory.getLogger ( URLImageLabel.class );

    private final URLImageComponent component;

    private final Label label;

    private final LocalResourceManager resourceManager;

    private String currentUrl;

    private Image currentImage;

    private final ControlImage controlImage;

    public URLImageLabel ( final Composite parent, final int style, final DataItemDescriptor descriptor, final URLImageComponent component )
    {
        super ( parent, style, null, null );
        this.component = component;

        final GridLayout layout = new GridLayout ( 2, false );
        layout.marginHeight = layout.marginWidth = 3;
        layout.horizontalSpacing = layout.verticalSpacing = 3;

        setLayout ( layout );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        this.label = new Label ( this, SWT.NONE );

        final GridData gd = new GridData ( SWT.CENTER, SWT.CENTER, true, true );
        if ( component.getHeight () != null && component.getWidth () != null )
        {
            gd.minimumHeight = component.getHeight ();
            gd.minimumWidth = component.getWidth ();
            // this.label.setLayoutData ( new GridData ( component.getWidth (), component.getHeight () ) );
            this.label.setSize ( component.getWidth (), component.getHeight () );
        }
        this.label.setLayoutData ( gd );

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false );
        }

        showUrl ( component.getFallbackImageUrl () );
    }

    @Override
    protected void handleDispose ()
    {
        if ( this.currentImage != null )
        {
            this.currentImage.dispose ();
            this.currentImage = null;
        }

        this.resourceManager.dispose ();
    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation aggregatedState )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        final DataItemValue value = values.get ( "value" ).getValue ();
        if ( value == null || !value.isConnected () || value.getValue () == null || value.getValue ().isNull () )
        {
            showUrl ( this.component.getFallbackImageUrl () );
        }
        else
        {
            try
            {
                showUrl ( format ( this.component.getImageUrl (), value.getValue ().asString ( "" ) ) );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to load image", e );
                showUrl ( this.component.getFallbackImageUrl () );
            }
        }
    }

    private String format ( final String imageUrl, final String string ) throws UnsupportedEncodingException
    {
        final StringTemplate template = new StringTemplate ( imageUrl );

        template.setAttribute ( "value", URLEncoder.encode ( string, "UTF-8" ) );
        template.setAttribute ( "properties", getProperties () );

        final String result = template.toString ();

        logger.debug ( "Formatted URL - '{}' -> '{}'", imageUrl, result );

        return result;
    }

    private Map<String, String> getProperties ()
    {
        if ( org.openscada.core.ui.connection.login.Activator.getDefault ().getSessionManager ().getSession () == null )
        {
            return Collections.emptyMap ();
        }

        if ( org.openscada.core.ui.connection.login.Activator.getDefault ().getSessionManager ().getSession ().getLoginContext () == null )
        {
            return Collections.emptyMap ();
        }

        return org.openscada.core.ui.connection.login.Activator.getDefault ().getSessionManager ().getSession ().getLoginContext ().getProperties ();
    }

    protected void showUrl ( final String url )
    {
        logger.debug ( "Requesting URL: {}", url );

        synchronized ( this )
        {
            if ( this.currentUrl != null && this.currentUrl.equals ( url ) )
            {
                logger.debug ( "Image did not change" );
                return;
            }

            this.currentUrl = url;
            Activator.getExecutor ().execute ( new Runnable () {
                @Override
                public void run ()
                {
                    try
                    {
                        processLoad ( url );
                    }
                    catch ( final Exception e )
                    {
                        logger.warn ( "Failed to load image", e );
                        try
                        {
                            URLImageLabel.this.currentUrl = URLImageLabel.this.component.getFallbackImageUrl ();
                            processLoad ( URLImageLabel.this.component.getFallbackImageUrl () );
                        }
                        catch ( final Exception e1 )
                        {
                            logger.warn ( "Failed to load fallback image", e1 );
                        }
                    }
                }
            } );
        }
    }

    private void processLoad ( final String stringUrl ) throws Exception
    {
        final ImageLoader loader = new ImageLoader ();

        final URL url = new URL ( stringUrl );

        final ImageData[] data = loader.load ( url.openStream () );

        logger.debug ( "Image loaded" );

        Display.getDefault ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                showImage ( stringUrl, data );
            }
        } );
    }

    protected void showImage ( final String url, final ImageData[] data )
    {
        if ( isDisposed () || getDisplay ().isDisposed () )
        {
            return;
        }

        if ( data == null || data.length <= 0 )
        {
            logger.info ( "No image data" );
            return;
        }

        synchronized ( this )
        {
            if ( url.equals ( this.currentUrl ) )
            {
                if ( this.currentImage != null )
                {
                    this.currentImage.dispose ();
                }
                this.currentImage = new Image ( getDisplay (), data[0] );
                this.label.setImage ( this.currentImage );
            }
            else
            {
                logger.warn ( "Image url changed - current: {}, our: {}", this.currentUrl, url );
            }
        }
    }

}
