package org.openscada.vi.ui.chart.draw2d.view;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.services.IEvaluationService;
import org.openscada.chart.swt.ChartArea;
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.ui.chart.selector.ChartInputSelector;
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

    private final boolean showSelector;

    private SashForm wrapper;

    private Chart configuration;

    private ChartInputSelector selector;

    public ChartView ( final ViewManagerContext viewManagerContext, final ViewManager viewManager, final ResourceManager manager, final ViewInstanceDescriptor descriptor, final Composite viewHolder, final ToolBar toolbar, final IEvaluationService evaluationService, final boolean showSelector )
    {
        super ( viewManagerContext, viewManager, manager, descriptor, toolbar, evaluationService );
        this.showSelector = showSelector;
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
        return this.wrapper;
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

        this.wrapper = new SashForm ( this.viewHolder, SWT.HORIZONTAL );
        this.wrapper.setLayout ( new FillLayout ( SWT.HORIZONTAL ) );

        this.chartArea = new ChartArea ( this.wrapper, SWT.NONE );
        this.configuration = loadConfiguration ();
        this.chart = new ChartViewer ( this.chartArea.getChartRenderer (), this.configuration );

        if ( this.showSelector )
        {
            this.selector = new ChartInputSelector ( this.wrapper, this.chart, true );
            this.wrapper.setWeights ( new int[] { 90, 10 } );
        }

        fireActiveStateChanged ( true );
    }

    @Override
    protected void deactivateView ()
    {
        boolean didDispose = false;
        if ( this.chart != null )
        {
            didDispose = true;
            this.chart.dispose ();
            this.chart = null;
        }
        if ( this.chartArea != null )
        {
            this.chartArea.dispose ();
            this.chartArea = null;

        }
        if ( this.selector != null )
        {
            this.selector.dispose ();
            this.selector = null;
        }
        if ( this.wrapper != null )
        {
            this.wrapper.dispose ();
            this.wrapper = null;
        }

        if ( didDispose )
        {
            fireActiveStateChanged ( false );
        }

    }

}
