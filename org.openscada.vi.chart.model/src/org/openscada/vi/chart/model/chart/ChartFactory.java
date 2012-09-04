/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.chart.model.chart;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.openscada.vi.chart.model.chart.ChartPackage
 * @generated
 */
public interface ChartFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ChartFactory eINSTANCE = org.openscada.vi.chart.model.chart.impl.ChartFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>View</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View</em>'.
     * @generated
     */
    ChartView createChartView ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ChartPackage getChartPackage ();

} //ChartFactory
