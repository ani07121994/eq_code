package src.com;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
//dev--@WebService(wsdlLocation = "http://eqdev-soa:16013/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "CommonNotification")
//sit direct--@WebService(wsdlLocation = "http://eqsit-soa:18033/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "CommonNotification")
//psp--@WebService(wsdlLocation = "http://eqdr-soa-ap1:17035/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "CommonNotification")
//sit loadbalance--@WebService(wsdlLocation = "http://eqosbsit.qantas.com.au/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "CommonNotification")
//psp - @WebService(wsdlLocation = "http://eqosbpspnew.qantas.com.au/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "CommonNotification")

@WebService(wsdlLocation = "http://eqosbnew.qantas.com.au/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "CommonNotification")
@XmlSeeAlso({ObjectFactory.class})
public interface CommonNotification {
  @WebMethod
  @Action(input = "http://com.src/CommonNotification/commonNotificationDetails")
  @RequestWrapper(localName = "commonNotificationDetails", targetNamespace = "http://com.src/", className = "src.com.CommonNotificationDetails")
  @Oneway
  void commonNotificationDetails(@WebParam(targetNamespace = "http://com.src/", name = "IFId") String paramString1, @WebParam(targetNamespace = "http://com.src/", name = "mailToAddress") String paramString2, @WebParam(targetNamespace = "http://com.src/", name = "mailBody") String paramString3, @WebParam(targetNamespace = "http://com.src/", name = "mailSubject") String paramString4, @WebParam(targetNamespace = "http://com.src/", name = "mailCcAddress") String paramString5, @WebParam(targetNamespace = "http://com.src/", name = "mailBccAddress") String paramString6, @WebParam(targetNamespace = "http://com.src/", name = "mailFromAddress") String paramString7);
}


/* Location:              C:\Users\2033471\Downloads\IdeserviceFaultHandler.jar!\src\com\CommonNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */