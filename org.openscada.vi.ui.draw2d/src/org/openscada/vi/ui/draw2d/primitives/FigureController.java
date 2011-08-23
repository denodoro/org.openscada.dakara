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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.script.ScriptException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.GroupBoxBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.draw2d.geometry.PrecisionDimension;
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
import org.openscada.vi.ui.draw2d.SymbolController;

/**
 * A figure controller
 * <p>
 * This figure controller needs to know when the figure it controls was added
 * or removed. Since draw2d does not provide a "addRemovedListener" for IFigure
 * but a {@link IFigure#removeNotify()} that can be overridden it is the
 * responsibility of the implementing controller to call {@link #start()} and
 * {@link #stop()} when the implementing {@link IFigure#addNotify()} and
 * {@link IFigure#removeNotify()} get called.
 * So create your figure like the following snippet shows:
 * <code><pre>
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
 * @author Jens Reimann
 *
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
            enableBlinking ( this.frequency );
        }

        @Override
        public void stop ()
        {
            super.dispose ();
        }

        @Override
        public void toggle ( final boolean on )
        {
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
            getFigure ().addMouseListener ( new MouseListener.Stub () {
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
        getFigure ().setCursor ( getCursor ( cursor ) );
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
        final Map<String, Object> scriptObjects = new LinkedHashMap<String, Object> ( 1 );
        scriptObjects.put ( "event", me );
        this.controller.execute ( this.onDoubleClick, scriptObjects );
    }

    protected void handleOnClick ( final MouseEvent me )
    {
        final Map<String, Object> scriptObjects = new LinkedHashMap<String, Object> ( 1 );
        scriptObjects.put ( "event", me );
        this.controller.execute ( this.onClick, scriptObjects );
    }

    public void setPreferredSize ( final org.eclipse.draw2d.geometry.Dimension size )
    {
        getFigure ().setPreferredSize ( size );
    }

    public Dimension getPreferredSize ()
    {
        final Dimension dimension = VisualInterfaceFactory.eINSTANCE.createDimension ();
        final org.eclipse.draw2d.geometry.Dimension size = getFigure ().getPreferredSize ();
        dimension.setHeight ( size.preciseWidth () );
        dimension.setWidth ( size.preciseWidth () );
        return dimension;
    }

    public void setPreferredWidth ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( value );
        dim.setPreciseHeight ( getFigure ().getPreferredSize ().preciseHeight () );

        getFigure ().setPreferredSize ( dim );
    }

    public void setPreferredHeight ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( getFigure ().getPreferredSize ().preciseWidth () );
        dim.setPreciseHeight ( value );

        getFigure ().setPreferredSize ( dim );
    }

    public void setBorder ( final String border )
    {
        getFigure ().setBorder ( makeBorder ( border ) );
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
        getFigure ().setVisible ( flag );
    }

    public abstract void setOpaque ( final Boolean flag );

    protected void setOpaque ( final Boolean flag, final boolean defaultValue )
    {
        if ( flag == null )
        {
            getFigure ().setOpaque ( defaultValue );
        }
        else
        {
            getFigure ().setOpaque ( flag );
        }
    }

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

        if ( border.startsWith ( "GROUP:" ) )
        {
            return new GroupBoxBorder ( border.substring ( "GROUP:".length () ) );
        }
        if ( border.startsWith ( "TITLE:" ) )
        {
            return new TitleBarBorder ( border.substring ( "TITLE:".length () ) );
        }

        StatusManager.getManager ().handle ( new Status ( IStatus.WARNING, Activator.PLUGIN_ID, "Invalid border string: " + border ), StatusManager.LOG );
        return null;
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
            return new DefaultColor ( getFigure (), applier );
        }

        if ( color.startsWith ( "#" ) && !color.contains ( "|" ) )
        {
            return new StaticColor ( getFigure (), applier, createColor ( Helper.makeColor ( color ) ) );
        }
        else if ( ( color.startsWith ( "#" ) || color.startsWith ( "|" ) ) && color.contains ( "|" ) )
        {
            final String tok[] = color.split ( "\\|" );
            final Color onColor = createColor ( Helper.makeColor ( tok[0] ) );
            Color offColor;
            int frequency = 1;
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
                frequency = Integer.parseInt ( tok[2] );
            }
            return new BlinkingColor ( getFigure (), applier, onColor, offColor, frequency );
        }
        return new DefaultColor ( getFigure (), applier );
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
