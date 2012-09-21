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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.openscada.chart.swt.ChartMouseListener;
import org.openscada.chart.swt.ChartMouseListener.MouseState;
import org.openscada.chart.swt.ChartMouseMoveListener;
import org.openscada.chart.swt.ChartRenderer;

public class FigureRenderer extends ChartRenderer
{

    private final ChartFigure chartFigure;

    public FigureRenderer ( final ChartFigure chartFigure )
    {
        this.chartFigure = chartFigure;
        chartFigure.addFigureListener ( new FigureListener () {

            @Override
            public void figureMoved ( final IFigure source )
            {
                handleResize ();
            }
        } );
    }

    protected void handleResize ()
    {
        resizeAll ( getClientArea () );
    }

    @Override
    public void redraw ()
    {
        this.chartFigure.getUpdateManager ().addDirtyRegion ( this.chartFigure, this.chartFigure.getBounds () );
    }

    @Override
    public Rectangle getClientArea ()
    {
        final org.eclipse.draw2d.geometry.Rectangle rect = this.chartFigure.getClientArea ();
        return new Rectangle ( rect.x, rect.y, rect.width, rect.height );
    }

    private final Map<ChartMouseListener, org.eclipse.draw2d.MouseListener> mouseListenerMap = new HashMap<ChartMouseListener, org.eclipse.draw2d.MouseListener> ();

    @Override
    public void addMouseListener ( final ChartMouseListener mouseListener )
    {
        removeMouseListener ( mouseListener );
        final org.eclipse.draw2d.MouseListener proxyListener = new org.eclipse.draw2d.MouseListener () {
            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
                mouseListener.onMouseDoubleClick ( convertEvent ( me ) );
            }

            @Override
            public void mousePressed ( final MouseEvent me )
            {
                mouseListener.onMouseDown ( convertEvent ( me ) );
            }

            @Override
            public void mouseReleased ( final MouseEvent me )
            {
                mouseListener.onMouseUp ( convertEvent ( me ) );
            }
        };
        this.mouseListenerMap.put ( mouseListener, proxyListener );
        this.chartFigure.addMouseListener ( proxyListener );
    }

    @Override
    public void removeMouseListener ( final ChartMouseListener mouseListener )
    {
        final org.eclipse.draw2d.MouseListener proxyListener = this.mouseListenerMap.remove ( mouseListener );
        if ( proxyListener != null )
        {
            this.chartFigure.removeMouseListener ( proxyListener );
        }
    }

    private final Map<ChartMouseMoveListener, MouseMotionListener> mouseMoveListenerMap = new HashMap<ChartMouseMoveListener, MouseMotionListener> ();

    @Override
    public void addMouseMoveListener ( final ChartMouseMoveListener mouseMoveListener )
    {
        removeMouseMoveListener ( mouseMoveListener );
        final MouseMotionListener proxyListener = new MouseMotionListener () {

            @Override
            public void mouseMoved ( final MouseEvent me )
            {
                mouseMoveListener.onMouseMove ( convertEvent ( me ) );
            }

            @Override
            public void mouseHover ( final MouseEvent me )
            {
                mouseMoveListener.onMouseMove ( convertEvent ( me ) );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
            }

            @Override
            public void mouseEntered ( final MouseEvent me )
            {
            }

            @Override
            public void mouseDragged ( final MouseEvent me )
            {
                mouseMoveListener.onMouseMove ( convertEvent ( me ) );
            }
        };
        this.mouseMoveListenerMap.put ( mouseMoveListener, proxyListener );
        this.chartFigure.addMouseMotionListener ( proxyListener );
    }

    @Override
    public void removeMouseMoveListener ( final ChartMouseMoveListener mouseMoveListener )
    {
        final MouseMotionListener proxyListener = this.mouseMoveListenerMap.remove ( mouseMoveListener );
        if ( proxyListener != null )
        {
            this.chartFigure.removeMouseMotionListener ( proxyListener );
        }
    }

    @Override
    public void addMouseWheelListener ( final MouseWheelListener listener )
    {
    }

    @Override
    public void removeMouseWheelListener ( final MouseWheelListener listener )
    {
    }

    @Override
    public Display getDisplay ()
    {
        return Display.getCurrent ();
    }

    private MouseState convertEvent ( final MouseEvent me )
    {
        final MouseState state = new MouseState ();
        state.button = me.button;
        state.x = me.x;
        state.y = me.y;
        state.state = me.getState ();
        return state;
    }
}
