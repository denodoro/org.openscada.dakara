/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Visibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ScriptVisibility#getScript <em>Script</em>}</li>
 *   <li>{@link org.openscada.vi.details.model.DetailView.ScriptVisibility#getScriptLanguage <em>Script Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getScriptVisibility()
 * @model
 * @generated
 */
public interface ScriptVisibility extends Visibility
{
    /**
     * Returns the value of the '<em><b>Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' attribute.
     * @see #setScript(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getScriptVisibility_Script()
     * @model required="true"
     * @generated
     */
    String getScript ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ScriptVisibility#getScript <em>Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' attribute.
     * @see #getScript()
     * @generated
     */
    void setScript ( String value );

    /**
     * Returns the value of the '<em><b>Script Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The script interpreter. If left empty "JavaScript" willl be used.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Script Language</em>' attribute.
     * @see #setScriptLanguage(String)
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#getScriptVisibility_ScriptLanguage()
     * @model
     * @generated
     */
    String getScriptLanguage ();

    /**
     * Sets the value of the '{@link org.openscada.vi.details.model.DetailView.ScriptVisibility#getScriptLanguage <em>Script Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script Language</em>' attribute.
     * @see #getScriptLanguage()
     * @generated
     */
    void setScriptLanguage ( String value );

} // ScriptVisibility
