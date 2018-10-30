package com.m2ps.node.src;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.util.Log;

import com.m2ps.sdk.ContextAction;

/**
 * Core Iso Source Request Listener. 
 * This class will forward the request to TM on the MESSAGE FROM SOURCE context.
 *
 */
public class IsoSrcRequestListener extends Log implements ISORequestListener, Configurable
{	
	protected Space space;
	protected String destinationQueueName;
	/*-----------------------------------------------------------------------------------------------------------------*/
	/**
	 * Constructs a new <code>IsoSrcRequestListener</code> instance.
	 */
	public IsoSrcRequestListener()
	{
		space = SpaceFactory.getSpace();
	}
	
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
		destinationQueueName = cfg.get("queue");
		if (destinationQueueName == null)
		{
			throw new ConfigurationException(
				"Incorrect or missing paramter 'queue'.  This should be set to the value of the destination queue.");
		}
		info("Destination Queue Name: " + destinationQueueName);
	}

	/*-----------------------------------------------------------------------------------------------------------------*/
	/**
	 * TODO
	 *
	 * @param source
	 * @param m
	 * @return
	 * @see org.jpos.iso.ISORequestListener#process(org.jpos.iso.ISOSource, org.jpos.iso.ISOMsg)
	 */
	@Override
	public boolean process(ISOSource source, ISOMsg m)
	{
		info("IsoSrcRequestListner add message to queue-tranmgr-req");
		
		ContextAction action = new ContextAction();
		action.putMessageCore(m);
		space.out(destinationQueueName, action);
		return false;
	}
}
