package org.openscada.vi.view;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;
import org.openscada.vi.ui.draw2d.VisualInterfaceViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisualInterfaceViewPart extends ViewPart
{

    private final static Logger logger = LoggerFactory.getLogger ( VisualInterfaceViewPart.class );

    @SuppressWarnings ( "unused" )
    private VisualInterfaceViewer viewer;

    public VisualInterfaceViewPart ()
    {
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.viewer = new VisualInterfaceViewer ( parent, SWT.NONE, load ( "platform:/plugin/org.openscada.vi.sample1/resources/My.vi" ), Activator.class.getClassLoader () );
    }

    private Symbol load ( final String uri )
    {
        logger.info ( "Loading: {}", uri ); //$NON-NLS-1$

        VisualInterfacePackage.eINSTANCE.eClass ();

        final ResourceSet resourceSet = new ResourceSetImpl ();

        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "vi", new XMIResourceFactoryImpl () ); //$NON-NLS-1$

        final URI file = URI.createURI ( uri );
        final Resource resource = resourceSet.getResource ( file, true );

        for ( final EObject o : resource.getContents () )
        {
            if ( o instanceof Symbol )
            {
                return (Symbol)o;
            }
        }
        return null;
    }

    @Override
    public void setFocus ()
    {
    }

}
