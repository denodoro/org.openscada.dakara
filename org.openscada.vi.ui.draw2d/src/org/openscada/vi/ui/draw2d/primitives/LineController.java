package org.openscada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.ui.draw2d.SymbolController;

public class LineController extends FigureController
{
    private final PolylineShape figure;

    public LineController ( final SymbolController controller, final Line element, final ResourceManager manager )
    {
        super ( controller, manager );

        this.figure = new PolylineShape () {
            @Override
            public void addNotify ()
            {
                super.addNotify ();
                start ();
            }

            @Override
            public void removeNotify ()
            {
                stop ();
                super.removeNotify ();
            }
        };

        final PointList points = new PointList ();
        for ( final Position pos : element.getPoints () )
        {
            final Point p = new PrecisionPoint ( pos.getX (), pos.getY () );
            points.addPoint ( p );
        }
        this.figure.setAntialias ( SWT.ON );
        this.figure.setPoints ( points );

        this.figure.setLineCap ( SWT.CAP_SQUARE );
        this.figure.setLineWidth ( element.getLineWidth () );

        // set bounds from line data, expanding WTF
        this.figure.setBounds ( points.getBounds ().expand ( 5, 5 ) );
        this.figure.setOpaque ( true );

        controller.addElement ( element.getName (), this );

        applyCommon ( element );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }
}
