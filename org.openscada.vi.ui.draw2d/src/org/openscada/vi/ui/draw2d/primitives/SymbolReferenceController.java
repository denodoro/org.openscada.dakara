package org.openscada.vi.ui.draw2d.primitives;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.openscada.vi.model.VisualInterface.SymbolReference;
import org.openscada.vi.ui.draw2d.Helper;
import org.openscada.vi.ui.draw2d.SymbolController;
import org.openscada.vi.ui.draw2d.SymbolLoader;
import org.openscada.vi.ui.draw2d.ViewElementFactory;

public class SymbolReferenceController implements Controller
{
    private final LayeredPane figure;

    public SymbolReferenceController ( final SymbolController controller, final SymbolReference symbolReference, final ViewElementFactory factory )
    {
        if ( symbolReference.getZoom () != null )
        {
            this.figure = new ScalableLayeredPane ();
            ( (ScalableLayeredPane)this.figure ).setScale ( symbolReference.getZoom () );
        }
        else
        {
            this.figure = new LayeredPane ();
        }

        final Layer layer = new Layer ();
        layer.setLayoutManager ( new StackLayout () );

        this.figure.add ( layer );

        try
        {

            final URI uri = URI.createURI ( symbolReference.getUri () );
            final SymbolLoader symbolLoader = factory.load ( uri );

            final Map<String, String> properties = new HashMap<String, String> ();
            properties.putAll ( convert ( symbolReference.getProperties () ) );
            createProperties ( controller, symbolReference, properties );

            final SymbolController childController = new SymbolController ( controller, symbolLoader.getSymbol (), symbolLoader.getClassLoader (), properties );

            final Controller elementController = factory.create ( childController, symbolLoader.getSymbol ().getRoot () );
            final IFigure rootFigure = elementController.getFigure ();
            layer.add ( rootFigure );

            // FIXME: register with parent controller
        }
        catch ( final Exception e )
        {
            layer.add ( Helper.createErrorFigure ( e ) );
        }
    }

    private void createProperties ( final SymbolController controller, final SymbolReference symbolReference, final Map<String, String> currentProperties ) throws Exception
    {
        controller.createProperties ( "JavaScript", symbolReference.getOnCreateProperties (), currentProperties );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
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

}
