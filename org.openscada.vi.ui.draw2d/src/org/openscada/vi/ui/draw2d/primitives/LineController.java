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

import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.ui.draw2d.SymbolController;

public class LineController extends ShapeController
{
    private final PolylineShape figure;

    private final PointList points;

    public LineController ( final SymbolController controller, final Line element, final ResourceManager manager )
    {
        super ( controller, manager );

        this.figure = new PolylineShape () {
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

        this.points = new PointList ();
        for ( final Position pos : element.getPoints () )
        {
            final Point p = new PrecisionPoint ( pos.getX (), pos.getY () );
            this.points.addPoint ( p );
        }

        this.figure.setPoints ( this.points );
        this.figure.getPreferredSize ();
        // this.figure.setBounds ( this.points.getBounds ().expand ( 10, 10 ) );

        controller.addElement ( element, this );

        applyCommon ( element );
    }

    @Override
    public void setPreferredSize ( final Dimension size )
    {
        if ( size == null )
        {
            super.setPreferredSize ( this.points.getBounds ().expand ( 10, 10 ).getSize () );
        }
        else
        {
            super.setPreferredSize ( size );
        }
    }

    @Override
    public void setAntialias ( final Boolean value )
    {
        setAntialias ( value, true );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, true );
    }

    @Override
    protected Shape getPropertyFigure ()
    {
        return this.figure;
    }
}
