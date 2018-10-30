
package com.m2ps.tranmanager;

import java.io.Serializable;

import org.jpos.transaction.TransactionParticipant;
import org.jpos.util.Log;

/**
 * Performs message validation.
 * 
 */
public class ValidateMessage extends Log implements TransactionParticipant
{
	
	@Override
	public int prepare(long id, Serializable ctx)
	{
		info("Validating message");
		info("Message validated");
		return PREPARED;
	}
	
	public void commit(long id, Serializable context)
	{
		// Empty
	}
	
	public void abort(long id, Serializable context)
	{
		// Empty
	}
}
