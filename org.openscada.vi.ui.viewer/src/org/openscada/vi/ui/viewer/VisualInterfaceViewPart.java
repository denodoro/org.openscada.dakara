package org.openscada.vi.ui.viewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.openscada.vi.ui.draw2d.VisualInterfaceViewer;

public class VisualInterfaceViewPart extends ViewPart
{

    @SuppressWarnings ( "unused" )
    private VisualInterfaceViewer viewer;

    public VisualInterfaceViewPart ()
    {
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.viewer = new VisualInterfaceViewer ( parent, SWT.NONE, "platform:/plugin/org.openscada.vi.sample1/resources/My.vi", null );
    }

    @Override
    public void setFocus ()
    {
    }

}
