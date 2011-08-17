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
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.TextImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.TextImpl#getLabelAlignment <em>Label Alignment</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.TextImpl#getTextAlignment <em>Text Alignment</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.TextImpl#getIconAlignment <em>Icon Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextImpl extends FigureImpl implements Text
{
    /**
     * The default value of the '{@link #getText() <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getText()
     * @generated
     * @ordered
     */
    protected static final String TEXT_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getText()
     * @generated
     * @ordered
     */
    protected String text = TEXT_EDEFAULT;
    /**
     * The default value of the '{@link #getLabelAlignment() <em>Label Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment LABEL_ALIGNMENT_EDEFAULT = Alignment.LEFT;
    /**
     * The cached value of the '{@link #getLabelAlignment() <em>Label Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelAlignment()
     * @generated
     * @ordered
     */
    protected Alignment labelAlignment = LABEL_ALIGNMENT_EDEFAULT;
    /**
     * The default value of the '{@link #getTextAlignment() <em>Text Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment TEXT_ALIGNMENT_EDEFAULT = Alignment.LEFT;
    /**
     * The cached value of the '{@link #getTextAlignment() <em>Text Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextAlignment()
     * @generated
     * @ordered
     */
    protected Alignment textAlignment = TEXT_ALIGNMENT_EDEFAULT;
    /**
     * The default value of the '{@link #getIconAlignment() <em>Icon Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIconAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment ICON_ALIGNMENT_EDEFAULT = Alignment.LEFT;
    /**
     * The cached value of the '{@link #getIconAlignment() <em>Icon Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIconAlignment()
     * @generated
     * @ordered
     */
    protected Alignment iconAlignment = ICON_ALIGNMENT_EDEFAULT;
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
    public String getText()
    {
        return text;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setText(String newText)
    {
        String oldText = text;
        text = newText;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.TEXT__TEXT, oldText, text));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment getLabelAlignment()
    {
        return labelAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabelAlignment(Alignment newLabelAlignment)
    {
        Alignment oldLabelAlignment = labelAlignment;
        labelAlignment = newLabelAlignment == null ? LABEL_ALIGNMENT_EDEFAULT : newLabelAlignment;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.TEXT__LABEL_ALIGNMENT, oldLabelAlignment, labelAlignment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment getTextAlignment()
    {
        return textAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTextAlignment(Alignment newTextAlignment)
    {
        Alignment oldTextAlignment = textAlignment;
        textAlignment = newTextAlignment == null ? TEXT_ALIGNMENT_EDEFAULT : newTextAlignment;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.TEXT__TEXT_ALIGNMENT, oldTextAlignment, textAlignment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment getIconAlignment()
    {
        return iconAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIconAlignment(Alignment newIconAlignment)
    {
        Alignment oldIconAlignment = iconAlignment;
        iconAlignment = newIconAlignment == null ? ICON_ALIGNMENT_EDEFAULT : newIconAlignment;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, VisualInterfacePackage.TEXT__ICON_ALIGNMENT, oldIconAlignment, iconAlignment));
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
            case VisualInterfacePackage.TEXT__TEXT:
                return getText();
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                return getLabelAlignment();
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                return getTextAlignment();
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                return getIconAlignment();
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
            case VisualInterfacePackage.TEXT__TEXT:
                setText((String)newValue);
                return;
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                setLabelAlignment((Alignment)newValue);
                return;
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                setTextAlignment((Alignment)newValue);
                return;
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                setIconAlignment((Alignment)newValue);
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
            case VisualInterfacePackage.TEXT__TEXT:
                setText(TEXT_EDEFAULT);
                return;
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                setLabelAlignment(LABEL_ALIGNMENT_EDEFAULT);
                return;
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                setTextAlignment(TEXT_ALIGNMENT_EDEFAULT);
                return;
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                setIconAlignment(ICON_ALIGNMENT_EDEFAULT);
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
            case VisualInterfacePackage.TEXT__TEXT:
                return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                return labelAlignment != LABEL_ALIGNMENT_EDEFAULT;
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                return textAlignment != TEXT_ALIGNMENT_EDEFAULT;
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                return iconAlignment != ICON_ALIGNMENT_EDEFAULT;
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
        result.append(" (text: ");
        result.append(text);
        result.append(", labelAlignment: ");
        result.append(labelAlignment);
        result.append(", textAlignment: ");
        result.append(textAlignment);
        result.append(", iconAlignment: ");
        result.append(iconAlignment);
        result.append(')');
        return result.toString();
    }

} //TextImpl
