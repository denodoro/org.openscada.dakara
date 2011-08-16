package org.openscada.vi.ui.draw2d;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ScaledGraphics;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;

public class RelativeFigure extends Figure
{
    private float zoom;

    private Point offset = new Point ( 0, 0 );

    public RelativeFigure ()
    {
        setLayoutManager ( new StackLayout () );
    }

    /**
     * @see org.eclipse.draw2d.Figure#getClientArea()
     */
    @Override
    public Rectangle getClientArea ( final Rectangle rect )
    {
        super.getClientArea ( rect );
        rect.width /= this.zoom;
        rect.height /= this.zoom;
        rect.x -= this.offset.x;
        rect.y -= this.offset.y;
        return rect;
    }

    @Override
    public Dimension getPreferredSize ( final int wHint, final int hHint )
    {
        final Dimension d = super.getPreferredSize ( wHint, hHint );
        final int w = getInsets ().getWidth ();
        final int h = getInsets ().getHeight ();
        return d.getExpanded ( -w, -h ).scale ( this.zoom ).expand ( w, h );
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintClientArea(Graphics)
     */
    @Override
    protected void paintClientArea ( final Graphics graphics )
    {
        if ( getChildren ().isEmpty () )
        {
            return;
        }

        final boolean optimizeClip = getBorder () == null || getBorder ().isOpaque ();

        final ScaledGraphics g = new ScaledGraphics ( graphics );

        if ( !optimizeClip )
        {
            g.clipRect ( getBounds ().getShrinked ( getInsets () ) );
        }
        g.translate ( getBounds ().x + getInsets ().left + this.offset.x, getBounds ().y + getInsets ().top + this.offset.y );
        g.scale ( this.zoom );
        g.pushState ();
        paintChildren ( g );
        g.popState ();
        g.dispose ();
        graphics.restoreState ();
    }

    public void setZoom ( final float zoom )
    {
        this.zoom = zoom;
        revalidate ();
        repaint ();
    }

    public void setOffset ( final Point offset )
    {
        this.offset = offset;
        revalidate ();
        repaint ();
    }

    /**
     * @see org.eclipse.draw2d.Figure#translateToParent(Translatable)
     */
    @Override
    public void translateToParent ( final Translatable t )
    {
        t.performTranslate ( this.offset.x, this.offset.y );
        t.performScale ( this.zoom );
        super.translateToParent ( t );
    }

    /**
     * @see org.eclipse.draw2d.Figure#translateFromParent(Translatable)
     */
    @Override
    public void translateFromParent ( final Translatable t )
    {
        super.translateFromParent ( t );
        t.performScale ( 1 / this.zoom );
        t.performTranslate ( -this.offset.x, -this.offset.y );
    }

    /**
     * @see org.eclipse.draw2d.Figure#useLocalCoordinates()
     */
    @Override
    protected boolean useLocalCoordinates ()
    {
        return true;
    }

}
