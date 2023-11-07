
package ap.quantas.com.ebsAutofillWebservice;

import ap.quantas.com.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

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
@WebServiceClient(name = "Update_ptt-bindingQSService", targetNamespace = "http://xmlns.oracle.com/pcbpel/adapter/db/Application3/soa/Update", wsdlLocation = "http://eqosb.qantas.com.au/AutoFill/ProxyService/AutoFillPS?wsdl")
public class UpdatePttBindingQSService
    extends Service
{
    private final static URL UPDATEPTTBINDINGQSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ap.quantas.com.ebsAutofillWebservice.UpdatePttBindingQSService.class.getName());
    
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, expression,
                                            Object.class);
        return valueExp.getValue(elContext);
    }
    static {
        URL url = null;
        try {
            URL baseUrl;
            String autoFillService = null;
            autoFillService = resolveExpression("#{ApOperationBean.propertyLoader.properties['EBS_AUTOFILL_SERVICE_WSDL']}").toString();
            System.out.println("autoFillService ::: "+ autoFillService);
            baseUrl = ap.quantas.com.ebsAutofillWebservice.UpdatePttBindingQSService.class.getResource(".");
            //url = new URL(baseUrl, "http://eqsit-ap:16034/AutoFill/ProxyService/AutoFillPS?wsdl");
            url = new URL(baseUrl, autoFillService);
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://eqosb.qantas.com.au/AutoFill/ProxyService/AutoFillPS?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        catch (Exception e) {
                    System.out.println(e);
                }
        UPDATEPTTBINDINGQSSERVICE_WSDL_LOCATION = url;
    }

    public UpdatePttBindingQSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UpdatePttBindingQSService() {
        super(UPDATEPTTBINDINGQSSERVICE_WSDL_LOCATION, new QName("http://xmlns.oracle.com/pcbpel/adapter/db/Application3/soa/Update", "Update_ptt-bindingQSService"));
    }

    /**
     * 
     * @return
     *     returns UpdatePtt
     */
    @WebEndpoint(name = "Update_ptt-bindingQSPort")
    public UpdatePtt getUpdatePttBindingQSPort() {
        return super.getPort(new QName("http://xmlns.oracle.com/pcbpel/adapter/db/Application3/soa/Update", "Update_ptt-bindingQSPort"), UpdatePtt.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UpdatePtt
     */
    @WebEndpoint(name = "Update_ptt-bindingQSPort")
    public UpdatePtt getUpdatePttBindingQSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.oracle.com/pcbpel/adapter/db/Application3/soa/Update", "Update_ptt-bindingQSPort"), UpdatePtt.class, features);
    }

}
