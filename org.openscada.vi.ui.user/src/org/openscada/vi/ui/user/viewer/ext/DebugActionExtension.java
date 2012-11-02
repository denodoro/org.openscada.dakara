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

package org.openscada.vi.ui.user.viewer.ext;

import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.openscada.vi.ui.user.Activator;
import org.openscada.vi.ui.user.viewer.ViewManager;

public class DebugActionExtension implements ViewerExtension
{

    public static boolean hasDebug ()
    {
        return Boolean.getBoolean ( "vi.debug" ); //$NON-NLS-1$
    }

    public static class DebugHandler
    {

        private final Label label;

        private Action reloadAction;

        private final ViewManager viewManager;

        public DebugHandler ( final Composite parent, final ViewManager viewManager )
        {
            this.viewManager = viewManager;
            this.label = new Label ( parent, SWT.NONE );

            final ResourceManager manager = new LocalResourceManager ( JFaceResources.getResources ( this.label.getDisplay () ), this.label );

            this.label.setImage ( manager.createImageWithDefault ( ImageDescriptor.createFromURL ( FileLocator.find ( Activator.getDefault ().getBundle (), new Path ( "/resources/debugIcon.png" ), Collections.EMPTY_MAP ) ) ) ); //$NON-NLS-1$

            final MenuManager menuManager = new MenuManager ( "#PopupMenu", "org.openscada.vi.ui.user.debugMenu" ); //$NON-NLS-1$ //$NON-NLS-2$

            menuManager.setRemoveAllWhenShown ( true );

            this.label.setMenu ( menuManager.createContextMenu ( this.label ) );

            createActions ();

            menuManager.addMenuListener ( new IMenuListener () {
                @Override
                public void menuAboutToShow ( final IMenuManager menuManager )
                {
                    contextMenuAboutToShow ( menuManager );
                }
            } );

            viewManager.registerMenuManager ( menuManager );
        }

        public Control getControl ()
        {
            return this.label;
        }

        protected void contextMenuAboutToShow ( final IMenuManager menuManager )
        {
            menuManager.add ( this.reloadAction );
            menuManager.add ( new Separator () );
            menuManager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
        }

        private void createActions ()
        {
            this.reloadAction = new Action ( "Reload" ) {
                @Override
                public void run ()
                {
                    DebugHandler.this.viewManager.reloadCurrentView ();
                }
            };
        }

    }

    @Override
    public Control create ( final Composite parent, final ViewManager viewManager, final boolean horizontal )
    {
        if ( !hasDebug () )
        {
            return null;
        }

        return new DebugHandler ( parent, viewManager ).getControl ();
    }

}
