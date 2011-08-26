/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     TH4 SYSTEMS GmbH - Hairline handling
 *******************************************************************************/
package org.openscada.vi.ui.draw2d.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.PathData;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

/**
 * A Graphics object able to scale all operations based on the current scale
 * factor.
 */
public class ScaledGraphics extends Graphics
{

    private static class FontHeightCache
    {
        Font font;

        int height;
    }

    static class FontKey
    {
        Font font;

        int height;

        protected FontKey ()
        {
        }

        protected FontKey ( final Font font, final int height )
        {
            this.font = font;
            this.height = height;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            return ( (FontKey)obj ).font.equals ( this.font ) && ( (FontKey)obj ).height == this.height;
        }

        @Override
        public int hashCode ()
        {
            return this.font.hashCode () ^ this.height;
        }

        protected void setValues ( final Font font, final int height )
        {
            this.font = font;
            this.height = height;
        }
    }

    /**
     * The internal state of the scaled graphics.
     */
    protected static class State
    {
        private double appliedX;

        private double appliedY;

        private Font font;

        private float lineWidth;

        private double zoom;

        /**
         * Constructs a new, uninitialized State object.
         */
        protected State ()
        {
        }

        /**
         * Constructs a new State object and initializes the properties based on
         * the given values.
         * 
         * @param zoom
         *            the zoom factor
         * @param x
         *            the x offset
         * @param y
         *            the y offset
         * @param font
         *            the font
         * @param lineWidth
         *            the line width
         */
        protected State ( final double zoom, final double x, final double y, final Font font, final int lineWidth )
        {
            this ( zoom, x, y, font, (float)lineWidth );
        }

        /**
         * Constructs a new State object and initializes the properties based on
         * the given values.
         * 
         * @param zoom
         *            the zoom factor
         * @param x
         *            the x offset
         * @param y
         *            the y offset
         * @param font
         *            the font
         * @param lineWidth
         *            the line width
         * 
         * @since 3.5
         */
        protected State ( final double zoom, final double x, final double y, final Font font, final float lineWidth )
        {
            this.zoom = zoom;
            this.appliedX = x;
            this.appliedY = y;
            this.font = font;
            this.lineWidth = lineWidth;
        }

        /**
         * Sets all the properties of the state object.
         * 
         * @param zoom
         *            the zoom factor
         * @param x
         *            the x offset
         * @param y
         *            the y offset
         * @param font
         *            the font
         * @param lineWidth
         *            the line width
         */
        protected void setValues ( final double zoom, final double x, final double y, final Font font, final int lineWidth )
        {
            setValues ( zoom, x, y, font, (float)lineWidth );
        }

        /**
         * Sets all the properties of the state object.
         * 
         * @param zoom
         *            the zoom factor
         * @param x
         *            the x offset
         * @param y
         *            the y offset
         * @param font
         *            the font
         * @param lineWidth
         *            the line width
         * 
         * @since 3.5
         */
        protected void setValues ( final double zoom, final double x, final double y, final Font font, final float lineWidth )
        {
            this.zoom = zoom;
            this.appliedX = x;
            this.appliedY = y;
            this.font = font;
            this.lineWidth = lineWidth;
        }
    }

    private static int[][] intArrayCache = new int[8][];

    private final Rectangle tempRECT = new Rectangle ();

    static
    {
        for ( int i = 0; i < intArrayCache.length; i++ )
        {
            intArrayCache[i] = new int[i + 1];
        }
    }

    private boolean allowText = true;

    // private static final Point PT = new Point();
    private final Map fontCache = new HashMap ();

    private final Map fontDataCache = new HashMap ();

    private final FontKey fontKey = new FontKey ();

    private double fractionalX;

    private double fractionalY;

    private final Graphics graphics;

    private final FontHeightCache localCache = new FontHeightCache ();

    private Font localFont;

    private float localLineWidth;

    private final List stack = new ArrayList ();

    private int stackPointer = 0;

    private final FontHeightCache targetCache = new FontHeightCache ();

    double zoom = 1.0;

    /**
     * Constructs a new ScaledGraphics based on the given Graphics object.
     * 
     * @param g
     *            the base graphics object
     */
    public ScaledGraphics ( final Graphics g )
    {
        this.graphics = g;
        this.localFont = g.getFont ();
        this.localLineWidth = g.getLineWidthFloat ();
    }

