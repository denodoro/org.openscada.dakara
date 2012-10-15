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

package org.openscada.vi.ui.draw2d;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.draw2d.Label;

public class ErrorFigure extends Label
{

    public ErrorFigure ()
    {
        setOpaque ( true );
    }

    public void setException ( final Throwable e )
    {
        setText ( String.format ( "%s", e ) );
        setToolTip ( new Label ( formatException ( e ) ) );
    }

    private static String formatException ( final Throwable e )
    {
        final StringWriter sw = new StringWriter ();
        final PrintWriter pw = new PrintWriter ( sw );

        e.printStackTrace ( pw );
        pw.close ();
        return sw.toString ();
    }

}
