/*     */ package ap.quantas.com.js_email_sender;
/*     */ 
/*     */ import ap.quantas.com.PropertyLoader;
/*     */ import ap.quantas.com.Utility;
/*     */ import ap.quantas.com.js_email_sender.ContentIdGenerator;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.util.ArrayList;
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
/*     */   public String sendAutoEmail(@WebParam(name = "emailTo") String emailTo, @WebParam(name = "emailCc") String emailCc, @WebParam(name = "docId") String docId, @WebParam(name = "invalid_reason_Type_id") String reasonType, @WebParam(name = "supplierName") String supplierName, @WebParam(name = "siteId") String siteId, @WebParam(name = "invoiceNum") String invoiceNum, @WebParam(name = "invoiceDate") String invoiceDate, @WebParam(name = "file_name_imaging") String file_name_imaging, @WebParam(name = "capture_batch_id") String captureBatchID) throws FileNotFoundException {
/*  91 */     if (reasonType == null || (reasonType != null && reasonType.trim().equals(""))) {
/*  93 */       System.out.println("Returning null ");
/*  94 */       return "reasonType";
/*     */     } 
/* 101 */     if (captureBatchID == null || (captureBatchID != null && captureBatchID.equals(""))) {
/* 102 */       System.out.println("Capture batch Id is coming null or empty from BPM");
/* 104 */       return "MAIL_SENT";
/*     */     } 
/* 111 */     Utility utility = new Utility();
/* 114 */     Session mailSession = null;
/* 115 */     String subject = null;
/* 116 */     String mailFrom = this.propertyLoader.getProperty("NOTIFICATION_EMAIL_ID").toString();
/* 117 */     String body = null;
/* 118 */     MimeMessage msg = null;
/* 119 */     String cc = null;
/* 120 */     String bcc = null;
/* 121 */     Map map = null;
/*     */     try {
/* 141 */       map = utility.initEmailParams(reasonType, supplierName, siteId, invoiceNum, invoiceDate);
/* 142 */       System.out.println("initEmailParams Map size :: " + map.size());
/* 143 */     } catch (Exception e) {
/* 144 */       return "FailedToLoad_InitParams";
/*     */     } 
/* 148 */     for (Object key : map.keySet()) {
/* 150 */       if (key.equals("body") && map.get("body") != null) {
/* 152 */         body = map.get("body").toString();
/*     */         continue;
/*     */       } 
/* 155 */       if (key.equals("subject") && map.get("subject") != null) {
/* 156 */         subject = map.get("subject").toString();
/*     */         continue;
/*     */       } 
/* 158 */       if (key.equals("cc") && map.get("cc") != null) {
/* 159 */         cc = map.get("cc").toString();
/*     */         continue;
/*     */       } 
/* 162 */       if (key.equals("email_from") && map.get("email_from") != null) {
/* 163 */         mailFrom = map.get("email_from").toString();
/*     */         continue;
/*     */       } 
/* 165 */       if (key.equals("bcc") && map.get("bcc") != null) {
/* 166 */         bcc = map.get("bcc").toString();
/* 167 */         System.out.println("BCC present :: " + bcc);
/*     */       } 
/*     */     } 
/* 175 */     System.out.println("Email body ::" + body);
/* 176 */     System.out.println("Email subject ::" + subject);
/* 177 */     System.out.println("Email emailTo ::" + emailTo);
/* 178 */     System.out.println("Email mailFrom ::" + mailFrom);
/*     */     try {
/* 182 */       mailSession = utility.getMailSession();
/* 183 */       msg = new MimeMessage(mailSession);
/* 184 */       msg.setFrom((Address)InternetAddress.parse(mailFrom, false)[0]);
/* 185 */       if (emailTo != null)
/*     */         try {
/* 187 */           msg.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(emailTo, false));
/* 193 */         } catch (Exception parseEx) {
/* 194 */           System.out.println("Unable to parse emailTo");
/* 195 */           return "Invalid_MailTo_Address";
/*     */         }  
/* 200 */       if (emailCc != null)
/*     */         try {
/* 202 */           msg.setRecipients(Message.RecipientType.CC, (Address[])InternetAddress.parse(emailCc, false));
/* 208 */         } catch (Exception parseEx) {
/* 209 */           return "Invalid_CC_Address";
/*     */         }  
/* 213 */       if (bcc != null)
/*     */         try {
/* 215 */           msg.setRecipients(Message.RecipientType.BCC, (Address[])InternetAddress.parse(bcc, false));
/* 221 */         } catch (Exception parseEx) {
/* 222 */           return "Invalid_BCC_Address";
/*     */         }  
/* 228 */     } catch (NamingException e) {
/* 230 */       e.printStackTrace();
/* 232 */     } catch (SendFailedException e) {
/* 233 */       return "Invalid_Address_Exception";
/* 239 */     } catch (MessagingException e) {
/* 240 */       e.printStackTrace();
/* 241 */       return "Invalid_Address_Exception";
/*     */     } 
/*     */     try {
/* 248 */       String cid = ContentIdGenerator.getContentId();
/* 252 */       String modifiedBody = utility.setEmailLink(body, docId);
/* 253 */       modifiedBody = modifiedBody + "<br>" + "<img src=\"cid:" + cid + "\" />";
/* 254 */       msg.setSubject(subject);
/* 255 */       msg.setSentDate(new Date());
/* 258 */       MimeBodyPart mbp1 = new MimeBodyPart();
/* 259 */       mbp1.setContent(modifiedBody, "text/html; charset=utf-8");
/* 278 */       MimeMultipart mimeMultipart = new MimeMultipart();
/*     */       try {
/* 280 */         ArrayList<String> downloaddocName_list = utility.getDocument(captureBatchID, file_name_imaging);
/* 283 */         if (downloaddocName_list != null && downloaddocName_list.size() != 0)
/* 285 */           for (String fileUploadPath : downloaddocName_list) {
/* 286 */             MimeBodyPart mbp2 = new MimeBodyPart();
/* 287 */             DataSource source = new FileDataSource(fileUploadPath);
/* 288 */             mbp2.setDataHandler(new DataHandler(source));
/* 289 */             System.out.println("FileName is ooooo----" + fileUploadPath.substring(fileUploadPath.lastIndexOf("/") + 1, fileUploadPath.length()));
/* 290 */             mbp2.setFileName(file_name_imaging);
/* 292 */             System.out.println("File name set already ::" + file_name_imaging);
/* 293 */             mimeMultipart.addBodyPart((BodyPart)mbp2);
/*     */           }  
/* 297 */       } catch (NullPointerException e) {
/* 298 */         return "FileFromImaging_Exception";
/*     */       } 
/* 306 */       MimeBodyPart imagePart = new MimeBodyPart();
/* 308 */       String imageFileUploadPath = this.propertyLoader.getProperty("FILE_UPLOAD_SERVER_PATH").toString() + "qantas_sign.png";
/* 309 */       imagePart.attachFile(imageFileUploadPath);
/* 310 */       imagePart.setContentID("<" + cid + ">");
/* 311 */       imagePart.setDisposition("inline");
/* 315 */       mimeMultipart.addBodyPart((BodyPart)mbp1);
/* 317 */       mimeMultipart.addBodyPart((BodyPart)imagePart);
/* 320 */       msg.setContent((Multipart)mimeMultipart);
/* 321 */       Transport.send((Message)msg);
/* 323 */       System.out.println("Message send successfuly");
/* 324 */       return "MAIL_SENT";
/* 327 */     } catch (SendFailedException e) {
/* 328 */       e.printStackTrace();
/* 329 */       return "Invalid_Address_Exception";
/* 332 */     } catch (FileNotFoundException ex) {
/* 333 */       throw new FileNotFoundException();
/* 338 */     } catch (MessagingException ex) {
/* 339 */       ex.printStackTrace();
/* 340 */       return "Messaging_Server_Exception";
/* 343 */     } catch (Exception e) {
/* 344 */       e.printStackTrace();
/* 345 */       return "Other_Exception";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\js_email_sender\EmailSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */