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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.ui.databinding.AdapterHelper;
import org.openscada.vi.model.VisualInterface.Arc;
import org.openscada.vi.model.VisualInterface.BorderContainer;
import org.openscada.vi.model.VisualInterface.Connection;
import org.openscada.vi.model.VisualInterface.Dimension;
import org.openscada.vi.model.VisualInterface.Ellipse;
import org.openscada.vi.model.VisualInterface.FigureContainer;
import org.openscada.vi.model.VisualInterface.GridContainer;
import org.openscada.vi.model.VisualInterface.Image;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.model.VisualInterface.StackContainer;
import org.openscada.vi.model.VisualInterface.SymbolReference;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.model.VisualInterface.XYContainer;
import org.openscada.vi.ui.draw2d.loader.XMISymbolLoader;
import org.openscada.vi.ui.draw2d.primitives.ArcController;
import org.openscada.vi.ui.draw2d.primitives.BorderContainerController;
import org.openscada.vi.ui.draw2d.primitives.EllipseController;
import org.openscada.vi.ui.draw2d.primitives.FigureContainerController;
import org.openscada.vi.ui.draw2d.primitives.GridContainerController;
import org.openscada.vi.ui.draw2d.primitives.ImageController;
import org.openscada.vi.ui.draw2d.primitives.LineController;
import org.openscada.vi.ui.draw2d.primitives.RectangleController;
import org.openscada.vi.ui.draw2d.primitives.StackContainerController;
import org.openscada.vi.ui.draw2d.primitives.SymbolReferenceController;
import org.openscada.vi.ui.draw2d.primitives.TextController;
import org.openscada.vi.ui.draw2d.primitives.XYContainerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicViewElementFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( BasicViewElementFactory.class );

    private final ResourceManager manager;

    private final Map<URI, XMISymbolLoader> symbolCache = new HashMap<URI, XMISymbolLoader> ();

    private final FigureCanvas canvas;

    public BasicViewElementFactory ( final FigureCanvas canvas, final ResourceManager manager )
    {
        this.manager = manager;
        this.canvas = canvas;
    }

    public Controller create ( final SymbolController controller, final Primitive element ) throws Exception
    {
        if ( element == null )
        {
            StatusManager.getManager ().handle ( new Status ( IStatus.INFO, Activator.PLUGIN_ID, "Empty element found" ), StatusManager.LOG );
            return new Controller () {

                @Override
                public IFigure getFigure ()
                {
                    return new Label ( "" );
                }
            };
        }

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
        else if ( element instanceof Arc )
        {
            return new ArcController ( controller, (Arc)element, this.manager );
        }
        else if ( element instanceof SymbolReference )
        {
            return new SymbolReferenceController ( controller, (SymbolReference)element, this, this.manager );
        }
        else if ( element instanceof Rectangle )
        {
            return new RectangleController ( controller, (Rectangle)element, this.manager );
        }
        else if ( element instanceof Ellipse )
        {
            return new EllipseController ( controller, (Ellipse)element, this.manager );
        }
        else if ( element instanceof GridContainer )
        {
            return new GridContainerController ( controller, (GridContainer)element, this );
        }
        else if ( element instanceof BorderContainer )
        {
            return new BorderContainerController ( controller, (BorderContainer)element, this );
        }
        else if ( element instanceof FigureContainer )
        {
            return new FigureContainerController ( controller, (FigureContainer)element, this.manager, this );
        }
        else if ( element instanceof StackContainer )
        {
            return new StackContainerController ( controller, (StackContainer)element, this );
        }
        else if ( element instanceof Image )
        {
            return new ImageController ( this.canvas, controller, (Image)element, this.manager );
        }

        final ViewElementFactory factory = Activator.createFactory ( element );
        if ( factory != null )
        {
            return factory.create ( controller, element, this.manager, this );
        }

        throw new IllegalArgumentException ( String.format ( "Element type %s is unknown", element.eClass ().getName () ) );
    }

    public org.eclipse.draw2d.geometry.Rectangle create ( final Position position, final Dimension dimension )
    {
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

    public void createConnections ( final Layer layer, final SymbolController controller, final EList<Connection> connections )
    {
        if ( connections == null )
        {
            return;
        }

        for ( final Connection connection : connections )
        {
            final Controller start = AdapterHelper.adapt ( controller.getElement ( connection.getStart () ), Controller.class );
            final Controller end = AdapterHelper.adapt ( controller.getElement ( connection.getEnd () ), Controller.class );

            if ( start != null && end != null )
            {
                final PolylineConnection c = new PolylineConnection ();
                c.setSourceAnchor ( new ChopboxAnchor ( start.getFigure () ) );
                c.setTargetAnchor ( new ChopboxAnchor ( end.getFigure () ) );
                c.setAntialias ( SWT.ON );
                layer.add ( c );
            }
        }
    }
}
