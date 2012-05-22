/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.openscada.vi.details.model.DetailView.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DetailViewFactoryImpl extends EFactoryImpl implements DetailViewFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DetailViewFactory init ()
    {
        try
        {
            DetailViewFactory theDetailViewFactory = (DetailViewFactory)EPackage.Registry.INSTANCE.getEFactory ( "http://th4-systems.com/VIMS/DetailView/1.0" );
            if ( theDetailViewFactory != null )
            {
                return theDetailViewFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new DetailViewFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case DetailViewPackage.VIEW:
                return createView ();
            case DetailViewPackage.GROUP_ENTRY:
                return createGroupEntry ();
            case DetailViewPackage.LABEL_COMPONENT:
                return createLabelComponent ();
            case DetailViewPackage.FILL_LAYOUT_COMPONENT:
                return createFillLayoutComponent ();
            case DetailViewPackage.BUTTON_COMPONENT:
                return createButtonComponent ();
            case DetailViewPackage.BOOL_LED_COMPONENT:
                return createBoolLEDComponent ();
            case DetailViewPackage.ITEM_VALUE_SOURCE:
                return createItemValueSource ();
            case DetailViewPackage.NOT_TRANSFORMER:
                return createNotTransformer ();
            case DetailViewPackage.REGISTRATION:
                return createRegistration ();
            case DetailViewPackage.SIMPLE_GRID_COMPONENT:
                return createSimpleGridComponent ();
            case DetailViewPackage.GROUP_GRID_COMPONENT:
                return createGroupGridComponent ();
            case DetailViewPackage.GROUP_GRID_ENTRY:
                return createGroupGridEntry ();
            case DetailViewPackage.VALUE_SET_COMPONENT:
                return createValueSetComponent ();
            case DetailViewPackage.VALUE_COMPONENT:
                return createValueComponent ();
            case DetailViewPackage.AND_TRANSFORMER:
                return createAndTransformer ();
            case DetailViewPackage.OR_TRANSFORMER:
                return createOrTransformer ();
            case DetailViewPackage.TEXT_INPUT_COMPONENT:
                return createTextInputComponent ();
            case DetailViewPackage.TEXT_COMPONENT:
                return createTextComponent ();
            case DetailViewPackage.TEXT_INPUT_MULTI_COMPONENT:
                return createTextInputMultiComponent ();
            case DetailViewPackage.CHECK_COMPONENT:
                return createCheckComponent ();
            case DetailViewPackage.LINK_COMPONENT:
                return createLinkComponent ();
            case DetailViewPackage.URL_IMAGE_COMPONENT:
                return createURLImageComponent ();
            case DetailViewPackage.PROGRESS_COMPONENT:
                return createProgressComponent ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public View createView ()
    {
        ViewImpl view = new ViewImpl ();
        return view;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupEntry createGroupEntry ()
    {
        GroupEntryImpl groupEntry = new GroupEntryImpl ();
        return groupEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LabelComponent createLabelComponent ()
    {
        LabelComponentImpl labelComponent = new LabelComponentImpl ();
        return labelComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FillLayoutComponent createFillLayoutComponent ()
    {
        FillLayoutComponentImpl fillLayoutComponent = new FillLayoutComponentImpl ();
        return fillLayoutComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ButtonComponent createButtonComponent ()
    {
        ButtonComponentImpl buttonComponent = new ButtonComponentImpl ();
        return buttonComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BoolLEDComponent createBoolLEDComponent ()
    {
        BoolLEDComponentImpl boolLEDComponent = new BoolLEDComponentImpl ();
        return boolLEDComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemValueSource createItemValueSource ()
    {
        ItemValueSourceImpl itemValueSource = new ItemValueSourceImpl ();
        return itemValueSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotTransformer createNotTransformer ()
    {
        NotTransformerImpl notTransformer = new NotTransformerImpl ();
        return notTransformer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Registration createRegistration ()
    {
        RegistrationImpl registration = new RegistrationImpl ();
        return registration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimpleGridComponent createSimpleGridComponent ()
    {
        SimpleGridComponentImpl simpleGridComponent = new SimpleGridComponentImpl ();
        return simpleGridComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupGridComponent createGroupGridComponent ()
    {
        GroupGridComponentImpl groupGridComponent = new GroupGridComponentImpl ();
        return groupGridComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupGridEntry createGroupGridEntry ()
    {
        GroupGridEntryImpl groupGridEntry = new GroupGridEntryImpl ();
        return groupGridEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueSetComponent createValueSetComponent ()
    {
        ValueSetComponentImpl valueSetComponent = new ValueSetComponentImpl ();
        return valueSetComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueComponent createValueComponent ()
    {
        ValueComponentImpl valueComponent = new ValueComponentImpl ();
        return valueComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AndTransformer createAndTransformer ()
    {
        AndTransformerImpl andTransformer = new AndTransformerImpl ();
        return andTransformer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OrTransformer createOrTransformer ()
    {
        OrTransformerImpl orTransformer = new OrTransformerImpl ();
        return orTransformer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextInputComponent createTextInputComponent ()
    {
        TextInputComponentImpl textInputComponent = new TextInputComponentImpl ();
        return textInputComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextComponent createTextComponent ()
    {
        TextComponentImpl textComponent = new TextComponentImpl ();
        return textComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextInputMultiComponent createTextInputMultiComponent ()
    {
        TextInputMultiComponentImpl textInputMultiComponent = new TextInputMultiComponentImpl ();
        return textInputMultiComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CheckComponent createCheckComponent ()
    {
        CheckComponentImpl checkComponent = new CheckComponentImpl ();
        return checkComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkComponent createLinkComponent ()
    {
        LinkComponentImpl linkComponent = new LinkComponentImpl ();
        return linkComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public URLImageComponent createURLImageComponent ()
    {
        URLImageComponentImpl urlImageComponent = new URLImageComponentImpl ();
        return urlImageComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProgressComponent createProgressComponent ()
    {
        ProgressComponentImpl progressComponent = new ProgressComponentImpl ();
        return progressComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewPackage getDetailViewPackage ()
    {
        return (DetailViewPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DetailViewPackage getPackage ()
    {
        return DetailViewPackage.eINSTANCE;
    }

} //DetailViewFactoryImpl
