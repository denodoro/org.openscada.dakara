/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Grid Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent#isEqually <em>Equally</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent#getCols <em>Cols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getSimpleGridComponent()
 * @model
 * @generated
 */
public interface SimpleGridComponent extends CompositeComponent
{
    /**
     * Returns the value of the '<em><b>Equally</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equally</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equally</em>' attribute.
     * @see #setEqually(boolean)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getSimpleGridComponent_Equally()
     * @model default="true"
     * @generated
     */
    boolean isEqually();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent#isEqually <em>Equally</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Equally</em>' attribute.
     * @see #isEqually()
     * @generated
     */
    void setEqually(boolean value);

    /**
     * Returns the value of the '<em><b>Cols</b></em>' attribute.
     * The default value is <code>"2"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cols</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cols</em>' attribute.
     * @see #setCols(int)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getSimpleGridComponent_Cols()
     * @model default="2"
     * @generated
     */
    int getCols();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent#getCols <em>Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cols</em>' attribute.
     * @see #getCols()
     * @generated
     */
    void setCols(int value);

} // SimpleGridComponent
