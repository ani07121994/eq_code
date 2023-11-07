/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.net.CookieHandler;
/*     */ import java.net.CookieManager;
/*     */ import java.net.CookiePolicy;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Test
/*     */ {
/*  31 */   public static HashMap<String, String> filePathList = new HashMap<>();
/*  32 */   public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean loadproperties() {
/*     */     try {
/*  38 */       Properties prop = new Properties();
/*  39 */       File file = new File("WFR_Notification_Jetstar.properties");
/*  40 */       FileInputStream fileInput = new FileInputStream(file);
/*     */       
/*  42 */       prop.load(fileInput);
/*     */ 
/*     */       
/*  45 */       filePathList.put("badImagesLocationAUS", prop.getProperty("BADIMAGESLOCATION1"));
/*  46 */       filePathList.put("badImagesLocationJAP", prop.getProperty("BADIMAGESLOCATION2"));
/*  47 */       filePathList.put("badImagesLocationSGP", prop.getProperty("BADIMAGESLOCATION3"));
/*  48 */       filePathList.put("partialSuccessLocation", prop.getProperty("PARTIALSUCCESSLOCATION"));
/*  49 */       filePathList.put("inputFolderLocationAUS", prop.getProperty("INPUTFOLDERLOCATION1"));
/*  50 */       filePathList.put("inputFolderLocationJAP", prop.getProperty("INPUTFOLDERLOCATION2"));
/*  51 */       filePathList.put("inputFolderLocationSGP", prop.getProperty("INPUTFOLDERLOCATION3"));
/*     */       
/*  53 */       filePathList.put("smtpHost", prop.getProperty("SMTPHOST"));
/*  54 */       filePathList.put("emailSubject", prop.getProperty("EMAILSUBJECT"));
/*  55 */       filePathList.put("emailTo", prop.getProperty("EMAILTO"));
/*  56 */       filePathList.put("emailFrom", prop.getProperty("EMAILFROM"));
/*     */       
/*  58 */       filePathList.put("captureLink", prop.getProperty("CAPTURELINK"));
/*  59 */       filePathList.put("imagingLink", prop.getProperty("IMAGINGLINK"));
/*  60 */       filePathList.put("verifierLink", prop.getProperty("VERIFIERLINK"));
/*  61 */       filePathList.put("bpmLink", prop.getProperty("BPMLINK"));
/*     */       
/*  63 */       filePathList.put("wfrJDBCUrl", prop.getProperty("WFRJDBCURL"));
/*  64 */       filePathList.put("wfrPwd", prop.getProperty("WFRPWD"));
/*  65 */       filePathList.put("wfrUser", prop.getProperty("WFRUSER"));
/*     */       
/*  67 */       filePathList.put("eqJDBCUrl", prop.getProperty("EQJDBCURL"));
/*  68 */       filePathList.put("eqPwd", prop.getProperty("EQPWD"));
/*  69 */       filePathList.put("eqUser", prop.getProperty("EQUSER"));
/*     */       
/*  71 */       return true;
/*     */     }
/*  73 */     catch (Exception e) {
/*  74 */       e.printStackTrace();
/*  75 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 122 */       if (!loadproperties()) {
/*     */         
/* 124 */         System.out.println("loadproperties not executed");
/* 125 */         System.out.println("--------Ending program-------");
/*     */         
/* 127 */         System.exit(0);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 224 */       ArrayList<String> list_of_links = new ArrayList<>();
/* 225 */       ArrayList<String> link_status = new ArrayList<>();
/* 226 */       ArrayList<String> success_list = new ArrayList<>();
/*     */       
/* 228 */       for (String key : filePathList.keySet()) {
/*     */         
/* 230 */         String keyValue = key.toString();
/* 231 */         if (keyValue.contains("captureLink") || keyValue.contains("verifierLink") || keyValue.contains("imagingLink") || keyValue.contains("bpmLink"))
/*     */         {
/* 233 */           list_of_links.add(filePathList.get(key));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 238 */       System.out.println("no of links to be checked :" + list_of_links.size());
/* 239 */       System.out.println("name of links checked : captureLink, imagingLink, verifierLink, bpmLink");
/*     */ 
/*     */       
/* 242 */       for (String url : list_of_links) {
/*     */         
/*     */         try {
/* 245 */           if (!checkLinks(url)) {
/* 246 */             link_status.add(url); continue;
/*     */           } 
/* 248 */           success_list.add(url);
/* 249 */         } catch (Exception exception) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 254 */       if (link_status.size() == 0 || link_status == null) {
/* 255 */         System.out.println("All links working fine");
/*     */       } else {
/* 257 */         System.out.println("no of error links :" + link_status.size());
/*     */       } 
/*     */       
/* 260 */       int no_of_wfr_import_files = countWFRImport();
/* 261 */       int no_of_stuck_invoices = countStuckInvoices();
/* 262 */       int no_of_failed_instances = countFailedInterfaceInstance();
/* 263 */       int no_of_Error_recovery = countErrorForRecovery();
/* 264 */       int no_of_eQ_interface_rejections = countEqInterfaceRejections();
/* 265 */       int no_of_Bad_imagesAUS = countBadImagesAUS();
/* 266 */       int no_of_Bad_imagesJAP = countBadImagesJAP();
/* 267 */       int no_of_Bad_imagesSGP = countBadImagesSGP();
/* 268 */       int no_partial_success_files = countPartialSuccess();
/* 269 */       int no_of_pending_certification = countPendingCertification();
/* 270 */       int no_of_file_stuck_in_input_folderAUS = countInputFolderAUS();
/* 271 */       int no_of_file_stuck_in_input_folderJAP = countInputFolderJAP();
/* 272 */       int no_of_file_stuck_in_input_folderSGP = countInputFolderSGP();
/* 273 */       int no_of_file_stuck_in_input_folder = no_of_file_stuck_in_input_folderAUS + no_of_file_stuck_in_input_folderJAP + no_of_file_stuck_in_input_folderSGP;
/* 274 */       int no_of_ecm_invisible_records = 0;
/*     */ 
/*     */       
/* 277 */       int no_of_Bad_images = no_of_Bad_imagesAUS + no_of_Bad_imagesJAP + no_of_Bad_imagesSGP;
/*     */       
/* 279 */       System.out.println("no of success links :" + success_list.size());
/* 280 */       System.out.println("WFR_IMPORT count :" + no_of_wfr_import_files);
/* 281 */       System.out.println("stuck invoice in 50/150/250/750 :" + no_of_stuck_invoices);
/* 282 */       System.out.println("no of failed instances :" + no_of_failed_instances);
/* 283 */       System.out.println("Error for recovery count :" + no_of_Error_recovery);
/* 284 */       System.out.println("eQ interface rejected count :" + no_of_eQ_interface_rejections);
/* 285 */       System.out.println("no of bad images :" + no_of_Bad_imagesAUS);
/* 286 */       System.out.println("no of bad images :" + no_of_Bad_imagesJAP);
/* 287 */       System.out.println("no of bad images :" + no_of_Bad_imagesSGP);
/* 288 */       System.out.println("no of partial success files :" + no_partial_success_files);
/* 289 */       System.out.println("pending for certification count :" + no_of_pending_certification);
/* 290 */       System.out.println("no of files stuck in input folder :" + no_of_file_stuck_in_input_folderAUS);
/* 291 */       System.out.println("no of files stuck in input folder :" + no_of_file_stuck_in_input_folderJAP);
/* 292 */       System.out.println("no of files stuck in input folder :" + no_of_file_stuck_in_input_folderSGP);
/* 293 */       System.out.println("no of files stuck in input folder :" + no_of_file_stuck_in_input_folder);
/* 294 */       System.out.println("no of invisible records in ECM :" + no_of_ecm_invisible_records);
/* 295 */       System.out.println("no of files stuck in badimages folder :" + no_of_Bad_images);
/*     */ 
/*     */       
/* 298 */       sendMail(success_list, link_status, no_of_wfr_import_files, no_of_stuck_invoices, no_of_failed_instances, no_of_Error_recovery, no_of_eQ_interface_rejections, no_of_Bad_imagesAUS, no_of_file_stuck_in_input_folder, no_partial_success_files, no_of_pending_certification, no_of_ecm_invisible_records);
/*     */ 
/*     */     
/*     */     }
/* 302 */     catch (Exception e) {
/* 303 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countPendingCertification() {
/*     */     try {
/* 312 */       int count = 0;
/*     */       
/* 314 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 315 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/* 316 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Pending Certification%' and xipm_app_1_0 = 'eqadmin' and xipm_app_1_32='JETSTAR INVOICE'");
/*     */       
/* 318 */       ResultSet rs = ps.executeQuery();
/* 319 */       while (rs.next()) {
/* 320 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 323 */       con.close();
/*     */       
/* 325 */       return count;
/* 326 */     } catch (Exception e) {
/* 327 */       e.printStackTrace();
/* 328 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int countPartialSuccess() {
/* 334 */     int count = 0;
/*     */     try {
/* 336 */       String partialSuccessLocation = filePathList.get("partialSuccessLocation");
/*     */ 
/*     */       
/* 339 */       File[] file = (new File(partialSuccessLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 341 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 342 */         if (f.getName().endsWith(".txt")) {
/* 343 */           count++;
/*     */         }
/*     */         
/* 346 */         b = (byte)(b + 1); }
/*     */ 
/*     */       
/* 349 */       return count;
/* 350 */     } catch (Exception e) {
/* 351 */       e.printStackTrace();
/* 352 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int countBadImagesAUS() {
/* 358 */     int count = 0;
/*     */     try {
/* 360 */       String badImagesLocation = filePathList.get("badImagesLocationAUS");
/*     */ 
/*     */       
/* 363 */       File[] file = (new File(badImagesLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 365 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 366 */         if (f.getName().endsWith(".tif")) {
/* 367 */           count++;
/*     */         }
/*     */         
/* 370 */         b = (byte)(b + 1); }
/*     */ 
/*     */       
/* 373 */       return count;
/* 374 */     } catch (Exception e) {
/* 375 */       e.printStackTrace();
/* 376 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countBadImagesJAP() {
/* 383 */     int count = 0;
/*     */     try {
/* 385 */       String badImagesLocation = filePathList.get("badImagesLocationJAP");
/*     */ 
/*     */       
/* 388 */       File[] file = (new File(badImagesLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 390 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 391 */         if (f.getName().endsWith(".tif")) {
/* 392 */           count++;
/*     */         }
/*     */         
/* 395 */         b = (byte)(b + 1); }
/*     */ 
/*     */       
/* 398 */       return count;
/* 399 */     } catch (Exception e) {
/* 400 */       e.printStackTrace();
/* 401 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countBadImagesSGP() {
/* 408 */     int count = 0;
/*     */     try {
/* 410 */       String badImagesLocation = filePathList.get("badImagesLocationSGP");
/*     */ 
/*     */       
/* 413 */       File[] file = (new File(badImagesLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 415 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 416 */         if (f.getName().endsWith(".tif")) {
/* 417 */           count++;
/*     */         }
/*     */         
/* 420 */         b = (byte)(b + 1); }
/*     */ 
/*     */       
/* 423 */       return count;
/* 424 */     } catch (Exception e) {
/* 425 */       e.printStackTrace();
/* 426 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countInputFolderAUS() {
/* 433 */     int count = 0;
/*     */     try {
/* 435 */       String inputFolderLocation = filePathList.get("inputFolderLocationAUS");
/*     */ 
/*     */       
/* 438 */       File[] file = (new File(inputFolderLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 440 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 441 */         if (f.getName().endsWith(".tif")) {
/* 442 */           count++;
/*     */         }
/*     */         
/* 445 */         b = (byte)(b + 1); }
/*     */ 
/*     */       
/* 448 */       return count;
/* 449 */     } catch (Exception e) {
/* 450 */       e.printStackTrace();
/* 451 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countInputFolderJAP() {
/* 458 */     int count = 0;
/*     */     try {
/* 460 */       String inputFolderLocation = filePathList.get("inputFolderLocationJAP");
/*     */ 
/*     */       
/* 463 */       File[] file = (new File(inputFolderLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 465 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 466 */         if (f.getName().endsWith(".tif")) {
/* 467 */           count++;
/*     */         }
/*     */         
/* 470 */         b = (byte)(b + 1); }
/*     */ 
/*     */       
/* 473 */       return count;
/* 474 */     } catch (Exception e) {
/* 475 */       e.printStackTrace();
/* 476 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countInputFolderSGP() {
/* 483 */     int count = 0;
/*     */     try {
/* 485 */       String inputFolderLocation = filePathList.get("inputFolderLocationSGP");
/*     */ 
/*     */       
/* 488 */       File[] file = (new File(inputFolderLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 490 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 491 */         if (f.getName().endsWith(".tif")) {
/* 492 */           count++;
/*     */         }
/*     */         
/* 495 */         b = (byte)(b + 1); }
/*     */ 
/*     */       
/* 498 */       return count;
/* 499 */     } catch (Exception e) {
/* 500 */       e.printStackTrace();
/* 501 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countEqInterfaceRejections() {
/*     */     try {
/* 509 */       int count = 0;
/*     */       
/* 511 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 512 */       Connection con = DriverManager.getConnection(filePathList.get("eqJDBCUrl"), filePathList.get("eqUser"), filePathList.get("eqPwd"));
/*     */       
/* 514 */       PreparedStatement ps = con.prepareStatement("select count(*) from apps.ap_invoices_interface where attribute12 like '%IMGPROCESS%' and status = 'REJECTED' and source like '%JETSTAR%'");
/*     */       
/* 516 */       ResultSet rs = ps.executeQuery();
/* 517 */       while (rs.next()) {
/* 518 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 521 */       con.close();
/*     */       
/* 523 */       return count;
/* 524 */     } catch (Exception e) {
/* 525 */       e.printStackTrace();
/* 526 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countErrorForRecovery() {
/*     */     try {
/* 536 */       int count = 0;
/*     */       
/* 538 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 539 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 541 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like 'Internal%'and XIPM_APP_1_32='JETSTAR INVOICE'");
/*     */       
/* 543 */       ResultSet rs = ps.executeQuery();
/* 544 */       while (rs.next()) {
/* 545 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 548 */       con.close();
/*     */       
/* 550 */       return count;
/* 551 */     } catch (Exception e) {
/* 552 */       e.printStackTrace();
/* 553 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countFailedInterfaceInstance() {
/*     */     try {
/* 561 */       int count = 0;
/*     */       
/* 563 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 564 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 566 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Failed%'and XIPM_APP_1_32='JETSTAR INVOICE'");
/*     */       
/* 568 */       ResultSet rs = ps.executeQuery();
/* 569 */       while (rs.next()) {
/* 570 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 573 */       con.close();
/*     */       
/* 575 */       return count;
/* 576 */     } catch (Exception e) {
/* 577 */       e.printStackTrace();
/* 578 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countStuckInvoices() {
/*     */     try {
/* 586 */       int count = 0;
/*     */       
/* 588 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 589 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 591 */       PreparedStatement ps = con.prepareStatement("select count(*) from JSWFR.BATCH where STATE IN ('0','50','150','250','750','900')");
/*     */       
/* 593 */       ResultSet rs = ps.executeQuery();
/* 594 */       while (rs.next()) {
/* 595 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 598 */       con.close();
/*     */       
/* 600 */       return count;
/* 601 */     } catch (Exception e) {
/* 602 */       e.printStackTrace();
/* 603 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countWFRImport() {
/*     */     try {
/* 611 */       int count = 0;
/*     */       
/* 613 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 614 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 616 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 = 'WFR_IMPORT'and XIPM_APP_1_32='JETSTAR INVOICE'");
/*     */       
/* 618 */       ResultSet rs = ps.executeQuery();
/* 619 */       while (rs.next()) {
/* 620 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 623 */       con.close();
/*     */       
/* 625 */       return count;
/* 626 */     } catch (Exception e) {
/* 627 */       e.printStackTrace();
/* 628 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countECMInvisibleRecords() {
/*     */     try {
/* 637 */       int count = 0;
/*     */       
/* 639 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 640 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 642 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.revisions where ddocname not in (select distinct(ddocname) from OWCPRD12C_OCS.idctext1)");
/*     */       
/* 644 */       ResultSet rs = ps.executeQuery();
/* 645 */       while (rs.next()) {
/* 646 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 649 */       con.close();
/*     */       
/* 651 */       return count;
/* 652 */     } catch (Exception e) {
/* 653 */       e.printStackTrace();
/* 654 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean checkLinks(String url) {
/* 664 */     CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 670 */       URL u = new URL(url);
/* 671 */       HttpURLConnection huc = (HttpURLConnection)u.openConnection();
/* 672 */       huc.setConnectTimeout(20000);
/* 673 */       huc.setRequestMethod("GET");
/* 674 */       huc.connect();
/* 675 */       int code = huc.getResponseCode();
/*     */       
/* 677 */       if (code == 200) {
/* 678 */         return true;
/*     */       }
/*     */     }
/* 681 */     catch (Exception e) {
/*     */       
/* 683 */       return false;
/*     */     } 
/* 685 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void sendMail(ArrayList<String> success_list, ArrayList<String> link_status, int no_of_wfr_import_files, int no_of_stuck_invoices, int no_of_failed_instances, int no_of_Error_recovery, int no_of_eQ_interface_rejections, int no_of_Bad_images, int no_of_file_stuck_in_input_folder, int no_partial_success_files, int no_of_pending_certification, int no_of_ecm_invisible_records) {
/* 692 */     ReadOutlookUnprocessedMail mailread = new ReadOutlookUnprocessedMail();
/* 693 */     List<Integer> countMail = mailread.checkMail();
/*     */     
/* 695 */     System.out.println("Inside sendMail");
/* 696 */     Session session = null;
/* 697 */     String message = "<p>Hi All,</p>";
/* 698 */     if (link_status.size() > 0 || success_list.size() > 0) {
/* 699 */       message = String.valueOf(String.valueOf(message)) + "<p>Please find the application and the server health status of OWC Application for Jetstar. Additionally,please find AP Automation system status below:</p>";
/*     */     } else {
/* 701 */       message = String.valueOf(String.valueOf(message)) + "<p>Please find AP Automation system status below:</p>";
/*     */     } 
/* 703 */     message = String.valueOf(String.valueOf(message)) + "<table style = 'border: 1px solid black;border-collapse: collapse; collapse;width : 100%'>";
/* 704 */     message = String.valueOf(String.valueOf(message)) + "<tr><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Activity</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Module</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Date/Time</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Running Status</b></th></tr>";
/*     */     
/* 706 */     if ((success_list.size() > 0 && !success_list.isEmpty()) || (link_status.size() > 0 && !link_status.isEmpty()) || no_of_wfr_import_files >= 0 || no_of_stuck_invoices >= 0 || no_of_failed_instances >= 0 || no_of_Error_recovery >= 0 || no_of_eQ_interface_rejections >= 0 || no_of_pending_certification >= 0 || no_of_Bad_images >= 0 || no_of_file_stuck_in_input_folder >= 0) {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 715 */         if (link_status.size() > 0) {
/*     */           
/* 717 */           for (String url : link_status) {
/* 718 */             if (url.contains("http://eqprod-capture1:16035/cs/")) {
/* 719 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/* 721 */             if (url.contains("http://eqprod-verifier2/WebVerifier/Login.aspx")) {
/* 722 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/* 724 */             if (url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")) {
/* 725 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/*     */             
/* 728 */             if (url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")) {
/* 729 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/*     */           }
/*     */         
/* 733 */         } else if (success_list.size() > 0) {
/*     */           
/* 735 */           for (String url : success_list) {
/* 736 */             if (url.contains("http://eqprod-capture1:16035/cs/")) {
/* 737 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
/*     */             }
/* 739 */             if (url.contains("http://eqprod-verifier2/WebVerifier/Login.aspx")) {
/* 740 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
/*     */             }
/* 742 */             if (url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")) {
/* 743 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
/*     */             }
/* 745 */             if (url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")) {
/* 746 */               message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 768 */         if (((Integer)countMail.get(0)).intValue() >= 0)
/* 769 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in unprocessed folder</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + countMail.get(0) + "</td></tr>"; 
/* 770 */         if (((Integer)countMail.get(1)).intValue() >= 0)
/* 771 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in Re-Process folder</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + countMail.get(1) + "</td></tr>"; 
/* 772 */         if (((Integer)countMail.get(2)).intValue() >= 0)
/* 773 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in Capture Error folder</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + countMail.get(2) + "</td></tr>"; 
/* 774 */         if (no_of_file_stuck_in_input_folder >= 0)
/* 775 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck between Capture and WFR</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_file_stuck_in_input_folder + "</td></tr>"; 
/* 776 */         if (no_of_Bad_images >= 0)
/* 777 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices rejected by WFR due to poor quality</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_Bad_images + "</td></tr>"; 
/* 778 */         if (no_of_stuck_invoices >= 0)
/* 779 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Stuck Invoices (0/50/150/250/750/900)</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_stuck_invoices + "</td></tr>"; 
/* 780 */         if (no_partial_success_files >= 0)
/* 781 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR export failure</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_partial_success_files + "</td></tr>"; 
/* 782 */         if (no_of_wfr_import_files >= 0)
/* 783 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Import</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_wfr_import_files + "</td></tr>"; 
/* 784 */         if (no_of_ecm_invisible_records >= 0)
/* 785 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>ECM Invisible Records</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_ecm_invisible_records + "</td></tr>"; 
/* 786 */         if (no_of_Error_recovery >= 0)
/* 787 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Internal error occured</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_Error_recovery + "</td></tr>"; 
/* 788 */         if (no_of_pending_certification >= 0)
/* 789 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Assigned invoices to Admin User</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_pending_certification + "</td></tr>"; 
/* 790 */         if (no_of_failed_instances >= 0)
/* 791 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices failed to insert record in AP interface</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_failed_instances + "</td></tr>"; 
/* 792 */         if (no_of_eQ_interface_rejections >= 0) {
/* 793 */           message = String.valueOf(String.valueOf(message)) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>AP interface rejection</td><td style = 'border: 1px solid black;border-collapse: collapse;'>eQ</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_eQ_interface_rejections + "</td></tr>";
/*     */         }
/* 795 */         message = String.valueOf(String.valueOf(message)) + "</table><br>";
/* 796 */         message = String.valueOf(String.valueOf(message)) + "Regards,<br>eQ OWC Support Team";
/*     */         
/* 798 */         Properties properties = System.getProperties();
/* 799 */         properties.setProperty("mail.smtp.host", filePathList.get("smtpHost"));
/* 800 */         session = Session.getDefaultInstance(properties);
/* 801 */         MimeMessage mimeMessage = new MimeMessage(session);
/* 802 */         mimeMessage.setFrom((Address)InternetAddress.parse((String)filePathList.get("emailFrom"), false)[0]);
/*     */         
/* 804 */         mimeMessage.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(filePathList.get("emailTo")));
/*     */ 
/*     */         
/* 807 */         mimeMessage.setSubject(filePathList.get("emailSubject"));
/* 808 */         mimeMessage.setSentDate(new Date());
/* 809 */         mimeMessage.setContent(message, "text/html; charset=utf-8");
/* 810 */         Transport.send((Message)mimeMessage);
/*     */ 
/*     */         
/* 813 */         System.out.println("WFR AP Automation Status Mail Sent Successfully");
/*     */       }
/* 815 */       catch (Exception e) {
/* 816 */         e.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       
/* 820 */       System.out.println("everything is woking fine");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\client notification\client notification\js\APAutomationNotification.jar!\Test.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */