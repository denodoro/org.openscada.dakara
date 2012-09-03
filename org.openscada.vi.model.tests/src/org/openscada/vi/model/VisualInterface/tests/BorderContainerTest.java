/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.openscada.vi.model.VisualInterface.BorderContainer;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Border Container</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BorderContainerTest extends TestCase
{

    /**
     * The fixture for this Border Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BorderContainer fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( BorderContainerTest.class );
    }

    /**
     * Constructs a new Border Container test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BorderContainerTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Border Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( BorderContainer fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Border Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BorderContainer getFixture ()
    {
        return fixture;
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
        setFixture ( VisualInterfaceFactory.eINSTANCE.createBorderContainer () );
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

} //BorderContainerTest
