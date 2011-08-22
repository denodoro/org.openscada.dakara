/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2011 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

package org.openscada.vi.ui.draw2d.primitives;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Image;
import org.openscada.vi.ui.draw2d.SymbolController;

public class ImageController extends FigureController
{
    private final Label figure;

    private ImageDescriptor currentImage;

    public ImageController ( final FigureCanvas canvas, final SymbolController controller, final Image element, final ResourceManager manager )
    {
        super ( controller, manager );

        this.figure = new Label () {
            @Override
            public void addNotify ()
            {
                super.addNotify ();
                start ();
            }

            @Override
            public void removeNotify ()
            {
                stop ();
                super.removeNotify ();
            }
        };
        controller.addElement ( element.getName (), this );

        applyCommon ( element );
        setImage ( element.getUri () );
    }

    public void setImage ( final String uri )
    {
        if ( this.currentImage != null )
        {
            this.manager.destroyImage ( this.currentImage );
            this.currentImage = null;
        }

        if ( uri == null || uri.isEmpty () )
        {
            this.figure.setIcon ( null );
        }
        else
        {
            try
            {
                this.figure.setIcon ( this.manager.createImageWithDefault ( this.currentImage = ImageDescriptor.createFromURL ( new URL ( uri ) ) ) );
            }
            catch ( final MalformedURLException e )
            {
                this.figure.setIcon ( this.manager.createImageWithDefault ( ImageDescriptor.getMissingImageDescriptor () ) );
            }
        }
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }
}
