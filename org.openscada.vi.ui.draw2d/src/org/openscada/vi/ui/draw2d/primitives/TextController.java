package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Alignment;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.ui.draw2d.SymbolController;

public class TextController extends FigureController
{
    private final Label figure;

    public TextController ( final SymbolController controller, final Text element, final ResourceManager manager )
    {
        super ( manager );
        this.figure = new Label ( element.getText () );
        controller.addElement ( element.getName (), this );
        applyStyles ( element );
    }

    protected void applyStyles ( final Text element )
    {
        super.applyStyles ( element );
        this.figure.setTextAlignment ( convertAlignment ( element.getTextAlignment () ) );
        this.figure.setLabelAlignment ( convertAlignment ( element.getLabelAlignment () ) );
        this.figure.setIconAlignment ( convertAlignment ( element.getIconAlignment () ) );
    }

    private int convertAlignment ( final Alignment alignment )
    {
        if ( alignment == null )
        {
            return convertAlignment ( (String)null, PositionConstants.LEFT );
        }
        else
        {
            return convertAlignment ( alignment.getName (), PositionConstants.LEFT );
        }
    }

    protected int convertAlignment ( final String alignment, final int defaultValue )
    {
        if ( "CENTER".equals ( alignment ) )
        {
            return PositionConstants.CENTER;
        }
        else if ( "LEFT".equals ( alignment ) )
        {
            return PositionConstants.LEFT;
        }
        else if ( "RIGHT".equals ( alignment ) )
        {
            return PositionConstants.RIGHT;
        }
        else if ( "TOP".equals ( alignment ) )
        {
            return PositionConstants.TOP;
        }
        else if ( "BOTTOM".equals ( alignment ) )
        {
            return PositionConstants.BOTTOM;
        }

        return defaultValue;
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
