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

package org.openscada.vi.details.handler;

import java.util.Map;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ParameterConverter extends AbstractParameterValueConverter
{

    private final GsonBuilder builder;

    public ParameterConverter ()
    {
        this.builder = new GsonBuilder ();
        this.builder.serializeNulls ();
        this.builder.setDateFormat ( "yyyy-MM-dd hh:mm:ss.SSS" ); //$NON-NLS-1$
    }

    @Override
    public Object convertToObject ( final String parameterValue ) throws ParameterValueConversionException
    {
        final Gson gson = this.builder.create ();
        return gson.fromJson ( parameterValue, new TypeToken<Map<String, String>> () {}.getType () );
    }

    @Override
    public String convertToString ( final Object parameterValue ) throws ParameterValueConversionException
    {
        if ( parameterValue instanceof Map )
        {
            final Gson gson = this.builder.create ();
            return gson.toJson ( parameterValue );
        }
        throw new ParameterValueConversionException ( "Unable to convert type " + parameterValue.getClass () );
    }

}
