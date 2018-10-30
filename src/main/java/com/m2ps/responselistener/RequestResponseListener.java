
package com.m2ps.responselistener;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOResponseListener;
import org.jpos.saf.SAF;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.util.NameRegistrar.NotFoundException;

import com.m2ps.message.M2PSIsoMsg;
import com.m2ps.sdk.ContextAction;

/**
 * This class provides timeout and reversal handling for a request message.
 *
 */
public class RequestResponseListener implements ISOResponseListener
{
	/**
	 * Process a response message from the sink.
	 *
	 * @param resp
	 * @param handBack
	 * @see org.jpos.iso.ISOResponseListener#responseReceived(org.jpos.iso.ISOMsg, java.lang.Object)
	 */
	@Override
	public void responseReceived(ISOMsg resp, Object handBack)
	{
		ISOMsg request = (ISOMsg)handBack;
		
		Space<String, ContextAction> sp = SpaceFactory.getSpace();
		
		ContextAction contextAction = new ContextAction();

		//send the response to core
		contextAction.putMessageCore(resp);
		//add the original source to the context, core would use the iso source to route to the original source
		contextAction.put(ContextAction.Fields.ISO_SOURCE, request.getSource());

		sp.out("queue-tranmgr-rsp", contextAction);
	}

	/**
	 * Process an request timeout, this will decline the request with response code 91 and send a
	 * 0420 reversal to the source.
	 * 
	 * @param handBack
	 * @see org.jpos.iso.ISOResponseListener#expired(java.lang.Object)
	 */
	@Override
	public void expired(Object handBack)
	{
		ISOMsg request = (ISOMsg)handBack;
		
		try
		{
			ISOMsg reversal = new ISOMsg("0420");
			
			//copyField(reversal, request, "2");
			M2PSIsoMsg.copyField(reversal, request, "3");
			M2PSIsoMsg.copyField(reversal, request, "4");
			M2PSIsoMsg.copyField(reversal, request, "11");
			M2PSIsoMsg.copyField(reversal, request, "41");
			reversal.set("39","91");
			
			SAF saf = SAF.getSAF("SAF");
			
			saf.send(reversal);
		}
		catch (NotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (ISOException ex)
		{
			ex.printStackTrace();
		}
		
		ISOMsg response = (ISOMsg)request.clone();
		
		try
		{
			response.setMTI("0210");
			response.set("39","91");
			
			responseReceived(response, handBack);
		}
		catch (ISOException ex)
		{
			ex.printStackTrace();
		}
	}
}

