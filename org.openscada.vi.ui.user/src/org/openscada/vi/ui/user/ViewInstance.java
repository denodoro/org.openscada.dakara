package org.openscada.vi.ui.user;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.openscada.vi.ui.draw2d.VisualInterfaceViewer;

public class ViewInstance
{
    private ToolItem button;

    private final ViewManager viewManager;

    private final VisualInterfaceViewer viewer;

    public ViewInstance ( final ViewManager viewManager, final Composite parent, final ToolBar toolbar, final ViewInstanceDescriptor descriptor )
    {
        this.viewManager = viewManager;

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
        this.viewer = new VisualInterfaceViewer ( parent, SWT.NONE, descriptor.getUri () );
        this.viewer.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
    }

    protected void showView ( final String id )
    {
        this.viewManager.showView ( id );
    }

    public void dispose ()
    {
        if ( this.button != null )
        {
            this.button.dispose ();
        }
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
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
    }

    public Control getControl ()
    {
        return this.viewer;
    }
}
