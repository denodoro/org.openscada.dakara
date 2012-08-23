/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.ProgressComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Progress Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl#getMax <em>Max</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl#getMin <em>Min</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgressComponentImpl extends ReadableComponentImpl implements ProgressComponent
{
    /**
     * The default value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescriptor()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescriptor()
     * @generated
     * @ordered
     */
    protected String descriptor = DESCRIPTOR_EDEFAULT;

    /**
     * The default value of the '{@link #getFactor() <em>Factor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFactor()
     * @generated
     * @ordered
     */
    protected static final double FACTOR_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getFactor() <em>Factor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFactor()
     * @generated
     * @ordered
     */
    protected double factor = FACTOR_EDEFAULT;

    /**
     * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMax()
     * @generated
     * @ordered
     */
    protected static final double MAX_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMax()
     * @generated
     * @ordered
     */
    protected double max = MAX_EDEFAULT;

    /**
     * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMin()
     * @generated
     * @ordered
     */
    protected static final double MIN_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMin()
     * @generated
     * @ordered
     */
    protected double min = MIN_EDEFAULT;

    /**
     * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected static final int WIDTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected int width = WIDTH_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProgressComponentImpl ()
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
        return DetailViewPackage.Literals.PROGRESS_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescriptor ()
    {
        return descriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescriptor ( String newDescriptor )
    {
        String oldDescriptor = descriptor;
        descriptor = newDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.PROGRESS_COMPONENT__DESCRIPTOR, oldDescriptor, descriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getFactor ()
    {
        return factor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFactor ( double newFactor )
    {
        double oldFactor = factor;
        factor = newFactor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.PROGRESS_COMPONENT__FACTOR, oldFactor, factor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getMax ()
    {
        return max;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMax ( double newMax )
    {
        double oldMax = max;
        max = newMax;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.PROGRESS_COMPONENT__MAX, oldMax, max ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getMin ()
    {
        return min;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMin ( double newMin )
    {
        double oldMin = min;
        min = newMin;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.PROGRESS_COMPONENT__MIN, oldMin, min ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getWidth ()
    {
        return width;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidth ( int newWidth )
    {
        int oldWidth = width;
        width = newWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.PROGRESS_COMPONENT__WIDTH, oldWidth, width ) );
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
            case DetailViewPackage.PROGRESS_COMPONENT__DESCRIPTOR:
                return getDescriptor ();
            case DetailViewPackage.PROGRESS_COMPONENT__FACTOR:
                return getFactor ();
            case DetailViewPackage.PROGRESS_COMPONENT__MAX:
                return getMax ();
            case DetailViewPackage.PROGRESS_COMPONENT__MIN:
                return getMin ();
            case DetailViewPackage.PROGRESS_COMPONENT__WIDTH:
                return getWidth ();
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
            case DetailViewPackage.PROGRESS_COMPONENT__DESCRIPTOR:
                setDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__FACTOR:
                setFactor ( (Double)newValue );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__MAX:
                setMax ( (Double)newValue );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__MIN:
                setMin ( (Double)newValue );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__WIDTH:
                setWidth ( (Integer)newValue );
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
            case DetailViewPackage.PROGRESS_COMPONENT__DESCRIPTOR:
                setDescriptor ( DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__FACTOR:
                setFactor ( FACTOR_EDEFAULT );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__MAX:
                setMax ( MAX_EDEFAULT );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__MIN:
                setMin ( MIN_EDEFAULT );
                return;
            case DetailViewPackage.PROGRESS_COMPONENT__WIDTH:
                setWidth ( WIDTH_EDEFAULT );
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
            case DetailViewPackage.PROGRESS_COMPONENT__DESCRIPTOR:
                return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals ( descriptor );
            case DetailViewPackage.PROGRESS_COMPONENT__FACTOR:
                return factor != FACTOR_EDEFAULT;
            case DetailViewPackage.PROGRESS_COMPONENT__MAX:
                return max != MAX_EDEFAULT;
            case DetailViewPackage.PROGRESS_COMPONENT__MIN:
                return min != MIN_EDEFAULT;
            case DetailViewPackage.PROGRESS_COMPONENT__WIDTH:
                return width != WIDTH_EDEFAULT;
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
        result.append ( " (descriptor: " );
        result.append ( descriptor );
        result.append ( ", factor: " );
        result.append ( factor );
        result.append ( ", max: " );
        result.append ( max );
        result.append ( ", min: " );
        result.append ( min );
        result.append ( ", width: " );
        result.append ( width );
        result.append ( ')' );
        return result.toString ();
    }

} //ProgressComponentImpl
