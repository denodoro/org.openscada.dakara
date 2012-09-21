package org.openscada.vi.ui.chart.draw2d.view;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.services.IEvaluationService;
import org.openscada.chart.swt.ChartArea;
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.ui.chart.viewer.ChartViewer;
import org.openscada.vi.ui.chart.draw2d.ChartHelper;
import org.openscada.vi.ui.user.AbstractViewInstance;
import org.openscada.vi.ui.user.ViewInstanceDescriptor;
import org.openscada.vi.ui.user.ViewManager;
import org.openscada.vi.ui.user.ViewManagerContext;

public class ChartView extends AbstractViewInstance
{

    private ChartViewer chart;

    private final Composite viewHolder;

    private ChartArea chartArea;

    public ChartView ( final ViewManagerContext viewManagerContext, final ViewManager viewManager, final ResourceManager manager, final ViewInstanceDescriptor descriptor, final Composite viewHolder, final ToolBar toolbar, final IEvaluationService evaluationService )
    {
        super ( viewManagerContext, viewManager, manager, descriptor, toolbar, evaluationService );
        this.viewHolder = viewHolder;
    }

    @Override
    public void setFocus ()
    {
        this.chartArea.setFocus ();
    }

    @Override
    public Control getControl ()
    {
        return this.chartArea;
    }

    private Chart loadConfiguration ()
    {
        return ChartHelper.loadConfiguraton ( this.descriptor.getUri ().toString () );
    }

    @Override
    protected void activateView ()
    {
        if ( this.chart != null )
        {
            return;
        }

        this.chartArea = new ChartArea ( this.viewHolder, SWT.NONE );
        this.chart = new ChartViewer ( this.chartArea.getChartRenderer (), loadConfiguration () );

        fireActiveStateChanged ( true );
    }

    @Override
    protected void deactivateView ()
    {
        if ( this.chart != null )
        {
            this.chart.dispose ();
            this.chart = null;
        }
        if ( this.chartArea != null )
        {
            this.chartArea.dispose ();
            this.chartArea = null;

            fireActiveStateChanged ( false );
        }
    }

}
