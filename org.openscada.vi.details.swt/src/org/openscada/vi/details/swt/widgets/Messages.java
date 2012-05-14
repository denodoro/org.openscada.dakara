/*
 * This file is part of the openSCADA project
 * Copyright (C) 2006-2012 TH4 SYSTEMS GmbH (http://th4-systems.com)
 *
 * openSCADA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * only, as published by the Free Software Foundation.
 *
 * openSCADA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License version 3 for more details
 * (a copy is included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with openSCADA. If not, see
 * <http://opensource.org/licenses/lgpl-3.0.html> for a copy of the LGPLv3 License.
 */

package org.openscada.vi.details.swt.widgets;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.openscada.vi.details.swt.widgets.messages"; //$NON-NLS-1$

    public static String AttributeImage_TrendError;

    public static String AttributeLockImage_ConfirmDialog_Message_Format;

    public static String AttributeLockImage_ConfirmDialog_Title;

    public static String AttributeLockImage_String_Timestamp;

    public static String AttributeLockImage_String_BlockedBy;

    public static String AttributeLockImage_String_BlockNote_None;

    public static String AttributeLockImage_String_None;

    public static String AttributeLockImage_String_Reason;

    public static String AttributeLockImage_String_Unknown;

    public static String LabelOpenscadaDialog_descriptor;

    public static String LockMessageDialog_DialogMessage;

    public static String LockMessageDialog_DialogTitle;

    public static String TextInputMultiComposite_clear;

    public static String TextInputMultiComposite_send;

    public static String ValueSetComposite_reset;

    public static String ValueSetComposite_resetDescriptor;

    public static String ValueSetComposite_set;

    public static String ValueSetComposite_setDescriptor;

    public static String ValueSetComposite_valueDescriptor;

    public static String VegaComposite_result;

    public static String VegaComposite_resultDescriptor;

    public static String VegaComposite_start;

    public static String VegaComposite_startDescriptor;

    public static String VegaComposite_state;

    public static String VegaComposite_stateDescriptor;

    public static String VegaComposite_waitingData;

    public static String VegaComposite_writeFailed;

    public static String WriteableComposite_invalidInput;

    public static String WriteableComposite_requiredInput;

    public static String WriteableComposite_wrongInput;

    public static String WriteConfirmDialog_confirmOperation;

    public static String WriteConfirmDialog_sendData;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
    }

    private Messages ()
    {
    }
}
