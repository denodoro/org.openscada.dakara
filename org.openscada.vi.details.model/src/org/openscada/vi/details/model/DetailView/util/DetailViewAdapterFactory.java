/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.openscada.vi.details.model.DetailView.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.openscada.vi.details.model.DetailView.DetailViewPackage
 * @generated
 */
public class DetailViewAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DetailViewPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = DetailViewPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DetailViewSwitch<Adapter> modelSwitch = new DetailViewSwitch<Adapter> () {
        @Override
        public Adapter caseView ( View object )
        {
            return createViewAdapter ();
        }

        @Override
        public Adapter caseComponent ( Component object )
        {
            return createComponentAdapter ();
        }

        @Override
        public Adapter caseGroupEntry ( GroupEntry object )
        {
            return createGroupEntryAdapter ();
        }

        @Override
        public Adapter caseLabelComponent ( LabelComponent object )
        {
            return createLabelComponentAdapter ();
        }

        @Override
        public Adapter caseCompositeComponent ( CompositeComponent object )
        {
            return createCompositeComponentAdapter ();
        }

        @Override
        public Adapter caseFillLayoutComponent ( FillLayoutComponent object )
        {
            return createFillLayoutComponentAdapter ();
        }

        @Override
        public Adapter caseButtonComponent ( ButtonComponent object )
        {
            return createButtonComponentAdapter ();
        }

        @Override
        public Adapter caseBoolLEDComponent ( BoolLEDComponent object )
        {
            return createBoolLEDComponentAdapter ();
        }

        @Override
        public Adapter caseValueSource ( ValueSource object )
        {
            return createValueSourceAdapter ();
        }

        @Override
        public Adapter caseItemValueSource ( ItemValueSource object )
        {
            return createItemValueSourceAdapter ();
        }

        @Override
        public Adapter caseNotTransformer ( NotTransformer object )
        {
            return createNotTransformerAdapter ();
        }

        @Override
        public Adapter caseGenericComponent ( GenericComponent object )
        {
            return createGenericComponentAdapter ();
        }

        @Override
        public Adapter caseRegistration ( Registration object )
        {
            return createRegistrationAdapter ();
        }

        @Override
        public Adapter caseSimpleGridComponent ( SimpleGridComponent object )
        {
            return createSimpleGridComponentAdapter ();
        }

        @Override
        public Adapter caseGroupGridComponent ( GroupGridComponent object )
        {
            return createGroupGridComponentAdapter ();
        }

        @Override
        public Adapter caseGroupGridEntry ( GroupGridEntry object )
        {
            return createGroupGridEntryAdapter ();
        }

        @Override
        public Adapter caseValueSetComponent ( ValueSetComponent object )
        {
            return createValueSetComponentAdapter ();
        }

        @Override
        public Adapter caseValueComponent ( ValueComponent object )
        {
            return createValueComponentAdapter ();
        }

        @Override
        public Adapter caseCompositeTransformer ( CompositeTransformer object )
        {
            return createCompositeTransformerAdapter ();
        }

        @Override
        public Adapter caseAndTransformer ( AndTransformer object )
        {
            return createAndTransformerAdapter ();
        }

        @Override
        public Adapter caseOrTransformer ( OrTransformer object )
        {
            return createOrTransformerAdapter ();
        }

        @Override
        public Adapter caseTextInputComponent ( TextInputComponent object )
        {
            return createTextInputComponentAdapter ();
        }

        @Override
        public Adapter caseWriteableComponent ( WriteableComponent object )
        {
            return createWriteableComponentAdapter ();
        }

        @Override
        public Adapter caseReadableComponent ( ReadableComponent object )
        {
            return createReadableComponentAdapter ();
        }

        @Override
        public Adapter caseTextComponent ( TextComponent object )
        {
            return createTextComponentAdapter ();
        }

        @Override
        public Adapter caseTextInputMultiComponent ( TextInputMultiComponent object )
        {
            return createTextInputMultiComponentAdapter ();
        }

        @Override
        public Adapter caseCheckComponent ( CheckComponent object )
        {
            return createCheckComponentAdapter ();
        }

