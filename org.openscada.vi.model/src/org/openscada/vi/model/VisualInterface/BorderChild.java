/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Border Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.BorderChild#getAlignment <em>Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getBorderChild()
 * @model
 * @generated
 */
public interface BorderChild extends Child
{
    /**
     * Returns the value of the '<em><b>Alignment</b></em>' attribute.
     * The default value is <code>"CENTER"</code>.
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
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getBorderChild_Alignment()
     * @model default="CENTER" required="true"
     * @generated
     */
    Alignment getAlignment ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.BorderChild#getAlignment <em>Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see #getAlignment()
     * @generated
     */
    void setAlignment ( Alignment value );

} // BorderChild
