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

package org.openscada.vi.ui.chart.draw2d;

import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.openscada.chart.swt.Graphics;

public class Draw2DGraphics implements Graphics
{

    private final org.eclipse.draw2d.Graphics g;

    public Draw2DGraphics ( final org.eclipse.draw2d.Graphics g )
    {
        this.g = g;
    }

    @Override
    public void setAlpha ( final int alpha )
    {
        this.g.setAlpha ( alpha );
    }

    @Override
    public void setLineAttributes ( final LineAttributes lineAttributes )
    {
        this.g.setLineAttributes ( lineAttributes );
    }

    @Override
    public void drawLine ( final int x1, final int y1, final int x2, final int y2 )
    {
        this.g.drawLine ( x1, y1, x2, y2 );
    }

    @Override
    public void fillRectangle ( final int x, final int y, final int width, final int height )
    {
        this.g.fillRectangle ( x, y, width, height );
    }

    @Override
    public Color getSystemColor ( final int color )
    {
        return Display.getCurrent ().getSystemColor ( color );
    }

    @Override
    public void setForeground ( final Color color )
    {
        this.g.setForegroundColor ( color );
    }

    @Override
    public void setBackground ( final Color color )
    {
        this.g.setBackgroundColor ( color );
    }

    @Override
    public void setClipping ( final Rectangle rect )
    {
        this.g.setClip ( new org.eclipse.draw2d.geometry.Rectangle ( rect.x, rect.y, rect.width, rect.height ) );
    }

    @Override
    public void drawRectangle ( final int x, final int y, final int width, final int height )
    {
        this.g.drawRectangle ( x, y, width, height );
    }

    @Override
    public void drawRectangle ( final Rectangle rect )
    {
        this.g.drawRectangle ( rect.x, rect.y, rect.width, rect.height );
    }

    @Override
    public Path createPath ()
    {
        return new Path ( Display.getCurrent () );
    }

    @Override
    public void drawPath ( final Path path )
    {
        this.g.drawPath ( path );
    }

    @Override
    public void fillRectangle ( final Rectangle rect )
    {
        this.g.fillRectangle ( rect.x, rect.y, rect.width, rect.height );
    }

    @Override
    public void drawText ( final String string, final int x, final int y, final Float rotate )
    {

        if ( rotate != null )
        {
            this.g.pushState ();
            this.g.rotate ( rotate );
        }

        this.g.drawText ( string, x, y );

        if ( rotate != null )
        {
            this.g.popState ();
        }
    }

    @Override
    public Point textExtent ( final String string )
    {
        final Dimension result = TextUtilities.INSTANCE.getTextExtents ( string, this.g.getFont () );
        return new Point ( result.width, result.height );
    }

    @Override
    public void setAntialias ( final boolean state )
    {
        this.g.setAntialias ( state ? SWT.ON : SWT.OFF );
    }
}
