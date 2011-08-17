package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.openscada.vi.model.VisualInterface.Dimension;
import org.openscada.vi.model.VisualInterface.Figure;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;

public abstract class FigureController implements Controller
{
    private final ResourceManager manager;

    public FigureController ( final ResourceManager manager )
    {
        this.manager = manager;
    }

    protected void applyStyles ( final Figure figure )
    {
        setBackgroundColor ( figure.getBackgroundColor () );
        setForegroundColor ( figure.getForegroundColor () );

        setPreferredSize ( create ( figure.getSize () ) );
    }

    public void setPreferredSize ( final org.eclipse.draw2d.geometry.Dimension size )
    {
        getFigure ().setPreferredSize ( size );
    }

    public Dimension getPreferredSize ()
    {
        final Dimension dimension = VisualInterfaceFactory.eINSTANCE.createDimension ();
        final org.eclipse.draw2d.geometry.Dimension size = getFigure ().getPreferredSize ();
        dimension.setHeight ( size.preciseWidth () );
        dimension.setWidth ( size.preciseWidth () );
        return dimension;
    }

    public void setPreferredWidth ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( value );
        dim.setPreciseHeight ( getFigure ().getPreferredSize ().preciseHeight () );

        getFigure ().setPreferredSize ( dim );
    }

    public void setPreferredHeight ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( getFigure ().getPreferredSize ().preciseWidth () );
        dim.setPreciseHeight ( value );

        getFigure ().setPreferredSize ( dim );
    }

    public void setBackgroundColor ( final String color )
    {
        getFigure ().setBackgroundColor ( makeColor ( color ) );
    }

    public void setForegroundColor ( final String color )
    {
        getFigure ().setForegroundColor ( makeColor ( color ) );
    }

    protected org.eclipse.draw2d.geometry.Dimension create ( final Dimension dimension )
    {
        if ( dimension == null )
        {
            return null;
        }
        return new PrecisionDimension ( dimension.getWidth (), dimension.getHeight () );
    }

    protected Color makeColor ( final String color )
    {
        if ( color == null )
        {
            return null;
        }

        if ( color.startsWith ( "#" ) )
        {
            if ( color.length () == 1 + 3 )
            {
                return this.manager.createColor ( makeColor ( color.substring ( 1, 2 ), color.substring ( 2, 3 ), color.substring ( 3, 4 ) ) );
            }
            else if ( color.length () >= 1 + 6 )
            {
                return this.manager.createColor ( makeColor ( color.substring ( 1, 3 ), color.substring ( 3, 5 ), color.substring ( 5, 7 ) ) );
            }
            return null;
        }
        return null;
    }

    protected static ColorDescriptor makeColor ( final String r, final String g, final String b )
    {
        return makeColor ( Integer.parseInt ( r, 16 ), Integer.parseInt ( g, 16 ), Integer.parseInt ( b, 16 ) );
    }

    protected static ColorDescriptor makeColor ( final int r, final int g, final int b )
    {
        return ColorDescriptor.createFrom ( new RGB ( r, g, b ) );
    }
}
