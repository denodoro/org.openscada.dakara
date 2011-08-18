package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.openscada.vi.model.VisualInterface.Alignment;
import org.openscada.vi.model.VisualInterface.Orientation;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.ui.draw2d.SymbolController;

public class TextController extends FigureController
{
    private final Label figure;

    private final FigureCanvas canvas;

    public TextController ( final FigureCanvas canvas, final SymbolController controller, final Text element, final ResourceManager manager )
    {
        super ( controller, manager );
        this.canvas = canvas;
        this.figure = new Label ( element.getText () );
        controller.addElement ( element.getName (), this );

        applyCommon ( element );
    }

    protected void applyCommon ( final Text element )
    {
        super.applyCommon ( element );
        this.figure.setTextAlignment ( convertAlignment ( element.getTextAlignment (), PositionConstants.CENTER ) );
        this.figure.setLabelAlignment ( convertAlignment ( element.getLabelAlignment (), PositionConstants.CENTER ) );
        this.figure.setIconAlignment ( convertAlignment ( element.getIconAlignment (), PositionConstants.CENTER ) );
        this.figure.setTextPlacement ( convertOrientation ( element.getTextPlacement (), PositionConstants.EAST ) );

        setFontFull ( element.getFontName (), element.getFontSize (), element.isFontBold (), element.isFontItalic () );
    }

    public void setFont ( final String fontName, final int fontSize )
    {
        setFontFull ( fontName, fontSize, false, false );
    }

    public void setFontFull ( final String fontName, final int fontSize, final boolean bold, final boolean italic )
    {
        this.figure.setFont ( convertFont ( fontName, fontSize, bold, italic ) );
    }

    private Font convertFont ( final String fontName, final int fontSize, final boolean bold, final boolean italic )
    {
        if ( fontName == null && fontSize <= 0 )
        {
            return null;
        }

        if ( fontName != null && fontSize > 0 )
        {
            return this.manager.createFont ( FontDescriptor.createFrom ( fontName, fontSize, makeStyle ( bold, italic ) ) );
        }
        else
        {
            Font font = this.figure.getFont ();
            if ( font == null )
            {
                font = this.canvas.getFont ();
            }
            if ( font == null )
            {
                font = Display.getDefault ().getSystemFont ();
            }
            final FontData[] fontData = FontDescriptor.copy ( font.getFontData () );
            for ( final FontData fd : fontData )
            {
                if ( fontName != null )
                {
                    fd.setName ( fontName );
                }
                if ( fontSize > 0 )
                {
                    fd.setHeight ( fontSize );
                }
                fd.setStyle ( makeStyle ( bold, italic ) );
            }
            return this.manager.createFont ( FontDescriptor.createFrom ( fontData ) );
        }
    }

    private int makeStyle ( final boolean bold, final boolean italic )
    {
        return SWT.NORMAL | ( bold ? SWT.BOLD : 0 ) | ( italic ? SWT.ITALIC : 0 );
    }

    private int convertOrientation ( final Orientation orientation, final int defaultValue )
    {
        if ( orientation == null )
        {
            return defaultValue;
        }
        else
        {
            return convertPosition ( orientation.getName (), defaultValue );
        }
    }

    private int convertAlignment ( final Alignment alignment, final int defaultValue )
    {
        if ( alignment == null )
        {
            return defaultValue;
        }
        else
        {
            return convertPosition ( alignment.getName (), defaultValue );
        }
    }

    protected int convertPosition ( final String position, final int defaultValue )
    {
        if ( "CENTER".equals ( position ) )
        {
            return PositionConstants.CENTER;
        }
        else if ( "LEFT".equals ( position ) )
        {
            return PositionConstants.LEFT;
        }
        else if ( "RIGHT".equals ( position ) )
        {
            return PositionConstants.RIGHT;
        }
        else if ( "TOP".equals ( position ) )
        {
            return PositionConstants.TOP;
        }
        else if ( "BOTTOM".equals ( position ) )
        {
            return PositionConstants.BOTTOM;
        }
        else if ( "EAST".equals ( position ) )
        {
            return PositionConstants.EAST;
        }
        else if ( "WEST".equals ( position ) )
        {
            return PositionConstants.WEST;
        }
        else if ( "NORTH".equals ( position ) )
        {
            return PositionConstants.NORTH;
        }
        else if ( "SOUTH".equals ( position ) )
        {
            return PositionConstants.SOUTH;
        }

        return defaultValue;
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

    public void setText ( final String text )
    {
        this.figure.setText ( text );
    }
}
