/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.chart.model.chart.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.openscada.vi.chart.model.chart.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChartFactoryImpl extends EFactoryImpl implements ChartFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ChartFactory init ()
    {
        try
        {
            ChartFactory theChartFactory = (ChartFactory)EPackage.Registry.INSTANCE.getEFactory ( "urn:openscada:visualInterface:chart" );
            if ( theChartFactory != null )
            {
                return theChartFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ChartFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ChartPackage.CHART_VIEW:
                return createChartView ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartView createChartView ()
    {
        ChartViewImpl chartView = new ChartViewImpl ();
        return chartView;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartPackage getChartPackage ()
    {
        return (ChartPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ChartPackage getPackage ()
    {
        return ChartPackage.eINSTANCE;
    }

} //ChartFactoryImpl
