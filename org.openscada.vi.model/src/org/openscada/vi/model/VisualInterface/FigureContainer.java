/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.FigureContainer#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigureContainer()
 * @model
 * @generated
 */
public interface FigureContainer extends Figure
{
    /**
     * Returns the value of the '<em><b>Content</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Content</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Content</em>' containment reference.
     * @see #setContent(Primitive)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigureContainer_Content()
     * @model containment="true"
     * @generated
     */
    Primitive getContent();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.FigureContainer#getContent <em>Content</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Content</em>' containment reference.
     * @see #getContent()
     * @generated
     */
    void setContent(Primitive value);

} // FigureContainer
