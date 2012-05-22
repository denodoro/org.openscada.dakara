/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.CheckComponent;
import org.openscada.vi.details.model.DetailView.DetailViewFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Check Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CheckComponentTest extends ComponentTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( CheckComponentTest.class );
    }

    /**
     * Constructs a new Check Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CheckComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Check Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected CheckComponent getFixture ()
    {
        return (CheckComponent)fixture;
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
        setFixture ( DetailViewFactory.eINSTANCE.createCheckComponent () );
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

} //CheckComponentTest
