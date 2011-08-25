package org.openscada.vi.ui.draw2d.impl;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.ScalableFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.swt.SWT;

/**
 * A non-freeform, scalable layered pane.
 * 
 * @author Eric Bordeau
 * @since 2.1.1
 */
public class ScalableLayeredPane extends LayeredPane implements ScalableFigure
{

    private double scale = 1.0;

    /**
     * @see IFigure#getClientArea(Rectangle)
     */
    @Override
    public Rectangle getClientArea ( final Rectangle rect )
    {
        super.getClientArea ( rect );

        // try to compensate scaling artifacts

        final int dx = (int) ( rect.x / this.scale ) - ( rect.x = (int)Math.ceil ( rect.x / this.scale ) );
        final int dy = (int) ( rect.y / this.scale ) - ( rect.y = (int)Math.ceil ( rect.y / this.scale ) );

        rect.width = (int)Math.ceil ( rect.width / this.scale ) - dx;
        rect.height = (int)Math.ceil ( rect.height / this.scale ) - dy;

        return rect;
    }

    /**
     * @see Figure#getPreferredSize(int, int)
     */
    @Override
    public Dimension getMinimumSize ( final int wHint, final int hHint )
    {
        final Dimension d = super.getMinimumSize ( wHint != SWT.DEFAULT ? (int) ( wHint / getScale () ) : SWT.DEFAULT, hHint != SWT.DEFAULT ? (int) ( hHint / getScale () ) : SWT.DEFAULT );
        final int w = getInsets ().getWidth ();
        final int h = getInsets ().getHeight ();
        return d.getExpanded ( -w, -h ).scale ( this.scale ).expand ( w, h );
    }

    /**
     * @see Figure#getPreferredSize(int, int)
     */
    @Override
    public Dimension getPreferredSize ( final int wHint, final int hHint )
    {
        final Dimension d = super.getPreferredSize ( wHint != SWT.DEFAULT ? (int) ( wHint / getScale () ) : SWT.DEFAULT, hHint != SWT.DEFAULT ? (int) ( hHint / getScale () ) : SWT.DEFAULT );
        final int w = getInsets ().getWidth ();
        final int h = getInsets ().getHeight ();
        return d.getExpanded ( -w, -h ).scale ( this.scale ).expand ( w, h );
    }

    /**
     * Returns the scale level, default is 1.0.
     * 
     * @return the scale level
     */
    @Override
    public double getScale ()
    {
        return this.scale;
    }

    /**
     * @see org.eclipse.draw2d.IFigure#isCoordinateSystem()
     */
    @Override
    public boolean isCoordinateSystem ()
    {
        return true;
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
        if ( this.scale == 1.0 )
        {
            super.paintClientArea ( graphics );
        }
        else
        {
            final ScaledGraphics g = new ScaledGraphics ( graphics );
            final boolean optimizeClip = getBorder () == null || getBorder ().isOpaque ();
            if ( !optimizeClip )
            {
                g.clipRect ( getBounds ().getCropped ( getInsets () ) );
            }
            g.scale ( this.scale );
            g.pushState ();
            paintChildren ( g );
            g.dispose ();
            graphics.restoreState ();
        }
    }

    /**
     * Sets the zoom level
     * 
     * @param newZoom
     *            The new zoom level
     */
    @Override
    public void setScale ( final double newZoom )
    {
        if ( this.scale == newZoom )
        {
            return;
        }
        this.scale = newZoom;
        fireMoved (); // for AncestorListener compatibility
        revalidate ();
        repaint ();
    }

    /**
     * @see org.eclipse.draw2d.Figure#translateFromParent(Translatable)
     */
    @Override
    public void translateFromParent ( final Translatable t )
    {
        t.performScale ( 1 / this.scale );
    }

    /**
     * @see org.eclipse.draw2d.Figure#translateToParent(Translatable)
     */
    @Override
    public void translateToParent ( final Translatable t )
    {
        t.performScale ( this.scale );
    }

}
