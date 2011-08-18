/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getRoot <em>Root</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getOnInit <em>On Init</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getOnDispose <em>On Dispose</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getOnUpdate <em>On Update</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getScriptModules <em>Script Modules</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getCursors <em>Cursors</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Symbol#getBackgroundColor <em>Background Color</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol()
 * @model
 * @generated
 */
public interface Symbol extends EObject
{
    /**
     * Returns the value of the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root</em>' containment reference.
     * @see #setRoot(Primitive)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_Root()
     * @model containment="true"
     * @generated
     */
    Primitive getRoot();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Symbol#getRoot <em>Root</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root</em>' containment reference.
     * @see #getRoot()
     * @generated
     */
    void setRoot(Primitive value);

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
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_Properties()
     * @model mapType="org.openscada.vi.model.VisualInterface.StringToStringMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getProperties();

    /**
     * Returns the value of the '<em><b>On Init</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Init</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Init</em>' attribute.
     * @see #setOnInit(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_OnInit()
     * @model
     * @generated
     */
    String getOnInit();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Symbol#getOnInit <em>On Init</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Init</em>' attribute.
     * @see #getOnInit()
     * @generated
     */
    void setOnInit(String value);

    /**
     * Returns the value of the '<em><b>On Dispose</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Dispose</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Dispose</em>' attribute.
     * @see #setOnDispose(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_OnDispose()
     * @model
     * @generated
     */
    String getOnDispose();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Symbol#getOnDispose <em>On Dispose</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Dispose</em>' attribute.
     * @see #getOnDispose()
     * @generated
     */
    void setOnDispose(String value);

    /**
     * Returns the value of the '<em><b>On Update</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Update</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Update</em>' attribute.
     * @see #setOnUpdate(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_OnUpdate()
     * @model
     * @generated
     */
    String getOnUpdate();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Symbol#getOnUpdate <em>On Update</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Update</em>' attribute.
     * @see #getOnUpdate()
     * @generated
     */
    void setOnUpdate(String value);

    /**
     * Returns the value of the '<em><b>Script Modules</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script Modules</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script Modules</em>' attribute list.
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_ScriptModules()
     * @model
     * @generated
     */
    EList<String> getScriptModules();

    /**
     * Returns the value of the '<em><b>Cursors</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cursors</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cursors</em>' containment reference.
     * @see #setCursors(Cursor)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_Cursors()
     * @model containment="true"
     * @generated
     */
    Cursor getCursors();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Symbol#getCursors <em>Cursors</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cursors</em>' containment reference.
     * @see #getCursors()
     * @generated
     */
    void setCursors(Cursor value);

    /**
     * Returns the value of the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Background Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Background Color</em>' attribute.
     * @see #setBackgroundColor(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getSymbol_BackgroundColor()
     * @model
     * @generated
     */
    String getBackgroundColor();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Symbol#getBackgroundColor <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background Color</em>' attribute.
     * @see #getBackgroundColor()
     * @generated
     */
    void setBackgroundColor(String value);

} // Symbol
