/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.SymbolReference#getUri <em>Uri</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.SymbolReference#getZoom <em>Zoom</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.SymbolReference#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.SymbolReference#getOnCreateProperties <em>On Create Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbolReference()
 * @model
 * @generated
 */
public interface SymbolReference extends Primitive
{
    /**
     * Returns the value of the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uri</em>' attribute.
     * @see #setUri(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbolReference_Uri()
     * @model required="true"
     * @generated
     */
    String getUri ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.SymbolReference#getUri <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
    void setUri ( String value );

    /**
     * Returns the value of the '<em><b>Zoom</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zoom</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zoom</em>' attribute.
     * @see #setZoom(Double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbolReference_Zoom()
     * @model
     * @generated
     */
    Double getZoom ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.SymbolReference#getZoom <em>Zoom</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zoom</em>' attribute.
     * @see #getZoom()
     * @generated
     */
    void setZoom ( Double value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' map.
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbolReference_Properties()
     * @model mapType="org.openscada.vi.model.VisualInterface.StringToStringMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getProperties ();

    /**
     * Returns the value of the '<em><b>On Create Properties</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Create Properties</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Create Properties</em>' attribute.
     * @see #setOnCreateProperties(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbolReference_OnCreateProperties()
     * @model
     * @generated
     */
    String getOnCreateProperties ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.SymbolReference#getOnCreateProperties <em>On Create Properties</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Create Properties</em>' attribute.
     * @see #getOnCreateProperties()
     * @generated
     */
    void setOnCreateProperties ( String value );

} // SymbolReference
