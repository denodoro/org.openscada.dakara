/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.tests;

import junit.textui.TestRunner;

import org.openscada.vi.model.VisualInterface.VisualInterfaceFactory;
import org.openscada.vi.model.VisualInterface.XYChild;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>XY Child</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class XYChildTest extends ChildTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args)
    {
        TestRunner.run(XYChildTest.class);
    }

    /**
     * Constructs a new XY Child test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XYChildTest(String name)
    {
        super(name);
    }

    /**
     * Returns the fixture for this XY Child test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected XYChild getFixture()
    {
        return (XYChild)fixture;
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
        setFixture(VisualInterfaceFactory.eINSTANCE.createXYChild());
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

} //XYChildTest
