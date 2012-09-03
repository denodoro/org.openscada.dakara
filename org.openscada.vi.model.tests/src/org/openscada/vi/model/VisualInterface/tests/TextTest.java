/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.tests;

import junit.textui.TestRunner;

import org.openscada.vi.model.VisualInterface.Text;
import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextTest extends FigureTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( TextTest.class );
    }

    /**
     * Constructs a new Text test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Text test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Text getFixture ()
    {
        return (Text)fixture;
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
        setFixture ( VisualInterfaceFactory.eINSTANCE.createText () );
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

} //TextTest
