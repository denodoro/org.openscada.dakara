package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.openscada.vi.model.VisualInterface.XYChild;
import org.openscada.vi.model.VisualInterface.XYContainer;
import org.openscada.vi.ui.draw2d.SymbolController;
import org.openscada.vi.ui.draw2d.ViewElementFactory;

public class XYContainerController implements Controller
{
    private final Figure figure;

    public XYContainerController ( final SymbolController controller, final XYContainer element, final ViewElementFactory factory )
    {
        this.figure = new Figure ();

        this.figure.setLayoutManager ( new XYLayout () );

        for ( final XYChild child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child.getElement () );
            final IFigure childFigure = elementController.getFigure ();
            this.figure.add ( childFigure, factory.create ( child.getPosition () ) );
        }

        controller.addElement ( element.getName (), this );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
