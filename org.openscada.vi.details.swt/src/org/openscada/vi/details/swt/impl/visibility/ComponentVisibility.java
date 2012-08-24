/*
 * This file is part of the openSCADA project
 * Copyright (C) 2011-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

package org.openscada.vi.details.swt.impl.visibility;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.openscada.vi.details.swt.impl.visibility.VisibilityProvider.Listener;

public class ComponentVisibility
{
    private final VisibilityProvider provider;

    private final Listener listener;

    private boolean state = true;

    private final VisibleComponent component;

    private final WritableSet descriptors = new WritableSet ();

    private final IObservableSet componentDescriptors;

    private final ISetChangeListener setListener = new ISetChangeListener () {

        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            ComponentVisibility.this.handleSetChange ( event.diff );
        }
    };

    public ComponentVisibility ( final VisibilityProvider provider, final VisibleComponent component )
    {
        this.provider = provider;
        this.component = component;
        this.componentDescriptors = component.getDescriptors ();

        component.create ();
        attachDescriptors ();

        this.listener = new Listener () {

            @Override
            public void visibilityChanged ( final boolean state )
            {
                handleVisibilityChanged ( state );
            }
        };

        this.provider.addListener ( this.listener );
    }

    protected void handleSetChange ( final SetDiff diff )
    {
        diff.applyTo ( this.descriptors );
    }

    protected void handleVisibilityChanged ( final boolean state )
    {
        if ( this.state == state )
        {
            return;
        }

        this.state = state;

        if ( state )
        {
            show ();
        }
        else
        {
            hide ();
        }
    }

    protected void hide ()
    {
        this.component.hide ();
        detachDescriptors ();
    }

    protected void show ()
    {
        this.component.show ();
        attachDescriptors ();
    }

    private void attachDescriptors ()
    {
        this.componentDescriptors.addSetChangeListener ( this.setListener );
        this.descriptors.addAll ( this.componentDescriptors );
    }

    private void detachDescriptors ()
    {
        this.componentDescriptors.removeSetChangeListener ( this.setListener );
        this.descriptors.clear ();
    }

    public void dispose ()
    {
        this.provider.dispose ();
        this.component.dispose ();
    }

    public IObservableSet getDescriptors ()
    {
        return this.descriptors;
    }
}
