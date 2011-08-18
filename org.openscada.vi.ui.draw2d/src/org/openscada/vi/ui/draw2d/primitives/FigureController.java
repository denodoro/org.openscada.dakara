package org.openscada.vi.ui.draw2d.primitives;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.script.ScriptException;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.openscada.ui.utils.blink.AbstractBlinker;
import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.model.VisualInterface.Cursor;
import org.openscada.vi.model.VisualInterface.Dimension;
import org.openscada.vi.model.VisualInterface.Figure;
import org.openscada.vi.model.VisualInterface.SystemCursor;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;
import org.openscada.vi.ui.draw2d.SymbolController;

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

    protected final ResourceManager manager;

    private final SymbolController controller;

    private ScriptExecutor onClick;

    private ScriptExecutor onDoubleClick;

    private final Map<Object, BaseColor> colorHandler = new HashMap<Object, FigureController.BaseColor> ();

    public FigureController ( final SymbolController controller, final ResourceManager manager )
    {
        this.manager = manager;
        this.controller = controller;
    }

    protected void internalDispose ()
    {
        for ( final BaseColor color : this.colorHandler.values () )
        {
            color.dispose ();
        }
        this.colorHandler.clear ();
    }

    protected void applyCommon ( final Figure figure )
    {
        getFigure ().addAncestorListener ( new AncestorListener () {
            @Override
            public void ancestorAdded ( final IFigure ancestor )
            {
                System.out.println ( "added: " + ancestor );
            }

            @Override
            public void ancestorMoved ( final IFigure ancestor )
            {
            }

            @Override
            public void ancestorRemoved ( final IFigure ancestor )
            {
                System.out.println ( "removed: " + ancestor );
            };
        } );

        setBackgroundColor ( figure.getBackgroundColor () );
        setForegroundColor ( figure.getForegroundColor () );

        setPreferredSize ( create ( figure.getSize () ) );

        setCursor ( convert ( figure.getCursor () ) );
        setVisible ( figure.isVisible () );

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

    protected org.eclipse.swt.graphics.Cursor getCursor ( final String cursor )
    {
        if ( "ARROW".equals ( cursor ) )
        {
            return Display.getDefault ().getSystemCursor ( SWT.CURSOR_ARROW );
        }
        else if ( "HAND".equals ( cursor ) )
        {
            return Display.getDefault ().getSystemCursor ( SWT.CURSOR_HAND );
        }
        else
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

    private static interface BaseColor
    {
        public void start ();

        public void dispose ();
    }

    private static class DefaultColor implements BaseColor
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
        public void dispose ()
        {
            // nothing to do  
        }
    }

    private static class StaticColor implements BaseColor
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
        public void dispose ()
        {
            // nothing to do
        }
    }

    private static class BlinkingColor extends AbstractBlinker implements BaseColor
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
        public void toggle ( final boolean on )
        {
            this.applier.applyColor ( this.figure, on ? this.onColor : this.offColor );
        }
    }

    public void setBackgroundColor ( final String color )
    {
        final BaseColor colorHandler = makeColorHandler ( color, new BackgroundApplier () );
        setColor ( "backgroundColor", colorHandler );
    }

    public void setForegroundColor ( final String color )
    {
        final BaseColor colorHandler = makeColorHandler ( color, new ForegroundApplier () );
        setColor ( "foregroundColor", colorHandler );
    }

    protected void setColor ( final Object key, final BaseColor colorHandler )
    {
        final BaseColor oldColorHandler = this.colorHandler.put ( key, colorHandler );
        if ( oldColorHandler != null )
        {
            oldColorHandler.dispose ();
        }
        colorHandler.start ();
    }

    public void setVisible ( final boolean flag )
    {
        getFigure ().setVisible ( flag );
    }

    protected org.eclipse.draw2d.geometry.Dimension create ( final Dimension dimension )
    {
        if ( dimension == null )
        {
            return null;
        }
        return new PrecisionDimension ( dimension.getWidth (), dimension.getHeight () );
    }

    protected BaseColor makeColorHandler ( final String color, final ColorApplier applier )
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
