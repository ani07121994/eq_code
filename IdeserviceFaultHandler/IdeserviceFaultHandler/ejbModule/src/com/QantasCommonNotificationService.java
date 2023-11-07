/*    */ package src.com;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.net.URL;
/*    */ import java.util.Properties;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;

import javax.jws.WebService;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*   
/*    */ //dev--@@WebServiceClient(wsdlLocation = "http://eqdev-soa:16013/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "QantasCommonNotificationService")
		//sit direct--@@WebServiceClient(wsdlLocation = "http://eqsit-soa:18033/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "QantasCommonNotificationService")
		//psp--@WebServiceClient(wsdlLocation = "http://eqdr-soa-ap1:17035/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "QantasCommonNotificationService")
/*    *///sit loadbalance--@
		//psp - 		@WebServiceClient(wsdlLocation = "http://eqosbpspnew.qantas.com.au/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "QantasCommonNotificationService")
	
		@WebServiceClient(wsdlLocation = "http://eqosbnew.qantas.com.au/CommonNotificationProject/ProxyService/CommonNotificationSevice_PS?wsdl", targetNamespace = "http://com.src/", name = "QantasCommonNotificationService")
	    public class QantasCommonNotificationService
/*    */   extends Service
/*    */ {
/*    */   private static URL wsdlLocationURL;
/*    */   private static Logger logger;
/*    */   
/*    */   static {
/* 33 */     Properties pro = new Properties();
/*    */     
/*    */     try {
/* 36 */       String configFile = System.getenv("QFEQIF_CONFIG");
/* 37 */       pro.load(new FileInputStream(configFile));
/*    */       
/* 39 */       logger = Logger.getLogger("src.com.QantasCommonNotificationService");
/* 40 */       URL baseUrl = QantasCommonNotificationService.class.getResource(".");
/* 41 */       if (baseUrl == null)
/*    */       {
/* 43 */         wsdlLocationURL = QantasCommonNotificationService.class.getResource(pro.getProperty("COMMON_NOTIFICATION_URL"));
/*    */         
/* 45 */         if (wsdlLocationURL == null)
/*    */         {
/* 47 */           baseUrl = (new File(".")).toURL();
/* 48 */           wsdlLocationURL = new URL(baseUrl, pro.getProperty("COMMON_NOTIFICATION_URL"));
/*    */         }
/*    */       
/*    */       }
/*    */       else
/*    */       {
/* 54 */         if (!baseUrl.getPath().endsWith("/")) {
/* 55 */           baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
/*    */         }
/* 57 */         wsdlLocationURL = new URL(baseUrl, pro.getProperty("COMMON_NOTIFICATION_URL"));
/*    */       }
/*    */     
/*    */     }
/* 61 */     catch (Exception e) {
/*    */       
/* 63 */       logger.log(Level.ALL, "Failed to create wsdlLocationURL using " + pro.getProperty("COMMON_NOTIFICATION_URL"), e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public QantasCommonNotificationService() {
/* 71 */     super(wsdlLocationURL, new QName("http://com.src/", "QantasCommonNotificationService"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public QantasCommonNotificationService(URL wsdlLocation, QName serviceName) {
/* 78 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */ 
/*    */   
/*    */   @WebEndpoint(name = "CommonNotificationPort")
/*    */   public CommonNotification getCommonNotificationPort() {
/* 84 */     return getPort(new QName("http://com.src/", "CommonNotificationPort"), CommonNotification.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @WebEndpoint(name = "CommonNotificationPort")
/*    */   public CommonNotification getCommonNotificationPort(WebServiceFeature... features) {
/* 92 */     return getPort(new QName("http://com.src/", "CommonNotificationPort"), CommonNotification.class, features);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\IdeserviceFaultHandler.jar!\src\com\QantasCommonNotificationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */