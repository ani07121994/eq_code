/*     */ package ap.quantas.com.js_email_sender;
/*     */ 
/*     */ import ap.quantas.com.PropertyLoader;
/*     */ import ap.quantas.com.Utility;
/*     */ import ap.quantas.com.js_email_sender.ContentIdGenerator;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import javax.activation.DataHandler;
/*     */ import javax.activation.DataSource;
/*     */ import javax.activation.FileDataSource;
/*     */ import javax.jws.WebMethod;
/*     */ import javax.jws.WebParam;
/*     */ import javax.jws.WebService;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.BodyPart;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.MessagingException;
/*     */ import javax.mail.Multipart;
/*     */ import javax.mail.SendFailedException;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeBodyPart;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import javax.mail.internet.MimeMultipart;
/*     */ import javax.naming.NamingException;
/*     */ import javax.xml.ws.BindingType;
/*     */ 
/*     */ @WebService(portName = "EmailSenderSoap12HttpPort")
/*     */ @BindingType("http://www.w3.org/2003/05/soap/bindings/HTTP/")
/*     */ public class EmailSender {
/*  80 */   PropertyLoader propertyLoader = PropertyLoader.getInstance();
/*     */   
/*     */   @WebMethod(operationName = "sendAutoEmail")
/*     */   public String sendAutoEmail(@WebParam(name = "emailTo") String emailTo, @WebParam(name = "emailCc") String emailCc, @WebParam(name = "docId") String docId, @WebParam(name = "invalid_reason_Type_id") String reasonType, @WebParam(name = "supplierName") String supplierName, @WebParam(name = "siteId") String siteId, @WebParam(name = "invoiceNum") String invoiceNum, @WebParam(name = "invoiceDate") String invoiceDate, @WebParam(name = "invoice_file_name") String invoice_fname, @WebParam(name = "capture_batch_ID") String captureBatchID) throws FileNotFoundException {
/*  91 */     if (reasonType == null || (reasonType != null && reasonType.trim().equals(""))) {
/*  93 */       System.out.println("Returning null ");
/*  94 */       return "reasonType";
/*     */     } 
/*  97 */     Utility utility = new Utility();
/* 100 */     Session mailSession = null;
/* 101 */     String subject = null;
/* 102 */     String mailFrom = this.propertyLoader.getProperty("NOTIFICATION_EMAIL_ID").toString();
/* 103 */     String body = null;
/* 104 */     MimeMessage msg = null;
/* 105 */     String cc = null;
/* 106 */     String bcc = null;
/* 107 */     Map map = null;
/*     */     try {
/* 127 */       map = utility.initEmailParams(reasonType, supplierName, siteId, invoiceNum, invoiceDate);
/* 128 */       System.out.println("initEmailParams Map size :: " + map.size());
/* 129 */     } catch (Exception e) {
/* 130 */       return "FailedToLoad_InitParams";
/*     */     } 
/* 134 */     for (Object key : map.keySet()) {
/* 136 */       if (key.equals("body") && map.get("body") != null) {
/* 138 */         body = map.get("body").toString();
/*     */         continue;
/*     */       } 
/* 141 */       if (key.equals("subject") && map.get("subject") != null) {
/* 142 */         subject = map.get("subject").toString();
/*     */         continue;
/*     */       } 
/* 144 */       if (key.equals("cc") && map.get("cc") != null) {
/* 145 */         cc = map.get("cc").toString();
/*     */         continue;
/*     */       } 
/* 148 */       if (key.equals("email_from") && map.get("email_from") != null) {
/* 149 */         mailFrom = map.get("email_from").toString();
/*     */         continue;
/*     */       } 
/* 151 */       if (key.equals("bcc") && map.get("bcc") != null) {
/* 152 */         bcc = map.get("bcc").toString();
/* 153 */         System.out.println("BCC present :: " + bcc);
/*     */       } 
/*     */     } 
/* 161 */     System.out.println("Email body ::" + body);
/* 162 */     System.out.println("Email subject ::" + subject);
/* 163 */     System.out.println("Email emailTo ::" + emailTo);
/* 164 */     System.out.println("Email mailFrom ::" + mailFrom);
/*     */     try {
/* 168 */       mailSession = utility.getMailSession();
/* 169 */       msg = new MimeMessage(mailSession);
/* 170 */       msg.setFrom((Address)InternetAddress.parse(mailFrom, false)[0]);
/* 171 */       if (emailTo != null)
/*     */         try {
/* 173 */           msg.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(emailTo, false));
/* 179 */         } catch (Exception parseEx) {
/* 180 */           System.out.println("Unable to parse emailTo");
/* 181 */           return "Invalid_MailTo_Address";
/*     */         }  
/* 186 */       if (emailCc != null)
/*     */         try {
/* 188 */           msg.setRecipients(Message.RecipientType.CC, (Address[])InternetAddress.parse(emailCc, false));
/* 194 */         } catch (Exception parseEx) {
/* 195 */           return "Invalid_CC_Address";
/*     */         }  
/* 199 */       if (bcc != null)
/*     */         try {
/* 201 */           msg.setRecipients(Message.RecipientType.BCC, (Address[])InternetAddress.parse(bcc, false));
/* 207 */         } catch (Exception parseEx) {
/* 208 */           return "Invalid_BCC_Address";
/*     */         }  
/* 214 */     } catch (NamingException e) {
/* 216 */       e.printStackTrace();
/* 218 */     } catch (SendFailedException e) {
/* 219 */       return "Invalid_Address_Exception";
/* 225 */     } catch (MessagingException e) {
/* 226 */       e.printStackTrace();
/* 227 */       return "Invalid_Address_Exception";
/*     */     } 
/*     */     try {
/* 234 */       String cid = ContentIdGenerator.getContentId();
/* 238 */       String modifiedBody = utility.setEmailLink(body, docId);
/* 239 */       modifiedBody = modifiedBody + "<br>" + "<img src=\"cid:" + cid + "\" />";
/* 240 */       msg.setSubject(subject);
/* 241 */       msg.setSentDate(new Date());
/* 244 */       MimeBodyPart mbp1 = new MimeBodyPart();
/* 245 */       mbp1.setContent(modifiedBody, "text/html; charset=utf-8");
/* 249 */       MimeBodyPart mbp2 = new MimeBodyPart();
/*     */       try {
/* 251 */         String fileUploadPath = utility.getDocument(captureBatchID, invoice_fname);
/* 252 */         DataSource source = new FileDataSource(fileUploadPath);
/* 253 */         mbp2.setDataHandler(new DataHandler(source));
/* 254 */         System.out.println("FileName is-" + fileUploadPath.substring(fileUploadPath.lastIndexOf("/") + 1, fileUploadPath.length()));
/* 256 */         System.out.println("Setting file name from the inputParameter as :: " + invoice_fname);
/* 257 */         mbp2.setFileName(invoice_fname);
/* 259 */       } catch (NullPointerException e) {
/* 260 */         return "FileFromImaging_Exception";
/*     */       } 
/* 265 */       MimeBodyPart imagePart = new MimeBodyPart();
/* 267 */       String imageFileUploadPath = this.propertyLoader.getProperty("FILE_UPLOAD_SERVER_PATH").toString() + "jetstarlogo.png";
/* 268 */       imagePart.attachFile(imageFileUploadPath);
/* 269 */       imagePart.setContentID("<" + cid + ">");
/* 270 */       imagePart.setDisposition("inline");
/* 273 */       MimeMultipart mimeMultipart = new MimeMultipart();
/* 274 */       mimeMultipart.addBodyPart((BodyPart)mbp1);
/* 275 */       mimeMultipart.addBodyPart((BodyPart)mbp2);
/* 276 */       mimeMultipart.addBodyPart((BodyPart)imagePart);
/* 279 */       msg.setContent((Multipart)mimeMultipart);
/* 280 */       Transport.send((Message)msg);
/* 282 */       System.out.println("Message send successfuly");
/* 283 */       return "MAIL_SENT";
/* 286 */     } catch (SendFailedException e) {
/* 287 */       e.printStackTrace();
/* 288 */       return "Invalid_Address_Exception";
/* 291 */     } catch (FileNotFoundException ex) {
/* 292 */       throw new FileNotFoundException();
/* 297 */     } catch (MessagingException ex) {
/* 298 */       ex.printStackTrace();
/* 299 */       return "Messaging_Server_Exception";
/* 302 */     } catch (Exception e) {
/* 303 */       e.printStackTrace();
/* 304 */       return "Other_Exception";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\js_email_sender\EmailSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */