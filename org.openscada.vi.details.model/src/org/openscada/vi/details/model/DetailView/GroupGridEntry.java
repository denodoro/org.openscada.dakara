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
 * A representation of the model object '<em><b>Group Grid Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getLabel <em>Label</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getComponents <em>Components</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getPermission <em>Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridEntry()
 * @model
 * @generated
 */
public interface GroupGridEntry extends EObject
{
    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridEntry_Label()
     * @model required="true"
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Components</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.vi.details.model.DetailView.Component}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Components</em>' containment reference list.
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridEntry_Components()
     * @model containment="true"
     * @generated
     */
    EList<Component> getComponents();

    /**
     * Returns the value of the '<em><b>Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Permission</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Permission</em>' attribute.
     * @see #setPermission(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupGridEntry_Permission()
     * @model
     * @generated
     */
    String getPermission();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getPermission <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Permission</em>' attribute.
     * @see #getPermission()
     * @generated
     */
    void setPermission(String value);

} // GroupGridEntry
