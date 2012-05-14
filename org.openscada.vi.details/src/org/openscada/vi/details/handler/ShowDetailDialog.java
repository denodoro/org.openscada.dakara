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

package org.openscada.vi.details.handler;

import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.openscada.ui.databinding.AbstractSelectionHandler;
import org.openscada.vi.details.DetailViewDialog;

public class ShowDetailDialog extends AbstractSelectionHandler
{

    @SuppressWarnings ( "unchecked" )
    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final String detailViewId = event.getParameter ( "org.openscada.vi.details.showDetailDialog.id" );
        final Map<String, String> parameters = (Map<String, String>)event.getObjectParameterForExecution ( "org.openscada.vi.details.showDetailDialog.parameters" );

        final DetailViewDialog dlg = new DetailViewDialog ( getShell (), detailViewId, parameters );
        dlg.open ();

        return null;
    }

}
