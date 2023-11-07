/*    */ package qantas.eq.integration.ftp;
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
/*    */ 
/*    */ public abstract class QFEQIFWorkflowBase
/*    */   implements QFEQIFBase
/*    */ {
/* 31 */   protected String m_fileName = "";
/* 32 */   protected String m_targetFolder = "";
/* 33 */   protected String m_sourceFolder = "";
/* 34 */   protected String m_overwriteFlag = "";
/*    */   
/*    */ 
/*    */   public static final String IFS_WF = "WF";
/*    */   
/*    */ 
/*    */   public static final String IFS_WF_FN_ERROR = "WF_FN_ERROR";
/*    */   
/*    */ 
/*    */   public static final String IFS_WF_MODULE = "MODULE";
/*    */   
/*    */ 
/*    */   public static final String IFS_WF_ITEM_TYPE = "ITEMTYPE";
/*    */   
/*    */ 
/*    */   public static final String IFS_WF_ITEM_KEY = "ITEMKEY";
/*    */   
/*    */ 
/*    */   public static final String IFS_WF_ACT_ID = "ACTID";
/*    */   
/*    */ 
/*    */   public static final String IFS_WF_FUNCTION_MODE = "FUNCMODE";
/*    */   
/*    */   public static final String IFS_WF_ERROR_MESSAGE = "ERRMESSAGE";
/*    */   
/*    */ 
/*    */   public boolean isBinaryXfer(String p_xferMode)
/*    */   {
/* 62 */     return p_xferMode.toUpperCase().equals("I");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isPassive(String p_isPassive)
/*    */   {
/* 73 */     return p_isPassive.toUpperCase().equals("P");
/*    */   }
/*    */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.ftp.QFEQIFWorkflowBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */