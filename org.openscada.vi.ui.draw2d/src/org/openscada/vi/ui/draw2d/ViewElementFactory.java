package org.openscada.vi.ui.draw2d;

import org.eclipse.jface.resource.ResourceManager;
import org.openscada.vi.model.VisualInterface.Primitive;

public interface ViewElementFactory
{

    public Controller create ( SymbolController controller, Primitive element, ResourceManager manager, BasicViewElementFactory basicViewElementFactory );

}
