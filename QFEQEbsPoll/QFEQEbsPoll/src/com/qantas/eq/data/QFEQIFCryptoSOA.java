/*    */ package com.qantas.eq.data;
/*    */ 
/*    */ import java.sql.CallableStatement;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class QFEQIFCryptoSOA {
/* 19 */   static final Logger _logger = Logger.getLogger(com.qantas.eq.data.QFEQIFCryptoSOA.class);
/*    */   
/* 20 */   private Connection m_conn = null;
/*    */   
/* 21 */   private final String CLASS_NAME = getClass().getName();
/*    */   
/*    */   public QFEQIFCryptoSOA(Connection p_conn) {
/* 26 */     this.m_conn = p_conn;
/*    */   }
/*    */   
/*    */   public QFEQIFCryptoSOA() {}
/*    */   
/*    */   public String decrypt(String p_encryptedText) {
/* 36 */     String METHOD_NAME = this.CLASS_NAME + ".decrypt";
/* 37 */    // _logger.info("Entering " + METHOD_NAME);
/* 39 */     String decryptedText = null;
/*    */     try {
/* 43 */       String sStmt = "{call QFEQIF_UTIL_PKG.DECRYPT(?, ?)}";
/* 45 */       CallableStatement procStmt = this.m_conn.prepareCall(sStmt);
/* 48 */       procStmt.setString(1, p_encryptedText);
/* 50 */       procStmt.registerOutParameter(2, 12);
/* 52 */       procStmt.execute();
/* 53 */       decryptedText = procStmt.getString(2);
/* 55 */       procStmt.close();
/* 56 */     } catch (SQLException ex) {
/* 57 */       _logger.error("Caught SQLException in decrypt : " + ex.getMessage());
/* 58 */     } catch (Exception ex) {
/* 59 */       _logger.error("Caught Exception in decrypt : " + ex.getMessage());
/*    */     } 
/* 62 */     //_logger.info("Exiting " + METHOD_NAME);
/* 63 */     return decryptedText;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\data\QFEQIFCryptoSOA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */