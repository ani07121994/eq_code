/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.DocumentService;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*    */ //dev n sit -- /*    */ @WebServiceClient(name = "DocumentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqdev-capture1:19000/imaging/ws/DocumentService?wsdl")
// Psp
//		@WebServiceClient(name = "DocumentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqtest-capture1:16033/imaging/ws/DocumentService?wsdl")
// Prod
/*    */ @WebServiceClient(name = "DocumentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqprod-capture1:16033/imaging/ws/DocumentService?wsdl")
/*    */ public class DocumentService_Service extends Service {
/*    */   private static final URL DOCUMENTSERVICE_WSDL_LOCATION;
/*    */   
/* 29 */   private static final Logger logger = Logger.getLogger(ap.quantas.com.imaging.documentUpdate.DocumentService_Service.class.getName());
/*    */   
/*    */   static {
/* 32 */     URL url = null;
/*    */     try {
/* 35 */       URL baseUrl = ap.quantas.com.imaging.documentUpdate.DocumentService_Service.class.getResource(".");
/* 37 */       //url = new URL(baseUrl, "http://eqdev-capture1:19000/imaging/ws/DocumentService?wsdl");
///* 37 */       url = new URL(baseUrl, "http://eqtest-capture1:16033/imaging/ws/DocumentService?wsdl");
				url = new URL(baseUrl, "http://eqprod-capture1:16033/imaging/ws/DocumentService?wsdl"); // Prod

/* 38 */     } catch (MalformedURLException e) {
/* 40 */       logger.warning(e.getMessage());
/*    */     } 
				catch(Exception e) {
					System.out.println(e);
				}
/* 42 */     DOCUMENTSERVICE_WSDL_LOCATION = url;
/*    */   }
/*    */   
/*    */   public DocumentService_Service(URL wsdlLocation, QName serviceName) {
/* 46 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */   
/*    */   public DocumentService_Service() {
/* 50 */     super(DOCUMENTSERVICE_WSDL_LOCATION, new QName("http://imaging.oracle/", "DocumentService"));
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "DocumentServicePort")
/*    */   public DocumentService getDocumentServicePort() {
/* 60 */     return getPort(new QName("http://imaging.oracle/", "DocumentServicePort"), DocumentService.class);
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "DocumentServicePort")
/*    */   public DocumentService getDocumentServicePort(WebServiceFeature... features) {
/* 72 */     return getPort(new QName("http://imaging.oracle/", "DocumentServicePort"), DocumentService.class, features);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\DocumentService_Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */