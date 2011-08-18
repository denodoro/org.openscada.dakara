package org.openscada.vi.ui.draw2d;

import java.util.HashMap;
import java.util.Map;

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

    private final Map<URI, SymbolLoader> symbolCache = new HashMap<URI, SymbolLoader> ();

    public ViewElementFactory ( final ResourceManager manager )
    {
        this.manager = manager;
    }

    public Controller create ( final SymbolController controller, final Primitive element )
    {
        if ( element instanceof XYContainer )
        {
            return new XYContainerController ( controller, (XYContainer)element, this );
        }
        else if ( element instanceof Text )
        {
            return new TextController ( controller, (Text)element, this.manager );
        }
        else if ( element instanceof Line )
        {
            return new LineController ( controller, (Line)element, this.manager );
        }
        else if ( element instanceof SymbolReference )
        {
            return new SymbolReferenceController ( controller, (SymbolReference)element, this );
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
        if ( position == null )
        {
            return null;
        }

        final org.eclipse.draw2d.geometry.PrecisionRectangle rect = new org.eclipse.draw2d.geometry.PrecisionRectangle ();
        rect.setPreciseLocation ( position.getX (), position.getY () );
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

    public SymbolLoader load ( final URI uri ) throws Exception
    {
        final SymbolLoader symbol = this.symbolCache.get ( uri );
        if ( symbol != null )
        {
            return symbol;
        }

        logger.info ( "Loading: {}", uri ); //$NON-NLS-1$

        final SymbolLoader loader = new SymbolLoader ( uri );
        return loader;
    }

}
