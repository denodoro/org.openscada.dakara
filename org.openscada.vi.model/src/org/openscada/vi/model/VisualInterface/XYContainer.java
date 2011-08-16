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
 * A representation of the model object '<em><b>XY Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.XYContainer#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getXYContainer()
 * @model
 * @generated
 */
public interface XYContainer extends Container
{
    /**
     * Returns the value of the '<em><b>Children</b></em>' containment reference list.
     * The list contents are of type {@link org.openscada.vi.model.VisualInterface.XYChild}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' containment reference list.
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getXYContainer_Children()
     * @model containment="true"
     * @generated
     */
    EList<XYChild> getChildren();

} // XYContainer
