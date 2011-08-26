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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

public class ArcShape extends Shape
{

    private double start;

    private double length;

    public void setStart ( final double start )
    {
        this.start = start;
        repaint ();
    }

    public void setLength ( final double length )
    {
        this.length = length;
        repaint ();
    }

    @Override
    protected void fillShape ( final Graphics graphics )
    {
        // no-op
    }

    @Override
    protected void outlineShape ( final Graphics graphics )
    {
        final float lineInset = Math.max ( 1.0f, getLineWidthFloat () ) / 2.0f;
        final int inset1 = (int)Math.floor ( lineInset );
        final int inset2 = (int)Math.ceil ( lineInset );

        final Rectangle r = Rectangle.SINGLETON.setBounds ( getBounds () );
        r.x += inset1;
        r.y += inset1;
        r.width -= inset1 + inset2;
        r.height -= inset1 + inset2;

        graphics.drawArc ( r, (int)this.start, (int)this.length );
    }

    public void setArc ( final double start, final double length )
    {
        this.start = start;
        this.length = length;
        repaint ();
    }

}
