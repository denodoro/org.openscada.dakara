/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.LinkComponent#getFormat <em>Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getLinkComponent()
 * @model
 * @generated
 */
public interface LinkComponent extends Component
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
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getLinkComponent_Format()
     * @model
     * @generated
     */
    String getFormat ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.LinkComponent#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat ( String value );

} // LinkComponent
