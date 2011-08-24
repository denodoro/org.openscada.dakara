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

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.ui.utils.status.StatusHelper;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.ui.draw2d.impl.ScalableLayeredPane;
import org.openscada.vi.ui.draw2d.loader.StaticSymbolLoader;
import org.openscada.vi.ui.draw2d.loader.SymbolLoader;
import org.openscada.vi.ui.draw2d.loader.XMISymbolLoader;
import org.openscada.vi.ui.draw2d.preferences.PreferenceConstants;
import org.openscada.vi.ui.draw2d.primitives.Controller;

public class VisualInterfaceViewer extends Composite
{
    private final ViewElementFactory factory;

    private final FigureCanvas canvas;

    private final LocalResourceManager manager;

    private SymbolController controller;

    private final Map<String, Object> scriptObjects;

    private final Map<String, String> initialProperties;

    private Boolean zooming;

    private ScalableLayeredPane pane;

    private IFigure figure;

    private Symbol symbol;

    private Layer layer;

    /**
     * Create a new viewer
     * @param parent the parent composite
     * @param style the composite style
     * @param uri the URI from which the root symbol should be loaded
     * @param scriptObjects optionally some script objects that get injected into the script context. May be <code>null</code>.
     * @param properties additional properties for symbol creation. May be <code>null</code>. These properties override the symbols properties.
     */
    public VisualInterfaceViewer ( final Composite parent, final int style, final URI uri, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, uri.toString (), scriptObjects, properties );
    }

    /**
     * Create a new viewer
     * @param parent the parent composite
     * @param style the composite style
     * @param uri the URI from which the root symbol should be loaded
     * @param scriptObjects optionally some script objects that get injected into the script context. May be <code>null</code>
     * @param properties additional properties for symbol creation. May be <code>null</code>. These properties override the symbols properties.
     */
    public VisualInterfaceViewer ( final Composite parent, final int style, final String uri, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, new XMISymbolLoader ( uri ), scriptObjects, properties );
    }

    public VisualInterfaceViewer ( final Composite parent, final int style, final Symbol symbol, final ClassLoader classLoader, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        this ( parent, style, new StaticSymbolLoader ( symbol, classLoader ), scriptObjects, properties );
    }

    public VisualInterfaceViewer ( final Composite parent, final int style, final SymbolLoader loader, final Map<String, Object> scriptObjects, final Map<String, String> properties )
    {
        super ( parent, style );

        this.initialProperties = properties == null ? Collections.<String, String> emptyMap () : properties;
        this.scriptObjects = scriptObjects;

        this.manager = new LocalResourceManager ( JFaceResources.getResources () );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                internalDispose ();
            }
        } );

        setLayout ( new FillLayout () );
        this.canvas = createCanvas ();

        this.factory = new ViewElementFactory ( this.canvas, this.manager );

        try
        {
            this.pane = new ScalableLayeredPane ();
            this.layer = new Layer ();
            this.layer.setLayoutManager ( new StackLayout () );
            this.pane.add ( this.layer );

            loader.load ();
            this.symbol = loader.getSymbol ();
            create ( loader.getSymbol (), loader.getClassLoader () );
            applyColor ( loader.getSymbol () );
        }
        catch ( final Exception e )
        {
            this.canvas.setContents ( Helper.createErrorFigure ( e ) );
        }
    }

    public boolean isZooming ()
    {
        if ( this.zooming == null )
        {
            return Activator.getDefault ().getPreferenceStore ().getBoolean ( PreferenceConstants.P_DEFAULT_ZOOMING );
        }
        else
        {
            return this.zooming;
        }
    }

    public void setZooming ( final Boolean zooming )
    {
        this.zooming = zooming;
    }

    private void applyColor ( final Symbol symbol )
    {
        final RGB color = org.openscada.vi.ui.draw2d.primitives.Helper.makeColor ( symbol.getBackgroundColor () );
        if ( color != null )
        {
            this.canvas.setBackground ( this.manager.createColor ( color ) );
        }
    }

    protected FigureCanvas createCanvas ()
    {
        final FigureCanvas canvas = new FigureCanvas ( this );

        addControlListener ( new ControlAdapter () {
            @Override
            public void controlResized ( final ControlEvent e )
            {
                handleResize ( getBounds () );
            }
        } );

        return canvas;
    }

    protected void handleResize ( final Rectangle bounds )
    {
        if ( !isZooming () )
        {
            setZoom ( 1.0 );
            return;
        }

        final Dimension prefSize = getPreferredSize ( bounds );

        final double ar = prefSize.preciseWidth () / prefSize.preciseHeight ();

        double newHeight = bounds.width / ar;
        final double zoom;

        if ( newHeight > bounds.height )
        {
            newHeight = bounds.height;
        }

        zoom = newHeight / prefSize.preciseHeight ();
        setZoom ( zoom );
    }

    private Dimension getPreferredSize ( final Rectangle bounds )
    {
        if ( this.symbol != null && this.symbol.getDesignSize () != null )
        {
            return new PrecisionDimension ( this.symbol.getDesignSize ().getWidth (), this.symbol.getDesignSize ().getHeight () );
        }
        else if ( this.figure != null )
        {
            return this.figure.getPreferredSize ( bounds.width, bounds.height );
        }
        else
        {
            return new PrecisionDimension ( bounds.width, bounds.height );
        }
    }

    private void setZoom ( final double zoom )
    {
        this.pane.setScale ( zoom );
    }

    protected void create ( final Symbol symbol, final ClassLoader classLoader )
    {

        try
        {
            final Map<String, String> properties = new HashMap<String, String> ( symbol.getProperties ().size () );
            for ( final Map.Entry<String, String> entry : symbol.getProperties ().entrySet () )
            {
                properties.put ( entry.getKey (), entry.getValue () );
            }
            properties.putAll ( this.initialProperties );

            this.controller = new SymbolController ( symbol, classLoader, properties, this.scriptObjects );

            final Controller controller = create ( symbol.getRoot () );

            this.controller.init ();

            this.layer.add ( this.figure = controller.getFigure () );

            this.factory.createConnections ( this.layer, this.controller, symbol.getConnections () );

        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            this.layer.add ( this.figure = Helper.createErrorFigure ( e ) );
        }

        this.canvas.setContents ( this.pane );
    }

    protected Controller create ( final Primitive element )
    {
        return this.factory.create ( this.controller, element );
    }

    private void internalDispose ()
    {
        if ( this.controller != null )
        {
            this.controller.dispose ();
        }
        if ( this.manager != null )
        {
            this.manager.dispose ();
        }
    }

    public void addSummaryListener ( final SummaryListener listener )
    {
        if ( this.controller != null )
        {
            this.controller.addSummaryListener ( listener );
        }
    }

    public void removeSummaryListener ( final SummaryListener listener )
    {
        if ( this.controller != null )
        {
            this.controller.removeSummaryListener ( listener );
        }
    }

}
