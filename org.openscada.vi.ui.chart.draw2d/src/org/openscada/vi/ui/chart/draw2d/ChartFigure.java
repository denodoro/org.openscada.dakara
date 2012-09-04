package org.openscada.vi.ui.chart.draw2d;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.graphics.Rectangle;
import org.openscada.chart.swt.ChartRenderer;
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.ui.chart.model.ChartModel.ChartFactory;
import org.openscada.ui.chart.model.ChartModel.XAxis;
import org.openscada.ui.chart.model.ChartModel.YAxis;
import org.openscada.ui.chart.viewer.ChartViewer;

public class ChartFigure extends Figure
{

    private ChartRenderer renderer;

    private ChartViewer viewer;

    @Override
    public void addNotify ()
    {
        super.addNotify ();
        createRenderer ();
    }

    @Override
    public void removeNotify ()
    {
        disposeRenderer ();
        super.removeNotify ();
    };

    private static Chart makeDefaultConfiguration ()
    {
        final Chart configuration = ChartFactory.eINSTANCE.createChart ();

        final YAxis y = ChartFactory.eINSTANCE.createYAxis ();
        y.setLabel ( "Values" );
        y.setFormat ( "%.2f" );
        configuration.getLeft ().add ( y );

        final XAxis x = ChartFactory.eINSTANCE.createXAxis ();
        x.setLabel ( "Time" );
        x.setFormat ( "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL" );
        x.setMinimum ( System.currentTimeMillis () );
        x.setMaximum ( System.currentTimeMillis () + 900 * 1000 );
        configuration.getBottom ().add ( x );

        configuration.setSelectedXAxis ( x );
        configuration.setSelectedYAxis ( y );

        return configuration;
    }

    protected void disposeRenderer ()
    {
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
            this.viewer = null;
        }
        if ( this.renderer != null )
        {
            this.renderer.dispose ();
            this.renderer = null;
        }
    }

    protected void createRenderer ()
    {
        disposeRenderer ();
        this.renderer = new FigureRenderer ( this );
        this.viewer = new ChartViewer ( this.renderer, makeDefaultConfiguration () );
    }

    @Override
    public void setSize ( final int w, final int h )
    {
        super.setSize ( w, h );
        if ( this.renderer != null )
        {
            this.renderer.resizeAll ( new Rectangle ( 0, 0, w, h ) );
        }
    }

    @Override
    protected void paintClientArea ( final Graphics graphics )
    {
        if ( this.renderer != null )
        {
            final Draw2DGraphics g = new Draw2DGraphics ( graphics );
            this.renderer.paint ( g );
        }
    }
}