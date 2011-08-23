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
