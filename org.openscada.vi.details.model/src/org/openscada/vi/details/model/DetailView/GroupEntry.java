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
 * A representation of the model object '<em><b>Group Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupEntry#getComponent <em>Component</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupEntry#getLabel <em>Label</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.GroupEntry#getPermission <em>Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupEntry()
 * @model
 * @generated
 */
public interface GroupEntry extends EObject
{
    /**
     * Returns the value of the '<em><b>Component</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Component</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Component</em>' containment reference.
     * @see #setComponent(Component)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupEntry_Component()
     * @model containment="true" required="true"
     * @generated
     */
    Component getComponent();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.GroupEntry#getComponent <em>Component</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Component</em>' containment reference.
     * @see #getComponent()
     * @generated
     */
    void setComponent(Component value);

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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupEntry_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.GroupEntry#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getGroupEntry_Permission()
     * @model
     * @generated
     */
    String getPermission();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.GroupEntry#getPermission <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Permission</em>' attribute.
     * @see #getPermission()
     * @generated
     */
    void setPermission(String value);

} // GroupEntry
