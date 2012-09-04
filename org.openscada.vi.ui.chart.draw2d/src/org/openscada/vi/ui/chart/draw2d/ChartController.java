package org.openscada.vi.ui.chart.draw2d;

import org.eclipse.draw2d.IFigure;
import org.openscada.vi.ui.draw2d.Controller;

public class ChartController implements Controller
{
    @Override
    public IFigure getFigure ()
    {
        return new ChartFigure ();
    }

}
