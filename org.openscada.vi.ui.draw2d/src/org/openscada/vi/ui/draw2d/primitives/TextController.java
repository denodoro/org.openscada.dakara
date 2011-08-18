package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Alignment;
import org.openscada.vi.model.VisualInterface.Orientation;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.ui.draw2d.SymbolController;

public class TextController extends FigureController
{
    private final Label figure;

    public TextController ( final SymbolController controller, final Text element, final ResourceManager manager )
    {
        super ( controller, manager );
        this.figure = new Label ( element.getText () );
        controller.addElement ( element.getName (), this );

        applyCommon ( element );
    }

    protected void applyCommon ( final Text element )
    {
        super.applyCommon ( element );
        this.figure.setTextAlignment ( convertAlignment ( element.getTextAlignment (), PositionConstants.CENTER ) );
        this.figure.setLabelAlignment ( convertAlignment ( element.getLabelAlignment (), PositionConstants.CENTER ) );
        this.figure.setIconAlignment ( convertAlignment ( element.getIconAlignment (), PositionConstants.CENTER ) );
        this.figure.setTextPlacement ( convertOrientation ( element.getTextPlacement (), PositionConstants.EAST ) );
    }

    private int convertOrientation ( final Orientation orientation, final int defaultValue )
    {
        if ( orientation == null )
        {
            return defaultValue;
        }
        else
        {
            return convertPosition ( orientation.getName (), defaultValue );
        }
    }

    private int convertAlignment ( final Alignment alignment, final int defaultValue )
    {
        if ( alignment == null )
        {
            return defaultValue;
        }
        else
        {
            return convertPosition ( alignment.getName (), defaultValue );
        }
    }

    protected int convertPosition ( final String position, final int defaultValue )
    {
        if ( "CENTER".equals ( position ) )
        {
            return PositionConstants.CENTER;
        }
        else if ( "LEFT".equals ( position ) )
        {
            return PositionConstants.LEFT;
        }
        else if ( "RIGHT".equals ( position ) )
        {
            return PositionConstants.RIGHT;
        }
        else if ( "TOP".equals ( position ) )
        {
            return PositionConstants.TOP;
        }
        else if ( "BOTTOM".equals ( position ) )
        {
            return PositionConstants.BOTTOM;
        }
        else if ( "EAST".equals ( position ) )
        {
            return PositionConstants.EAST;
        }
        else if ( "WEST".equals ( position ) )
        {
            return PositionConstants.WEST;
        }
        else if ( "NORTH".equals ( position ) )
        {
            return PositionConstants.NORTH;
        }
        else if ( "SOUTH".equals ( position ) )
        {
            return PositionConstants.SOUTH;
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
