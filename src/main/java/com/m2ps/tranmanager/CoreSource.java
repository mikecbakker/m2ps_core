
package com.m2ps.tranmanager;

import java.io.IOException;
import java.io.Serializable;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import org.jpos.util.Log;

import com.m2ps.sdk.ContextAction;

/**
 * This class picks a response message off the context action and sends it to the appropriate Iso Source.
 * 
 */
public class CoreSource extends Log implements TransactionParticipant
{
	protected Space<String, Context> sp;
	
	@Override
	public int prepare(long id, Serializable ctx) 
	{
		info("Forwarding message to source");
		ContextAction contextAction = (ContextAction)ctx;
		ISOMsg response = contextAction.getMessageCore();
		ISOSource isoSource = (ISOSource)contextAction.get(ContextAction.Fields.ISO_SOURCE);
		
		if (response != null)
		{
			try
			{
				isoSource.send(response);
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
			catch (ISOException ex)
			{
				ex.printStackTrace();
			}
		}
		return PREPARED;
	}
	
	@Override
	public void commit(long id, Serializable context)
	{
		// Empty
	}
	
	@Override
	public void abort(long id, Serializable context)
	{
		// Empty
	}
}
