/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.provider;

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
import org.openscada.vi.model.VisualInterface.GridChild;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

/**
 * This is the item provider adapter for a {@link org.openscada.vi.model.VisualInterface.GridChild} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GridChildItemProvider extends ChildItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GridChildItemProvider ( AdapterFactory adapterFactory )
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

            addHorizontalAlignmentPropertyDescriptor ( object );
            addVerticalAlignmentPropertyDescriptor ( object );
            addGrabHorizontalSpacePropertyDescriptor ( object );
            addGrabVerticalSpacePropertyDescriptor ( object );
            addSpanColsPropertyDescriptor ( object );
            addSpanRowsPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Horizontal Alignment feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addHorizontalAlignmentPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GridChild_horizontalAlignment_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_GridChild_horizontalAlignment_feature", "_UI_GridChild_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.GRID_CHILD__HORIZONTAL_ALIGNMENT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Vertical Alignment feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVerticalAlignmentPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GridChild_verticalAlignment_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_GridChild_verticalAlignment_feature", "_UI_GridChild_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.GRID_CHILD__VERTICAL_ALIGNMENT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Grab Horizontal Space feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addGrabHorizontalSpacePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GridChild_grabHorizontalSpace_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_GridChild_grabHorizontalSpace_feature", "_UI_GridChild_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.GRID_CHILD__GRAB_HORIZONTAL_SPACE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Grab Vertical Space feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addGrabVerticalSpacePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GridChild_grabVerticalSpace_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_GridChild_grabVerticalSpace_feature", "_UI_GridChild_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.GRID_CHILD__GRAB_VERTICAL_SPACE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Span Cols feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSpanColsPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GridChild_spanCols_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_GridChild_spanCols_feature", "_UI_GridChild_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.GRID_CHILD__SPAN_COLS, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Span Rows feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSpanRowsPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_GridChild_spanRows_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_GridChild_spanRows_feature", "_UI_GridChild_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.GRID_CHILD__SPAN_ROWS, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This returns GridChild.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/GridChild" ) ); //$NON-NLS-1$
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
        String label = ( (GridChild)object ).getName ();
        return label == null || label.length () == 0 ? getString ( "_UI_GridChild_type" ) : //$NON-NLS-1$
        getString ( "_UI_GridChild_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( GridChild.class ) )
        {
            case VisualInterfacePackage.GRID_CHILD__HORIZONTAL_ALIGNMENT:
            case VisualInterfacePackage.GRID_CHILD__VERTICAL_ALIGNMENT:
            case VisualInterfacePackage.GRID_CHILD__GRAB_HORIZONTAL_SPACE:
            case VisualInterfacePackage.GRID_CHILD__GRAB_VERTICAL_SPACE:
            case VisualInterfacePackage.GRID_CHILD__SPAN_COLS:
            case VisualInterfacePackage.GRID_CHILD__SPAN_ROWS:
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
