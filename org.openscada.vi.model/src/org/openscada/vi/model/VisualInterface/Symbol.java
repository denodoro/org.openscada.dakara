/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol()
 * @model
 * @generated
 */
public interface Symbol extends EObject
{
    /**
     * Returns the value of the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root</em>' containment reference.
     * @see #setRoot(Primitive)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_Root()
     * @model containment="true"
     * @generated
     */
    Primitive getRoot();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Symbol#getRoot <em>Root</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root</em>' containment reference.
     * @see #getRoot()
     * @generated
     */
    void setRoot(Primitive value);

} // Symbol
