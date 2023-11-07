/*    */ package qantas.eq.integration.util;
/*    */ 
/*    */ import qantas.eq.integration.QFEQIFBase;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QFEQIFUtil
/*    */   implements QFEQIFBase
/*    */ {
/* 30 */   private final String CLASS_NAME = getClass().getName();
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
/*    */ 
/*    */   public static synchronized String toBlank(String p_str)
/*    */   {
/* 44 */     return p_str == null ? "" : p_str;
/*    */   }
/*    */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */