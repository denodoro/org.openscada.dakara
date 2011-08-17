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
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Dimension#getWidth <em>Width</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Dimension#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getDimension()
 * @model
 * @generated
 */
public interface Dimension extends EObject
{
    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getDimension_Width()
     * @model default="0" required="true"
     * @generated
     */
    double getWidth();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Dimension#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth(double value);

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getDimension_Height()
     * @model default="0" required="true"
     * @generated
     */
    double getHeight();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Dimension#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight(double value);

} // Dimension