    /** @see Graphics#clipRect(Rectangle) */
    @Override
    public void clipRect ( final Rectangle r )
    {
        this.graphics.clipRect ( zoomClipRect ( r ) );
    }

    Font createFont ( final FontData data )
    {
        return new Font ( Display.getCurrent (), data );
    }

    /**
     * Scales given path by zoom factor
     * 
     * @param path
     *            Path to be scaled
     * @return Scaled path
     */
    private Path createScaledPath ( final Path path )
    {
        final PathData p = path.getPathData ();
        for ( int i = 0; i < p.points.length; i += 2 )
        {
            p.points[i] = (float) ( p.points[i] * this.zoom + this.fractionalX );
            p.points[i + 1] = (float) ( p.points[i + 1] * this.zoom + this.fractionalY );
        }
        final Path scaledPath = new Path ( path.getDevice () );
        int index = 0;
        for ( int i = 0; i < p.types.length; i++ )
        {
            final byte type = p.types[i];
            switch ( type )
            {
            case SWT.PATH_MOVE_TO:
                scaledPath.moveTo ( p.points[index], p.points[index + 1] );
                index += 2;
                break;
            case SWT.PATH_LINE_TO:
                scaledPath.lineTo ( p.points[index], p.points[index + 1] );
                index += 2;
                break;
            case SWT.PATH_CUBIC_TO:
                scaledPath.cubicTo ( p.points[index], p.points[index + 1], p.points[index + 2], p.points[index + 3], p.points[index + 4], p.points[index + 5] );
                index += 6;
                break;
            case SWT.PATH_QUAD_TO:
                scaledPath.quadTo ( p.points[index], p.points[index + 1], p.points[index + 2], p.points[index + 3] );
                index += 4;
                break;
            case SWT.PATH_CLOSE:
                scaledPath.close ();
                break;
            }
        }
        return scaledPath;
    }

    /** @see Graphics#dispose() */
    @Override
    public void dispose ()
    {
        // Remove all states from the stack
        while ( this.stackPointer > 0 )
        {
            popState ();
        }

        // Dispose fonts
        final Iterator iter = this.fontCache.values ().iterator ();
        while ( iter.hasNext () )
        {
            final Font font = (Font)iter.next ();
            font.dispose ();
        }

    }

    /** @see Graphics#drawArc(int, int, int, int, int, int) */
    @Override
    public void drawArc ( final int x, final int y, final int w, final int h, final int offset, final int sweep )
    {
        final Rectangle z = zoomRect ( x, y, w, h );
        if ( z.isEmpty () || sweep == 0 )
        {
            return;
        }
        this.graphics.drawArc ( z, offset, sweep );
    }

    /** @see Graphics#drawFocus(int, int, int, int) */
    @Override
    public void drawFocus ( final int x, final int y, final int w, final int h )
    {
        this.graphics.drawFocus ( zoomRect ( x, y, w, h ) );
    }

    /** @see Graphics#drawImage(Image, int, int) */
    @Override
    public void drawImage ( final Image srcImage, final int x, final int y )
    {
        final org.eclipse.swt.graphics.Rectangle size = srcImage.getBounds ();
        this.graphics.drawImage ( srcImage, 0, 0, size.width, size.height, (int)Math.floor ( x * this.zoom + this.fractionalX ), (int)Math.floor ( y * this.zoom + this.fractionalY ), (int)Math.floor ( size.width * this.zoom + this.fractionalX ), (int)Math.floor ( size.height * this.zoom + this.fractionalY ) );
    }

    /** @see Graphics#drawImage(Image, int, int, int, int, int, int, int, int) */
    @Override
    public void drawImage ( final Image srcImage, final int sx, final int sy, final int sw, final int sh, final int tx, final int ty, final int tw, final int th )
    {
        // "t" == target rectangle, "s" = source

        final Rectangle t = zoomRect ( tx, ty, tw, th );
        if ( !t.isEmpty () )
        {
            this.graphics.drawImage ( srcImage, sx, sy, sw, sh, t.x, t.y, t.width, t.height );
        }
    }

    /** @see Graphics#drawLine(int, int, int, int) */
    @Override
    public void drawLine ( final int x1, final int y1, final int x2, final int y2 )
    {
        this.graphics.drawLine ( (int)Math.floor ( x1 * this.zoom + this.fractionalX ), (int)Math.floor ( y1 * this.zoom + this.fractionalY ), (int)Math.floor ( x2 * this.zoom + this.fractionalX ), (int)Math.floor ( y2 * this.zoom + this.fractionalY ) );
    }

