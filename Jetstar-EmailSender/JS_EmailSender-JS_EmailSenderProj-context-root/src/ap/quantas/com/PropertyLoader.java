/*    */ package ap.quantas.com;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class PropertyLoader {
/*  9 */   private static ap.quantas.com.PropertyLoader INSTANCE = null;
/*    */   
/*    */   private HashMap<String, Object> properties;
/*    */   
/* 13 */   private HashMap<Long, String> reasonCodeMap = null;
/*    */   
/* 14 */   private HashMap<Long, HashMap<Long, String>> reasonCodeTypeMap = null;
/*    */   
/* 16 */   private HashMap<String, BigDecimal> taxRatesMasterList = null;
/*    */   
/* 18 */   private HashMap<Long, String> internalStatusMap = null;
/*    */   
/*    */   private PropertyLoader() {
/* 21 */     this.properties = new HashMap<String, Object>();
/* 22 */     this.reasonCodeMap = new HashMap<Long, String>();
/* 23 */     this.reasonCodeTypeMap = new HashMap<Long, HashMap<Long, String>>();
/* 24 */     this.taxRatesMasterList = new HashMap<String, BigDecimal>();
/* 25 */     this.internalStatusMap = new HashMap<Long, String>();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.PropertyLoader getInstance() {
/* 29 */     if (INSTANCE == null)
/* 30 */       INSTANCE = new ap.quantas.com.PropertyLoader(); 
/* 32 */     return INSTANCE;
/*    */   }
/*    */   
/*    */   public void addProperty(String key, Object value) {
/* 37 */     this.properties.put(key, value);
/*    */   }
/*    */   
/*    */   public Object getProperty(String key) {
/* 41 */     return this.properties.get(key);
/*    */   }
/*    */   
/*    */   public HashMap<Long, String> getReasonCodeMap() {
/* 46 */     return this.reasonCodeMap;
/*    */   }
/*    */   
/*    */   public HashMap<Long, HashMap<Long, String>> getReasonCodeTypeMap() {
/* 50 */     return this.reasonCodeTypeMap;
/*    */   }
/*    */   
/*    */   public void setProperties(HashMap<String, Object> properties) {
/* 55 */     this.properties = properties;
/*    */   }
/*    */   
/*    */   public HashMap<String, Object> getProperties() {
/* 59 */     return this.properties;
/*    */   }
/*    */   
/*    */   public void setTaxRatesMasterList(HashMap<String, BigDecimal> taxRatesMasterList) {
/* 64 */     this.taxRatesMasterList = taxRatesMasterList;
/*    */   }
/*    */   
/*    */   public HashMap<String, BigDecimal> getTaxRatesMasterList() {
/* 68 */     return this.taxRatesMasterList;
/*    */   }
/*    */   
/*    */   public void setInternalStatusMap(HashMap<Long, String> internalStatusMap) {
/* 73 */     this.internalStatusMap = internalStatusMap;
/*    */   }
/*    */   
/*    */   public HashMap<Long, String> getInternalStatusMap() {
/* 77 */     return this.internalStatusMap;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\PropertyLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */