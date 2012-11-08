package org.openscada.vi.ui.draw2d.preferences;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.openscada.vi.ui.draw2d.preferences.messages"; //$NON-NLS-1$

    public static String PreferencePage_activateZooming;

    public static String PreferencePage_title;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
