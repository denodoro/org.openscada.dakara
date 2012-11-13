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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.chart.model.chart.ChartView;
import org.openscada.vi.ui.draw2d.ErrorFigure;
import org.openscada.vi.ui.draw2d.SymbolController;
import org.openscada.vi.ui.draw2d.primitives.FigureController;

public class ChartController extends FigureController
{
    private final ChartFigure figure;

    private final Figure wrapperFigure;

    private final ErrorFigure errorFigure;

    public ChartController ( final SymbolController symbolController, final ResourceManager resourceManager, final ChartView view )
    {
        super ( symbolController, resourceManager );

        this.wrapperFigure = new Figure () {
            @Override
            public void addNotify ()
            {
                super.addNotify ();
                start ();
            }

            @Override
            public void removeNotify ()
            {
                stop ();
                super.removeNotify ();
            }
        };

        this.wrapperFigure.setOpaque ( false );
        this.figure = new ChartFigure ();

        this.wrapperFigure.setLayoutManager ( new StackLayout () );
        this.wrapperFigure.add ( this.figure );
        this.errorFigure = new ErrorFigure ();

        symbolController.addElement ( view, this );

        applyCommon ( view );
    }

    protected void applyCommon ( final ChartView view )
    {
        setChartConfigurationUri ( view.getConfigurationUri () );
        super.applyCommon ( view );
    }

    public void setChartConfigurationUri ( final String configurationUri )
    {
        if ( this.wrapperFigure.getChildren ().contains ( this.errorFigure ) )
        {
            this.wrapperFigure.remove ( this.errorFigure );
        }

        if ( this.figure != null && configurationUri != null )
        {
            try
            {
                this.figure.setConfiguration ( ChartHelper.loadConfiguraton ( configurationUri ) );
            }
            catch ( final Exception e )
            {
                this.wrapperFigure.add ( this.errorFigure );
                this.errorFigure.setException ( e );
            }
        }
    }

    @Override
    public IFigure getPropertyFigure ()
    {
        return this.figure;
    }

    @Override
    public IFigure getFigure ()
    {
        return this.wrapperFigure;
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, false );
    }

}