    /** @see Graphics#drawOval(int, int, int, int) */
    @Override
    public void drawOval ( final int x, final int y, final int w, final int h )
    {
        this.graphics.drawOval ( zoomRect ( x, y, w, h ) );
    }

    /** @see Graphics#drawPath(Path) */
    @Override
    public void drawPath ( final Path path )
    {
        final Path scaledPath = createScaledPath ( path );
        try
        {
            this.graphics.drawPath ( scaledPath );
        }
        finally
        {
            scaledPath.dispose ();
        }
    }

    /** @see Graphics#drawPoint(int, int) */
    @Override
    public void drawPoint ( final int x, final int y )
    {
        this.graphics.drawPoint ( (int)Math.floor ( x * this.zoom + this.fractionalX ), (int)Math.floor ( y * this.zoom + this.fractionalY ) );
    }

    /**
     * @see Graphics#drawPolygon(int[])
     */
    @Override
    public void drawPolygon ( final int[] points )
    {
        this.graphics.drawPolygon ( zoomPointList ( points ) );
    }

    /** @see Graphics#drawPolygon(PointList) */
    @Override
    public void drawPolygon ( final PointList points )
    {
        this.graphics.drawPolygon ( zoomPointList ( points.toIntArray () ) );
    }

    /**
     * @see Graphics#drawPolyline(int[])
     */
    @Override
    public void drawPolyline ( final int[] points )
    {
        this.graphics.drawPolyline ( zoomPointList ( points ) );
    }

    /** @see Graphics#drawPolyline(PointList) */
    @Override
    public void drawPolyline ( final PointList points )
    {
        this.graphics.drawPolyline ( zoomPointList ( points.toIntArray () ) );
    }

    /** @see Graphics#drawRectangle(int, int, int, int) */
    @Override
    public void drawRectangle ( final int x, final int y, final int w, final int h )
    {
        this.graphics.drawRectangle ( zoomRect ( x, y, w, h ) );
    }

    /** @see Graphics#drawRoundRectangle(Rectangle, int, int) */
    @Override
    public void drawRoundRectangle ( final Rectangle r, final int arcWidth, final int arcHeight )
    {
        this.graphics.drawRoundRectangle ( zoomRect ( r.x, r.y, r.width, r.height ), (int) ( arcWidth * this.zoom ), (int) ( arcHeight * this.zoom ) );
    }

    /** @see Graphics#drawString(String, int, int) */
    @Override
    public void drawString ( final String s, final int x, final int y )
    {
        if ( this.allowText )
        {
            this.graphics.drawString ( s, zoomTextPoint ( x, y ) );
        }
    }

    /** @see Graphics#drawText(String, int, int) */
    @Override
    public void drawText ( final String s, final int x, final int y )
    {
        if ( this.allowText )
        {
            this.graphics.drawText ( s, zoomTextPoint ( x, y ) );
        }
    }

    /**
     * @see Graphics#drawText(String, int, int, int)
     */
    @Override
    public void drawText ( final String s, final int x, final int y, final int style )
    {
        if ( this.allowText )
        {
            this.graphics.drawText ( s, zoomTextPoint ( x, y ), style );
        }
    }

    /**
     * @see Graphics#drawTextLayout(TextLayout, int, int, int, int, Color,
     *      Color)
     */
    @Override
    public void drawTextLayout ( final TextLayout layout, final int x, final int y, final int selectionStart, final int selectionEnd, final Color selectionForeground, final Color selectionBackground )
    {
        final TextLayout scaled = zoomTextLayout ( layout );
        if ( scaled == null )
        {
            return;
        }
        try
        {
            this.graphics.drawTextLayout ( scaled, (int)Math.floor ( x * this.zoom + this.fractionalX ), (int)Math.floor ( y * this.zoom + this.fractionalY ), selectionStart, selectionEnd, selectionBackground, selectionForeground );
        }
        finally
        {
            scaled.dispose ();
        }
    }

    /** @see Graphics#fillArc(int, int, int, int, int, int) */
    @Override
    public void fillArc ( final int x, final int y, final int w, final int h, final int offset, final int sweep )
    {
        final Rectangle z = zoomFillRect ( x, y, w, h );
        if ( z.isEmpty () || sweep == 0 )
        {
            return;
        }
        this.graphics.fillArc ( z, offset, sweep );
    }

