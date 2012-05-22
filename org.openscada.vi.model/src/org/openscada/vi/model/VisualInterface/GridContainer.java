/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grid Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridContainer#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridContainer#isEqualWidth <em>Equal Width</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridContainer#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridContainer()
 * @model
 * @generated
 */
public interface GridContainer extends Container
{
    /**
     * Returns the value of the '<em><b>Columns</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Columns</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Columns</em>' attribute.
     * @see #setColumns(int)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridContainer_Columns()
     * @model default="1"
     * @generated
     */
    int getColumns ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridContainer#getColumns <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Columns</em>' attribute.
     * @see #getColumns()
     * @generated
     */
    void setColumns ( int value );

    /**
     * Returns the value of the '<em><b>Equal Width</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equal Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equal Width</em>' attribute.
     * @see #setEqualWidth(boolean)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridContainer_EqualWidth()
     * @model default="false"
     * @generated
     */
    boolean isEqualWidth ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridContainer#isEqualWidth <em>Equal Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Equal Width</em>' attribute.
     * @see #isEqualWidth()
     * @generated
     */
    void setEqualWidth ( boolean value );

    /**
     * Returns the value of the '<em><b>Children</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.vi.model.VisualInterface.GridChild}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' containment reference list.
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridContainer_Children()
     * @model containment="true"
     * @generated
     */
    EList<GridChild> getChildren ();

} // GridContainer
