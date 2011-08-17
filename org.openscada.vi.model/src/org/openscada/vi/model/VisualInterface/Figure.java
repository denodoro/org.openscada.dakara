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

} // Figure