    /** @see Graphics#fillGradient(int, int, int, int, boolean) */
    @Override
    public void fillGradient ( final int x, final int y, final int w, final int h, final boolean vertical )
    {
        this.graphics.fillGradient ( zoomFillRect ( x, y, w, h ), vertical );
    }

    /** @see Graphics#fillOval(int, int, int, int) */
    @Override
    public void fillOval ( final int x, final int y, final int w, final int h )
    {
        this.graphics.fillOval ( zoomFillRect ( x, y, w, h ) );
    }

    /** @see Graphics#fillPath(Path) */
    @Override
    public void fillPath ( final Path path )
    {
        final Path scaledPath = createScaledPath ( path );
        try
        {
            this.graphics.fillPath ( scaledPath );
        }
        finally
        {
            scaledPath.dispose ();
        }
    }

    /**
     * @see Graphics#fillPolygon(int[])
     */
    @Override
    public void fillPolygon ( final int[] points )
    {
        this.graphics.fillPolygon ( zoomPointList ( points ) );
    }

    /** @see Graphics#fillPolygon(PointList) */
    @Override
    public void fillPolygon ( final PointList points )
    {
        this.graphics.fillPolygon ( zoomPointList ( points.toIntArray () ) );
    }

    /** @see Graphics#fillRectangle(int, int, int, int) */
    @Override
    public void fillRectangle ( final int x, final int y, final int w, final int h )
    {
        this.graphics.fillRectangle ( zoomFillRect ( x, y, w, h ) );
    }

    /** @see Graphics#fillRoundRectangle(Rectangle, int, int) */
    @Override
    public void fillRoundRectangle ( final Rectangle r, final int arcWidth, final int arcHeight )
    {
        this.graphics.fillRoundRectangle ( zoomFillRect ( r.x, r.y, r.width, r.height ), (int) ( arcWidth * this.zoom ), (int) ( arcHeight * this.zoom ) );
    }

    /** @see Graphics#fillString(String, int, int) */
    @Override
    public void fillString ( final String s, final int x, final int y )
    {
        if ( this.allowText )
        {
            this.graphics.fillString ( s, zoomTextPoint ( x, y ) );
        }
    }

    /** @see Graphics#fillText(String, int, int) */
    @Override
    public void fillText ( final String s, final int x, final int y )
    {
        if ( this.allowText )
        {
            this.graphics.fillText ( s, zoomTextPoint ( x, y ) );
        }
    }

    /**
     * @see Graphics#getAbsoluteScale()
     */
    @Override
    public double getAbsoluteScale ()
    {
        return this.zoom * this.graphics.getAbsoluteScale ();
    }

    /**
     * @see Graphics#getAlpha()
     */
    @Override
    public int getAlpha ()
    {
        return this.graphics.getAlpha ();
    }

    /**
     * @see Graphics#getAntialias()
     */
    @Override
    public int getAntialias ()
    {
        return this.graphics.getAntialias ();
    }

    /** @see Graphics#getBackgroundColor() */
    @Override
    public Color getBackgroundColor ()
    {
        return this.graphics.getBackgroundColor ();
    }

    Font getCachedFont ( FontKey key )
    {
        final Font font = (Font)this.fontCache.get ( key );
        if ( font != null )
        {
            return font;
        }
        key = new FontKey ( key.font, key.height );
        final FontData data = key.font.getFontData ()[0];
        data.setHeight ( key.height );
        final Font zoomedFont = createFont ( data );
        this.fontCache.put ( key, zoomedFont );
        return zoomedFont;
    }

    FontData getCachedFontData ( final Font f )
    {
        FontData data = (FontData)this.fontDataCache.get ( f );
        if ( data == null )
        {
            data = getLocalFont ().getFontData ()[0];
            this.fontDataCache.put ( f, data );
        }
        return data;
    }

    /** @see Graphics#getClip(Rectangle) */
    @Override
    public Rectangle getClip ( final Rectangle rect )
    {
        this.graphics.getClip ( rect );
        final int x = (int) ( rect.x / this.zoom );
        final int y = (int) ( rect.y / this.zoom );
        /*
         * If the clip rectangle is queried, perform an inverse zoom, and take
         * the ceiling of the resulting double. This is necessary because
         * forward scaling essentially performs a floor() function. Without
         * this, figures will think that they don't need to paint when actually
         * they do.
         */
        rect.width = (int)Math.ceil ( rect.right () / this.zoom ) - x;
        rect.height = (int)Math.ceil ( rect.bottom () / this.zoom ) - y;
        rect.x = x;
        rect.y = y;
        return rect;
    }

