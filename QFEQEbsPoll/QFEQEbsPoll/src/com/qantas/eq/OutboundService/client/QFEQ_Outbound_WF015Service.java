/*    */ package com.qantas.eq.OutboundService.client;
/*    */ 
/*    */ import com.qantas.eq.OutboundService.client.Execute_ptt;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.net.URL;
/*    */ import java.util.Properties;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*    */ //dev--/*    */ @WebServiceClient(wsdlLocation = "http://eqdev-soa.qantas.com.au:16015/soa-infra/services/default/QFEQ_Outbound_WF015WCC/QFEQ_Outbound_WF015Service?WSDL", targetNamespace = "http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", name = "QFEQ_Outbound_WF015Service")
		//sit direct--/*    */ @WebServiceClient(wsdlLocation = "http://eqsit-soa.qantas.com.au:18035/soa-infra/services/default/QFEQ_Outbound_WF015WCC/QFEQ_Outbound_WF015Service?WSDL", targetNamespace = "http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", name = "QFEQ_Outbound_WF015Service")

/*    */ @WebServiceClient(wsdlLocation = "http://eqsoasit.qantas.com.au/soa-infra/services/default/QFEQ_Outbound_WF015WCC/QFEQ_Outbound_WF015Service?WSDL", targetNamespace = "http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", name = "QFEQ_Outbound_WF015Service")
/*    */ public class QFEQ_Outbound_WF015Service extends Service {
/*    */   private static URL wsdlLocationURL;
/*    */   
/*    */   private static Logger logger;
/*    */   
/*    */   static {
/*    */     try {
/* 38 */       String configFile = System.getenv("QFEQIF_CONFIG");
/* 39 */       Properties pro = new Properties();
/* 40 */       pro.load(new FileInputStream(configFile));
/* 42 */       logger = Logger.getLogger("com.qantas.eq.OutboundService.client.QFEQ_Outbound_WF015Service");
/* 43 */       URL baseUrl = com.qantas.eq.OutboundService.client.QFEQ_Outbound_WF015Service.class.getResource(".");
/* 44 */       if (baseUrl == null) {
/* 46 */         wsdlLocationURL = com.qantas.eq.OutboundService.client.QFEQ_Outbound_WF015Service.class.getResource(pro.getProperty("OUTBOUND_SERVICE_URL"));
/* 48 */         if (wsdlLocationURL == null) {
/* 50 */           baseUrl = (new File(".")).toURL();
/* 51 */           wsdlLocationURL = new URL(baseUrl, pro.getProperty("OUTBOUND_SERVICE_URL"));
/*    */         } 
/*    */       } else {
/* 57 */         if (!baseUrl.getPath().endsWith("/"))
/* 58 */           baseUrl = new URL(baseUrl, baseUrl.getPath() + "/"); 
/* 60 */         wsdlLocationURL = new URL(baseUrl, pro.getProperty("OUTBOUND_SERVICE_URL"));
/*    */       } 
/* 64 */     } catch (Exception e) {
/* 66 */       logger.log(Level.ALL, "Failed to create wsdlLocationURL using http://172.27.45.8:16035/soa-infra/services/default/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service?WSDL", e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public QFEQ_Outbound_WF015Service() {
/* 74 */     super(wsdlLocationURL, new QName("http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", "QFEQ_Outbound_WF015Service"));
/*    */   }
/*    */   
/*    */   public QFEQ_Outbound_WF015Service(URL wsdlLocationURL, QName serviceName) {
/* 81 */     super(wsdlLocationURL, serviceName);
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "execute_pt")
/*    */   public Execute_ptt getExecute_pt() {
/* 87 */     return getPort(new QName("http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", "execute_pt"), Execute_ptt.class);
/*    */   }
/*    */   
/*    */   @WebEndpoint(name = "execute_pt")
/*    */   public Execute_ptt getExecute_pt(WebServiceFeature... features) {
/* 95 */     return getPort(new QName("http://oracle.com/sca/soapservice/QFEQ_Outbound_WF015App/QFEQ_Outbound_WF015Impl/QFEQ_Outbound_WF015Service", "execute_pt"), Execute_ptt.class, features);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\OutboundService\client\QFEQ_Outbound_WF015Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */