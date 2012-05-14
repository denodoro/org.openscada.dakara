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

package org.openscada.vi.details.swt.source;

import java.util.Map;

import org.openscada.core.Variant;
import org.openscada.da.client.DataItemValue;
import org.openscada.vi.details.swt.data.SCADAAttributes;

public class NotEvaluatorController implements ValueSourceController
{

    private final ValueSourceController eval;

    public NotEvaluatorController ( final ValueSourceController eval )
    {
        this.eval = eval;
    }

    @Override
    public DataItemValue value ()
    {
        final DataItemValue.Builder builder = new DataItemValue.Builder ( this.eval.value () );

        builder.setValue ( Variant.valueOf ( !builder.getValue ().asBoolean () ) );

        return builder.build ();
    }

    @Override
    public void updateData ( final Map<Object, DataItemValue> values, final SCADAAttributes state )
    {
        this.eval.updateData ( values, state );
    }

}
