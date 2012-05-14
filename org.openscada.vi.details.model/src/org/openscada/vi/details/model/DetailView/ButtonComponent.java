/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Button Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getFormat <em>Format</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getValue <em>Value</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getReadDescriptor <em>Read Descriptor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getWriteDescriptor <em>Write Descriptor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getActive <em>Active</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getTextHeight <em>Text Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent()
 * @model
 * @generated
 */
public interface ButtonComponent extends GenericComponent
{
    /**
     * Returns the value of the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Format</em>' attribute.
     * @see #setFormat(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent_Format()
     * @model required="true"
     * @generated
     */
    String getFormat();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent_Value()
     * @model required="true"
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent_ReadDescriptor()
     * @model
     * @generated
     */
    String getReadDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getReadDescriptor <em>Read Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Descriptor</em>' attribute.
     * @see #getReadDescriptor()
     * @generated
     */
    void setReadDescriptor(String value);

    /**
     * Returns the value of the '<em><b>Write Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Write Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Write Descriptor</em>' attribute.
     * @see #setWriteDescriptor(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent_WriteDescriptor()
     * @model required="true"
     * @generated
     */
    String getWriteDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getWriteDescriptor <em>Write Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Write Descriptor</em>' attribute.
     * @see #getWriteDescriptor()
     * @generated
     */
    void setWriteDescriptor(String value);

    /**
     * Returns the value of the '<em><b>Active</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Active</em>' containment reference.
     * @see #setActive(ValueSource)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent_Active()
     * @model containment="true"
     * @generated
     */
    ValueSource getActive();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getActive <em>Active</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active</em>' containment reference.
     * @see #getActive()
     * @generated
     */
    void setActive(ValueSource value);

    /**
     * Returns the value of the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute</em>' attribute.
     * @see #setAttribute(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent_Attribute()
     * @model
     * @generated
     */
    String getAttribute();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getAttribute <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute</em>' attribute.
     * @see #getAttribute()
     * @generated
     */
    void setAttribute(String value);

    /**
     * Returns the value of the '<em><b>Text Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text Height</em>' attribute.
     * @see #setTextHeight(int)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getButtonComponent_TextHeight()
     * @model
     * @generated
     */
    int getTextHeight();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getTextHeight <em>Text Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text Height</em>' attribute.
     * @see #getTextHeight()
     * @generated
     */
    void setTextHeight(int value);

} // ButtonComponent
