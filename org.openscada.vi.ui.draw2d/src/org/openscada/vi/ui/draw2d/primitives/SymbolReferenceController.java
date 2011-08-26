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

package org.openscada.vi.ui.draw2d.primitives;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openscada.ui.utils.status.StatusHelper;
import org.openscada.vi.model.VisualInterface.SymbolReference;
import org.openscada.vi.ui.draw2d.Activator;
import org.openscada.vi.ui.draw2d.Helper;
import org.openscada.vi.ui.draw2d.SymbolController;
import org.openscada.vi.ui.draw2d.ViewElementFactory;
import org.openscada.vi.ui.draw2d.impl.ScalableLayeredPane;
import org.openscada.vi.ui.draw2d.loader.XMISymbolLoader;
import org.openscada.vi.ui.draw2d.preferences.PreferenceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolReferenceController implements Controller
{

    private final static Logger logger = LoggerFactory.getLogger ( SymbolReferenceController.class );

    private final LayeredPane figure;

    public SymbolReferenceController ( final SymbolController controller, final SymbolReference symbolReference, final ViewElementFactory factory, final ResourceManager manager )
    {
        if ( symbolReference.getZoom () != null )
        {
            if ( Activator.getDefault ().getPreferenceStore ().getBoolean ( PreferenceConstants.P_DEFAULT_HAIRLINE ) )
            {
                this.figure = new ScalableLayeredPane ();
                ( (ScalableLayeredPane)this.figure ).setScale ( symbolReference.getZoom () );
            }
            else
            {
                this.figure = new org.eclipse.draw2d.ScalableLayeredPane ();
                ( (org.eclipse.draw2d.ScalableLayeredPane)this.figure ).setScale ( symbolReference.getZoom () );
            }
        }
        else
        {
            this.figure = new LayeredPane ();
        }

        final Layer layer = new Layer ();
        layer.setLayoutManager ( new StackLayout () );

        this.figure.add ( layer );

        try
        {
            final URI uri = URI.createURI ( symbolReference.getUri () );
            final XMISymbolLoader symbolLoader = factory.load ( uri );
            symbolLoader.load ();

            final Map<String, String> properties = new HashMap<String, String> ();
            properties.putAll ( convert ( symbolReference.getProperties () ) );
            createProperties ( controller, symbolReference, properties );

            final SymbolController childController = new SymbolController ( controller, symbolLoader.getSymbol (), symbolLoader.getClassLoader (), properties, controller.getScriptObjects () );

            final Controller elementController = factory.create ( childController, symbolLoader.getSymbol ().getRoot () );
            final IFigure rootFigure = elementController.getFigure ();
            layer.add ( rootFigure );

            final RGB color = org.openscada.vi.ui.draw2d.primitives.Helper.makeColor ( symbolLoader.getSymbol ().getBackgroundColor () );
            if ( color != null )
            {
                layer.setBackgroundColor ( manager.createColor ( color ) );
            }

            // register the symbol element controller 
            controller.addElement ( symbolReference, elementController );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create symbol", e );
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            layer.add ( Helper.createErrorFigure ( e ) );
        }
    }

    private void createProperties ( final SymbolController controller, final SymbolReference symbolReference, final Map<String, String> currentProperties ) throws Exception
    {
        controller.createProperties ( "JavaScript", symbolReference.getOnCreateProperties (), currentProperties );
    }

    @Override
    public IFigure getFigure ()
    {
        return this.figure;
    }

    private Map<? extends String, ? extends String> convert ( final EMap<String, String> properties )
    {
        final Map<String, String> p = new HashMap<String, String> ();
        if ( properties != null )
        {
            for ( final Map.Entry<String, String> entry : properties.entrySet () )
            {
                p.put ( entry.getKey (), entry.getValue () );
            }
        }
        return p;
    }

}
