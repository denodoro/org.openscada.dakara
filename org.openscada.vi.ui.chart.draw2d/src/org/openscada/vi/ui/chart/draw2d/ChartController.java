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

import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.vi.chart.model.chart.ChartView;
import org.openscada.vi.ui.draw2d.SymbolController;
import org.openscada.vi.ui.draw2d.primitives.FigureController;

public class ChartController extends FigureController
{
    private final Chart configuration;

    private final ChartFigure figure;

    public ChartController ( final SymbolController symbolController, final ResourceManager resourceManager, final ChartView view )
    {
        super ( symbolController, resourceManager );
        this.configuration = ChartHelper.loadConfiguraton ( view.getConfigurationUri () );
        this.figure = new ChartFigure ( this.configuration );

        applyCommon ( view );
    }

    public Chart getConfiguration ()
    {
        return this.configuration;
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, false );
    }

}
