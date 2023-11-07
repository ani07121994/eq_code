
package ap.quantas.com.ebsCalculateInvoiceDueDateWebService;

import ap.quantas.com.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;



/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "DueDateService_ptt-bindingQSService", targetNamespace = "http://xmlns.oracle.com/pcbpel/adapter/db/APIntegrationApp/APIntegrationPrj/DueDateService", wsdlLocation = "http://eqosb.qantas.com.au/DueDateService/ProxyService/GetDueDatePS?wsdl")
public class DueDateServicePttBindingQSService
    extends Service
{

    private final static URL DUEDATESERVICEPTTBINDINGQSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ap.quantas.com.ebsCalculateInvoiceDueDateWebService.DueDateServicePttBindingQSService.class.getName());

    static {
        URL url = null;
        try {
            String dueDateService = null;
            System.out.println("b4 resolving expression");
            
            
            dueDateService = Utility.resolveExpression("#{ApOperationBean.propertyLoader.properties['GET_INVOICE_DUE_DATE_SERVICE_WSDL']}").toString();
            System.out.println("After resolving expression");
            URL baseUrl;
            baseUrl = ap.quantas.com.ebsCalculateInvoiceDueDateWebService.DueDateServicePttBindingQSService.class.getResource(".");
            //url = new URL(baseUrl, "http://eqsit-ap:16034/DueDateService/ProxyService/GetDueDatePS?wsdl");
            url = new URL(baseUrl, dueDateService);
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/AP%20Integration/Due_Date_WebserviceClient/GetDueDatePS.xml', retrying as a local file");
            logger.warning(e.getMessage());
        }
        catch (Exception e) {
                    System.out.println(e);
                }
        DUEDATESERVICEPTTBINDINGQSSERVICE_WSDL_LOCATION = url;
    }

    public DueDateServicePttBindingQSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DueDateServicePttBindingQSService() {
        super(DUEDATESERVICEPTTBINDINGQSSERVICE_WSDL_LOCATION, new QName("http://xmlns.oracle.com/pcbpel/adapter/db/APIntegrationApp/APIntegrationPrj/DueDateService", "DueDateService_ptt-bindingQSService"));
    }

    /**
     * 
     * @return
     *     returns DueDateServicePtt
     */
    @WebEndpoint(name = "DueDateService_ptt-bindingQSPort")
    public DueDateServicePtt getDueDateServicePttBindingQSPort() {
        return super.getPort(new QName("http://xmlns.oracle.com/pcbpel/adapter/db/APIntegrationApp/APIntegrationPrj/DueDateService", "DueDateService_ptt-bindingQSPort"), DueDateServicePtt.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DueDateServicePtt
     */
    @WebEndpoint(name = "DueDateService_ptt-bindingQSPort")
    public DueDateServicePtt getDueDateServicePttBindingQSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.oracle.com/pcbpel/adapter/db/APIntegrationApp/APIntegrationPrj/DueDateService", "DueDateService_ptt-bindingQSPort"), DueDateServicePtt.class, features);
    }

}
