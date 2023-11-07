/*    */ package qantas.eq.integration.util;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import java.util.logging.Logger;
/*    */ import qantas.eq.integration.QFEQIFBase;
/*    */ import qantas.eq.integration.QFEQIFLogger;
/*    */ import qantas.eq.integration.util.QFEQIFDatabaseConn;
/*    */ 
/*    */ public class QFEQIFTransactionUtil implements QFEQIFBase {
/* 14 */   private static Logger _QFEQLogger = QFEQIFLogger.getLogger(qantas.eq.integration.util.QFEQIFTransactionUtil.class.getName());
/*    */   
/*    */   public static void updateRecord(String m_fileName, String m_status) throws SQLException {
/* 20 */     Connection conn = QFEQIFDatabaseConn.getConnection();
/* 21 */     Statement pstmt = conn.createStatement();
/* 22 */     StringBuilder sb = new StringBuilder();
/* 23 */     sb.append("update qfeqif_status set status='" + m_status + "'");
/* 24 */     sb.append(" where filearrvdate = (SELECT MAX(filearrvdate) FROM qfeqif_status");
/* 25 */     sb.append(" where filename = '" + m_fileName + "')");
/* 26 */     String sql = sb.toString();
/* 27 */     pstmt.executeUpdate(sql);
/* 28 */     conn.commit();
/* 29 */     _QFEQLogger.info("File status updated successfully...");
/* 30 */     QFEQIFDatabaseConn.closeConnection();
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\non_prodwars\QantasIHubCryptoLargeFile.war!\WEB-INF\classes\qantas\eq\integratio\\util\QFEQIFTransactionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */