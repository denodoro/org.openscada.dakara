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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.UnionSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.openscada.vi.details.swt.DetailComponent;

public abstract class SubTrackingVisibleComponent extends TrackingVisibleComponent
{
    private final Set<DetailComponent> subs = new HashSet<DetailComponent> ();

    private final WritableSet descriptors = new WritableSet ();

    private IObservableSet unionSet = Observables.emptyObservableSet ();

    private final ISetChangeListener setListener = new ISetChangeListener () {

        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            event.diff.applyTo ( SubTrackingVisibleComponent.this.descriptors );
        }
    };

    @Override
    public void start ()
    {
        super.start ();
        for ( final DetailComponent component : this.subs )
        {
            component.start ();
        }
    };

    @Override
    public void stop ()
    {
        for ( final DetailComponent component : this.subs )
        {
            component.stop ();
        }
        super.stop ();
    };

    protected void trackSub ( final DetailComponent subComponent )
    {
        this.subs.add ( subComponent );
        update ();
    }

    protected void untrackSub ( final DetailComponent subComponent )
    {
        this.subs.remove ( subComponent );
        update ();
    }

    private void update ()
    {
        this.unionSet.removeSetChangeListener ( this.setListener );
        this.unionSet.dispose ();
        this.descriptors.clear ();

        final List<IObservableSet> childSets = new LinkedList<IObservableSet> ();

        for ( final DetailComponent component : this.subs )
        {
            childSets.add ( component.getDescriptors () );
        }

        if ( childSets.isEmpty () )
        {
            this.unionSet = Observables.emptyObservableSet ();
        }
        else
        {
            this.unionSet = new UnionSet ( childSets.toArray ( new IObservableSet[childSets.size ()] ) );
        }

        this.unionSet.addSetChangeListener ( this.setListener );
        this.descriptors.addAll ( this.unionSet );
    }

    @Override
    public void dispose ()
    {
        for ( final DetailComponent sub : this.subs )
        {
            sub.dispose ();
        }
        super.dispose ();
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        return new UnionSet ( new IObservableSet[] { super.getDescriptors (), this.descriptors } );
    }
}
