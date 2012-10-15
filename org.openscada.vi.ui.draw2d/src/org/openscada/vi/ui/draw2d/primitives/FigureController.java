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

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.script.ScriptException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.GroupBoxBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.ui.utils.blink.AbstractBlinker;
import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.model.VisualInterface.Cursor;
import org.openscada.vi.model.VisualInterface.Dimension;
import org.openscada.vi.model.VisualInterface.Figure;
import org.openscada.vi.model.VisualInterface.SystemCursor;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;
import org.openscada.vi.ui.draw2d.Activator;
import org.openscada.vi.ui.draw2d.Controller;
import org.openscada.vi.ui.draw2d.SymbolController;

/**
 * A figure controller
 * <p>
 * This figure controller needs to know when the figure it controls was added or
 * removed. Since draw2d does not provide a "addRemovedListener" for IFigure but
 * a {@link IFigure#removeNotify()} that can be overridden it is the
 * responsibility of the implementing controller to call {@link #start()} and
 * {@link #stop()} when the implementing {@link IFigure#addNotify()} and
 * {@link IFigure#removeNotify()} get called. So create your figure like the
 * following snippet shows: <code><pre>
IFigure figure = new PolylineShape () {
    public void addNotify () {
        super.addNotify ();
        start (); // FigureController.start ();
    }

    public void removeNotify () {
        stop (); // FigureController.stop ();
        super.removeNotify ();
    }
};
 * </pre></code>
 * </p>
 * 
 * @author Jens Reimann
 */
public abstract class FigureController implements Controller
{

    private static interface ColorApplier
    {
        public void applyColor ( IFigure figure, Color color );
    }

    private static class ForegroundApplier implements ColorApplier
    {
        @Override
        public void applyColor ( final IFigure figure, final Color color )
        {
            figure.setForegroundColor ( color );
        }
    }

    private static class BackgroundApplier implements ColorApplier
    {
        @Override
        public void applyColor ( final IFigure figure, final Color color )
        {
            figure.setBackgroundColor ( color );
        }
    }

    private static interface ColorHandler
    {
        public void start ();

        public void stop ();
    }

    private static class DefaultColor implements ColorHandler
    {
        private final IFigure figure;

        private final ColorApplier applier;

        public DefaultColor ( final IFigure figure, final ColorApplier applier )
        {
            this.figure = figure;
            this.applier = applier;
        }

        @Override
        public void start ()
        {
            this.applier.applyColor ( this.figure, null );
        }

        @Override
        public void stop ()
        {
            // nothing to do  
        }
    }

    private static class StaticColor implements ColorHandler
    {
        private final IFigure figure;

        private final ColorApplier applier;

        private final Color color;

        public StaticColor ( final IFigure figure, final ColorApplier applier, final Color color )
        {
            this.figure = figure;
            this.applier = applier;
            this.color = color;
        }

        @Override
        public void start ()
        {
            this.applier.applyColor ( this.figure, this.color );
        }

        @Override
        public void stop ()
        {
            // nothing to do
        }
    }

    private static class BlinkingColor extends AbstractBlinker implements ColorHandler
    {
        private final IFigure figure;

        private final ColorApplier applier;

        private final Color onColor;

        private final Color offColor;

        private final int frequency;

        public BlinkingColor ( final IFigure figure, final ColorApplier applier, final Color onColor, final Color offColor, final int frequency )
        {
            this.figure = figure;
            this.applier = applier;
            this.onColor = onColor;
            this.offColor = offColor;
            this.frequency = frequency;
        }

        @Override
        public void start ()
        {
            enableBlinking ( true );
        }

        @Override
        public void stop ()
        {
            enableBlinking ( false );
            super.dispose ();
        }

        @Override
        public void toggle ( final int globalCounter )
        {
            final boolean on = globalCounter % this.frequency == 0;
            this.applier.applyColor ( this.figure, on ? this.onColor : this.offColor );
        }
    }

    protected final ResourceManager manager;

    private final SymbolController controller;

    private ScriptExecutor onClick;

    private ScriptExecutor onDoubleClick;

    private final Map<Object, ColorHandler> colorHandler = new HashMap<Object, FigureController.ColorHandler> ();

    private boolean started;

    public FigureController ( final SymbolController controller, final ResourceManager manager )
    {
        this.manager = manager;
        this.controller = controller;
    }

    /**
     * Get the figure that is used for controlling the properties of this
     * controller.
     * <p>
     * The figure returned is by default the same as the
     * {@link #getFigure()}. But in some cases it might be necessary
     * to return a different figure.
     * </p>
     * 
     * @return the figure that should the attributes applied
     */
    protected abstract IFigure getPropertyFigure ();

