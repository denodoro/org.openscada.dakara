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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.openscada.vi.model.VisualInterface.Alignment;
import org.openscada.vi.model.VisualInterface.BorderChild;
import org.openscada.vi.model.VisualInterface.BorderContainer;
import org.openscada.vi.ui.draw2d.SymbolController;
import org.openscada.vi.ui.draw2d.ViewElementFactory;

public class BorderContainerController implements Controller
{
    private final Figure figure;

    private BorderLayout layout;

    public BorderContainerController ( final SymbolController controller, final BorderContainer element, final ViewElementFactory factory )
    {
        this.figure = new Figure ();

        this.figure.setLayoutManager ( this.layout = new BorderLayout () );

        this.layout.setHorizontalSpacing ( element.getHorizontalSpacing () );
        this.layout.setVerticalSpacing ( element.getVerticalSpacing () );

        for ( final BorderChild child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child.getElement () );
            final IFigure childFigure = elementController.getFigure ();

            controller.addRawElement ( child.getName (), new BorderChildController ( childFigure ) );

            this.figure.add ( childFigure, convert ( child.getAlignment () ) );
        }

        controller.addElement ( element, this );
    }

    public static Object convert ( final Alignment alignment )
    {
        switch ( alignment )
        {
        case BOTTOM:
            return BorderLayout.BOTTOM;
        case TOP:
            return BorderLayout.TOP;
        case CENTER:
            return BorderLayout.CENTER;
        case LEFT:
            return BorderLayout.LEFT;
        case RIGHT:
            return BorderLayout.RIGHT;
        default:
            return null;
        }
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
