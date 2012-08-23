/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.PermissionVisibility;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Permission Visibility</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PermissionVisibilityTest extends VisibilityTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( PermissionVisibilityTest.class );
    }

    /**
     * Constructs a new Permission Visibility test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PermissionVisibilityTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Permission Visibility test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected PermissionVisibility getFixture ()
    {
        return (PermissionVisibility)fixture;
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
        setFixture ( DetailViewFactory.eINSTANCE.createPermissionVisibility () );
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

} //PermissionVisibilityTest
