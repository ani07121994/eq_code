package qantas.document.service.handler;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import qantas.document.util.Utility;


public class Handler1 implements SOAPHandler<SOAPMessageContext>
{
		
	public Set<QName> getHeaders()
	{
		System.out.println("\ngetHeaders");
		return null;
	}
	
	public boolean handleMessage(SOAPMessageContext context)
	{
		return true;
	}

	public boolean handleMessage1(SOAPMessageContext context)
	{
		System.out.println("Inside handleMessage");
		
		QName operationName = (QName) context.get(MessageContext.WSDL_OPERATION);
		SOAPMessage soapMsg = context.getMessage();

		
		Boolean outBoundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		// if this is an incoming message from the client

		try {
			System.out.println( "\n soapMsg=="+soapMsg.getSOAPBody()+" , outBoundProperty="+outBoundProperty);
			if (outBoundProperty) {
				new Utility().trackAuditInfo(getMsgAsString(soapMsg),"PE", "IF429",operationName.getLocalPart(),getSession(context).getId()); //"PS" : Process Start, "IF429" : Interface ID,

				/*	System.out.println("\n Else soapHeader+"+soapMsg.getSOAPHeader());
				SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
				System.out.println("\n soapEnv=="+soapEnv);
				SOAPHeader soapHeader = soapEnv.getHeader();		  
				//SOAPHeader soapHeader = soapMsg.getSOAPHeader();
				System.out.println("\n Else soapHeader111:"+soapHeader);
				//SOAPHeaderElement headerElement = soapHeader.addHeaderElement(soapEnv.createName("","", ""));
				
				//SOAPHeaderElement headerElement = soapHeader.addHeaderElement(soapEnv.createName(
				//		"Signature", "SOAP-SEC", "http://schemas.xmlsoap.org/soap/security/2000-12"));
				System.out.println("\n Else soapHeader111:"+soapHeader);
				if (null == soapHeader){
		  		    System.out.println("\n Else soapHeader000:"+soapHeader);
		            soapHeader = soapEnv.addHeader();
		            soapHeader.setValue("Hello");
		  		    System.out.println("\n Else soapHeader222:"+soapHeader);
	            }	*/
				HttpServletResponse response = (HttpServletResponse) context.get(MessageContext.SERVLET_RESPONSE);

				System.out.println("\n soapMsg Length:"+getMsgAsString(soapMsg));
				int len = getMsgAsString(soapMsg).length()+27;
				response.setContentLength(len);
				
			}else{
				new Utility().trackAuditInfo(getMsgAsString(soapMsg),"PS", "IF429",operationName.getLocalPart(),getSession(context).getId()); //"PS" : Process Start, "IF429" : Interface ID,				
			}
		} catch (SOAPException e) {
			System.out.println("\n Inside Exeception:");
		} 
		return true;
	}

	public boolean handleFault(SOAPMessageContext context)
	{
		System.out.println("handleFault :");
		try
		{
			QName operationName = (QName) context.get(MessageContext.WSDL_OPERATION);

			SOAPMessage msg = context.getMessage();
			new Utility().trackAuditInfo(getMsgAsString(msg),"PERROR", "IF429",operationName.getLocalPart(),getSession(context).getId()); //"PS" : Process Start, "IF429" : Interface ID,
			
			SOAPFault fault = msg.getSOAPPart().getEnvelope().getBody().getFault();
			System.out.println("\n soapMsg fault:"+fault.getFaultString()+" :getFaultCode--:"+fault.getFaultCode());			
			 			
			/*HttpServletResponse response = (HttpServletResponse) context.get(MessageContext.SERVLET_RESPONSE);
			int len = getMsgAsString(msg)+24;
			response.setContentLength(len);*/	
		}
		catch(SOAPException e) { 
			System.out.println("\n handleFault SOAPException :");
			//e.printStackTrace();
		}		
		return true;
	}

	public void close(MessageContext messageContext)
	{
		System.out.println("close :");
	}
    public HttpSession getSession(SOAPMessageContext context) {
    	HttpServletRequest req = (HttpServletRequest) context.get(MessageContext.SERVLET_REQUEST);

        //HttpServletRequest req = (HttpServletRequest) this.ctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        return req.getSession();
    }	

	private void generateSOAPErrMessage(SOAPMessageContext context, String reason) {
		try {
			SOAPMessage msg = context.getMessage();
			SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault = soapBody.addFault();
			HttpServletResponse response = (HttpServletResponse) context.get(MessageContext.SERVLET_RESPONSE);

			//System.out.println("\n Else response:"+response);
			System.out.println("\n soapMsg Length:"+getMsgAsString(msg).length());
			int len = getMsgAsString(msg).length()+27;
			response.setContentLength(len);			
			soapFault.setFaultString(reason);
			throw new SOAPFaultException(soapFault);
		}
		catch(SOAPException e) { }
	}
	private String getMsgAsString(SOAPMessage message) {
		String msg = "";
		int len = 0;
		if(null != message)
		{
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				message.writeTo(baos);
				msg = baos.toString();
				System.out.println("\nInside getMsgAsString->Message=="+msg);

				/*if(null != msg)
					len = msg.length();
				else len = 0;*/
			} catch (SOAPException e){
				System.out.println("\n getMsgAsString SOAPException:"+e.getMessage());

			}
			catch (IOException soape) { 
				System.out.println("\n getMsgAsString IOException:"+soape.getMessage());

			}
		}
		return msg;
	}  
}