    /**
     * @see Graphics#getAdvanced()
     */
    @Override
    public boolean getAdvanced ()
    {
        return this.graphics.getAdvanced ();
    }

    /**
     * @see Graphics#getFillRule()
     */
    @Override
    public int getFillRule ()
    {
        return this.graphics.getFillRule ();
    }

    /** @see Graphics#getFont() */
    @Override
    public Font getFont ()
    {
        return getLocalFont ();
    }

    /** @see Graphics#getFontMetrics() */
    @Override
    public FontMetrics getFontMetrics ()
    {
        return FigureUtilities.getFontMetrics ( this.localFont );
    }

    /** @see Graphics#getForegroundColor() */
    @Override
    public Color getForegroundColor ()
    {
        return this.graphics.getForegroundColor ();
    }

    /**
     * @see Graphics#getInterpolation()
     */
    @Override
    public int getInterpolation ()
    {
        return this.graphics.getInterpolation ();
    }

    /**
     * @see Graphics#getLineCap()
     */
    @Override
    public int getLineCap ()
    {
        return this.graphics.getLineCap ();
    }

    /**
     * @see Graphics#getLineJoin()
     */
    @Override
    public int getLineJoin ()
    {
        return this.graphics.getLineJoin ();
    }

    /** @see Graphics#getLineStyle() */
    @Override
    public int getLineStyle ()
    {
        return this.graphics.getLineStyle ();
    }

    /** @see Graphics#getLineMiterLimit() */
    @Override
    public float getLineMiterLimit ()
    {
        return this.graphics.getLineMiterLimit ();
    }

    /** @see Graphics#getLineWidth() */
    @Override
    public int getLineWidth ()
    {
        return (int)getLineWidthFloat ();
    }

    /** @see Graphics#getLineWidthFloat() */
    @Override
    public float getLineWidthFloat ()
    {
        return getLocalLineWidth ();
    }

    /** @see Graphics#getLineAttributes() */
    @Override
    public LineAttributes getLineAttributes ()
    {
        final LineAttributes a = this.graphics.getLineAttributes ();
        a.width = getLocalLineWidth ();
        return a;
    }

    private Font getLocalFont ()
    {
        return this.localFont;
    }

    private float getLocalLineWidth ()
    {
        return this.localLineWidth;
    }

    /**
     * @see Graphics#getTextAntialias()
     */
    @Override
    public int getTextAntialias ()
    {
        return this.graphics.getTextAntialias ();
    }

    /** @see Graphics#getXORMode() */
    @Override
    public boolean getXORMode ()
    {
        return this.graphics.getXORMode ();
    }

    /** @see Graphics#popState() */
    @Override
    public void popState ()
    {
        this.graphics.popState ();
        this.stackPointer--;
        restoreLocalState ( (State)this.stack.get ( this.stackPointer ) );
    }

    /** @see Graphics#pushState() */
    @Override
    public void pushState ()
    {
        State s;
        if ( this.stack.size () > this.stackPointer )
        {
            s = (State)this.stack.get ( this.stackPointer );
            s.setValues ( this.zoom, this.fractionalX, this.fractionalY, getLocalFont (), this.localLineWidth );
        }
        else
        {
            this.stack.add ( new State ( this.zoom, this.fractionalX, this.fractionalY, getLocalFont (), this.localLineWidth ) );
        }
        this.stackPointer++;

        this.graphics.pushState ();
    }

    private void restoreLocalState ( final State state )
    {
        this.fractionalX = state.appliedX;
        this.fractionalY = state.appliedY;
        setScale ( state.zoom );
        setLocalFont ( state.font );
        setLocalLineWidth ( state.lineWidth );
    }

    /** @see Graphics#restoreState() */
    @Override
    public void restoreState ()
    {
        this.graphics.restoreState ();
        restoreLocalState ( (State)this.stack.get ( this.stackPointer - 1 ) );
    }

    /** @see Graphics#rotate(float) */
    @Override
    public void rotate ( final float degrees )
    {
        this.graphics.rotate ( degrees );
    }

