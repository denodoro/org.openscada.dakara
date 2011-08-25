/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2011 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.openscada.vi.model.VisualInterface.Alignment;

public class BorderChildController
{

    private final IFigure figure;

    public BorderChildController ( final IFigure childFigure )
    {
        this.figure = childFigure;
    }

    public void setAlignment ( final String alignment )
    {
        try
        {
            this.figure.getParent ().setConstraint ( this.figure, BorderContainerController.convert ( Alignment.valueOf ( alignment ) ) );
        }
        catch ( final Exception e )
        {
            this.figure.getParent ().setConstraint ( this.figure, null );
        }
    }
}
