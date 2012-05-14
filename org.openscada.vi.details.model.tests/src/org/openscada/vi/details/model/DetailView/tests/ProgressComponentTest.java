/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.ProgressComponent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Progress Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProgressComponentTest extends ReadableComponentTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args)
    {
        TestRunner.run(ProgressComponentTest.class);
    }

    /**
     * Constructs a new Progress Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProgressComponentTest(String name)
    {
        super(name);
    }

    /**
     * Returns the fixture for this Progress Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ProgressComponent getFixture()
    {
        return (ProgressComponent)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception
    {
        setFixture(DetailViewFactory.eINSTANCE.createProgressComponent());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception
    {
        setFixture(null);
    }

} //ProgressComponentTest