    /** @see Graphics#scale(double) */
    @Override
    public void scale ( final double amount )
    {
        setScale ( this.zoom * amount );
    }

    /** @see Graphics#setAdvanced(boolean) */
    @Override
    public void setAdvanced ( final boolean advanced )
    {
        this.graphics.setAdvanced ( advanced );
    }

    /**
     * @see Graphics#setAlpha(int)
     */
    @Override
    public void setAlpha ( final int alpha )
    {
        this.graphics.setAlpha ( alpha );
    }

    /**
     * @see Graphics#setAntialias(int)
     */
    @Override
    public void setAntialias ( final int value )
    {
        this.graphics.setAntialias ( value );
    }

    /** @see Graphics#setBackgroundColor(Color) */
    @Override
    public void setBackgroundColor ( final Color rgb )
    {
        this.graphics.setBackgroundColor ( rgb );
    }

    /** @see Graphics#setClip(Path) */
    @Override
    public void setClip ( final Path path )
    {
        final Path scaledPath = createScaledPath ( path );
        try
        {
            this.graphics.setClip ( scaledPath );
        }
        finally
        {
            scaledPath.dispose ();
        }
    }

    /** @see Graphics#setBackgroundPattern(Pattern) */
    @Override
    public void setBackgroundPattern ( final Pattern pattern )
    {
        this.graphics.setBackgroundPattern ( pattern );
    }

    /** @see Graphics#setClip(Rectangle) */
    @Override
    public void setClip ( final Rectangle r )
    {
        this.graphics.setClip ( zoomClipRect ( r ) );
    }

    /**
     * @see org.eclipse.draw2d.Graphics#clipPath(org.eclipse.swt.graphics.Path)
     */
    @Override
    public void clipPath ( final Path path )
    {
        final Path scaledPath = createScaledPath ( path );
        try
        {
            this.graphics.clipPath ( scaledPath );
        }
        finally
        {
            scaledPath.dispose ();
        }
    }

    /**
     * @see Graphics#setFillRule(int)
     */
    @Override
    public void setFillRule ( final int rule )
    {
        this.graphics.setFillRule ( rule );
    }

    /** @see Graphics#setFont(Font) */
    @Override
    public void setFont ( final Font f )
    {
        setLocalFont ( f );
    }

    /** @see Graphics#setForegroundColor(Color) */
    @Override
    public void setForegroundColor ( final Color rgb )
    {
        this.graphics.setForegroundColor ( rgb );
    }

    /** @see Graphics#setForegroundPattern(Pattern) */
    @Override
    public void setForegroundPattern ( final Pattern pattern )
    {
        this.graphics.setForegroundPattern ( pattern );
    }

    /** @see org.eclipse.draw2d.Graphics#setInterpolation(int) */
    @Override
    public void setInterpolation ( final int interpolation )
    {
        this.graphics.setInterpolation ( interpolation );
    }

    /**
     * @see Graphics#setLineCap(int)
     */
    @Override
    public void setLineCap ( final int cap )
    {
        this.graphics.setLineCap ( cap );
    }

    /**
     * @see Graphics#setLineDash(int[])
     */
    @Override
    public void setLineDash ( final int[] dash )
    {
        this.graphics.setLineDash ( dash );
    }

    /**
     * @see org.eclipse.draw2d.Graphics#setLineDash(float[])
     */
    @Override
    public void setLineDash ( final float[] dash )
    {
        this.graphics.setLineDash ( dash );
    }

    /**
     * @see Graphics#setLineJoin(int)
     */
    @Override
    public void setLineJoin ( final int join )
    {
        this.graphics.setLineJoin ( join );
    }

    /** @see Graphics#setLineStyle(int) */
    @Override
    public void setLineStyle ( final int style )
    {
        this.graphics.setLineStyle ( style );
    }

    /** @see Graphics#setLineMiterLimit(float) */
    @Override
    public void setLineMiterLimit ( final float value )
    {
        this.graphics.setLineMiterLimit ( value );
    }

    /** @see Graphics#setLineWidth(int) */
    @Override
    public void setLineWidth ( final int width )
    {
        setLineWidthFloat ( width );
    }

    /** @see Graphics#setLineWidthFloat(float) */
    @Override
    public void setLineWidthFloat ( final float width )
    {
        setLocalLineWidth ( width );
    }

