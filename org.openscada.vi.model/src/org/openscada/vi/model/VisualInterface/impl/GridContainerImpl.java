/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.openscada.vi.model.VisualInterface.GridChild;
import org.openscada.vi.model.VisualInterface.GridContainer;
import org.openscada.vi.model.VisualInterface.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grid Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.GridContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.GridContainerImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.GridContainerImpl#isEqualWidth <em>Equal Width</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.impl.GridContainerImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GridContainerImpl extends EObjectImpl implements GridContainer
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getColumns() <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumns()
     * @generated
     * @ordered
     */
    protected static final int COLUMNS_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getColumns() <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumns()
     * @generated
     * @ordered
     */
    protected int columns = COLUMNS_EDEFAULT;

    /**
     * The default value of the '{@link #isEqualWidth() <em>Equal Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEqualWidth()
     * @generated
     * @ordered
     */
    protected static final boolean EQUAL_WIDTH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEqualWidth() <em>Equal Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEqualWidth()
     * @generated
     * @ordered
     */
    protected boolean equalWidth = EQUAL_WIDTH_EDEFAULT;

    /**
     * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
    protected EList<GridChild> children;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GridContainerImpl ()
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
        return VisualInterfacePackage.Literals.GRID_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getColumns ()
    {
        return columns;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setColumns ( int newColumns )
    {
        int oldColumns = columns;
        columns = newColumns;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__COLUMNS, oldColumns, columns ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEqualWidth ()
    {
        return equalWidth;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEqualWidth ( boolean newEqualWidth )
    {
        boolean oldEqualWidth = equalWidth;
        equalWidth = newEqualWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH, oldEqualWidth, equalWidth ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<GridChild> getChildren ()
    {
        if ( children == null )
        {
            children = new EObjectContainmentEList<GridChild> ( GridChild.class, this, VisualInterfacePackage.GRID_CONTAINER__CHILDREN );
        }
        return children;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                return ( (InternalEList<?>)getChildren () ).basicRemove ( otherEnd, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
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
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                return getName ();
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                return getColumns ();
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                return isEqualWidth ();
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                return getChildren ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                setName ( (String)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                setColumns ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                setEqualWidth ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                getChildren ().clear ();
                getChildren ().addAll ( (Collection<? extends GridChild>)newValue );
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
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                setColumns ( COLUMNS_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                setEqualWidth ( EQUAL_WIDTH_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                getChildren ().clear ();
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
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                return columns != COLUMNS_EDEFAULT;
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                return equalWidth != EQUAL_WIDTH_EDEFAULT;
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                return children != null && !children.isEmpty ();
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", columns: " ); //$NON-NLS-1$
        result.append ( columns );
        result.append ( ", equalWidth: " ); //$NON-NLS-1$
        result.append ( equalWidth );
        result.append ( ')' );
        return result.toString ();
    }

} //GridContainerImpl
