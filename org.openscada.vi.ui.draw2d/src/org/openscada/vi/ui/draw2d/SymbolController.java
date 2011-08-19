package org.openscada.vi.ui.draw2d;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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
import org.openscada.vi.ui.draw2d.primitives.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    private final Set<SummaryListener> summaryListeners = new LinkedHashSet<SummaryListener> ( 1 );

    private final Map<String, Object> scriptObjects;

    public SymbolController ( final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects ) throws Exception
    {
        this ( null, symbol, classLoader, properties, scriptObjects );
    }

    public SymbolController ( final SymbolController parentController, final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects ) throws Exception
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

        this.scriptContext = this.engine.getContext ();

        this.scriptContext.setAttribute ( "controller", this.context, ScriptContext.ENGINE_SCOPE );
        this.scriptContext.setAttribute ( "data", this.symbolData, ScriptContext.ENGINE_SCOPE );
        this.scriptContext.setAttribute ( "GSON", createJson (), ScriptContext.ENGINE_SCOPE );
        this.scriptObjects = scriptObjects;
        addScriptObjects ( scriptObjects );
        if ( parentController != null )
        {
            addScriptObjects ( parentController.getScriptObjects () );
        }

        for ( final String module : symbol.getScriptModules () )
        {
            loadScript ( module );
        }

        this.onInit = new ScriptExecutor ( this.engine, symbol.getOnInit (), classLoader );
        this.onDispose = new ScriptExecutor ( this.engine, symbol.getOnDispose (), classLoader );
        this.onUpdate = new ScriptExecutor ( this.engine, symbol.getOnUpdate (), classLoader );
    }

    private Gson createJson ()
    {
        return new GsonBuilder ().serializeNulls ().setDateFormat ( "yyyy-MM-dd hh:mm:ss.SSS" ).create ();
    }

    private void addScriptObjects ( final Map<String, Object> scriptObjects )
    {
        if ( scriptObjects != null )
        {
            for ( final Map.Entry<String, Object> entry : scriptObjects.entrySet () )
            {
                this.scriptContext.setAttribute ( entry.getKey (), entry.getValue (), ScriptContext.ENGINE_SCOPE );
            }
        }
    }

    public Map<String, Object> getScriptObjects ()
    {
        return this.scriptObjects;
    }

    private void loadScript ( final String module ) throws Exception
    {
        final String moduleSource = Resources.toString ( new URL ( module ), Charset.forName ( "UTF-8" ) );
        new ScriptExecutor ( this.engine, moduleSource, this.classLoader ).execute ( this.scriptContext );
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

    public void addElement ( final String name, final Controller element )
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

    public SummaryInformation getSummaryInformation ()
    {
        return new SummaryInformation ( getData (), collectChildrenData () );
    }

    private Collection<SummaryInformation> collectChildrenData ()
    {
        final Collection<SummaryInformation> result = new LinkedList<SummaryInformation> ();

        for ( final SymbolController controller : this.controllers )
        {
            result.add ( controller.getSummaryInformation () );
        }

        return result;
    }

    protected void handleDataUpdate ()
    {
        final Map<String, DataItemValue> currentData = this.registrationManager.getData ();
        if ( currentData == this.lastData )
        {
            return;
        }
        this.lastData = currentData;

        runUpdate ();

        // propagate update
        if ( this.parentController != null )
        {
            this.parentController.runUpdate ();
        }
    }

    private void runUpdate ()
    {
        try
        {
            this.onUpdate.execute ( this.scriptContext );
            notifySummaryListeners ();
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    protected void notifySummaryListeners ()
    {
        final SummaryInformation info = getSummaryInformation ();
        for ( final SummaryListener listener : this.summaryListeners )
        {
            listener.summaryChanged ( info );
        }
    }

    public void addSummaryListener ( final SummaryListener listener )
    {
        if ( this.summaryListeners.add ( listener ) )
        {
            listener.summaryChanged ( getSummaryInformation () );
        }
    }

    public void removeSummaryListener ( final SummaryListener listener )
    {
        this.summaryListeners.remove ( listener );
    }

    public ScriptExecutor createScriptExecutor ( final String command ) throws ScriptException
    {
        if ( command == null || command.isEmpty () )
        {
            return null;
        }

        return new ScriptExecutor ( this.engine, command, this.classLoader );
    }

    public void execute ( final ScriptExecutor scriptExecutor, final Map<String, Object> scriptObjects )
    {
        if ( scriptExecutor == null )
        {
            return;
        }

        try
        {
            scriptExecutor.execute ( this.scriptContext, scriptObjects );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

}
