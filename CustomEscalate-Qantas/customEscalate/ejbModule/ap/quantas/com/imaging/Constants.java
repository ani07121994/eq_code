/*    */ package ap.quantas.com.imaging;
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
/* 16 */     DEV,
/* 17 */     SIT,
/* 18 */     PSP,
/* 19 */     PROD,
/* 20 */     SAUAT;
/*    */     public String value() {
/* 22 */       return name();
/*    */     }
/*    */     public static ENV_TYPE fromValue(String v) {
/* 25 */       return valueOf(v);
/*    */     }
/*    */   }
/*    */   
/* 29 */   private static final ENV_TYPE compileFor = ENV_TYPE.PROD;
/*    */ 
/*    */   
/*    */   public static final String getURLPrefix(ENV_TYPE env) {
/* 33 */     if (env == ENV_TYPE.valueOf("DEV"))
/* 34 */       return "http://eqdev-capture1:19000"; 
/* 35 */     if (env == ENV_TYPE.valueOf("SIT"))
/*    */     {
/*    */       
/* 38 */       return "http://eqdev-capture1:19000"; } 
/* 39 */     if (env == ENV_TYPE.valueOf("PSP"))
/* 40 */       return "http://eqtest-capture1.qantas.com.au:16033"; 
/* 41 */     if (env == ENV_TYPE.valueOf("PROD"))
///* 42 */       return "http://eqprod-capture1.qantas.com.au:19000"; 
				 return "http://eqprod-capture1.qantas.com.au:16033"; // Prod 
/* 43 */     if (env == ENV_TYPE.valueOf("SAUAT")) {
/* 44 */       return "http://eqdev-capture1:16033";
/*    */     }
/* 46 */     return "http://www.google.com";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final String getLoginServiceURL() {
/* 52 */     return getURLPrefix(compileFor) + "/imaging/ws/LoginService?wsdl";
/*    */   }
/*    */   public static final String getDocumentServiceURL() {
/* 55 */     return getURLPrefix(compileFor) + "/imaging/ws/DocumentService?wsdl";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final String getEbsDataSourceName() {
/* 62 */     if (compileFor == ENV_TYPE.valueOf("DEV"))
/* 63 */       return "jdbc/DEV_APPS_NXA"; 
/* 64 */     if (compileFor == ENV_TYPE.valueOf("SIT"))
/* 65 */       return "jdbc/CRP2_APPS_NXA"; 
/* 66 */     if (compileFor == ENV_TYPE.valueOf("PSP")) {
/* 67 */       return "jdbc/PROD_APPS_NXA";
/*    */     }
/* 69 */     if (compileFor == ENV_TYPE.valueOf("PROD"))
/* 70 */       return "jdbc/PROD_APPS_NXA"; 
/* 71 */     if (compileFor == ENV_TYPE.valueOf("SAUAT")) {
/* 72 */       return "jdbc/SAUAT_APPS";
/*    */     }
/* 74 */     return "jdbc/ORACLE_EXADATA";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final String getEqfilesDataSourceName() {
/* 81 */     if (compileFor == ENV_TYPE.valueOf("DEV"))
/* 82 */       return "jdbc/DEV_EQFILES_NXA"; 
/* 83 */     if (compileFor == ENV_TYPE.valueOf("SIT"))
/* 84 */       return "jdbc/CRP2_EQFILES_NXA"; 
/* 85 */     if (compileFor == ENV_TYPE.valueOf("PSP"))
/*    */     {
/* 87 */       return "jdbc/PROD_EQFILES_NXA"; } 
/* 88 */     if (compileFor == ENV_TYPE.valueOf("PROD"))
/* 89 */       return "jdbc/PROD_EQFILES_NXA"; 
/* 90 */     if (compileFor == ENV_TYPE.valueOf("SAUAT")) {
/* 91 */       return "jdbc/SAUAT_EQFILES";
/*    */     }
/* 93 */     return "jdbc/ORACLE_EXADATA";
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */