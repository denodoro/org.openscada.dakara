package org.openscada.vi.ui.draw2d;

import org.openscada.vi.model.VisualInterface.Symbol;

public interface SymbolLoader
{

    public void load () throws Exception;

    public Symbol getSymbol ();

    public ClassLoader getClassLoader ();

}