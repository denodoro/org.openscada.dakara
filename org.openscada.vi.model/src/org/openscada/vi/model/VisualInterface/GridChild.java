/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.model.VisualInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grid Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridChild#getHorizontalAlignment <em>Horizontal Alignment</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridChild#getVerticalAlignment <em>Vertical Alignment</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridChild#isGrabHorizontalSpace <em>Grab Horizontal Space</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridChild#isGrabVerticalSpace <em>Grab Vertical Space</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridChild#getSpanCols <em>Span Cols</em>}</li>
 *   <li>{@link org.openscada.vi.model.VisualInterface.GridChild#getSpanRows <em>Span Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridChild()
 * @model
 * @generated
 */
public interface GridChild extends Child
{
    /**
     * Returns the value of the '<em><b>Horizontal Alignment</b></em>' attribute.
     * The default value is <code>"BEGINNING"</code>.
     * The literals are from the enumeration {@link org.openscada.vi.model.VisualInterface.GridAlignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Horizontal Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Horizontal Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.GridAlignment
     * @see #setHorizontalAlignment(GridAlignment)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridChild_HorizontalAlignment()
     * @model default="BEGINNING" required="true"
     * @generated
     */
    GridAlignment getHorizontalAlignment ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridChild#getHorizontalAlignment <em>Horizontal Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Horizontal Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.GridAlignment
     * @see #getHorizontalAlignment()
     * @generated
     */
    void setHorizontalAlignment ( GridAlignment value );

    /**
     * Returns the value of the '<em><b>Vertical Alignment</b></em>' attribute.
     * The default value is <code>"BEGINNING"</code>.
     * The literals are from the enumeration {@link org.openscada.vi.model.VisualInterface.GridAlignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vertical Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Vertical Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.GridAlignment
     * @see #setVerticalAlignment(GridAlignment)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridChild_VerticalAlignment()
     * @model default="BEGINNING" required="true"
     * @generated
     */
    GridAlignment getVerticalAlignment ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridChild#getVerticalAlignment <em>Vertical Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Vertical Alignment</em>' attribute.
     * @see org.openscada.vi.model.VisualInterface.GridAlignment
     * @see #getVerticalAlignment()
     * @generated
     */
    void setVerticalAlignment ( GridAlignment value );

    /**
     * Returns the value of the '<em><b>Grab Horizontal Space</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Grab Horizontal Space</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Grab Horizontal Space</em>' attribute.
     * @see #setGrabHorizontalSpace(boolean)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridChild_GrabHorizontalSpace()
     * @model default="false" required="true"
     * @generated
     */
    boolean isGrabHorizontalSpace ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridChild#isGrabHorizontalSpace <em>Grab Horizontal Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grab Horizontal Space</em>' attribute.
     * @see #isGrabHorizontalSpace()
     * @generated
     */
    void setGrabHorizontalSpace ( boolean value );

    /**
     * Returns the value of the '<em><b>Grab Vertical Space</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Grab Vertical Space</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Grab Vertical Space</em>' attribute.
     * @see #setGrabVerticalSpace(boolean)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridChild_GrabVerticalSpace()
     * @model default="false" required="true"
     * @generated
     */
    boolean isGrabVerticalSpace ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridChild#isGrabVerticalSpace <em>Grab Vertical Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grab Vertical Space</em>' attribute.
     * @see #isGrabVerticalSpace()
     * @generated
     */
    void setGrabVerticalSpace ( boolean value );

    /**
     * Returns the value of the '<em><b>Span Cols</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Span Cols</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Span Cols</em>' attribute.
     * @see #setSpanCols(int)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridChild_SpanCols()
     * @model default="0" required="true"
     * @generated
     */
    int getSpanCols ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridChild#getSpanCols <em>Span Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Span Cols</em>' attribute.
     * @see #getSpanCols()
     * @generated
     */
    void setSpanCols ( int value );

    /**
     * Returns the value of the '<em><b>Span Rows</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Span Rows</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Span Rows</em>' attribute.
     * @see #setSpanRows(int)
     * @see org.openscada.vi.model.VisualInterface.VisualInterfacePackage#getGridChild_SpanRows()
     * @model default="0" required="true"
     * @generated
     */
    int getSpanRows ();

    /**
     * Sets the value of the '{@link org.openscada.vi.model.VisualInterface.GridChild#getSpanRows <em>Span Rows</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Span Rows</em>' attribute.
     * @see #getSpanRows()
     * @generated
     */
    void setSpanRows ( int value );

} // GridChild
