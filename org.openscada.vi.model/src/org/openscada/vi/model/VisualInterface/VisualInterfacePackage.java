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
     * The feature id for the '<em><b>Cursors</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__CURSORS = 6;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__BACKGROUND_COLOR = 7;

    /**
     * The feature id for the '<em><b>Design Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__DESIGN_SIZE = 8;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__CONNECTIONS = 9;

    /**
     * The number of structural features of the '<em>Symbol</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_FEATURE_COUNT = 10;

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
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__SIZE = PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_CLICK = PRIMITIVE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_DOUBLE_CLICK = PRIMITIVE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__CURSOR = PRIMITIVE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__VISIBLE = PRIMITIVE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__BORDER = PRIMITIVE_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__OPAQUE = PRIMITIVE_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Figure</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 9;

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
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__OPAQUE = FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__LINE_WIDTH = FIGURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ANTIALIAS = FIGURE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ALPHA = FIGURE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__FILL = FIGURE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__OUTLINE = FIGURE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 5;

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
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__OUTLINE = SHAPE__OUTLINE;

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
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__OPAQUE = FIGURE__OPAQUE;

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
     * The feature id for the '<em><b>Font Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_NAME = FIGURE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Font Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_SIZE = FIGURE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Font Bold</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_BOLD = FIGURE_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Font Italic</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_ITALIC = FIGURE_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Text</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 9;

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
    int LINE__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__OUTLINE = SHAPE__OUTLINE;

    /**
     * The feature id for the '<em><b>Points</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__POINTS = SHAPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Line</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 1;


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
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.CursorImpl <em>Cursor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.CursorImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getCursor()
     * @generated
     */
    int CURSOR = 15;

    /**
     * The number of structural features of the '<em>Cursor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURSOR_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.SystemCursorImpl <em>System Cursor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.SystemCursorImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSystemCursor()
     * @generated
     */
    int SYSTEM_CURSOR = 16;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_CURSOR__TYPE = CURSOR_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>System Cursor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_CURSOR_FEATURE_COUNT = CURSOR_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.GridContainerImpl <em>Grid Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.GridContainerImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getGridContainer()
     * @generated
     */
    int GRID_CONTAINER = 17;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Columns</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__COLUMNS = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Equal Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__EQUAL_WIDTH = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__CHILDREN = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Grid Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.BorderContainerImpl <em>Border Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.BorderContainerImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getBorderContainer()
     * @generated
     */
    int BORDER_CONTAINER = 18;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__CHILDREN = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Vertical Spacing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__VERTICAL_SPACING = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Horizontal Spacing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__HORIZONTAL_SPACING = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Border Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.BorderChildImpl <em>Border Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.BorderChildImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getBorderChild()
     * @generated
     */
    int BORDER_CHILD = 19;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD__ELEMENT = CHILD__ELEMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD__NAME = CHILD__NAME;

    /**
     * The feature id for the '<em><b>Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD__ALIGNMENT = CHILD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Border Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD_FEATURE_COUNT = CHILD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.GridChildImpl <em>Grid Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.GridChildImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getGridChild()
     * @generated
     */
    int GRID_CHILD = 20;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__ELEMENT = CHILD__ELEMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__NAME = CHILD__NAME;

    /**
     * The feature id for the '<em><b>Horizontal Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__HORIZONTAL_ALIGNMENT = CHILD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Vertical Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__VERTICAL_ALIGNMENT = CHILD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Grab Horizontal Space</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__GRAB_HORIZONTAL_SPACE = CHILD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Grab Vertical Space</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__GRAB_VERTICAL_SPACE = CHILD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Span Cols</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__SPAN_COLS = CHILD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Span Rows</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__SPAN_ROWS = CHILD_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Grid Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD_FEATURE_COUNT = CHILD_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.FigureContainerImpl <em>Figure Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.FigureContainerImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getFigureContainer()
     * @generated
     */
    int FIGURE_CONTAINER = 21;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__OPAQUE = FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Content</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__CONTENT = FIGURE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Figure Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.ImageImpl <em>Image</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.ImageImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getImage()
     * @generated
     */
    int IMAGE = 22;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__OPAQUE = FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__URI = FIGURE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Image</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.EllipseImpl <em>Ellipse</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.EllipseImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getEllipse()
     * @generated
     */
    int ELLIPSE = 23;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__OUTLINE = SHAPE__OUTLINE;

    /**
     * The number of structural features of the '<em>Ellipse</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.ArcImpl <em>Arc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.ArcImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getArc()
     * @generated
     */
    int ARC = 24;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__OUTLINE = SHAPE__OUTLINE;

    /**
     * The feature id for the '<em><b>Start</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__START = SHAPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__LENGTH = SHAPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.impl.ConnectionImpl <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.impl.ConnectionImpl
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getConnection()
     * @generated
     */
    int CONNECTION = 25;

    /**
     * The feature id for the '<em><b>Start</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__START = 0;

    /**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__END = 1;

    /**
     * The number of structural features of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.Alignment <em>Alignment</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.Alignment
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getAlignment()
     * @generated
     */
    int ALIGNMENT = 26;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.Orientation <em>Orientation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.Orientation
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getOrientation()
     * @generated
     */
    int ORIENTATION = 27;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.SystemCursorType <em>System Cursor Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.SystemCursorType
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSystemCursorType()
     * @generated
     */
    int SYSTEM_CURSOR_TYPE = 28;


    /**
     * The meta object id for the '{@link org.openscada.vi.model.VisualInterface.GridAlignment <em>Grid Alignment</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.model.VisualInterface.GridAlignment
     * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getGridAlignment()
     * @generated
     */
    int GRID_ALIGNMENT = 29;


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
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.Symbol#getCursors <em>Cursors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Cursors</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getCursors()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Cursors();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Symbol#getBackgroundColor <em>Background Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Color</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getBackgroundColor()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_BackgroundColor();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.Symbol#getDesignSize <em>Design Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Design Size</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getDesignSize()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_DesignSize();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.model.VisualInterface.Symbol#getConnections <em>Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connections</em>'.
     * @see org.openscada.vi.model.VisualInterface.Symbol#getConnections()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Connections();

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
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Shape#getLineWidth <em>Line Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Line Width</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape#getLineWidth()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_LineWidth();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Shape#getAntialias <em>Antialias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Antialias</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape#getAntialias()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Antialias();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Shape#getAlpha <em>Alpha</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Alpha</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape#getAlpha()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Alpha();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Shape#isFill <em>Fill</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Fill</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape#isFill()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Fill();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Shape#isOutline <em>Outline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Outline</em>'.
     * @see org.openscada.vi.model.VisualInterface.Shape#isOutline()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Outline();

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
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getFontName <em>Font Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Name</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getFontName()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontName();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#getFontSize <em>Font Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Size</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#getFontSize()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontSize();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#isFontBold <em>Font Bold</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Bold</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#isFontBold()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontBold();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Text#isFontItalic <em>Font Italic</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Italic</em>'.
     * @see org.openscada.vi.model.VisualInterface.Text#isFontItalic()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontItalic();

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
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.Figure#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Size</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getSize()
     * @see #getFigure()
     * @generated
     */
    EReference getFigure_Size();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Figure#getOnClick <em>On Click</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Click</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getOnClick()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnClick();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Figure#getOnDoubleClick <em>On Double Click</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Double Click</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getOnDoubleClick()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnDoubleClick();

    /**
     * Returns the meta object for the reference '{@link org.openscada.vi.model.VisualInterface.Figure#getCursor <em>Cursor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Cursor</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getCursor()
     * @see #getFigure()
     * @generated
     */
    EReference getFigure_Cursor();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Figure#isVisible <em>Visible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visible</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#isVisible()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_Visible();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Figure#getBorder <em>Border</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Border</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getBorder()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_Border();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Figure#getOpaque <em>Opaque</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Opaque</em>'.
     * @see org.openscada.vi.model.VisualInterface.Figure#getOpaque()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_Opaque();

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
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Cursor <em>Cursor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cursor</em>'.
     * @see org.openscada.vi.model.VisualInterface.Cursor
     * @generated
     */
    EClass getCursor();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.SystemCursor <em>System Cursor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>System Cursor</em>'.
     * @see org.openscada.vi.model.VisualInterface.SystemCursor
     * @generated
     */
    EClass getSystemCursor();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.SystemCursor#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.openscada.vi.model.VisualInterface.SystemCursor#getType()
     * @see #getSystemCursor()
     * @generated
     */
    EAttribute getSystemCursor_Type();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.GridContainer <em>Grid Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Grid Container</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridContainer
     * @generated
     */
    EClass getGridContainer();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridContainer#getColumns <em>Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Columns</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridContainer#getColumns()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_Columns();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridContainer#isEqualWidth <em>Equal Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Equal Width</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridContainer#isEqualWidth()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_EqualWidth();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.model.VisualInterface.GridContainer#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridContainer#getChildren()
     * @see #getGridContainer()
     * @generated
     */
    EReference getGridContainer_Children();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.BorderContainer <em>Border Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Border Container</em>'.
     * @see org.openscada.vi.model.VisualInterface.BorderContainer
     * @generated
     */
    EClass getBorderContainer();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.model.VisualInterface.BorderContainer#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.openscada.vi.model.VisualInterface.BorderContainer#getChildren()
     * @see #getBorderContainer()
     * @generated
     */
    EReference getBorderContainer_Children();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.BorderContainer#getVerticalSpacing <em>Vertical Spacing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Vertical Spacing</em>'.
     * @see org.openscada.vi.model.VisualInterface.BorderContainer#getVerticalSpacing()
     * @see #getBorderContainer()
     * @generated
     */
    EAttribute getBorderContainer_VerticalSpacing();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.BorderContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Horizontal Spacing</em>'.
     * @see org.openscada.vi.model.VisualInterface.BorderContainer#getHorizontalSpacing()
     * @see #getBorderContainer()
     * @generated
     */
    EAttribute getBorderContainer_HorizontalSpacing();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.BorderChild <em>Border Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Border Child</em>'.
     * @see org.openscada.vi.model.VisualInterface.BorderChild
     * @generated
     */
    EClass getBorderChild();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.BorderChild#getAlignment <em>Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.BorderChild#getAlignment()
     * @see #getBorderChild()
     * @generated
     */
    EAttribute getBorderChild_Alignment();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.GridChild <em>Grid Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Grid Child</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridChild
     * @generated
     */
    EClass getGridChild();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridChild#getHorizontalAlignment <em>Horizontal Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Horizontal Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridChild#getHorizontalAlignment()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_HorizontalAlignment();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridChild#getVerticalAlignment <em>Vertical Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Vertical Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridChild#getVerticalAlignment()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_VerticalAlignment();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridChild#isGrabHorizontalSpace <em>Grab Horizontal Space</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Grab Horizontal Space</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridChild#isGrabHorizontalSpace()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_GrabHorizontalSpace();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridChild#isGrabVerticalSpace <em>Grab Vertical Space</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Grab Vertical Space</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridChild#isGrabVerticalSpace()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_GrabVerticalSpace();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridChild#getSpanCols <em>Span Cols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Span Cols</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridChild#getSpanCols()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_SpanCols();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.GridChild#getSpanRows <em>Span Rows</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Span Rows</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridChild#getSpanRows()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_SpanRows();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.FigureContainer <em>Figure Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Figure Container</em>'.
     * @see org.openscada.vi.model.VisualInterface.FigureContainer
     * @generated
     */
    EClass getFigureContainer();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.model.VisualInterface.FigureContainer#getContent <em>Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Content</em>'.
     * @see org.openscada.vi.model.VisualInterface.FigureContainer#getContent()
     * @see #getFigureContainer()
     * @generated
     */
    EReference getFigureContainer_Content();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Image <em>Image</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Image</em>'.
     * @see org.openscada.vi.model.VisualInterface.Image
     * @generated
     */
    EClass getImage();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Image#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.openscada.vi.model.VisualInterface.Image#getUri()
     * @see #getImage()
     * @generated
     */
    EAttribute getImage_Uri();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Ellipse <em>Ellipse</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ellipse</em>'.
     * @see org.openscada.vi.model.VisualInterface.Ellipse
     * @generated
     */
    EClass getEllipse();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Arc <em>Arc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Arc</em>'.
     * @see org.openscada.vi.model.VisualInterface.Arc
     * @generated
     */
    EClass getArc();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Arc#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Start</em>'.
     * @see org.openscada.vi.model.VisualInterface.Arc#getStart()
     * @see #getArc()
     * @generated
     */
    EAttribute getArc_Start();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.model.VisualInterface.Arc#getLength <em>Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Length</em>'.
     * @see org.openscada.vi.model.VisualInterface.Arc#getLength()
     * @see #getArc()
     * @generated
     */
    EAttribute getArc_Length();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.model.VisualInterface.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connection</em>'.
     * @see org.openscada.vi.model.VisualInterface.Connection
     * @generated
     */
    EClass getConnection();

    /**
     * Returns the meta object for the reference '{@link org.openscada.vi.model.VisualInterface.Connection#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Start</em>'.
     * @see org.openscada.vi.model.VisualInterface.Connection#getStart()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_Start();

    /**
     * Returns the meta object for the reference '{@link org.openscada.vi.model.VisualInterface.Connection#getEnd <em>End</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>End</em>'.
     * @see org.openscada.vi.model.VisualInterface.Connection#getEnd()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_End();

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
     * Returns the meta object for enum '{@link org.openscada.vi.model.VisualInterface.SystemCursorType <em>System Cursor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>System Cursor Type</em>'.
     * @see org.openscada.vi.model.VisualInterface.SystemCursorType
     * @generated
     */
    EEnum getSystemCursorType();

    /**
     * Returns the meta object for enum '{@link org.openscada.vi.model.VisualInterface.GridAlignment <em>Grid Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Grid Alignment</em>'.
     * @see org.openscada.vi.model.VisualInterface.GridAlignment
     * @generated
     */
    EEnum getGridAlignment();

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
         * The meta object literal for the '<em><b>Cursors</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__CURSORS = eINSTANCE.getSymbol_Cursors();

        /**
         * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__BACKGROUND_COLOR = eINSTANCE.getSymbol_BackgroundColor();

        /**
         * The meta object literal for the '<em><b>Design Size</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__DESIGN_SIZE = eINSTANCE.getSymbol_DesignSize();

        /**
         * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__CONNECTIONS = eINSTANCE.getSymbol_Connections();

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
         * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__LINE_WIDTH = eINSTANCE.getShape_LineWidth();

        /**
         * The meta object literal for the '<em><b>Antialias</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__ANTIALIAS = eINSTANCE.getShape_Antialias();

        /**
         * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__ALPHA = eINSTANCE.getShape_Alpha();

        /**
         * The meta object literal for the '<em><b>Fill</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__FILL = eINSTANCE.getShape_Fill();

        /**
         * The meta object literal for the '<em><b>Outline</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__OUTLINE = eINSTANCE.getShape_Outline();

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
         * The meta object literal for the '<em><b>Font Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_NAME = eINSTANCE.getText_FontName();

        /**
         * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_SIZE = eINSTANCE.getText_FontSize();

        /**
         * The meta object literal for the '<em><b>Font Bold</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_BOLD = eINSTANCE.getText_FontBold();

        /**
         * The meta object literal for the '<em><b>Font Italic</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_ITALIC = eINSTANCE.getText_FontItalic();

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
         * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGURE__SIZE = eINSTANCE.getFigure_Size();

        /**
         * The meta object literal for the '<em><b>On Click</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_CLICK = eINSTANCE.getFigure_OnClick();

        /**
         * The meta object literal for the '<em><b>On Double Click</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_DOUBLE_CLICK = eINSTANCE.getFigure_OnDoubleClick();

        /**
         * The meta object literal for the '<em><b>Cursor</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGURE__CURSOR = eINSTANCE.getFigure_Cursor();

        /**
         * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__VISIBLE = eINSTANCE.getFigure_Visible();

        /**
         * The meta object literal for the '<em><b>Border</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__BORDER = eINSTANCE.getFigure_Border();

        /**
         * The meta object literal for the '<em><b>Opaque</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__OPAQUE = eINSTANCE.getFigure_Opaque();

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
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.CursorImpl <em>Cursor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.CursorImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getCursor()
         * @generated
         */
        EClass CURSOR = eINSTANCE.getCursor();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.SystemCursorImpl <em>System Cursor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.SystemCursorImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSystemCursor()
         * @generated
         */
        EClass SYSTEM_CURSOR = eINSTANCE.getSystemCursor();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYSTEM_CURSOR__TYPE = eINSTANCE.getSystemCursor_Type();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.GridContainerImpl <em>Grid Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.GridContainerImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getGridContainer()
         * @generated
         */
        EClass GRID_CONTAINER = eINSTANCE.getGridContainer();

        /**
         * The meta object literal for the '<em><b>Columns</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__COLUMNS = eINSTANCE.getGridContainer_Columns();

        /**
         * The meta object literal for the '<em><b>Equal Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__EQUAL_WIDTH = eINSTANCE.getGridContainer_EqualWidth();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GRID_CONTAINER__CHILDREN = eINSTANCE.getGridContainer_Children();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.BorderContainerImpl <em>Border Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.BorderContainerImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getBorderContainer()
         * @generated
         */
        EClass BORDER_CONTAINER = eINSTANCE.getBorderContainer();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BORDER_CONTAINER__CHILDREN = eINSTANCE.getBorderContainer_Children();

        /**
         * The meta object literal for the '<em><b>Vertical Spacing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BORDER_CONTAINER__VERTICAL_SPACING = eINSTANCE.getBorderContainer_VerticalSpacing();

        /**
         * The meta object literal for the '<em><b>Horizontal Spacing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BORDER_CONTAINER__HORIZONTAL_SPACING = eINSTANCE.getBorderContainer_HorizontalSpacing();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.BorderChildImpl <em>Border Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.BorderChildImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getBorderChild()
         * @generated
         */
        EClass BORDER_CHILD = eINSTANCE.getBorderChild();

        /**
         * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BORDER_CHILD__ALIGNMENT = eINSTANCE.getBorderChild_Alignment();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.GridChildImpl <em>Grid Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.GridChildImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getGridChild()
         * @generated
         */
        EClass GRID_CHILD = eINSTANCE.getGridChild();

        /**
         * The meta object literal for the '<em><b>Horizontal Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__HORIZONTAL_ALIGNMENT = eINSTANCE.getGridChild_HorizontalAlignment();

        /**
         * The meta object literal for the '<em><b>Vertical Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__VERTICAL_ALIGNMENT = eINSTANCE.getGridChild_VerticalAlignment();

        /**
         * The meta object literal for the '<em><b>Grab Horizontal Space</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__GRAB_HORIZONTAL_SPACE = eINSTANCE.getGridChild_GrabHorizontalSpace();

        /**
         * The meta object literal for the '<em><b>Grab Vertical Space</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__GRAB_VERTICAL_SPACE = eINSTANCE.getGridChild_GrabVerticalSpace();

        /**
         * The meta object literal for the '<em><b>Span Cols</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__SPAN_COLS = eINSTANCE.getGridChild_SpanCols();

        /**
         * The meta object literal for the '<em><b>Span Rows</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__SPAN_ROWS = eINSTANCE.getGridChild_SpanRows();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.FigureContainerImpl <em>Figure Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.FigureContainerImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getFigureContainer()
         * @generated
         */
        EClass FIGURE_CONTAINER = eINSTANCE.getFigureContainer();

        /**
         * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGURE_CONTAINER__CONTENT = eINSTANCE.getFigureContainer_Content();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.ImageImpl <em>Image</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.ImageImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getImage()
         * @generated
         */
        EClass IMAGE = eINSTANCE.getImage();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE__URI = eINSTANCE.getImage_Uri();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.EllipseImpl <em>Ellipse</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.EllipseImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getEllipse()
         * @generated
         */
        EClass ELLIPSE = eINSTANCE.getEllipse();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.ArcImpl <em>Arc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.ArcImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getArc()
         * @generated
         */
        EClass ARC = eINSTANCE.getArc();

        /**
         * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARC__START = eINSTANCE.getArc_Start();

        /**
         * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARC__LENGTH = eINSTANCE.getArc_Length();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.impl.ConnectionImpl <em>Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.impl.ConnectionImpl
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getConnection()
         * @generated
         */
        EClass CONNECTION = eINSTANCE.getConnection();

        /**
         * The meta object literal for the '<em><b>Start</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__START = eINSTANCE.getConnection_Start();

        /**
         * The meta object literal for the '<em><b>End</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__END = eINSTANCE.getConnection_End();

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

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.SystemCursorType <em>System Cursor Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.SystemCursorType
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getSystemCursorType()
         * @generated
         */
        EEnum SYSTEM_CURSOR_TYPE = eINSTANCE.getSystemCursorType();

        /**
         * The meta object literal for the '{@link org.openscada.vi.model.VisualInterface.GridAlignment <em>Grid Alignment</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.model.VisualInterface.GridAlignment
         * @see org.openscada.vi.model.VisualInterface.impl.VisualInterfacePackageImpl#getGridAlignment()
         * @generated
         */
        EEnum GRID_ALIGNMENT = eINSTANCE.getGridAlignment();

    }

} //VisualInterfacePackage
