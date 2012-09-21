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
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.vi.chart.model.chart.ChartView;
import org.openscada.vi.ui.draw2d.Controller;

public class ChartController implements Controller
{
    private final Chart configuration;

    public ChartController ( final ChartView view )
    {
        this.configuration = ChartHelper.loadConfiguraton ( view.getConfigurationUri () );
    }

    public Chart getConfiguration ()
    {
        return this.configuration;
    }

    @Override
    public IFigure getFigure ()
    {
        return new ChartFigure ( this.configuration );
    }

}
