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

package org.openscada.vi.ui.draw2d.loader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;
import org.openscada.vi.ui.draw2d.Activator;

public class XMISymbolLoader implements SymbolLoader
{
    private final URI uri;

    private Symbol symbol;

    private final ClassLoader classLoader;

    public XMISymbolLoader ( final String uri )
    {
        this ( URI.createURI ( uri ) );
    }

    public XMISymbolLoader ( final URI uri )
    {
        this.uri = uri;
        this.classLoader = findClassLoader ( uri );
    }

    private ClassLoader findClassLoader ( final URI uri )
    {
        return Activator.class.getClassLoader ();
    }

    @Override
    public ClassLoader getClassLoader ()
    {
        return this.classLoader;
    }

    @Override
    public Symbol getSymbol ()
    {
        return this.symbol;
    }

    @Override
    public void load () throws Exception
    {
        // load
        VisualInterfacePackage.eINSTANCE.eClass ();

        this.symbol = null;

        final ResourceSet resourceSet = new ResourceSetImpl ();

        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "vi", new XMIResourceFactoryImpl () ); //$NON-NLS-1$

        final Resource resource = resourceSet.getResource ( this.uri, true );

        for ( final EObject o : resource.getContents () )
        {
            if ( o instanceof Symbol )
            {
                this.symbol = (Symbol)o;
            }
        }
    }
}
