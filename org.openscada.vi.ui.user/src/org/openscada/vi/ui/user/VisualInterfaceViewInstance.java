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

package org.openscada.vi.ui.user;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.services.IEvaluationService;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.data.SummaryListener;
import org.openscada.vi.data.SummaryProvider;
import org.openscada.vi.ui.draw2d.VisualInterfaceViewer;
import org.openscada.vi.ui.user.viewer.AbstractViewInstance;
import org.openscada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.openscada.vi.ui.user.viewer.ViewManager;
import org.openscada.vi.ui.user.viewer.ViewManagerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisualInterfaceViewInstance extends AbstractViewInstance implements SummaryListener, SummaryProvider
{
    private final static Logger logger = LoggerFactory.getLogger ( VisualInterfaceViewInstance.class );

    private VisualInterfaceViewer viewer;

    private final Composite parent;

    private final LinkedHashMap<String, Object> scriptObjects;

    private SummaryInformation currentSummary;

    private final Set<SummaryListener> summaryListeners = new LinkedHashSet<SummaryListener> ();

    public VisualInterfaceViewInstance ( final ViewManager viewManager, final ViewManagerContext viewManagerContext, final Composite parent, final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        super ( viewManagerContext, descriptor, evaluationService );
        this.parent = parent;

        // create the visual interface view

        this.scriptObjects = new LinkedHashMap<String, Object> ();
        this.scriptObjects.put ( "viewManager", viewManager );
    }

    @Override
    protected void activateView ()
    {
        if ( this.viewer != null )
        {
            return;
        }

        this.viewer = new VisualInterfaceViewer ( this.parent, SWT.NONE, this.descriptor.getUri (), this.scriptObjects, this.descriptor.getProperties () );
        this.viewer.setZooming ( this.descriptor.getZooming () );
        this.viewer.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        // always add summary listener if we are active
        this.viewer.addSummaryListener ( this );
    }

    @Override
    protected void deactivateView ()
    {
        if ( this.viewer != null )
        {
            this.viewer.removeSummaryListener ( this );

            this.viewer.dispose ();
            this.viewer = null;
        }
    }

    @Override
    public void dispose ()
    {
        if ( this.viewer != null )
        {
            this.viewer.removeSummaryListener ( this );
            this.viewer.dispose ();
            this.viewer = null;
        }

        super.dispose ();
    }

    @Override
    public void setFocus ()
    {
        this.viewer.setFocus ();
    }

    @Override
    public Control getControl ()
    {
        return this.viewer;
    }

    @Override
    public SummaryInformation getSummary ()
    {
        return this.currentSummary;
    }

    @Override
    public void summaryChanged ( final SummaryInformation summary )
    {
        logger.debug ( "Summary changed: {}", summary );
        this.currentSummary = summary;
        fireSummaryChanged ( summary );
    }

    private void fireSummaryChanged ( final SummaryInformation summary )
    {
        for ( final SummaryListener listener : this.summaryListeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.summaryChanged ( summary );
                }
            } );
        }
    }

    @Override
    public void addSummaryListener ( final SummaryListener summaryListener )
    {
        this.summaryListeners.add ( summaryListener );
    }

    @Override
    public void removeSummaryListener ( final SummaryListener summaryListener )
    {
        this.summaryListeners.remove ( summaryListener );
    }
}
