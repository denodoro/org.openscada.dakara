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

package org.openscada.vi.ui.draw2d;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.openscada.vi.ui.draw2d"; //$NON-NLS-1$

    private static final String EXTP_VIEW_ELEMENT_FACTORY = "org.openscada.vi.ui.draw2d.viewElementFactory";

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator ()
    {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        plugin = null;
        super.stop ( context );
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault ()
    {
        return plugin;
    }

    public static ViewElementFactory createFactory ( final EObject modelObject ) throws CoreException
    {
        if ( modelObject == null )
        {
            return null;
        }

        final String requestedClass = modelObject.eClass ().getInstanceClassName ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_VIEW_ELEMENT_FACTORY ) )
        {
            if ( !"factory".equals ( ele.getName () ) )
            {
                continue;
            }

            for ( final IConfigurationElement child : ele.getChildren ( "supports" ) )
            {
                final String modelClass = child.getAttribute ( "modelClass" );
                if ( modelClass == null || modelClass.isEmpty () )
                {
                    continue;
                }

                if ( modelClass.equals ( requestedClass ) )
                {
                    return (ViewElementFactory)ele.createExecutableExtension ( "class" );
                }
            }

        }
        return null;
    }
}
