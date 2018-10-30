
package com.m2ps.tranmanager;

import java.io.Serializable;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOResponseListener;
import org.jpos.iso.MUX;
import org.jpos.q2.iso.QMUX;
import org.jpos.transaction.TransactionParticipant;
import org.jpos.util.Log;
import org.jpos.util.NameRegistrar.NotFoundException;

import com.m2ps.responselistener.RequestResponseListener;
import com.m2ps.sdk.ContextAction;

/**
 * This class forwards a request message to the sink mux.
 * 
 */
public class CoreSink extends Log implements TransactionParticipant, Configurable
{
	protected String destinationQmux;
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	/**
	 * Retrieves and loads the configuration as defined in the QBean.
	 * 
	 * @param cfg
	 * @throws ConfigurationException
	 * @see org.jpos.core.Configurable#setConfiguration(org.jpos.core.Configuration)
	 */
	@Override
	public void setConfiguration(Configuration cfg) throws ConfigurationException
	{
		destinationQmux = cfg.get("dest_qmux");
		if (destinationQmux == null)
		{
			throw new ConfigurationException(
				"Incorrect or missing paramter 'dest_qmux'.  This should be set to the value of the destination qmux.");
		}
		info("Destination Queue Name: " + destinationQmux);
	}
	
	@Override
	public int prepare(long id, Serializable ctx)
	{
		info("In CoreSink");
		ContextAction contextAction = (ContextAction)ctx;
		ISOMsg messageToSink = contextAction.getMessageCore();
		
		if (messageToSink != null)
		{
			info("Forwarding message to sink");
			try
			{
				// No routing at this stage, when performing routing the mux should be based on the bin
				MUX mux = QMUX.getMUX(destinationQmux);
				
				// At this stage we will only get a 0200, this will change if we process an advice from the source.
				ISOResponseListener isoResponseListener = new RequestResponseListener();
			
				// Send the request to the sink, the RequestResponseListener will process the response and handle timeouts.
				mux.request(messageToSink, 10000,isoResponseListener,messageToSink);
			}
			catch (NotFoundException ex)
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
		//Empty
	}
	
	@Override
	public void abort(long id, Serializable context)
	{
		//Empty
	}
}
