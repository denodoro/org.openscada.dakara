/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.chart.model.chart.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.openscada.vi.chart.model.chart.ChartPackage;
import org.openscada.vi.chart.model.chart.ChartView;
import org.openscada.vi.model.VisualInterface.impl.FigureImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.chart.model.chart.impl.ChartViewImpl#getConfigurationUri <em>Configuration Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChartViewImpl extends FigureImpl implements ChartView
{
    /**
     * The default value of the '{@link #getConfigurationUri() <em>Configuration Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationUri()
     * @generated
     * @ordered
     */
    protected static final String CONFIGURATION_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConfigurationUri() <em>Configuration Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationUri()
     * @generated
     * @ordered
     */
    protected String configurationUri = CONFIGURATION_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChartViewImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return ChartPackage.Literals.CHART_VIEW;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConfigurationUri ()
    {
        return configurationUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfigurationUri ( String newConfigurationUri )
    {
        String oldConfigurationUri = configurationUri;
        configurationUri = newConfigurationUri;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART_VIEW__CONFIGURATION_URI, oldConfigurationUri, configurationUri ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART_VIEW__CONFIGURATION_URI:
                return getConfigurationUri ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART_VIEW__CONFIGURATION_URI:
                setConfigurationUri ( (String)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART_VIEW__CONFIGURATION_URI:
                setConfigurationUri ( CONFIGURATION_URI_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART_VIEW__CONFIGURATION_URI:
                return CONFIGURATION_URI_EDEFAULT == null ? configurationUri != null : !CONFIGURATION_URI_EDEFAULT.equals ( configurationUri );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (configurationUri: " );
        result.append ( configurationUri );
        result.append ( ')' );
        return result.toString ();
    }

} //ChartViewImpl
