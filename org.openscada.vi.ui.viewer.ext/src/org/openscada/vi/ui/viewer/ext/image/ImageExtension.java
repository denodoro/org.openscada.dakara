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
package org.openscada.vi.ui.viewer.ext.image;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.openscada.vi.ui.user.viewer.ViewManager;
import org.openscada.vi.ui.user.viewer.ext.ViewerExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageExtension implements ViewerExtension, IExecutableExtension
{

    private final static Logger logger = LoggerFactory.getLogger ( ImageExtension.class );

    private URL imageUrl;

    private Image image;

    @Override
    public Control create ( final Composite composite, final ViewManager viewManager, final boolean horizontal )
    {
        final Label label = new Label ( composite, SWT.NONE );

        try
        {
            this.image = new Image ( label.getDisplay (), this.imageUrl.openStream () );
            label.setImage ( this.image );
        }
        catch ( final IOException e )
        {
            label.setText ( "Failed to load image: " + e );
        }

        label.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                if ( ImageExtension.this.image != null )
                {
                    ImageExtension.this.image.dispose ();
                }
            }
        } );

        return label;
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        try
        {
            if ( data instanceof String )
            {
                this.imageUrl = new URL ( (String)data );
            }
            if ( data instanceof Hashtable<?, ?> )
            {
                this.imageUrl = new URL ( (String) ( (Hashtable<?, ?>)data ).get ( "url" ) );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to parse URL", e );
        }
    }
}
