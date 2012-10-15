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

import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.ui.draw2d.SymbolController;

public class RectangleController extends ShapeController
{
    private final Shape figure;

    public RectangleController ( final SymbolController controller, final Rectangle element, final ResourceManager manager )
    {
        super ( controller, manager );
        final PrecisionRectangle rect = new PrecisionRectangle ();
        if ( element.getSize () != null )
        {
            rect.setPreciseSize ( element.getSize ().getWidth (), element.getSize ().getHeight () );
        }
        this.figure = new RectangleFigureExtension ( this );
        this.figure.setBounds ( rect );

        controller.addElement ( element, this );

        applyCommon ( element );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, true );
    }

    @Override
    public void setAntialias ( final Boolean value )
    {
        setAntialias ( value, false );
    }

    @Override
    protected Shape getPropertyFigure ()
    {
        return this.figure;
    }
}
