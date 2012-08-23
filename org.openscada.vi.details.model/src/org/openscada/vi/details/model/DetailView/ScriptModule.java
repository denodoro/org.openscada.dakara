/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ScriptModule#getScriptLanguage <em>Script Language</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ScriptModule#getCode <em>Code</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ScriptModule#getCodeUri <em>Code Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getScriptModule()
 * @model
 * @generated
 */
public interface ScriptModule extends EObject
{
    /**
     * Returns the value of the '<em><b>Script Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The language of the script module. Default is "JavaScript".
     * <!-- end-model-doc -->
     * @return the value of the '<em>Script Language</em>' attribute.
     * @see #setScriptLanguage(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getScriptModule_ScriptLanguage()
     * @model
     * @generated
     */
    String getScriptLanguage ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ScriptModule#getScriptLanguage <em>Script Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script Language</em>' attribute.
     * @see #getScriptLanguage()
     * @generated
     */
    void setScriptLanguage ( String value );

    /**
     * Returns the value of the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Code</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The script code to execute.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Code</em>' attribute.
     * @see #setCode(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getScriptModule_Code()
     * @model
     * @generated
     */
    String getCode ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ScriptModule#getCode <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Code</em>' attribute.
     * @see #getCode()
     * @generated
     */
    void setCode ( String value );

    /**
     * Returns the value of the '<em><b>Code Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Code Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Code Uri</em>' attribute.
     * @see #setCodeUri(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getScriptModule_CodeUri()
     * @model
     * @generated
     */
    String getCodeUri ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ScriptModule#getCodeUri <em>Code Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Code Uri</em>' attribute.
     * @see #getCodeUri()
     * @generated
     */
    void setCodeUri ( String value );

} // ScriptModule
