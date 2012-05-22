/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Writeable Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.WriteableComponent#getCeil <em>Ceil</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.WriteableComponent#getFloor <em>Floor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getWriteableComponent()
 * @model abstract="true"
 * @generated
 */
public interface WriteableComponent extends ReadableComponent
{
    /**
     * Returns the value of the '<em><b>Ceil</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ceil</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ceil</em>' attribute.
     * @see #setCeil(Double)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getWriteableComponent_Ceil()
     * @model
     * @generated
     */
    Double getCeil ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.WriteableComponent#getCeil <em>Ceil</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ceil</em>' attribute.
     * @see #getCeil()
     * @generated
     */
    void setCeil ( Double value );

    /**
     * Returns the value of the '<em><b>Floor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Floor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Floor</em>' attribute.
     * @see #setFloor(double)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getWriteableComponent_Floor()
     * @model
     * @generated
     */
    double getFloor ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.WriteableComponent#getFloor <em>Floor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Floor</em>' attribute.
     * @see #getFloor()
     * @generated
     */
    void setFloor ( double value );

} // WriteableComponent
