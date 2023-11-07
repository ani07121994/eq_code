/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.SearchService;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*    */ //DEV N SIT -- /*    */ @WebServiceClient(name = "SearchService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqdev-capture1.qantas.com.au:19000/imaging/ws/SearchService?wsdl")
// Psp
//		@WebServiceClient(name = "SearchService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqtest-capture1.qantas.com.au:16033/imaging/ws/SearchService?wsdl")
// Prod
/*    */ @WebServiceClient(name = "SearchService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqprod-capture1.qantas.com.au:16033/imaging/ws/SearchService?wsdl")
/*    */ public class SearchService_Service extends Service {
/*    */   private static final URL SEARCHSERVICE_WSDL_LOCATION;
/*    */   
/* 26 */   private static final Logger logger = Logger.getLogger(ap.quantas.com.imaging.documentSearchService.SearchService_Service.class.getName());
/*    */   
/*    */   static {
/* 29 */     URL url = null;
/*    */     try {
/* 32 */       URL baseUrl = ap.quantas.com.imaging.documentSearchService.SearchService_Service.class.getResource(".");
/* 34 */       //url = new URL(baseUrl, "http://eqdev-capture1.qantas.com.au:19000/imaging/ws/SearchService?wsdl");
///* 34 */       url = new URL(baseUrl, "http://eqtest-capture1.qantas.com.au:16033/imaging/ws/SearchService?wsdl");
				 url = new URL(baseUrl, "http://eqprod-capture1.qantas.com.au:16033/imaging/ws/SearchService?wsdl"); // Prod
/* 35 */     } catch (MalformedURLException e) {
/* 36 */       logger.warning("Failed to create URL for the wsdl Location: 'file:/C:/Users/332914/Desktop/DocRetrieveSvc/SearchService.xml', retrying as a local file");
/* 37 */       logger.warning(e.getMessage());
/*    */     } 
				catch(Exception e) {
					System.out.println(e);
				}
/* 39 */     SEARCHSERVICE_WSDL_LOCATION = url;
/*    */   }
/*    */   
/*    */   public SearchService_Service(URL wsdlLocation, QName serviceName) {
/* 43 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */   
/*    */   public SearchService_Service() {
/* 47 */     super(SEARCHSERVICE_WSDL_LOCATION, new QName("http://imaging.oracle/", "SearchService"));
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "SearchServicePort")
/*    */   public SearchService getSearchServicePort() {
/* 57 */     return getPort(new QName("http://imaging.oracle/", "SearchServicePort"), SearchService.class);
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "SearchServicePort")
/*    */   public SearchService getSearchServicePort(WebServiceFeature... features) {
/* 69 */     return getPort(new QName("http://imaging.oracle/", "SearchServicePort"), SearchService.class, features);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchService_Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */