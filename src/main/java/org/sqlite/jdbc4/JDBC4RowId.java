/*
 * Copyright 2016 doe300.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sqlite.jdbc4;

import java.nio.ByteBuffer;
import java.sql.RowId;

/**
 * Implementation of {@link RowId}.
 * 
 * SQLite supports a ROWID for every table (except when created with WITHOUT ROWID) by querying set columns 
 * "rowid", "oid" or "_rowid_".
 * The ROWID is a 64-bit signed integer (java.lang.Long)
 * 
 * @author doe300
 * @see https://www.sqlite.org/lang_createtable.html#rowid
 */
public class JDBC4RowId implements RowId
{
	private final long rowID;

	public JDBC4RowId( long rowID )
	{
		this.rowID = rowID;
	}
	
	@Override
	public boolean equals( Object o )
	{
		return o != null && o instanceof JDBC4RowId && ((JDBC4RowId)o).rowID == rowID;
	}

	@Override
	public byte[] getBytes()
	{
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(rowID);
		return buffer.array();
	}

	@Override
	public String toString()
	{
		return Long.toString( rowID );
	}

	@Override
	public int hashCode()
	{
		return Long.hashCode( rowID );
	}
}
