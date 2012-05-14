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
import org.openscada.vi.details.model.DetailView.ReadableComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Readable Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl#getDecimal <em>Decimal</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl#getHdConnectionid <em>Hd Connectionid</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl#getHdItemId <em>Hd Item Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ReadableComponentImpl extends ComponentImpl implements ReadableComponent
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
     * The default value of the '{@link #getDecimal() <em>Decimal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDecimal()
     * @generated
     * @ordered
     */
    protected static final String DECIMAL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDecimal() <em>Decimal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDecimal()
     * @generated
     * @ordered
     */
    protected String decimal = DECIMAL_EDEFAULT;

    /**
     * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected static final String ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected String attribute = ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getHdConnectionid() <em>Hd Connectionid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdConnectionid()
     * @generated
     * @ordered
     */
    protected static final String HD_CONNECTIONID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHdConnectionid() <em>Hd Connectionid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdConnectionid()
     * @generated
     * @ordered
     */
    protected String hdConnectionid = HD_CONNECTIONID_EDEFAULT;

    /**
     * The default value of the '{@link #getHdItemId() <em>Hd Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdItemId()
     * @generated
     * @ordered
     */
    protected static final String HD_ITEM_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHdItemId() <em>Hd Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdItemId()
     * @generated
     * @ordered
     */
    protected String hdItemId = HD_ITEM_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReadableComponentImpl()
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
        return DetailViewPackage.Literals.READABLE_COMPONENT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__FORMAT, oldFormat, format));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDecimal()
    {
        return decimal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDecimal(String newDecimal)
    {
        String oldDecimal = decimal;
        decimal = newDecimal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__DECIMAL, oldDecimal, decimal));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAttribute()
    {
        return attribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttribute(String newAttribute)
    {
        String oldAttribute = attribute;
        attribute = newAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE, oldAttribute, attribute));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHdConnectionid()
    {
        return hdConnectionid;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHdConnectionid(String newHdConnectionid)
    {
        String oldHdConnectionid = hdConnectionid;
        hdConnectionid = newHdConnectionid;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__HD_CONNECTIONID, oldHdConnectionid, hdConnectionid));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHdItemId()
    {
        return hdItemId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHdItemId(String newHdItemId)
    {
        String oldHdItemId = hdItemId;
        hdItemId = newHdItemId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID, oldHdItemId, hdItemId));
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                return getFormat();
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                return getDecimal();
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                return getAttribute();
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTIONID:
                return getHdConnectionid();
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                return getHdItemId();
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                setFormat((String)newValue);
                return;
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                setDecimal((String)newValue);
                return;
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                setAttribute((String)newValue);
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTIONID:
                setHdConnectionid((String)newValue);
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                setHdItemId((String)newValue);
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                setFormat(FORMAT_EDEFAULT);
                return;
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                setDecimal(DECIMAL_EDEFAULT);
                return;
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                setAttribute(ATTRIBUTE_EDEFAULT);
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTIONID:
                setHdConnectionid(HD_CONNECTIONID_EDEFAULT);
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                setHdItemId(HD_ITEM_ID_EDEFAULT);
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                return DECIMAL_EDEFAULT == null ? decimal != null : !DECIMAL_EDEFAULT.equals(decimal);
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals(attribute);
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTIONID:
                return HD_CONNECTIONID_EDEFAULT == null ? hdConnectionid != null : !HD_CONNECTIONID_EDEFAULT.equals(hdConnectionid);
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                return HD_ITEM_ID_EDEFAULT == null ? hdItemId != null : !HD_ITEM_ID_EDEFAULT.equals(hdItemId);
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
        result.append(", decimal: ");
        result.append(decimal);
        result.append(", attribute: ");
        result.append(attribute);
        result.append(", hdConnectionid: ");
        result.append(hdConnectionid);
        result.append(", hdItemId: ");
        result.append(hdItemId);
        result.append(')');
        return result.toString();
    }

} //ReadableComponentImpl
