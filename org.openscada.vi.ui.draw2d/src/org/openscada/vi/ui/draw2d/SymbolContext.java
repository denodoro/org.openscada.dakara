/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
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

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.core.Variant;
import org.openscada.core.VariantEditor;
import org.openscada.ui.utils.status.StatusHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The context object that is exported to the script context
 * @author Jens Reimann
 * @since 0.17.0
 *
 */
public class SymbolContext
{

    private final static Logger logger = LoggerFactory.getLogger ( SymbolContext.class );

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

    public Object getProperty ( final String name, final String defaultValue )
    {
        return this.controller.getProperties ().getProperty ( name, defaultValue );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId )
    {
        registerItem ( name, itemId, connectionId, false, true );
    }

    public void registerItem ( final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        this.controller.registerItem ( name, itemId, connectionId, ignoreSummary, nullInvalid );
    }

    public void unregisterItem ( final String name )
    {
        this.controller.unregisterItem ( name );
    }

    public void startWrite ( final String connectionId, final String itemId, final Object value ) throws InterruptedException
    {
        this.controller.startWrite ( connectionId, itemId, Variant.valueOf ( value ) );
    }

    public void startWriteString ( final String connectionId, final String itemId, final String value ) throws InterruptedException
    {
        this.controller.startWrite ( connectionId, itemId, VariantEditor.toVariant ( value ) );
    }

    public void startWriteAttributeString ( final String connectionId, final String itemId, final String key, final String value ) throws InterruptedException
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );

        attributes.put ( key, VariantEditor.toVariant ( value ) );

        this.controller.startWriteAttributes ( connectionId, itemId, attributes );
    }

    public void startWriteAttribute ( final String connectionId, final String itemId, final String key, final Object value ) throws InterruptedException
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );

        attributes.put ( key, Variant.valueOf ( value ) );

        this.controller.startWriteAttributes ( connectionId, itemId, attributes );
    }

    public void startWriteAttributes ( final String connectionId, final String itemId, final Map<String, Variant> attributes ) throws InterruptedException
    {
        this.controller.startWriteAttributes ( connectionId, itemId, attributes );
    }

    public void executeCommand ( final String commandId, final Map<String, String> eventData )
    {

        try
        {
            final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench ().getService ( ICommandService.class );
            final IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench ().getService ( IHandlerService.class );

            final Command command = commandService.getCommand ( commandId );

            final Parameterization[] parameterizations = new Parameterization[eventData.size ()];

            int i = 0;
            for ( final Map.Entry<String, String> entry : eventData.entrySet () )
            {
                parameterizations[i] = new Parameterization ( command.getParameter ( entry.getKey () ), entry.getValue () );
                i++;
            }
            final ParameterizedCommand parameterCommand = new ParameterizedCommand ( command, parameterizations );

            handlerService.executeCommand ( parameterCommand, null );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to execute command", e );
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.BLOCK );
        }
    }
}
