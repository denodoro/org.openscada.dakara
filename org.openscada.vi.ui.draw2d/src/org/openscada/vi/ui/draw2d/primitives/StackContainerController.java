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

package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.StackContainer;
import org.openscada.vi.ui.draw2d.BasicViewElementFactory;
import org.openscada.vi.ui.draw2d.Controller;
import org.openscada.vi.ui.draw2d.SymbolController;

public class StackContainerController implements Controller
{
    private final Figure figure;

    private StackLayout layout;

    public StackContainerController ( final SymbolController controller, final StackContainer element, final BasicViewElementFactory factory ) throws Exception
    {
        this.figure = new Figure ();

        this.figure.setLayoutManager ( this.layout = new StackLayout () );

        this.layout.setObserveVisibility ( true );

        for ( final Primitive child : element.getChildren () )
        {
            final Controller elementController = factory.create ( controller, child );
            final IFigure childFigure = elementController.getFigure ();

            controller.addRawElement ( child.getName (), elementController );

            this.figure.add ( childFigure );
        }

        controller.addElement ( element, this );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

}