    @Override
    public IFigure getFigure ()
    {
        return getPropertyFigure ();
    }

    protected void applyCommon ( final Figure figure )
    {
        setBorder ( figure.getBorder () );
        setBackgroundColor ( figure.getBackgroundColor () );
        setForegroundColor ( figure.getForegroundColor () );

        setPreferredSize ( create ( figure.getSize () ) );

        setCursor ( convert ( figure.getCursor () ) );
        setVisible ( figure.isVisible () );
        setOpaque ( figure.getOpaque () );

        try
        {
            this.onClick = this.controller.createScriptExecutor ( figure.getOnClick () );
            this.onDoubleClick = this.controller.createScriptExecutor ( figure.getOnDoubleClick () );
        }
        catch ( final ScriptException e )
        {
            throw new RuntimeException ( "Failed to initialize", e );
        }

        if ( this.onClick != null || this.onDoubleClick != null )
        {
            getPropertyFigure ().addMouseListener ( new MouseListener.Stub () {
                @Override
                public void mouseReleased ( final MouseEvent me )
                {
                    handleOnClick ( me );
                }

                @Override
                public void mouseDoubleClicked ( final MouseEvent me )
                {
                    handleOnDoubleClick ( me );
                }
            } );
        }
    }

    public void setCursor ( final String cursor )
    {
        getPropertyFigure ().setCursor ( getCursor ( cursor ) );
    }

    public static enum SWTCursors
    {
        ARROW ( SWT.CURSOR_ARROW ),
        HAND ( SWT.CURSOR_HAND ),
        HELP ( SWT.CURSOR_HELP ),
        WAIT ( SWT.CURSOR_WAIT ),
        CROSS ( SWT.CURSOR_CROSS ),
        IBEAM ( SWT.CURSOR_IBEAM ),
        NO ( SWT.CURSOR_NO );

        private int id;

        private SWTCursors ( final int id )
        {
            this.id = id;
        }

        public int id ()
        {
            return this.id;
        }
    }

    protected org.eclipse.swt.graphics.Cursor getCursor ( final String cursor )
    {
        try
        {
            final SWTCursors cursorValue = SWTCursors.valueOf ( cursor );
            return Display.getDefault ().getSystemCursor ( cursorValue.id () );
        }
        catch ( final Exception e )
        {
            // TODO: try to load as resource instead
            return null;
        }
    }

    private String convert ( final Cursor cursor )
    {
        if ( cursor instanceof SystemCursor )
        {
            return ( (SystemCursor)cursor ).getType ().toString ();
        }
        return null;
    }

    protected void handleOnDoubleClick ( final MouseEvent me )
    {
        this.controller.debugLog ( String.format ( "Double click: %s", me ) );
        final Map<String, Object> scriptObjects = new LinkedHashMap<String, Object> ( 1 );
        scriptObjects.put ( "event", me );
        this.controller.execute ( this.onDoubleClick, scriptObjects );
    }

    protected void handleOnClick ( final MouseEvent me )
    {
        this.controller.debugLog ( String.format ( "Click: %s", me ) );
        final Map<String, Object> scriptObjects = new LinkedHashMap<String, Object> ( 1 );
        scriptObjects.put ( "event", me );
        this.controller.execute ( this.onClick, scriptObjects );
    }

    public void setPreferredSize ( final org.eclipse.draw2d.geometry.Dimension size )
    {
        getPropertyFigure ().setPreferredSize ( size );
    }

    public void setSize ( final org.eclipse.draw2d.geometry.Dimension size )
    {
        if ( size != null )
        {
            getPropertyFigure ().setSize ( size );
        }
    }

    public void setSize ( final double width, final double height )
    {
        final Rectangle b = getPropertyFigure ().getBounds ();

        getPropertyFigure ().setBounds ( new PrecisionRectangle ( b.preciseX (), b.preciseY (), width, height ) );
    }

    public void setWidth ( final double width )
    {
        final Rectangle b = getPropertyFigure ().getBounds ();

        getPropertyFigure ().setBounds ( new PrecisionRectangle ( b.preciseX (), b.preciseY (), width, b.preciseHeight () ) );
    }

    public void setHeight ( final double height )
    {
        final Rectangle b = getPropertyFigure ().getBounds ();

        getPropertyFigure ().setBounds ( new PrecisionRectangle ( b.preciseX (), b.preciseY (), b.preciseWidth (), height ) );
    }

