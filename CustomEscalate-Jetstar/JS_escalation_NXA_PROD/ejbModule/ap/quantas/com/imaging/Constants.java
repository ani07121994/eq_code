/*    */ package ap.quantas.com.imaging;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Constants
/*    */ {
/*    */   private static final String IMAGING_URL_LOGIN_SERVICE = "/imaging/ws/LoginService?wsdl";
/*    */   private static final String IMAGING_URL_DOCUMENT_SERVICE = "/imaging/ws/DocumentService?wsdl";
/*    */   public static final String IMAGING_USERNAME = "weblogic";
/*    */   public static final String IMAGING_PASSWORD = "wls123@PRD";
/*    */   
/*    */   public enum ENV_TYPE
/*    */   {
/* 18 */     DEV,
/* 19 */     SIT,
/* 20 */     PSP,
/* 21 */     PROD,
/* 22 */     SAUAT;
/*    */     public String value() {
/* 24 */       return name();
/*    */     }
/*    */     public static ENV_TYPE fromValue(String v) {
/* 27 */       return valueOf(v);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 32 */   private static final ENV_TYPE compileFor = ENV_TYPE.PROD;
/*    */ 
/*    */   
/*    */   public static final String getURLPrefix(ENV_TYPE env) {
/* 36 */     if (env == ENV_TYPE.valueOf("DEV"))
/* 37 */       return "http://eqdev-capture1:19000"; 
/* 38 */     if (env == ENV_TYPE.valueOf("SIT"))
/*    */     {
/* 40 */       return "http://eqdev-capture1:19000"; } 
/* 41 */     if (env == ENV_TYPE.valueOf("PSP"))
/* 42 */       return "http://eqtest-capture1.qantas.com.au:16033"; 
/* 43 */     if (env == ENV_TYPE.valueOf("PROD"))
///* 44 */       return "http://eqprod-capture1.qantas.com.au:19000";
				return "http://eqprod-capture1.qantas.com.au:16033"; // Prod
/* 45 */     if (env == ENV_TYPE.valueOf("SAUAT")) {
/* 46 */       return "http://eqdev-capture1:16033";
/*    */     }
/* 48 */     return "http://www.google.com";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final String getLoginServiceURL() {
/* 54 */     return getURLPrefix(compileFor) + "/imaging/ws/LoginService?wsdl";
/*    */   }
/*    */   public static final String getDocumentServiceURL() {
/* 57 */     return getURLPrefix(compileFor) + "/imaging/ws/DocumentService?wsdl";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final String getEbsDataSourceName() {
/* 64 */     if (compileFor == ENV_TYPE.valueOf("DEV"))
/* 65 */       return "jdbc/DEV_APPS_NXA"; 
/* 66 */     if (compileFor == ENV_TYPE.valueOf("SIT"))
/* 67 */       return "jdbc/CRP2_APPS_NXA"; 
/* 68 */     if (compileFor == ENV_TYPE.valueOf("PSP")) {
/* 69 */       return "jdbc/PROD_APPS_NXA";
/*    */     }
/* 71 */     if (compileFor == ENV_TYPE.valueOf("PROD"))
/* 72 */       return "jdbc/PROD_APPS_NXA"; 
/* 73 */     if (compileFor == ENV_TYPE.valueOf("SAUAT")) {
/* 74 */       return "jdbc/SAUAT_APPS";
/*    */     }
/* 76 */     return "jdbc/ORACLE_EXADATA";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final String getEqfilesDataSourceName() {
/* 83 */     if (compileFor == ENV_TYPE.valueOf("DEV"))
/* 84 */       return "jdbc/DEV_EQFILES_NXA"; 
/* 85 */     if (compileFor == ENV_TYPE.valueOf("SIT"))
/* 86 */       return "jdbc/CRP2_EQFILES_NXA"; 
/* 87 */     if (compileFor == ENV_TYPE.valueOf("PSP")) {
/*    */       
/* 89 */       System.out.println("getEqfilesDataSourceName ::jdbc/PROD_EQFILES_NXA");
/* 90 */       return "jdbc/PROD_EQFILES_NXA";
/* 91 */     }  if (compileFor == ENV_TYPE.valueOf("PROD")) {
/* 92 */       System.out.println("getEqfilesDataSourceName ::jdbc/PROD_EQFILES_NXA");
/* 93 */       return "jdbc/PROD_EQFILES_NXA";
/* 94 */     }  if (compileFor == ENV_TYPE.valueOf("SAUAT")) {
/* 95 */       return "jdbc/SAUAT_EQFILES";
/*    */     }
/* 97 */     return "jdbc/ORACLE_EXADATA";
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */