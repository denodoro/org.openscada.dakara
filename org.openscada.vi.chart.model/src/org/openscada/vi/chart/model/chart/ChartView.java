/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.chart.model.chart;

import org.openscada.vi.model.VisualInterface.Primitive;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.chart.model.chart.ChartView#getConfigurationUri <em>Configuration Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.chart.model.chart.ChartPackage#getChartView()
 * @model
 * @generated
 */
public interface ChartView extends Primitive
{

    /**
     * Returns the value of the '<em><b>Configuration Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration Uri</em>' attribute.
     * @see #setConfigurationUri(String)
     * @see org.openscada.vi.chart.model.chart.ChartPackage#getChartView_ConfigurationUri()
     * @model required="true"
     * @generated
     */
    String getConfigurationUri ();

    /**
     * Sets the value of the '{@link org.openscada.vi.chart.model.chart.ChartView#getConfigurationUri <em>Configuration Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration Uri</em>' attribute.
     * @see #getConfigurationUri()
     * @generated
     */
    void setConfigurationUri ( String value );
} // ChartView
