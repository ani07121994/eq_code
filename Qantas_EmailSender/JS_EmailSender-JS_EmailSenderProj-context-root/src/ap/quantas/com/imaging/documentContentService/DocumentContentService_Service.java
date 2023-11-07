/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentContentService.DocumentContentService;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*    */ //dev n sit-- @WebServiceClient(name = "DocumentContentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqdev-capture1.qantas.com.au:19000/imaging/ws/DocumentContentService?wsdl")
// Psp
//	   @WebServiceClient(name = "DocumentContentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqtest-capture1.qantas.com.au:16033/imaging/ws/DocumentContentService?wsdl")
// Prod
/*    */ @WebServiceClient(name = "DocumentContentService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqprod-capture1.qantas.com.au:16033/imaging/ws/DocumentContentService?wsdl")
/*    */ public class DocumentContentService_Service extends Service {
/*    */   private static final URL DOCUMENTCONTENTSERVICE_WSDL_LOCATION;
/*    */   
/* 30 */   private static final Logger logger = Logger.getLogger(ap.quantas.com.imaging.documentContentService.DocumentContentService_Service.class.getName());
/*    */   
/*    */   private static final String CompilationEnv = "PROD";
/*    */   
/*    */   static {
/* 35 */     URL url = null;
/*    */     try {
/* 38 */       URL baseUrl = ap.quantas.com.imaging.documentContentService.DocumentContentService_Service.class.getResource(".");
/* 40 */       if (CompilationEnv.equals("DEV")) {
/* 41 */         url = new URL(baseUrl, "http://eqdev-capture1.qantas.com.au:19000/imaging/ws/DocumentContentService?wsdl");
/* 43 */       } else if (CompilationEnv.equals("SIT")) {
/* 44 */         url = new URL(baseUrl, "http://eqdev-capture1.qantas.com.au:19000/imaging/ws/DocumentContentService?wsdl");
/* 46 */       } else if (CompilationEnv.equals("PSP")) {
/* 47 */         url = new URL(baseUrl, "http://eqtest-capture1.qantas.com.au:16033/imaging/ws/DocumentContentService?wsdl");
/*    */       } else if (CompilationEnv.equals("PROD")) {
	/* 47 */         url = 
//			new URL(baseUrl, "http://eqprod-capture1.qantas.com.au:19000/imaging/ws/DocumentContentService?wsdl");
			new URL(baseUrl, "http://eqprod-capture1.qantas.com.au:16033/imaging/ws/DocumentContentService?wsdl"); // Prod
	/*    */       } 
/* 53 */     } catch (MalformedURLException e) {
/* 54 */       logger.warning("Failed to create URL for the wsdl Location: '" + url + "', retrying as a local file");
/* 55 */       logger.warning(e.getMessage());
/*    */     } 
				catch(Exception e) {
					System.out.println(e);
				}
/* 57 */     DOCUMENTCONTENTSERVICE_WSDL_LOCATION = url;
/*    */   }
/*    */   
/*    */   public DocumentContentService_Service(URL wsdlLocation, QName serviceName) {
/* 61 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */   
/*    */   public DocumentContentService_Service() {
/* 65 */     super(DOCUMENTCONTENTSERVICE_WSDL_LOCATION, new QName("http://imaging.oracle/", "DocumentContentService"));
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "DocumentContentServicePort")
/*    */   public DocumentContentService getDocumentContentServicePort() {
/* 75 */     return getPort(new QName("http://imaging.oracle/", "DocumentContentServicePort"), DocumentContentService.class);
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "DocumentContentServicePort")
/*    */   public DocumentContentService getDocumentContentServicePort(WebServiceFeature... features) {
/* 87 */     return getPort(new QName("http://imaging.oracle/", "DocumentContentServicePort"), DocumentContentService.class, features);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\DocumentContentService_Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */