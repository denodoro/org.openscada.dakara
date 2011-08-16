/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.openscada.vi.model.VisualInterface.Child;
import org.openscada.vi.model.VisualInterface.Line;
import org.openscada.vi.model.VisualInterface.Position;
import org.openscada.vi.model.VisualInterface.Primitive;
import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.model.VisualInterface.Shape;
import org.openscada.vi.model.VisualInterface.Symbol;
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
    public EClass getPrimitive()
    {
        return primitiveEClass;
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
    public EAttribute getShape_Width()
    {
        return (EAttribute)shapeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getShape_Height()
    {
        return (EAttribute)shapeEClass.getEStructuralFeatures().get(1);
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
    public EAttribute getText_Format()
    {
        return (EAttribute)textEClass.getEStructuralFeatures().get(0);
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

        primitiveEClass = createEClass(PRIMITIVE);

        containerEClass = createEClass(CONTAINER);

        shapeEClass = createEClass(SHAPE);
        createEAttribute(shapeEClass, SHAPE__WIDTH);
        createEAttribute(shapeEClass, SHAPE__HEIGHT);

        rectangleEClass = createEClass(RECTANGLE);

        textEClass = createEClass(TEXT);
        createEAttribute(textEClass, TEXT__FORMAT);

        childEClass = createEClass(CHILD);
        createEReference(childEClass, CHILD__ELEMENT);
        createEAttribute(childEClass, CHILD__NAME);

        xyChildEClass = createEClass(XY_CHILD);
        createEReference(xyChildEClass, XY_CHILD__POSITION);

        xyContainerEClass = createEClass(XY_CONTAINER);
        createEReference(xyContainerEClass, XY_CONTAINER__CHILDREN);

        positionEClass = createEClass(POSITION);
        createEAttribute(positionEClass, POSITION__X);
        createEAttribute(positionEClass, POSITION__Y);

        lineEClass = createEClass(LINE);
        createEReference(lineEClass, LINE__POINTS);
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
        shapeEClass.getESuperTypes().add(this.getPrimitive());
        rectangleEClass.getESuperTypes().add(this.getShape());
        textEClass.getESuperTypes().add(this.getPrimitive());
        xyChildEClass.getESuperTypes().add(this.getChild());
        xyContainerEClass.getESuperTypes().add(this.getContainer());
        lineEClass.getESuperTypes().add(this.getPrimitive());

        // Initialize classes and features; add operations and parameters
        initEClass(symbolEClass, Symbol.class, "Symbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSymbol_Root(), this.getPrimitive(), null, "root", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(primitiveEClass, Primitive.class, "Primitive", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(containerEClass, org.openscada.vi.model.VisualInterface.Container.class, "Container", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(shapeEClass, Shape.class, "Shape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getShape_Width(), ecorePackage.getEDouble(), "width", null, 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getShape_Height(), ecorePackage.getEDouble(), "height", null, 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(rectangleEClass, Rectangle.class, "Rectangle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getText_Format(), ecorePackage.getEString(), "format", null, 1, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(childEClass, Child.class, "Child", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getChild_Element(), this.getPrimitive(), null, "element", null, 0, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getChild_Name(), ecorePackage.getEString(), "name", null, 0, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(xyChildEClass, XYChild.class, "XYChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getXYChild_Position(), this.getPosition(), null, "position", null, 1, 1, XYChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(xyContainerEClass, XYContainer.class, "XYContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getXYContainer_Children(), this.getXYChild(), null, "children", null, 0, -1, XYContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(positionEClass, Position.class, "Position", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPosition_X(), ecorePackage.getEDouble(), "x", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPosition_Y(), ecorePackage.getEDouble(), "y", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLine_Points(), this.getPosition(), null, "points", null, 0, -1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
        addAnnotation
          (getChild_Element(), 
           source, 
           new String[] 
           {
             "kind", "element",
             "name", "element"
           });		
        addAnnotation
          (getXYChild_Position(), 
           source, 
           new String[] 
           {
             "kind", "element"
           });
    }

} //VisualInterfacePackageImpl