    /** @see Graphics#setLineAttributes(LineAttributes) */
    @Override
    public void setLineAttributes ( final LineAttributes attributes )
    {
        this.graphics.setLineAttributes ( attributes );
        setLocalLineWidth ( attributes.width );
    }

    private void setLocalFont ( final Font f )
    {
        this.localFont = f;
        this.graphics.setFont ( zoomFont ( f ) );
    }

    private void setLocalLineWidth ( final float width )
    {
        this.localLineWidth = width;
        this.graphics.setLineWidthFloat ( zoomLineWidth ( width ) );
    }

    public void setScale ( final double value )
    {
        if ( this.zoom != value )
        {
            this.zoom = value;
            this.graphics.setFont ( zoomFont ( getLocalFont () ) );
            this.graphics.setLineWidthFloat ( zoomLineWidth ( this.localLineWidth ) );
        }
    }

    /**
     * @see Graphics#setTextAntialias(int)
     */
    @Override
    public void setTextAntialias ( final int value )
    {
        this.graphics.setTextAntialias ( value );
    }

    /** @see Graphics#setXORMode(boolean) */
    @Override
    public void setXORMode ( final boolean b )
    {
        this.graphics.setXORMode ( b );
    }

    /** @see Graphics#translate(int, int) */
    @Override
    public void translate ( final int dx, final int dy )
    {
        // fractionalX/Y is the fractional part left over from previous
        // translates that gets lost in the integer approximation.
        final double dxFloat = dx * this.zoom + this.fractionalX;
        final double dyFloat = dy * this.zoom + this.fractionalY;
        this.fractionalX = dxFloat - Math.floor ( dxFloat );
        this.fractionalY = dyFloat - Math.floor ( dyFloat );
        this.graphics.translate ( (int)Math.floor ( dxFloat ), (int)Math.floor ( dyFloat ) );
    }

    /** @see Graphics#translate(float, float) */
    @Override
    public void translate ( final float dx, final float dy )
    {
        final double dxFloat = dx * this.zoom + this.fractionalX;
        final double dyFloat = dy * this.zoom + this.fractionalY;
        this.fractionalX = dxFloat - Math.floor ( dxFloat );
        this.fractionalY = dyFloat - Math.floor ( dyFloat );
        this.graphics.translate ( (int)Math.floor ( dxFloat ), (int)Math.floor ( dyFloat ) );
    }

    private Rectangle zoomClipRect ( final Rectangle r )
    {
        this.tempRECT.x = (int)Math.floor ( r.x * this.zoom + this.fractionalX );
        this.tempRECT.y = (int)Math.floor ( r.y * this.zoom + this.fractionalY );
        this.tempRECT.width = (int)Math.ceil ( ( r.x + r.width ) * this.zoom + this.fractionalX ) - this.tempRECT.x;
        this.tempRECT.height = (int)Math.ceil ( ( r.y + r.height ) * this.zoom + this.fractionalY ) - this.tempRECT.y;
        return this.tempRECT;
    }

    private Rectangle zoomFillRect ( final int x, final int y, final int w, final int h )
    {
        this.tempRECT.x = (int)Math.floor ( x * this.zoom + this.fractionalX );
        this.tempRECT.y = (int)Math.floor ( y * this.zoom + this.fractionalY );
        this.tempRECT.width = (int)Math.floor ( ( x + w - 1 ) * this.zoom + this.fractionalX ) - this.tempRECT.x + 1;
        this.tempRECT.height = (int)Math.floor ( ( y + h - 1 ) * this.zoom + this.fractionalY ) - this.tempRECT.y + 1;
        return this.tempRECT;
    }

    Font zoomFont ( Font f )
    {
        if ( f == null )
        {
            f = Display.getCurrent ().getSystemFont ();
        }
        final FontData data = getCachedFontData ( f );
        final int zoomedFontHeight = zoomFontHeight ( data.getHeight () );
        this.allowText = zoomedFontHeight > 0;
        this.fontKey.setValues ( f, zoomedFontHeight );
        return getCachedFont ( this.fontKey );
    }

    int zoomFontHeight ( final int height )
    {
        return (int) ( this.zoom * height );
    }

    float zoomLineWidth ( final float w )
    {
        if ( w == 1.0f )
        {
            return 1.0f;
        }
        return (float) ( w * this.zoom );
    }

