/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.tests;

import junit.textui.TestRunner;

import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.ItemValueSource;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Item Value Source</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ItemValueSourceTest extends ValueSourceTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args)
    {
        TestRunner.run(ItemValueSourceTest.class);
    }

    /**
     * Constructs a new Item Value Source test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemValueSourceTest(String name)
    {
        super(name);
    }

    /**
     * Returns the fixture for this Item Value Source test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ItemValueSource getFixture()
    {
        return (ItemValueSource)fixture;
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
        setFixture(DetailViewFactory.eINSTANCE.createItemValueSource());
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

} //ItemValueSourceTest
