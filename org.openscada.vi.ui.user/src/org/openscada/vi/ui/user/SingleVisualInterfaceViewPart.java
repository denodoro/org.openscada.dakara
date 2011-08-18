package org.openscada.vi.ui.user;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.part.ViewPart;

public class SingleVisualInterfaceViewPart extends ViewPart implements ViewManager
{

    private Composite viewHolder;

    private ToolBar toolBar;

    private final Map<String, ViewInstance> instances = new LinkedHashMap<String, ViewInstance> ( 1 );

    private ViewInstance currentInstance;

    private StackLayout stackLayout;

    public SingleVisualInterfaceViewPart ()
    {
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        parent.setLayout ( new FillLayout () );
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        final GridLayout layout = new GridLayout ( 1, true );
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        layout.marginHeight = layout.marginWidth = 0;
        wrapper.setLayout ( layout );

        this.toolBar = new ToolBar ( wrapper, SWT.HORIZONTAL );
        this.toolBar.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );

        this.viewHolder = new Composite ( wrapper, SWT.NONE );
        this.viewHolder.setLayout ( this.stackLayout = new StackLayout () );
        for ( final ViewInstanceDescriptor descriptor : Activator.getDescriptors () )
        {
            addView ( descriptor );
            if ( descriptor.isDefaultInstance () )
            {
                showView ( descriptor.getId () );
            }
        }
    }

    private void addView ( final ViewInstanceDescriptor descriptor )
    {
        final ViewInstance instance = new ViewInstance ( this, this.viewHolder, this.toolBar, descriptor );
        this.instances.put ( descriptor.getId (), instance );
    }

    @Override
    public void showView ( final String id )
    {
        final ViewInstance instance = this.instances.get ( id );
        if ( instance == null )
        {
            return;
        }
        if ( this.currentInstance == instance )
        {
            return;
        }

        if ( this.currentInstance != null )
        {
            this.currentInstance.deactivate ();
        }

        this.currentInstance = instance;
        this.currentInstance.activate ();

        this.stackLayout.topControl = this.currentInstance.getControl ();
        this.viewHolder.layout ();
    }

    @Override
    public void setFocus ()
    {
        if ( this.currentInstance != null )
        {
            this.currentInstance.setFocus ();
        }
    }

}
