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
