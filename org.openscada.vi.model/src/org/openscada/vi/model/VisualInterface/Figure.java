/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Figure#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Figure#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Figure#getSize <em>Size</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Figure#getOnClick <em>On Click</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Figure#getOnDoubleClick <em>On Double Click</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Figure#getCursor <em>Cursor</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Figure#isVisible <em>Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure()
 * @model
 * @generated
 */
public interface Figure extends Primitive
{
    /**
     * Returns the value of the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreground Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreground Color</em>' attribute.
     * @see #setForegroundColor(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure_ForegroundColor()
     * @model
     * @generated
     */
    String getForegroundColor();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Figure#getForegroundColor <em>Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreground Color</em>' attribute.
     * @see #getForegroundColor()
     * @generated
     */
    void setForegroundColor(String value);

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
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure_BackgroundColor()
     * @model
     * @generated
     */
    String getBackgroundColor();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Figure#getBackgroundColor <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background Color</em>' attribute.
     * @see #getBackgroundColor()
     * @generated
     */
    void setBackgroundColor(String value);

    /**
     * Returns the value of the '<em><b>Size</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Size</em>' reference.
     * @see #setSize(Dimension)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure_Size()
     * @model
     * @generated
     */
    Dimension getSize();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Figure#getSize <em>Size</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Size</em>' reference.
     * @see #getSize()
     * @generated
     */
    void setSize(Dimension value);

    /**
     * Returns the value of the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Click</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Click</em>' attribute.
     * @see #setOnClick(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure_OnClick()
     * @model
     * @generated
     */
    String getOnClick();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Figure#getOnClick <em>On Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Click</em>' attribute.
     * @see #getOnClick()
     * @generated
     */
    void setOnClick(String value);

    /**
     * Returns the value of the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Double Click</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Double Click</em>' attribute.
     * @see #setOnDoubleClick(String)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure_OnDoubleClick()
     * @model
     * @generated
     */
    String getOnDoubleClick();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Figure#getOnDoubleClick <em>On Double Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Double Click</em>' attribute.
     * @see #getOnDoubleClick()
     * @generated
     */
    void setOnDoubleClick(String value);

    /**
     * Returns the value of the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cursor</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cursor</em>' reference.
     * @see #setCursor(Cursor)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure_Cursor()
     * @model
     * @generated
     */
    Cursor getCursor();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Figure#getCursor <em>Cursor</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cursor</em>' reference.
     * @see #getCursor()
     * @generated
     */
    void setCursor(Cursor value);

    /**
     * Returns the value of the '<em><b>Visible</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visible</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visible</em>' attribute.
     * @see #setVisible(boolean)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getFigure_Visible()
     * @model default="true" required="true"
     * @generated
     */
    boolean isVisible();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Figure#isVisible <em>Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visible</em>' attribute.
     * @see #isVisible()
     * @generated
     */
    void setVisible(boolean value);

} // Figure
