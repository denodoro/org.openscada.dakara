/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Text#getText <em>Text</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Text#getLabelAlignment <em>Label Alignment</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Text#getTextAlignment <em>Text Alignment</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Text#getIconAlignment <em>Icon Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getText()
 * @model
 * @generated
 */
public interface Text extends Figure
{

    /**
     * Returns the value of the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text</em>' attribute.
     * @see #setText(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getText_Text()
     * @model required="true"
     * @generated
     */
    String getText();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Text#getText <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text</em>' attribute.
     * @see #getText()
     * @generated
     */
    void setText(String value);

    /**
     * Returns the value of the '<em><b>Label Alignment</b></em>' attribute.
     * The literals are from the enumeration {@link org.openscada.vi.model.VisualInterface.Alignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #setLabelAlignment(Alignment)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getText_LabelAlignment()
     * @model
     * @generated
     */
    Alignment getLabelAlignment();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Text#getLabelAlignment <em>Label Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #getLabelAlignment()
     * @generated
     */
    void setLabelAlignment(Alignment value);

    /**
     * Returns the value of the '<em><b>Text Alignment</b></em>' attribute.
     * The literals are from the enumeration {@link org.openscada.vi.model.VisualInterface.Alignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #setTextAlignment(Alignment)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getText_TextAlignment()
     * @model
     * @generated
     */
    Alignment getTextAlignment();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Text#getTextAlignment <em>Text Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #getTextAlignment()
     * @generated
     */
    void setTextAlignment(Alignment value);

    /**
     * Returns the value of the '<em><b>Icon Alignment</b></em>' attribute.
     * The literals are from the enumeration {@link org.openscada.vi.model.VisualInterface.Alignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Icon Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Icon Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #setIconAlignment(Alignment)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getText_IconAlignment()
     * @model
     * @generated
     */
    Alignment getIconAlignment();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Text#getIconAlignment <em>Icon Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Icon Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #getIconAlignment()
     * @generated
     */
    void setIconAlignment(Alignment value);
} // Text
