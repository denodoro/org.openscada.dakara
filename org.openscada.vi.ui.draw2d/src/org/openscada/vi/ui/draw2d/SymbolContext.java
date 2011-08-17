package org.openscada.vi.ui.draw2d;

import java.util.Properties;

public class SymbolContext
{
    private final SymbolController controller;

    public SymbolContext ( final SymbolController controller )
    {
        this.controller = controller;
    }

    public Properties getProperties ()
    {
        return this.controller.getProperties ();
    }

    public Object getElement ( final String name )
    {
        return this.controller.getElement ( name );
    }

    public Object getProperty ( final String name )
    {
        return this.controller.getProperties ().getProperty ( name );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId )
    {
        this.controller.registerItem ( name, itemId, connectionId );
    }

    public void unregisterItem ( final String name )
    {
        this.controller.unregisterItem ( name );
    }

}
