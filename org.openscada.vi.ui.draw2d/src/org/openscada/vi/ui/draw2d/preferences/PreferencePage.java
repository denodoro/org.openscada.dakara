package org.openscada.vi.ui.draw2d.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.openscada.vi.ui.draw2d.Activator;

/** This class represents a preference page that is contributed to the Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that
 * allows us to create a page that is small and knows how to save, restore and apply itself. <p> This page is used to modify preferences only. They are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can be accessed directly via the preference store. */

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{

    private BooleanFieldEditor defaultZoomingEditor;

    public PreferencePage ()
    {
        super ( GRID );
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
    }

    /** Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various types of preferences. Each field editor knows how to save and restore itself. */
    @Override
    public void createFieldEditors ()
    {
        this.defaultZoomingEditor = new BooleanFieldEditor ( PreferenceConstants.P_DEFAULT_ZOOMING, Messages.PreferencePage_activateZooming, getFieldEditorParent () );
        addField ( this.defaultZoomingEditor );
    }

    @Override
    protected void performDefaults ()
    {
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    @Override
    public void init ( final IWorkbench workbench )
    {
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
        setDescription ( Messages.PreferencePage_title );
    }
}