/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Shape#getWidth <em>Width</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Shape#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getShape()
 * @model abstract="true"
 * @generated
 */
public interface Shape extends Primitive
{
    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getShape_Width()
     * @model required="true"
     * @generated
     */
    double getWidth();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Shape#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth(double value);

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getShape_Height()
     * @model required="true"
     * @generated
     */
    double getHeight();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Shape#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight(double value);

} // Shape
