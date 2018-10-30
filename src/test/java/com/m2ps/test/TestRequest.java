package com.m2ps.test;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.packager.XMLPackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test general request flows.
 *
 */
public class TestRequest
{
	public Logger loggerSource = new Logger();
	public Logger loggerSink = new Logger();
	public ISOChannel channelSource;
	public ISOChannel channelSink;
	
	/**
	 * Connect channel and logger
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		try
		{
			/* Connect to source node */
			loggerSource.addListener(new SimpleLogListener(System.out));
			channelSource = new XMLChannel("localhost", 10002, new XMLPackager());
			((LogSource)channelSource).setLogger(loggerSource, "SourceSimulator-channel");
			channelSource.connect();
			
			/* Connect to sink node */
			
			loggerSink.addListener(new SimpleLogListener(System.out));
			
			channelSink = new XMLChannel("localhost", 10004, new XMLPackager());
			((LogSource)channelSink).setLogger(loggerSink, "SinkSimulator-channel");
			channelSink.connect();
		}
		catch (ISOException ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * Disconnects channel
	 *
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		/* Disconnect */
		try
		{
			channelSource.disconnect();
			channelSink.disconnect();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * Test an approved 0200 request and a 0210 response. 
	 *
	 */
	@Test
	public void requestResponseApproved()
	{
		try
		{
			/* Send message to Source node */
			ISOMsg m = getRequestMsg();
			channelSource.send(m);
			
			/* Receive at Sink node */
			ISOMsg r = channelSink.receive();
			
			/* Send response from sink node */
			r.setMTI("0210");
			r.set(39, "00");
			channelSink.send(r);

			/* Receive response at source node */
			r = channelSource.receive();
			
			Assert.assertEquals(r.getString("39"), "00");
		}
		catch (Exception e)
		{
			fail("Unexpected exception: " + e.toString());
		}
	}
	
	/**
	 * Test an 0200 request and a declined 0210 response. 
	 *
	 */
	@Test
	public void requestResponseDeclined()
	{
		try
		{
			/* Send message to Source node */
			ISOMsg m = getRequestMsg();
			channelSource.send(m);
			
			/* Receive at Sink node */
			ISOMsg r = channelSink.receive();
			
			/* Send response from sink node */
			r.setMTI("0210");
			r.set(39, "14");
			channelSink.send(r);

			/* Receive response at source node */
			r = channelSource.receive();
			
			Assert.assertEquals(r.getString("39"), "14");
		}
		catch (Exception e)
		{
			fail("Unexpected exception: " + e.toString());
		}
	}
	
	/**
	 * Test an 0200 timeout followed by a 0420 advice.
	 *
	 */
	@Test
	public void requestTimeout()
	{
		try
		{
			/* Send message to Source node */
			ISOMsg m = getRequestMsg();
			channelSource.send(m);
			
			/* Receive 0200 at Sink node */
			channelSink.receive();
			
			/* Receive 0420 at Sink node */
			ISOMsg reversal = channelSink.receive();
			Assert.assertEquals(reversal.getString("39"), "91");

			/* Receive 0210 response at source node */
			ISOMsg requestResponse = channelSource.receive();
			Assert.assertEquals(requestResponse.getString("39"), "91");
			
			reversal.setMTI("0430");
			reversal.set(39, "00");
			channelSink.send(reversal);
		}
		catch (Exception e)
		{
			fail("Unexpected exception: " + e.toString());
		}
	}
	
	/**
	 * Test an 0200 timeout followed by a 0420 advice.
	 *
	 */
	@Test
	public void timeoutDuplicateSAF()
	{
		try
		{
			/* Send message to Source node */
			ISOMsg m = getRequestMsg();
			channelSource.send(m);
			
			/* Receive 0200 at Sink node */
			channelSink.receive();
			
			/* Receive 0420 at Sink node */
			ISOMsg reversal = channelSink.receive();
			Assert.assertEquals(reversal.getString("39"), "91");

			/* Receive 0210 response at source node */
			ISOMsg requestResponse = channelSource.receive();
			Assert.assertEquals(requestResponse.getString("39"), "91");
			
			/* Receive the SAF 0420 at Sink node */
			reversal = channelSink.receive();
			Assert.assertEquals(reversal.getString("39"), "91");
			
			reversal.setMTI("0430");
			reversal.set(39, "00");
			channelSink.send(reversal);
		}
		catch (Exception e)
		{
			fail("Unexpected exception: " + e.toString());
		}
	}
	
	public ISOMsg getRequestMsg()
	{
		ISOMsg m = new ISOMsg();
		try
		{
			m.setMTI("0200");
			m.set(3, "000000");
			m.set(4, "000000111224");
			m.set(11, "000000987123");
			m.set(41, "00000001");
		}
		catch (ISOException ex)
		{
			ex.printStackTrace();
		}

		return m;
	}
	
}

