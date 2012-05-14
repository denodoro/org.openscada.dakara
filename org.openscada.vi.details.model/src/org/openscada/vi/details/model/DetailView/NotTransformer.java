/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.NotTransformer#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getNotTransformer()
 * @model
 * @generated
 */
public interface NotTransformer extends ValueSource
{
    /**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(ValueSource)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getNotTransformer_Value()
     * @model containment="true" required="true"
     * @generated
     */
    ValueSource getValue();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.NotTransformer#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
    void setValue(ValueSource value);

} // NotTransformer