    private int[] zoomPointList ( final int[] points )
    {
        int[] scaled = null;

        // Look in cache for a integer array with the same length as 'points'
        for ( int i = 0; i < intArrayCache.length; i++ )
        {
            if ( intArrayCache[i].length == points.length )
            {
                scaled = intArrayCache[i];

                // Move this integer array up one notch in the array
                if ( i != 0 )
                {
                    final int[] temp = intArrayCache[i - 1];
                    intArrayCache[i - 1] = scaled;
                    intArrayCache[i] = temp;
                }
            }
        }

        // If no match is found, take the one that is last and resize it.
        if ( scaled == null )
        {
            intArrayCache[intArrayCache.length - 1] = new int[points.length];
            scaled = intArrayCache[intArrayCache.length - 1];
        }

        // Scale the points
        for ( int i = 0; i + 1 < points.length; i += 2 )
        {
            scaled[i] = (int)Math.floor ( points[i] * this.zoom + this.fractionalX );
            scaled[i + 1] = (int)Math.floor ( points[i + 1] * this.zoom + this.fractionalY );
        }
        return scaled;
    }

    private Rectangle zoomRect ( final int x, final int y, final int w, final int h )
    {
        this.tempRECT.x = (int)Math.floor ( x * this.zoom + this.fractionalX );
        this.tempRECT.y = (int)Math.floor ( y * this.zoom + this.fractionalY );
        this.tempRECT.width = (int)Math.floor ( ( x + w ) * this.zoom + this.fractionalX ) - this.tempRECT.x;
        this.tempRECT.height = (int)Math.floor ( ( y + h ) * this.zoom + this.fractionalY ) - this.tempRECT.y;
        return this.tempRECT;
    }

    private TextLayout zoomTextLayout ( final TextLayout layout )
    {
        final TextLayout zoomed = new TextLayout ( Display.getCurrent () );
        zoomed.setText ( layout.getText () );

        int zoomWidth = -1;

        if ( layout.getWidth () != -1 )
        {
            zoomWidth = (int) ( layout.getWidth () * this.zoom );
        }

        if ( zoomWidth < -1 || zoomWidth == 0 )
        {
            return null;
        }

        zoomed.setFont ( zoomFont ( layout.getFont () ) );
        zoomed.setAlignment ( layout.getAlignment () );
        zoomed.setAscent ( layout.getAscent () );
        zoomed.setDescent ( layout.getDescent () );
        zoomed.setOrientation ( layout.getOrientation () );
        zoomed.setSegments ( layout.getSegments () );
        zoomed.setSpacing ( layout.getSpacing () );
        zoomed.setTabs ( layout.getTabs () );

        zoomed.setWidth ( zoomWidth );
        final int length = layout.getText ().length ();
        if ( length > 0 )
        {
            int start = 0, offset = 1;
            TextStyle style = null, lastStyle = layout.getStyle ( 0 );
            for ( ; offset <= length; offset++ )
            {
                if ( offset != length && ( style = layout.getStyle ( offset ) ) == lastStyle )
                {
                    continue;
                }
                final int end = offset - 1;

                if ( lastStyle != null )
                {
                    final TextStyle zoomedStyle = new TextStyle ( zoomFont ( lastStyle.font ), lastStyle.foreground, lastStyle.background );
                    zoomedStyle.metrics = lastStyle.metrics;
                    zoomedStyle.rise = lastStyle.rise;
                    zoomedStyle.strikeout = lastStyle.strikeout;
                    zoomedStyle.underline = lastStyle.underline;
                    zoomed.setStyle ( zoomedStyle, start, end );
                }
                lastStyle = style;
                start = offset;
            }
        }
        return zoomed;
    }

    private Point zoomTextPoint ( final int x, final int y )
    {
        if ( this.localCache.font != this.localFont )
        {
            // Font is different, re-calculate its height
            final FontMetrics metric = FigureUtilities.getFontMetrics ( this.localFont );
            this.localCache.height = metric.getHeight () - metric.getDescent ();
            this.localCache.font = this.localFont;
        }
        if ( this.targetCache.font != this.graphics.getFont () )
        {
            final FontMetrics metric = this.graphics.getFontMetrics ();
            this.targetCache.font = this.graphics.getFont ();
            this.targetCache.height = metric.getHeight () - metric.getDescent ();
        }
        return new Point ( (int)Math.floor ( x * this.zoom + this.fractionalX ), (int)Math.floor ( ( y + this.localCache.height - 1 ) * this.zoom - this.targetCache.height + 1 + this.fractionalY ) );
    }
}