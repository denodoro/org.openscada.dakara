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

import java.util.Collection;
import java.util.Map;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.openscada.vi.details.model.DetailView.Registration;
import org.openscada.vi.details.swt.data.ControllerListener;
import org.openscada.vi.details.swt.data.DataController;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.impl.DetailComponentImpl;

public abstract class GenericComposite extends Composite implements ControllerListener
{
    protected final DataController controller;

    public GenericComposite ( final Composite parent, final int style, final Collection<Registration> registrations, final Map<String, String> properties )
    {
        super ( parent, style );

        this.controller = new DataController ( this );

        if ( registrations != null )
        {
            for ( final Registration reg : registrations )
            {
                final DataItemDescriptor descriptor = DataItemDescriptor.create ( DetailComponentImpl.resolve ( reg.getDescriptor (), properties ) );
                this.controller.registerItem ( reg.getKey (), descriptor, reg.isAggregateState () );
            }
        }

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
    }

    public void start ()
    {
        this.controller.start ();
        for ( final Control control : getChildren () )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).start ();
            }
        }
    }

    public void stop ()
    {
        for ( final Control control : getChildren () )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).stop ();
            }
        }
        this.controller.stop ();
    }

    protected void handleDispose ()
    {
        this.controller.dispose ();
    }

    @Override
    public void dispose ()
    {
        handleDispose ();
        super.dispose ();
    }
}
