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

package org.openscada.vi.details;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailViewManager
{

    private static final Logger logger = LoggerFactory.getLogger ( DetailViewManager.class );

    private static final String EXTP_DETAIL_VIEW = "org.openscada.vi.details.detailView"; //$NON-NLS-1$

    public static DetailView openView ( final String id, final Map<String, String> properties ) throws CoreException
    {
        logger.info ( "Searching view: {}", id ); //$NON-NLS-1$

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_DETAIL_VIEW ) )
        {
            final String cfgId = ele.getAttribute ( "id" ); //$NON-NLS-1$

            logger.debug ( "Checking: {}", cfgId ); //$NON-NLS-1$

            if ( cfgId != null && cfgId.equals ( id ) )
            {
                return createDetailView ( id, ele, properties );
            }
        }
        return null;
    }

    private static DetailView createDetailView ( final String id, final IConfigurationElement ele, final Map<String, String> properties ) throws CoreException
    {
        final Object o = ele.createExecutableExtension ( "class" ); //$NON-NLS-1$
        if ( o instanceof DetailView )
        {
            final DetailView view = (DetailView)o;
            return view;
        }
        else
        {
            logger.warn ( "View created object of type: " + o ); //$NON-NLS-1$
            return null;
        }
    }
}
