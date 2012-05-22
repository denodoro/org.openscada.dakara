/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.util;

import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.openscada.vi.model.VisualInterface.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage
 * @generated
 */
public class VisualInterfaceAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static VisualInterfacePackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfaceAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = VisualInterfacePackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VisualInterfaceSwitch<Adapter> modelSwitch = new VisualInterfaceSwitch<Adapter> () {
        @Override
        public Adapter caseSymbol ( Symbol object )
        {
            return createSymbolAdapter ();
        }

        @Override
        public Adapter casePrimitive ( Primitive object )
        {
            return createPrimitiveAdapter ();
        }

        @Override
        public Adapter caseContainer ( Container object )
        {
            return createContainerAdapter ();
        }

        @Override
        public Adapter caseShape ( Shape object )
        {
            return createShapeAdapter ();
        }

        @Override
        public Adapter caseRectangle ( Rectangle object )
        {
            return createRectangleAdapter ();
        }

        @Override
        public Adapter caseText ( Text object )
        {
            return createTextAdapter ();
        }

        @Override
        public Adapter caseChild ( Child object )
        {
            return createChildAdapter ();
        }

        @Override
        public Adapter caseXYChild ( XYChild object )
        {
            return createXYChildAdapter ();
        }

        @Override
        public Adapter caseXYContainer ( XYContainer object )
        {
            return createXYContainerAdapter ();
        }

        @Override
        public Adapter casePosition ( Position object )
        {
            return createPositionAdapter ();
        }

        @Override
        public Adapter caseLine ( Line object )
        {
            return createLineAdapter ();
        }

        @Override
        public Adapter caseFigure ( Figure object )
        {
            return createFigureAdapter ();
        }

        @Override
        public Adapter caseSymbolReference ( SymbolReference object )
        {
            return createSymbolReferenceAdapter ();
        }

        @Override
        public Adapter caseStringToStringMap ( Map.Entry<String, String> object )
        {
            return createStringToStringMapAdapter ();
        }

        @Override
        public Adapter caseDimension ( Dimension object )
        {
            return createDimensionAdapter ();
        }

        @Override
        public Adapter caseCursor ( Cursor object )
        {
            return createCursorAdapter ();
        }

        @Override
        public Adapter caseSystemCursor ( SystemCursor object )
        {
            return createSystemCursorAdapter ();
        }

        @Override
        public Adapter caseGridContainer ( GridContainer object )
        {
            return createGridContainerAdapter ();
        }

        @Override
        public Adapter caseBorderContainer ( BorderContainer object )
        {
            return createBorderContainerAdapter ();
        }

        @Override
        public Adapter caseBorderChild ( BorderChild object )
        {
            return createBorderChildAdapter ();
        }

        @Override
        public Adapter caseGridChild ( GridChild object )
        {
            return createGridChildAdapter ();
        }

        @Override
        public Adapter caseFigureContainer ( FigureContainer object )
        {
            return createFigureContainerAdapter ();
        }

        @Override
        public Adapter caseImage ( Image object )
        {
            return createImageAdapter ();
        }

        @Override
        public Adapter caseEllipse ( Ellipse object )
        {
            return createEllipseAdapter ();
        }

        @Override
        public Adapter caseArc ( Arc object )
        {
            return createArcAdapter ();
        }

        @Override
        public Adapter caseConnection ( Connection object )
        {
            return createConnectionAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Symbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Symbol
     * @generated
     */
    public Adapter createSymbolAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Primitive <em>Primitive</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Primitive
     * @generated
     */
    public Adapter createPrimitiveAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Container <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Container
     * @generated
     */
    public Adapter createContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Shape <em>Shape</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Shape
     * @generated
     */
    public Adapter createShapeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Rectangle <em>Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Rectangle
     * @generated
     */
    public Adapter createRectangleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Text <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Text
     * @generated
     */
    public Adapter createTextAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Child <em>Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Child
     * @generated
     */
    public Adapter createChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.XYChild <em>XY Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.XYChild
     * @generated
     */
    public Adapter createXYChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.XYContainer <em>XY Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.XYContainer
     * @generated
     */
    public Adapter createXYContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Position <em>Position</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Position
     * @generated
     */
    public Adapter createPositionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Line <em>Line</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Line
     * @generated
     */
    public Adapter createLineAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Figure <em>Figure</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Figure
     * @generated
     */
    public Adapter createFigureAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.SymbolReference <em>Symbol Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.SymbolReference
     * @generated
     */
    public Adapter createSymbolReferenceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To String Map</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
    public Adapter createStringToStringMapAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Dimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Dimension
     * @generated
     */
    public Adapter createDimensionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Cursor <em>Cursor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Cursor
     * @generated
     */
    public Adapter createCursorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.SystemCursor <em>System Cursor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.SystemCursor
     * @generated
     */
    public Adapter createSystemCursorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.GridContainer <em>Grid Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.GridContainer
     * @generated
     */
    public Adapter createGridContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.BorderContainer <em>Border Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.BorderContainer
     * @generated
     */
    public Adapter createBorderContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.BorderChild <em>Border Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.BorderChild
     * @generated
     */
    public Adapter createBorderChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.GridChild <em>Grid Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.GridChild
     * @generated
     */
    public Adapter createGridChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.FigureContainer <em>Figure Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.FigureContainer
     * @generated
     */
    public Adapter createFigureContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Image <em>Image</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Image
     * @generated
     */
    public Adapter createImageAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Ellipse <em>Ellipse</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Ellipse
     * @generated
     */
    public Adapter createEllipseAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Arc <em>Arc</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Arc
     * @generated
     */
    public Adapter createArcAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.model.VisualInterface.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.model.VisualInterface.Connection
     * @generated
     */
    public Adapter createConnectionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //VisualInterfaceAdapterFactory
