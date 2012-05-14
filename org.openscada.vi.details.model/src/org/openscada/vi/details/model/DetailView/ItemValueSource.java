/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Value Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ItemValueSource#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getItemValueSource()
 * @model
 * @generated
 */
public interface ItemValueSource extends ValueSource
{
    /**
     * Returns the value of the '<em><b>Value Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Key</em>' attribute.
     * @see #setValueKey(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getItemValueSource_ValueKey()
     * @model required="true"
     * @generated
     */
    String getValueKey();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ItemValueSource#getValueKey <em>Value Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Key</em>' attribute.
     * @see #getValueKey()
     * @generated
     */
    void setValueKey(String value);

} // ItemValueSource
