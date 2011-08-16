package org.openscada.vi.ui.draw2d;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.model.VisualInterface.XYChild;
import org.openscada.vi.model.VisualInterface.XYContainer;

public class ViewElementFactory
{
    public IFigure create ( final Primitive element )
    {
        if ( element instanceof XYContainer )
        {
            return createXYLayout ( (XYContainer)element );
        }
        else if ( element instanceof Text )
        {
            final Label label = new Label ( ( (Text)element ).getFormat () );
            label.setForegroundColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_BLACK ) );
            return label;
        }
        else if ( element instanceof Line )
        {
            return createLine ( (Line)element );
        }
        else if ( element instanceof Rectangle )
        {
            final PrecisionRectangle rect = new PrecisionRectangle ();
            rect.setPreciseSize ( ( (Rectangle)element ).getWidth (), ( (Rectangle)element ).getWidth () );
            final RectangleFigure fig = new RectangleFigure ();
            fig.setBounds ( rect );

            final Border border = new LineBorder ( 2 );
            fig.setBorder ( border );
            fig.setForegroundColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_BLACK ) );
            fig.setBackgroundColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_WHITE ) );

            return fig;
        }
        return null;
    }

    private IFigure createLine ( final Line element )
    {
        final PolylineShape polyline = new PolylineShape ();

        final PointList points = new PointList ();
        for ( final Position pos : element.getPoints () )
        {
            final Point p = new PrecisionPoint ( pos.getX (), pos.getY () );
            points.addPoint ( p );
        }
        polyline.setAntialias ( SWT.ON );
        polyline.setPoints ( points );

        polyline.setLineCap ( SWT.CAP_FLAT );
        polyline.setForegroundColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_BLACK ) );
        polyline.setBackgroundColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_WHITE ) );
        polyline.setLineWidth ( 1 );

        // set bounds from line data, expanding WTF
        polyline.setBounds ( points.getBounds ().expand ( 5, 5 ) );
        polyline.setOpaque ( true );

        return polyline;
    }

    private org.eclipse.draw2d.geometry.Rectangle create ( final Position position )
    {
        final org.eclipse.draw2d.geometry.PrecisionRectangle rect = new org.eclipse.draw2d.geometry.PrecisionRectangle ();
        rect.setPreciseLocation ( position.getX (), position.getY () );
        rect.setPreciseSize ( -1, -1 );
        return rect;
    }

    protected IFigure createXYLayout ( final XYContainer element )
    {
        final Figure pane = new Figure ();

        pane.setLayoutManager ( new XYLayout () );

        for ( final XYChild child : element.getChildren () )
        {
            final IFigure childFigure = create ( child.getElement () );
            pane.add ( childFigure, create ( child.getPosition () ) );
        }

        return pane;
    }
}
