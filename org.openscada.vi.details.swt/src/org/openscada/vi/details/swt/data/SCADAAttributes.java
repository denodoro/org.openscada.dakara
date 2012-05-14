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

package org.openscada.vi.details.swt.data;

import java.util.Calendar;
import java.util.Collection;

import org.openscada.core.NullValueException;
import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SCADAAttributes
{

    //have to be false by default, cause we after instantiation we calculate these values using an OR operation -> see SCADAStatusController
    private final boolean disconnected;

    private final boolean error;

    private final boolean alarm;

    private final boolean manualActive;

    private final boolean ackRequired;

    private final boolean validValue;

    private final boolean blocked;

    private final Boolean blockedNative;

    private String blockedNativeUser;

    private String blockedNativeNote;

    private Calendar blockedNativeTimestamp;

    private final Calendar timestamp;

    private static final Logger logger = LoggerFactory.getLogger ( SCADAAttributes.class );;

    @Override
    public String toString ()
    {
        return "{disconnected: " + this.disconnected + ", error: " + this.error + ", alarm: " + this.alarm + ", manualActive: " + this.manualActive + ", ackRequired: " + this.ackRequired + ", validValue: " + this.validValue + ", blocked: " + this.blocked + ", blockedNative: " + this.blockedNative + ", blockedNativeUser: " + this.blockedNativeUser + ", blockedNativeNote: " + this.blockedNativeNote + ", blockedNativeTimestamp: " + this.blockedNativeTimestamp + ", timestamp: " + this.timestamp;
    }

    public static SCADAAttributes aggregate ( final Collection<SCADAAttributes> attributes )
    {
        int validValue = 0;
        int disconnected = 0;
        int error = 0;
        int alarm = 0;
        int manualActive = 0;
        Calendar timestamp = null;
        int ackRequired = 0;
        int blocked = 0;
        Boolean blockedNative = null;
        String blockedNativeUser = null;
        String blockedNativeNote = null;
        Calendar blockedNativeTimestamp = null;

        final int size = attributes.size ();

        for ( final SCADAAttributes entry : attributes )
        {
            if ( entry.isValidValue () )
            {
                validValue++;
            }
            if ( entry.isDisconnected () )
            {
                disconnected++;
            }
            if ( entry.isError () )
            {
                error++;
            }
            if ( entry.isAlarm () )
            {
                alarm++;
            }
            if ( entry.isManualActive () )
            {
                manualActive++;
            }
            if ( entry.isAckRequired () )
            {
                ackRequired++;
            }
            if ( entry.isBlocked () )
            {
                blocked++;
            }
            if ( entry.isBlockedNative () != null ) //isBlockedNative may return null. We want to keep the tri-state functionality: null, false, true
            { //keep output null, if all entries are null
                if ( blockedNative == null ) //Check if the output was ever set to true. If so, don't change it. We never want it set back to false.
                {
                    blockedNative = entry.isBlockedNative ();
                }
                else
                {
                    if ( blockedNative != true )
                    {
                        blockedNative = entry.isBlockedNative ();
                    }
                }
            }
            if ( timestamp == null )
            {
                timestamp = entry.getTimestamp ();
            }
            else if ( timestamp.before ( entry.getTimestamp () ) )
            {
                timestamp = entry.getTimestamp ();
            }
            if ( blockedNativeTimestamp == null )
            {
                blockedNativeTimestamp = entry.getBlockedNativeTimestamp ();
            }
            else if ( blockedNativeTimestamp.before ( entry.getBlockedNativeTimestamp () ) )
            {
                blockedNativeTimestamp = entry.getBlockedNativeTimestamp ();
            }
            if ( blockedNativeNote == null && entry.blockedNativeNote != null )
            {
                blockedNativeNote = entry.getBlockedNativeNote ();
            }
            else if ( entry.blockedNativeNote != null )
            {
                blockedNativeNote += "\n" + entry.getBlockedNativeNote ();
            }
            if ( blockedNativeUser == null && entry.blockedNativeUser != null )
            {
                blockedNativeUser = entry.getBlockedNativeUser ();
            }
            else if ( entry.blockedNativeUser != null )
            {
                blockedNativeUser += "\n" + entry.getBlockedNativeUser ();
            }
        }

        return new SCADAAttributes ( validValue == size, disconnected > 0, error > 0, alarm > 0, manualActive > 0, timestamp, ackRequired > 0, blocked > 0, blockedNative, blockedNativeTimestamp, blockedNativeNote, blockedNativeUser );
    }

    public SCADAAttributes ( final boolean validValue, final boolean disconnected, final boolean error, final boolean alarm, final boolean manualActive, final Calendar timestamp, final boolean ackRequired, final boolean blocked, final Boolean blockedNative, final Calendar blockedNativeTimesatmp, final String blockNativeNote, final String blockedNativeUser )
    {

        this.validValue = validValue;
        this.disconnected = disconnected;
        this.error = error;
        this.alarm = alarm;
        this.manualActive = manualActive;
        this.timestamp = timestamp;
        this.ackRequired = ackRequired;
        this.blocked = blocked;
        //blockedNative may be set to null, if it is not set.
        this.blockedNative = blockedNative;
        this.blockedNativeTimestamp = blockedNativeTimesatmp;
        this.blockedNativeNote = blockNativeNote;
        this.blockedNativeUser = blockedNativeUser;
    }

    public SCADAAttributes ( final DataItemValue value )
    {
        Variant variant = null;

        if ( value != null )
        {
            // we have a connection
            this.disconnected = !value.isConnected ();
            this.validValue = !value.getValue ().isNull ();
            this.alarm = value.isAlarm ();
            this.error = value.isError ();
            this.manualActive = value.isManual ();
            this.timestamp = value.getTimestamp ();
            this.ackRequired = value.isAttribute ( "ackRequired", false ); //$NON-NLS-1$
            this.blocked = value.isBlocked ();
            //blockedNative may be set to null, if it is not set.
            this.blockedNative = value.isAttribute ( "org.openscada.da.master.common.block.active" ); //$NON-NLS-1$
            this.blockedNativeTimestamp = value.getAsTimestamp ( "org.openscada.da.master.common.block.timestamp" );
            try
            {
                variant = value.getAttributes ().get ( "org.openscada.da.master.common.block.note" );
                if ( variant != null )
                {
                    this.blockedNativeNote = variant.asString ();
                }
                else
                {
                    this.blockedNativeNote = null;
                }
            }
            catch ( final NullValueException e )
            {
                this.blockedNativeNote = null;
                logger.warn ( "blockedNativeNote set to null" );
            }
            try
            {
                variant = value.getAttributes ().get ( "org.openscada.da.master.common.block.user" );
                if ( variant != null )
                {
                    this.blockedNativeUser = variant.asString ();
                }
                else
                {
                    this.blockedNativeUser = null;
                }
            }
            catch ( final NullValueException e )
            {
                this.blockedNativeUser = null;
                logger.warn ( "blockedNativeUser set to null" );
            }
        }
        else
        {
            // we do not have a connection
            this.disconnected = true;
            this.validValue = false;
            this.alarm = false;
            this.error = false;
            this.manualActive = false;
            this.timestamp = null;
            this.ackRequired = false;
            this.blocked = false;
            this.blockedNative = null;
            this.blockedNativeTimestamp = null;
            this.blockedNativeNote = null;
            this.blockedNativeUser = null;
        }
    }

    public boolean isValid ()
    {
        return isValidValue () && !isDisconnected () && !isError ();
    }

    public boolean isValidValue ()
    {
        return this.validValue;
    }

    public boolean isDisconnected ()
    {
        return this.disconnected;
    }

    public boolean isError ()
    {
        return this.error;
    }

    public boolean isAlarm ()
    {
        return this.alarm;
    }

    public boolean isManualActive ()
    {
        return this.manualActive;
    }

    public boolean isAckRequired ()
    {
        return this.ackRequired;
    }

    public boolean isBlocked ()
    {
        return this.blocked;
    }

    public Boolean isBlockedNative ()
    {
        return this.blockedNative;
    }

    public Calendar getTimestamp ()
    {
        return this.timestamp;
    }

    public Calendar getBlockedNativeTimestamp ()
    {
        return this.blockedNativeTimestamp;
    }

    public String getBlockedNativeNote ()
    {
        return this.blockedNativeNote;
    }

    public String getBlockedNativeUser ()
    {
        return this.blockedNativeUser;
    }

}
