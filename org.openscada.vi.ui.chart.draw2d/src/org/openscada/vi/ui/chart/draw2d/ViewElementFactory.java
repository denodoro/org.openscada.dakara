package org.openscada.vi.ui.chart.draw2d;

import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.chart.model.chart.ChartView;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.ui.draw2d.BasicViewElementFactory;
import org.openscada.vi.ui.draw2d.Controller;
import org.openscada.vi.ui.draw2d.SymbolController;

public class ViewElementFactory implements org.openscada.vi.ui.draw2d.ViewElementFactory
{

    @Override
    public Controller create ( final SymbolController controller, final Primitive element, final ResourceManager manager, final BasicViewElementFactory basicViewElementFactory )
    {
        final ChartView view = (ChartView)element;
        return new ChartController ( view );
    }

}
