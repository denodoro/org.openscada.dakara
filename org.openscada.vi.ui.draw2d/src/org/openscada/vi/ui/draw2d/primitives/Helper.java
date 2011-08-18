package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.swt.graphics.RGB;

public final class Helper
{
    private Helper ()
    {
    }

    public static RGB makeColor ( final String color )
    {
        if ( color == null )
        {
            return null;
        }

        if ( color.startsWith ( "#" ) )
        {
            if ( color.length () == 1 + 3 )
            {
                return makeRGB ( color.substring ( 1, 2 ) + "0", color.substring ( 2, 3 ) + "0", color.substring ( 3, 4 ) + "0" );
            }
            else if ( color.length () >= 1 + 6 )
            {
                return makeRGB ( color.substring ( 1, 3 ), color.substring ( 3, 5 ), color.substring ( 5, 7 ) );
            }
        }
        return null;
    }

    protected static RGB makeRGB ( final String r, final String g, final String b )
    {
        return new RGB ( Integer.parseInt ( r, 16 ), Integer.parseInt ( g, 16 ), Integer.parseInt ( b, 16 ) );
    }

}
