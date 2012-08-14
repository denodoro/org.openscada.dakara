/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.openscada.vi.details.model.DetailView.AndTransformer;
import org.openscada.vi.details.model.DetailView.BoolLEDComponent;
import org.openscada.vi.details.model.DetailView.ButtonComponent;
import org.openscada.vi.details.model.DetailView.CheckComponent;
import org.openscada.vi.details.model.DetailView.Component;
import org.openscada.vi.details.model.DetailView.CompositeComponent;
import org.openscada.vi.details.model.DetailView.CompositeTransformer;
import org.openscada.vi.details.model.DetailView.DetailViewFactory;
import org.openscada.vi.details.model.DetailView.DetailViewPackage;
import org.openscada.vi.details.model.DetailView.FillLayoutComponent;
import org.openscada.vi.details.model.DetailView.GenericComponent;
import org.openscada.vi.details.model.DetailView.GroupEntry;
import org.openscada.vi.details.model.DetailView.GroupGridComponent;
import org.openscada.vi.details.model.DetailView.GroupGridEntry;
import org.openscada.vi.details.model.DetailView.HiddenComponent;
import org.openscada.vi.details.model.DetailView.ItemValueSource;
import org.openscada.vi.details.model.DetailView.LabelComponent;
import org.openscada.vi.details.model.DetailView.LinkComponent;
import org.openscada.vi.details.model.DetailView.NotTransformer;
import org.openscada.vi.details.model.DetailView.OrTransformer;
import org.openscada.vi.details.model.DetailView.ProgressComponent;
import org.openscada.vi.details.model.DetailView.ReadableComponent;
import org.openscada.vi.details.model.DetailView.Registration;
import org.openscada.vi.details.model.DetailView.SimpleGridComponent;
import org.openscada.vi.details.model.DetailView.TextComponent;
import org.openscada.vi.details.model.DetailView.TextInputComponent;
import org.openscada.vi.details.model.DetailView.TextInputMultiComponent;
import org.openscada.vi.details.model.DetailView.URLImageComponent;
import org.openscada.vi.details.model.DetailView.ValueComponent;
import org.openscada.vi.details.model.DetailView.ValueSetComponent;
import org.openscada.vi.details.model.DetailView.ValueSource;
import org.openscada.vi.details.model.DetailView.View;
import org.openscada.vi.details.model.DetailView.WriteableComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DetailViewPackageImpl extends EPackageImpl implements DetailViewPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass viewEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass labelComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositeComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fillLayoutComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass buttonComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass boolLEDComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueSourceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemValueSourceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass notTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass registrationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleGridComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupGridComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupGridEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueSetComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositeTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass andTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass orTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textInputComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass writeableComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass readableComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textInputMultiComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass checkComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass urlImageComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass progressComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass hiddenComponentEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.openscada.vi.details.model.DetailView.DetailViewPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DetailViewPackageImpl ()
    {
        super ( eNS_URI, DetailViewFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link DetailViewPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DetailViewPackage init ()
    {
        if ( isInited )
            return (DetailViewPackage)EPackage.Registry.INSTANCE.getEPackage ( DetailViewPackage.eNS_URI );

        // Obtain or create and register package
        DetailViewPackageImpl theDetailViewPackage = (DetailViewPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof DetailViewPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new DetailViewPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theDetailViewPackage.createPackageContents ();

        // Initialize created meta-data
        theDetailViewPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theDetailViewPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( DetailViewPackage.eNS_URI, theDetailViewPackage );
        return theDetailViewPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getView ()
    {
        return viewEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getView_HeaderComponent ()
    {
        return (EReference)viewEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getView_Groups ()
    {
        return (EReference)viewEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getView_HiddenComponent ()
    {
        return (EReference)viewEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponent ()
    {
        return componentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroupEntry ()
    {
        return groupEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupEntry_Component ()
    {
        return (EReference)groupEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupEntry_Label ()
    {
        return (EAttribute)groupEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupEntry_Permission ()
    {
        return (EAttribute)groupEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLabelComponent ()
    {
        return labelComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLabelComponent_Format ()
    {
        return (EAttribute)labelComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLabelComponent_Descriptor ()
    {
        return (EAttribute)labelComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositeComponent ()
    {
        return compositeComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeComponent_Children ()
    {
        return (EReference)compositeComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFillLayoutComponent ()
    {
        return fillLayoutComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getButtonComponent ()
    {
        return buttonComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_Format ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_Value ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_ReadDescriptor ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_WriteDescriptor ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getButtonComponent_Active ()
    {
        return (EReference)buttonComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_Attribute ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_TextHeight ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBoolLEDComponent ()
    {
        return boolLEDComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Format ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Descriptor ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Alarm ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Attribute ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueSource ()
    {
        return valueSourceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemValueSource ()
    {
        return itemValueSourceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemValueSource_ValueKey ()
    {
        return (EAttribute)itemValueSourceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNotTransformer ()
    {
        return notTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNotTransformer_Value ()
    {
        return (EReference)notTransformerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericComponent ()
    {
        return genericComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenericComponent_Registrations ()
    {
        return (EReference)genericComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRegistration ()
    {
        return registrationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegistration_Key ()
    {
        return (EAttribute)registrationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegistration_Descriptor ()
    {
        return (EAttribute)registrationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegistration_AggregateState ()
    {
        return (EAttribute)registrationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleGridComponent ()
    {
        return simpleGridComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleGridComponent_Equally ()
    {
        return (EAttribute)simpleGridComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleGridComponent_Cols ()
    {
        return (EAttribute)simpleGridComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroupGridComponent ()
    {
        return groupGridComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupGridComponent_Groups ()
    {
        return (EReference)groupGridComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridComponent_Equally ()
    {
        return (EAttribute)groupGridComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridComponent_Cols ()
    {
        return (EAttribute)groupGridComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroupGridEntry ()
    {
        return groupGridEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridEntry_Label ()
    {
        return (EAttribute)groupGridEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupGridEntry_Components ()
    {
        return (EReference)groupGridEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridEntry_Permission ()
    {
        return (EAttribute)groupGridEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueSetComponent ()
    {
        return valueSetComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueSetComponent_ValueDescriptor ()
    {
        return (EAttribute)valueSetComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueSetComponent_SetDescriptor ()
    {
        return (EAttribute)valueSetComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueSetComponent_ResetDescriptor ()
    {
        return (EAttribute)valueSetComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueComponent ()
    {
        return valueComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueComponent_Descriptor ()
    {
        return (EAttribute)valueComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueComponent_Date ()
    {
        return (EAttribute)valueComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositeTransformer ()
    {
        return compositeTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeTransformer_Values ()
    {
        return (EReference)compositeTransformerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAndTransformer ()
    {
        return andTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOrTransformer ()
    {
        return orTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextInputComponent ()
    {
        return textInputComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextInputComponent_Descriptor ()
    {
        return (EAttribute)textInputComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextInputComponent_ReadDescriptor ()
    {
        return (EAttribute)textInputComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWriteableComponent ()
    {
        return writeableComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWriteableComponent_Ceil ()
    {
        return (EAttribute)writeableComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWriteableComponent_Floor ()
    {
        return (EAttribute)writeableComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReadableComponent ()
    {
        return readableComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_Format ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_Decimal ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_Attribute ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_HdConnectionid ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_HdItemId ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextComponent ()
    {
        return textComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Descriptor ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Width ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Height ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Date ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_TextHeight ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_TextMap ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextInputMultiComponent ()
    {
        return textInputMultiComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextInputMultiComponent_Descriptor ()
    {
        return (EAttribute)textInputMultiComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCheckComponent ()
    {
        return checkComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_Format ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_Descriptor ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_Attribute ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_ReadDescriptor ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLinkComponent ()
    {
        return linkComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLinkComponent_Format ()
    {
        return (EAttribute)linkComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getURLImageComponent ()
    {
        return urlImageComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_Descriptor ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_ImageUrl ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_FallbackImageUrl ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_Width ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_Height ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProgressComponent ()
    {
        return progressComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Descriptor ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Factor ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Max ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Min ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Width ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHiddenComponent ()
    {
        return hiddenComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHiddenComponent_Descriptor ()
    {
        return (EAttribute)hiddenComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewFactory getDetailViewFactory ()
    {
        return (DetailViewFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        viewEClass = createEClass ( VIEW );
        createEReference ( viewEClass, VIEW__HEADER_COMPONENT );
        createEReference ( viewEClass, VIEW__GROUPS );
        createEReference ( viewEClass, VIEW__HIDDEN_COMPONENT );

        componentEClass = createEClass ( COMPONENT );

        groupEntryEClass = createEClass ( GROUP_ENTRY );
        createEReference ( groupEntryEClass, GROUP_ENTRY__COMPONENT );
        createEAttribute ( groupEntryEClass, GROUP_ENTRY__LABEL );
        createEAttribute ( groupEntryEClass, GROUP_ENTRY__PERMISSION );

        labelComponentEClass = createEClass ( LABEL_COMPONENT );
        createEAttribute ( labelComponentEClass, LABEL_COMPONENT__FORMAT );
        createEAttribute ( labelComponentEClass, LABEL_COMPONENT__DESCRIPTOR );

        compositeComponentEClass = createEClass ( COMPOSITE_COMPONENT );
        createEReference ( compositeComponentEClass, COMPOSITE_COMPONENT__CHILDREN );

        fillLayoutComponentEClass = createEClass ( FILL_LAYOUT_COMPONENT );

        buttonComponentEClass = createEClass ( BUTTON_COMPONENT );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__FORMAT );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__VALUE );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__READ_DESCRIPTOR );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__WRITE_DESCRIPTOR );
        createEReference ( buttonComponentEClass, BUTTON_COMPONENT__ACTIVE );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__ATTRIBUTE );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__TEXT_HEIGHT );

        boolLEDComponentEClass = createEClass ( BOOL_LED_COMPONENT );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__FORMAT );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__DESCRIPTOR );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__ALARM );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__ATTRIBUTE );

        valueSourceEClass = createEClass ( VALUE_SOURCE );

        itemValueSourceEClass = createEClass ( ITEM_VALUE_SOURCE );
        createEAttribute ( itemValueSourceEClass, ITEM_VALUE_SOURCE__VALUE_KEY );

        notTransformerEClass = createEClass ( NOT_TRANSFORMER );
        createEReference ( notTransformerEClass, NOT_TRANSFORMER__VALUE );

        genericComponentEClass = createEClass ( GENERIC_COMPONENT );
        createEReference ( genericComponentEClass, GENERIC_COMPONENT__REGISTRATIONS );

        registrationEClass = createEClass ( REGISTRATION );
        createEAttribute ( registrationEClass, REGISTRATION__KEY );
        createEAttribute ( registrationEClass, REGISTRATION__DESCRIPTOR );
        createEAttribute ( registrationEClass, REGISTRATION__AGGREGATE_STATE );

        simpleGridComponentEClass = createEClass ( SIMPLE_GRID_COMPONENT );
        createEAttribute ( simpleGridComponentEClass, SIMPLE_GRID_COMPONENT__EQUALLY );
        createEAttribute ( simpleGridComponentEClass, SIMPLE_GRID_COMPONENT__COLS );

        groupGridComponentEClass = createEClass ( GROUP_GRID_COMPONENT );
        createEReference ( groupGridComponentEClass, GROUP_GRID_COMPONENT__GROUPS );
        createEAttribute ( groupGridComponentEClass, GROUP_GRID_COMPONENT__EQUALLY );
        createEAttribute ( groupGridComponentEClass, GROUP_GRID_COMPONENT__COLS );

        groupGridEntryEClass = createEClass ( GROUP_GRID_ENTRY );
        createEAttribute ( groupGridEntryEClass, GROUP_GRID_ENTRY__LABEL );
        createEReference ( groupGridEntryEClass, GROUP_GRID_ENTRY__COMPONENTS );
        createEAttribute ( groupGridEntryEClass, GROUP_GRID_ENTRY__PERMISSION );

        valueSetComponentEClass = createEClass ( VALUE_SET_COMPONENT );
        createEAttribute ( valueSetComponentEClass, VALUE_SET_COMPONENT__VALUE_DESCRIPTOR );
        createEAttribute ( valueSetComponentEClass, VALUE_SET_COMPONENT__SET_DESCRIPTOR );
        createEAttribute ( valueSetComponentEClass, VALUE_SET_COMPONENT__RESET_DESCRIPTOR );

        valueComponentEClass = createEClass ( VALUE_COMPONENT );
        createEAttribute ( valueComponentEClass, VALUE_COMPONENT__DESCRIPTOR );
        createEAttribute ( valueComponentEClass, VALUE_COMPONENT__DATE );

        compositeTransformerEClass = createEClass ( COMPOSITE_TRANSFORMER );
        createEReference ( compositeTransformerEClass, COMPOSITE_TRANSFORMER__VALUES );

        andTransformerEClass = createEClass ( AND_TRANSFORMER );

        orTransformerEClass = createEClass ( OR_TRANSFORMER );

        textInputComponentEClass = createEClass ( TEXT_INPUT_COMPONENT );
        createEAttribute ( textInputComponentEClass, TEXT_INPUT_COMPONENT__DESCRIPTOR );
        createEAttribute ( textInputComponentEClass, TEXT_INPUT_COMPONENT__READ_DESCRIPTOR );

        writeableComponentEClass = createEClass ( WRITEABLE_COMPONENT );
        createEAttribute ( writeableComponentEClass, WRITEABLE_COMPONENT__CEIL );
        createEAttribute ( writeableComponentEClass, WRITEABLE_COMPONENT__FLOOR );

        readableComponentEClass = createEClass ( READABLE_COMPONENT );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__FORMAT );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__DECIMAL );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__ATTRIBUTE );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__HD_CONNECTIONID );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__HD_ITEM_ID );

        textComponentEClass = createEClass ( TEXT_COMPONENT );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__DESCRIPTOR );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__WIDTH );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__HEIGHT );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__DATE );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__TEXT_HEIGHT );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__TEXT_MAP );

        textInputMultiComponentEClass = createEClass ( TEXT_INPUT_MULTI_COMPONENT );
        createEAttribute ( textInputMultiComponentEClass, TEXT_INPUT_MULTI_COMPONENT__DESCRIPTOR );

        checkComponentEClass = createEClass ( CHECK_COMPONENT );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__FORMAT );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__DESCRIPTOR );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__ATTRIBUTE );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__READ_DESCRIPTOR );

        linkComponentEClass = createEClass ( LINK_COMPONENT );
        createEAttribute ( linkComponentEClass, LINK_COMPONENT__FORMAT );

        urlImageComponentEClass = createEClass ( URL_IMAGE_COMPONENT );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__DESCRIPTOR );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__IMAGE_URL );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__WIDTH );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__HEIGHT );

        progressComponentEClass = createEClass ( PROGRESS_COMPONENT );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__DESCRIPTOR );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__FACTOR );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__MAX );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__MIN );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__WIDTH );

        hiddenComponentEClass = createEClass ( HIDDEN_COMPONENT );
        createEAttribute ( hiddenComponentEClass, HIDDEN_COMPONENT__DESCRIPTOR );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        labelComponentEClass.getESuperTypes ().add ( this.getComponent () );
        compositeComponentEClass.getESuperTypes ().add ( this.getComponent () );
        fillLayoutComponentEClass.getESuperTypes ().add ( this.getCompositeComponent () );
        buttonComponentEClass.getESuperTypes ().add ( this.getGenericComponent () );
        boolLEDComponentEClass.getESuperTypes ().add ( this.getComponent () );
        itemValueSourceEClass.getESuperTypes ().add ( this.getValueSource () );
        notTransformerEClass.getESuperTypes ().add ( this.getValueSource () );
        genericComponentEClass.getESuperTypes ().add ( this.getComponent () );
        simpleGridComponentEClass.getESuperTypes ().add ( this.getCompositeComponent () );
        groupGridComponentEClass.getESuperTypes ().add ( this.getComponent () );
        valueSetComponentEClass.getESuperTypes ().add ( this.getWriteableComponent () );
        valueComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );
        compositeTransformerEClass.getESuperTypes ().add ( this.getValueSource () );
        andTransformerEClass.getESuperTypes ().add ( this.getCompositeTransformer () );
        orTransformerEClass.getESuperTypes ().add ( this.getCompositeTransformer () );
        textInputComponentEClass.getESuperTypes ().add ( this.getWriteableComponent () );
        writeableComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );
        readableComponentEClass.getESuperTypes ().add ( this.getComponent () );
        textComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );
        textInputMultiComponentEClass.getESuperTypes ().add ( this.getWriteableComponent () );
        checkComponentEClass.getESuperTypes ().add ( this.getComponent () );
        linkComponentEClass.getESuperTypes ().add ( this.getComponent () );
        urlImageComponentEClass.getESuperTypes ().add ( this.getComponent () );
        progressComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );

        // Initialize classes and features; add operations and parameters
        initEClass ( viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getView_HeaderComponent (), this.getComponent (), null, "headerComponent", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getView_Groups (), this.getGroupEntry (), null, "groups", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getView_HiddenComponent (), this.getHiddenComponent (), null, "hiddenComponent", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( groupEntryEClass, GroupEntry.class, "GroupEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getGroupEntry_Component (), this.getComponent (), null, "component", null, 1, 1, GroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getGroupEntry_Label (), ecorePackage.getEString (), "label", null, 0, 1, GroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getGroupEntry_Permission (), ecorePackage.getEString (), "permission", null, 0, 1, GroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( labelComponentEClass, LabelComponent.class, "LabelComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getLabelComponent_Format (), ecorePackage.getEString (), "format", "%s", 0, 1, LabelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getLabelComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, LabelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( compositeComponentEClass, CompositeComponent.class, "CompositeComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getCompositeComponent_Children (), this.getComponent (), null, "children", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( fillLayoutComponentEClass, FillLayoutComponent.class, "FillLayoutComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( buttonComponentEClass, ButtonComponent.class, "ButtonComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getButtonComponent_Format (), ecorePackage.getEString (), "format", null, 1, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getButtonComponent_Value (), ecorePackage.getEString (), "value", null, 1, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getButtonComponent_ReadDescriptor (), ecorePackage.getEString (), "readDescriptor", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getButtonComponent_WriteDescriptor (), ecorePackage.getEString (), "writeDescriptor", null, 1, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getButtonComponent_Active (), this.getValueSource (), null, "active", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getButtonComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getButtonComponent_TextHeight (), ecorePackage.getEInt (), "textHeight", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( boolLEDComponentEClass, BoolLEDComponent.class, "BoolLEDComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getBoolLEDComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getBoolLEDComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getBoolLEDComponent_Alarm (), ecorePackage.getEBoolean (), "alarm", null, 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getBoolLEDComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( valueSourceEClass, ValueSource.class, "ValueSource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( itemValueSourceEClass, ItemValueSource.class, "ItemValueSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getItemValueSource_ValueKey (), ecorePackage.getEString (), "valueKey", null, 1, 1, ItemValueSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( notTransformerEClass, NotTransformer.class, "NotTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getNotTransformer_Value (), this.getValueSource (), null, "value", null, 1, 1, NotTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( genericComponentEClass, GenericComponent.class, "GenericComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getGenericComponent_Registrations (), this.getRegistration (), null, "registrations", null, 0, -1, GenericComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( registrationEClass, Registration.class, "Registration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getRegistration_Key (), ecorePackage.getEString (), "key", null, 1, 1, Registration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getRegistration_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, Registration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getRegistration_AggregateState (), ecorePackage.getEBoolean (), "aggregateState", "true", 0, 1, Registration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( simpleGridComponentEClass, SimpleGridComponent.class, "SimpleGridComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getSimpleGridComponent_Equally (), ecorePackage.getEBoolean (), "equally", "true", 0, 1, SimpleGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getSimpleGridComponent_Cols (), ecorePackage.getEInt (), "cols", "2", 0, 1, SimpleGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( groupGridComponentEClass, GroupGridComponent.class, "GroupGridComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getGroupGridComponent_Groups (), this.getGroupGridEntry (), null, "groups", null, 0, -1, GroupGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getGroupGridComponent_Equally (), ecorePackage.getEBoolean (), "equally", "false", 1, 1, GroupGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getGroupGridComponent_Cols (), ecorePackage.getEInt (), "cols", "2", 1, 1, GroupGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( groupGridEntryEClass, GroupGridEntry.class, "GroupGridEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getGroupGridEntry_Label (), ecorePackage.getEString (), "label", null, 1, 1, GroupGridEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getGroupGridEntry_Components (), this.getComponent (), null, "components", null, 0, -1, GroupGridEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getGroupGridEntry_Permission (), ecorePackage.getEString (), "permission", null, 0, 1, GroupGridEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( valueSetComponentEClass, ValueSetComponent.class, "ValueSetComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getValueSetComponent_ValueDescriptor (), ecorePackage.getEString (), "valueDescriptor", null, 1, 1, ValueSetComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getValueSetComponent_SetDescriptor (), ecorePackage.getEString (), "setDescriptor", null, 0, 1, ValueSetComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getValueSetComponent_ResetDescriptor (), ecorePackage.getEString (), "resetDescriptor", null, 0, 1, ValueSetComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( valueComponentEClass, ValueComponent.class, "ValueComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getValueComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, ValueComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getValueComponent_Date (), ecorePackage.getEBooleanObject (), "date", null, 0, 1, ValueComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( compositeTransformerEClass, CompositeTransformer.class, "CompositeTransformer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getCompositeTransformer_Values (), this.getValueSource (), null, "values", null, 0, -1, CompositeTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( andTransformerEClass, AndTransformer.class, "AndTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( orTransformerEClass, OrTransformer.class, "OrTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( textInputComponentEClass, TextInputComponent.class, "TextInputComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getTextInputComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, TextInputComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getTextInputComponent_ReadDescriptor (), ecorePackage.getEString (), "readDescriptor", null, 0, 1, TextInputComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( writeableComponentEClass, WriteableComponent.class, "WriteableComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getWriteableComponent_Ceil (), ecorePackage.getEDoubleObject (), "ceil", null, 0, 1, WriteableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getWriteableComponent_Floor (), ecorePackage.getEDouble (), "floor", null, 0, 1, WriteableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( readableComponentEClass, ReadableComponent.class, "ReadableComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getReadableComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getReadableComponent_Decimal (), ecorePackage.getEString (), "decimal", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getReadableComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getReadableComponent_HdConnectionid (), ecorePackage.getEString (), "hdConnectionid", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getReadableComponent_HdItemId (), ecorePackage.getEString (), "hdItemId", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( textComponentEClass, TextComponent.class, "TextComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getTextComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getTextComponent_Width (), ecorePackage.getEInt (), "width", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getTextComponent_Height (), ecorePackage.getEInt (), "height", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getTextComponent_Date (), ecorePackage.getEBoolean (), "date", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getTextComponent_TextHeight (), ecorePackage.getEInt (), "textHeight", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getTextComponent_TextMap (), ecorePackage.getEString (), "textMap", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( textInputMultiComponentEClass, TextInputMultiComponent.class, "TextInputMultiComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getTextInputMultiComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, TextInputMultiComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( checkComponentEClass, CheckComponent.class, "CheckComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getCheckComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getCheckComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getCheckComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getCheckComponent_ReadDescriptor (), ecorePackage.getEString (), "readDescriptor", null, 0, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( linkComponentEClass, LinkComponent.class, "LinkComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getLinkComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, LinkComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( urlImageComponentEClass, URLImageComponent.class, "URLImageComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getURLImageComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getURLImageComponent_ImageUrl (), ecorePackage.getEString (), "imageUrl", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getURLImageComponent_FallbackImageUrl (), ecorePackage.getEString (), "fallbackImageUrl", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getURLImageComponent_Width (), ecorePackage.getEIntegerObject (), "width", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getURLImageComponent_Height (), ecorePackage.getEIntegerObject (), "height", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( progressComponentEClass, ProgressComponent.class, "ProgressComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getProgressComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProgressComponent_Factor (), ecorePackage.getEDouble (), "factor", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProgressComponent_Max (), ecorePackage.getEDouble (), "max", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProgressComponent_Min (), ecorePackage.getEDouble (), "min", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProgressComponent_Width (), ecorePackage.getEInt (), "width", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( hiddenComponentEClass, HiddenComponent.class, "HiddenComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getHiddenComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, HiddenComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        // Create resource
        createResource ( eNS_URI );
    }

} //DetailViewPackageImpl
