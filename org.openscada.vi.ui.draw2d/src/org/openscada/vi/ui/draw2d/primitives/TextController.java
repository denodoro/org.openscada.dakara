package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.ui.draw2d.SymbolController;

public class TextController extends FigureController
{
    private final Label figure;

    public TextController ( final SymbolController controller, final Text element, final ResourceManager manager )
    {
        super ( manager );
        this.figure = new Label ( element.getFormat () );
        controller.addElement ( element.getName (), this );
        applyStyles ( element );
    }

    protected void applyStyles ( final Text element )
    {
        super.applyStyles ( element );
        this.figure.setLabelAlignment ( convertAlignment ( element.getAlignment () ) );
    }

    protected int convertAlignment ( final String alignment )
    {
        if ( "CENTER".equals ( alignment ) )
        {
            return PositionConstants.CENTER;
        }
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

    public void setText ( final String text )
    {
        this.figure.setText ( text );
    }
}
