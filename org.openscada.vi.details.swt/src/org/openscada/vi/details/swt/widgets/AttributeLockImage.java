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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.openscada.core.Variant;
import org.openscada.vi.details.swt.data.DataItemDescriptor;
import org.openscada.vi.details.swt.data.SCADAAttributes;

public class AttributeLockImage extends AttributeImage
{
    private Image imageLocked;

    private Image imageUnlocked;

    private Label blockLabel;

    private final DataItemDescriptor descriptor;

    private final Styler boldStyler;

    private final DataItemToolTip tooltip;

    private SCADAAttributes state;

    public AttributeLockImage ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, descriptor, hdConnectionId, hdItemId );

        this.descriptor = descriptor;

        this.tooltip = new DataItemToolTip ( this.blockLabel, descriptor );
        this.tooltip.setShift ( new Point ( 5, 5 ) );
        this.tooltip.activate ();
        this.boldStyler = createBoldStyler ();
    }

    @Override
    protected void performDispose ()
    {
        super.performDispose ();
    }

    @Override
    protected void initLabels ()
    {
        super.initLabels ();
        this.blockLabel = new Label ( this, 0 );
        this.blockLabel.setImage ( getImageEmpty () );
        this.blockLabel.addMouseListener ( new MouseAdapter () {

            @Override
            public void mouseDown ( final org.eclipse.swt.events.MouseEvent e )
            {
                AttributeLockImage.this.toggleBlock ();
            }

        } );

    }

    public Styler createBoldStyler ()
    {
        return new Styler () {

            @Override
            public void applyStyles ( final TextStyle textStyle )
            {
                textStyle.font = getResourceManager ().createFont ( JFaceResources.getDefaultFontDescriptor ().withStyle ( SWT.BOLD ) );
            }
        };
    }

    @Override
    protected void initResources ()
    {
        super.initResources ();
        this.imageLocked = getResourceManager ().createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeLockImage.class, "icons/locked.png" ) ); //$NON-NLS-1$
        this.imageUnlocked = getResourceManager ().createImageWithDefault ( ImageDescriptor.createFromFile ( AttributeLockImage.class, "icons/unlocked.png" ) ); //$NON-NLS-1$
    }

    protected void toggleBlock ()
    {
        if ( this.state == null )
        {
            return;
        }

        if ( this.state.isBlockedNative () == null )
        {
            return;
        }

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        if ( !this.state.isBlockedNative () )
        {
            final String reason = getBlockReason ();
            if ( reason == null )
            {
                return;
            }
            if ( !reason.isEmpty () )
            {
                attributes.put ( "org.openscada.da.master.common.block.note", Variant.valueOf ( reason ) );//$NON-NLS-1$
            }
            else
            {
                attributes.put ( "org.openscada.da.master.common.block.note", Variant.valueOf ( Messages.AttributeLockImage_String_BlockNote_None ) );//$NON-NLS-1$                
            }
        }
        else
        {
            String blockNoteString = Messages.AttributeLockImage_String_BlockNote_None;

            String blockNote;
            try
            {
                blockNote = this.state.getBlockedNativeNote ();
            }
            catch ( final NullPointerException e )
            {
                blockNote = null;
            }

            if ( blockNote != null )
            {
                blockNoteString = blockNote;
            }
            else
            {
                blockNoteString = Messages.AttributeLockImage_String_BlockNote_None;
            }
            if ( !MessageDialog.openConfirm ( getShell (), Messages.AttributeLockImage_ConfirmDialog_Title, String.format ( Messages.AttributeLockImage_ConfirmDialog_Message_Format, blockNoteString ) ) )
            {
                return;
            }

        }

        attributes.put ( "org.openscada.da.master.common.block.active", Variant.valueOf ( !this.state.isBlockedNative () ) );//$NON-NLS-1$

        this.controller.writeOperation ( attributes, this.descriptor );
    }

    private String getBlockReason ()
    {
        String string;
        try
        {
            string = this.state.getBlockedNativeNote ();
        }
        catch ( final NullPointerException e )
        {
            string = null;
        }
        return new LockMessageDialog ( getShell (), string ).openDialog ();
    }

    @Override
    public void updateStatusView ( final SCADAAttributes state )
    {
        this.state = state;
        super.updateStatusView ( state );
        if ( this.state.isBlockedNative () != null )
        {
            if ( this.state.isBlockedNative () == false )
            {
                this.blockLabel.setImage ( this.imageUnlocked );
                this.tooltip.deactivate ();
            }
            else if ( this.state.isBlockedNative () == true )
            {
                this.blockLabel.setImage ( this.imageLocked );
                this.tooltip.setText ( getStyledString ( this.state.getBlockedNativeNote (), this.state.getBlockedNativeUser (), this.state.getBlockedNativeTimestamp () ) );
                this.tooltip.activate ();

            }
        }
        else
        {
            this.blockLabel.setImage ( getImageEmpty () );
            this.tooltip.deactivate ();
        }
    }

    protected StyledString getStyledString ( final String note, final String user, final Calendar timestamp )
    {
        final StyledString string = new StyledString ();

        if ( timestamp != null )
        {
            string.append ( Messages.AttributeLockImage_String_Timestamp, this.boldStyler );
            string.append ( timestamp.getTime ().toString () + "\n\n" );
        }

        if ( user != null )
        {
            string.append ( Messages.AttributeLockImage_String_BlockedBy, this.boldStyler );
            if ( user.equals ( "" ) )
            {
                string.append ( Messages.AttributeLockImage_String_Unknown );
            }
            else
            {
                string.append ( user );
            }
        }

        if ( note != null )
        {
            // show tooltip
            if ( string.length () > 0 )
            {
                string.append ( "\n" ); //$NON-NLS-1$
            }
            string.append ( Messages.AttributeLockImage_String_Reason, this.boldStyler );
            if ( note.equals ( "" ) )
            {
                string.append ( Messages.AttributeLockImage_String_None );
            }
            else
            {
                string.append ( note );
            }
        }
        return string;
    }

}
