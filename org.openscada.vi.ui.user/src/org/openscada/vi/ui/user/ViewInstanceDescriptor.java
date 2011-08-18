package org.openscada.vi.ui.user;

import java.net.URI;
import java.util.Map;

public class ViewInstanceDescriptor
{
    private final String id;

    private final String parentId;

    private final URI uri;

    private final String name;

    private final Map<String, String> properties;

    private final boolean defaultInstance;

    public ViewInstanceDescriptor ( final String id, final String parentId, final URI uri, final String name, final boolean defaultInstance, final Map<String, String> properties )
    {
        super ();
        this.id = id;
        this.parentId = parentId;
        this.uri = uri;
        this.name = name;
        this.properties = properties;
        this.defaultInstance = defaultInstance;
    }

    public String getId ()
    {
        return this.id;
    }

    public String getParentId ()
    {
        return this.parentId;
    }

    public URI getUri ()
    {
        return this.uri;
    }

    public String getName ()
    {
        return this.name;
    }

    public Map<String, String> getProperties ()
    {
        return this.properties;
    }

    public boolean isDefaultInstance ()
    {
        return this.defaultInstance;
    }
}
