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

package org.openscada.vi.details.swt;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.openscada.utils.concurrent.NamedThreadFactory;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.openscada.vi.details.swt"; //$NON-NLS-1$

    public static final String IMG_CONTROLLER_BLOCKED = "blocked";

    public static final String IMG_CONTROLLER_UNBLOCKED = "unblocked";

    public static final String IMG_WARN_BIG = "warn.big";

    public static final String IMG_TREND = "trend";

    // The shared instance
    private static Activator plugin;

    private ExecutorService executor;

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
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "Image Loader" ) );
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.executor.shutdownNow ();

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

    public static Executor getExecutor ()
    {
        return plugin.executor;
    }

    @Override
    protected void initializeImageRegistry ( final ImageRegistry reg )
    {
        super.initializeImageRegistry ( reg );
        reg.put ( IMG_CONTROLLER_BLOCKED, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/blocked.gif" ) );
        reg.put ( IMG_CONTROLLER_UNBLOCKED, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/unblocked.gif" ) );
        reg.put ( IMG_WARN_BIG, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/warn.gif" ) );
        reg.put ( IMG_TREND, imageDescriptorFromPlugin ( PLUGIN_ID, "icons/trend_10.png" ) );
    }

}
