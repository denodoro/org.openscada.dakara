/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;
import org.openscada.vi.model.VisualInterface.XYContainer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>XY Container</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class XYContainerTest extends TestCase
{

    /**
     * The fixture for this XY Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XYContainer fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( XYContainerTest.class );
    }

    /**
     * Constructs a new XY Container test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XYContainerTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this XY Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( XYContainer fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this XY Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XYContainer getFixture ()
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
        setFixture ( VisualInterfaceFactory.eINSTANCE.createXYContainer () );
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

} //XYContainerTest
