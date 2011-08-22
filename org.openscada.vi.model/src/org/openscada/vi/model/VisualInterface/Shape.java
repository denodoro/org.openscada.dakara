/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Shape#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Shape#getAntialias <em>Antialias</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.Shape#getAlpha <em>Alpha</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getShape()
 * @model abstract="true"
 * @generated
 */
public interface Shape extends Figure
{

    /**
     * Returns the value of the '<em><b>Line Width</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Line Width</em>' attribute.
     * @see #setLineWidth(float)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getShape_LineWidth()
     * @model default="1" required="true"
     * @generated
     */
    float getLineWidth();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Shape#getLineWidth <em>Line Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Line Width</em>' attribute.
     * @see #getLineWidth()
     * @generated
     */
    void setLineWidth(float value);

    /**
     * Returns the value of the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Antialias</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Antialias</em>' attribute.
     * @see #setAntialias(Boolean)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getShape_Antialias()
     * @model
     * @generated
     */
    Boolean getAntialias();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Shape#getAntialias <em>Antialias</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Antialias</em>' attribute.
     * @see #getAntialias()
     * @generated
     */
    void setAntialias(Boolean value);

    /**
     * Returns the value of the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alpha</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Alpha</em>' attribute.
     * @see #setAlpha(Double)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getShape_Alpha()
     * @model
     * @generated
     */
    Double getAlpha();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.Shape#getAlpha <em>Alpha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alpha</em>' attribute.
     * @see #getAlpha()
     * @generated
     */
    void setAlpha(Double value);

} // Shape
