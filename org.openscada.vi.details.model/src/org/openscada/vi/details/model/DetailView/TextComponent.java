/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextComponent#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextComponent#getWidth <em>Width</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextComponent#getHeight <em>Height</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextComponent#isDate <em>Date</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextComponent#getTextHeight <em>Text Height</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.TextComponent#getTextMap <em>Text Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextComponent()
 * @model
 * @generated
 */
public interface TextComponent extends ReadableComponent
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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextComponent_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor(String value);

    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(int)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextComponent_Width()
     * @model
     * @generated
     */
    int getWidth();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextComponent#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth(int value);

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(int)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextComponent_Height()
     * @model
     * @generated
     */
    int getHeight();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextComponent#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight(int value);

    /**
     * Returns the value of the '<em><b>Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Date</em>' attribute.
     * @see #setDate(boolean)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextComponent_Date()
     * @model
     * @generated
     */
    boolean isDate();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextComponent#isDate <em>Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Date</em>' attribute.
     * @see #isDate()
     * @generated
     */
    void setDate(boolean value);

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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextComponent_TextHeight()
     * @model
     * @generated
     */
    int getTextHeight();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextComponent#getTextHeight <em>Text Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text Height</em>' attribute.
     * @see #getTextHeight()
     * @generated
     */
    void setTextHeight(int value);

    /**
     * Returns the value of the '<em><b>Text Map</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text Map</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text Map</em>' attribute.
     * @see #setTextMap(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getTextComponent_TextMap()
     * @model
     * @generated
     */
    String getTextMap();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.TextComponent#getTextMap <em>Text Map</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text Map</em>' attribute.
     * @see #getTextMap()
     * @generated
     */
    void setTextMap(String value);

} // TextComponent
