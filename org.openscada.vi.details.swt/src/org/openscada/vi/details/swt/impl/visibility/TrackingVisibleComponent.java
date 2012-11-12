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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.swt.widgets.Control;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.widgets.GenericComposite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TrackingVisibleComponent implements VisibleComponent
{

    private final static Logger logger = LoggerFactory.getLogger ( TrackingVisibleComponent.class );

    private final List<Control> controls = new LinkedList<Control> ();

    private final WritableSet items = new WritableSet ();

    protected void trackControl ( final Control control )
    {
        this.controls.add ( control );
    }

    protected void untrackControl ( final Control control )
    {
        this.controls.remove ( control );
    }

    @Override
    public void start ()
    {
        for ( final Control control : this.controls )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).start ();
            }
        }
    }

    @Override
    public void stop ()
    {
        for ( final Control control : this.controls )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).stop ();
            }
        }
    }

    @Override
    public void show ()
    {
        logger.debug ( "Showing component" );

        for ( final Control control : this.controls )
        {
            control.setVisible ( true );
        }
    }

    @Override
    public void hide ()
    {
        for ( final Control control : this.controls )
        {
            control.setVisible ( false );
        }
    }

    @Override
    public void dispose ()
    {
        for ( final Control control : this.controls )
        {
            control.dispose ();
        }
    }

    protected void trackItem ( final DataItemDescriptor item )
    {
        if ( item != null )
        {
            this.items.add ( item );
        }
    }

    protected void untrackItem ( final DataItemDescriptor item )
    {
        this.items.remove ( item );
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        return this.items;
    }

}
