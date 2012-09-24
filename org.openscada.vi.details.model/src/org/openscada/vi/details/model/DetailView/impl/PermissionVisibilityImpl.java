/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.PermissionVisibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission Visibility</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.PermissionVisibilityImpl#getRequiredPermission <em>Required Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermissionVisibilityImpl extends VisibilityImpl implements PermissionVisibility
{
    /**
     * The default value of the '{@link #getRequiredPermission() <em>Required Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequiredPermission()
     * @generated
     * @ordered
     */
    protected static final String REQUIRED_PERMISSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRequiredPermission() <em>Required Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequiredPermission()
     * @generated
     * @ordered
     */
    protected String requiredPermission = REQUIRED_PERMISSION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PermissionVisibilityImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return DetailViewPackage.Literals.PERMISSION_VISIBILITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRequiredPermission ()
    {
        return requiredPermission;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequiredPermission ( String newRequiredPermission )
    {
        String oldRequiredPermission = requiredPermission;
        requiredPermission = newRequiredPermission;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.PERMISSION_VISIBILITY__REQUIRED_PERMISSION, oldRequiredPermission, requiredPermission ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
        case DetailViewPackage.PERMISSION_VISIBILITY__REQUIRED_PERMISSION:
            return getRequiredPermission ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
        case DetailViewPackage.PERMISSION_VISIBILITY__REQUIRED_PERMISSION:
            setRequiredPermission ( (String)newValue );
            return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
        case DetailViewPackage.PERMISSION_VISIBILITY__REQUIRED_PERMISSION:
            setRequiredPermission ( REQUIRED_PERMISSION_EDEFAULT );
            return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
        case DetailViewPackage.PERMISSION_VISIBILITY__REQUIRED_PERMISSION:
            return REQUIRED_PERMISSION_EDEFAULT == null ? requiredPermission != null : !REQUIRED_PERMISSION_EDEFAULT.equals ( requiredPermission );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (requiredPermission: " );
        result.append ( requiredPermission );
        result.append ( ')' );
        return result.toString ();
    }

} //PermissionVisibilityImpl
