/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.openscada.vi.model.VisualInterface.Child;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.ChildImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildImpl extends EObjectImpl implements Child
{
    /**
     * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getElement()
     * @generated
     * @ordered
     */
    protected Primitive element;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChildImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return VisualInterfacePackage.Literals.CHILD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Primitive getElement()
    {
        return element;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetElement(Primitive newElement, NotificationChain msgs)
    {
        Primitive oldElement = element;
        element = newElement;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.CHILD__ELEMENT, oldElement, newElement);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setElement(Primitive newElement)
    {
        if (newElement != element)
        {
            NotificationChain msgs = null;
            if (element != null)
                msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.CHILD__ELEMENT, null, msgs);
            if (newElement != null)
                msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.CHILD__ELEMENT, null, msgs);
            msgs = basicSetElement(newElement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.CHILD__ELEMENT, newElement, newElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case VisualInterfacePackage.CHILD__ELEMENT:
                return basicSetElement(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case VisualInterfacePackage.CHILD__ELEMENT:
                return getElement();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case VisualInterfacePackage.CHILD__ELEMENT:
                setElement((Primitive)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case VisualInterfacePackage.CHILD__ELEMENT:
                setElement((Primitive)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case VisualInterfacePackage.CHILD__ELEMENT:
                return element != null;
        }
        return super.eIsSet(featureID);
    }

} //ChildImpl
