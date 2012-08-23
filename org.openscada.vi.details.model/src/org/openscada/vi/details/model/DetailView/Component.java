/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.Component#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends EObject
{

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visibility</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' containment reference.
     * @see #setVisibility(Visibility)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getComponent_Visibility()
     * @model containment="true"
     * @generated
     */
    Visibility getVisibility ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.Component#getVisibility <em>Visibility</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' containment reference.
     * @see #getVisibility()
     * @generated
     */
    void setVisibility ( Visibility value );
} // Component
