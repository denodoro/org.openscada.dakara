/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Set Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getValueDescriptor <em>Value Descriptor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getSetDescriptor <em>Set Descriptor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getResetDescriptor <em>Reset Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getValueSetComponent()
 * @model
 * @generated
 */
public interface ValueSetComponent extends WriteableComponent
{
    /**
     * Returns the value of the '<em><b>Value Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Descriptor</em>' attribute.
     * @see #setValueDescriptor(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getValueSetComponent_ValueDescriptor()
     * @model required="true"
     * @generated
     */
    String getValueDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getValueDescriptor <em>Value Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Descriptor</em>' attribute.
     * @see #getValueDescriptor()
     * @generated
     */
    void setValueDescriptor(String value);

    /**
     * Returns the value of the '<em><b>Set Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Set Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Set Descriptor</em>' attribute.
     * @see #setSetDescriptor(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getValueSetComponent_SetDescriptor()
     * @model
     * @generated
     */
    String getSetDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getSetDescriptor <em>Set Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Set Descriptor</em>' attribute.
     * @see #getSetDescriptor()
     * @generated
     */
    void setSetDescriptor(String value);

    /**
     * Returns the value of the '<em><b>Reset Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reset Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reset Descriptor</em>' attribute.
     * @see #setResetDescriptor(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getValueSetComponent_ResetDescriptor()
     * @model
     * @generated
     */
    String getResetDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getResetDescriptor <em>Reset Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reset Descriptor</em>' attribute.
     * @see #getResetDescriptor()
     * @generated
     */
    void setResetDescriptor(String value);

} // ValueSetComponent
