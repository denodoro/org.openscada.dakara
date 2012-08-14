/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.HiddenComponent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hidden Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddenComponentTest extends ComponentTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( HiddenComponentTest.class );
    }

    /**
     * Constructs a new Hidden Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiddenComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Hidden Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected HiddenComponent getFixture ()
    {
        return (HiddenComponent)fixture;
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
        setFixture ( DetailViewFactory.eINSTANCE.createHiddenComponent () );
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

} //HiddenComponentTest
