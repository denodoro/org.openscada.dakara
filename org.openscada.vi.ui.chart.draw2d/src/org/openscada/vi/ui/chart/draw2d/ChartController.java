package org.openscada.vi.ui.chart.draw2d;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.openscada.ui.chart.model.ChartModel.Chart;
import org.openscada.ui.chart.model.ChartModel.ChartPackage;
import org.openscada.vi.chart.model.chart.ChartView;
import org.openscada.vi.ui.draw2d.Controller;

public class ChartController implements Controller
{
    private final Chart configuration;

    public ChartController ( final ChartView view )
    {
        this.configuration = loadConfiguraton ( view.getConfigurationUri () );
    }

    private static Chart loadConfiguraton ( final String configurationUri )
    {
        if ( configurationUri == null || configurationUri.isEmpty () )
        {
            return null;
        }

        // load
        ChartPackage.eINSTANCE.eClass ();

        final ResourceSet resourceSet = new ResourceSetImpl ();

        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new XMIResourceFactoryImpl () ); //$NON-NLS-1$

        final Resource resource = resourceSet.getResource ( URI.createURI ( configurationUri ), true );

        for ( final EObject o : resource.getContents () )
        {
            if ( o instanceof Chart )
            {
                return (Chart)o;
            }
        }
        return null;
    }

    public Chart getConfiguration ()
    {
        return this.configuration;
    }

    @Override
    public IFigure getFigure ()
    {
        return new ChartFigure ( this.configuration );
    }

}
