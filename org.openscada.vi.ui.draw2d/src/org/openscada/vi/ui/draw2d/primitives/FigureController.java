package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.openscada.vi.model.VisualInterface.Figure;

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
    }

    public void setBackgroundColor ( final String color )
    {
        getFigure ().setBackgroundColor ( makeColor ( color ) );
    }

    public void setForegroundColor ( final String color )
    {
        getFigure ().setForegroundColor ( makeColor ( color ) );
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
