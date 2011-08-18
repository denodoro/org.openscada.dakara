/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Cursor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.SystemCursor#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSystemCursor()
 * @model
 * @generated
 */
public interface SystemCursor extends Cursor
{
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.openscada.vi.model.VisualInterface.SystemCursorType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.SystemCursorType
     * @see #setType(SystemCursorType)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSystemCursor_Type()
     * @model required="true"
     * @generated
     */
    SystemCursorType getType();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.SystemCursor#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.SystemCursorType
     * @see #getType()
     * @generated
     */
    void setType(SystemCursorType value);

} // SystemCursor
