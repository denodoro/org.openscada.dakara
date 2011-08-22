package org.openscada.vi.ui.draw2d;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.ScalableLayeredPane;
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

        final int newWidth;
        final int newHeight;
        final double zoom;
        if ( bounds.width < bounds.height )
        {
            newWidth = bounds.width;
            newHeight = (int) ( newWidth * ar );
            zoom = newWidth / prefSize.preciseWidth ();
        }
        else
        {
            newHeight = bounds.height;
            newWidth = (int) ( newHeight / ar );
            zoom = newHeight / prefSize.preciseHeight ();
        }

        setZoom ( zoom );
    }

    private Dimension getPreferredSize ( final Rectangle bounds )
    {
        if ( this.symbol != null && this.symbol.getDesignSize () != null )
        {
            return new PrecisionDimension ( this.symbol.getDesignSize ().getWidth (), this.symbol.getDesignSize ().getHeight () );
        }
        return this.figure.getPreferredSize ( bounds.width, bounds.height );
    }

    private void setZoom ( final double zoom )
    {
        this.pane.setScale ( zoom );
    }

    protected void create ( final Symbol symbol, final ClassLoader classLoader )
    {
        this.pane = new ScalableLayeredPane ();
        final Layer layer = new Layer ();
        layer.setLayoutManager ( new StackLayout () );
        this.pane.add ( layer );

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

            layer.add ( this.figure = controller.getFigure () );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            layer.add ( this.figure = Helper.createErrorFigure ( e ) );
        }

        this.canvas.setContents ( this.pane );
    }

    protected Controller create ( final Primitive element )
    {
        return this.factory.create ( this.controller, element );
    }

    private void internalDispose ()
    {
        this.controller.dispose ();
        this.manager.dispose ();
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
