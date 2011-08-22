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

package org.openscada.vi.ui.draw2d;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Dimension;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.model.VisualInterface.SymbolReference;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.model.VisualInterface.XYContainer;
import org.openscada.vi.ui.draw2d.primitives.Controller;
import org.openscada.vi.ui.draw2d.primitives.LineController;
import org.openscada.vi.ui.draw2d.primitives.RectangleController;
import org.openscada.vi.ui.draw2d.primitives.SymbolReferenceController;
import org.openscada.vi.ui.draw2d.primitives.TextController;
import org.openscada.vi.ui.draw2d.primitives.XYContainerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewElementFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( ViewElementFactory.class );

    private final ResourceManager manager;

    private final Map<URI, XMISymbolLoader> symbolCache = new HashMap<URI, XMISymbolLoader> ();

    private final FigureCanvas canvas;

    public ViewElementFactory ( final FigureCanvas canvas, final ResourceManager manager )
    {
        this.manager = manager;
        this.canvas = canvas;
    }

    public Controller create ( final SymbolController controller, final Primitive element )
    {
        if ( element instanceof XYContainer )
        {
            return new XYContainerController ( controller, (XYContainer)element, this );
        }
        else if ( element instanceof Text )
        {
            return new TextController ( this.canvas, controller, (Text)element, this.manager );
        }
        else if ( element instanceof Line )
        {
            return new LineController ( controller, (Line)element, this.manager );
        }
        else if ( element instanceof SymbolReference )
        {
            return new SymbolReferenceController ( controller, (SymbolReference)element, this, this.manager );
        }
        else if ( element instanceof Rectangle )
        {
            return new RectangleController ( controller, (Rectangle)element, this.manager );
        }
        logger.warn ( "Unknown element: {}", element );
        return null;
    }

    public org.eclipse.draw2d.geometry.Rectangle create ( final Position position, final Dimension dimension )
    {
        if ( position == null && dimension == null )
        {
            return null;
        }

        final org.eclipse.draw2d.geometry.PrecisionRectangle rect = new org.eclipse.draw2d.geometry.PrecisionRectangle ();

        if ( position != null )
        {
            rect.setPreciseLocation ( position.getX (), position.getY () );
        }
        else
        {
            rect.setPreciseLocation ( 0.0, 0.0 );
        }

        if ( dimension == null )
        {
            rect.setPreciseSize ( -1, -1 );
        }
        else
        {
            rect.setPreciseSize ( dimension.getWidth (), dimension.getHeight () );
        }
        return rect;
    }

    public XMISymbolLoader load ( final URI uri ) throws Exception
    {
        final XMISymbolLoader symbol = this.symbolCache.get ( uri );
        if ( symbol != null )
        {
            return symbol;
        }

        logger.info ( "Loading: {}", uri ); //$NON-NLS-1$

        return new XMISymbolLoader ( uri );
    }

}
