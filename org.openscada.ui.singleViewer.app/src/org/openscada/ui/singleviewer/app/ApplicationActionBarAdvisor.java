package org.openscada.ui.singleviewer.app;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor
{

    public ApplicationActionBarAdvisor ( final IActionBarConfigurer configurer )
    {
        super ( configurer );
    }

    @Override
    protected void makeActions ( final IWorkbenchWindow window )
    {
    }

    @Override
    protected void fillMenuBar ( final IMenuManager menuBar )
    {
    }

}
