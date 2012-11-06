/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.GenericComponent;
import org.openscada.vi.details.model.DetailView.Registration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.GenericComponentImpl#getRegistrations <em>Registrations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GenericComponentImpl extends ComponentImpl implements GenericComponent
{
    /**
     * The cached value of the '{@link #getRegistrations() <em>Registrations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegistrations()
     * @generated
     * @ordered
     */
    protected EList<Registration> registrations;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenericComponentImpl ()
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
        return DetailViewPackage.Literals.GENERIC_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Registration> getRegistrations ()
    {
        if ( registrations == null )
        {
            registrations = new EObjectContainmentEList<Registration> ( Registration.class, this, DetailViewPackage.GENERIC_COMPONENT__REGISTRATIONS );
        }
        return registrations;
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
        case DetailViewPackage.GENERIC_COMPONENT__REGISTRATIONS:
            return ( (InternalEList<?>)getRegistrations () ).basicRemove ( otherEnd, msgs );
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
        case DetailViewPackage.GENERIC_COMPONENT__REGISTRATIONS:
            return getRegistrations ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
        case DetailViewPackage.GENERIC_COMPONENT__REGISTRATIONS:
            getRegistrations ().clear ();
            getRegistrations ().addAll ( (Collection<? extends Registration>)newValue );
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
        case DetailViewPackage.GENERIC_COMPONENT__REGISTRATIONS:
            getRegistrations ().clear ();
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
        case DetailViewPackage.GENERIC_COMPONENT__REGISTRATIONS:
            return registrations != null && !registrations.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //GenericComponentImpl
