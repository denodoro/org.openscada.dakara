/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.tests;

import junit.textui.TestRunner;

import org.openscada.vi.model.VisualInterface.Rectangle;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Rectangle</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RectangleTest extends ShapeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( RectangleTest.class );
    }

    /**
     * Constructs a new Rectangle test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RectangleTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Rectangle test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Rectangle getFixture ()
    {
        return (Rectangle)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp () throws Exception
    {
        setFixture ( VisualInterfaceFactory.eINSTANCE.createRectangle () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown () throws Exception
    {
        setFixture ( null );
    }

} //RectangleTest
