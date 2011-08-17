/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.openscada.vi.model.VisualInterface.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage
 * @generated
 */
public class VisualInterfaceSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static VisualInterfacePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfaceSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = VisualInterfacePackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage)
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case VisualInterfacePackage.SYMBOL:
            {
                Symbol symbol = (Symbol)theEObject;
                T result = caseSymbol(symbol);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.PRIMITIVE:
            {
                Primitive primitive = (Primitive)theEObject;
                T result = casePrimitive(primitive);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.CONTAINER:
            {
                Container container = (Container)theEObject;
                T result = caseContainer(container);
                if (result == null) result = casePrimitive(container);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.SHAPE:
            {
                Shape shape = (Shape)theEObject;
                T result = caseShape(shape);
                if (result == null) result = caseFigure(shape);
                if (result == null) result = casePrimitive(shape);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.RECTANGLE:
            {
                Rectangle rectangle = (Rectangle)theEObject;
                T result = caseRectangle(rectangle);
                if (result == null) result = caseShape(rectangle);
                if (result == null) result = caseFigure(rectangle);
                if (result == null) result = casePrimitive(rectangle);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.TEXT:
            {
                Text text = (Text)theEObject;
                T result = caseText(text);
                if (result == null) result = caseFigure(text);
                if (result == null) result = casePrimitive(text);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.CHILD:
            {
                Child child = (Child)theEObject;
                T result = caseChild(child);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.XY_CHILD:
            {
                XYChild xyChild = (XYChild)theEObject;
                T result = caseXYChild(xyChild);
                if (result == null) result = caseChild(xyChild);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.XY_CONTAINER:
            {
                XYContainer xyContainer = (XYContainer)theEObject;
                T result = caseXYContainer(xyContainer);
                if (result == null) result = caseContainer(xyContainer);
                if (result == null) result = casePrimitive(xyContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.POSITION:
            {
                Position position = (Position)theEObject;
                T result = casePosition(position);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.LINE:
            {
                Line line = (Line)theEObject;
                T result = caseLine(line);
                if (result == null) result = caseFigure(line);
                if (result == null) result = casePrimitive(line);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.FIGURE:
            {
                Figure figure = (Figure)theEObject;
                T result = caseFigure(figure);
                if (result == null) result = casePrimitive(figure);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.SYMBOL_REFERENCE:
            {
                SymbolReference symbolReference = (SymbolReference)theEObject;
                T result = caseSymbolReference(symbolReference);
                if (result == null) result = casePrimitive(symbolReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.STRING_TO_STRING_MAP:
            {
                @SuppressWarnings("unchecked") Map.Entry<String, String> stringToStringMap = (Map.Entry<String, String>)theEObject;
                T result = caseStringToStringMap(stringToStringMap);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case VisualInterfacePackage.DIMENSION:
            {
                Dimension dimension = (Dimension)theEObject;
                T result = caseDimension(dimension);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Symbol</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Symbol</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSymbol(Symbol object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitive(Primitive object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseContainer(Container object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Shape</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Shape</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseShape(Shape object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Rectangle</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rectangle</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRectangle(Rectangle object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseText(Text object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Child</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Child</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChild(Child object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XY Child</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XY Child</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXYChild(XYChild object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XY Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XY Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXYContainer(XYContainer object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Position</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Position</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePosition(Position object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Line</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Line</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLine(Line object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Figure</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Figure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFigure(Figure object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Symbol Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Symbol Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSymbolReference(SymbolReference object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String To String Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String To String Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringToStringMap(Map.Entry<String, String> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDimension(Dimension object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object)
    {
        return null;
    }

} //VisualInterfaceSwitch
