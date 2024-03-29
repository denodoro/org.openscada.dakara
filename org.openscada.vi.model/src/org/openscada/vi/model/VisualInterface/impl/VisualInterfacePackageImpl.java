/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.openscada.vi.model.VisualInterface.Alignment;
import org.openscada.vi.model.VisualInterface.Arc;
import org.openscada.vi.model.VisualInterface.BorderChild;
import org.openscada.vi.model.VisualInterface.BorderContainer;
import org.openscada.vi.model.VisualInterface.Child;
import org.openscada.vi.model.VisualInterface.Connection;
import org.openscada.vi.model.VisualInterface.Cursor;
import org.openscada.vi.model.VisualInterface.Dimension;
import org.openscada.vi.model.VisualInterface.Ellipse;
import org.openscada.vi.model.VisualInterface.Figure;
import org.openscada.vi.model.VisualInterface.FigureContainer;
import org.openscada.vi.model.VisualInterface.GridAlignment;
import org.openscada.vi.model.VisualInterface.GridChild;
import org.openscada.vi.model.VisualInterface.GridContainer;
import org.openscada.vi.model.VisualInterface.Image;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Orientation;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.model.VisualInterface.Shape;
import org.openscada.vi.model.VisualInterface.Symbol;
import org.openscada.vi.model.VisualInterface.SymbolReference;
import org.openscada.vi.model.VisualInterface.SystemCursor;
import org.openscada.vi.model.VisualInterface.SystemCursorType;
import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;
import org.openscada.vi.model.VisualInterface.XYChild;
import org.openscada.vi.model.VisualInterface.XYContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualInterfacePackageImpl extends EPackageImpl implements VisualInterfacePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass symbolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass containerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass shapeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rectangleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass childEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass xyChildEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass xyContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass positionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass lineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass figureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass symbolReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringToStringMapEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dimensionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cursorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass systemCursorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass gridContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass borderContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass borderChildEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass gridChildEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass figureContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass imageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass ellipseEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass arcEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum alignmentEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum orientationEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum systemCursorTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum gridAlignmentEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private VisualInterfacePackageImpl()
    {
        super(eNS_URI, VisualInterfaceFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link VisualInterfacePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static VisualInterfacePackage init()
    {
        if (isInited) return (VisualInterfacePackage)EPackage.Registry.INSTANCE.getEPackage(VisualInterfacePackage.eNS_URI);

        // Obtain or create and register package
        VisualInterfacePackageImpl theVisualInterfacePackage = (VisualInterfacePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VisualInterfacePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VisualInterfacePackageImpl());

        isInited = true;

        // Create package meta-data objects
        theVisualInterfacePackage.createPackageContents();

        // Initialize created meta-data
        theVisualInterfacePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theVisualInterfacePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(VisualInterfacePackage.eNS_URI, theVisualInterfacePackage);
        return theVisualInterfacePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSymbol()
    {
        return symbolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSymbol_Root()
    {
        return (EReference)symbolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSymbol_Properties()
    {
        return (EReference)symbolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbol_OnInit()
    {
        return (EAttribute)symbolEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbol_OnDispose()
    {
        return (EAttribute)symbolEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbol_OnUpdate()
    {
        return (EAttribute)symbolEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbol_ScriptModules()
    {
        return (EAttribute)symbolEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSymbol_Cursors()
    {
        return (EReference)symbolEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbol_BackgroundColor()
    {
        return (EAttribute)symbolEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSymbol_DesignSize()
    {
        return (EReference)symbolEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSymbol_Connections()
    {
        return (EReference)symbolEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPrimitive()
    {
        return primitiveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPrimitive_Name()
    {
        return (EAttribute)primitiveEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getContainer()
    {
        return containerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getShape()
    {
        return shapeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getShape_LineWidth()
    {
        return (EAttribute)shapeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getShape_Antialias()
    {
        return (EAttribute)shapeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getShape_Alpha()
    {
        return (EAttribute)shapeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getShape_Fill()
    {
        return (EAttribute)shapeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getShape_Outline()
    {
        return (EAttribute)shapeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRectangle()
    {
        return rectangleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getText()
    {
        return textEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_Text()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_LabelAlignment()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_TextAlignment()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_TextPlacement()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_FontName()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_FontSize()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_FontBold()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_FontItalic()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getText_IconAlignment()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getChild()
    {
        return childEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChild_Element()
    {
        return (EReference)childEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChild_Name()
    {
        return (EAttribute)childEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getXYChild()
    {
        return xyChildEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getXYChild_Position()
    {
        return (EReference)xyChildEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getXYChild_Dimension()
    {
        return (EReference)xyChildEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getXYContainer()
    {
        return xyContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getXYContainer_Children()
    {
        return (EReference)xyContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPosition()
    {
        return positionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPosition_X()
    {
        return (EAttribute)positionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPosition_Y()
    {
        return (EAttribute)positionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLine()
    {
        return lineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLine_Points()
    {
        return (EReference)lineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFigure()
    {
        return figureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigure_ForegroundColor()
    {
        return (EAttribute)figureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigure_BackgroundColor()
    {
        return (EAttribute)figureEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFigure_Size()
    {
        return (EReference)figureEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigure_OnClick()
    {
        return (EAttribute)figureEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigure_OnDoubleClick()
    {
        return (EAttribute)figureEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFigure_Cursor()
    {
        return (EReference)figureEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigure_Visible()
    {
        return (EAttribute)figureEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigure_Border()
    {
        return (EAttribute)figureEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFigure_Opaque()
    {
        return (EAttribute)figureEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSymbolReference()
    {
        return symbolReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbolReference_Uri()
    {
        return (EAttribute)symbolReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbolReference_Zoom()
    {
        return (EAttribute)symbolReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSymbolReference_Properties()
    {
        return (EReference)symbolReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSymbolReference_OnCreateProperties()
    {
        return (EAttribute)symbolReferenceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringToStringMap()
    {
        return stringToStringMapEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStringToStringMap_Key()
    {
        return (EAttribute)stringToStringMapEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStringToStringMap_Value()
    {
        return (EAttribute)stringToStringMapEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDimension()
    {
        return dimensionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDimension_Width()
    {
        return (EAttribute)dimensionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDimension_Height()
    {
        return (EAttribute)dimensionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCursor()
    {
        return cursorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSystemCursor()
    {
        return systemCursorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSystemCursor_Type()
    {
        return (EAttribute)systemCursorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGridContainer()
    {
        return gridContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridContainer_Columns()
    {
        return (EAttribute)gridContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridContainer_EqualWidth()
    {
        return (EAttribute)gridContainerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGridContainer_Children()
    {
        return (EReference)gridContainerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBorderContainer()
    {
        return borderContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBorderContainer_Children()
    {
        return (EReference)borderContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBorderContainer_VerticalSpacing()
    {
        return (EAttribute)borderContainerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBorderContainer_HorizontalSpacing()
    {
        return (EAttribute)borderContainerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBorderChild()
    {
        return borderChildEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBorderChild_Alignment()
    {
        return (EAttribute)borderChildEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGridChild()
    {
        return gridChildEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridChild_HorizontalAlignment()
    {
        return (EAttribute)gridChildEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridChild_VerticalAlignment()
    {
        return (EAttribute)gridChildEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridChild_GrabHorizontalSpace()
    {
        return (EAttribute)gridChildEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridChild_GrabVerticalSpace()
    {
        return (EAttribute)gridChildEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridChild_SpanCols()
    {
        return (EAttribute)gridChildEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGridChild_SpanRows()
    {
        return (EAttribute)gridChildEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFigureContainer()
    {
        return figureContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFigureContainer_Content()
    {
        return (EReference)figureContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImage()
    {
        return imageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getImage_Uri()
    {
        return (EAttribute)imageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEllipse()
    {
        return ellipseEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getArc()
    {
        return arcEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getArc_Start()
    {
        return (EAttribute)arcEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getArc_Length()
    {
        return (EAttribute)arcEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnection()
    {
        return connectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnection_Start()
    {
        return (EReference)connectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnection_End()
    {
        return (EReference)connectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getAlignment()
    {
        return alignmentEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getOrientation()
    {
        return orientationEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getSystemCursorType()
    {
        return systemCursorTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getGridAlignment()
    {
        return gridAlignmentEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfaceFactory getVisualInterfaceFactory()
    {
        return (VisualInterfaceFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents()
    {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        symbolEClass = createEClass(SYMBOL);
        createEReference(symbolEClass, SYMBOL__ROOT);
        createEReference(symbolEClass, SYMBOL__PROPERTIES);
        createEAttribute(symbolEClass, SYMBOL__ON_INIT);
        createEAttribute(symbolEClass, SYMBOL__ON_DISPOSE);
        createEAttribute(symbolEClass, SYMBOL__ON_UPDATE);
        createEAttribute(symbolEClass, SYMBOL__SCRIPT_MODULES);
        createEReference(symbolEClass, SYMBOL__CURSORS);
        createEAttribute(symbolEClass, SYMBOL__BACKGROUND_COLOR);
        createEReference(symbolEClass, SYMBOL__DESIGN_SIZE);
        createEReference(symbolEClass, SYMBOL__CONNECTIONS);

        primitiveEClass = createEClass(PRIMITIVE);
        createEAttribute(primitiveEClass, PRIMITIVE__NAME);

        containerEClass = createEClass(CONTAINER);

        shapeEClass = createEClass(SHAPE);
        createEAttribute(shapeEClass, SHAPE__LINE_WIDTH);
        createEAttribute(shapeEClass, SHAPE__ANTIALIAS);
        createEAttribute(shapeEClass, SHAPE__ALPHA);
        createEAttribute(shapeEClass, SHAPE__FILL);
        createEAttribute(shapeEClass, SHAPE__OUTLINE);

        rectangleEClass = createEClass(RECTANGLE);

        textEClass = createEClass(TEXT);
        createEAttribute(textEClass, TEXT__TEXT);
        createEAttribute(textEClass, TEXT__LABEL_ALIGNMENT);
        createEAttribute(textEClass, TEXT__ICON_ALIGNMENT);
        createEAttribute(textEClass, TEXT__TEXT_ALIGNMENT);
        createEAttribute(textEClass, TEXT__TEXT_PLACEMENT);
        createEAttribute(textEClass, TEXT__FONT_NAME);
        createEAttribute(textEClass, TEXT__FONT_SIZE);
        createEAttribute(textEClass, TEXT__FONT_BOLD);
        createEAttribute(textEClass, TEXT__FONT_ITALIC);

        childEClass = createEClass(CHILD);
        createEReference(childEClass, CHILD__ELEMENT);
        createEAttribute(childEClass, CHILD__NAME);

        xyChildEClass = createEClass(XY_CHILD);
        createEReference(xyChildEClass, XY_CHILD__POSITION);
        createEReference(xyChildEClass, XY_CHILD__DIMENSION);

        xyContainerEClass = createEClass(XY_CONTAINER);
        createEReference(xyContainerEClass, XY_CONTAINER__CHILDREN);

        positionEClass = createEClass(POSITION);
        createEAttribute(positionEClass, POSITION__X);
        createEAttribute(positionEClass, POSITION__Y);

        lineEClass = createEClass(LINE);
        createEReference(lineEClass, LINE__POINTS);

        figureEClass = createEClass(FIGURE);
        createEAttribute(figureEClass, FIGURE__FOREGROUND_COLOR);
        createEAttribute(figureEClass, FIGURE__BACKGROUND_COLOR);
        createEReference(figureEClass, FIGURE__SIZE);
        createEAttribute(figureEClass, FIGURE__ON_CLICK);
        createEAttribute(figureEClass, FIGURE__ON_DOUBLE_CLICK);
        createEReference(figureEClass, FIGURE__CURSOR);
        createEAttribute(figureEClass, FIGURE__VISIBLE);
        createEAttribute(figureEClass, FIGURE__BORDER);
        createEAttribute(figureEClass, FIGURE__OPAQUE);

        symbolReferenceEClass = createEClass(SYMBOL_REFERENCE);
        createEAttribute(symbolReferenceEClass, SYMBOL_REFERENCE__URI);
        createEAttribute(symbolReferenceEClass, SYMBOL_REFERENCE__ZOOM);
        createEReference(symbolReferenceEClass, SYMBOL_REFERENCE__PROPERTIES);
        createEAttribute(symbolReferenceEClass, SYMBOL_REFERENCE__ON_CREATE_PROPERTIES);

        stringToStringMapEClass = createEClass(STRING_TO_STRING_MAP);
        createEAttribute(stringToStringMapEClass, STRING_TO_STRING_MAP__KEY);
        createEAttribute(stringToStringMapEClass, STRING_TO_STRING_MAP__VALUE);

        dimensionEClass = createEClass(DIMENSION);
        createEAttribute(dimensionEClass, DIMENSION__WIDTH);
        createEAttribute(dimensionEClass, DIMENSION__HEIGHT);

        cursorEClass = createEClass(CURSOR);

        systemCursorEClass = createEClass(SYSTEM_CURSOR);
        createEAttribute(systemCursorEClass, SYSTEM_CURSOR__TYPE);

        gridContainerEClass = createEClass(GRID_CONTAINER);
        createEAttribute(gridContainerEClass, GRID_CONTAINER__COLUMNS);
        createEAttribute(gridContainerEClass, GRID_CONTAINER__EQUAL_WIDTH);
        createEReference(gridContainerEClass, GRID_CONTAINER__CHILDREN);

        borderContainerEClass = createEClass(BORDER_CONTAINER);
        createEReference(borderContainerEClass, BORDER_CONTAINER__CHILDREN);
        createEAttribute(borderContainerEClass, BORDER_CONTAINER__VERTICAL_SPACING);
        createEAttribute(borderContainerEClass, BORDER_CONTAINER__HORIZONTAL_SPACING);

        borderChildEClass = createEClass(BORDER_CHILD);
        createEAttribute(borderChildEClass, BORDER_CHILD__ALIGNMENT);

        gridChildEClass = createEClass(GRID_CHILD);
        createEAttribute(gridChildEClass, GRID_CHILD__HORIZONTAL_ALIGNMENT);
        createEAttribute(gridChildEClass, GRID_CHILD__VERTICAL_ALIGNMENT);
        createEAttribute(gridChildEClass, GRID_CHILD__GRAB_HORIZONTAL_SPACE);
        createEAttribute(gridChildEClass, GRID_CHILD__GRAB_VERTICAL_SPACE);
        createEAttribute(gridChildEClass, GRID_CHILD__SPAN_COLS);
        createEAttribute(gridChildEClass, GRID_CHILD__SPAN_ROWS);

        figureContainerEClass = createEClass(FIGURE_CONTAINER);
        createEReference(figureContainerEClass, FIGURE_CONTAINER__CONTENT);

        imageEClass = createEClass(IMAGE);
        createEAttribute(imageEClass, IMAGE__URI);

        ellipseEClass = createEClass(ELLIPSE);

        arcEClass = createEClass(ARC);
        createEAttribute(arcEClass, ARC__START);
        createEAttribute(arcEClass, ARC__LENGTH);

        connectionEClass = createEClass(CONNECTION);
        createEReference(connectionEClass, CONNECTION__START);
        createEReference(connectionEClass, CONNECTION__END);

        // Create enums
        alignmentEEnum = createEEnum(ALIGNMENT);
        orientationEEnum = createEEnum(ORIENTATION);
        systemCursorTypeEEnum = createEEnum(SYSTEM_CURSOR_TYPE);
        gridAlignmentEEnum = createEEnum(GRID_ALIGNMENT);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents()
    {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        containerEClass.getESuperTypes().add(this.getPrimitive());
        shapeEClass.getESuperTypes().add(this.getFigure());
        rectangleEClass.getESuperTypes().add(this.getShape());
        textEClass.getESuperTypes().add(this.getFigure());
        xyChildEClass.getESuperTypes().add(this.getChild());
        xyContainerEClass.getESuperTypes().add(this.getContainer());
        lineEClass.getESuperTypes().add(this.getShape());
        figureEClass.getESuperTypes().add(this.getPrimitive());
        symbolReferenceEClass.getESuperTypes().add(this.getPrimitive());
        systemCursorEClass.getESuperTypes().add(this.getCursor());
        gridContainerEClass.getESuperTypes().add(this.getContainer());
        borderContainerEClass.getESuperTypes().add(this.getContainer());
        borderChildEClass.getESuperTypes().add(this.getChild());
        gridChildEClass.getESuperTypes().add(this.getChild());
        figureContainerEClass.getESuperTypes().add(this.getFigure());
        imageEClass.getESuperTypes().add(this.getFigure());
        ellipseEClass.getESuperTypes().add(this.getShape());
        arcEClass.getESuperTypes().add(this.getShape());

        // Initialize classes and features; add operations and parameters
        initEClass(symbolEClass, Symbol.class, "Symbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSymbol_Root(), this.getPrimitive(), null, "root", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSymbol_Properties(), this.getStringToStringMap(), null, "properties", null, 0, -1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSymbol_OnInit(), ecorePackage.getEString(), "onInit", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSymbol_OnDispose(), ecorePackage.getEString(), "onDispose", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSymbol_OnUpdate(), ecorePackage.getEString(), "onUpdate", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSymbol_ScriptModules(), ecorePackage.getEString(), "scriptModules", null, 0, -1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSymbol_Cursors(), this.getCursor(), null, "cursors", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSymbol_BackgroundColor(), ecorePackage.getEString(), "backgroundColor", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSymbol_DesignSize(), this.getDimension(), null, "designSize", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSymbol_Connections(), this.getConnection(), null, "connections", null, 0, -1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(primitiveEClass, Primitive.class, "Primitive", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPrimitive_Name(), ecorePackage.getEString(), "name", null, 0, 1, Primitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(containerEClass, org.openscada.vi.model.VisualInterface.Container.class, "Container", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(shapeEClass, Shape.class, "Shape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getShape_LineWidth(), ecorePackage.getEFloat(), "lineWidth", "1", 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getShape_Antialias(), ecorePackage.getEBooleanObject(), "antialias", null, 0, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getShape_Alpha(), ecorePackage.getEDoubleObject(), "alpha", null, 0, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getShape_Fill(), ecorePackage.getEBoolean(), "fill", "true", 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getShape_Outline(), ecorePackage.getEBoolean(), "outline", "true", 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(rectangleEClass, Rectangle.class, "Rectangle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getText_Text(), ecorePackage.getEString(), "text", null, 1, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getText_LabelAlignment(), this.getAlignment(), "labelAlignment", "CENTER", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getText_IconAlignment(), this.getAlignment(), "iconAlignment", "CENTER", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getText_TextAlignment(), this.getAlignment(), "textAlignment", "CENTER", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getText_TextPlacement(), this.getOrientation(), "textPlacement", "EAST", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getText_FontName(), ecorePackage.getEString(), "fontName", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getText_FontSize(), ecorePackage.getEInt(), "fontSize", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getText_FontBold(), ecorePackage.getEBoolean(), "fontBold", "false", 1, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getText_FontItalic(), ecorePackage.getEBoolean(), "fontItalic", "false", 1, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(childEClass, Child.class, "Child", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getChild_Element(), this.getPrimitive(), null, "element", null, 0, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getChild_Name(), ecorePackage.getEString(), "name", null, 0, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(xyChildEClass, XYChild.class, "XYChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getXYChild_Position(), this.getPosition(), null, "position", null, 1, 1, XYChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getXYChild_Dimension(), this.getDimension(), null, "dimension", null, 0, 1, XYChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(xyContainerEClass, XYContainer.class, "XYContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getXYContainer_Children(), this.getXYChild(), null, "children", null, 0, -1, XYContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(positionEClass, Position.class, "Position", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPosition_X(), ecorePackage.getEDouble(), "x", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPosition_Y(), ecorePackage.getEDouble(), "y", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getLine_Points(), this.getPosition(), null, "points", null, 0, -1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(figureEClass, Figure.class, "Figure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getFigure_ForegroundColor(), ecorePackage.getEString(), "foregroundColor", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFigure_BackgroundColor(), ecorePackage.getEString(), "backgroundColor", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getFigure_Size(), this.getDimension(), null, "size", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFigure_OnClick(), ecorePackage.getEString(), "onClick", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFigure_OnDoubleClick(), ecorePackage.getEString(), "onDoubleClick", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getFigure_Cursor(), this.getCursor(), null, "cursor", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFigure_Visible(), ecorePackage.getEBoolean(), "visible", "true", 1, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getFigure_Border(), ecorePackage.getEString(), "border", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getFigure_Opaque(), ecorePackage.getEBooleanObject(), "opaque", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(symbolReferenceEClass, SymbolReference.class, "SymbolReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSymbolReference_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSymbolReference_Zoom(), ecorePackage.getEDoubleObject(), "zoom", null, 0, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSymbolReference_Properties(), this.getStringToStringMap(), null, "properties", null, 0, -1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSymbolReference_OnCreateProperties(), ecorePackage.getEString(), "onCreateProperties", null, 0, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(stringToStringMapEClass, Map.Entry.class, "StringToStringMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getStringToStringMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getStringToStringMap_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDimension_Width(), ecorePackage.getEDouble(), "width", "0", 1, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDimension_Height(), ecorePackage.getEDouble(), "height", "0", 1, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(cursorEClass, Cursor.class, "Cursor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(systemCursorEClass, SystemCursor.class, "SystemCursor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSystemCursor_Type(), this.getSystemCursorType(), "type", null, 1, 1, SystemCursor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(gridContainerEClass, GridContainer.class, "GridContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGridContainer_Columns(), ecorePackage.getEInt(), "columns", "1", 0, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGridContainer_EqualWidth(), ecorePackage.getEBoolean(), "equalWidth", "false", 0, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getGridContainer_Children(), this.getGridChild(), null, "children", null, 0, -1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(borderContainerEClass, BorderContainer.class, "BorderContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getBorderContainer_Children(), this.getBorderChild(), null, "children", null, 0, -1, BorderContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getBorderContainer_VerticalSpacing(), ecorePackage.getEInt(), "verticalSpacing", "0", 1, 1, BorderContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getBorderContainer_HorizontalSpacing(), ecorePackage.getEInt(), "horizontalSpacing", "0", 1, 1, BorderContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(borderChildEClass, BorderChild.class, "BorderChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getBorderChild_Alignment(), this.getAlignment(), "alignment", "CENTER", 1, 1, BorderChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(gridChildEClass, GridChild.class, "GridChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGridChild_HorizontalAlignment(), this.getGridAlignment(), "horizontalAlignment", "BEGINNING", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGridChild_VerticalAlignment(), this.getGridAlignment(), "verticalAlignment", "BEGINNING", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGridChild_GrabHorizontalSpace(), ecorePackage.getEBoolean(), "grabHorizontalSpace", "false", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGridChild_GrabVerticalSpace(), ecorePackage.getEBoolean(), "grabVerticalSpace", "false", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGridChild_SpanCols(), ecorePackage.getEInt(), "spanCols", "0", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getGridChild_SpanRows(), ecorePackage.getEInt(), "spanRows", "0", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(figureContainerEClass, FigureContainer.class, "FigureContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getFigureContainer_Content(), this.getPrimitive(), null, "content", null, 0, 1, FigureContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getImage_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(ellipseEClass, Ellipse.class, "Ellipse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(arcEClass, Arc.class, "Arc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getArc_Start(), ecorePackage.getEInt(), "start", null, 1, 1, Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getArc_Length(), ecorePackage.getEInt(), "length", null, 1, 1, Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getConnection_Start(), this.getPrimitive(), null, "start", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getConnection_End(), this.getPrimitive(), null, "end", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        getConnection_End().getEKeys().add(this.getPrimitive_Name());

        // Initialize enums and add enum literals
        initEEnum(alignmentEEnum, Alignment.class, "Alignment"); //$NON-NLS-1$
        addEEnumLiteral(alignmentEEnum, Alignment.LEFT);
        addEEnumLiteral(alignmentEEnum, Alignment.CENTER);
        addEEnumLiteral(alignmentEEnum, Alignment.RIGHT);
        addEEnumLiteral(alignmentEEnum, Alignment.TOP);
        addEEnumLiteral(alignmentEEnum, Alignment.BOTTOM);

        initEEnum(orientationEEnum, Orientation.class, "Orientation"); //$NON-NLS-1$
        addEEnumLiteral(orientationEEnum, Orientation.NORTH);
        addEEnumLiteral(orientationEEnum, Orientation.SOUTH);
        addEEnumLiteral(orientationEEnum, Orientation.EAST);
        addEEnumLiteral(orientationEEnum, Orientation.WEST);

        initEEnum(systemCursorTypeEEnum, SystemCursorType.class, "SystemCursorType"); //$NON-NLS-1$
        addEEnumLiteral(systemCursorTypeEEnum, SystemCursorType.ARROW);
        addEEnumLiteral(systemCursorTypeEEnum, SystemCursorType.HAND);

        initEEnum(gridAlignmentEEnum, GridAlignment.class, "GridAlignment"); //$NON-NLS-1$
        addEEnumLiteral(gridAlignmentEEnum, GridAlignment.CENTER);
        addEEnumLiteral(gridAlignmentEEnum, GridAlignment.FILL);
        addEEnumLiteral(gridAlignmentEEnum, GridAlignment.BEGINNING);
        addEEnumLiteral(gridAlignmentEEnum, GridAlignment.END);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
        addAnnotation
          (getChild_Element(), 
           source, 
           new String[] 
           {
             "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
             "name", "element" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getXYChild_Position(), 
           source, 
           new String[] 
           {
             "kind", "element" //$NON-NLS-1$ //$NON-NLS-2$
           });	
    }

} //VisualInterfacePackageImpl
