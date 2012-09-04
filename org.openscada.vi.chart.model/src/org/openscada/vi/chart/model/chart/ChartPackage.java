/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.chart.model.chart;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.openscada.vi.chart.model.chart.ChartFactory
 * @model kind="package"
 * @generated
 */
public interface ChartPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "chart";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "urn:openscada:visualInterface:chart";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "chart";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ChartPackage eINSTANCE = org.openscada.vi.chart.model.chart.impl.ChartPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.openscada.vi.chart.model.chart.impl.ChartViewImpl <em>View</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.chart.model.chart.impl.ChartViewImpl
     * @see org.openscada.vi.chart.model.chart.impl.ChartPackageImpl#getChartView()
     * @generated
     */
    int CHART_VIEW = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__NAME = VisualInterfacePackage.PRIMITIVE__NAME;

    /**
     * The number of structural features of the '<em>View</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW_FEATURE_COUNT = VisualInterfacePackage.PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.openscada.vi.chart.model.chart.ChartView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View</em>'.
     * @see org.openscada.vi.chart.model.chart.ChartView
     * @generated
     */
    EClass getChartView ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ChartFactory getChartFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.openscada.vi.chart.model.chart.impl.ChartViewImpl <em>View</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.chart.model.chart.impl.ChartViewImpl
         * @see org.openscada.vi.chart.model.chart.impl.ChartPackageImpl#getChartView()
         * @generated
         */
        EClass CHART_VIEW = eINSTANCE.getChartView ();

    }

} //ChartPackage
