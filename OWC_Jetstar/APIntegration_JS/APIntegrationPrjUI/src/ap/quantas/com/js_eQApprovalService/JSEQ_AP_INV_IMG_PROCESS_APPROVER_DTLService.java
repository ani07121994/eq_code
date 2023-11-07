package ap.quantas.com.js_eQApprovalService;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102
//dev--
//@WebServiceClient(wsdlLocation="http://eqdev-soa:16013/JetStarService/ProxyService/JETSTAR_APPROVER_DTL_PS?wsdl",
@WebServiceClient(wsdlLocation="http://eqosb.qantas.com.au/JetStarService/ProxyService/JETSTAR_APPROVER_DTL_PS?wsdl",
  targetNamespace="http://xmlns.oracle.com/pcbpel/adapter/db/JetstarOsb/JetStarOsbApp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL",
  name="JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL-service")
public class JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLService
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLService");
      URL baseUrl =
        JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLService.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
          JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLService.class.getResource("http://eqosb.qantas.com.au/JetStarService/ProxyService/JETSTAR_APPROVER_DTL_PS?wsdl");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
            new URL(baseUrl, "http://eqosb.qantas.com.au/JetStarService/ProxyService/JETSTAR_APPROVER_DTL_PS?wsdl");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
          new URL(baseUrl, "http://eqosb.qantas.com.au/JetStarService/ProxyService/JETSTAR_APPROVER_DTL_PS?wsdl");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://eqsit-db:16033/JetStarService/ProxyService/JETSTAR_APPROVER_DTL_PS?wsdl",
          e);
    }
      catch (Exception e)
      {
          System.out.println(e);
      }
  }

  public JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLService()
  {
    super(wsdlLocationURL,
          new QName("http://xmlns.oracle.com/pcbpel/adapter/db/JetstarOsb/JetStarOsbApp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL",
                    "JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL-service"));
  }

  public JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLService(URL wsdlLocation,
                                                     QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL-port")
  public ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL_ptt getJSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLPort()
  {
    return (ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL_ptt) super.getPort(new QName("http://xmlns.oracle.com/pcbpel/adapter/db/JetstarOsb/JetStarOsbApp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL",
                                                                                                                  "JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL-port"),
                                                                                                        ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL_ptt.class);
  }

  @WebEndpoint(name="JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL-port")
  public ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL_ptt getJSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLPort(WebServiceFeature... features)
  {
    return (ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL_ptt) super.getPort(new QName("http://xmlns.oracle.com/pcbpel/adapter/db/JetstarOsb/JetStarOsbApp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL",
                                                                                                                  "JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL-port"),
                                                                                                        ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL_ptt.class,
                                                                                                        features);
  }
}
