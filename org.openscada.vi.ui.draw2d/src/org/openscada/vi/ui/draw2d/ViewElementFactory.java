package org.openscada.vi.ui.draw2d;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.model.VisualInterface.SymbolReference;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.model.VisualInterface.XYChild;
import org.openscada.vi.model.VisualInterface.XYContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewElementFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( ViewElementFactory.class );

    private final ResourceManager manager;

    private final Map<URI, Symbol> symbolCache = new HashMap<URI, Symbol> ();

    public ViewElementFactory ( final ResourceManager manager )
    {
        this.manager = manager;
    }

    public IFigure create ( final SymbolController controller, final Primitive element )
    {
        if ( element instanceof XYContainer )
        {
            return createXYLayout ( controller, (XYContainer)element );
        }
        else if ( element instanceof Text )
        {
            final Label label = new Label ( ( (Text)element ).getFormat () );
            controller.addElement ( element.getName (), label );
            return applyFigure ( (Text)element, label );
        }
        else if ( element instanceof Line )
        {
            return createLine ( controller, (Line)element );
        }
        else if ( element instanceof SymbolReference )
        {
            return createSymbolReference ( controller, (SymbolReference)element );
        }
        else if ( element instanceof Rectangle )
        {
            return createRectangle ( controller, (Rectangle)element );
        }
        return null;
    }

    protected IFigure createSymbolReference ( final SymbolController controller, final SymbolReference symbolReference )
    {
        final LayeredPane rootWrapper;

        if ( symbolReference.getZoom () != null )
        {
            rootWrapper = new ScalableLayeredPane ();
            ( (ScalableLayeredPane)rootWrapper ).setScale ( symbolReference.getZoom () );
        }
        else
        {
            rootWrapper = new LayeredPane ();
        }

        final URI uri = URI.createURI ( symbolReference.getUri () );
        final Symbol symbol = load ( uri );

        final Layer layer = new Layer ();
        layer.setLayoutManager ( new StackLayout () );

        rootWrapper.add ( layer );

        try
        {
            final Map<String, String> properties = new HashMap<String, String> ();
            properties.putAll ( convert ( symbolReference.getProperties () ) );
            createProperties ( controller, symbolReference, properties );

            // TODO: use class loader of providing bundle
            final SymbolController childController = new SymbolController ( controller, symbol, Activator.class.getClassLoader (), properties );

            final IFigure rootFigure = create ( childController, symbol.getRoot () );
            layer.add ( rootFigure );
        }
        catch ( final Exception e )
        {
            layer.add ( Helper.createErrorFigure ( e ) );
        }

        return rootWrapper;
    }

    private Map<? extends String, ? extends String> convert ( final EMap<String, String> properties )
    {
        final Map<String, String> p = new HashMap<String, String> ();
        if ( properties != null )
        {
            for ( final Map.Entry<String, String> entry : properties.entrySet () )
            {
                p.put ( entry.getKey (), entry.getValue () );
            }
        }
        return p;
    }

    private void createProperties ( final SymbolController controller, final SymbolReference symbolReference, final Map<String, String> currentProperties ) throws Exception
    {
        controller.createProperties ( "JavaScript", symbolReference.getOnCreateProperties (), currentProperties );
    }

    protected Symbol load ( final URI uri )
    {
        final Symbol symbol = this.symbolCache.get ( uri );
        if ( symbol != null )
        {
            return symbol;
        }

        logger.info ( "Loading: {}", uri ); //$NON-NLS-1$

        final ResourceSet resourceSet = new ResourceSetImpl ();

        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "vi", new XMIResourceFactoryImpl () ); //$NON-NLS-1$

        final Resource resource = resourceSet.getResource ( uri, true );

        for ( final EObject o : resource.getContents () )
        {
            if ( o instanceof Symbol )
            {
                this.symbolCache.put ( uri, (Symbol)o );
                return (Symbol)o;
            }
        }
        return null;
    }

    private IFigure createRectangle ( final SymbolController controller, final Rectangle element )
    {
        final PrecisionRectangle rect = new PrecisionRectangle ();
        rect.setPreciseSize ( element.getWidth (), element.getHeight () );
        final RectangleFigure fig = new RectangleFigure ();
        fig.setBounds ( rect );

        controller.addElement ( element.getName (), fig );

        return applyFigure ( element, fig );
    }

    private IFigure createLine ( final SymbolController controller, final Line element )
    {
        final PolylineShape polyline = new PolylineShape ();

        final PointList points = new PointList ();
        for ( final Position pos : element.getPoints () )
        {
            final Point p = new PrecisionPoint ( pos.getX (), pos.getY () );
            points.addPoint ( p );
        }
        polyline.setAntialias ( SWT.ON );
        polyline.setPoints ( points );

        polyline.setLineCap ( SWT.CAP_SQUARE );
        polyline.setLineWidth ( element.getLineWidth () );

        // set bounds from line data, expanding WTF
        polyline.setBounds ( points.getBounds ().expand ( 5, 5 ) );
        polyline.setOpaque ( true );

        controller.addElement ( element.getName (), polyline );

        return applyFigure ( element, polyline );
    }

    private org.eclipse.draw2d.geometry.Rectangle create ( final Position position )
    {
        final org.eclipse.draw2d.geometry.PrecisionRectangle rect = new org.eclipse.draw2d.geometry.PrecisionRectangle ();
        rect.setPreciseLocation ( position.getX (), position.getY () );
        rect.setPreciseSize ( -1, -1 );
        return rect;
    }

    protected IFigure createXYLayout ( final SymbolController controller, final XYContainer element )
    {
        final Figure pane = new Figure ();

        pane.setLayoutManager ( new XYLayout () );

        for ( final XYChild child : element.getChildren () )
        {
            final IFigure childFigure = create ( controller, child.getElement () );
            pane.add ( childFigure, create ( child.getPosition () ) );
        }

        controller.addElement ( element.getName (), pane );

        return pane;
    }

    protected IFigure applyFigure ( final org.openscada.vi.model.VisualInterface.Figure figureModel, final IFigure figure )
    {
        figure.setForegroundColor ( makeColor ( figureModel.getForegroundColor () ) );
        figure.setBackgroundColor ( makeColor ( figureModel.getBackgroundColor () ) );
        return figure;
    }

    private Color makeColor ( final String color )
    {
        if ( color == null )
        {
            return null;
        }

        if ( color.startsWith ( "#" ) )
        {
            if ( color.length () == 1 + 3 )
            {
                return this.manager.createColor ( makeColor ( color.substring ( 1, 2 ), color.substring ( 2, 3 ), color.substring ( 3, 4 ) ) );
            }
            else if ( color.length () >= 1 + 6 )
            {
                return this.manager.createColor ( makeColor ( color.substring ( 1, 3 ), color.substring ( 3, 5 ), color.substring ( 5, 7 ) ) );
            }
            return null;
        }
        return null;
    }

    private ColorDescriptor makeColor ( final String r, final String g, final String b )
    {
        return makeColor ( Integer.parseInt ( r, 16 ), Integer.parseInt ( g, 16 ), Integer.parseInt ( b, 16 ) );
    }

    private ColorDescriptor makeColor ( final int r, final int g, final int b )
    {
        return ColorDescriptor.createFrom ( new RGB ( r, g, b ) );
    }
}
