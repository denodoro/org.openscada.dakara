/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XY Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.XYChild#getPosition <em>Position</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.XYChild#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getXYChild()
 * @model
 * @generated
 */
public interface XYChild extends Child
{
    /**
     * Returns the value of the '<em><b>Position</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Position</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Position</em>' containment reference.
     * @see #setPosition(Position)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getXYChild_Position()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element'"
     * @generated
     */
    Position getPosition();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.XYChild#getPosition <em>Position</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Position</em>' containment reference.
     * @see #getPosition()
     * @generated
     */
    void setPosition(Position value);

    /**
     * Returns the value of the '<em><b>Dimension</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An optional dimension for the XYLayout
     * <!-- end-model-doc -->
     * @return the value of the '<em>Dimension</em>' containment reference.
     * @see #setDimension(Dimension)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getXYChild_Dimension()
     * @model containment="true"
     * @generated
     */
    Dimension getDimension();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.XYChild#getDimension <em>Dimension</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dimension</em>' containment reference.
     * @see #getDimension()
     * @generated
     */
    void setDimension(Dimension value);

} // XYChild
