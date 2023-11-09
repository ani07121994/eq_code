
package ap.quantas.com.imaging.documentContentService;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 *
 */
@WebServiceClient(name = "DocumentContentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqtest-capture1.qantas.com.au:16033/imaging/ws/DocumentContentService?wsdl")
public class DocumentContentService_Service extends Service {

	private final static URL DOCUMENTCONTENTSERVICE_WSDL_LOCATION;
	private final static WebServiceException DOCUMENTCONTENTSERVICE_EXCEPTION;
	private final static QName DOCUMENTCONTENTSERVICE_QNAME = new QName("http://imaging.oracle/",
			"DocumentContentService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
//			url = DocumentContentService_Service.class
//					.getResource("http://eqtest-capture1.qantas.com.au:16033/imaging/ws/DocumentContentService?wsdl");
            url = new URL("http://eqtest-capture1.qantas.com.au:16033/imaging/ws/DocumentContentService?wsdl");
			System.out.println("DocumentContentService url :" + url);
		}
//        catch (MalformedURLException ex) {
//            e = new WebServiceException(ex);
//            }
		catch (Exception e1) {
			System.out.println(e1);
		}
		DOCUMENTCONTENTSERVICE_WSDL_LOCATION = url;
		DOCUMENTCONTENTSERVICE_EXCEPTION = e;
	}

	public DocumentContentService_Service() {
		super(__getWsdlLocation(), DOCUMENTCONTENTSERVICE_QNAME);
	}

	public DocumentContentService_Service(WebServiceFeature... features) {
		super(__getWsdlLocation(), DOCUMENTCONTENTSERVICE_QNAME, features);
	}

	public DocumentContentService_Service(URL wsdlLocation) {
		super(wsdlLocation, DOCUMENTCONTENTSERVICE_QNAME);
	}

	public DocumentContentService_Service(URL wsdlLocation, WebServiceFeature... features) {
		super(wsdlLocation, DOCUMENTCONTENTSERVICE_QNAME, features);
	}

	public DocumentContentService_Service(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public DocumentContentService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 *
	 * @return returns DocumentContentService
	 */
	@WebEndpoint(name = "DocumentContentServicePort")
	public DocumentContentService getDocumentContentServicePort() {
		return super.getPort(new QName("http://imaging.oracle/", "DocumentContentServicePort"),
				DocumentContentService.class);
	}

	/**
	 *
	 * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *                 on the proxy. Supported features not in the
	 *                 <code>features</code> parameter will have their default
	 *                 values.
	 * @return returns DocumentContentService
	 */
	@WebEndpoint(name = "DocumentContentServicePort")
	public DocumentContentService getDocumentContentServicePort(WebServiceFeature... features) {
		return super.getPort(new QName("http://imaging.oracle/", "DocumentContentServicePort"),
				DocumentContentService.class, features);
	}

	private static URL __getWsdlLocation() {
		if (DOCUMENTCONTENTSERVICE_EXCEPTION != null) {
			throw DOCUMENTCONTENTSERVICE_EXCEPTION;
		}
		return DOCUMENTCONTENTSERVICE_WSDL_LOCATION;
	}

}
