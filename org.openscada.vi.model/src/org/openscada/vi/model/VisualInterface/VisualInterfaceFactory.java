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
     * Returns a new object of class '<em>Symbol Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Symbol Reference</em>'.
     * @generated
     */
    SymbolReference createSymbolReference();

    /**
     * Returns a new object of class '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Dimension</em>'.
     * @generated
     */
    Dimension createDimension();

    /**
     * Returns a new object of class '<em>System Cursor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>System Cursor</em>'.
     * @generated
     */
    SystemCursor createSystemCursor();

    /**
     * Returns a new object of class '<em>Grid Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Grid Container</em>'.
     * @generated
     */
    GridContainer createGridContainer();

    /**
     * Returns a new object of class '<em>Border Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Border Container</em>'.
     * @generated
     */
    BorderContainer createBorderContainer();

    /**
     * Returns a new object of class '<em>Border Child</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Border Child</em>'.
     * @generated
     */
    BorderChild createBorderChild();

    /**
     * Returns a new object of class '<em>Grid Child</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Grid Child</em>'.
     * @generated
     */
    GridChild createGridChild();

    /**
     * Returns a new object of class '<em>Figure Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Figure Container</em>'.
     * @generated
     */
    FigureContainer createFigureContainer();

    /**
     * Returns a new object of class '<em>Image</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Image</em>'.
     * @generated
     */
    Image createImage();

    /**
     * Returns a new object of class '<em>Ellipse</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ellipse</em>'.
     * @generated
     */
    Ellipse createEllipse();

    /**
     * Returns a new object of class '<em>Arc</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Arc</em>'.
     * @generated
     */
    Arc createArc();

    /**
     * Returns a new object of class '<em>Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Connection</em>'.
     * @generated
     */
    Connection createConnection();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    VisualInterfacePackage getVisualInterfacePackage();

} //VisualInterfaceFactory
