/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.Constants;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ //dev n sit --/*    */ @WebServiceClient(name = "DocumentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqdev-capture1:19000/imaging/ws/DocumentService?wsdl")
//		@WebServiceClient(name = "DocumentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqtest-capture1.qantas.com.au:16033/imaging/ws/DocumentService?wsdl")/*    */ 
// Prod
/*    */ @WebServiceClient(name = "DocumentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqprod-capture1.qantas.com.au:16033/imaging/ws/DocumentService?wsdl")
		 public class DocumentService_Service
/*    */   extends Service
/*    */ {
/*    */   private static final URL DOCUMENTSERVICE_WSDL_LOCATION;
/* 28 */   private static final Logger logger = Logger.getLogger(DocumentService_Service.class.getName());
/*    */   
/*    */   static {
/* 31 */     URL url = null;
/*    */ 
/*    */     
/*    */     try {
/* 35 */       URL baseUrl = DocumentService_Service.class.getResource(".");
/* 36 */       url = new URL(baseUrl, Constants.getDocumentServiceURL());
/* 37 */     } catch (MalformedURLException e) {
/* 38 */       logger.warning("Failed to create URL for the wsdl Location: '" + Constants.getDocumentServiceURL() + "', retrying as a local file");
/* 39 */       logger.warning(e.getMessage());
/*    */     } 
			catch(Exception e) {
				System.out.println(e);
			}
/* 41 */     DOCUMENTSERVICE_WSDL_LOCATION = url;
/*    */   }
/*    */   
/*    */   public DocumentService_Service(URL wsdlLocation, QName serviceName) {
/* 45 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */   
/*    */   public DocumentService_Service() {
/* 49 */     super(DOCUMENTSERVICE_WSDL_LOCATION, new QName("http://imaging.oracle/", "DocumentService"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @WebEndpoint(name = "DocumentServicePort")
/*    */   public DocumentService getDocumentServicePort() {
/* 59 */     return getPort(new QName("http://imaging.oracle/", "DocumentServicePort"), DocumentService.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @WebEndpoint(name = "DocumentServicePort")
/*    */   public DocumentService getDocumentServicePort(WebServiceFeature... features) {
/* 71 */     return getPort(new QName("http://imaging.oracle/", "DocumentServicePort"), DocumentService.class, features);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\DocumentService_Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */