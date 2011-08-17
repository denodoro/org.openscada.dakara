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
 *   <li>{@link org.openscada.vi.model.VisualInterface.Text#getFormat <em>Format</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Text#getAlignment <em>Alignment</em>}</li>
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
     * Returns the value of the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Format</em>' attribute.
     * @see #setFormat(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getText_Format()
     * @model required="true"
     * @generated
     */
    String getFormat();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Text#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat(String value);

    /**
     * Returns the value of the '<em><b>Alignment</b></em>' attribute.
     * The literals are from the enumeration {@link org.openscada.vi.model.VisualInterface.Alignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #setAlignment(Alignment)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getText_Alignment()
     * @model
     * @generated
     */
    Alignment getAlignment();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Text#getAlignment <em>Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #getAlignment()
     * @generated
     */
    void setAlignment(Alignment value);
} // Text