        @Override
        public Adapter caseLinkComponent ( LinkComponent object )
        {
            return createLinkComponentAdapter ();
        }

        @Override
        public Adapter caseURLImageComponent ( URLImageComponent object )
        {
            return createURLImageComponentAdapter ();
        }

        @Override
        public Adapter caseProgressComponent ( ProgressComponent object )
        {
            return createProgressComponentAdapter ();
        }

        @Override
        public Adapter caseHiddenComponent ( HiddenComponent object )
        {
            return createHiddenComponentAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.View <em>View</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.View
     * @generated
     */
    public Adapter createViewAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.Component
     * @generated
     */
    public Adapter createComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.GroupEntry <em>Group Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.GroupEntry
     * @generated
     */
    public Adapter createGroupEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.LabelComponent <em>Label Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.LabelComponent
     * @generated
     */
    public Adapter createLabelComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.CompositeComponent <em>Composite Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.CompositeComponent
     * @generated
     */
    public Adapter createCompositeComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.FillLayoutComponent <em>Fill Layout Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.FillLayoutComponent
     * @generated
     */
    public Adapter createFillLayoutComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.ButtonComponent <em>Button Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent
     * @generated
     */
    public Adapter createButtonComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.BoolLEDComponent <em>Bool LED Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.BoolLEDComponent
     * @generated
     */
    public Adapter createBoolLEDComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.ValueSource <em>Value Source</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.ValueSource
     * @generated
     */
    public Adapter createValueSourceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.ItemValueSource <em>Item Value Source</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.ItemValueSource
     * @generated
     */
    public Adapter createItemValueSourceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.NotTransformer <em>Not Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.NotTransformer
     * @generated
     */
    public Adapter createNotTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.GenericComponent <em>Generic Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.GenericComponent
     * @generated
     */
    public Adapter createGenericComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.Registration <em>Registration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.Registration
     * @generated
     */
    public Adapter createRegistrationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent <em>Simple Grid Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.SimpleGridComponent
     * @generated
     */
    public Adapter createSimpleGridComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.GroupGridComponent <em>Group Grid Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.GroupGridComponent
     * @generated
     */
    public Adapter createGroupGridComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.GroupGridEntry <em>Group Grid Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.GroupGridEntry
     * @generated
     */
    public Adapter createGroupGridEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent <em>Value Set Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.ValueSetComponent
     * @generated
     */
    public Adapter createValueSetComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.ValueComponent <em>Value Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.ValueComponent
     * @generated
     */
    public Adapter createValueComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.CompositeTransformer <em>Composite Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.CompositeTransformer
     * @generated
     */
    public Adapter createCompositeTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.AndTransformer <em>And Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.AndTransformer
     * @generated
     */
    public Adapter createAndTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.OrTransformer <em>Or Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.OrTransformer
     * @generated
     */
    public Adapter createOrTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.TextInputComponent <em>Text Input Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.TextInputComponent
     * @generated
     */
    public Adapter createTextInputComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.WriteableComponent <em>Writeable Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.WriteableComponent
     * @generated
     */
    public Adapter createWriteableComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.ReadableComponent <em>Readable Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.ReadableComponent
     * @generated
     */
    public Adapter createReadableComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.TextComponent <em>Text Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.TextComponent
     * @generated
     */
    public Adapter createTextComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.TextInputMultiComponent <em>Text Input Multi Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.TextInputMultiComponent
     * @generated
     */
    public Adapter createTextInputMultiComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.CheckComponent <em>Check Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.CheckComponent
     * @generated
     */
    public Adapter createCheckComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.LinkComponent <em>Link Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.LinkComponent
     * @generated
     */
    public Adapter createLinkComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.URLImageComponent <em>URL Image Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.URLImageComponent
     * @generated
     */
    public Adapter createURLImageComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.ProgressComponent <em>Progress Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.ProgressComponent
     * @generated
     */
    public Adapter createProgressComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.vi.details.model.DetailView.HiddenComponent <em>Hidden Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.vi.details.model.DetailView.HiddenComponent
     * @generated
     */
    public Adapter createHiddenComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //DetailViewAdapterFactory
