/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.openscada.vi.model.VisualInterface.SymbolReference;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SymbolReferenceTest extends TestCase
{

    /**
     * The fixture for this Symbol Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SymbolReference fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SymbolReferenceTest.class );
    }

    /**
     * Constructs a new Symbol Reference test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SymbolReferenceTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Symbol Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( SymbolReference fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Symbol Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SymbolReference getFixture ()
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
        setFixture ( VisualInterfaceFactory.eINSTANCE.createSymbolReference () );
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

} //SymbolReferenceTest
