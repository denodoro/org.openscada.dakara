/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.GroupGridEntry;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Group Grid Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GroupGridEntryTest extends TestCase
{

    /**
     * The fixture for this Group Grid Entry test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroupGridEntry fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( GroupGridEntryTest.class );
    }

    /**
     * Constructs a new Group Grid Entry test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupGridEntryTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Group Grid Entry test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( GroupGridEntry fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Group Grid Entry test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroupGridEntry getFixture ()
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
        setFixture ( DetailViewFactory.eINSTANCE.createGroupGridEntry () );
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

} //GroupGridEntryTest
