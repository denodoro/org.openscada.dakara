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
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.GroupEntry;

/**
 * This is the item provider adapter for a {@link org.openscada.vi.details.model.DetailView.GroupEntry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GroupEntryItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupEntryItemProvider ( AdapterFactory adapterFactory )
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

            addLabelPropertyDescriptor ( object );
            addPermissionPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Label feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLabelPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GroupEntry_label_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_GroupEntry_label_feature", "_UI_GroupEntry_type" ), DetailViewPackage.Literals.GROUP_ENTRY__LABEL, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Permission feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPermissionPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GroupEntry_permission_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_GroupEntry_permission_feature", "_UI_GroupEntry_type" ), DetailViewPackage.Literals.GROUP_ENTRY__PERMISSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures ( Object object )
    {
        if ( childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            childrenFeatures.add ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT );
            childrenFeatures.add ( DetailViewPackage.Literals.GROUP_ENTRY__VISIBILITY );
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature ( Object object, Object child )
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature ( object, child );
    }

    /**
     * This returns GroupEntry.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/GroupEntry" ) );
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
        String label = ( (GroupEntry)object ).getLabel ();
        return label == null || label.length () == 0 ? getString ( "_UI_GroupEntry_type" ) : getString ( "_UI_GroupEntry_type" ) + " " + label;
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

        switch ( notification.getFeatureID ( GroupEntry.class ) )
        {
            case DetailViewPackage.GROUP_ENTRY__LABEL:
            case DetailViewPackage.GROUP_ENTRY__PERMISSION:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case DetailViewPackage.GROUP_ENTRY__COMPONENT:
            case DetailViewPackage.GROUP_ENTRY__VISIBILITY:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), true, false ) );
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

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createLabelComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createFillLayoutComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createButtonComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createBoolLEDComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createSimpleGridComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createGroupGridComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createValueSetComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createValueComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createTextInputComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createTextComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createTextInputMultiComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createCheckComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createLinkComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createURLImageComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__COMPONENT, DetailViewFactory.eINSTANCE.createProgressComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__VISIBILITY, DetailViewFactory.eINSTANCE.createScriptVisibility () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__VISIBILITY, DetailViewFactory.eINSTANCE.createPermissionVisibility () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__VISIBILITY, DetailViewFactory.eINSTANCE.createInvisible () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.GROUP_ENTRY__VISIBILITY, DetailViewFactory.eINSTANCE.createTestVisibility () ) );
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
