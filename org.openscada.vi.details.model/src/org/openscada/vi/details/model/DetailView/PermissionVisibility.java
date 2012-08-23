/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission Visibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.PermissionVisibility#getRequiredPermission <em>Required Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getPermissionVisibility()
 * @model
 * @generated
 */
public interface PermissionVisibility extends Visibility
{
    /**
     * Returns the value of the '<em><b>Required Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Permission</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Permission</em>' attribute.
     * @see #setRequiredPermission(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getPermissionVisibility_RequiredPermission()
     * @model required="true"
     * @generated
     */
    String getRequiredPermission ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.PermissionVisibility#getRequiredPermission <em>Required Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required Permission</em>' attribute.
     * @see #getRequiredPermission()
     * @generated
     */
    void setRequiredPermission ( String value );

} // PermissionVisibility
