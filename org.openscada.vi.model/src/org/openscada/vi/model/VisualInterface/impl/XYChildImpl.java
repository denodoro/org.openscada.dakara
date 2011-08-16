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

import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;
import org.openscada.vi.model.VisualInterface.XYChild;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XY Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.XYChildImpl#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XYChildImpl extends ChildImpl implements XYChild
{
    /**
     * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosition()
     * @generated
     * @ordered
     */
    protected Position position;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XYChildImpl()
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
        return VisualInterfacePackage.Literals.XY_CHILD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPosition(Position newPosition, NotificationChain msgs)
    {
        Position oldPosition = position;
        position = newPosition;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.XY_CHILD__POSITION, oldPosition, newPosition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPosition(Position newPosition)
    {
        if (newPosition != position)
        {
            NotificationChain msgs = null;
            if (position != null)
                msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.XY_CHILD__POSITION, null, msgs);
            if (newPosition != null)
                msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.XY_CHILD__POSITION, null, msgs);
            msgs = basicSetPosition(newPosition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.XY_CHILD__POSITION, newPosition, newPosition));
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                return basicSetPosition(null, msgs);
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                return getPosition();
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                setPosition((Position)newValue);
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                setPosition((Position)null);
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                return position != null;
        }
        return super.eIsSet(featureID);
    }

} //XYChildImpl
