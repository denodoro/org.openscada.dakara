package org.openscada.vi.ui.draw2d;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

public class Helper
{
    public static IFigure createErrorFigure ( final Throwable e )
    {
        final Label label = new Label ( e.getMessage () );
        return label;
    }
}
