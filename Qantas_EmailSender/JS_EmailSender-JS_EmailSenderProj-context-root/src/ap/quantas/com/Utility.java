/*     */ package ap.quantas.com;
/*     */ 
/*     */ import ap.quantas.com.FileDescriptor;
/*     */ import ap.quantas.com.PropertyLoader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import javax.activation.DataHandler;
/*     */ import javax.mail.Session;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.naming.NamingException;
/*     */ import javax.sql.DataSource;
/*     */ import oracle.imaging.BasicUserToken;
/*     */ import oracle.imaging.DocumentContentService;
/*     */ import oracle.imaging.NameId;
/*     */ import oracle.imaging.Search;
/*     */ import oracle.imaging.SearchArgument;
/*     */ import oracle.imaging.SearchService;
/*     */ import oracle.imaging.SearchValue;
/*     */ import oracle.imaging.ServicesFactory;
/*     */ import oracle.imaging.UserToken;
/*     */ 
/*     */ public class Utility {
/*  74 */   PropertyLoader propertyLoader = PropertyLoader.getInstance();
/*     */   
/*     */   public static final String deployment_env = "PROD";
/*     */   
/*     */   public DataSource getDataSource() throws NamingException {
/*  86 */     String jndi_name = "";
/*  87 */     if (deployment_env.equals("DEV")) {
/*  88 */       jndi_name = "jdbc/DEV_EQFILES_NXA";
/*  90 */     } else if (deployment_env.equals("SIT")) {
/*  91 */       jndi_name = "jdbc/CRP2_APPS_NXA";
/*  92 */     } else if (deployment_env.equals("PSP")) {
/*  93 */       jndi_name = "jdbc/PROD_EQFILES_NXA";
/*  94 */     } else if (deployment_env.equals("PROD")) {
/*  95 */       jndi_name = "jdbc/PROD_EQFILES_NXA";
/*     */     } 
/*  99 */     Context initContext = new InitialContext();
/* 100 */     DataSource ds = (DataSource)initContext.lookup(jndi_name);
/* 102 */     return ds;
/*     */   }
/*     */   
/*     */   public Session getMailSession() throws NamingException {
/* 115 */     InitialContext ic = new InitialContext();
/* 116 */     Session session = (Session)ic.lookup("smtp/mailSession");
/* 119 */     return session;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getDocument(String captureBatchID, String document_name) throws FileNotFoundException {
/* 129 */     String imaging_ws_url = null;
/* 130 */     if (deployment_env.equals("DEV")) {
/* 131 */       imaging_ws_url = "http://eqdev-capture1.qantas.com.au:19000/imaging/ws";
/* 133 */     } else if (deployment_env.equals("SIT")) {
/* 134 */       imaging_ws_url = "http://eqdev-capture1.qantas.com.au:19000/imaging/ws";
/* 135 */     } else if (deployment_env.equals("PSP")) {
/* 136 */       imaging_ws_url = "http://eqtest-capture1.qantas.com.au:16033/imaging/ws";
/* 137 */     } else if (deployment_env.equals("PROD")) {
///* 138 */       imaging_ws_url = "http://eqprod-capture1.qantas.com.au:19000/imaging/ws";
				imaging_ws_url = "http://eqprod-capture1.qantas.com.au:16033/imaging/ws";
/*     */     } 
/* 141 */     byte[] byteArray = null;
/* 142 */     FileDescriptor fd = new FileDescriptor();
/* 143 */     DataHandler fileData = null;
/* 144 */     FileOutputStream outputStream = null;
/* 158 */     ArrayList<String> downloaddocName_list = new ArrayList<String>();
/*     */     try {
/* 160 */       System.out.println("captureBatchID , document_name===" + captureBatchID + "," + document_name);
/* 162 */       BasicUserToken basicUserToken = new BasicUserToken(this.propertyLoader.getProperty("IMAGING_DOCUMENT_CONTENT_SERVICE_USERNAME").toString(), this.propertyLoader.getProperty("IMAGING_DOCUMENT_CONTENT_SERVICE_PASSWORD").toString());
/* 164 */       System.out.println("before servicesFactory imaging_ws_url :: " + imaging_ws_url);
/* 165 */       ServicesFactory servicesFactory = ServicesFactory.login((UserToken)basicUserToken, Locale.US, imaging_ws_url);
/*     */       try {
/* 173 */         SearchService searchService = servicesFactory.getSearchService();
/* 174 */         DocumentContentService docContentService = servicesFactory.getDocumentContentService();
/* 177 */         List<SearchArgument> searchArguments = new ArrayList<SearchArgument>();
/* 180 */         SearchValue searchValue = new SearchValue(SearchValue.Type.TEXT, captureBatchID);
/* 181 */         SearchArgument searchArgument = new SearchArgument("Capture Batch ID", searchValue);
/* 182 */         searchArgument.setOperatorValue(Search.Operator.CONTAINS);
/* 183 */         searchArguments.add(searchArgument);
/* 193 */         System.out.println("before searching imaging Qantas:: JS_QF_Search_Invoice_ALL");
/* 195 */         Search.ResultSet resultSet = searchService.executeSavedSearch(new NameId("JS_QF_Search_Invoice_ALL"), searchArguments);
/* 197 */         if (resultSet.getTotalResults() == 0)
/* 201 */           throw new FileNotFoundException("Document not found"); 
/* 204 */         if (resultSet.getTotalResults() != 0) {
/* 205 */           ArrayList<Search.Result> resultList = (ArrayList<Search.Result>)resultSet.getResults();
/* 207 */           for (Search.Result r : resultList) {
/* 208 */             String documentId = r.getDocumentId();
/* 209 */             String strDowunloadDocName = r.getDocument().getName();
/* 211 */             System.out.println("documentId=" + documentId + ", documentName=" + strDowunloadDocName);
/* 215 */             fileData = docContentService.retrieve(documentId);
/* 217 */             System.out.println("filedata from docContentService");
/* 221 */             File file = new File(this.propertyLoader.getProperty("FILE_UPLOAD_SERVER_PATH").toString() + strDowunloadDocName);
/* 226 */             file.setReadable(true, false);
/* 227 */             file.setExecutable(true, false);
/* 228 */             file.setWritable(true, false);
/* 230 */             outputStream = new FileOutputStream(file);
/* 232 */             fileData.writeTo(outputStream);
/* 234 */             if (outputStream != null) {
/* 235 */               outputStream.close();
/* 236 */               outputStream.flush();
/*     */             } 
/* 238 */             fd.setBytedata(byteArray);
/* 241 */             System.out.println("wrote to file ");
/* 242 */             downloaddocName_list.add(this.propertyLoader.getProperty("FILE_UPLOAD_SERVER_PATH").toString() + strDowunloadDocName);
/*     */           } 
/*     */         } 
/*     */       } finally {
/*     */         try {
/* 252 */           if (servicesFactory != null) {
/* 253 */             servicesFactory.logout();
/* 254 */             System.out.println("servicesFactory.logout() done ");
/*     */           } 
/* 256 */           if (outputStream != null) {
/* 257 */             outputStream.close();
/* 258 */             System.out.println("closed outputStream ");
/*     */           } 
/* 262 */         } catch (Exception e) {}
/*     */       } 
/* 267 */     } catch (FileNotFoundException e) {
/* 268 */       throw new FileNotFoundException();
/* 270 */     } catch (Exception e) {
/* 271 */       System.out.println(e.getMessage());
/*     */     } 
/* 276 */     System.out.println("returning file locations-----downloaddocName_list size ---" + downloaddocName_list.size());
/* 277 */     for (String file_path : downloaddocName_list)
/* 278 */       System.out.println("File path ----" + file_path); 
/* 281 */     return downloaddocName_list;
/*     */   }
/*     */   
/*     */   public String setEmailLink(String body, String documentId) {
/* 373 */     String bodyPart = null;
/* 375 */     if (documentId != null)
/* 377 */       System.out.println("document id in setEmailLink ::: " + documentId); 
/* 378 */     if (body != null && body.contains("Click here"))
/* 380 */       body = body.replace("Click here", "<a href=\"" + this.propertyLoader.getProperty("IMAGE_URL_ADF").toString() + documentId + "\">Click here</a>"); 
/* 382 */     System.out.println("body in setEmailLink :: " + body);
/* 383 */     return body;
/*     */   }
/*     */   
/*     */   public Map<String, String> initEmailParams(String reasonTypeId, String supplierName, String siteId, String invoiceNum, String invoiceDate) throws NamingException, SQLException {
/* 392 */     Map<String, String> emailMap = new HashMap<String, String>();
/* 394 */     if (reasonTypeId != null)
/* 395 */       System.out.println("reasonTypeId :: " + reasonTypeId); 
/* 398 */     System.out.println("initEmailParams>>reasonTypeId>>" + reasonTypeId);
/* 400 */     DataSource ds = getDataSource();
/* 402 */     System.out.println("after getting datasource");
/* 404 */     System.out.println("Ds properties :: " + ds.toString());
/* 407 */     String reasonId = null;
/* 408 */     ResultSet rs2 = null;
/* 409 */     Connection conn = null;
/* 410 */     ResultSet rs = null;
/*     */     try {
/* 412 */       conn = ds.getConnection();
/* 413 */       if (conn != null) {
/* 414 */         System.out.println("Connection not null");
/* 417 */         rs2 = conn.createStatement().executeQuery("select id from ap_reason_type WHERE reason_type='" + reasonTypeId + "'");
/* 419 */         System.out.println("rs :: ");
/* 422 */         StringBuilder emailBody = new StringBuilder();
/* 425 */         if (rs2.next()) {
/* 426 */           System.out.println("Body :: " + rs2.getString(1));
/* 428 */           if (rs2.getString(1) != null)
/* 429 */             reasonId = rs2.getString(1); 
/*     */         } 
/* 435 */         rs2.close();
/*     */       } 
/* 439 */       System.out.println("Reason id :: " + reasonId);
/* 441 */       if (reasonTypeId != null && reasonTypeId.equals("DUPLICATE INVOICE"))
/* 443 */         reasonId = "65"; 
/* 482 */       System.out.println("Reason id :: " + reasonId);
/* 483 */       if (conn != null) {
/* 484 */         System.out.println("Connection not null");
/* 485 */         rs = conn.createStatement().executeQuery("select body,email_to,email_from,subject,cc,bcc from ap_email_table where reason_type_id='" + reasonId + "'");
/* 487 */         System.out.println("rs :: ");
/* 489 */         String emailBodyString = null;
/* 490 */         StringBuilder emailBody = new StringBuilder();
/* 493 */         if (rs.next()) {
/* 494 */           System.out.println("Body :: " + rs.getString(1));
/* 497 */           if (rs.getString(1) != null) {
/* 499 */             String modifiedMailBody = modifyEmail(rs.getString(1), supplierName, siteId, invoiceNum, invoiceDate);
/* 500 */             String put = emailMap.put("body", modifiedMailBody);
/*     */           } 
/* 504 */           emailMap.put("email_to", rs.getString(2));
/* 505 */           emailMap.put("email_from", rs.getString(3));
/* 506 */           if (rs.getString(4) != null) {
/* 507 */             String modifiedMailSubject = modifyEmail(rs.getString(4), supplierName, siteId, invoiceNum, invoiceDate);
/* 508 */             emailMap.put("subject", modifiedMailSubject);
/*     */           } 
/* 512 */           emailMap.put("cc", rs.getString(5));
/* 513 */           emailMap.put("bcc", rs.getString(6));
/*     */         } 
/* 518 */         rs.close();
/* 522 */         System.out.println("emailMap :: " + emailMap.size());
/* 523 */         for (String key : emailMap.keySet())
/* 525 */           System.out.println("emailMap key :: " + (String)emailMap.get(key)); 
/*     */       } 
/* 529 */     } catch (SQLException e) {
/* 530 */       System.out.println(" database error ");
/*     */     } finally {
/* 536 */       if (rs2 != null)
/* 537 */         rs2.close(); 
/* 540 */       if (rs != null)
/* 541 */         rs.close(); 
/* 543 */       if (conn != null) {
/* 544 */         System.out.println("Closing connection after calling utility");
/* 545 */         conn.close();
/*     */       } 
/*     */     } 
/* 549 */     System.out.println("emailMap key :: " + emailMap.size());
/* 550 */     return emailMap;
/*     */   }
/*     */   
/*     */   private String modifyEmail(String emailString, String supplierName_tobe_replaced, String siteId_tobe_replaced, String invoiceNum_tobe_replaced, String invoiceDate_tobe_replaced) {
/* 556 */     String supplierName = null;
/* 557 */     String siteId = null;
/* 558 */     String invoiceNum = null;
/* 559 */     String invoiceDate = null;
/* 560 */     if (supplierName_tobe_replaced != null) {
/* 561 */       supplierName = supplierName_tobe_replaced.toString();
/* 562 */       if (emailString.contains("&SupplierName"))
/* 563 */         emailString = emailString.replaceAll("&SupplierName", supplierName); 
/*     */     } 
/* 568 */     if (siteId_tobe_replaced != null) {
/* 569 */       siteId = siteId_tobe_replaced.toString();
/* 570 */       System.out.println("site id :" + siteId);
/* 571 */       if (emailString.contains("&SiteID"))
/* 572 */         emailString = emailString.replaceAll("&SiteID", siteId); 
/*     */     } 
/* 575 */     if (invoiceNum_tobe_replaced != null) {
/* 576 */       invoiceNum = invoiceNum_tobe_replaced.toString();
/* 577 */       System.out.println("ivoice Number " + invoiceNum);
/* 578 */       if (emailString.contains("&InvoiceNum"))
/* 579 */         emailString = emailString.replaceAll("&InvoiceNum", invoiceNum); 
/*     */     } 
/* 583 */     if (invoiceDate_tobe_replaced != null) {
/* 584 */       invoiceDate = invoiceDate_tobe_replaced.toString();
/* 585 */       System.out.println("invoiceDate " + invoiceDate);
/* 586 */       if (emailString.contains("&InvoiceDate"))
/* 587 */         emailString = emailString.replaceAll("&InvoiceDate", invoiceDate); 
/*     */     } 
/* 592 */     System.out.println("Modified Email Body : " + emailString);
/* 593 */     return emailString;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */