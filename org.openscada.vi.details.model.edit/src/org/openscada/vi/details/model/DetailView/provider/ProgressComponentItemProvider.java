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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.ProgressComponent;

/**
 * This is the item provider adapter for a {@link org.openscada.vi.details.model.DetailView.ProgressComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProgressComponentItemProvider extends ReadableComponentItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProgressComponentItemProvider ( AdapterFactory adapterFactory )
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

            addDescriptorPropertyDescriptor ( object );
            addFactorPropertyDescriptor ( object );
            addMaxPropertyDescriptor ( object );
            addMinPropertyDescriptor ( object );
            addWidthPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Descriptor feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDescriptorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProgressComponent_descriptor_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProgressComponent_descriptor_feature", "_UI_ProgressComponent_type" ), DetailViewPackage.Literals.PROGRESS_COMPONENT__DESCRIPTOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Factor feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFactorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProgressComponent_factor_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProgressComponent_factor_feature", "_UI_ProgressComponent_type" ), DetailViewPackage.Literals.PROGRESS_COMPONENT__FACTOR, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Max feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMaxPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProgressComponent_max_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProgressComponent_max_feature", "_UI_ProgressComponent_type" ), DetailViewPackage.Literals.PROGRESS_COMPONENT__MAX, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Min feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMinPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProgressComponent_min_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProgressComponent_min_feature", "_UI_ProgressComponent_type" ), DetailViewPackage.Literals.PROGRESS_COMPONENT__MIN, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Width feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addWidthPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProgressComponent_width_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProgressComponent_width_feature", "_UI_ProgressComponent_type" ), DetailViewPackage.Literals.PROGRESS_COMPONENT__WIDTH, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This returns ProgressComponent.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ProgressComponent" ) );
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
        String label = ( (ProgressComponent)object ).getFormat ();
        return label == null || label.length () == 0 ? getString ( "_UI_ProgressComponent_type" ) : getString ( "_UI_ProgressComponent_type" ) + " " + label;
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

        switch ( notification.getFeatureID ( ProgressComponent.class ) )
        {
            case DetailViewPackage.PROGRESS_COMPONENT__DESCRIPTOR:
            case DetailViewPackage.PROGRESS_COMPONENT__FACTOR:
            case DetailViewPackage.PROGRESS_COMPONENT__MAX:
            case DetailViewPackage.PROGRESS_COMPONENT__MIN:
            case DetailViewPackage.PROGRESS_COMPONENT__WIDTH:
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

}
