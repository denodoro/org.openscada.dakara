package org.openscada.vi.ui.draw2d;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

public class Helper
{
    public static IFigure createErrorFigure ( final Throwable e )
    {
        final Label label = new Label ();
        label.setText ( formatException ( e ) );
        return label;
    }

    private static String formatException ( final Throwable e )
    {
        final StringWriter sw = new StringWriter ();
        final PrintWriter pw = new PrintWriter ( sw );

        e.printStackTrace ( pw );
        pw.close ();
        return sw.toString ();
    }
}
