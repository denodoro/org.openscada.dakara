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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.openscada.vi.model.VisualInterface.GridAlignment;
import org.openscada.vi.model.VisualInterface.GridChild;
import org.openscada.vi.model.VisualInterface.GridContainer;
import org.openscada.vi.ui.draw2d.BasicViewElementFactory;
import org.openscada.vi.ui.draw2d.Controller;
import org.openscada.vi.ui.draw2d.SymbolController;

public class GridContainerController implements Controller
{
    private final Figure figure;

    public GridContainerController ( final SymbolController controller, final GridContainer element, final BasicViewElementFactory factory ) throws Exception
    {
        this.figure = new Figure ();

        this.figure.setLayoutManager ( new GridLayout ( element.getColumns (), element.isEqualWidth () ) );

        for ( final GridChild child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child.getElement () );
            final IFigure childFigure = elementController.getFigure ();
            this.figure.add ( childFigure, convert ( child ) );
        }

        controller.addElement ( element, this );
    }

    private Object convert ( final GridChild child )
    {
        final GridData gd = new GridData ();

        gd.horizontalAlignment = convert ( child.getHorizontalAlignment () );
        gd.verticalAlignment = convert ( child.getVerticalAlignment () );
        gd.grabExcessHorizontalSpace = child.isGrabHorizontalSpace ();
        gd.grabExcessVerticalSpace = child.isGrabVerticalSpace ();
        gd.horizontalSpan = child.getSpanCols ();
        gd.verticalSpan = child.getSpanRows ();

        return gd;
    }

    private int convert ( final GridAlignment alignment )
    {
        switch ( alignment )
        {
            case BEGINNING:
                return GridData.BEGINNING;
            case END:
                return GridData.END;
            case CENTER:
                return GridData.CENTER;
            case FILL:
                return GridData.FILL;
            default:
                return GridData.BEGINNING;
        }
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
