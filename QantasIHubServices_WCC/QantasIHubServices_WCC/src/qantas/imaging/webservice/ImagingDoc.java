
package qantas.imaging.webservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
//dev--@WebServiceClient(name = "ImagingDoc", targetNamespace = "http://webService.imaging.qantas/", wsdlLocation = "http://eqdev-soa:16015/ImagingDocServ/ImagingDocServicePort?WSDL")
//sit direct--@WebServiceClient(name = "ImagingDoc", targetNamespace = "http://webService.imaging.qantas/", wsdlLocation = "http://eqsit-soa:18035/ImagingDocServ/ImagingDocServicePort?WSDL")
//psp--@WebServiceClient(name = "ImagingDoc", targetNamespace = "http://webService.imaging.qantas/", wsdlLocation = "http://eqdr-soa-ap1:17035/ImagingDocServ/ImagingDocServicePort?WSDL")
//sit loadbalance--@WebServiceClient(name = "ImagingDoc", targetNamespace = "http://webService.imaging.qantas/", wsdlLocation = "http://eqsoasit.qantas.com.au/ImagingDocServ/ImagingDocServicePort?WSDL")
//jee load balance SIT--@WebServiceClient(name = "ImagingDoc", targetNamespace = "http://webService.imaging.qantas/", wsdlLocation = "http://eqjeesit.qantas.com.au/ImagingDocServ/ImagingDocServicePort?WSDL")
// psp - @WebServiceClient(name = "ImagingDoc", targetNamespace = "http://webService.imaging.qantas/", wsdlLocation = "http://eqjeepsp.qantas.com.au/ImagingDocServ/ImagingDocServicePort?WSDL")

@WebServiceClient(name = "ImagingDoc", targetNamespace = "http://webService.imaging.qantas/", wsdlLocation = "http://eqjee.qantas.com.au/ImagingDocServ/ImagingDocServicePort?WSDL")
public class ImagingDoc
    extends Service
{

    private final static URL IMAGINGDOC_WSDL_LOCATION;
    private final static WebServiceException IMAGINGDOC_EXCEPTION;
    private final static QName IMAGINGDOC_QNAME = new QName("http://webService.imaging.qantas/", "ImagingDoc");

    static {
        URL url = null;
        WebServiceException e = null;
        Properties pro = new Properties();
		String configFilePath = "";
		FileInputStream fis = null;
        try {
        	
        	configFilePath = System.getenv("QFEQIF_CONFIG");
			fis = new FileInputStream(configFilePath);
			pro.load(fis);
			
			String wsdlUrl = pro.getProperty("imaging.doc.wsdl");
        	
            //url = new URL("http://eqdr-soa-ap1:16035/ImagingDocServ/ImagingDocServicePort?wsdl");
            //url = new URL("http://eqsit-soa:16035/ImagingDocServ/ImagingDocServicePort?wsdl");
			url = new URL(wsdlUrl);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        IMAGINGDOC_WSDL_LOCATION = url;
        IMAGINGDOC_EXCEPTION = e;
    }

    public ImagingDoc() {
        super(__getWsdlLocation(), IMAGINGDOC_QNAME);
    }

    public ImagingDoc(WebServiceFeature... features) {
        super(__getWsdlLocation(), IMAGINGDOC_QNAME, features);
    }

    public ImagingDoc(URL wsdlLocation) {
        super(wsdlLocation, IMAGINGDOC_QNAME);
    }

    public ImagingDoc(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IMAGINGDOC_QNAME, features);
    }

    public ImagingDoc(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ImagingDoc(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ImagingServiceImpl
     */
    @WebEndpoint(name = "ImagingServiceImplPort")
    public ImagingServiceImpl getImagingServiceImplPort() {
        return super.getPort(new QName("http://webService.imaging.qantas/", "ImagingServiceImplPort"), ImagingServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ImagingServiceImpl
     */
    @WebEndpoint(name = "ImagingServiceImplPort")
    public ImagingServiceImpl getImagingServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webService.imaging.qantas/", "ImagingServiceImplPort"), ImagingServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IMAGINGDOC_EXCEPTION!= null) {
            throw IMAGINGDOC_EXCEPTION;
        }
        return IMAGINGDOC_WSDL_LOCATION;
    }

}
