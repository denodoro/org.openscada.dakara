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
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.FigureContainer;
import org.openscada.vi.ui.draw2d.BasicViewElementFactory;
import org.openscada.vi.ui.draw2d.SymbolController;

public class FigureContainerController extends FigureController
{
    private final Figure figure;

    public FigureContainerController ( final SymbolController controller, final FigureContainer element, final ResourceManager manager, final BasicViewElementFactory viewElementFactory ) throws Exception
    {
        super ( controller, manager );

        this.figure = new Figure () {
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

        if ( element.getSize () != null )
        {
            final PrecisionRectangle rect = new PrecisionRectangle ();
            rect.setPreciseSize ( element.getSize ().getWidth (), element.getSize ().getHeight () );
            this.figure.setBounds ( rect );
        }

        controller.addElement ( element, this );

        this.figure.setLayoutManager ( new StackLayout () );
        this.figure.add ( viewElementFactory.create ( controller, element.getContent () ).getFigure () );

        applyCommon ( element );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, false );
    }

    @Override
    public Figure getFigure ()
    {
        return this.figure;
    }
}
