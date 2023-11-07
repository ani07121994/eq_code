/*    */ package qantas.eq.integration.util;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Properties;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.InitialContext;
/*    */ import javax.sql.DataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QFEQIFDatabaseConn
/*    */ {
/*    */   private static Connection connect;
/*    */   private static QFEQIFDatabaseConn instance;
/*    */   
/*    */   private QFEQIFDatabaseConn()
/*    */   {
/*    */     try
/*    */     {
/* 25 */       String configFile = System.getenv("QFEQIF_CONFIG");
/* 26 */       Properties pro = new Properties();
/* 27 */       pro.load(new FileInputStream(configFile));
/* 28 */       String dsName = pro.getProperty("IHUB_DATA_SOURCE");
/*    */       
/* 30 */       Context ic = new InitialContext();
/* 31 */       DataSource ds = (DataSource)ic.lookup(dsName);
/* 32 */       connect = ds.getConnection();
/*    */     } catch (Exception fnf) {
/* 34 */       System.err.println(fnf.getMessage());
/*    */     }
/*    */   }
/*    */   
/*    */   public static Connection getConnection()
/*    */   {
/* 40 */     if (instance == null) {
/* 41 */       instance = new QFEQIFDatabaseConn();
/*    */     }
/* 43 */     return connect;
/*    */   }
/*    */   
/*    */   public static void closeConnection()
/*    */   {
/*    */     try {
/* 49 */       if (instance != null)
/*    */       {
/* 51 */         connect.close();
/* 52 */         instance = null;
/*    */       }
/*    */     } catch (SQLException e) {
/* 55 */       System.err.println(e.getMessage());
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFDatabaseConn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */