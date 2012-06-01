package org.openscada.vi.ui.user;

public interface ViewManagerContext
{

    public void viewVisibilityChanged ( ViewInstance viewInstance, boolean state );

    public int calculateToolbarIndex ( ViewInstanceDescriptor descriptor );
}
