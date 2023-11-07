/*    */ package qantas.eq.integration.util;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import java.util.logging.Logger;
/*    */ import qantas.eq.integration.QFEQIFBase;
/*    */ import qantas.eq.integration.QFEQIFLogger;
/*    */ 
/*    */ 
/*    */ public class QFEQIFTransactionUtil
/*    */   implements QFEQIFBase
/*    */ {
/* 14 */   private static Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFTransactionUtil.class.getName());
/*    */   
/*    */ 
/*    */   public static void updateRecord(String m_fileName, String m_status)
/*    */     throws SQLException
/*    */   {
/* 20 */     Connection conn = null;
/* 21 */     Statement pstmt = null;
/* 22 */     String sql = "";
/*    */     try {
/* 24 */       StringBuilder sb = new StringBuilder();
/* 25 */       sb.append("update qfeqif_status set status='" + m_status + "'");
/* 26 */       sb.append(" where filename = '" + m_fileName + "' and filearrvdate = (SELECT MAX(filearrvdate) FROM qfeqif_status");
/* 27 */       sb.append(" where filename = '" + m_fileName + "')");
/* 28 */       sql = sb.toString();
/* 29 */       conn = QFEQIFDatabaseConn.getConnection();
/* 30 */       pstmt = conn.createStatement();
/* 31 */       pstmt.executeUpdate(sql);
/* 32 */       conn.commit();
/* 33 */       _QFEQLogger.info("File status updated successfully...");
/* 34 */       QFEQIFDatabaseConn.closeConnection();
/*    */     } catch (SQLException e) {
/* 36 */       if (e.getErrorCode() == 17008) {
/*    */         try {
/* 38 */           conn = QFEQIFDatabaseConn.getConnection();
/* 39 */           pstmt.executeUpdate(sql);
/* 40 */           conn.commit();
/* 41 */           _QFEQLogger.info("File status updated successfully...");
/* 42 */           QFEQIFDatabaseConn.closeConnection();
/*    */         } catch (Exception ex) {
/* 44 */           _QFEQLogger.severe(QFEQIFCMSDKUtilSOA.stackTraceToString(ex));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFTransactionUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */