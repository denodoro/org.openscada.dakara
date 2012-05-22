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
 * A representation of the model object '<em><b>Group Grid Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#isEqually <em>Equally</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#getCols <em>Cols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridComponent()
 * @model
 * @generated
 */
public interface GroupGridComponent extends Component
{
    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.vi.details.model.DetailView.GroupGridEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridComponent_Groups()
     * @model containment="true"
     * @generated
     */
    EList<GroupGridEntry> getGroups ();

    /**
     * Returns the value of the '<em><b>Equally</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equally</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equally</em>' attribute.
     * @see #setEqually(boolean)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridComponent_Equally()
     * @model default="false" required="true"
     * @generated
     */
    boolean isEqually ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#isEqually <em>Equally</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Equally</em>' attribute.
     * @see #isEqually()
     * @generated
     */
    void setEqually ( boolean value );

    /**
     * Returns the value of the '<em><b>Cols</b></em>' attribute.
     * The default value is <code>"2"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cols</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cols</em>' attribute.
     * @see #setCols(int)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridComponent_Cols()
     * @model default="2" required="true"
     * @generated
     */
    int getCols ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#getCols <em>Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cols</em>' attribute.
     * @see #getCols()
     * @generated
     */
    void setCols ( int value );

} // GroupGridComponent
