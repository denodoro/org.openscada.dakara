package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.openscada.vi.model.VisualInterface.Alignment;

public class BorderChildController
{

    private final IFigure figure;

    public BorderChildController ( final IFigure childFigure )
    {
        this.figure = childFigure;
    }

    public void setAlignment ( final String alignment )
    {
        try
        {
            this.figure.getParent ().setConstraint ( this.figure, BorderContainerController.convert ( Alignment.valueOf ( alignment ) ) );
        }
        finally
        {
            this.figure.getParent ().setConstraint ( this.figure, null );
        }
    }
}
