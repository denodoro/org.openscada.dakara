package org.openscada.vi.ui.user;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.openscada.vi.ui.draw2d.SummaryInformation;
import org.openscada.vi.ui.draw2d.SummaryListener;
import org.openscada.vi.ui.draw2d.VisualInterfaceViewer;

public class ViewInstance implements SummaryListener
{
    private ToolItem button;

    private final ViewManager viewManager;

    private VisualInterfaceViewer viewer;

    private final ViewInstanceDescriptor descriptor;

    public ViewInstance ( final ViewManager viewManager, final Composite parent, final ToolBar toolbar, final ViewInstanceDescriptor descriptor )
    {
        this.viewManager = viewManager;
        this.descriptor = descriptor;

        // create the main button
        if ( descriptor.getParentId () == null || descriptor.getParentId ().isEmpty () )
        {
            this.button = new ToolItem ( toolbar, SWT.RADIO );
            this.button.setText ( descriptor.getName () );
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final org.eclipse.swt.events.SelectionEvent e )
                {
                    showView ( descriptor.getId () );
                };
            } );
        }
        else
        {
            this.button = null;
        }

        // create the visual interface view

        final Map<String, Object> scriptObjects = new LinkedHashMap<String, Object> ();
        scriptObjects.put ( "viewManager", viewManager );

        this.viewer = new VisualInterfaceViewer ( parent, SWT.NONE, descriptor.getUri (), scriptObjects, descriptor.getProperties () );
        this.viewer.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        if ( this.button != null )
        {
            this.viewer.addSummaryListener ( this );
        }
    }

    protected void showView ( final String id )
    {
        this.viewManager.showView ( id );
    }

    public void dispose ()
    {
        if ( this.button != null )
        {
            this.viewer.removeSummaryListener ( this );
            this.button.dispose ();
            this.button = null;
        }
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
            this.viewer = null;
        }
    }

    public void deactivate ()
    {
        if ( this.button != null )
        {
            this.button.setSelection ( false );
        }
    }

    public void activate ()
    {
        if ( this.button != null )
        {
            this.button.setSelection ( true );
        }
    }

    public void setFocus ()
    {
        this.viewer.setFocus ();
    }

    public Control getControl ()
    {
        return this.viewer;
    }

    @Override
    public void summaryChanged ( final SummaryInformation summary )
    {
        if ( this.button != null )
        {
            if ( summary.isError () || !summary.isValid () )
            {
                this.button.setText ( this.descriptor.getName () + " [E]" );
            }
            else if ( summary.isAlarm () )
            {
                this.button.setText ( this.descriptor.getName () + " [A]" );
            }
            else if ( summary.isManual () )
            {
                this.button.setText ( this.descriptor.getName () + " [M]" );
            }
            else if ( summary.isBlocked () )
            {
                this.button.setText ( this.descriptor.getName () + " [B]" );
            }
            else
            {
                this.button.setText ( this.descriptor.getName () + " []" );
            }
            this.button.getParent ().layout ();
        }
    }
}
