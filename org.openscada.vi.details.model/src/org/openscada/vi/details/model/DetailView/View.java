/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.View#getHeaderComponent <em>Header Component</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.View#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getView()
 * @model
 * @generated
 */
public interface View extends EObject
{
    /**
     * Returns the value of the '<em><b>Header Component</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Header Component</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Header Component</em>' containment reference.
     * @see #setHeaderComponent(Component)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getView_HeaderComponent()
     * @model containment="true"
     * @generated
     */
    Component getHeaderComponent();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.View#getHeaderComponent <em>Header Component</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Header Component</em>' containment reference.
     * @see #getHeaderComponent()
     * @generated
     */
    void setHeaderComponent(Component value);

    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.vi.details.model.DetailView.GroupEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getView_Groups()
     * @model containment="true"
     * @generated
     */
    EList<GroupEntry> getGroups();

} // View
