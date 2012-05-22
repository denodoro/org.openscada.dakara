/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Input Multi Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextInputMultiComponent#getDescriptor <em>Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextInputMultiComponent()
 * @model
 * @generated
 */
public interface TextInputMultiComponent extends WriteableComponent
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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextInputMultiComponent_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextInputMultiComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor ( String value );

} // TextInputMultiComponent
