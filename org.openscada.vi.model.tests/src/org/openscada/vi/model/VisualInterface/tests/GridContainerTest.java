/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.openscada.vi.model.VisualInterface.GridContainer;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Grid Container</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GridContainerTest extends TestCase
{

    /**
     * The fixture for this Grid Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GridContainer fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( GridContainerTest.class );
    }

    /**
     * Constructs a new Grid Container test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GridContainerTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Grid Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( GridContainer fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Grid Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GridContainer getFixture ()
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
        setFixture ( VisualInterfaceFactory.eINSTANCE.createGridContainer () );
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

} //GridContainerTest
