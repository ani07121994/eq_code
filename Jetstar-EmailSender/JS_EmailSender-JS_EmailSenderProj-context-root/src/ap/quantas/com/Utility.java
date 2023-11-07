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
/*  75 */   PropertyLoader propertyLoader = PropertyLoader.getInstance();
/*     */   
/*     */   public static final String deployment_env = "PROD";
/*     */   
/*     */   public DataSource getDataSource() throws NamingException {
/*  87 */     String jndi_name = "";
/*  88 */     if (deployment_env.equals("DEV")) {
/*  89 */       jndi_name = "jdbc/EQFILES_NXA";
/*  91 */     } else if (deployment_env.equals("SIT")) {
/*  92 */       jndi_name = "jdbc/CRP2_EQFILES_NXA";
/*  93 */     } else if (deployment_env.equals("PSP")) {
/*  94 */       jndi_name = "jdbc/PROD_EQFILES_NXA";
/*  95 */     } else if (deployment_env.equals("PROD")) {
/*  96 */       jndi_name = "jdbc/PROD_EQFILES_NXA";
/*     */     } 
/* 100 */     Context initContext = new InitialContext();
/* 101 */     DataSource ds = (DataSource)initContext.lookup(jndi_name);
/* 103 */     return ds;
/*     */   }
/*     */   
/*     */   public String getDocument(String captureBatchID, String document_name) throws FileNotFoundException {
/* 115 */     String imaging_ws_url = null;
/* 116 */     if (deployment_env.equals("DEV")) {
/* 117 */       imaging_ws_url = "http://eqdev-capture1.qantas.com.au:19000/imaging/ws";
/* 119 */     } else if (deployment_env.equals("SIT")) {
/* 120 */       imaging_ws_url = "http://eqdev-capture1.qantas.com.au:19000/imaging/ws";
/* 121 */     } else if (deployment_env.equals("PSP")) {
/* 122 */       imaging_ws_url = "http://eqtest-capture1.qantas.com.au:16033/imaging/ws";
/* 123 */     } else if (deployment_env.equals("PROD")) {
///* 124 */       imaging_ws_url = "http://eqprod-capture1.qantas.com.au:19000/imaging/ws";
				imaging_ws_url = "http://eqprod-capture1.qantas.com.au:16033/imaging/ws"; // Prod
/*     */     } 
/* 127 */     byte[] byteArray = null;
/* 128 */     FileDescriptor fd = new FileDescriptor();
/* 129 */     DataHandler fileData = null;
/* 130 */     FileOutputStream outputStream = null;
/* 133 */     String strDowunloadDocName = "";
/*     */     try {
/* 135 */       System.out.println("captureBatchID , document_name===" + captureBatchID + "," + document_name);
/* 137 */       BasicUserToken basicUserToken = new BasicUserToken(this.propertyLoader.getProperty("IMAGING_DOCUMENT_CONTENT_SERVICE_USERNAME").toString(), this.propertyLoader.getProperty("IMAGING_DOCUMENT_CONTENT_SERVICE_PASSWORD").toString());
/* 139 */       System.out.println("before servicesFactory imaging_ws_url :: " + imaging_ws_url);
/* 140 */       ServicesFactory servicesFactory = ServicesFactory.login((UserToken)basicUserToken, Locale.US, imaging_ws_url);
/*     */       try {
/* 148 */         SearchService searchService = servicesFactory.getSearchService();
/* 149 */         DocumentContentService docContentService = servicesFactory.getDocumentContentService();
/* 152 */         List<SearchArgument> searchArguments = new ArrayList<SearchArgument>();
/* 155 */         SearchValue searchValue = new SearchValue(SearchValue.Type.TEXT, captureBatchID);
/* 156 */         SearchArgument searchArgument = new SearchArgument("Capture Batch ID", searchValue);
/* 157 */         searchArgument.setOperatorValue(Search.Operator.CONTAINS);
/* 158 */         searchArguments.add(searchArgument);
/* 168 */         System.out.println("before searching imaging :: " + this.propertyLoader.getProperty("IMAGING_NAMEID"));
/* 170 */         Search.ResultSet resultSet = searchService.executeSavedSearch(new NameId("JS_QF_Search_Invoice_ALL"), searchArguments);
/* 172 */         if (resultSet.getTotalResults() == 0)
/* 176 */           throw new FileNotFoundException("Document not found"); 
/* 179 */         String documentId = ((Search.Result)resultSet.getResults().get(0)).getDocumentId();
/* 180 */         strDowunloadDocName = ((Search.Result)resultSet.getResults().get(0)).getDocument().getName();
/* 182 */         System.out.println("documentId=" + documentId + ", documentName=" + strDowunloadDocName);
/* 186 */         fileData = docContentService.retrieve(documentId);
/* 188 */         System.out.println("filedata from docContentService");
/* 192 */         File file = new File(this.propertyLoader.getProperty("FILE_UPLOAD_SERVER_PATH").toString() + strDowunloadDocName);
/* 197 */         file.setReadable(true, false);
/* 198 */         file.setExecutable(true, false);
/* 199 */         file.setWritable(true, false);
/* 201 */         outputStream = new FileOutputStream(file);
/* 203 */         fileData.writeTo(outputStream);
/* 205 */         if (outputStream != null) {
/* 206 */           outputStream.close();
/* 207 */           outputStream.flush();
/*     */         } 
/* 209 */         fd.setBytedata(byteArray);
/* 253 */         System.out.println("wrote to file ");
/*     */       } finally {
/*     */         try {
/* 259 */           if (servicesFactory != null) {
/* 260 */             servicesFactory.logout();
/* 261 */             System.out.println("servicesFactory.logout() done ");
/*     */           } 
/* 263 */           if (outputStream != null) {
/* 264 */             outputStream.close();
/* 265 */             System.out.println("closed outputStream ");
/*     */           } 
/* 268 */         } catch (Exception e) {}
/*     */       } 
/* 273 */     } catch (FileNotFoundException e) {
/* 274 */       throw new FileNotFoundException();
/* 276 */     } catch (Exception e) {
/* 277 */       System.out.println(e.getMessage());
/*     */     } 
/* 280 */     System.out.println("returning file location  " + this.propertyLoader.getProperty("FILE_UPLOAD_SERVER_PATH").toString() + strDowunloadDocName);
/* 281 */     return this.propertyLoader.getProperty("FILE_UPLOAD_SERVER_PATH").toString() + strDowunloadDocName;
/*     */   }
/*     */   
/*     */   public Session getMailSession() throws NamingException {
/* 293 */     InitialContext ic = new InitialContext();
/* 294 */     Session session = (Session)ic.lookup("smtp/mailSession");
/* 297 */     return session;
/*     */   }
/*     */   
/*     */   public String setEmailLink(String body, String documentId) {
/* 391 */     String bodyPart = null;
/* 393 */     if (documentId != null)
/* 395 */       System.out.println("document id in setEmailLink ::: " + documentId); 
/* 396 */     if (body != null && body.contains("Click here"))
/* 398 */       body = body.replace("Click here", "<a href=\"" + this.propertyLoader.getProperty("IMAGE_URL_ADF").toString() + documentId + "\">Click here</a>"); 
/* 400 */     System.out.println("body in setEmailLink :: " + body);
/* 401 */     return body;
/*     */   }
/*     */   
/*     */   public Map<String, String> initEmailParams(String reasonTypeId, String supplierName, String siteId, String invoiceNum, String invoiceDate) throws NamingException, SQLException {
/* 410 */     Map<String, String> emailMap = new HashMap<String, String>();
/* 412 */     if (reasonTypeId != null)
/* 413 */       System.out.println("reasonTypeId :: " + reasonTypeId); 
/* 416 */     System.out.println("initEmailParams>>reasonTypeId>>" + reasonTypeId);
/* 418 */     DataSource ds = getDataSource();
/* 420 */     System.out.println("after getting datasource");
/* 422 */     System.out.println("Ds properties :: " + ds.toString());
/* 425 */     String reasonId = null;
/* 426 */     ResultSet rs2 = null;
/* 427 */     Connection conn = null;
/* 428 */     ResultSet rs = null;
/*     */     try {
/* 430 */       conn = ds.getConnection();
/* 431 */       if (conn != null) {
/* 432 */         System.out.println("Connection not null");
/* 435 */         rs2 = conn.createStatement().executeQuery("select id from js_ap_reason_type WHERE reason_type='" + reasonTypeId + "'");
/* 437 */         System.out.println("rs :: ");
/* 440 */         StringBuilder emailBody = new StringBuilder();
/* 443 */         if (rs2.next()) {
/* 444 */           System.out.println("Body :: " + rs2.getString(1));
/* 446 */           if (rs2.getString(1) != null)
/* 447 */             reasonId = rs2.getString(1); 
/*     */         } 
/* 453 */         rs2.close();
/*     */       } 
/* 457 */       System.out.println("Reason id :: " + reasonId);
/* 459 */       if (reasonTypeId != null && reasonTypeId.equals("DUPLICATE INVOICE"))
/* 461 */         reasonId = "65"; 
/* 500 */       System.out.println("Reason id :: " + reasonId);
/* 501 */       if (conn != null) {
/* 502 */         System.out.println("Connection not null");
/* 503 */         rs = conn.createStatement().executeQuery("select body,email_to,email_from,subject,cc,bcc from js_ap_email_table where reason_type_id='" + reasonId + "'");
/* 505 */         System.out.println("rs :: ");
/* 507 */         String emailBodyString = null;
/* 508 */         StringBuilder emailBody = new StringBuilder();
/* 511 */         if (rs.next()) {
/* 512 */           System.out.println("Body :: " + rs.getString(1));
/* 515 */           if (rs.getString(1) != null) {
/* 517 */             String modifiedMailBody = modifyEmail(rs.getString(1), supplierName, siteId, invoiceNum, invoiceDate);
/* 518 */             String put = emailMap.put("body", modifiedMailBody);
/*     */           } 
/* 522 */           emailMap.put("email_to", rs.getString(2));
/* 523 */           emailMap.put("email_from", rs.getString(3));
/* 524 */           if (rs.getString(4) != null) {
/* 525 */             String modifiedMailSubject = modifyEmail(rs.getString(4), supplierName, siteId, invoiceNum, invoiceDate);
/* 526 */             emailMap.put("subject", modifiedMailSubject);
/*     */           } 
/* 530 */           emailMap.put("cc", rs.getString(5));
/* 531 */           emailMap.put("bcc", rs.getString(6));
/*     */         } 
/* 536 */         rs.close();
/* 540 */         System.out.println("emailMap :: " + emailMap.size());
/* 541 */         for (String key : emailMap.keySet())
/* 543 */           System.out.println("emailMap key :: " + (String)emailMap.get(key)); 
/*     */       } 
/* 547 */     } catch (SQLException e) {
/* 548 */       System.out.println(" database error ");
/*     */     } finally {
/* 554 */       if (rs2 != null)
/* 555 */         rs2.close(); 
/* 558 */       if (rs != null)
/* 559 */         rs.close(); 
/* 561 */       if (conn != null) {
/* 562 */         System.out.println("Closing connection after calling utility");
/* 563 */         conn.close();
/*     */       } 
/*     */     } 
/* 567 */     System.out.println("emailMap key :: " + emailMap.size());
/* 568 */     return emailMap;
/*     */   }
/*     */   
/*     */   private String modifyEmail(String emailString, String supplierName_tobe_replaced, String siteId_tobe_replaced, String invoiceNum_tobe_replaced, String invoiceDate_tobe_replaced) {
/* 574 */     String supplierName = null;
/* 575 */     String siteId = null;
/* 576 */     String invoiceNum = null;
/* 577 */     String invoiceDate = null;
/* 578 */     if (supplierName_tobe_replaced != null) {
/* 579 */       supplierName = supplierName_tobe_replaced.toString();
/* 580 */       if (emailString.contains("&SupplierName"))
/* 581 */         emailString = emailString.replaceAll("&SupplierName", supplierName); 
/*     */     } 
/* 586 */     if (siteId_tobe_replaced != null) {
/* 587 */       siteId = siteId_tobe_replaced.toString();
/* 588 */       System.out.println("site id :" + siteId);
/* 589 */       if (emailString.contains("&SiteID"))
/* 590 */         emailString = emailString.replaceAll("&SiteID", siteId); 
/*     */     } 
/* 593 */     if (invoiceNum_tobe_replaced != null) {
/* 594 */       invoiceNum = invoiceNum_tobe_replaced.toString();
/* 595 */       System.out.println("ivoice Number " + invoiceNum);
/* 596 */       if (emailString.contains("&InvoiceNum"))
/* 597 */         emailString = emailString.replaceAll("&InvoiceNum", invoiceNum); 
/*     */     } 
/* 601 */     if (invoiceDate_tobe_replaced != null) {
/* 602 */       invoiceDate = invoiceDate_tobe_replaced.toString();
/* 603 */       System.out.println("invoiceDate " + invoiceDate);
/* 604 */       if (emailString.contains("&InvoiceDate"))
/* 605 */         emailString = emailString.replaceAll("&InvoiceDate", invoiceDate); 
/*     */     } 
/* 610 */     System.out.println("Modified Email Body : " + emailString);
/* 611 */     return emailString;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */