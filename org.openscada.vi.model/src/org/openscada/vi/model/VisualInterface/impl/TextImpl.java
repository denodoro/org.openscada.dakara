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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.TextImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.TextImpl#getAlignment <em>Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextImpl extends FigureImpl implements Text
{
    /**
     * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormat()
     * @generated
     * @ordered
     */
    protected static final String FORMAT_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormat()
     * @generated
     * @ordered
     */
    protected String format = FORMAT_EDEFAULT;

    /**
     * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment ALIGNMENT_EDEFAULT = Alignment.LEFT;
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
    protected TextImpl()
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
        return VisualInterfacePackage.Literals.TEXT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFormat(String newFormat)
    {
        String oldFormat = format;
        format = newFormat;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.TEXT__FORMAT, oldFormat, format));
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
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.TEXT__ALIGNMENT, oldAlignment, alignment));
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
            case VisualInterfacePackage.TEXT__FORMAT:
                return getFormat();
            case VisualInterfacePackage.TEXT__ALIGNMENT:
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
            case VisualInterfacePackage.TEXT__FORMAT:
                setFormat((String)newValue);
                return;
            case VisualInterfacePackage.TEXT__ALIGNMENT:
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
            case VisualInterfacePackage.TEXT__FORMAT:
                setFormat(FORMAT_EDEFAULT);
                return;
            case VisualInterfacePackage.TEXT__ALIGNMENT:
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
            case VisualInterfacePackage.TEXT__FORMAT:
                return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
            case VisualInterfacePackage.TEXT__ALIGNMENT:
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
        result.append(" (format: ");
        result.append(format);
        result.append(", alignment: ");
        result.append(alignment);
        result.append(')');
        return result.toString();
    }

} //TextImpl
