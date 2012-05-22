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

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.View;

/**
 * This is the item provider adapter for a {@link org.openscada.vi.details.model.DetailView.View} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ViewItemProvider ( AdapterFactory adapterFactory )
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

        }
        return itemPropertyDescriptors;
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
            childrenFeatures.add ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT );
            childrenFeatures.add ( DetailViewPackage.Literals.VIEW__GROUPS );
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
     * This returns View.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/View" ) );
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
        return getString ( "_UI_View_type" );
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

        switch ( notification.getFeatureID ( View.class ) )
        {
            case DetailViewPackage.VIEW__HEADER_COMPONENT:
            case DetailViewPackage.VIEW__GROUPS:
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

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createLabelComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createFillLayoutComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createButtonComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createBoolLEDComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createSimpleGridComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createGroupGridComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createValueSetComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createValueComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createTextInputComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createTextComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createTextInputMultiComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createCheckComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createLinkComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createURLImageComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT, DetailViewFactory.eINSTANCE.createProgressComponent () ) );

        newChildDescriptors.add ( createChildParameter ( DetailViewPackage.Literals.VIEW__GROUPS, DetailViewFactory.eINSTANCE.createGroupEntry () ) );
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
