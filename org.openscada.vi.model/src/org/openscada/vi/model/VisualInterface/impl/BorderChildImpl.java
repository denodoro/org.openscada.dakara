/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.openscada.vi.model.VisualInterface.Alignment;
import org.openscada.vi.model.VisualInterface.BorderChild;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Border Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.BorderChildImpl#getAlignment <em>Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BorderChildImpl extends ChildImpl implements BorderChild
{
    /**
     * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment ALIGNMENT_EDEFAULT = Alignment.CENTER;

    /**
     * The cached value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlignment()
     * @generated
     * @ordered
     */
    protected Alignment alignment = ALIGNMENT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BorderChildImpl()
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
        return VisualInterfacePackage.Literals.BORDER_CHILD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment getAlignment()
    {
        return alignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAlignment(Alignment newAlignment)
    {
        Alignment oldAlignment = alignment;
        alignment = newAlignment == null ? ALIGNMENT_EDEFAULT : newAlignment;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.BORDER_CHILD__ALIGNMENT, oldAlignment, alignment));
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
            case VisualInterfacePackage.BORDER_CHILD__ALIGNMENT:
                return getAlignment();
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
            case VisualInterfacePackage.BORDER_CHILD__ALIGNMENT:
                setAlignment((Alignment)newValue);
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
            case VisualInterfacePackage.BORDER_CHILD__ALIGNMENT:
                setAlignment(ALIGNMENT_EDEFAULT);
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
            case VisualInterfacePackage.BORDER_CHILD__ALIGNMENT:
                return alignment != ALIGNMENT_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (alignment: "); //$NON-NLS-1$
        result.append(alignment);
        result.append(')');
        return result.toString();
    }

} //BorderChildImpl
