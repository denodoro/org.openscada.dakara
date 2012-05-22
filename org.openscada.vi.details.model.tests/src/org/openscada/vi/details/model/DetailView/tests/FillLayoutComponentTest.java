/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.FillLayoutComponent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Fill Layout Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FillLayoutComponentTest extends CompositeComponentTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( FillLayoutComponentTest.class );
    }

    /**
     * Constructs a new Fill Layout Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FillLayoutComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Fill Layout Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected FillLayoutComponent getFixture ()
    {
        return (FillLayoutComponent)fixture;
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
        setFixture ( DetailViewFactory.eINSTANCE.createFillLayoutComponent () );
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

} //FillLayoutComponentTest
