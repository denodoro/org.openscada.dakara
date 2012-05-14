/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Input Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextInputComponent#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextInputComponent#getReadDescriptor <em>Read Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextInputComponent()
 * @model
 * @generated
 */
public interface TextInputComponent extends WriteableComponent
{
    /**
     * Returns the value of the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Descriptor</em>' attribute.
     * @see #setDescriptor(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextInputComponent_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextInputComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor(String value);

    /**
     * Returns the value of the '<em><b>Read Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Read Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Read Descriptor</em>' attribute.
     * @see #setReadDescriptor(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextInputComponent_ReadDescriptor()
     * @model
     * @generated
     */
    String getReadDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextInputComponent#getReadDescriptor <em>Read Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Descriptor</em>' attribute.
     * @see #getReadDescriptor()
     * @generated
     */
    void setReadDescriptor(String value);

} // TextInputComponent
