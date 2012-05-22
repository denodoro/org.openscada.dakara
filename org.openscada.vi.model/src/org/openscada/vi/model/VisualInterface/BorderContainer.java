/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Border Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.BorderContainer#getChildren <em>Children</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.BorderContainer#getVerticalSpacing <em>Vertical Spacing</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.BorderContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getBorderContainer()
 * @model
 * @generated
 */
public interface BorderContainer extends Container
{

    /**
     * Returns the value of the '<em><b>Children</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.vi.model.VisualInterface.BorderChild}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' containment reference list.
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getBorderContainer_Children()
     * @model containment="true"
     * @generated
     */
    EList<BorderChild> getChildren ();

    /**
     * Returns the value of the '<em><b>Vertical Spacing</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vertical Spacing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Vertical Spacing</em>' attribute.
     * @see #setVerticalSpacing(int)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getBorderContainer_VerticalSpacing()
     * @model default="0" required="true"
     * @generated
     */
    int getVerticalSpacing ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.BorderContainer#getVerticalSpacing <em>Vertical Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Vertical Spacing</em>' attribute.
     * @see #getVerticalSpacing()
     * @generated
     */
    void setVerticalSpacing ( int value );

    /**
     * Returns the value of the '<em><b>Horizontal Spacing</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Horizontal Spacing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Horizontal Spacing</em>' attribute.
     * @see #setHorizontalSpacing(int)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getBorderContainer_HorizontalSpacing()
     * @model default="0" required="true"
     * @generated
     */
    int getHorizontalSpacing ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.BorderContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Horizontal Spacing</em>' attribute.
     * @see #getHorizontalSpacing()
     * @generated
     */
    void setHorizontalSpacing ( int value );
} // BorderContainer