    public Dimension getPreferredSize ()
    {
        final Dimension dimension = VisualInterfaceFactory.eINSTANCE.createDimension ();
        final org.eclipse.draw2d.geometry.Dimension size = getPropertyFigure ().getPreferredSize ();
        dimension.setHeight ( size.preciseWidth () );
        dimension.setWidth ( size.preciseWidth () );
        return dimension;
    }

    public void setPreferredWidth ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( value );
        dim.setPreciseHeight ( getPropertyFigure ().getPreferredSize ().preciseHeight () );

        getPropertyFigure ().setPreferredSize ( dim );
    }

    public void setPreferredHeight ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( getPropertyFigure ().getPreferredSize ().preciseWidth () );
        dim.setPreciseHeight ( value );

        getPropertyFigure ().setPreferredSize ( dim );
    }

    public void setBorder ( final String border )
    {
        getPropertyFigure ().setBorder ( makeBorder ( border ) );
    }

    public void setBackgroundColor ( final String color )
    {
        final ColorHandler colorHandler = makeColorHandler ( color, new BackgroundApplier () );
        setColor ( "backgroundColor", colorHandler );
    }

    public void setForegroundColor ( final String color )
    {
        final ColorHandler colorHandler = makeColorHandler ( color, new ForegroundApplier () );
        setColor ( "foregroundColor", colorHandler );
    }

    protected void setColor ( final Object key, final ColorHandler colorHandler )
    {
        final ColorHandler oldColorHandler = this.colorHandler.put ( key, colorHandler );
        if ( oldColorHandler != null )
        {
            // dispose
            oldColorHandler.stop ();
        }

        // we are started, so start the color
        if ( this.started )
        {
            colorHandler.start ();
        }
    }

    public void start ()
    {
        if ( this.started )
        {
            return;
        }
        this.started = true;

        // start all colors
        for ( final ColorHandler color : this.colorHandler.values () )
        {
            color.start ();
        }
    }

    public void stop ()
    {
        if ( !this.started )
        {
            return;
        }
        this.started = false;

        // stop all colors
        for ( final ColorHandler color : this.colorHandler.values () )
        {
            color.stop ();
        }
    }

    public void setVisible ( final boolean flag )
    {
        getPropertyFigure ().setVisible ( flag );
    }

    public abstract void setOpaque ( final Boolean flag );

    protected void setOpaque ( final Boolean flag, final boolean defaultValue )
    {
        if ( flag == null )
        {
            getPropertyFigure ().setOpaque ( defaultValue );
        }
        else
        {
            getPropertyFigure ().setOpaque ( flag );
        }
    }

    /**
     * Create a new border
     * <p>
     * 
     * <pre>
     * 3
     * GROUP:x
     * COMPOUND:[GROUP:2|GROUP:3]
     * </pre>
     * 
     * </p>
     * 
     * @param border
     * @return a new border
     */
    protected Border makeBorder ( final String border )
    {
        if ( border == null || border.isEmpty () )
        {
            return null;
        }

        if ( border.matches ( "[0-9]+" ) )
        {
            return new LineBorder ( Integer.parseInt ( border ) );
        }

        if ( border.startsWith ( "LINE:" ) )
        {
            final Map<String, String> args = parseBorderArguments ( "lineWidth", border.substring ( "LINE:".length () ) );
            final LineBorder lineBorder = new LineBorder ();
            if ( args.containsKey ( "lineWidth" ) )
            {
                lineBorder.setWidth ( Integer.parseInt ( args.get ( "lineWidth" ) ) );
            }
            lineBorder.setColor ( createColor ( Helper.makeColor ( args.get ( "color" ) ) ) );

            return lineBorder;
        }
        if ( border.startsWith ( "GROUP:" ) )
        {
            final GroupBoxBorder groupBorder = new GroupBoxBorder ();

            final Map<String, String> args = parseBorderArguments ( "text", border.substring ( "GROUP:".length () ) );
            if ( args.containsKey ( "text" ) )
            {
                groupBorder.setLabel ( args.get ( "text" ) );
            }
            final Color color = createColor ( Helper.makeColor ( args.get ( "textColor" ) ) );
            if ( color != null )
            {
                groupBorder.setTextColor ( color );
            }

            return groupBorder;
        }
        if ( border.startsWith ( "TITLE:" ) )
        {
            final TitleBarBorder titleBorder = new TitleBarBorder ();

            final Map<String, String> args = parseBorderArguments ( "text", border.substring ( "TITLE:".length () ) );
            if ( args.containsKey ( "text" ) )
            {
                titleBorder.setLabel ( args.get ( "text" ) );
            }
            final Color color = createColor ( Helper.makeColor ( args.get ( "textColor" ) ) );
            if ( color != null )
            {
                titleBorder.setTextColor ( color );
            }
            final Color backgroundColor = createColor ( Helper.makeColor ( args.get ( "backgroundColor" ) ) );
            if ( backgroundColor != null )
            {
                titleBorder.setBackgroundColor ( backgroundColor );
            }

            return titleBorder;
        }
        if ( border.startsWith ( "MARGIN:" ) )
        {
            final Map<String, String> args = parseBorderArguments ( "inset", border.substring ( "MARGIN:".length () ) );
            if ( args.containsKey ( "inset" ) )
            {
                final String value = args.get ( "inset" );
                if ( value.contains ( "," ) )
                {
                    final String[] insets = args.get ( "inset" ).split ( ", ?" );
                    return new MarginBorder ( Integer.parseInt ( insets[0] ), Integer.parseInt ( insets[1] ), Integer.parseInt ( insets[2] ), Integer.parseInt ( insets[3] ) );
                }
                else
                {
                    return new MarginBorder ( Integer.parseInt ( args.get ( "inset" ) ) );
                }
            }
            else if ( args.containsKey ( "t" ) || args.containsKey ( "l" ) || args.containsKey ( "r" ) || args.containsKey ( "b" ) )
            {
                return new MarginBorder ( makeInt ( args, "t", 0 ), makeInt ( args, "l", 0 ), makeInt ( args, "b", 0 ), makeInt ( args, "r", 0 ) );
            }
            else
            {
                return new MarginBorder ( 0 );
            }
        }
        if ( border.startsWith ( "COMPOUND:" ) )
        {
            final Map<String, String> args = parseBorderArguments ( "", border.substring ( "COMPOUND:".length () ) );
            return new CompoundBorder ( makeBorder ( args.get ( "outer" ) ), makeBorder ( args.get ( "inner" ) ) );
        }

        StatusManager.getManager ().handle ( new Status ( IStatus.WARNING, Activator.PLUGIN_ID, "Invalid border string: " + border ), StatusManager.LOG );
        return null;
    }

    private int makeInt ( final Map<String, String> args, final String string, final int defaultValue )
    {
        final String value = args.get ( string );
        if ( value == null || value.isEmpty () )
        {
            return defaultValue;
        }
        return Integer.parseInt ( value );
    }

    protected Map<String, String> parseBorderArguments ( final String singleArgumentName, final String border )
    {
        if ( border == null || border.isEmpty () )
        {
            return Collections.emptyMap ();
        }
        if ( border.startsWith ( "[" ) && border.endsWith ( "]" ) )
        {
            final Map<String, String> result = new LinkedHashMap<String, String> ();
            final String str = border.substring ( 1, border.length () - 1 );
            for ( final String tok : str.split ( "[, \\t\\n\\r]" ) )
            {
                final String[] ele = tok.split ( "=", 2 );
                if ( ele.length > 1 )
                {
                    result.put ( ele[0], ele[1] );
                }
            }
            return result;
        }
        else
        {
            final Map<String, String> result = new LinkedHashMap<String, String> ( 1 );
            result.put ( singleArgumentName, border );
            return result;
        }
    }

    protected org.eclipse.draw2d.geometry.Dimension create ( final Dimension dimension )
    {
        if ( dimension == null )
        {
            return null;
        }
        return new PrecisionDimension ( dimension.getWidth (), dimension.getHeight () );
    }

    protected ColorHandler makeColorHandler ( final String color, final ColorApplier applier )
    {
        if ( color == null )
        {
            return new DefaultColor ( getPropertyFigure (), applier );
        }

        if ( color.startsWith ( "#" ) && !color.contains ( "|" ) )
        {
            return new StaticColor ( getPropertyFigure (), applier, createColor ( Helper.makeColor ( color ) ) );
        }
        else if ( ( color.startsWith ( "#" ) || color.startsWith ( "|" ) ) && color.contains ( "|" ) )
        {
            final String tok[] = color.split ( "\\|" );
            final Color onColor = createColor ( Helper.makeColor ( tok[0] ) );
            Color offColor;
            int stepCount = 1;
            if ( tok.length > 1 )
            {
                offColor = createColor ( Helper.makeColor ( tok[1] ) );
            }
            else
            {
                offColor = null;
            }
            if ( tok.length > 2 )
            {
                stepCount = Integer.parseInt ( tok[2] );
            }
            return new BlinkingColor ( getPropertyFigure (), applier, onColor, offColor, stepCount * 2 );
        }
        return new DefaultColor ( getPropertyFigure (), applier );
    }

    protected Color createColor ( final RGB rgb )
    {
        if ( rgb == null )
        {
            return null;
        }
        return this.manager.createColor ( rgb );
    }

}
