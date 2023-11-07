/*     */ package com.qantas.eq.data;
/*     */ 
/*     */ import com.qantas.eq.OutboundService.client.Execute_ptt;
/*     */ import com.qantas.eq.OutboundService.client.QFEQ_Outbound_WF015Service;
/*     */ import com.qantas.eq.OutboundService.genJava.ObjectFactory;
/*     */ import com.qantas.eq.OutboundService.genJava.QFEQIFEBSSOAOUT;
/*     */ import com.qantas.eq.data.QFEQIF_EBS_SOA_OUT;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.Properties;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.sql.DataSource;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import oracle.AQ.AQDequeueOption;
/*     */ import oracle.AQ.AQDriverManager;
/*     */ import oracle.AQ.AQEnqueueOption;
/*     */ import oracle.AQ.AQMessage;
/*     */ import oracle.AQ.AQObjectPayload;
/*     */ import oracle.AQ.AQOracleQueue;
/*     */ import oracle.AQ.AQOracleSQLException;
/*     */ import oracle.AQ.AQOracleSession;
/*     */ import oracle.AQ.AQQueue;
/*     */ import oracle.AQ.AQSession;
/*     */ import oracle.sql.CLOB;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QFEQIFReadAQ {
/*     */   private static QFEQ_Outbound_WF015Service qFEQ_Outbound_WF015Service;
/*     */   
/*  53 */   private static Logger _logger = Logger.getLogger(com.qantas.eq.data.QFEQIFReadAQ.class);
/*     */   
/*     */   public static AQSession createSession() {
/*  62 */     AQSession aq_sess = null;
/*     */     try {
/*  65 */       String configFile = System.getenv("QFEQIF_CONFIG");
/*  66 */       Properties pro = new Properties();
/*  67 */       pro.load(new FileInputStream(configFile));
/*  68 */       String dsName = pro.getProperty("EBS_DATA_SOURCE");
/*  70 */       Context ic = new InitialContext();
/*  71 */       DataSource ds = (DataSource)ic.lookup(dsName);
/*  72 */       Connection db_conn = ds.getConnection();
/*  74 */       //_logger.info("***************Opened JDBC Connection to EBS***************");
/*  75 */       db_conn.setAutoCommit(false);
/*  78 */       Class.forName("oracle.AQ.AQOracleDriver");
/*  81 */       aq_sess = AQDriverManager.createAQSession(db_conn);
/*  82 */      // _logger.info("**********************Successfully created AQSession**********************");
/*  83 */     } catch (Exception e) {
/*  84 */       _logger.error("Exception occurred in Dequeue :: " + stackTraceToString(e));
/*     */     } 
/*  86 */     return aq_sess;
/*     */   }
/*     */   
/*     */   public static QFEQIF_EBS_SOA_OUT AQObjectPayloadRead() {
/*  91 */     Connection db_conn = null;
/*  92 */     AQQueue queue = null;
/*  93 */     AQMessage message = null;
/*  94 */     AQObjectPayload payload = null;
/*  95 */     AQEnqueueOption eq_option = null;
/*  96 */     AQDequeueOption dq_option = null;
/*  97 */     QFEQIF_EBS_SOA_OUT EBS_SOA_OUT = null;
/*  99 */     AQSession aq_sess = null;
/* 100 */     Connection conn = null;
/* 101 */     Statement stmt = null;
/* 102 */     ResultSet rs = null;
/* 104 */     String IFS_ADMIN_USER = "";
/* 105 */     String IFS_ADMIN_PWD = "";
/* 106 */     String IFS_SERVICE = "";
/* 107 */     String IFS_SYS_PWD = "";
/* 109 */     Properties pro = new Properties();
/* 110 */     String configFilePath = "";
/* 112 */     InputStream is = null;
/* 113 */     OutputStream os = null;
/* 114 */     String locPath = "";
			  String ifid = "";
/* 115 */     String outputFileName = "";
/*     */     try {
/* 118 */       configFilePath = System.getenv("QFEQIF_CONFIG");
/* 119 */       pro.load(new FileInputStream(configFilePath));
/* 121 */       aq_sess = createSession();
/* 122 */       db_conn = ((AQOracleSession)aq_sess).getDBConnection();
/* 123 */       queue = aq_sess.getQueue("BOLINF", "QFEQIF_EBS_SOAOUT");
/* 124 */       dq_option = new AQDequeueOption();
/* 125 */       String dequeue_condition = "TAB.USER_DATA.EVENT_NAME = 'NEWLOBFILE' and TAB.USER_DATA.EVENT_KEY in (" + pro.getProperty("CUSTOM.DEQUEUE") + ")";
/* 126 */       dq_option.setCondition(dequeue_condition);
/* 127 */       dq_option.setDequeueMode(3);
/* 128 */       dq_option.setWaitTime(10);
/*     */       do {
/* 131 */         //_logger.info("*******************Starting Dequeue**********************");
/* 132 */         message = ((AQOracleQueue)queue).dequeue(dq_option, Class.forName("com.qantas.eq.data.QFEQIF_EBS_SOA_OUT"));
/* 133 */         //_logger.info("****************Record Dequeued*********************");
/* 135 */         payload = message.getObjectPayload();
/* 136 */         EBS_SOA_OUT = (QFEQIF_EBS_SOA_OUT)payload.getPayloadData();
/* 138 */         //_logger.info("Object data retrieved:  [QFEQIF_EBS_SOA_OUT]");
/* 139 */         _logger.info("ITEMTYPE: " + EBS_SOA_OUT.ITEMTYPE);
/* 140 */         _logger.info("ITEMKEY: " + EBS_SOA_OUT.ITEMKEY);
/* 141 */         _logger.info("File_Name: " + EBS_SOA_OUT.File_Name);
/* 142 */         _logger.info("File_path: " + EBS_SOA_OUT.File_path);
/* 143 */         _logger.info("CMREQID: " + EBS_SOA_OUT.CMREQID);
/* 144 */         _logger.info("CMRETCODE: " + EBS_SOA_OUT.CMRETCODE);
/* 145 */         _logger.info("CMRETMSG: " + EBS_SOA_OUT.CMRETMSG);
/* 146 */         _logger.info("CMRECCNT: " + EBS_SOA_OUT.CMRECCNT);
/* 147 */         _logger.info("EVENT_NAME: " + EBS_SOA_OUT.EVENT_NAME);
/* 148 */         _logger.info("EVENT_KEY: " + EBS_SOA_OUT.EVENT_KEY);
/* 152 */         outputFileName = EBS_SOA_OUT.File_Name;
				  ifid = EBS_SOA_OUT.EVENT_KEY;
				  outputFileName = ifid+"_"+outputFileName;
/* 153 */         CLOB data = (CLOB)EBS_SOA_OUT.Payload;
/* 158 */         String dsName = pro.getProperty("IHUB_DATA_SOURCE");
/* 160 */         Context ic = new InitialContext();
/* 161 */         DataSource ds = (DataSource)ic.lookup(dsName);
/* 162 */         conn = ds.getConnection();
/* 195 */         String sql = "select * from qfeqif_properties qfe where qfe.name in ('OUTBOUND_LOCALPATH')";
/* 196 */         stmt = conn.createStatement();
/* 197 */         rs = stmt.executeQuery(sql);
/* 199 */         while (rs.next())
/* 200 */           locPath = rs.getString("VALUE").trim(); 
/* 205 */         if (locPath.endsWith("/")) {
/* 206 */           outputFileName = locPath + outputFileName;
/*     */         } else {
/* 208 */           outputFileName = locPath + "/" + outputFileName;
/*     */         } 
				System.out.println("outputFileName"+outputFileName);
/* 211 */         is = data.getAsciiStream();
/* 212 */         os = new FileOutputStream(new File(outputFileName));
/* 214 */         int read = 0;
/* 215 */         byte[] bytes = new byte[1024];
/* 217 */         while ((read = is.read(bytes)) != -1)
/* 218 */           os.write(bytes, 0, read); 
/* 221 */         if (is != null)
/* 222 */           is.close(); 
/* 225 */         if (os != null)
/* 226 */           os.close(); 
/* 237 */         qFEQ_Outbound_WF015Service = new QFEQ_Outbound_WF015Service();
/* 238 */         Execute_ptt execute_ptt = qFEQ_Outbound_WF015Service.getExecute_pt();
/* 240 */         ObjectFactory objectFactory = new ObjectFactory();
/* 241 */         QFEQIFEBSSOAOUT SOA_OUT = objectFactory.createQFEQIFEBSSOAOUT();
/* 243 */         JAXBElement<String> itemtype = objectFactory.createQFEQIFEBSSOAOUTITEMTYPE(EBS_SOA_OUT.ITEMTYPE);
/* 244 */         SOA_OUT.setITEMTYPE(itemtype);
/* 246 */         JAXBElement<String> itemkey = objectFactory.createQFEQIFEBSSOAOUTITEMKEY(EBS_SOA_OUT.ITEMKEY);
/* 247 */         SOA_OUT.setITEMKEY(itemkey);
/* 249 */         //JAXBElement<String> filename = objectFactory.createQFEQIFEBSSOAOUTFILENAME(EBS_SOA_OUT.File_Name);
				  JAXBElement<String> filename = objectFactory.createQFEQIFEBSSOAOUTFILENAME(ifid+"_"+EBS_SOA_OUT.File_Name);
				  System.out.println("ifid"+ifid+"..."+"filename"+filename);
/* 250 */         SOA_OUT.setFILENAME(filename);
/* 252 */         JAXBElement<String> filepath = objectFactory.createQFEQIFEBSSOAOUTFILEPATH(EBS_SOA_OUT.File_path);
/* 253 */         SOA_OUT.setFILEPATH(filepath);
/* 255 */         JAXBElement<String> cmreqid = objectFactory.createQFEQIFEBSSOAOUTCMREQID(EBS_SOA_OUT.CMREQID);
/* 256 */         SOA_OUT.setCMREQID(cmreqid);
/* 258 */         JAXBElement<String> cmretcode = objectFactory.createQFEQIFEBSSOAOUTCMRETCODE(EBS_SOA_OUT.CMRETCODE);
/* 259 */         SOA_OUT.setCMRETCODE(cmretcode);
/* 261 */         JAXBElement<String> cmretmsg = objectFactory.createQFEQIFEBSSOAOUTCMRETMSG(EBS_SOA_OUT.CMRETMSG);
/* 262 */         SOA_OUT.setCMRETMSG(cmretmsg);
/* 264 */         JAXBElement<String> cmreccnt = objectFactory.createQFEQIFEBSSOAOUTCMRECCNT(EBS_SOA_OUT.CMRECCNT);
/* 265 */         SOA_OUT.setCMRECCNT(cmreccnt);
/* 267 */         JAXBElement<String> eventname = objectFactory.createQFEQIFEBSSOAOUTEVENTNAME(EBS_SOA_OUT.EVENT_NAME);
/* 268 */         SOA_OUT.setEVENTNAME(eventname);
/* 270 */         JAXBElement<String> eventkey = objectFactory.createQFEQIFEBSSOAOUTEVENTKEY(EBS_SOA_OUT.EVENT_KEY);
/* 271 */         SOA_OUT.setEVENTKEY(eventkey);
/* 273 */         JAXBElement<String> Data = objectFactory.createQFEQIFEBSSOAOUTPAYLOAD("");
/* 274 */         SOA_OUT.setPAYLOAD(Data);
/* 276 */         JAXBElement<String> queuedate = objectFactory.createQFEQIFEBSSOAOUTQUEUEDATE("");
/* 277 */         SOA_OUT.setQUEUEDATE(queuedate);
/* 279 */         //_logger.info("**********************Calling Outbound Process**********************");
/* 280 */         execute_ptt.execute(SOA_OUT);
/* 281 */        // _logger.info("**********************File Processing Starts in eQ**********************");
/* 283 */         db_conn.commit();
/* 284 */       } while (message != null);
/* 286 */       queue.close();
/* 287 */       db_conn.commit();
/* 288 */       db_conn.close();
/* 289 */     } catch (AQOracleSQLException aqx) {
/* 290 */       if (aqx.getErrorCode() == 25228) {
/* 291 */         _logger.warn("No data in queue.");
/*     */       } else {
/* 293 */         _logger.error("Oracle AQ Error Occurred : " + stackTraceToString((Throwable)aqx));
/*     */       } 
/* 295 */     } catch (Exception e) {
/* 296 */       _logger.error("Error in EBS Poll : " + stackTraceToString(e));
/*     */     } finally {
/*     */       try {
/* 299 */         aq_sess.close();
/* 300 */         db_conn.close();
/* 301 */         conn.close();
/* 302 */       } catch (Exception ex) {}
/*     */     } 
/* 306 */     return EBS_SOA_OUT;
/*     */   }
/*     */   
/*     */   public static void writeToFile(CLOB xmlDocument, String outputTextFileName1) {
/* 310 */     File outputTextFile1 = null;
/* 311 */     FileOutputStream outputFileOutputStream = null;
/* 312 */     OutputStreamWriter outputOutputStreamWriter = null;
/* 313 */     BufferedWriter outputBufferedWriter = null;
/* 314 */     String sqlText = null;
/* 315 */     Statement stmt = null;
/* 316 */     ResultSet rset = null;
/* 317 */     String locPath = null;
/* 318 */     int charsRead = 0;
/* 319 */     int charsWritten = 0;
/* 320 */     int totCharsRead = 0;
/* 321 */     int totCharsWritten = 0;
/* 326 */     Connection connect = null;
/*     */     try {
/* 329 */       String configFile = System.getenv("QFEQIF_CONFIG");
/* 330 */       Properties pro = new Properties();
/* 331 */       pro.load(new FileInputStream(configFile));
/* 332 */       String dsName = pro.getProperty("IHUB_DATA_SOURCE");
/* 334 */       Context ic = new InitialContext();
/* 335 */       DataSource ds = (DataSource)ic.lookup(dsName);
/* 336 */       connect = ds.getConnection();
/* 338 */       sqlText = "select * from qfeqif_properties qfe where qfe.name in ('OUTBOUND_LOCALPATH')";
/* 339 */       stmt = connect.createStatement();
/* 340 */       rset = stmt.executeQuery(sqlText);
/* 342 */       while (rset.next())
/* 343 */         locPath = rset.getString("VALUE").trim(); 
/* 346 */       if (locPath.endsWith("/")) {
/* 347 */         outputTextFileName1 = locPath + outputTextFileName1;
/*     */       } else {
/* 349 */         outputTextFileName1 = locPath + "/" + outputTextFileName1;
/*     */       } 
/* 351 */       connect.close();
/* 353 */       outputTextFile1 = new File(outputTextFileName1);
/* 354 */       outputFileOutputStream = new FileOutputStream(outputTextFile1);
/* 355 */       outputOutputStreamWriter = new OutputStreamWriter(outputFileOutputStream);
/* 356 */       outputBufferedWriter = new BufferedWriter(outputOutputStreamWriter);
/* 359 */       long clobLength = xmlDocument.length();
/* 360 */       int chunkSize = xmlDocument.getChunkSize();
/* 361 */       char[] textBuffer = new char[chunkSize];
/* 363 */      // _logger.info("Writing data into file");
/*     */       long position;
/* 364 */       for (position = 1L; position <= clobLength; position += chunkSize) {
/* 369 */         charsRead = xmlDocument.getChars(position, chunkSize, textBuffer);
/* 372 */         outputBufferedWriter.write(textBuffer, 0, charsRead);
/* 374 */         totCharsRead += charsRead;
/* 375 */         totCharsWritten += charsRead;
/*     */       } 
/* 378 */       outputBufferedWriter.close();
/* 379 */       outputOutputStreamWriter.close();
/* 380 */       outputFileOutputStream.close();
/* 381 */      // _logger.info("Data written to " + outputTextFileName1);
/* 382 */     } catch (Exception e) {
/* 383 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 386 */         connect.close();
/* 387 */       } catch (Exception sqlx) {
/* 388 */        // _logger.info("Error closing DB Connection " + sqlx.getMessage());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String stackTraceToString(Throwable e) {
/* 394 */     StringBuilder sb = new StringBuilder();
/* 395 */     for (StackTraceElement element : e.getStackTrace()) {
/* 396 */       sb.append(element.toString());
/* 397 */       sb.append("\n");
/*     */     } 
/* 399 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\data\QFEQIFReadAQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */