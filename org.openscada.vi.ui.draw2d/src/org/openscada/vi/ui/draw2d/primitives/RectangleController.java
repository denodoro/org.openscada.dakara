package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.ui.draw2d.SymbolController;

public class RectangleController extends FigureController
{
    private final RectangleFigure figure;

    public RectangleController ( final SymbolController controller, final Rectangle element, final ResourceManager manager )
    {
        super ( controller, manager );
        final PrecisionRectangle rect = new PrecisionRectangle ();
        rect.setPreciseSize ( element.getWidth (), element.getHeight () );
        this.figure = new RectangleFigure ();
        this.figure.setBounds ( rect );

        controller.addElement ( element.getName (), this );

        applyCommon ( element );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }
}
