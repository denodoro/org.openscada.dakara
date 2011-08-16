/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage
 * @generated
 */
public interface VisualInterfaceFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    VisualInterfaceFactory eINSTANCE = org.openscada.vi.model.VisualInterface.impl.VisualInterfaceFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Symbol</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Symbol</em>'.
     * @generated
     */
    Symbol createSymbol();

    /**
     * Returns a new object of class '<em>Rectangle</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Rectangle</em>'.
     * @generated
     */
    Rectangle createRectangle();

    /**
     * Returns a new object of class '<em>Text</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Text</em>'.
     * @generated
     */
    Text createText();

    /**
     * Returns a new object of class '<em>Child</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Child</em>'.
     * @generated
     */
    Child createChild();

    /**
     * Returns a new object of class '<em>XY Child</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>XY Child</em>'.
     * @generated
     */
    XYChild createXYChild();

    /**
     * Returns a new object of class '<em>XY Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>XY Container</em>'.
     * @generated
     */
    XYContainer createXYContainer();

    /**
     * Returns a new object of class '<em>Position</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Position</em>'.
     * @generated
     */
    Position createPosition();

    /**
     * Returns a new object of class '<em>Line</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Line</em>'.
     * @generated
     */
    Line createLine();

    /**
     * Returns a new object of class '<em>Figure</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Figure</em>'.
     * @generated
     */
    Figure createFigure();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    VisualInterfacePackage getVisualInterfacePackage();

} //VisualInterfaceFactory
