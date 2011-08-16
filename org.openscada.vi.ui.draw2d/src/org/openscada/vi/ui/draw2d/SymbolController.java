package org.openscada.vi.ui.draw2d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.eclipse.draw2d.IFigure;
import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolController
{

    private final static Logger logger = LoggerFactory.getLogger ( SymbolController.class );

    private final Symbol symbol;

    private final SymbolController parentController;

    private final Set<SymbolController> controllers = new LinkedHashSet<SymbolController> ();

    private final ScriptExecutor onInit;

    private final ScriptEngineManager engineManager;

    private final ScriptEngine engine;

    private final ScriptExecutor onDispose;

    private final ScriptExecutor onUpdate;

    private final Properties properties;

    private final SymbolContext context;

    private final ScriptContext scriptContext;

    private final ClassLoader classLoader;

    private final Map<String, Object> elements = new HashMap<String, Object> ();

    public SymbolController ( final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties ) throws Exception
    {
        this ( null, symbol, classLoader, properties );
    }

    public SymbolController ( final SymbolController parentController, final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties ) throws Exception
    {
        this.parentController = parentController;
        this.classLoader = classLoader;
        this.symbol = symbol;

        this.engineManager = new ScriptEngineManager ( classLoader );

        if ( parentController != null )
        {
            this.properties = new Properties ( parentController.getProperties () );
        }
        else
        {
            this.properties = new Properties ();
        }

        for ( final Map.Entry<String, String> entry : symbol.getProperties ().entrySet () )
        {
            this.properties.put ( entry.getKey (), entry.getValue () );
        }
        this.properties.putAll ( properties );

        this.engine = this.engineManager.getEngineByName ( "JavaScript" );
        this.context = new SymbolContext ( this );

        if ( parentController != null )
        {
            parentController.addChild ( this );
        }

        // this.engineManager.put ( "context", this.context );
        this.scriptContext = this.engine.getContext ();
        this.scriptContext.setAttribute ( "controller", this.context, ScriptContext.GLOBAL_SCOPE );

        this.onInit = new ScriptExecutor ( this.engine, symbol.getOnInit (), classLoader );
        this.onDispose = new ScriptExecutor ( this.engine, symbol.getOnDispose (), classLoader );
        this.onUpdate = new ScriptExecutor ( this.engine, symbol.getOnUpdate (), classLoader );
    }

    public void init () throws Exception
    {
        this.onInit.execute ( this.scriptContext );
        for ( final SymbolController controller : this.controllers )
        {
            controller.init ();
        }
    }

    public Properties getProperties ()
    {
        return this.properties;
    }

    protected void addChild ( final SymbolController controller )
    {
        this.controllers.add ( controller );
    }

    protected void removeChild ( final SymbolController controller )
    {
        this.controllers.remove ( controller );
    }

    public void dispose ()
    {
        try
        {
            this.onDispose.execute ( this.scriptContext );
        }
        catch ( final ScriptException e )
        {
            logger.warn ( "Failed to dispose", e );
        }

        if ( this.parentController != null )
        {
            this.parentController.removeChild ( this );
        }

        final ArrayList<SymbolController> controllers = new ArrayList<SymbolController> ( this.controllers );
        for ( final SymbolController controller : controllers )
        {
            controller.dispose ();
        }
        this.controllers.clear ();
    }

    public Object createProperties ( final String command, final String onCreateProperties, final Map<String, String> currentProperties ) throws Exception
    {
        final ScriptExecutor executor = new ScriptExecutor ( this.engine, onCreateProperties, this.classLoader );
        final SimpleScriptContext currentContext = new SimpleScriptContext ();
        final Bindings bindings = this.engine.createBindings ();
        bindings.put ( "properties", currentProperties );
        currentContext.setBindings ( bindings, ScriptContext.ENGINE_SCOPE );
        return executor.execute ( currentContext );
    }

    public Object getElement ( final String name )
    {
        return this.elements.get ( name );
    }

    public void addElement ( final String name, final IFigure element )
    {
        if ( name == null )
        {
            return;
        }
        else
        {
            this.elements.put ( name, element );
        }
    }

    public void removeElement ( final String name )
    {
        this.elements.remove ( name );
    }
}
