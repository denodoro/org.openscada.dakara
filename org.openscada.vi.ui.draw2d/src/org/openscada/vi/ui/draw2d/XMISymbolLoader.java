package org.openscada.vi.ui.draw2d;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

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
