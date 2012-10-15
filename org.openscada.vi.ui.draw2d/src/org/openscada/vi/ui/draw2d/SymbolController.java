/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2011 TH4 SYSTEMS GmbH (http://th4-systems.com)
 *
 * openSCADA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * only, as published by the Free Software Foundation.
 *
 * openSCADA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License version 3 for more details
 * (a copy is included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with openSCADA. If not, see
 * <http://opensource.org/licenses/lgpl-3.0.html> for a copy of the LGPLv3 License.
 */

package org.openscada.vi.ui.draw2d;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.openscada.ui.utils.status.StatusHelper;
import org.openscada.utils.script.ScriptExecutor;
import org.openscada.vi.data.DataValue;
import org.openscada.vi.data.RegistrationManager;
import org.openscada.vi.data.RegistrationManager.Listener;
import org.openscada.vi.data.SummaryInformation;
import org.openscada.vi.data.SummaryListener;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SymbolController implements Listener
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

    private final Map<Primitive, Object> primitives = new HashMap<Primitive, Object> ();

    private RegistrationManager registrationManager;

    private final SymbolData symbolData;

    private Map<String, DataValue> lastData;

    private final Set<SummaryListener> summaryListeners = new LinkedHashSet<SummaryListener> ( 1 );

    private final Map<String, Object> scriptObjects;

    private MessageConsole console;

    private MessageConsole createdConsole;

    private MessageConsoleStream logStream;

    private MessageConsoleStream errorStream;

    private final String symbolInfoName;

    public SymbolController ( final String symbolInfoName, final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects ) throws Exception
    {
        this ( symbolInfoName, null, symbol, classLoader, properties, scriptObjects );
    }

    public SymbolController ( final String symbolInfoName, final SymbolController parentController, final Symbol symbol, final ClassLoader classLoader, final Map<String, String> properties, final Map<String, Object> scriptObjects ) throws Exception
    {
        this.symbolInfoName = symbolInfoName;
        this.parentController = parentController;
        this.classLoader = classLoader;

        this.symbolData = new SymbolData ( this );
        this.registrationManager = new RegistrationManager ( Activator.getDefault ().getBundle ().getBundleContext () );
        this.registrationManager.addListener ( this );
        this.registrationManager.open ();
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
            if ( entry.getValue () != null )
            {
                this.properties.put ( entry.getKey (), entry.getValue () );
            }
        }

        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            if ( entry.getValue () != null )
            {
                this.properties.put ( entry.getKey (), entry.getValue () );
            }
        }

        this.engine = this.engineManager.getEngineByName ( "JavaScript" );
        this.context = new SymbolContext ( this );

        if ( parentController != null )
        {
            parentController.addChild ( this );
        }

        this.scriptContext = this.engine.getContext ();
        assignConsole ( this.scriptContext );

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

    private void assignConsole ( final ScriptContext scriptContext )
    {
        this.console = createOrGetConsole ();

        // scriptContext.setReader ( new InputStreamReader ( this.console.getInputStream () ) );

        /* wrapping into a PrintWriter is necessary due to
         * http://bugs.sun.com/view_bug.do?bug_id=6759414
         * */

        final MessageConsoleStream writerStream = this.console.newMessageStream ();
        scriptContext.setWriter ( new PrintWriter ( new OutputStreamWriter ( writerStream ) ) );

        this.errorStream = this.console.newMessageStream ();
        this.errorStream.setColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_RED ) );
        scriptContext.setErrorWriter ( new PrintWriter ( new OutputStreamWriter ( this.errorStream ) ) );

        this.logStream = this.console.newMessageStream ();
        this.logStream.setColor ( Display.getDefault ().getSystemColor ( SWT.COLOR_GRAY ) );
    }

    private MessageConsole createOrGetConsole ()
    {
        if ( this.parentController != null && this.parentController.getConsole () != null )
        {
            return this.parentController.getConsole ();
        }

        final IConsoleManager manager = ConsolePlugin.getDefault ().getConsoleManager ();
        final MessageConsole console = new MessageConsole ( String.format ( "Symbol Debug Console: %s", this.symbolInfoName ), null, null, true );
        manager.addConsoles ( new IConsole[] { console } );
        this.createdConsole = console;
        return console;
    }

    protected MessageConsole getConsole ()
    {
        if ( this.console != null )
        {
            return this.console;
        }
        else
        {
            return null;
        }
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
        this.logStream.println ( String.format ( "Loading script module: %s", module ) );
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
        if ( this.createdConsole != null )
        {
            ConsolePlugin.getDefault ().getConsoleManager ().removeConsoles ( new IConsole[] { this.createdConsole } );
            this.createdConsole = null;
        }

        if ( this.logStream != null && !this.logStream.isClosed () )
        {
            try
            {
                this.logStream.close ();
            }
            catch ( final IOException e )
            {
                logger.warn ( "Failed to close log stream", e );
            }
        }

        try
        {
            if ( this.onDispose != null )
            {
                this.onDispose.execute ( this.scriptContext );
            }
        }
        catch ( final Exception e )
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

        if ( this.registrationManager != null )
        {
            this.registrationManager.dispose ();
            this.registrationManager = null;
        }
    }

    public Object createProperties ( final String command, final String onCreateProperties, final Map<String, String> currentProperties ) throws Exception
    {
        final ScriptExecutor executor = new ScriptExecutor ( this.engine, onCreateProperties, this.classLoader );
        final Map<String, Object> localProperties = new HashMap<String, Object> ( 1 );
        localProperties.put ( "properties", currentProperties );
        return executor.execute ( this.scriptContext, localProperties );
    }

    public Object getElement ( final String name )
    {
        return this.elements.get ( name );
    }

    public Object getElement ( final Primitive primitive )
    {
        return this.primitives.get ( primitive );
    }

    public void addRawElement ( final String name, final Object element )
    {
        if ( name == null )
        {
            return;
        }
        this.elements.put ( name, element );
    }

    public void addElement ( final Primitive primitive, final Object element )
    {
        if ( primitive == null )
        {
            return;
        }

        if ( primitive.getName () != null )
        {
            this.elements.put ( primitive.getName (), element );
        }
        this.primitives.put ( primitive, element );
    }

    public void removeElement ( final Primitive primitive )
    {
        if ( primitive == null )
        {
            return;
        }
        this.primitives.remove ( primitive );
        this.elements.remove ( primitive.getName () );
    }

    public void unregisterItem ( final String name )
    {
        this.registrationManager.unregisterItem ( name );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        this.registrationManager.registerItem ( name, itemId, connectionId, ignoreSummary, nullInvalid );
    }

    /**
     * Trigger the controller to update the data from the registration manager
     * <p>
     * This method can be called from any thread and must synchronized to the UI
     * </p>
     */
    @Override
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
        return convert ( this.registrationManager.getData () );
    }

    private Map<String, DataItemValue> convert ( final Map<String, DataValue> data )
    {
        final Map<String, DataItemValue> values = new LinkedHashMap<String, DataItemValue> ( data.size () );
        for ( final Map.Entry<String, DataValue> entry : data.entrySet () )
        {
            if ( entry.getValue () == null )
            {
                continue;
            }
            values.put ( entry.getKey (), entry.getValue ().getValue () );
        }
        return values;
    }

    public SummaryInformation getSummaryInformation ()
    {
        return new SummaryInformation ( this.registrationManager.getData (), collectChildrenData () );
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
        if ( this.registrationManager == null )
        {
            // dispose7
            return;
        }

        final Map<String, DataValue> currentData = this.registrationManager.getData ();
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
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
        }
        notifySummaryListeners ();
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
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
        }
    }

    public void startWrite ( final String connectionId, final String itemId, final Variant value ) throws InterruptedException
    {
        this.registrationManager.startWrite ( connectionId, itemId, value );
    }

    public void startWriteAttributes ( final String connectionId, final String itemId, final Map<String, Variant> attributes ) throws InterruptedException
    {
        this.registrationManager.startWriteAttributes ( connectionId, itemId, attributes );
    }

    public void debugLog ( final String string )
    {
        final MessageConsoleStream stream = this.console.newMessageStream ();
        final PrintWriter ps = new PrintWriter ( stream );
        ps.println ( string );

        try
        {
            ps.close ();
            stream.close ();
        }
        catch ( final IOException e )
        {
        }
    }

    public void errorLog ( final String string )
    {
        errorLog ( string, null );
    }

    public void errorLog ( final String string, final Exception e )
    {
        final PrintWriter pw = new PrintWriter ( this.errorStream );
        pw.println ( string );
        e.printStackTrace ( pw );
        pw.flush ();
    }

    protected SymbolContext getContext ()
    {
        return this.context;
    }

    public SymbolContext getParentContext ()
    {
        if ( this.parentController != null )
        {
            return this.parentController.getContext ();
        }
        else
        {
            return null;
        }
    }

}
