/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.openscada.vi.model.VisualInterface.Arc;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.ArcImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.ArcImpl#getLength <em>Length</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArcImpl extends ShapeImpl implements Arc
{
    /**
     * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStart()
     * @generated
     * @ordered
     */
    protected static final int START_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStart()
     * @generated
     * @ordered
     */
    protected int start = START_EDEFAULT;

    /**
     * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected static final int LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected int length = LENGTH_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ArcImpl ()
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
        return VisualInterfacePackage.Literals.ARC;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getStart ()
    {
        return start;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStart ( int newStart )
    {
        int oldStart = start;
        start = newStart;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.ARC__START, oldStart, start ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getLength ()
    {
        return length;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLength ( int newLength )
    {
        int oldLength = length;
        length = newLength;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.ARC__LENGTH, oldLength, length ) );
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
            case VisualInterfacePackage.ARC__START:
                return getStart ();
            case VisualInterfacePackage.ARC__LENGTH:
                return getLength ();
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
            case VisualInterfacePackage.ARC__START:
                setStart ( (Integer)newValue );
                return;
            case VisualInterfacePackage.ARC__LENGTH:
                setLength ( (Integer)newValue );
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
            case VisualInterfacePackage.ARC__START:
                setStart ( START_EDEFAULT );
                return;
            case VisualInterfacePackage.ARC__LENGTH:
                setLength ( LENGTH_EDEFAULT );
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
            case VisualInterfacePackage.ARC__START:
                return start != START_EDEFAULT;
            case VisualInterfacePackage.ARC__LENGTH:
                return length != LENGTH_EDEFAULT;
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
        result.append ( " (start: " ); //$NON-NLS-1$
        result.append ( start );
        result.append ( ", length: " ); //$NON-NLS-1$
        result.append ( length );
        result.append ( ')' );
        return result.toString ();
    }

} //ArcImpl
