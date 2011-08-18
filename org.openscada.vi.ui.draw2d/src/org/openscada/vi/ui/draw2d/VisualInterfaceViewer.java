package org.openscada.vi.ui.draw2d;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.ui.draw2d.primitives.Controller;

public class VisualInterfaceViewer extends Composite
{
    private final ViewElementFactory factory;

    private final FigureCanvas canvas;

    private final LocalResourceManager manager;

    private SymbolController controller;

    private Map<String, Object> scriptObjects;

    private Map<String, String> initialProperties;

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
        super ( parent, style );

        this.initialProperties = properties == null ? Collections.<String, String> emptyMap () : properties;

        this.scriptObjects = scriptObjects;
        this.manager = new LocalResourceManager ( JFaceResources.getResources () );

        this.factory = new ViewElementFactory ( this.manager );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                internalDispose ();
            }
        } );

        setLayout ( new FillLayout () );
        this.canvas = createCanvas ();

        try
        {
            final SymbolLoader loader = new SymbolLoader ( uri );
            this.canvas.setContents ( create ( loader.getSymbol (), loader.getClassLoader () ) );
            applyColor ( loader.getSymbol () );
        }
        catch ( final Exception e )
        {
            this.canvas.setContents ( Helper.createErrorFigure ( e ) );
        }

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
        return new FigureCanvas ( this );
    }

    public VisualInterfaceViewer ( final Composite parent, final int style, final Symbol symbol, final ClassLoader symbolClassLoader )
    {
        super ( parent, style );

        this.manager = new LocalResourceManager ( JFaceResources.getResources () );

        this.factory = new ViewElementFactory ( this.manager );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                internalDispose ();
            }
        } );

        setLayout ( new FillLayout () );
        this.canvas = createCanvas ();

        this.canvas.setContents ( create ( symbol, symbolClassLoader ) );
        applyColor ( symbol );
    }

    protected IFigure create ( final Symbol symbol, final ClassLoader classLoader )
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

            return controller.getFigure ();
        }
        catch ( final Exception e )
        {
            return Helper.createErrorFigure ( e );
        }
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
