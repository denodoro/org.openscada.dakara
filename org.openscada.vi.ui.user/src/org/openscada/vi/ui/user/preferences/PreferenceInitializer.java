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
