package org.openscada.vi.ui.draw2d;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
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

    public VisualInterfaceViewer ( final Composite parent, final int style, final Symbol symbol )
    {
        super ( parent, style );

        this.factory = new ViewElementFactory ();

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                internalDispose ();
            }
        } );

        setLayout ( new FillLayout () );
        this.canvas = new FigureCanvas ( this );

        this.canvas.setContents ( create ( symbol ) );
    }

    protected IFigure create ( final Symbol symbol )
    {
        final IFigure fig = create ( symbol.getRoot () );
        return fig;
    }

    protected IFigure create ( final Primitive element )
    {
        return this.factory.create ( element );
    }

    private void internalDispose ()
    {
    }

}
