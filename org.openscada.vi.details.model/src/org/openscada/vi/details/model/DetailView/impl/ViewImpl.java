/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.impl;

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
import org.openscada.vi.details.model.DetailView.Component;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.GroupEntry;
import org.openscada.vi.details.model.DetailView.HiddenComponent;
import org.openscada.vi.details.model.DetailView.ScriptModule;
import org.openscada.vi.details.model.DetailView.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ViewImpl#getHeaderComponent <em>Header Component</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ViewImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ViewImpl#getHiddenComponent <em>Hidden Component</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.impl.ViewImpl#getScriptModule <em>Script Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends EObjectImpl implements View
{
    /**
     * The cached value of the '{@link #getHeaderComponent() <em>Header Component</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeaderComponent()
     * @generated
     * @ordered
     */
    protected Component headerComponent;

    /**
     * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGroups()
     * @generated
     * @ordered
     */
    protected EList<GroupEntry> groups;

    /**
     * The cached value of the '{@link #getHiddenComponent() <em>Hidden Component</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHiddenComponent()
     * @generated
     * @ordered
     */
    protected EList<HiddenComponent> hiddenComponent;

    /**
     * The cached value of the '{@link #getScriptModule() <em>Script Module</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptModule()
     * @generated
     * @ordered
     */
    protected EList<ScriptModule> scriptModule;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ViewImpl ()
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
        return DetailViewPackage.Literals.VIEW;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Component getHeaderComponent ()
    {
        return headerComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetHeaderComponent ( Component newHeaderComponent, NotificationChain msgs )
    {
        Component oldHeaderComponent = headerComponent;
        headerComponent = newHeaderComponent;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, DetailViewPackage.VIEW__HEADER_COMPONENT, oldHeaderComponent, newHeaderComponent );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeaderComponent ( Component newHeaderComponent )
    {
        if ( newHeaderComponent != headerComponent )
        {
            NotificationChain msgs = null;
            if ( headerComponent != null )
                msgs = ( (InternalEObject)headerComponent ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.VIEW__HEADER_COMPONENT, null, msgs );
            if ( newHeaderComponent != null )
                msgs = ( (InternalEObject)newHeaderComponent ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.VIEW__HEADER_COMPONENT, null, msgs );
            msgs = basicSetHeaderComponent ( newHeaderComponent, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.VIEW__HEADER_COMPONENT, newHeaderComponent, newHeaderComponent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<GroupEntry> getGroups ()
    {
        if ( groups == null )
        {
            groups = new EObjectContainmentEList<GroupEntry> ( GroupEntry.class, this, DetailViewPackage.VIEW__GROUPS );
        }
        return groups;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<HiddenComponent> getHiddenComponent ()
    {
        if ( hiddenComponent == null )
        {
            hiddenComponent = new EObjectContainmentEList<HiddenComponent> ( HiddenComponent.class, this, DetailViewPackage.VIEW__HIDDEN_COMPONENT );
        }
        return hiddenComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ScriptModule> getScriptModule ()
    {
        if ( scriptModule == null )
        {
            scriptModule = new EObjectContainmentEList<ScriptModule> ( ScriptModule.class, this, DetailViewPackage.VIEW__SCRIPT_MODULE );
        }
        return scriptModule;
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
            case DetailViewPackage.VIEW__HEADER_COMPONENT:
                return basicSetHeaderComponent ( null, msgs );
            case DetailViewPackage.VIEW__GROUPS:
                return ( (InternalEList<?>)getGroups () ).basicRemove ( otherEnd, msgs );
            case DetailViewPackage.VIEW__HIDDEN_COMPONENT:
                return ( (InternalEList<?>)getHiddenComponent () ).basicRemove ( otherEnd, msgs );
            case DetailViewPackage.VIEW__SCRIPT_MODULE:
                return ( (InternalEList<?>)getScriptModule () ).basicRemove ( otherEnd, msgs );
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
            case DetailViewPackage.VIEW__HEADER_COMPONENT:
                return getHeaderComponent ();
            case DetailViewPackage.VIEW__GROUPS:
                return getGroups ();
            case DetailViewPackage.VIEW__HIDDEN_COMPONENT:
                return getHiddenComponent ();
            case DetailViewPackage.VIEW__SCRIPT_MODULE:
                return getScriptModule ();
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
            case DetailViewPackage.VIEW__HEADER_COMPONENT:
                setHeaderComponent ( (Component)newValue );
                return;
            case DetailViewPackage.VIEW__GROUPS:
                getGroups ().clear ();
                getGroups ().addAll ( (Collection<? extends GroupEntry>)newValue );
                return;
            case DetailViewPackage.VIEW__HIDDEN_COMPONENT:
                getHiddenComponent ().clear ();
                getHiddenComponent ().addAll ( (Collection<? extends HiddenComponent>)newValue );
                return;
            case DetailViewPackage.VIEW__SCRIPT_MODULE:
                getScriptModule ().clear ();
                getScriptModule ().addAll ( (Collection<? extends ScriptModule>)newValue );
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
            case DetailViewPackage.VIEW__HEADER_COMPONENT:
                setHeaderComponent ( (Component)null );
                return;
            case DetailViewPackage.VIEW__GROUPS:
                getGroups ().clear ();
                return;
            case DetailViewPackage.VIEW__HIDDEN_COMPONENT:
                getHiddenComponent ().clear ();
                return;
            case DetailViewPackage.VIEW__SCRIPT_MODULE:
                getScriptModule ().clear ();
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
            case DetailViewPackage.VIEW__HEADER_COMPONENT:
                return headerComponent != null;
            case DetailViewPackage.VIEW__GROUPS:
                return groups != null && !groups.isEmpty ();
            case DetailViewPackage.VIEW__HIDDEN_COMPONENT:
                return hiddenComponent != null && !hiddenComponent.isEmpty ();
            case DetailViewPackage.VIEW__SCRIPT_MODULE:
                return scriptModule != null && !scriptModule.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //ViewImpl
