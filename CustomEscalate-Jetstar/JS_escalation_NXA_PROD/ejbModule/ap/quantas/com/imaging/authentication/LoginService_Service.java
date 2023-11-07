/*    */ package ap.quantas.com.imaging.authentication;
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
/*    */ //dev n sit -- /*    */ @WebServiceClient(name = "LoginService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqdev-capture1:19000/imaging/ws/LoginService?wsdl")
//		@WebServiceClient(name = "LoginService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqtest-capture1:16033/imaging/ws/LoginService?wsdl")
// Prod
/*    */ @WebServiceClient(name = "LoginService", targetNamespace = "http://imaging.oracle/", wsdlLocation = "http://eqprod-capture1:16033/imaging/ws/LoginService?wsdl")
/*    */ public class LoginService_Service
/*    */   extends Service
/*    */ {
/*    */   private static final URL LOGINSERVICE_WSDL_LOCATION;
/* 28 */   private static final Logger logger = Logger.getLogger(LoginService_Service.class.getName());
/*    */   
/*    */   static {
/* 31 */     URL url = null;
/*    */     
/*    */     try {
/* 34 */       URL baseUrl = LoginService_Service.class.getResource(".");
/* 35 */       url = new URL(baseUrl, Constants.getLoginServiceURL());
/* 36 */     } catch (MalformedURLException e) {
/* 37 */       logger.warning("Failed to create URL for the wsdl Location: '" + Constants.getLoginServiceURL() + "', retrying as a local file");
/* 38 */       logger.warning(e.getMessage());
/*    */     } 
			catch(Exception e) {
				System.out.println(e);
			}
/* 40 */     LOGINSERVICE_WSDL_LOCATION = url;
/*    */   }
/*    */   
/*    */   public LoginService_Service(URL wsdlLocation, QName serviceName) {
/* 44 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */   
/*    */   public LoginService_Service() {
/* 48 */     super(LOGINSERVICE_WSDL_LOCATION, new QName("http://imaging.oracle/", "LoginService"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @WebEndpoint(name = "LoginServicePort")
/*    */   public LoginService getLoginServicePort() {
/* 58 */     return getPort(new QName("http://imaging.oracle/", "LoginServicePort"), LoginService.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @WebEndpoint(name = "LoginServicePort")
/*    */   public LoginService getLoginServicePort(WebServiceFeature... features) {
/* 70 */     return getPort(new QName("http://imaging.oracle/", "LoginServicePort"), LoginService.class, features);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\authentication\LoginService_Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */