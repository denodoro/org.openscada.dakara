package org.openscada.vi.ui.draw2d;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Symbol;

public class VisualInterfaceViewer extends Composite
{
    private final ViewElementFactory factory;

    private final FigureCanvas canvas;

    private final LocalResourceManager manager;

    private SymbolController controller;

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
        this.canvas = new FigureCanvas ( this );

        this.canvas.setContents ( create ( symbol, symbolClassLoader ) );
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

            this.controller = new SymbolController ( symbol, classLoader, properties );

            final IFigure fig = create ( symbol.getRoot () );

            this.controller.init ();
            return fig;
        }
        catch ( final Exception e )
        {
            return Helper.createErrorFigure ( e );
        }

    }

    protected IFigure create ( final Primitive element )
    {
        return this.factory.create ( this.controller, element );
    }

    private void internalDispose ()
    {
        this.controller.dispose ();
        this.manager.dispose ();
    }

}
