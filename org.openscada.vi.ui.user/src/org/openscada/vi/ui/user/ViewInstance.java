package org.openscada.vi.ui.user;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.openscada.vi.ui.draw2d.SummaryInformation;
import org.openscada.vi.ui.draw2d.SummaryListener;
import org.openscada.vi.ui.draw2d.VisualInterfaceViewer;
import org.openscada.vi.ui.user.preferences.PreferenceConstants;

public class ViewInstance implements SummaryListener
{
    private ToolItem button;

    private final ViewManager viewManager;

    private VisualInterfaceViewer viewer;

    private final ResourceManager manager;

    private final Image imageOk;

    private final Image imageInvalid;

    private final Image imageAlarm;

    private final Image imageManual;

    private final Image imageBlocked;

    private final Image imageAckRequired;

    public ViewInstance ( final ViewManager viewManager, final Composite parent, final ToolBar toolbar, final ViewInstanceDescriptor descriptor, final ResourceManager manager )
    {
        this.viewManager = viewManager;
        this.manager = manager;

        this.imageOk = createImage ( PreferenceConstants.P_IMG_OK );
        this.imageInvalid = createImage ( PreferenceConstants.P_IMG_INVALID );
        this.imageAlarm = createImage ( PreferenceConstants.P_IMG_ALARM );
        this.imageManual = createImage ( PreferenceConstants.P_IMG_MANUAL );
        this.imageBlocked = createImage ( PreferenceConstants.P_IMG_BLOCKED );
        this.imageAckRequired = createImage ( PreferenceConstants.P_IMG_ACK_REQUIRED );

        // create the main button
        if ( descriptor.getParentId () == null || descriptor.getParentId ().isEmpty () )
        {
            this.button = new ToolItem ( toolbar, SWT.PUSH );
            this.button.setText ( descriptor.getName () );
            this.button.setImage ( this.imageOk );
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

    private Image createImage ( final String key )
    {
        try
        {
            final String uri = Activator.getDefault ().getPreferenceStore ().getString ( key );
            return this.manager.createImageWithDefault ( ImageDescriptor.createFromURL ( new URL ( uri ) ) );
        }
        catch ( final MalformedURLException e )
        {
            return this.manager.createImageWithDefault ( ImageDescriptor.getMissingImageDescriptor () );
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
                this.button.setImage ( this.imageInvalid );
            }
            else if ( summary.isAlarm () )
            {
                this.button.setImage ( this.imageAlarm );
            }
            else if ( summary.isManual () )
            {
                this.button.setImage ( this.imageManual );
            }
            else if ( summary.isBlocked () )
            {
                this.button.setImage ( this.imageBlocked );
            }
            else
            {
                this.button.setImage ( this.imageOk );
            }
            this.button.getParent ().layout ();
        }
    }
}
