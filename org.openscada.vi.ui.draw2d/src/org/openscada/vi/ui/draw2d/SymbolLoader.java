package org.openscada.vi.ui.draw2d;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

public class SymbolLoader
{
    private final URI uri;

    private Exception error;

    private Symbol symbol;

    private final ClassLoader classLoader;

    public SymbolLoader ( final String uri ) throws Exception
    {
        this ( URI.createURI ( uri ) );
    }

    public SymbolLoader ( final URI uri ) throws Exception
    {
        this.uri = uri;

        this.classLoader = findClassLoader ( uri );
        load ();
    }

    private ClassLoader findClassLoader ( final URI uri )
    {
        return Activator.class.getClassLoader ();
    }

    public Exception getError ()
    {
        return this.error;
    }

    public ClassLoader getClassLoader ()
    {
        return this.classLoader;
    }

    public Symbol getSymbol ()
    {
        return this.symbol;
    }

    private void load () throws Exception
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
