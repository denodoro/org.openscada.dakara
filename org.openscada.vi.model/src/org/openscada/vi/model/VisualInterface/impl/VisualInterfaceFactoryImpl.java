/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.openscada.vi.model.VisualInterface.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualInterfaceFactoryImpl extends EFactoryImpl implements VisualInterfaceFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static VisualInterfaceFactory init()
    {
        try
        {
            VisualInterfaceFactory theVisualInterfaceFactory = (VisualInterfaceFactory)EPackage.Registry.INSTANCE.getEFactory("urn:openscada:visualInterface"); 
            if (theVisualInterfaceFactory != null)
            {
                return theVisualInterfaceFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new VisualInterfaceFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfaceFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case VisualInterfacePackage.SYMBOL: return createSymbol();
            case VisualInterfacePackage.RECTANGLE: return createRectangle();
            case VisualInterfacePackage.TEXT: return createText();
            case VisualInterfacePackage.CHILD: return createChild();
            case VisualInterfacePackage.XY_CHILD: return createXYChild();
            case VisualInterfacePackage.XY_CONTAINER: return createXYContainer();
            case VisualInterfacePackage.POSITION: return createPosition();
            case VisualInterfacePackage.LINE: return createLine();
            case VisualInterfacePackage.FIGURE: return createFigure();
            case VisualInterfacePackage.SYMBOL_REFERENCE: return createSymbolReference();
            case VisualInterfacePackage.STRING_TO_STRING_MAP: return (EObject)createStringToStringMap();
            case VisualInterfacePackage.DIMENSION: return createDimension();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue)
    {
        switch (eDataType.getClassifierID())
        {
            case VisualInterfacePackage.ALIGNMENT:
                return createAlignmentFromString(eDataType, initialValue);
            case VisualInterfacePackage.ORIENTATION:
                return createOrientationFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue)
    {
        switch (eDataType.getClassifierID())
        {
            case VisualInterfacePackage.ALIGNMENT:
                return convertAlignmentToString(eDataType, instanceValue);
            case VisualInterfacePackage.ORIENTATION:
                return convertOrientationToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Symbol createSymbol()
    {
        SymbolImpl symbol = new SymbolImpl();
        return symbol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Rectangle createRectangle()
    {
        RectangleImpl rectangle = new RectangleImpl();
        return rectangle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Text createText()
    {
        TextImpl text = new TextImpl();
        return text;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Child createChild()
    {
        ChildImpl child = new ChildImpl();
        return child;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XYChild createXYChild()
    {
        XYChildImpl xyChild = new XYChildImpl();
        return xyChild;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XYContainer createXYContainer()
    {
        XYContainerImpl xyContainer = new XYContainerImpl();
        return xyContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Position createPosition()
    {
        PositionImpl position = new PositionImpl();
        return position;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Line createLine()
    {
        LineImpl line = new LineImpl();
        return line;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Figure createFigure()
    {
        FigureImpl figure = new FigureImpl();
        return figure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SymbolReference createSymbolReference()
    {
        SymbolReferenceImpl symbolReference = new SymbolReferenceImpl();
        return symbolReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map.Entry<String, String> createStringToStringMap()
    {
        StringToStringMapImpl stringToStringMap = new StringToStringMapImpl();
        return stringToStringMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Dimension createDimension()
    {
        DimensionImpl dimension = new DimensionImpl();
        return dimension;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment createAlignmentFromString(EDataType eDataType, String initialValue)
    {
        Alignment result = Alignment.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertAlignmentToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Orientation createOrientationFromString(EDataType eDataType, String initialValue)
    {
        Orientation result = Orientation.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertOrientationToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfacePackage getVisualInterfacePackage()
    {
        return (VisualInterfacePackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static VisualInterfacePackage getPackage()
    {
        return VisualInterfacePackage.eINSTANCE;
    }

} //VisualInterfaceFactoryImpl
