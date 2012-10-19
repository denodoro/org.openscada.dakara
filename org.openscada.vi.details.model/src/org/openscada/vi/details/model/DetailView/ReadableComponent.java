/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Readable Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getFormat <em>Format</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getDecimal <em>Decimal</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdConnectionId <em>Hd Connection Id</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdItemId <em>Hd Item Id</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdQueryString <em>Hd Query String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getReadableComponent()
 * @model abstract="true"
 * @generated
 */
public interface ReadableComponent extends Component
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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getReadableComponent_Format()
     * @model
     * @generated
     */
    String getFormat ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat ( String value );

    /**
     * Returns the value of the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Decimal</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Decimal</em>' attribute.
     * @see #setDecimal(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getReadableComponent_Decimal()
     * @model
     * @generated
     */
    String getDecimal ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getDecimal <em>Decimal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Decimal</em>' attribute.
     * @see #getDecimal()
     * @generated
     */
    void setDecimal ( String value );

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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getReadableComponent_Attribute()
     * @model
     * @generated
     */
    String getAttribute ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getAttribute <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute</em>' attribute.
     * @see #getAttribute()
     * @generated
     */
    void setAttribute ( String value );

    /**
     * Returns the value of the '<em><b>Hd Connection Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hd Connection Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hd Connection Id</em>' attribute.
     * @see #setHdConnectionId(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getReadableComponent_HdConnectionId()
     * @model
     * @generated
     */
    String getHdConnectionId ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdConnectionId <em>Hd Connection Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hd Connection Id</em>' attribute.
     * @see #getHdConnectionId()
     * @generated
     */
    void setHdConnectionId ( String value );

    /**
     * Returns the value of the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hd Item Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hd Item Id</em>' attribute.
     * @see #setHdItemId(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getReadableComponent_HdItemId()
     * @model
     * @generated
     */
    String getHdItemId ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdItemId <em>Hd Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hd Item Id</em>' attribute.
     * @see #getHdItemId()
     * @generated
     */
    void setHdItemId ( String value );

    /**
     * Returns the value of the '<em><b>Hd Query String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hd Query String</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hd Query String</em>' attribute.
     * @see #setHdQueryString(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getReadableComponent_HdQueryString()
     * @model
     * @generated
     */
    String getHdQueryString ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdQueryString <em>Hd Query String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hd Query String</em>' attribute.
     * @see #getHdQueryString()
     * @generated
     */
    void setHdQueryString ( String value );

} // ReadableComponent
