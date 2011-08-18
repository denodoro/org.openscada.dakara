package org.openscada.ui.singleviewer.app;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory
{

    @Override
    public void createInitialLayout ( final IPageLayout layout )
    {
        layout.setEditorAreaVisible ( false );
    }
}
