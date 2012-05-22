/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.TextInputMultiComponent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Text Input Multi Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextInputMultiComponentTest extends WriteableComponentTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( TextInputMultiComponentTest.class );
    }

    /**
     * Constructs a new Text Input Multi Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextInputMultiComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Text Input Multi Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected TextInputMultiComponent getFixture ()
    {
        return (TextInputMultiComponent)fixture;
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
        setFixture ( DetailViewFactory.eINSTANCE.createTextInputMultiComponent () );
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

} //TextInputMultiComponentTest
