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

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.openscada.vi.model.VisualInterface.Shape;
import org.openscada.vi.ui.draw2d.SymbolController;

public abstract class ShapeController extends FigureController
{

    public ShapeController ( final SymbolController controller, final ResourceManager manager )
    {
        super ( controller, manager );
    }

    protected void applyCommon ( final Shape element )
    {
        super.applyCommon ( element );

        setLineWidth ( element.getLineWidth () );
        setAntialias ( element.getAntialias () );
        setAlpha ( element.getAlpha () );
        setFill ( element.isFill () );
        setOutline ( element.isOutline () );
    }

    public void setOutline ( final boolean flag )
    {
        getPropertyFigure ().setOutline ( flag );
    }

    public void setAlpha ( final Double alpha )
    {
        if ( alpha != null )
        {
            getPropertyFigure ().setAlpha ( (int) ( Math.max ( 0.0, Math.min ( 1.0, alpha ) ) * 255.0 ) );
        }
        else
        {
            getPropertyFigure ().setAlpha ( null );
        }
    }

    public void setLineWidth ( final float width )
    {
        getPropertyFigure ().setLineWidthFloat ( width );
    }

    public void setFill ( final boolean state )
    {
        getPropertyFigure ().setFill ( state );
    }

    protected void setAntialias ( final Boolean value, final boolean defaultValue )
    {
        if ( value == null )
        {
            getPropertyFigure ().setAntialias ( defaultValue ? SWT.ON : SWT.OFF );
        }
        else
        {
            getPropertyFigure ().setAntialias ( value ? SWT.ON : SWT.OFF );
        }
    }

    public abstract void setAntialias ( Boolean value );

    @Override
    protected abstract org.eclipse.draw2d.Shape getPropertyFigure ();

}