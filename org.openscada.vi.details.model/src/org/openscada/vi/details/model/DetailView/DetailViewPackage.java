/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openscada.vi.details.model.DetailView;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.openscada.vi.details.model.DetailView.DetailViewFactory
 * @model kind="package"
 * @generated
 */
public interface DetailViewPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "DetailView";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://th4-systems.com/VIMS/DetailView/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "detailView";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DetailViewPackage eINSTANCE = org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ViewImpl <em>View</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ViewImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getView()
     * @generated
     */
    int VIEW = 0;

    /**
     * The feature id for the '<em><b>Header Component</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW__HEADER_COMPONENT = 0;

    /**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW__GROUPS = 1;

    /**
     * The number of structural features of the '<em>View</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getComponent()
     * @generated
     */
    int COMPONENT = 1;

    /**
     * The number of structural features of the '<em>Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl <em>Group Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGroupEntry()
     * @generated
     */
    int GROUP_ENTRY = 2;

    /**
     * The feature id for the '<em><b>Component</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_ENTRY__COMPONENT = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_ENTRY__LABEL = 1;

    /**
     * The feature id for the '<em><b>Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_ENTRY__PERMISSION = 2;

    /**
     * The number of structural features of the '<em>Group Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_ENTRY_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.LabelComponentImpl <em>Label Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.LabelComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getLabelComponent()
     * @generated
     */
    int LABEL_COMPONENT = 3;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LABEL_COMPONENT__FORMAT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LABEL_COMPONENT__DESCRIPTOR = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Label Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LABEL_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.CompositeComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getCompositeComponent()
     * @generated
     */
    int COMPOSITE_COMPONENT = 4;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_COMPONENT__CHILDREN = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Composite Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.FillLayoutComponentImpl <em>Fill Layout Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.FillLayoutComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getFillLayoutComponent()
     * @generated
     */
    int FILL_LAYOUT_COMPONENT = 5;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILL_LAYOUT_COMPONENT__CHILDREN = COMPOSITE_COMPONENT__CHILDREN;

    /**
     * The number of structural features of the '<em>Fill Layout Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILL_LAYOUT_COMPONENT_FEATURE_COUNT = COMPOSITE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.GenericComponentImpl <em>Generic Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.GenericComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGenericComponent()
     * @generated
     */
    int GENERIC_COMPONENT = 11;

    /**
     * The feature id for the '<em><b>Registrations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_COMPONENT__REGISTRATIONS = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Generic Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ButtonComponentImpl <em>Button Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ButtonComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getButtonComponent()
     * @generated
     */
    int BUTTON_COMPONENT = 6;

    /**
     * The feature id for the '<em><b>Registrations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__REGISTRATIONS = GENERIC_COMPONENT__REGISTRATIONS;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__FORMAT = GENERIC_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__VALUE = GENERIC_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Read Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__READ_DESCRIPTOR = GENERIC_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Write Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__WRITE_DESCRIPTOR = GENERIC_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Active</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__ACTIVE = GENERIC_COMPONENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__ATTRIBUTE = GENERIC_COMPONENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Text Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT__TEXT_HEIGHT = GENERIC_COMPONENT_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Button Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUTTON_COMPONENT_FEATURE_COUNT = GENERIC_COMPONENT_FEATURE_COUNT + 7;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.BoolLEDComponentImpl <em>Bool LED Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.BoolLEDComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getBoolLEDComponent()
     * @generated
     */
    int BOOL_LED_COMPONENT = 7;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOL_LED_COMPONENT__FORMAT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOL_LED_COMPONENT__DESCRIPTOR = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Alarm</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOL_LED_COMPONENT__ALARM = COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOL_LED_COMPONENT__ATTRIBUTE = COMPONENT_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Bool LED Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOL_LED_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ValueSourceImpl <em>Value Source</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ValueSourceImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getValueSource()
     * @generated
     */
    int VALUE_SOURCE = 8;

    /**
     * The number of structural features of the '<em>Value Source</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SOURCE_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ItemValueSourceImpl <em>Item Value Source</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ItemValueSourceImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getItemValueSource()
     * @generated
     */
    int ITEM_VALUE_SOURCE = 9;

    /**
     * The feature id for the '<em><b>Value Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_VALUE_SOURCE__VALUE_KEY = VALUE_SOURCE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Item Value Source</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_VALUE_SOURCE_FEATURE_COUNT = VALUE_SOURCE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.NotTransformerImpl <em>Not Transformer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.NotTransformerImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getNotTransformer()
     * @generated
     */
    int NOT_TRANSFORMER = 10;

    /**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NOT_TRANSFORMER__VALUE = VALUE_SOURCE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Not Transformer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NOT_TRANSFORMER_FEATURE_COUNT = VALUE_SOURCE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.RegistrationImpl <em>Registration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.RegistrationImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getRegistration()
     * @generated
     */
    int REGISTRATION = 12;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REGISTRATION__KEY = 0;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REGISTRATION__DESCRIPTOR = 1;

    /**
     * The feature id for the '<em><b>Aggregate State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REGISTRATION__AGGREGATE_STATE = 2;

    /**
     * The number of structural features of the '<em>Registration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REGISTRATION_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.SimpleGridComponentImpl <em>Simple Grid Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.SimpleGridComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getSimpleGridComponent()
     * @generated
     */
    int SIMPLE_GRID_COMPONENT = 13;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_GRID_COMPONENT__CHILDREN = COMPOSITE_COMPONENT__CHILDREN;

    /**
     * The feature id for the '<em><b>Equally</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_GRID_COMPONENT__EQUALLY = COMPOSITE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Cols</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_GRID_COMPONENT__COLS = COMPOSITE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Simple Grid Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_GRID_COMPONENT_FEATURE_COUNT = COMPOSITE_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.GroupGridComponentImpl <em>Group Grid Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.GroupGridComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGroupGridComponent()
     * @generated
     */
    int GROUP_GRID_COMPONENT = 14;

    /**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_COMPONENT__GROUPS = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Equally</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_COMPONENT__EQUALLY = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Cols</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_COMPONENT__COLS = COMPONENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Group Grid Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.GroupGridEntryImpl <em>Group Grid Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.GroupGridEntryImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGroupGridEntry()
     * @generated
     */
    int GROUP_GRID_ENTRY = 15;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_ENTRY__LABEL = 0;

    /**
     * The feature id for the '<em><b>Components</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_ENTRY__COMPONENTS = 1;

    /**
     * The feature id for the '<em><b>Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_ENTRY__PERMISSION = 2;

    /**
     * The number of structural features of the '<em>Group Grid Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_GRID_ENTRY_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl <em>Readable Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getReadableComponent()
     * @generated
     */
    int READABLE_COMPONENT = 23;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int READABLE_COMPONENT__FORMAT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int READABLE_COMPONENT__DECIMAL = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int READABLE_COMPONENT__ATTRIBUTE = COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int READABLE_COMPONENT__HD_CONNECTIONID = COMPONENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int READABLE_COMPONENT__HD_ITEM_ID = COMPONENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Readable Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int READABLE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.WriteableComponentImpl <em>Writeable Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.WriteableComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getWriteableComponent()
     * @generated
     */
    int WRITEABLE_COMPONENT = 22;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT__FORMAT = READABLE_COMPONENT__FORMAT;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT__DECIMAL = READABLE_COMPONENT__DECIMAL;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT__ATTRIBUTE = READABLE_COMPONENT__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT__HD_CONNECTIONID = READABLE_COMPONENT__HD_CONNECTIONID;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT__HD_ITEM_ID = READABLE_COMPONENT__HD_ITEM_ID;

    /**
     * The feature id for the '<em><b>Ceil</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT__CEIL = READABLE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Floor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT__FLOOR = READABLE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Writeable Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WRITEABLE_COMPONENT_FEATURE_COUNT = READABLE_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ValueSetComponentImpl <em>Value Set Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ValueSetComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getValueSetComponent()
     * @generated
     */
    int VALUE_SET_COMPONENT = 16;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__FORMAT = WRITEABLE_COMPONENT__FORMAT;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__DECIMAL = WRITEABLE_COMPONENT__DECIMAL;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__ATTRIBUTE = WRITEABLE_COMPONENT__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__HD_CONNECTIONID = WRITEABLE_COMPONENT__HD_CONNECTIONID;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__HD_ITEM_ID = WRITEABLE_COMPONENT__HD_ITEM_ID;

    /**
     * The feature id for the '<em><b>Ceil</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__CEIL = WRITEABLE_COMPONENT__CEIL;

    /**
     * The feature id for the '<em><b>Floor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__FLOOR = WRITEABLE_COMPONENT__FLOOR;

    /**
     * The feature id for the '<em><b>Value Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__VALUE_DESCRIPTOR = WRITEABLE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Set Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__SET_DESCRIPTOR = WRITEABLE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Reset Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT__RESET_DESCRIPTOR = WRITEABLE_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Value Set Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_SET_COMPONENT_FEATURE_COUNT = WRITEABLE_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ValueComponentImpl <em>Value Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ValueComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getValueComponent()
     * @generated
     */
    int VALUE_COMPONENT = 17;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT__FORMAT = READABLE_COMPONENT__FORMAT;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT__DECIMAL = READABLE_COMPONENT__DECIMAL;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT__ATTRIBUTE = READABLE_COMPONENT__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT__HD_CONNECTIONID = READABLE_COMPONENT__HD_CONNECTIONID;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT__HD_ITEM_ID = READABLE_COMPONENT__HD_ITEM_ID;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT__DESCRIPTOR = READABLE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT__DATE = READABLE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Value Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_COMPONENT_FEATURE_COUNT = READABLE_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.CompositeTransformerImpl <em>Composite Transformer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.CompositeTransformerImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getCompositeTransformer()
     * @generated
     */
    int COMPOSITE_TRANSFORMER = 18;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_TRANSFORMER__VALUES = VALUE_SOURCE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Composite Transformer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_TRANSFORMER_FEATURE_COUNT = VALUE_SOURCE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.AndTransformerImpl <em>And Transformer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.AndTransformerImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getAndTransformer()
     * @generated
     */
    int AND_TRANSFORMER = 19;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_TRANSFORMER__VALUES = COMPOSITE_TRANSFORMER__VALUES;

    /**
     * The number of structural features of the '<em>And Transformer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AND_TRANSFORMER_FEATURE_COUNT = COMPOSITE_TRANSFORMER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.OrTransformerImpl <em>Or Transformer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.OrTransformerImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getOrTransformer()
     * @generated
     */
    int OR_TRANSFORMER = 20;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OR_TRANSFORMER__VALUES = COMPOSITE_TRANSFORMER__VALUES;

    /**
     * The number of structural features of the '<em>Or Transformer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OR_TRANSFORMER_FEATURE_COUNT = COMPOSITE_TRANSFORMER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.TextInputComponentImpl <em>Text Input Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.TextInputComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getTextInputComponent()
     * @generated
     */
    int TEXT_INPUT_COMPONENT = 21;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__FORMAT = WRITEABLE_COMPONENT__FORMAT;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__DECIMAL = WRITEABLE_COMPONENT__DECIMAL;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__ATTRIBUTE = WRITEABLE_COMPONENT__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__HD_CONNECTIONID = WRITEABLE_COMPONENT__HD_CONNECTIONID;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__HD_ITEM_ID = WRITEABLE_COMPONENT__HD_ITEM_ID;

    /**
     * The feature id for the '<em><b>Ceil</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__CEIL = WRITEABLE_COMPONENT__CEIL;

    /**
     * The feature id for the '<em><b>Floor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__FLOOR = WRITEABLE_COMPONENT__FLOOR;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__DESCRIPTOR = WRITEABLE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Read Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT__READ_DESCRIPTOR = WRITEABLE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Text Input Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_COMPONENT_FEATURE_COUNT = WRITEABLE_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.TextComponentImpl <em>Text Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.TextComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getTextComponent()
     * @generated
     */
    int TEXT_COMPONENT = 24;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__FORMAT = READABLE_COMPONENT__FORMAT;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__DECIMAL = READABLE_COMPONENT__DECIMAL;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__ATTRIBUTE = READABLE_COMPONENT__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__HD_CONNECTIONID = READABLE_COMPONENT__HD_CONNECTIONID;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__HD_ITEM_ID = READABLE_COMPONENT__HD_ITEM_ID;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__DESCRIPTOR = READABLE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__WIDTH = READABLE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__HEIGHT = READABLE_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__DATE = READABLE_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Text Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__TEXT_HEIGHT = READABLE_COMPONENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Text Map</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT__TEXT_MAP = READABLE_COMPONENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Text Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_COMPONENT_FEATURE_COUNT = READABLE_COMPONENT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.TextInputMultiComponentImpl <em>Text Input Multi Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.TextInputMultiComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getTextInputMultiComponent()
     * @generated
     */
    int TEXT_INPUT_MULTI_COMPONENT = 25;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__FORMAT = WRITEABLE_COMPONENT__FORMAT;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__DECIMAL = WRITEABLE_COMPONENT__DECIMAL;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__ATTRIBUTE = WRITEABLE_COMPONENT__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__HD_CONNECTIONID = WRITEABLE_COMPONENT__HD_CONNECTIONID;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__HD_ITEM_ID = WRITEABLE_COMPONENT__HD_ITEM_ID;

    /**
     * The feature id for the '<em><b>Ceil</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__CEIL = WRITEABLE_COMPONENT__CEIL;

    /**
     * The feature id for the '<em><b>Floor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__FLOOR = WRITEABLE_COMPONENT__FLOOR;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT__DESCRIPTOR = WRITEABLE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Text Input Multi Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_INPUT_MULTI_COMPONENT_FEATURE_COUNT = WRITEABLE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.CheckComponentImpl <em>Check Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.CheckComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getCheckComponent()
     * @generated
     */
    int CHECK_COMPONENT = 26;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_COMPONENT__FORMAT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_COMPONENT__DESCRIPTOR = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_COMPONENT__ATTRIBUTE = COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Read Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_COMPONENT__READ_DESCRIPTOR = COMPONENT_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Check Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHECK_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.LinkComponentImpl <em>Link Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.LinkComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getLinkComponent()
     * @generated
     */
    int LINK_COMPONENT = 27;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_COMPONENT__FORMAT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Link Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.URLImageComponentImpl <em>URL Image Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.URLImageComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getURLImageComponent()
     * @generated
     */
    int URL_IMAGE_COMPONENT = 28;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_IMAGE_COMPONENT__DESCRIPTOR = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Image Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_IMAGE_COMPONENT__IMAGE_URL = COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Fallback Image Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL = COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_IMAGE_COMPONENT__WIDTH = COMPONENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_IMAGE_COMPONENT__HEIGHT = COMPONENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>URL Image Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_IMAGE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl <em>Progress Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getProgressComponent()
     * @generated
     */
    int PROGRESS_COMPONENT = 29;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__FORMAT = READABLE_COMPONENT__FORMAT;

    /**
     * The feature id for the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__DECIMAL = READABLE_COMPONENT__DECIMAL;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__ATTRIBUTE = READABLE_COMPONENT__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Hd Connectionid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__HD_CONNECTIONID = READABLE_COMPONENT__HD_CONNECTIONID;

    /**
     * The feature id for the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__HD_ITEM_ID = READABLE_COMPONENT__HD_ITEM_ID;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__DESCRIPTOR = READABLE_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Factor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__FACTOR = READABLE_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__MAX = READABLE_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Min</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__MIN = READABLE_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT__WIDTH = READABLE_COMPONENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Progress Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROGRESS_COMPONENT_FEATURE_COUNT = READABLE_COMPONENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.openscada.vi.details.model.DetailView.impl.HiddenComponentImpl <em>Hidden Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.openscada.vi.details.model.DetailView.impl.HiddenComponentImpl
     * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getHiddenComponent()
     * @generated
     */
    int HIDDEN_COMPONENT = 30;

    /**
     * The feature id for the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_COMPONENT__DESCRIPTOR = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Hidden Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIDDEN_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.View <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View</em>'.
     * @see org.openscada.vi.details.model.DetailView.View
     * @generated
     */
    EClass getView ();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.details.model.DetailView.View#getHeaderComponent <em>Header Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Header Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.View#getHeaderComponent()
     * @see #getView()
     * @generated
     */
    EReference getView_HeaderComponent ();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.details.model.DetailView.View#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Groups</em>'.
     * @see org.openscada.vi.details.model.DetailView.View#getGroups()
     * @see #getView()
     * @generated
     */
    EReference getView_Groups ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.Component
     * @generated
     */
    EClass getComponent ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.GroupEntry <em>Group Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group Entry</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupEntry
     * @generated
     */
    EClass getGroupEntry ();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.details.model.DetailView.GroupEntry#getComponent <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupEntry#getComponent()
     * @see #getGroupEntry()
     * @generated
     */
    EReference getGroupEntry_Component ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.GroupEntry#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupEntry#getLabel()
     * @see #getGroupEntry()
     * @generated
     */
    EAttribute getGroupEntry_Label ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.GroupEntry#getPermission <em>Permission</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Permission</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupEntry#getPermission()
     * @see #getGroupEntry()
     * @generated
     */
    EAttribute getGroupEntry_Permission ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.LabelComponent <em>Label Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Label Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.LabelComponent
     * @generated
     */
    EClass getLabelComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.LabelComponent#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.openscada.vi.details.model.DetailView.LabelComponent#getFormat()
     * @see #getLabelComponent()
     * @generated
     */
    EAttribute getLabelComponent_Format ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.LabelComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.LabelComponent#getDescriptor()
     * @see #getLabelComponent()
     * @generated
     */
    EAttribute getLabelComponent_Descriptor ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.CompositeComponent <em>Composite Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Composite Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.CompositeComponent
     * @generated
     */
    EClass getCompositeComponent ();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.details.model.DetailView.CompositeComponent#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.openscada.vi.details.model.DetailView.CompositeComponent#getChildren()
     * @see #getCompositeComponent()
     * @generated
     */
    EReference getCompositeComponent_Children ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.FillLayoutComponent <em>Fill Layout Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Fill Layout Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.FillLayoutComponent
     * @generated
     */
    EClass getFillLayoutComponent ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.ButtonComponent <em>Button Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Button Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent
     * @generated
     */
    EClass getButtonComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent#getFormat()
     * @see #getButtonComponent()
     * @generated
     */
    EAttribute getButtonComponent_Format ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent#getValue()
     * @see #getButtonComponent()
     * @generated
     */
    EAttribute getButtonComponent_Value ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getReadDescriptor <em>Read Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent#getReadDescriptor()
     * @see #getButtonComponent()
     * @generated
     */
    EAttribute getButtonComponent_ReadDescriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getWriteDescriptor <em>Write Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Write Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent#getWriteDescriptor()
     * @see #getButtonComponent()
     * @generated
     */
    EAttribute getButtonComponent_WriteDescriptor ();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Active</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent#getActive()
     * @see #getButtonComponent()
     * @generated
     */
    EReference getButtonComponent_Active ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent#getAttribute()
     * @see #getButtonComponent()
     * @generated
     */
    EAttribute getButtonComponent_Attribute ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ButtonComponent#getTextHeight <em>Text Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Height</em>'.
     * @see org.openscada.vi.details.model.DetailView.ButtonComponent#getTextHeight()
     * @see #getButtonComponent()
     * @generated
     */
    EAttribute getButtonComponent_TextHeight ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.BoolLEDComponent <em>Bool LED Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Bool LED Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.BoolLEDComponent
     * @generated
     */
    EClass getBoolLEDComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.BoolLEDComponent#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.openscada.vi.details.model.DetailView.BoolLEDComponent#getFormat()
     * @see #getBoolLEDComponent()
     * @generated
     */
    EAttribute getBoolLEDComponent_Format ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.BoolLEDComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.BoolLEDComponent#getDescriptor()
     * @see #getBoolLEDComponent()
     * @generated
     */
    EAttribute getBoolLEDComponent_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.BoolLEDComponent#isAlarm <em>Alarm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Alarm</em>'.
     * @see org.openscada.vi.details.model.DetailView.BoolLEDComponent#isAlarm()
     * @see #getBoolLEDComponent()
     * @generated
     */
    EAttribute getBoolLEDComponent_Alarm ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.BoolLEDComponent#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute</em>'.
     * @see org.openscada.vi.details.model.DetailView.BoolLEDComponent#getAttribute()
     * @see #getBoolLEDComponent()
     * @generated
     */
    EAttribute getBoolLEDComponent_Attribute ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.ValueSource <em>Value Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Source</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueSource
     * @generated
     */
    EClass getValueSource ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.ItemValueSource <em>Item Value Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Value Source</em>'.
     * @see org.openscada.vi.details.model.DetailView.ItemValueSource
     * @generated
     */
    EClass getItemValueSource ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ItemValueSource#getValueKey <em>Value Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value Key</em>'.
     * @see org.openscada.vi.details.model.DetailView.ItemValueSource#getValueKey()
     * @see #getItemValueSource()
     * @generated
     */
    EAttribute getItemValueSource_ValueKey ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.NotTransformer <em>Not Transformer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Not Transformer</em>'.
     * @see org.openscada.vi.details.model.DetailView.NotTransformer
     * @generated
     */
    EClass getNotTransformer ();

    /**
     * Returns the meta object for the containment reference '{@link org.openscada.vi.details.model.DetailView.NotTransformer#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see org.openscada.vi.details.model.DetailView.NotTransformer#getValue()
     * @see #getNotTransformer()
     * @generated
     */
    EReference getNotTransformer_Value ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.GenericComponent <em>Generic Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.GenericComponent
     * @generated
     */
    EClass getGenericComponent ();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.details.model.DetailView.GenericComponent#getRegistrations <em>Registrations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Registrations</em>'.
     * @see org.openscada.vi.details.model.DetailView.GenericComponent#getRegistrations()
     * @see #getGenericComponent()
     * @generated
     */
    EReference getGenericComponent_Registrations ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.Registration <em>Registration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Registration</em>'.
     * @see org.openscada.vi.details.model.DetailView.Registration
     * @generated
     */
    EClass getRegistration ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.Registration#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.openscada.vi.details.model.DetailView.Registration#getKey()
     * @see #getRegistration()
     * @generated
     */
    EAttribute getRegistration_Key ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.Registration#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.Registration#getDescriptor()
     * @see #getRegistration()
     * @generated
     */
    EAttribute getRegistration_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.Registration#isAggregateState <em>Aggregate State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Aggregate State</em>'.
     * @see org.openscada.vi.details.model.DetailView.Registration#isAggregateState()
     * @see #getRegistration()
     * @generated
     */
    EAttribute getRegistration_AggregateState ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent <em>Simple Grid Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Grid Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.SimpleGridComponent
     * @generated
     */
    EClass getSimpleGridComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent#isEqually <em>Equally</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Equally</em>'.
     * @see org.openscada.vi.details.model.DetailView.SimpleGridComponent#isEqually()
     * @see #getSimpleGridComponent()
     * @generated
     */
    EAttribute getSimpleGridComponent_Equally ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.SimpleGridComponent#getCols <em>Cols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cols</em>'.
     * @see org.openscada.vi.details.model.DetailView.SimpleGridComponent#getCols()
     * @see #getSimpleGridComponent()
     * @generated
     */
    EAttribute getSimpleGridComponent_Cols ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.GroupGridComponent <em>Group Grid Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group Grid Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridComponent
     * @generated
     */
    EClass getGroupGridComponent ();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Groups</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridComponent#getGroups()
     * @see #getGroupGridComponent()
     * @generated
     */
    EReference getGroupGridComponent_Groups ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#isEqually <em>Equally</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Equally</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridComponent#isEqually()
     * @see #getGroupGridComponent()
     * @generated
     */
    EAttribute getGroupGridComponent_Equally ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.GroupGridComponent#getCols <em>Cols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cols</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridComponent#getCols()
     * @see #getGroupGridComponent()
     * @generated
     */
    EAttribute getGroupGridComponent_Cols ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.GroupGridEntry <em>Group Grid Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group Grid Entry</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridEntry
     * @generated
     */
    EClass getGroupGridEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridEntry#getLabel()
     * @see #getGroupGridEntry()
     * @generated
     */
    EAttribute getGroupGridEntry_Label ();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Components</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridEntry#getComponents()
     * @see #getGroupGridEntry()
     * @generated
     */
    EReference getGroupGridEntry_Components ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.GroupGridEntry#getPermission <em>Permission</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Permission</em>'.
     * @see org.openscada.vi.details.model.DetailView.GroupGridEntry#getPermission()
     * @see #getGroupGridEntry()
     * @generated
     */
    EAttribute getGroupGridEntry_Permission ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent <em>Value Set Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Set Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueSetComponent
     * @generated
     */
    EClass getValueSetComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getValueDescriptor <em>Value Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueSetComponent#getValueDescriptor()
     * @see #getValueSetComponent()
     * @generated
     */
    EAttribute getValueSetComponent_ValueDescriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getSetDescriptor <em>Set Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Set Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueSetComponent#getSetDescriptor()
     * @see #getValueSetComponent()
     * @generated
     */
    EAttribute getValueSetComponent_SetDescriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ValueSetComponent#getResetDescriptor <em>Reset Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reset Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueSetComponent#getResetDescriptor()
     * @see #getValueSetComponent()
     * @generated
     */
    EAttribute getValueSetComponent_ResetDescriptor ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.ValueComponent <em>Value Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueComponent
     * @generated
     */
    EClass getValueComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ValueComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueComponent#getDescriptor()
     * @see #getValueComponent()
     * @generated
     */
    EAttribute getValueComponent_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ValueComponent#getDate <em>Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Date</em>'.
     * @see org.openscada.vi.details.model.DetailView.ValueComponent#getDate()
     * @see #getValueComponent()
     * @generated
     */
    EAttribute getValueComponent_Date ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.CompositeTransformer <em>Composite Transformer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Composite Transformer</em>'.
     * @see org.openscada.vi.details.model.DetailView.CompositeTransformer
     * @generated
     */
    EClass getCompositeTransformer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.openscada.vi.details.model.DetailView.CompositeTransformer#getValues <em>Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Values</em>'.
     * @see org.openscada.vi.details.model.DetailView.CompositeTransformer#getValues()
     * @see #getCompositeTransformer()
     * @generated
     */
    EReference getCompositeTransformer_Values ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.AndTransformer <em>And Transformer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>And Transformer</em>'.
     * @see org.openscada.vi.details.model.DetailView.AndTransformer
     * @generated
     */
    EClass getAndTransformer ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.OrTransformer <em>Or Transformer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Or Transformer</em>'.
     * @see org.openscada.vi.details.model.DetailView.OrTransformer
     * @generated
     */
    EClass getOrTransformer ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.TextInputComponent <em>Text Input Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Input Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextInputComponent
     * @generated
     */
    EClass getTextInputComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextInputComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextInputComponent#getDescriptor()
     * @see #getTextInputComponent()
     * @generated
     */
    EAttribute getTextInputComponent_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextInputComponent#getReadDescriptor <em>Read Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextInputComponent#getReadDescriptor()
     * @see #getTextInputComponent()
     * @generated
     */
    EAttribute getTextInputComponent_ReadDescriptor ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.WriteableComponent <em>Writeable Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Writeable Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.WriteableComponent
     * @generated
     */
    EClass getWriteableComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.WriteableComponent#getCeil <em>Ceil</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ceil</em>'.
     * @see org.openscada.vi.details.model.DetailView.WriteableComponent#getCeil()
     * @see #getWriteableComponent()
     * @generated
     */
    EAttribute getWriteableComponent_Ceil ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.WriteableComponent#getFloor <em>Floor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Floor</em>'.
     * @see org.openscada.vi.details.model.DetailView.WriteableComponent#getFloor()
     * @see #getWriteableComponent()
     * @generated
     */
    EAttribute getWriteableComponent_Floor ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.ReadableComponent <em>Readable Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Readable Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.ReadableComponent
     * @generated
     */
    EClass getReadableComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.openscada.vi.details.model.DetailView.ReadableComponent#getFormat()
     * @see #getReadableComponent()
     * @generated
     */
    EAttribute getReadableComponent_Format ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getDecimal <em>Decimal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Decimal</em>'.
     * @see org.openscada.vi.details.model.DetailView.ReadableComponent#getDecimal()
     * @see #getReadableComponent()
     * @generated
     */
    EAttribute getReadableComponent_Decimal ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute</em>'.
     * @see org.openscada.vi.details.model.DetailView.ReadableComponent#getAttribute()
     * @see #getReadableComponent()
     * @generated
     */
    EAttribute getReadableComponent_Attribute ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdConnectionid <em>Hd Connectionid</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hd Connectionid</em>'.
     * @see org.openscada.vi.details.model.DetailView.ReadableComponent#getHdConnectionid()
     * @see #getReadableComponent()
     * @generated
     */
    EAttribute getReadableComponent_HdConnectionid ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ReadableComponent#getHdItemId <em>Hd Item Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hd Item Id</em>'.
     * @see org.openscada.vi.details.model.DetailView.ReadableComponent#getHdItemId()
     * @see #getReadableComponent()
     * @generated
     */
    EAttribute getReadableComponent_HdItemId ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.TextComponent <em>Text Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextComponent
     * @generated
     */
    EClass getTextComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextComponent#getDescriptor()
     * @see #getTextComponent()
     * @generated
     */
    EAttribute getTextComponent_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextComponent#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextComponent#getWidth()
     * @see #getTextComponent()
     * @generated
     */
    EAttribute getTextComponent_Width ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextComponent#getHeight <em>Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextComponent#getHeight()
     * @see #getTextComponent()
     * @generated
     */
    EAttribute getTextComponent_Height ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextComponent#isDate <em>Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Date</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextComponent#isDate()
     * @see #getTextComponent()
     * @generated
     */
    EAttribute getTextComponent_Date ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextComponent#getTextHeight <em>Text Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Height</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextComponent#getTextHeight()
     * @see #getTextComponent()
     * @generated
     */
    EAttribute getTextComponent_TextHeight ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextComponent#getTextMap <em>Text Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Map</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextComponent#getTextMap()
     * @see #getTextComponent()
     * @generated
     */
    EAttribute getTextComponent_TextMap ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.TextInputMultiComponent <em>Text Input Multi Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Input Multi Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextInputMultiComponent
     * @generated
     */
    EClass getTextInputMultiComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.TextInputMultiComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.TextInputMultiComponent#getDescriptor()
     * @see #getTextInputMultiComponent()
     * @generated
     */
    EAttribute getTextInputMultiComponent_Descriptor ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.CheckComponent <em>Check Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Check Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.CheckComponent
     * @generated
     */
    EClass getCheckComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.CheckComponent#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.openscada.vi.details.model.DetailView.CheckComponent#getFormat()
     * @see #getCheckComponent()
     * @generated
     */
    EAttribute getCheckComponent_Format ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.CheckComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.CheckComponent#getDescriptor()
     * @see #getCheckComponent()
     * @generated
     */
    EAttribute getCheckComponent_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.CheckComponent#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute</em>'.
     * @see org.openscada.vi.details.model.DetailView.CheckComponent#getAttribute()
     * @see #getCheckComponent()
     * @generated
     */
    EAttribute getCheckComponent_Attribute ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.CheckComponent#getReadDescriptor <em>Read Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.CheckComponent#getReadDescriptor()
     * @see #getCheckComponent()
     * @generated
     */
    EAttribute getCheckComponent_ReadDescriptor ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.LinkComponent <em>Link Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.LinkComponent
     * @generated
     */
    EClass getLinkComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.LinkComponent#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.openscada.vi.details.model.DetailView.LinkComponent#getFormat()
     * @see #getLinkComponent()
     * @generated
     */
    EAttribute getLinkComponent_Format ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.URLImageComponent <em>URL Image Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>URL Image Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.URLImageComponent
     * @generated
     */
    EClass getURLImageComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.URLImageComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.URLImageComponent#getDescriptor()
     * @see #getURLImageComponent()
     * @generated
     */
    EAttribute getURLImageComponent_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.URLImageComponent#getImageUrl <em>Image Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Image Url</em>'.
     * @see org.openscada.vi.details.model.DetailView.URLImageComponent#getImageUrl()
     * @see #getURLImageComponent()
     * @generated
     */
    EAttribute getURLImageComponent_ImageUrl ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.URLImageComponent#getFallbackImageUrl <em>Fallback Image Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Fallback Image Url</em>'.
     * @see org.openscada.vi.details.model.DetailView.URLImageComponent#getFallbackImageUrl()
     * @see #getURLImageComponent()
     * @generated
     */
    EAttribute getURLImageComponent_FallbackImageUrl ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.URLImageComponent#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.openscada.vi.details.model.DetailView.URLImageComponent#getWidth()
     * @see #getURLImageComponent()
     * @generated
     */
    EAttribute getURLImageComponent_Width ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.URLImageComponent#getHeight <em>Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height</em>'.
     * @see org.openscada.vi.details.model.DetailView.URLImageComponent#getHeight()
     * @see #getURLImageComponent()
     * @generated
     */
    EAttribute getURLImageComponent_Height ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.ProgressComponent <em>Progress Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Progress Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.ProgressComponent
     * @generated
     */
    EClass getProgressComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ProgressComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ProgressComponent#getDescriptor()
     * @see #getProgressComponent()
     * @generated
     */
    EAttribute getProgressComponent_Descriptor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ProgressComponent#getFactor <em>Factor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Factor</em>'.
     * @see org.openscada.vi.details.model.DetailView.ProgressComponent#getFactor()
     * @see #getProgressComponent()
     * @generated
     */
    EAttribute getProgressComponent_Factor ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ProgressComponent#getMax <em>Max</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max</em>'.
     * @see org.openscada.vi.details.model.DetailView.ProgressComponent#getMax()
     * @see #getProgressComponent()
     * @generated
     */
    EAttribute getProgressComponent_Max ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ProgressComponent#getMin <em>Min</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min</em>'.
     * @see org.openscada.vi.details.model.DetailView.ProgressComponent#getMin()
     * @see #getProgressComponent()
     * @generated
     */
    EAttribute getProgressComponent_Min ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.ProgressComponent#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.openscada.vi.details.model.DetailView.ProgressComponent#getWidth()
     * @see #getProgressComponent()
     * @generated
     */
    EAttribute getProgressComponent_Width ();

    /**
     * Returns the meta object for class '{@link org.openscada.vi.details.model.DetailView.HiddenComponent <em>Hidden Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hidden Component</em>'.
     * @see org.openscada.vi.details.model.DetailView.HiddenComponent
     * @generated
     */
    EClass getHiddenComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.openscada.vi.details.model.DetailView.HiddenComponent#getDescriptor <em>Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Descriptor</em>'.
     * @see org.openscada.vi.details.model.DetailView.HiddenComponent#getDescriptor()
     * @see #getHiddenComponent()
     * @generated
     */
    EAttribute getHiddenComponent_Descriptor ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DetailViewFactory getDetailViewFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ViewImpl <em>View</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ViewImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getView()
         * @generated
         */
        EClass VIEW = eINSTANCE.getView ();

        /**
         * The meta object literal for the '<em><b>Header Component</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIEW__HEADER_COMPONENT = eINSTANCE.getView_HeaderComponent ();

        /**
         * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIEW__GROUPS = eINSTANCE.getView_Groups ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ComponentImpl <em>Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getComponent()
         * @generated
         */
        EClass COMPONENT = eINSTANCE.getComponent ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl <em>Group Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.GroupEntryImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGroupEntry()
         * @generated
         */
        EClass GROUP_ENTRY = eINSTANCE.getGroupEntry ();

        /**
         * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP_ENTRY__COMPONENT = eINSTANCE.getGroupEntry_Component ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP_ENTRY__LABEL = eINSTANCE.getGroupEntry_Label ();

        /**
         * The meta object literal for the '<em><b>Permission</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP_ENTRY__PERMISSION = eINSTANCE.getGroupEntry_Permission ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.LabelComponentImpl <em>Label Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.LabelComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getLabelComponent()
         * @generated
         */
        EClass LABEL_COMPONENT = eINSTANCE.getLabelComponent ();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LABEL_COMPONENT__FORMAT = eINSTANCE.getLabelComponent_Format ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LABEL_COMPONENT__DESCRIPTOR = eINSTANCE.getLabelComponent_Descriptor ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.CompositeComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getCompositeComponent()
         * @generated
         */
        EClass COMPOSITE_COMPONENT = eINSTANCE.getCompositeComponent ();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_COMPONENT__CHILDREN = eINSTANCE.getCompositeComponent_Children ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.FillLayoutComponentImpl <em>Fill Layout Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.FillLayoutComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getFillLayoutComponent()
         * @generated
         */
        EClass FILL_LAYOUT_COMPONENT = eINSTANCE.getFillLayoutComponent ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ButtonComponentImpl <em>Button Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ButtonComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getButtonComponent()
         * @generated
         */
        EClass BUTTON_COMPONENT = eINSTANCE.getButtonComponent ();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUTTON_COMPONENT__FORMAT = eINSTANCE.getButtonComponent_Format ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUTTON_COMPONENT__VALUE = eINSTANCE.getButtonComponent_Value ();

        /**
         * The meta object literal for the '<em><b>Read Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUTTON_COMPONENT__READ_DESCRIPTOR = eINSTANCE.getButtonComponent_ReadDescriptor ();

        /**
         * The meta object literal for the '<em><b>Write Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUTTON_COMPONENT__WRITE_DESCRIPTOR = eINSTANCE.getButtonComponent_WriteDescriptor ();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BUTTON_COMPONENT__ACTIVE = eINSTANCE.getButtonComponent_Active ();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUTTON_COMPONENT__ATTRIBUTE = eINSTANCE.getButtonComponent_Attribute ();

        /**
         * The meta object literal for the '<em><b>Text Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUTTON_COMPONENT__TEXT_HEIGHT = eINSTANCE.getButtonComponent_TextHeight ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.BoolLEDComponentImpl <em>Bool LED Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.BoolLEDComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getBoolLEDComponent()
         * @generated
         */
        EClass BOOL_LED_COMPONENT = eINSTANCE.getBoolLEDComponent ();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOL_LED_COMPONENT__FORMAT = eINSTANCE.getBoolLEDComponent_Format ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOL_LED_COMPONENT__DESCRIPTOR = eINSTANCE.getBoolLEDComponent_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Alarm</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOL_LED_COMPONENT__ALARM = eINSTANCE.getBoolLEDComponent_Alarm ();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOL_LED_COMPONENT__ATTRIBUTE = eINSTANCE.getBoolLEDComponent_Attribute ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ValueSourceImpl <em>Value Source</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ValueSourceImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getValueSource()
         * @generated
         */
        EClass VALUE_SOURCE = eINSTANCE.getValueSource ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ItemValueSourceImpl <em>Item Value Source</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ItemValueSourceImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getItemValueSource()
         * @generated
         */
        EClass ITEM_VALUE_SOURCE = eINSTANCE.getItemValueSource ();

        /**
         * The meta object literal for the '<em><b>Value Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_VALUE_SOURCE__VALUE_KEY = eINSTANCE.getItemValueSource_ValueKey ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.NotTransformerImpl <em>Not Transformer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.NotTransformerImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getNotTransformer()
         * @generated
         */
        EClass NOT_TRANSFORMER = eINSTANCE.getNotTransformer ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NOT_TRANSFORMER__VALUE = eINSTANCE.getNotTransformer_Value ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.GenericComponentImpl <em>Generic Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.GenericComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGenericComponent()
         * @generated
         */
        EClass GENERIC_COMPONENT = eINSTANCE.getGenericComponent ();

        /**
         * The meta object literal for the '<em><b>Registrations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GENERIC_COMPONENT__REGISTRATIONS = eINSTANCE.getGenericComponent_Registrations ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.RegistrationImpl <em>Registration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.RegistrationImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getRegistration()
         * @generated
         */
        EClass REGISTRATION = eINSTANCE.getRegistration ();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REGISTRATION__KEY = eINSTANCE.getRegistration_Key ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REGISTRATION__DESCRIPTOR = eINSTANCE.getRegistration_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Aggregate State</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REGISTRATION__AGGREGATE_STATE = eINSTANCE.getRegistration_AggregateState ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.SimpleGridComponentImpl <em>Simple Grid Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.SimpleGridComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getSimpleGridComponent()
         * @generated
         */
        EClass SIMPLE_GRID_COMPONENT = eINSTANCE.getSimpleGridComponent ();

        /**
         * The meta object literal for the '<em><b>Equally</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_GRID_COMPONENT__EQUALLY = eINSTANCE.getSimpleGridComponent_Equally ();

        /**
         * The meta object literal for the '<em><b>Cols</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_GRID_COMPONENT__COLS = eINSTANCE.getSimpleGridComponent_Cols ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.GroupGridComponentImpl <em>Group Grid Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.GroupGridComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGroupGridComponent()
         * @generated
         */
        EClass GROUP_GRID_COMPONENT = eINSTANCE.getGroupGridComponent ();

        /**
         * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP_GRID_COMPONENT__GROUPS = eINSTANCE.getGroupGridComponent_Groups ();

        /**
         * The meta object literal for the '<em><b>Equally</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP_GRID_COMPONENT__EQUALLY = eINSTANCE.getGroupGridComponent_Equally ();

        /**
         * The meta object literal for the '<em><b>Cols</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP_GRID_COMPONENT__COLS = eINSTANCE.getGroupGridComponent_Cols ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.GroupGridEntryImpl <em>Group Grid Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.GroupGridEntryImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getGroupGridEntry()
         * @generated
         */
        EClass GROUP_GRID_ENTRY = eINSTANCE.getGroupGridEntry ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP_GRID_ENTRY__LABEL = eINSTANCE.getGroupGridEntry_Label ();

        /**
         * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP_GRID_ENTRY__COMPONENTS = eINSTANCE.getGroupGridEntry_Components ();

        /**
         * The meta object literal for the '<em><b>Permission</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GROUP_GRID_ENTRY__PERMISSION = eINSTANCE.getGroupGridEntry_Permission ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ValueSetComponentImpl <em>Value Set Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ValueSetComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getValueSetComponent()
         * @generated
         */
        EClass VALUE_SET_COMPONENT = eINSTANCE.getValueSetComponent ();

        /**
         * The meta object literal for the '<em><b>Value Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_SET_COMPONENT__VALUE_DESCRIPTOR = eINSTANCE.getValueSetComponent_ValueDescriptor ();

        /**
         * The meta object literal for the '<em><b>Set Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_SET_COMPONENT__SET_DESCRIPTOR = eINSTANCE.getValueSetComponent_SetDescriptor ();

        /**
         * The meta object literal for the '<em><b>Reset Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_SET_COMPONENT__RESET_DESCRIPTOR = eINSTANCE.getValueSetComponent_ResetDescriptor ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ValueComponentImpl <em>Value Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ValueComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getValueComponent()
         * @generated
         */
        EClass VALUE_COMPONENT = eINSTANCE.getValueComponent ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_COMPONENT__DESCRIPTOR = eINSTANCE.getValueComponent_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_COMPONENT__DATE = eINSTANCE.getValueComponent_Date ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.CompositeTransformerImpl <em>Composite Transformer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.CompositeTransformerImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getCompositeTransformer()
         * @generated
         */
        EClass COMPOSITE_TRANSFORMER = eINSTANCE.getCompositeTransformer ();

        /**
         * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_TRANSFORMER__VALUES = eINSTANCE.getCompositeTransformer_Values ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.AndTransformerImpl <em>And Transformer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.AndTransformerImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getAndTransformer()
         * @generated
         */
        EClass AND_TRANSFORMER = eINSTANCE.getAndTransformer ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.OrTransformerImpl <em>Or Transformer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.OrTransformerImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getOrTransformer()
         * @generated
         */
        EClass OR_TRANSFORMER = eINSTANCE.getOrTransformer ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.TextInputComponentImpl <em>Text Input Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.TextInputComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getTextInputComponent()
         * @generated
         */
        EClass TEXT_INPUT_COMPONENT = eINSTANCE.getTextInputComponent ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_INPUT_COMPONENT__DESCRIPTOR = eINSTANCE.getTextInputComponent_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Read Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_INPUT_COMPONENT__READ_DESCRIPTOR = eINSTANCE.getTextInputComponent_ReadDescriptor ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.WriteableComponentImpl <em>Writeable Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.WriteableComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getWriteableComponent()
         * @generated
         */
        EClass WRITEABLE_COMPONENT = eINSTANCE.getWriteableComponent ();

        /**
         * The meta object literal for the '<em><b>Ceil</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WRITEABLE_COMPONENT__CEIL = eINSTANCE.getWriteableComponent_Ceil ();

        /**
         * The meta object literal for the '<em><b>Floor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WRITEABLE_COMPONENT__FLOOR = eINSTANCE.getWriteableComponent_Floor ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl <em>Readable Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ReadableComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getReadableComponent()
         * @generated
         */
        EClass READABLE_COMPONENT = eINSTANCE.getReadableComponent ();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute READABLE_COMPONENT__FORMAT = eINSTANCE.getReadableComponent_Format ();

        /**
         * The meta object literal for the '<em><b>Decimal</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute READABLE_COMPONENT__DECIMAL = eINSTANCE.getReadableComponent_Decimal ();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute READABLE_COMPONENT__ATTRIBUTE = eINSTANCE.getReadableComponent_Attribute ();

        /**
         * The meta object literal for the '<em><b>Hd Connectionid</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute READABLE_COMPONENT__HD_CONNECTIONID = eINSTANCE.getReadableComponent_HdConnectionid ();

        /**
         * The meta object literal for the '<em><b>Hd Item Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute READABLE_COMPONENT__HD_ITEM_ID = eINSTANCE.getReadableComponent_HdItemId ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.TextComponentImpl <em>Text Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.TextComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getTextComponent()
         * @generated
         */
        EClass TEXT_COMPONENT = eINSTANCE.getTextComponent ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_COMPONENT__DESCRIPTOR = eINSTANCE.getTextComponent_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_COMPONENT__WIDTH = eINSTANCE.getTextComponent_Width ();

        /**
         * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_COMPONENT__HEIGHT = eINSTANCE.getTextComponent_Height ();

        /**
         * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_COMPONENT__DATE = eINSTANCE.getTextComponent_Date ();

        /**
         * The meta object literal for the '<em><b>Text Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_COMPONENT__TEXT_HEIGHT = eINSTANCE.getTextComponent_TextHeight ();

        /**
         * The meta object literal for the '<em><b>Text Map</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_COMPONENT__TEXT_MAP = eINSTANCE.getTextComponent_TextMap ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.TextInputMultiComponentImpl <em>Text Input Multi Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.TextInputMultiComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getTextInputMultiComponent()
         * @generated
         */
        EClass TEXT_INPUT_MULTI_COMPONENT = eINSTANCE.getTextInputMultiComponent ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_INPUT_MULTI_COMPONENT__DESCRIPTOR = eINSTANCE.getTextInputMultiComponent_Descriptor ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.CheckComponentImpl <em>Check Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.CheckComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getCheckComponent()
         * @generated
         */
        EClass CHECK_COMPONENT = eINSTANCE.getCheckComponent ();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHECK_COMPONENT__FORMAT = eINSTANCE.getCheckComponent_Format ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHECK_COMPONENT__DESCRIPTOR = eINSTANCE.getCheckComponent_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHECK_COMPONENT__ATTRIBUTE = eINSTANCE.getCheckComponent_Attribute ();

        /**
         * The meta object literal for the '<em><b>Read Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHECK_COMPONENT__READ_DESCRIPTOR = eINSTANCE.getCheckComponent_ReadDescriptor ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.LinkComponentImpl <em>Link Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.LinkComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getLinkComponent()
         * @generated
         */
        EClass LINK_COMPONENT = eINSTANCE.getLinkComponent ();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK_COMPONENT__FORMAT = eINSTANCE.getLinkComponent_Format ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.URLImageComponentImpl <em>URL Image Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.URLImageComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getURLImageComponent()
         * @generated
         */
        EClass URL_IMAGE_COMPONENT = eINSTANCE.getURLImageComponent ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_IMAGE_COMPONENT__DESCRIPTOR = eINSTANCE.getURLImageComponent_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Image Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_IMAGE_COMPONENT__IMAGE_URL = eINSTANCE.getURLImageComponent_ImageUrl ();

        /**
         * The meta object literal for the '<em><b>Fallback Image Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL = eINSTANCE.getURLImageComponent_FallbackImageUrl ();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_IMAGE_COMPONENT__WIDTH = eINSTANCE.getURLImageComponent_Width ();

        /**
         * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_IMAGE_COMPONENT__HEIGHT = eINSTANCE.getURLImageComponent_Height ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl <em>Progress Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.ProgressComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getProgressComponent()
         * @generated
         */
        EClass PROGRESS_COMPONENT = eINSTANCE.getProgressComponent ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROGRESS_COMPONENT__DESCRIPTOR = eINSTANCE.getProgressComponent_Descriptor ();

        /**
         * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROGRESS_COMPONENT__FACTOR = eINSTANCE.getProgressComponent_Factor ();

        /**
         * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROGRESS_COMPONENT__MAX = eINSTANCE.getProgressComponent_Max ();

        /**
         * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROGRESS_COMPONENT__MIN = eINSTANCE.getProgressComponent_Min ();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROGRESS_COMPONENT__WIDTH = eINSTANCE.getProgressComponent_Width ();

        /**
         * The meta object literal for the '{@link org.openscada.vi.details.model.DetailView.impl.HiddenComponentImpl <em>Hidden Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.openscada.vi.details.model.DetailView.impl.HiddenComponentImpl
         * @see org.openscada.vi.details.model.DetailView.impl.DetailViewPackageImpl#getHiddenComponent()
         * @generated
         */
        EClass HIDDEN_COMPONENT = eINSTANCE.getHiddenComponent ();

        /**
         * The meta object literal for the '<em><b>Descriptor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIDDEN_COMPONENT__DESCRIPTOR = eINSTANCE.getHiddenComponent_Descriptor ();

    }

} //DetailViewPackage
