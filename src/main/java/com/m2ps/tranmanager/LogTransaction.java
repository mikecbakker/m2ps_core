
package com.m2ps.tranmanager;

import java.io.Serializable;

import org.jpos.ee.DB;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;

import com.m2ps.sdk.ContextAction;
import com.m2ps.tranmanager.db.Transaction;

/**
 * Records the transaction to the database
 * 
 */
public class LogTransaction extends TxnSupport
{
	/*-----------------------------------------------------------------------------------------------------------------*/
	@Override
	protected int doPrepare(long id, Context ctx) throws Exception
	{
		info("Recording transaction to database");
		ContextAction contextAction = (ContextAction)(ctx);
		ISOMsg m2psIsoMsg = contextAction.getMessageCore();
		
		assertNotNull(m2psIsoMsg, "A valid IsoMsg is expected in the context");
		
		//TODO this should probably happen in commit below.
		DB db = getDB(ctx);
		db.session().save(new Transaction(m2psIsoMsg));
		
		// return PREPARED | NO_JOIN | READONLY;
		return PREPARED;
	}
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	@Override
	public void commit(long id, Serializable context)
	{
		//EMPTY
	}
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	@Override
	public void abort(long id, Serializable context)
	{
		//EMPTY
	}
}
