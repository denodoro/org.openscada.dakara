/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
 *
 * openSCADA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * only, as published by the Free Software Foundation.
 *
 * openSCADA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License version 3 for more details
 * (a copy is included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with openSCADA. If not, see
 * <http://opensource.org/licenses/lgpl-3.0.html> for a copy of the LGPLv3 License.
 */

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

    private final Chart configuration;

    public ChartFigure ( final Chart configuration )
    {
        this.configuration = configuration;
    }

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
        this.viewer = new ChartViewer ( this.renderer, this.configuration != null ? this.configuration : makeDefaultConfiguration () );
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