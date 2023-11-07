/*    */ package qantas.eq.integration.util;
/*    */ 
/*    */ import qantas.eq.integration.QFEQIFBase;
/*    */ 
/*    */ public class QFEQIFUtil implements QFEQIFBase {
/* 30 */   private final String CLASS_NAME = getClass().getName();
/*    */   
/*    */   public static synchronized String toBlank(String p_str) {
/* 44 */     return (p_str == null) ? "" : p_str;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\non_prodwars\QantasIHubCryptoLargeFile.war!\WEB-INF\classes\qantas\eq\integratio\\util\QFEQIFUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */