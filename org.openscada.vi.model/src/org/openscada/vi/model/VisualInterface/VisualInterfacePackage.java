/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.openscada.vi.model.VisualInterface.VisualInterfaceFactory
 * @model kind="package"
 * @generated
 */
public interface VisualInterfacePackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "VisualInterface";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "urn:openscada:visualInterface";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "visualInterface";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    VisualInterfacePackage eINSTANCE = org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl.init();

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.SymbolImpl <em>Symbol</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.SymbolImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSymbol()
     * @generated
     */
    int SYMBOL = 0;

    /**
     * The feature id for the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ROOT = 0;

    /**
     * The number of structural features of the '<em>Symbol</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.Primitive <em>Primitive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.Primitive
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getPrimitive()
     * @generated
     */
    int PRIMITIVE = 1;

    /**
     * The number of structural features of the '<em>Primitive</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.Container <em>Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.Container
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getContainer()
     * @generated
     */
    int CONTAINER = 2;

    /**
     * The number of structural features of the '<em>Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.ShapeImpl <em>Shape</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.ShapeImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getShape()
     * @generated
     */
    int SHAPE = 3;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__WIDTH = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__HEIGHT = PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.RectangleImpl <em>Rectangle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.RectangleImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getRectangle()
     * @generated
     */
    int RECTANGLE = 4;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__WIDTH = SHAPE__WIDTH;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__HEIGHT = SHAPE__HEIGHT;

    /**
     * The number of structural features of the '<em>Rectangle</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.TextImpl <em>Text</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.TextImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getText()
     * @generated
     */
    int TEXT = 5;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FORMAT = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Text</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.ChildImpl <em>Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.ChildImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getChild()
     * @generated
     */
    int CHILD = 6;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHILD__ELEMENT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHILD__NAME = 1;

    /**
     * The number of structural features of the '<em>Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHILD_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.XYChildImpl <em>XY Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.XYChildImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getXYChild()
     * @generated
     */
    int XY_CHILD = 7;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__ELEMENT = CHILD__ELEMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__NAME = CHILD__NAME;

    /**
     * The feature id for the '<em><b>Position</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__POSITION = CHILD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>XY Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD_FEATURE_COUNT = CHILD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.XYContainerImpl <em>XY Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.XYContainerImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getXYContainer()
     * @generated
     */
    int XY_CONTAINER = 8;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CONTAINER__CHILDREN = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>XY Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.PositionImpl <em>Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.PositionImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getPosition()
     * @generated
     */
    int POSITION = 9;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSITION__X = 0;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSITION__Y = 1;

    /**
     * The number of structural features of the '<em>Position</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSITION_FEATURE_COUNT = 2;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.LineImpl <em>Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.LineImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getLine()
     * @generated
     */
    int LINE = 10;

    /**
     * The feature id for the '<em><b>Points</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__POINTS = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Line</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Symbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Symbol</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol
     * @generated
     */
    EClass getSymbol();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.Symbol#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getRoot()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Root();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Primitive <em>Primitive</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive</em>'.
     * @see org.openscada.vi.model.VisualInterface.Primitive
     * @generated
     */
    EClass getPrimitive();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Container <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Container</em>'.
     * @see org.openscada.vi.model.VisualInterface.Container
     * @generated
     */
    EClass getContainer();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Shape <em>Shape</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Shape</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape
     * @generated
     */
    EClass getShape();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Shape#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape#getWidth()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Width();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Shape#getHeight <em>Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape#getHeight()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Height();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Rectangle <em>Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rectangle</em>'.
     * @see org.openscada.vi.model.VisualInterface.Rectangle
     * @generated
     */
    EClass getRectangle();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Text <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text
     * @generated
     */
    EClass getText();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getFormat()
     * @see #getText()
     * @generated
     */
    EAttribute getText_Format();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Child <em>Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Child</em>'.
     * @see org.openscada.vi.model.VisualInterface.Child
     * @generated
     */
    EClass getChild();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.Child#getElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Element</em>'.
     * @see org.openscada.vi.model.VisualInterface.Child#getElement()
     * @see #getChild()
     * @generated
     */
    EReference getChild_Element();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Child#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.openscada.vi.model.VisualInterface.Child#getName()
     * @see #getChild()
     * @generated
     */
    EAttribute getChild_Name();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.XYChild <em>XY Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XY Child</em>'.
     * @see org.openscada.vi.model.VisualInterface.XYChild
     * @generated
     */
    EClass getXYChild();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.XYChild#getPosition <em>Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Position</em>'.
     * @see org.openscada.vi.model.VisualInterface.XYChild#getPosition()
     * @see #getXYChild()
     * @generated
     */
    EReference getXYChild_Position();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.XYContainer <em>XY Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XY Container</em>'.
     * @see org.openscada.vi.model.VisualInterface.XYContainer
     * @generated
     */
    EClass getXYContainer();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.model.VisualInterface.XYContainer#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.openscada.vi.model.VisualInterface.XYContainer#getChildren()
     * @see #getXYContainer()
     * @generated
     */
    EReference getXYContainer_Children();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Position <em>Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Position</em>'.
     * @see org.openscada.vi.model.VisualInterface.Position
     * @generated
     */
    EClass getPosition();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Position#getX <em>X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>X</em>'.
     * @see org.openscada.vi.model.VisualInterface.Position#getX()
     * @see #getPosition()
     * @generated
     */
    EAttribute getPosition_X();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Position#getY <em>Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Y</em>'.
     * @see org.openscada.vi.model.VisualInterface.Position#getY()
     * @see #getPosition()
     * @generated
     */
    EAttribute getPosition_Y();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Line <em>Line</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Line</em>'.
     * @see org.openscada.vi.model.VisualInterface.Line
     * @generated
     */
    EClass getLine();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.model.VisualInterface.Line#getPoints <em>Points</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Points</em>'.
     * @see org.openscada.vi.model.VisualInterface.Line#getPoints()
     * @see #getLine()
     * @generated
     */
    EReference getLine_Points();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    VisualInterfaceFactory getVisualInterfaceFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.SymbolImpl <em>Symbol</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.SymbolImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSymbol()
         * @generated
         */
        EClass SYMBOL = eINSTANCE.getSymbol();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__ROOT = eINSTANCE.getSymbol_Root();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.Primitive <em>Primitive</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.Primitive
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getPrimitive()
         * @generated
         */
        EClass PRIMITIVE = eINSTANCE.getPrimitive();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.Container <em>Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.Container
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getContainer()
         * @generated
         */
        EClass CONTAINER = eINSTANCE.getContainer();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.ShapeImpl <em>Shape</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.ShapeImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getShape()
         * @generated
         */
        EClass SHAPE = eINSTANCE.getShape();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__WIDTH = eINSTANCE.getShape_Width();

        /**
         * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__HEIGHT = eINSTANCE.getShape_Height();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.RectangleImpl <em>Rectangle</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.RectangleImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getRectangle()
         * @generated
         */
        EClass RECTANGLE = eINSTANCE.getRectangle();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.TextImpl <em>Text</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.TextImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getText()
         * @generated
         */
        EClass TEXT = eINSTANCE.getText();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FORMAT = eINSTANCE.getText_Format();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.ChildImpl <em>Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.ChildImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getChild()
         * @generated
         */
        EClass CHILD = eINSTANCE.getChild();

        /**
         * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHILD__ELEMENT = eINSTANCE.getChild_Element();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHILD__NAME = eINSTANCE.getChild_Name();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.XYChildImpl <em>XY Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.XYChildImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getXYChild()
         * @generated
         */
        EClass XY_CHILD = eINSTANCE.getXYChild();

        /**
         * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference XY_CHILD__POSITION = eINSTANCE.getXYChild_Position();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.XYContainerImpl <em>XY Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.XYContainerImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getXYContainer()
         * @generated
         */
        EClass XY_CONTAINER = eINSTANCE.getXYContainer();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference XY_CONTAINER__CHILDREN = eINSTANCE.getXYContainer_Children();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.PositionImpl <em>Position</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.PositionImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getPosition()
         * @generated
         */
        EClass POSITION = eINSTANCE.getPosition();

        /**
         * The meta object literal for the '<em><b>X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSITION__X = eINSTANCE.getPosition_X();

        /**
         * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSITION__Y = eINSTANCE.getPosition_Y();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.LineImpl <em>Line</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.LineImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getLine()
         * @generated
         */
        EClass LINE = eINSTANCE.getLine();

        /**
         * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINE__POINTS = eINSTANCE.getLine_Points();

    }

} //VisualInterfacePackage
