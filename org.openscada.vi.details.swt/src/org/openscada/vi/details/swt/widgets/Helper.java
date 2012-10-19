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

package org.openscada.vi.details.swt.widgets;

import org.eclipse.swt.SWT;
import org.openscada.vi.details.swt.widgets.control.ControlImage;
import org.openscada.vi.details.swt.widgets.control.TrendControlImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helper
{

    private final static Logger logger = LoggerFactory.getLogger ( Helper.class );

    public static TrendControlImage createTrendButton ( final ControlImage controlImage, final String connectionId, final String itemId )
    {
        logger.debug ( "Checking createTrendButton - connectionId: {}, itemId: {}", connectionId, itemId );

        if ( connectionId == null || connectionId.isEmpty () )
        {
            return null;
        }

        if ( itemId == null || itemId.isEmpty () )
        {
            return null;
        }

        return new TrendControlImage ( controlImage.getClientSpace (), SWT.NONE, connectionId, itemId );
    }
}
