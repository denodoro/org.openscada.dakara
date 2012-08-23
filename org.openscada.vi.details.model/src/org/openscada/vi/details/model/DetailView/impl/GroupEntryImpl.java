/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.openscada.vi.details.model.DetailView.Component;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.GroupEntry;
import org.openscada.vi.details.model.DetailView.Visibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl#getPermission <em>Permission</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupEntryImpl extends EObjectImpl implements GroupEntry
{
    /**
     * The cached value of the '{@link #getComponent() <em>Component</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponent()
     * @generated
     * @ordered
     */
    protected Component component;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getPermission() <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPermission()
     * @generated
     * @ordered
     */
    protected static final String PERMISSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPermission() <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPermission()
     * @generated
     * @ordered
     */
    protected String permission = PERMISSION_EDEFAULT;

    /**
     * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected Visibility visibility;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroupEntryImpl ()
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
        return DetailViewPackage.Literals.GROUP_ENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Component getComponent ()
    {
        return component;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetComponent ( Component newComponent, NotificationChain msgs )
    {
        Component oldComponent = component;
        component = newComponent;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, DetailViewPackage.GROUP_ENTRY__COMPONENT, oldComponent, newComponent );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setComponent ( Component newComponent )
    {
        if ( newComponent != component )
        {
            NotificationChain msgs = null;
            if ( component != null )
                msgs = ( (InternalEObject)component ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.GROUP_ENTRY__COMPONENT, null, msgs );
            if ( newComponent != null )
                msgs = ( (InternalEObject)newComponent ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.GROUP_ENTRY__COMPONENT, null, msgs );
            msgs = basicSetComponent ( newComponent, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.GROUP_ENTRY__COMPONENT, newComponent, newComponent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel ()
    {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel ( String newLabel )
    {
        String oldLabel = label;
        label = newLabel;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.GROUP_ENTRY__LABEL, oldLabel, label ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPermission ()
    {
        return permission;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPermission ( String newPermission )
    {
        String oldPermission = permission;
        permission = newPermission;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.GROUP_ENTRY__PERMISSION, oldPermission, permission ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Visibility getVisibility ()
    {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVisibility ( Visibility newVisibility, NotificationChain msgs )
    {
        Visibility oldVisibility = visibility;
        visibility = newVisibility;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, DetailViewPackage.GROUP_ENTRY__VISIBILITY, oldVisibility, newVisibility );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVisibility ( Visibility newVisibility )
    {
        if ( newVisibility != visibility )
        {
            NotificationChain msgs = null;
            if ( visibility != null )
                msgs = ( (InternalEObject)visibility ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.GROUP_ENTRY__VISIBILITY, null, msgs );
            if ( newVisibility != null )
                msgs = ( (InternalEObject)newVisibility ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.GROUP_ENTRY__VISIBILITY, null, msgs );
            msgs = basicSetVisibility ( newVisibility, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.GROUP_ENTRY__VISIBILITY, newVisibility, newVisibility ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case DetailViewPackage.GROUP_ENTRY__COMPONENT:
                return basicSetComponent ( null, msgs );
            case DetailViewPackage.GROUP_ENTRY__VISIBILITY:
                return basicSetVisibility ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
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
            case DetailViewPackage.GROUP_ENTRY__COMPONENT:
                return getComponent ();
            case DetailViewPackage.GROUP_ENTRY__LABEL:
                return getLabel ();
            case DetailViewPackage.GROUP_ENTRY__PERMISSION:
                return getPermission ();
            case DetailViewPackage.GROUP_ENTRY__VISIBILITY:
                return getVisibility ();
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
            case DetailViewPackage.GROUP_ENTRY__COMPONENT:
                setComponent ( (Component)newValue );
                return;
            case DetailViewPackage.GROUP_ENTRY__LABEL:
                setLabel ( (String)newValue );
                return;
            case DetailViewPackage.GROUP_ENTRY__PERMISSION:
                setPermission ( (String)newValue );
                return;
            case DetailViewPackage.GROUP_ENTRY__VISIBILITY:
                setVisibility ( (Visibility)newValue );
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
            case DetailViewPackage.GROUP_ENTRY__COMPONENT:
                setComponent ( (Component)null );
                return;
            case DetailViewPackage.GROUP_ENTRY__LABEL:
                setLabel ( LABEL_EDEFAULT );
                return;
            case DetailViewPackage.GROUP_ENTRY__PERMISSION:
                setPermission ( PERMISSION_EDEFAULT );
                return;
            case DetailViewPackage.GROUP_ENTRY__VISIBILITY:
                setVisibility ( (Visibility)null );
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
            case DetailViewPackage.GROUP_ENTRY__COMPONENT:
                return component != null;
            case DetailViewPackage.GROUP_ENTRY__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals ( label );
            case DetailViewPackage.GROUP_ENTRY__PERMISSION:
                return PERMISSION_EDEFAULT == null ? permission != null : !PERMISSION_EDEFAULT.equals ( permission );
            case DetailViewPackage.GROUP_ENTRY__VISIBILITY:
                return visibility != null;
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
        result.append ( " (label: " );
        result.append ( label );
        result.append ( ", permission: " );
        result.append ( permission );
        result.append ( ')' );
        return result.toString ();
    }

} //GroupEntryImpl
