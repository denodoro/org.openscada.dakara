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
 * A representation of the model object '<em><b>Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Position#getX <em>X</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Position#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getPosition()
 * @model
 * @generated
 */
public interface Position extends EObject
{
    /**
     * Returns the value of the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>X</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>X</em>' attribute.
     * @see #setX(double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getPosition_X()
     * @model required="true"
     * @generated
     */
    double getX ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Position#getX <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>X</em>' attribute.
     * @see #getX()
     * @generated
     */
    void setX ( double value );

    /**
     * Returns the value of the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Y</em>' attribute.
     * @see #setY(double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getPosition_Y()
     * @model required="true"
     * @generated
     */
    double getY ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Position#getY <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' attribute.
     * @see #getY()
     * @generated
     */
    void setY ( double value );

} // Position
