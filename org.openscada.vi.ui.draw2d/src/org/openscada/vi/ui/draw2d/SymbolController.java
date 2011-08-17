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

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.da.client.DataItemValue;
import org.openscada.ui.utils.status.StatusHelper;
import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolController
{

    private final static Logger logger = LoggerFactory.getLogger ( SymbolController.class );

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

    private final RegistrationManager registrationManager;

    private final SymbolData symbolData;

    private Map<String, DataItemValue> lastData;

    public SymbolController ( final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties ) throws Exception
    {
        this ( null, symbol, classLoader, properties );
    }

    public SymbolController ( final SymbolController parentController, final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties ) throws Exception
    {
        this.parentController = parentController;
        this.classLoader = classLoader;

        this.symbolData = new SymbolData ( this );
        this.registrationManager = new RegistrationManager ( this );
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
        this.scriptContext.setAttribute ( "data", this.symbolData, ScriptContext.GLOBAL_SCOPE );

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

    public void addElement ( final String name, final Object element )
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

    public void unregisterItem ( final String name )
    {
        this.registrationManager.unregisterItem ( name );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId )
    {
        this.registrationManager.registerItem ( name, itemId, connectionId );
    }

    /**
     * Trigger the controller to update the data from the registration manager
     * <p>
     * This method can be called from any thread and must synchronized to the UI
     * </p>
     */
    public void triggerDataUpdate ()
    {
        try
        {
            Display.getDefault ().asyncExec ( new Runnable () {
                @Override
                public void run ()
                {
                    handleDataUpdate ();
                };
            } );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    public Map<String, DataItemValue> getData ()
    {
        return this.registrationManager.getData ();
    }

    protected void handleDataUpdate ()
    {
        final Map<String, DataItemValue> currentData = this.registrationManager.getData ();
        if ( currentData == this.lastData )
        {
            return;
        }
        this.lastData = currentData;

        try
        {
            this.onUpdate.execute ( this.scriptContext );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

}
