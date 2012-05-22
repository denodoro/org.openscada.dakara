/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GenericComponent#getRegistrations <em>Registrations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGenericComponent()
 * @model abstract="true"
 * @generated
 */
public interface GenericComponent extends Component
{
    /**
     * Returns the value of the '<em><b>Registrations</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.vi.details.model.DetailView.Registration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Registrations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Registrations</em>' containment reference list.
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGenericComponent_Registrations()
     * @model containment="true"
     * @generated
     */
    EList<Registration> getRegistrations ();

} // GenericComponent
