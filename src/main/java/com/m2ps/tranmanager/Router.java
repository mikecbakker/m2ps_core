
package com.m2ps.tranmanager;

import java.io.Serializable;

import org.jpos.space.Space;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import org.jpos.util.Log;

/**
 * Routes transaction. This Particpant currently has no implementation.
 * 
 */
public class Router extends Log implements TransactionParticipant
{
	protected Space<String, Context> sp;
	
	@Override
	public int prepare(long id, Serializable ctx)
	{
		info("In Router");
		
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
