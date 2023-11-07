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
/*  31 */   public static HashMap<String, String> filePathList = new HashMap<String, String>();
/*  32 */   public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean loadproperties() {
/*     */     try {
/*  38 */       Properties prop = new Properties();
/*  39 */       File file = new File("WFR_Notification.properties");
/*  40 */       FileInputStream fileInput = new FileInputStream(file);
/*     */       
/*  42 */       prop.load(fileInput);
/*     */ 
/*     */       
/*  45 */       filePathList.put("badImagesLocation", prop.getProperty("BADIMAGESLOCATION"));
/*  46 */       filePathList.put("partialSuccessLocation", prop.getProperty("PARTIALSUCCESSLOCATION"));
/*  47 */       filePathList.put("inputFolderLocation", prop.getProperty("INPUTFOLDERLOCATION"));
/*     */       
/*  49 */       filePathList.put("smtpHost", prop.getProperty("SMTPHOST"));
/*  50 */       filePathList.put("emailSubject", prop.getProperty("EMAILSUBJECT"));
/*  51 */       filePathList.put("emailTo", prop.getProperty("EMAILTO"));
/*  52 */       filePathList.put("emailFrom", prop.getProperty("EMAILFROM"));
/*     */       
/*  54 */       filePathList.put("captureLink", prop.getProperty("CAPTURELINK"));
/*  55 */       filePathList.put("imagingLink", prop.getProperty("IMAGINGLINK"));
/*  56 */       filePathList.put("verifierLink", prop.getProperty("VERIFIERLINK"));
/*  57 */       filePathList.put("bpmLink", prop.getProperty("BPMLINK"));
/*     */       
/*  59 */       filePathList.put("wfrJDBCUrl", prop.getProperty("WFRJDBCURL"));
/*  60 */       filePathList.put("wfrPwd", prop.getProperty("WFRPWD"));
/*  61 */       filePathList.put("wfrUser", prop.getProperty("WFRUSER"));
/*     */       
/*  63 */       filePathList.put("eqJDBCUrl", prop.getProperty("EQJDBCURL"));
/*  64 */       filePathList.put("eqPwd", prop.getProperty("EQPWD"));
/*  65 */       filePathList.put("eqUser", prop.getProperty("EQUSER"));
/*     */       
/*  67 */       return true;
/*     */     }
/*  69 */     catch (Exception e) {
/*  70 */       e.printStackTrace();
/*  71 */       return false;
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
/* 118 */       if (!loadproperties()) {
/*     */         
/* 120 */         System.out.println("loadproperties not executed");
/* 121 */         System.out.println("--------Ending program-------");
/*     */         
/* 123 */         System.exit(0);
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
/* 220 */       ArrayList<String> list_of_links = new ArrayList<String>();
/* 221 */       ArrayList<String> link_status = new ArrayList<String>();
/* 222 */       ArrayList<String> success_list = new ArrayList<String>();
/*     */       
/* 224 */       for (String key : filePathList.keySet()) {
/*     */         
/* 226 */         String keyValue = key.toString();
/* 227 */         if (keyValue.contains("captureLink") || keyValue.contains("verifierLink") || keyValue.contains("imagingLink") || keyValue.contains("bpmLink"))
/*     */         {
/* 229 */           list_of_links.add(filePathList.get(key));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 234 */       System.out.println("no of links to be checked :" + list_of_links.size());
/* 235 */       System.out.println("name of links checked : captureLink, imagingLink, verifierLink, bpmLink");
/*     */ 
/*     */       
/* 238 */       for (String url : list_of_links) {
/*     */         
/*     */         try {
/* 241 */           if (!checkLinks(url)) {
/* 242 */             link_status.add(url); continue;
/*     */           } 
/* 244 */           success_list.add(url);
/* 245 */         } catch (Exception exception) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 250 */       if (link_status.size() == 0 || link_status == null) {
/* 251 */         System.out.println("All links working fine");
/*     */       } else {
/* 253 */         System.out.println("no of error links :" + link_status.size());
/*     */       } 
/*     */       
/* 256 */       int no_of_wfr_import_files = countWFRImport();
/* 257 */       int no_of_stuck_invoices = countStuckInvoices();
/* 258 */       int no_of_failed_instances = countFailedInterfaceInstance();
/* 259 */       int no_of_Error_recovery = countErrorForRecovery();
/* 260 */       int no_of_eQ_interface_rejections = countEqInterfaceRejections();
/* 261 */       int no_of_Bad_images = countBadImages();
/* 262 */       int no_partial_success_files = countPartialSuccess();
/* 263 */       int no_of_pending_certification = countPendingCertification();
/* 264 */       int no_of_file_stuck_in_input_folder = countInputFolder();
/*     */       
/* 266 */       int no_of_ecm_invisible_records = 0;
/*     */       
/* 268 */       System.out.println("no of success links :" + success_list.size());
/* 269 */       System.out.println("WFR_IMPORT count :" + no_of_wfr_import_files);
/* 270 */       System.out.println("stuck invoice in 50/150/250/750 :" + no_of_stuck_invoices);
/* 271 */       System.out.println("no of failed instances :" + no_of_failed_instances);
/* 272 */       System.out.println("Error for recovery count :" + no_of_Error_recovery);
/* 273 */       System.out.println("eQ interface rejected count :" + no_of_eQ_interface_rejections);
/* 274 */       System.out.println("no of bad images :" + no_of_Bad_images);
/* 275 */       System.out.println("no of partial success files :" + no_partial_success_files);
/* 276 */       System.out.println("pending for certification count :" + no_of_pending_certification);
/* 277 */       System.out.println("no of files stuck in input folder :" + no_of_file_stuck_in_input_folder);
/* 278 */       System.out.println("no of invisible records in ECM :" + no_of_ecm_invisible_records);
/*     */ 
/*     */       
/* 281 */       sendMail(success_list, link_status, no_of_wfr_import_files, no_of_stuck_invoices, no_of_failed_instances, no_of_Error_recovery, no_of_eQ_interface_rejections, no_of_Bad_images, no_of_file_stuck_in_input_folder, no_partial_success_files, no_of_pending_certification, no_of_ecm_invisible_records);
/*     */ 
/*     */     
/*     */     }
/* 285 */     catch (Exception e) {
/* 286 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countPendingCertification() {
/*     */     try {
/* 295 */       int count = 0;
/*     */       
/* 297 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 298 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/* 299 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Pending Certification%' and xipm_app_1_0 = 'eqadmin' and xipm_app_1_31='P2P INVOICE'");
/*     */       
/* 301 */       ResultSet rs = ps.executeQuery();
/* 302 */       while (rs.next()) {
/* 303 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 306 */       con.close();
/*     */       
/* 308 */       return count;
/* 309 */     } catch (Exception e) {
/* 310 */       e.printStackTrace();
/* 311 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int countPartialSuccess() {
/* 317 */     int count = 0;
/*     */     try {
/* 319 */       String partialSuccessLocation = filePathList.get("partialSuccessLocation");
/*     */ 
/*     */       
/* 322 */       File[] file = (new File(partialSuccessLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 324 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 325 */         if (f.getName().endsWith(".txt")) {
/* 326 */           count++;
/*     */         }
/*     */         
/*     */         b++; }
/*     */ 
/*     */       
/* 332 */       return count;
/* 333 */     } catch (Exception e) {
/* 334 */       e.printStackTrace();
/* 335 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int countBadImages() {
/* 341 */     int count = 0;
/*     */     try {
/* 343 */       String badImagesLocation = filePathList.get("badImagesLocation");
/*     */ 
/*     */       
/* 346 */       File[] file = (new File(badImagesLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 348 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 349 */         if (f.getName().endsWith(".tif")) {
/* 350 */           count++;
/*     */         }
/*     */         
/*     */         b++; }
/*     */ 
/*     */       
/* 356 */       return count;
/* 357 */     } catch (Exception e) {
/* 358 */       e.printStackTrace();
/* 359 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countInputFolder() {
/* 366 */     int count = 0;
/*     */     try {
/* 368 */       String inputFolderLocation = filePathList.get("inputFolderLocation");
/*     */ 
/*     */       
/* 371 */       File[] file = (new File(inputFolderLocation)).listFiles(); byte b; int i;
/*     */       File[] arrayOfFile1;
/* 373 */       for (i = (arrayOfFile1 = file).length, b = 0; b < i; ) { File f = arrayOfFile1[b];
/* 374 */         if (f.getName().endsWith(".tif")) {
/* 375 */           count++;
/*     */         }
/*     */         
/*     */         b++; }
/*     */ 
/*     */       
/* 381 */       return count;
/* 382 */     } catch (Exception e) {
/* 383 */       e.printStackTrace();
/* 384 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countEqInterfaceRejections() {
/*     */     try {
/* 392 */       int count = 0;
/*     */       
/* 394 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 395 */       Connection con = DriverManager.getConnection(filePathList.get("eqJDBCUrl"), filePathList.get("eqUser"), filePathList.get("eqPwd"));
/*     */       
/* 397 */       PreparedStatement ps = con.prepareStatement("select count(*) from apps.ap_invoices_interface where attribute12 like '%IMGPROCESS%' and status = 'REJECTED' and source IN ('P2P PO BASED','P2P NON PO INVOICE')");
/*     */       
/* 399 */       ResultSet rs = ps.executeQuery();
/* 400 */       while (rs.next()) {
/* 401 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 404 */       con.close();
/*     */       
/* 406 */       return count;
/* 407 */     } catch (Exception e) {
/* 408 */       e.printStackTrace();
/* 409 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countErrorForRecovery() {
/*     */     try {
/* 419 */       int count = 0;
/*     */       
/* 421 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 422 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 424 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like 'Internal%' and xipm_app_1_31='P2P INVOICE'");
/*     */       
/* 426 */       ResultSet rs = ps.executeQuery();
/* 427 */       while (rs.next()) {
/* 428 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 431 */       con.close();
/*     */       
/* 433 */       return count;
/* 434 */     } catch (Exception e) {
/* 435 */       e.printStackTrace();
/* 436 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countFailedInterfaceInstance() {
/*     */     try {
/* 444 */       int count = 0;
/*     */       
/* 446 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 447 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 449 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Failed%' and xipm_app_1_31='P2P INVOICE'");
/*     */       
/* 451 */       ResultSet rs = ps.executeQuery();
/* 452 */       while (rs.next()) {
/* 453 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 456 */       con.close();
/*     */       
/* 458 */       return count;
/* 459 */     } catch (Exception e) {
/* 460 */       e.printStackTrace();
/* 461 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countStuckInvoices() {
/*     */     try {
/* 469 */       int count = 0;
/*     */       
/* 471 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 472 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 474 */       PreparedStatement ps = con.prepareStatement("select count(*) from EQWFR.BATCH where STATE IN ('50','150','250','750','900')");
/*     */       
/* 476 */       ResultSet rs = ps.executeQuery();
/* 477 */       while (rs.next()) {
/* 478 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 481 */       con.close();
/*     */       
/* 483 */       return count;
/* 484 */     } catch (Exception e) {
/* 485 */       e.printStackTrace();
/* 486 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countWFRImport() {
/*     */     try {
/* 494 */       int count = 0;
/*     */       
/* 496 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 497 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 499 */       PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 = 'WFR_IMPORT' and xipm_app_1_31='P2P INVOICE'");
/*     */       
/* 501 */       ResultSet rs = ps.executeQuery();
/* 502 */       while (rs.next()) {
/* 503 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 506 */       con.close();
/*     */       
/* 508 */       return count;
/* 509 */     } catch (Exception e) {
/* 510 */       e.printStackTrace();
/* 511 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countECMInvisibleRecords() {
/*     */     try {
/* 520 */       int count = 0;
/*     */       
/* 522 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/* 523 */       Connection con = DriverManager.getConnection(filePathList.get("wfrJDBCUrl"), filePathList.get("wfrUser"), filePathList.get("wfrPwd"));
/*     */       
/* 525 */       PreparedStatement ps = con.prepareStatement("select count(*) from PROD_OCS.revisions where ddocname not in (select distinct(ddocname) from PROD_OCS.idctext1)");
/*     */       
/* 527 */       ResultSet rs = ps.executeQuery();
/* 528 */       while (rs.next()) {
/* 529 */         count = Integer.parseInt(rs.getString(1));
/*     */       }
/*     */       
/* 532 */       con.close();
/*     */       
/* 534 */       return count;
/* 535 */     } catch (Exception e) {
/* 536 */       e.printStackTrace();
/* 537 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean checkLinks(String url) {
/* 547 */     CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 553 */       URL u = new URL(url);
/* 554 */       HttpURLConnection huc = (HttpURLConnection)u.openConnection();
/* 555 */       huc.setConnectTimeout(20000);
/* 556 */       huc.setRequestMethod("GET");
/* 557 */       huc.connect();
/* 558 */       int code = huc.getResponseCode();
/*     */       
/* 560 */       if (code == 200) {
/* 561 */         return true;
/*     */       }
/*     */     }
/* 564 */     catch (Exception e) {
/*     */       
/* 566 */       return false;
/*     */     } 
/* 568 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void sendMail(ArrayList<String> success_list, ArrayList<String> link_status, int no_of_wfr_import_files, int no_of_stuck_invoices, int no_of_failed_instances, int no_of_Error_recovery, int no_of_eQ_interface_rejections, int no_of_Bad_images, int no_of_file_stuck_in_input_folder, int no_partial_success_files, int no_of_pending_certification, int no_of_ecm_invisible_records) {
/* 575 */     ReadOutlookUnprocessedMail mailread = new ReadOutlookUnprocessedMail();
/* 576 */     List<Integer> countMail = mailread.checkMail();
/*     */     
/* 578 */     System.out.println("Inside sendMail");
/* 579 */     Session session = null;
/* 580 */     String message = "<p>Hi All,</p>";
/* 581 */     if (link_status.size() > 0 || success_list.size() > 0) {
/* 582 */       message = String.valueOf(message) + "<p>Please find the application and the server health status of OWC Application.Additionally,please find AP Automation system status below:</p>";
/*     */     } else {
/* 584 */       message = String.valueOf(message) + "<p>Please find AP Automation system status below:</p>";
/*     */     } 
/* 586 */     message = String.valueOf(message) + "<table style = 'border: 1px solid black;border-collapse: collapse; collapse;width : 100%'>";
/* 587 */     message = String.valueOf(message) + "<tr><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Activity</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Module</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Date/Time</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Running Status</b></th></tr>";
/*     */     
/* 589 */     if ((success_list.size() > 0 && !success_list.isEmpty()) || (link_status.size() > 0 && !link_status.isEmpty()) || no_of_wfr_import_files >= 0 || no_of_stuck_invoices >= 0 || no_of_failed_instances >= 0 || no_of_Error_recovery >= 0 || no_of_eQ_interface_rejections >= 0 || no_of_pending_certification >= 0 || no_of_file_stuck_in_input_folder >= 0) {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 598 */         if (link_status.size() > 0) {
/*     */           
/* 600 */           for (String url : link_status) {
/* 601 */             if (url.contains("http://eqprod-capture1:16035/cs/")) {
/* 602 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/* 604 */             if (url.contains("http://eqprod-verifier1/WebVerifier/Login.aspx")) {
/* 605 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/* 607 */             if (url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")) {
/* 608 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/*     */             
/* 611 */             if (url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")) {
/* 612 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Error" + "</td></tr>";
/*     */             }
/*     */           }
/*     */         
/* 616 */         } else if (success_list.size() > 0) {
/*     */           
/* 618 */           for (String url : success_list) {
/* 619 */             if (url.contains("http://eqprod-capture1:16035/cs/")) {
/* 620 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
/*     */             }
/* 622 */             if (url.contains("http://eqprod-verifier1/WebVerifier/Login.aspx")) {
/* 623 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
/*     */             }
/* 625 */             if (url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")) {
/* 626 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
/*     */             }
/* 628 */             if (url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")) {
/* 629 */               message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + "Running Normal" + "</td></tr>";
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
/* 650 */         if (((Integer)countMail.get(0)).intValue() >= 0)
/* 651 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in unprocessed folder</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + countMail.get(0) + "</td></tr>"; 
/* 652 */         if (((Integer)countMail.get(1)).intValue() >= 0)
/* 653 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in unprocessed Junk folder</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + countMail.get(1) + "</td></tr>"; 
/* 654 */         if (((Integer)countMail.get(2)).intValue() >= 0)
/* 655 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in Capture Error folder</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + countMail.get(2) + "</td></tr>"; 
/* 656 */         if (no_of_file_stuck_in_input_folder >= 0)
/* 657 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck between Capture and WFR</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_file_stuck_in_input_folder + "</td></tr>"; 
/* 658 */         if (no_of_Bad_images >= 0)
/* 659 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices rejected by WFR due to poor quality</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_Bad_images + "</td></tr>"; 
/* 660 */         if (no_of_stuck_invoices >= 0)
/* 661 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Stuck Invoices (50/150/250/750/900)</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_stuck_invoices + "</td></tr>"; 
/* 662 */         if (no_partial_success_files >= 0)
/* 663 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR export failure</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_partial_success_files + "</td></tr>"; 
/* 664 */         if (no_of_wfr_import_files >= 0)
/* 665 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Import</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_wfr_import_files + "</td></tr>"; 
/* 666 */         if (no_of_ecm_invisible_records >= 0)
/* 667 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>ECM Invisible Records</td><td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_ecm_invisible_records + "</td></tr>"; 
/* 668 */         if (no_of_Error_recovery >= 0)
/* 669 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Internal error occured</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_Error_recovery + "</td></tr>"; 
/* 670 */         if (no_of_pending_certification >= 0)
/* 671 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Assigned invoices to Admin User</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_pending_certification + "</td></tr>"; 
/* 672 */         if (no_of_failed_instances >= 0)
/* 673 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices failed to insert record in AP interface</td><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_failed_instances + "</td></tr>"; 
/* 674 */         if (no_of_eQ_interface_rejections >= 0) {
/* 675 */           message = String.valueOf(message) + "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>AP interface rejection</td><td style = 'border: 1px solid black;border-collapse: collapse;'>eQ</td><td style = 'border: 1px solid black;border-collapse: collapse;'>" + sdf.format(new Date()) + "</td>" + "<td style = 'border: 1px solid black;border-collapse: collapse;'>" + no_of_eQ_interface_rejections + "</td></tr>";
/*     */         }
/* 677 */         message = String.valueOf(message) + "</table><br>";
/* 678 */         message = String.valueOf(message) + "Regards,<br>eQ OWC Support Team";
/*     */         
/* 680 */         Properties properties = System.getProperties();
/* 681 */         properties.setProperty("mail.smtp.host", filePathList.get("smtpHost"));
/* 682 */         session = Session.getDefaultInstance(properties);
/* 683 */         MimeMessage mimeMessage = new MimeMessage(session);
/* 684 */         mimeMessage.setFrom((Address)InternetAddress.parse((String)filePathList.get("emailFrom"), false)[0]);
/*     */         
/* 686 */         mimeMessage.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(filePathList.get("emailTo")));
/*     */ 
/*     */         
/* 689 */         mimeMessage.setSubject(filePathList.get("emailSubject"));
/* 690 */         mimeMessage.setSentDate(new Date());
/* 691 */         mimeMessage.setContent(message, "text/html; charset=utf-8");
/* 692 */         Transport.send((Message)mimeMessage);
/*     */ 
/*     */         
/* 695 */         System.out.println("WFR AP Automation Status Mail Sent Successfully");
/*     */       }
/* 697 */       catch (Exception e) {
/* 698 */         e.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       
/* 702 */       System.out.println("everything is woking fine");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\client notification\client notification\Qantas\APAutomationNotification.jar!\Test.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */