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
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Connection#getStart <em>Start</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Connection#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject
{
    /**
     * Returns the value of the '<em><b>Start</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start</em>' reference.
     * @see #setStart(Primitive)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getConnection_Start()
     * @model required="true"
     * @generated
     */
    Primitive getStart();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Connection#getStart <em>Start</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start</em>' reference.
     * @see #getStart()
     * @generated
     */
    void setStart(Primitive value);

    /**
     * Returns the value of the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>End</em>' reference.
     * @see #setEnd(Primitive)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getConnection_End()
     * @model keys="name" required="true"
     * @generated
     */
    Primitive getEnd();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Connection#getEnd <em>End</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>End</em>' reference.
     * @see #getEnd()
     * @generated
     */
    void setEnd(Primitive value);

} // Connection
