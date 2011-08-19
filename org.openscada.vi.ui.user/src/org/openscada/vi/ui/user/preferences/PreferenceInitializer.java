package org.openscada.vi.ui.user.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.openscada.vi.ui.user.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer
{

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    @Override
    public void initializeDefaultPreferences ()
    {
        final IPreferenceStore store = Activator.getDefault ().getPreferenceStore ();
        store.setDefault ( PreferenceConstants.P_IMG_OK, makeURI ( "ok.png" ) );
        store.setDefault ( PreferenceConstants.P_IMG_ALARM, makeURI ( "alarm.png" ) );
        store.setDefault ( PreferenceConstants.P_IMG_INVALID, makeURI ( "invalid.png" ) );
        store.setDefault ( PreferenceConstants.P_IMG_MANUAL, makeURI ( "manual.png" ) );
        store.setDefault ( PreferenceConstants.P_IMG_BLOCKED, makeURI ( "blocked.png" ) );
        store.setDefault ( PreferenceConstants.P_IMG_ALARM_0, makeURI ( "alarm0.png" ) );
        store.setDefault ( PreferenceConstants.P_IMG_ALARM_1, makeURI ( "alarm1.png" ) );
    }

    private String makeURI ( final String file )
    {
        return "platform:/plugin/" + Activator.PLUGIN_ID + "/resources/" + file;
    }
}
