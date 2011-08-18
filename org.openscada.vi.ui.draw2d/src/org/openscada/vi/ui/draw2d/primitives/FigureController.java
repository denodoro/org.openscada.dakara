package org.openscada.vi.ui.draw2d.primitives;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.script.ScriptException;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.model.VisualInterface.Cursor;
import org.openscada.vi.model.VisualInterface.Dimension;
import org.openscada.vi.model.VisualInterface.Figure;
import org.openscada.vi.model.VisualInterface.SystemCursor;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;
import org.openscada.vi.ui.draw2d.SymbolController;

public abstract class FigureController implements Controller
{
    private final ResourceManager manager;

    private final SymbolController controller;

    private ScriptExecutor onClick;

    private ScriptExecutor onDoubleClick;

    public FigureController ( final SymbolController controller, final ResourceManager manager )
    {
        this.manager = manager;
        this.controller = controller;
    }

    protected void applyCommon ( final Figure figure )
    {
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

    public void setBackgroundColor ( final String color )
    {
        getFigure ().setBackgroundColor ( makeColor ( color ) );
    }

    public void setForegroundColor ( final String color )
    {
        getFigure ().setForegroundColor ( makeColor ( color ) );
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

    protected Color makeColor ( final String color )
    {
        if ( color == null )
        {
            return null;
        }

        if ( color.startsWith ( "#" ) )
        {
            if ( color.length () == 1 + 3 )
            {
                return this.manager.createColor ( makeColor ( color.substring ( 1, 2 ), color.substring ( 2, 3 ), color.substring ( 3, 4 ) ) );
            }
            else if ( color.length () >= 1 + 6 )
            {
                return this.manager.createColor ( makeColor ( color.substring ( 1, 3 ), color.substring ( 3, 5 ), color.substring ( 5, 7 ) ) );
            }
            return null;
        }
        return null;
    }

    protected static ColorDescriptor makeColor ( final String r, final String g, final String b )
    {
        return makeColor ( Integer.parseInt ( r, 16 ), Integer.parseInt ( g, 16 ), Integer.parseInt ( b, 16 ) );
    }

    protected static ColorDescriptor makeColor ( final int r, final int g, final int b )
    {
        return ColorDescriptor.createFrom ( new RGB ( r, g, b ) );
    }
}
