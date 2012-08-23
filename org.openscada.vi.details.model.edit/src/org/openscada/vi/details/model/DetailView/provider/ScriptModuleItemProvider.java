/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.ScriptModule;

/**
 * This is the item provider adapter for a {@link org.openscada.vi.details.model.DetailView.ScriptModule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptModuleItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptModuleItemProvider ( AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors ( Object object )
    {
        if ( itemPropertyDescriptors == null )
        {
            super.getPropertyDescriptors ( object );

            addScriptLanguagePropertyDescriptor ( object );
            addCodePropertyDescriptor ( object );
            addCodeUriPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Script Language feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addScriptLanguagePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScriptModule_scriptLanguage_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptModule_scriptLanguage_feature", "_UI_ScriptModule_type" ), DetailViewPackage.Literals.SCRIPT_MODULE__SCRIPT_LANGUAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Code feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCodePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScriptModule_code_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptModule_code_feature", "_UI_ScriptModule_type" ), DetailViewPackage.Literals.SCRIPT_MODULE__CODE, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Code Uri feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCodeUriPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScriptModule_codeUri_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptModule_codeUri_feature", "_UI_ScriptModule_type" ), DetailViewPackage.Literals.SCRIPT_MODULE__CODE_URI, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This returns ScriptModule.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ScriptModule" ) );
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText ( Object object )
    {
        String label = ( (ScriptModule)object ).getScriptLanguage ();
        return label == null || label.length () == 0 ? getString ( "_UI_ScriptModule_type" ) : getString ( "_UI_ScriptModule_type" ) + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged ( Notification notification )
    {
        updateChildren ( notification );

        switch ( notification.getFeatureID ( ScriptModule.class ) )
        {
            case DetailViewPackage.SCRIPT_MODULE__SCRIPT_LANGUAGE:
            case DetailViewPackage.SCRIPT_MODULE__CODE:
            case DetailViewPackage.SCRIPT_MODULE__CODE_URI:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
        }
        super.notifyChanged ( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors ( Collection<Object> newChildDescriptors, Object object )
    {
        super.collectNewChildDescriptors ( newChildDescriptors, object );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        return DetailViewEditPlugin.INSTANCE;
    }

}
