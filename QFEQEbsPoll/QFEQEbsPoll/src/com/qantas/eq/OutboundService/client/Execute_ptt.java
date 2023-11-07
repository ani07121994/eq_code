package com.qantas.eq.OutboundService.client;

import com.qantas.eq.OutboundService.genJava.ObjectFactory;
import com.qantas.eq.OutboundService.genJava.QFEQIFEBSSOAOUT;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
//dev--@WebService(wsdlLocation = "http://eqdev-soa.qantas.com.au:16015/soa-infra/services/default/QFEQ_Outbound_WF015WCC/QFEQ_Outbound_WF015Service?WSDL", targetNamespace = "http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", name = "execute_ptt")
//sit direct--@WebService(wsdlLocation = "http://eqsit-soa.qantas.com.au:18035/soa-infra/services/default/QFEQ_Outbound_WF015WCC/QFEQ_Outbound_WF015Service?WSDL", targetNamespace = "http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", name = "execute_ptt")

@WebService(wsdlLocation = "http://eqsoasit.qantas.com.au/soa-infra/services/default/QFEQ_Outbound_WF015WCC/QFEQ_Outbound_WF015Service?WSDL", targetNamespace = "http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", name = "execute_ptt")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Execute_ptt {
  @WebMethod(action = "execute")
  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  @Action(input = "execute")
  @Oneway
  void execute(@WebParam(targetNamespace = "http://xmlns.oracle.com/xdb/BOLINF", partName = "QFEQIF_EBS_SOA_OUT", name = "QFEQIF_EBS_SOA_OUT") QFEQIFEBSSOAOUT paramQFEQIFEBSSOAOUT);
}


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\OutboundService\client\Execute_ptt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */