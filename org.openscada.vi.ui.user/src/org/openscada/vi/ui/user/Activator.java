package org.openscada.vi.ui.user;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.openscada.ui.utils.status.StatusHelper;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.openscada.vi.ui.user"; //$NON-NLS-1$

    public static final String EXTP_VIEW = PLUGIN_ID + ".view";

    private static final String ELE_VIEW_INSTANCE = "viewInstance";

    private static final String ELE_PROPERTY = "property";

    // The shared instance
    private static Activator plugin;

    private List<ViewInstanceDescriptor> descriptors;

    /**
     * The constructor
     */
    public Activator ()
    {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        plugin = null;
        super.stop ( context );
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault ()
    {
        return plugin;
    }

    protected List<ViewInstanceDescriptor> internalGetDescriptors ()
    {
        if ( this.descriptors == null )
        {
            this.descriptors = loadDescriptors ();
        }
        return this.descriptors;
    }

    public static List<ViewInstanceDescriptor> getDescriptors ()
    {
        return getDefault ().internalGetDescriptors ();
    }

    protected static List<ViewInstanceDescriptor> loadDescriptors ()
    {
        final List<ViewInstanceDescriptor> result = new LinkedList<ViewInstanceDescriptor> ();
        for ( final IConfigurationElement element : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_VIEW ) )
        {
            if ( !ELE_VIEW_INSTANCE.equals ( element.getName () ) )
            {
                continue;
            }

            final ViewInstanceDescriptor descriptor = convert ( element );
            if ( descriptor != null )
            {
                result.add ( descriptor );
            }
        }
        return result;
    }

    private static ViewInstanceDescriptor convert ( final IConfigurationElement element )
    {
        try
        {
            final String id = element.getAttribute ( "id" );
            final String name = element.getAttribute ( "name" );
            final String parentId = element.getAttribute ( "parentId" );
            final URI uri = new URI ( element.getAttribute ( "uri" ) );

            final Map<String, String> properties = new LinkedHashMap<String, String> ( 0 );

            for ( final IConfigurationElement child : element.getChildren ( ELE_PROPERTY ) )
            {
                properties.put ( child.getAttribute ( "key" ), child.getAttribute ( "value" ) );
            }

            final boolean defaultInstance = element.getAttribute ( "defaultInstance" ) == null ? false : Boolean.parseBoolean ( element.getAttribute ( "defaultInstance" ) );

            return new ViewInstanceDescriptor ( id, parentId, uri, name, defaultInstance, properties );
        }
        catch ( final Throwable e )
        {
            plugin.getLog ().log ( StatusHelper.convertStatus ( PLUGIN_ID, e ) );
            return null;
        }
    }
}
