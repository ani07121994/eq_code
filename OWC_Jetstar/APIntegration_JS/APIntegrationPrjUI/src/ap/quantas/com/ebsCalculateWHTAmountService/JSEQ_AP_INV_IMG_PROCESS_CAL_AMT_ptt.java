package ap.quantas.com.ebsCalculateWHTAmountService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)
//dev--
//@WebService(wsdlLocation="http://eqdev-soa:16013/JetStarService/ProxyService/JESTAR_CAL_AMT_PS?wsdl",
//@WebService(wsdlLocation="http://eqosbnew.qantas.com.au/JetStarService/ProxyService/JESTAR_CAL_AMT_PS?wsdl",

@WebService(wsdlLocation="http://eqosb.qantas.com.au/JetStarService/ProxyService/JESTAR_CAL_AMT_PS?wsdl",
  targetNamespace="http://xmlns.oracle.com/pcbpel/adapter/db/JetstarOsb/JetStarOsbApp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT",
  name="JSEQ_AP_INV_IMG_PROCESS_CAL_AMT_ptt")
@XmlSeeAlso(
  { ap.quantas.com.ebsCalculateWHTAmountService.ObjectFactory.class })
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.BARE)
public interface JSEQ_AP_INV_IMG_PROCESS_CAL_AMT_ptt
{
  @WebMethod(operationName="JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", action="JSEQ_AP_INV_IMG_PROCESS_CAL_AMT")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", output="http://xmlns.oracle.com/pcbpel/adapter/db/JetstarOsb/JetStarOsbApp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT_ptt/JSEQ_AP_INV_IMG_PROCESS_CAL_AMTResponse")
  @WebResult(targetNamespace="http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT",
    partName="OutputParameters", name="OutputParameters")
  public ap.quantas.com.ebsCalculateWHTAmountService.OutputParameters jseqAPINVIMGPROCESSCALAMT(@WebParam(targetNamespace="http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT",
      partName="InputParameters", name="InputParameters")
    ap.quantas.com.ebsCalculateWHTAmountService.InputParameters InputParameters);
}
