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

package org.openscada.vi.ui.chart.draw2d.view;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.services.IEvaluationService;
import org.openscada.vi.ui.user.ViewInstance;
import org.openscada.vi.ui.user.ViewInstanceDescriptor;
import org.openscada.vi.ui.user.ViewInstanceFactory;
import org.openscada.vi.ui.user.ViewManager;
import org.openscada.vi.ui.user.ViewManagerContext;

public class ChartViewFactory implements ViewInstanceFactory
{

    @Override
    public ViewInstance createViewInstance ( final ViewManager viewManager, final ViewManagerContext viewManagerContext, final ViewInstanceDescriptor descriptor, final Composite viewHolder, final ToolBar toolBar, final ResourceManager manager, final IWorkbenchPartSite site )
    {
        final ChartView view = new ChartView ( viewManagerContext, viewManager, manager, descriptor, viewHolder, toolBar, (IEvaluationService)site.getService ( IEvaluationService.class ), true );
        view.init ();
        return view;
    }

}
