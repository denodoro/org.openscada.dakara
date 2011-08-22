package org.openscada.vi.ui.draw2d;

import org.openscada.vi.model.VisualInterface.Symbol;

public class StaticSymbolLoader implements SymbolLoader
{
    private final Symbol symbol;

    private final ClassLoader classLoader;

    public StaticSymbolLoader ( final Symbol symbol, final ClassLoader classLoader )
    {
        this.symbol = symbol;
        this.classLoader = classLoader;
    }

    @Override
    public void load ()
    {
        // nothing to do
    }

    @Override
    public Symbol getSymbol ()
    {
        return this.symbol;
    }

    @Override
    public ClassLoader getClassLoader ()
    {
        return this.classLoader;
    }

}
