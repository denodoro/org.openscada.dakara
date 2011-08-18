/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
     * The feature id for the '<em><b>Properties</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__PROPERTIES = 1;

    /**
     * The feature id for the '<em><b>On Init</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ON_INIT = 2;

    /**
     * The feature id for the '<em><b>On Dispose</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ON_DISPOSE = 3;

    /**
     * The feature id for the '<em><b>On Update</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ON_UPDATE = 4;

    /**
     * The feature id for the '<em><b>Script Modules</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__SCRIPT_MODULES = 5;

    /**
     * The number of structural features of the '<em>Symbol</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_FEATURE_COUNT = 6;

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
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE__NAME = 0;

    /**
     * The number of structural features of the '<em>Primitive</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.FigureImpl <em>Figure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.FigureImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getFigure()
     * @generated
     */
    int FIGURE = 11;

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
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__NAME = PRIMITIVE__NAME;

    /**
     * The number of structural features of the '<em>Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__NAME = PRIMITIVE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__FOREGROUND_COLOR = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__BACKGROUND_COLOR = PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Size</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__SIZE = PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Figure</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 3;

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
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__WIDTH = FIGURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__HEIGHT = FIGURE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 2;

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
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__SIZE = SHAPE__SIZE;

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
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__TEXT = FIGURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Label Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__LABEL_ALIGNMENT = FIGURE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Icon Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ICON_ALIGNMENT = FIGURE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Text Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__TEXT_ALIGNMENT = FIGURE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Text Placement</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__TEXT_PLACEMENT = FIGURE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Text</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 5;

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
     * The number of structural features of the '<em>Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHILD_FEATURE_COUNT = 1;

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
     * The feature id for the '<em><b>Position</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__POSITION = CHILD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dimension</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__DIMENSION = CHILD_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>XY Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD_FEATURE_COUNT = CHILD_FEATURE_COUNT + 2;

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
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CONTAINER__NAME = CONTAINER__NAME;

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
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>Points</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__POINTS = FIGURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__LINE_WIDTH = FIGURE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Line</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 2;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.SymbolReferenceImpl <em>Symbol Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.SymbolReferenceImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSymbolReference()
     * @generated
     */
    int SYMBOL_REFERENCE = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__NAME = PRIMITIVE__NAME;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__URI = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Zoom</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__ZOOM = PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Properties</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__PROPERTIES = PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>On Create Properties</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__ON_CREATE_PROPERTIES = PRIMITIVE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Symbol Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 4;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.StringToStringMapImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getStringToStringMap()
     * @generated
     */
    int STRING_TO_STRING_MAP = 13;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TO_STRING_MAP__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TO_STRING_MAP__VALUE = 1;

    /**
     * The number of structural features of the '<em>String To String Map</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TO_STRING_MAP_FEATURE_COUNT = 2;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.DimensionImpl <em>Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.DimensionImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getDimension()
     * @generated
     */
    int DIMENSION = 14;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIMENSION__WIDTH = 0;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIMENSION__HEIGHT = 1;

    /**
     * The number of structural features of the '<em>Dimension</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIMENSION_FEATURE_COUNT = 2;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.Alignment <em>Alignment</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getAlignment()
     * @generated
     */
    int ALIGNMENT = 15;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.Orientation <em>Orientation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.Orientation
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getOrientation()
     * @generated
     */
    int ORIENTATION = 16;


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
     * Returns the meta object for the map '{@link org.openscada.vi.model.VisualInterface.Symbol#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Properties</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getProperties()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Properties();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Symbol#getOnInit <em>On Init</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Init</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getOnInit()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_OnInit();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Symbol#getOnDispose <em>On Dispose</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Dispose</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getOnDispose()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_OnDispose();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Symbol#getOnUpdate <em>On Update</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Update</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getOnUpdate()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_OnUpdate();

    /**
     * Returns the meta object for the attribute list '{@link org.openscada.vi.model.VisualInterface.Symbol#getScriptModules <em>Script Modules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Script Modules</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getScriptModules()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_ScriptModules();

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
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Primitive#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.openscada.vi.model.VisualInterface.Primitive#getName()
     * @see #getPrimitive()
     * @generated
     */
    EAttribute getPrimitive_Name();

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
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getText <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getText()
     * @see #getText()
     * @generated
     */
    EAttribute getText_Text();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getLabelAlignment <em>Label Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getLabelAlignment()
     * @see #getText()
     * @generated
     */
    EAttribute getText_LabelAlignment();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getTextAlignment <em>Text Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getTextAlignment()
     * @see #getText()
     * @generated
     */
    EAttribute getText_TextAlignment();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getTextPlacement <em>Text Placement</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Placement</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getTextPlacement()
     * @see #getText()
     * @generated
     */
    EAttribute getText_TextPlacement();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getIconAlignment <em>Icon Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getIconAlignment()
     * @see #getText()
     * @generated
     */
    EAttribute getText_IconAlignment();

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
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.XYChild#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Dimension</em>'.
     * @see org.openscada.vi.model.VisualInterface.XYChild#getDimension()
     * @see #getXYChild()
     * @generated
     */
    EReference getXYChild_Dimension();

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
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Line#getLineWidth <em>Line Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Line Width</em>'.
     * @see org.openscada.vi.model.VisualInterface.Line#getLineWidth()
     * @see #getLine()
     * @generated
     */
    EAttribute getLine_LineWidth();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Figure <em>Figure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Figure</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure
     * @generated
     */
    EClass getFigure();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Figure#getForegroundColor <em>Foreground Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Foreground Color</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getForegroundColor()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_ForegroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Figure#getBackgroundColor <em>Background Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Color</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getBackgroundColor()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_BackgroundColor();

    /**
     * Returns the meta object for the reference '{@link org.openscada.vi.model.VisualInterface.Figure#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Size</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getSize()
     * @see #getFigure()
     * @generated
     */
    EReference getFigure_Size();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.SymbolReference <em>Symbol Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Symbol Reference</em>'.
     * @see org.openscada.vi.model.VisualInterface.SymbolReference
     * @generated
     */
    EClass getSymbolReference();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.SymbolReference#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.openscada.vi.model.VisualInterface.SymbolReference#getUri()
     * @see #getSymbolReference()
     * @generated
     */
    EAttribute getSymbolReference_Uri();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.SymbolReference#getZoom <em>Zoom</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Zoom</em>'.
     * @see org.openscada.vi.model.VisualInterface.SymbolReference#getZoom()
     * @see #getSymbolReference()
     * @generated
     */
    EAttribute getSymbolReference_Zoom();

    /**
     * Returns the meta object for the map '{@link org.openscada.vi.model.VisualInterface.SymbolReference#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Properties</em>'.
     * @see org.openscada.vi.model.VisualInterface.SymbolReference#getProperties()
     * @see #getSymbolReference()
     * @generated
     */
    EReference getSymbolReference_Properties();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.SymbolReference#getOnCreateProperties <em>On Create Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Create Properties</em>'.
     * @see org.openscada.vi.model.VisualInterface.SymbolReference#getOnCreateProperties()
     * @see #getSymbolReference()
     * @generated
     */
    EAttribute getSymbolReference_OnCreateProperties();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>String To String Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String To String Map</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     *        valueDataType="org.eclipse.emf.ecore.EString"
     * @generated
     */
    EClass getStringToStringMap();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getStringToStringMap()
     * @generated
     */
    EAttribute getStringToStringMap_Key();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getStringToStringMap()
     * @generated
     */
    EAttribute getStringToStringMap_Value();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Dimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dimension</em>'.
     * @see org.openscada.vi.model.VisualInterface.Dimension
     * @generated
     */
    EClass getDimension();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Dimension#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.openscada.vi.model.VisualInterface.Dimension#getWidth()
     * @see #getDimension()
     * @generated
     */
    EAttribute getDimension_Width();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Dimension#getHeight <em>Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height</em>'.
     * @see org.openscada.vi.model.VisualInterface.Dimension#getHeight()
     * @see #getDimension()
     * @generated
     */
    EAttribute getDimension_Height();

    /**
     * Returns the meta object for enum '{@link org.openscada.vi.model.VisualInterface.Alignment <em>Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @generated
     */
    EEnum getAlignment();

    /**
     * Returns the meta object for enum '{@link org.openscada.vi.model.VisualInterface.Orientation <em>Orientation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Orientation</em>'.
     * @see org.openscada.vi.model.VisualInterface.Orientation
     * @generated
     */
    EEnum getOrientation();

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
         * The meta object literal for the '<em><b>Properties</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__PROPERTIES = eINSTANCE.getSymbol_Properties();

        /**
         * The meta object literal for the '<em><b>On Init</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__ON_INIT = eINSTANCE.getSymbol_OnInit();

        /**
         * The meta object literal for the '<em><b>On Dispose</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__ON_DISPOSE = eINSTANCE.getSymbol_OnDispose();

        /**
         * The meta object literal for the '<em><b>On Update</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__ON_UPDATE = eINSTANCE.getSymbol_OnUpdate();

        /**
         * The meta object literal for the '<em><b>Script Modules</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__SCRIPT_MODULES = eINSTANCE.getSymbol_ScriptModules();

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
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRIMITIVE__NAME = eINSTANCE.getPrimitive_Name();

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
         * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__TEXT = eINSTANCE.getText_Text();

        /**
         * The meta object literal for the '<em><b>Label Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__LABEL_ALIGNMENT = eINSTANCE.getText_LabelAlignment();

        /**
         * The meta object literal for the '<em><b>Text Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__TEXT_ALIGNMENT = eINSTANCE.getText_TextAlignment();

        /**
         * The meta object literal for the '<em><b>Text Placement</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__TEXT_PLACEMENT = eINSTANCE.getText_TextPlacement();

        /**
         * The meta object literal for the '<em><b>Icon Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__ICON_ALIGNMENT = eINSTANCE.getText_IconAlignment();

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
         * The meta object literal for the '<em><b>Dimension</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference XY_CHILD__DIMENSION = eINSTANCE.getXYChild_Dimension();

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

        /**
         * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINE__LINE_WIDTH = eINSTANCE.getLine_LineWidth();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.FigureImpl <em>Figure</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.FigureImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getFigure()
         * @generated
         */
        EClass FIGURE = eINSTANCE.getFigure();

        /**
         * The meta object literal for the '<em><b>Foreground Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__FOREGROUND_COLOR = eINSTANCE.getFigure_ForegroundColor();

        /**
         * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__BACKGROUND_COLOR = eINSTANCE.getFigure_BackgroundColor();

        /**
         * The meta object literal for the '<em><b>Size</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGURE__SIZE = eINSTANCE.getFigure_Size();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.SymbolReferenceImpl <em>Symbol Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.SymbolReferenceImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSymbolReference()
         * @generated
         */
        EClass SYMBOL_REFERENCE = eINSTANCE.getSymbolReference();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL_REFERENCE__URI = eINSTANCE.getSymbolReference_Uri();

        /**
         * The meta object literal for the '<em><b>Zoom</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL_REFERENCE__ZOOM = eINSTANCE.getSymbolReference_Zoom();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL_REFERENCE__PROPERTIES = eINSTANCE.getSymbolReference_Properties();

        /**
         * The meta object literal for the '<em><b>On Create Properties</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL_REFERENCE__ON_CREATE_PROPERTIES = eINSTANCE.getSymbolReference_OnCreateProperties();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.StringToStringMapImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getStringToStringMap()
         * @generated
         */
        EClass STRING_TO_STRING_MAP = eINSTANCE.getStringToStringMap();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_TO_STRING_MAP__KEY = eINSTANCE.getStringToStringMap_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_TO_STRING_MAP__VALUE = eINSTANCE.getStringToStringMap_Value();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.DimensionImpl <em>Dimension</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.DimensionImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getDimension()
         * @generated
         */
        EClass DIMENSION = eINSTANCE.getDimension();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIMENSION__WIDTH = eINSTANCE.getDimension_Width();

        /**
         * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIMENSION__HEIGHT = eINSTANCE.getDimension_Height();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.Alignment <em>Alignment</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.Alignment
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getAlignment()
         * @generated
         */
        EEnum ALIGNMENT = eINSTANCE.getAlignment();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.Orientation <em>Orientation</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.Orientation
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getOrientation()
         * @generated
         */
        EEnum ORIENTATION = eINSTANCE.getOrientation();

    }

} //VisualInterfacePackage
