/*     */ package oracle.bpel.services.workflow.assignment.dynamic;
/*     */ 
/*     */ import ap.quantas.com.imaging.Constants;
/*     */ import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
/*     */ import ap.quantas.com.imaging.documentUpdate.DocumentService;
/*     */ import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
/*     */ import ap.quantas.com.imaging.documentUpdate.FieldType;
/*     */ import ap.quantas.com.imaging.documentUpdate.FieldValue;
/*     */ import ap.quantas.com.imaging.documentUpdate.TypedValue;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.sql.DataSource;
/*     */ import javax.xml.ws.BindingProvider;
/*     */ import javax.xml.ws.Holder;
/*     */ import javax.xml.ws.handler.Handler;
/*     */ import oracle.bpel.services.workflow.task.model.IdentityType;
/*     */ import oracle.bpel.services.workflow.task.model.Task;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ public class CustomEscalator
/*     */   implements IDynamicTaskEscalationPattern
/*     */ {
/*     */   public String getTaskEscalationUser(Task task) throws DynamicPatternException {
			System.out.println("in getTaskEscalationUser ");
/*  80 */     String eqfilesDataSourceName = Constants.getEqfilesDataSourceName();
/*  81 */     Connection conn1 = null;
/*  82 */     String logfilepath = null;
/*     */     try {
/*  84 */       Context ctx = new InitialContext();
/*  85 */       DataSource ds = (DataSource)ctx.lookup(eqfilesDataSourceName);
/*  86 */       conn1 = ds.getConnection();
/*  87 */       ResultSet rs = conn1.createStatement().executeQuery("select * from ap_properties_table where name='CUSTOM_ESCALATOR_LOG_FILE_LOCATION'");
/*  88 */       rs.next();
/*  89 */       logfilepath = rs.getString("value");
				System.out.println("logfilepath"+logfilepath);
/*  90 */       rs.close();
/*  91 */     } catch (Exception ex) {
/*  92 */       ex.printStackTrace();
/*     */     } finally {
/*     */       
/*  95 */       if (conn1 != null) {
/*     */         try {
/*  97 */           conn1.close();
/*  98 */         } catch (Exception ex) {}
/*     */       }
/*     */     } 
/* 101 */     CustomLogger logger = new CustomLogger(logfilepath);
				
/* 102 */     logger.info("========== getTaskEscalationUser STARTtt==========");
/* 103 */     logger.info("Inside CustomEscalator-------11111 getTaskEscalationUser using NXA connection eqfilesDataSourceName..... " + eqfilesDataSourceName);
/*     */     
/* 169 */     String userId = null;
/* 170 */     String documentId = null;
/* 171 */     String invoiceId = null;
/*     */     
/* 173 */     String supervisorId = null;
/* 174 */     String supervisorName = null;
/* 175 */     String superVisorEmailAddress = null;
/* 176 */     Element payload = task.getPayloadAsElement();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     logger.info(payload.getTextContent());
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
/* 192 */     NodeList nodelist1 = payload.getChildNodes();
/* 193 */     for (int i = 0; i < nodelist1.getLength(); i++) {
/*     */       
/* 195 */       String nodeName = nodelist1.item(i).getNodeName();
/*     */ 
/*     */ 
/*     */       
/* 199 */       if (nodeName.toLowerCase().endsWith("flexdata")) {
/* 200 */         Node invoiceImport = nodelist1.item(i);
/* 201 */         NodeList nodelist2 = invoiceImport.getChildNodes();
/* 202 */         for (int j = 0; j < nodelist2.getLength(); j++) {
/* 203 */           String childNodeName1 = nodelist2.item(j).getNodeName();
/*     */           
/* 205 */           if (childNodeName1.toLowerCase().endsWith("flexinfo")) {
/*     */             
/* 207 */             Node header_outer = nodelist2.item(j);
/* 208 */             NodeList nodelist3_outer = header_outer.getChildNodes();
/*     */             
/* 210 */             for (int jj = 0; jj < nodelist3_outer.getLength(); jj++) {
/*     */               
/* 212 */               if (!nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("attr2"))
/*     */               {
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
/* 224 */                 if (nodelist3_outer.item(jj).getNodeName().trim().contains("invoiceID")) {
/* 225 */                   logger.info("enetered invoice id from invoiceID check " + nodelist3_outer.item(jj).getTextContent());
/* 226 */                   invoiceId = nodelist3_outer.item(jj).getTextContent();
/* 227 */                   logger.info("Invoiceid is " + invoiceId);
/* 228 */                   if (invoiceId != null && !invoiceId.equals(""))
/*     */                   {
/* 230 */                     logger.info("InvoiceId is " + invoiceId);
/*     */                   }
/*     */                 }
/* 233 */                 else if (nodelist3_outer.item(jj).getNodeName().trim().contains("invoice")) {
/*     */                   
/* 235 */                   logger.info(" inside the else if " + nodelist3_outer.item(jj).getNodeName());
/* 236 */                   if (nodelist3_outer.item(jj).getNodeName().trim().contains("invoiceID")) {
/* 237 */                     logger.info("enetered invoice id " + nodelist3_outer.item(jj).getTextContent());
/* 238 */                     invoiceId = nodelist3_outer.item(jj).getTextContent();
/* 239 */                     if (invoiceId != null && !invoiceId.equals(""))
/*     */                     {
/* 241 */                       logger.info("InvoiceId is " + invoiceId);
/*     */                     }
/*     */                   } 
/*     */                   
/* 245 */                   logger.info("\t\t\t\tMatched : " + nodelist3_outer.item(jj).getNodeName() + " : " + nodelist3_outer.item(jj).getTextContent());
/*     */                 
/*     */                 }
/* 248 */                 else if (nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("attr1")) {
/*     */                   
/* 250 */                   documentId = nodelist3_outer.item(jj).getTextContent();
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */         System.out.println("-----invoiceId : " + invoiceId);
					System.out.println("-----Document ID : " + documentId);
/* 258 */         logger.info("-----invoiceId : " + invoiceId);
/* 259 */         logger.info("-----Document ID : " + documentId);
/*     */       } 
/*     */     } 
/*     */     
/* 263 */     userId = ((IdentityType)task.getSystemAttributes().getAssignees().get(0)).getId();
/*     */     
/* 265 */     logger.info("userId for task :: " + userId);
/* 266 */     logger.info("task for task :: " + task.getTaskDefinitionId());
/*     */ 
/*     */     
/* 269 */     String ebsDataSourceName = Constants.getEbsDataSourceName();
/* 270 */     Connection conn2 = null;
/* 271 */     if (userId != null) {
/*     */       try {
/* 273 */         Context ctx = new InitialContext();
/* 274 */         DataSource ds = (DataSource)ctx.lookup(ebsDataSourceName);
/* 275 */         conn2 = ds.getConnection();
/*     */         
/* 277 */         String query = "select papf_out.employee_number \"EMPLOYEE_NUMBER\", DECODE(a.SUPERVISOR_EMPLOYEE_NUMBER, 961426, NULL, a.SUPERVISOR_NAME) \"SUPERVISOR_NAME\", DECODE(a.SUPERVISOR_EMPLOYEE_NUMBER, 961426,NULL,a.SUPERVISOR_EMPLOYEE_NUMBER) \"SUPERVISOR_EMPLOYEE_NUMBER\", DECODE(a.SUPERVISOR_EMAIL_ADDRESS,'ALANJOYCE@QANTAS.COM.AU',NULL,a.SUPERVISOR_EMAIL_ADDRESS) \"SUPERVISOR_EMAIL_ADDRESS\" from apps.per_all_people_f papf_out, (select pap.full_name       SUPERVISOR_NAME, pap.employee_number SUPERVISOR_EMPLOYEE_NUMBER, pap.email_address   SUPERVISOR_EMAIL_ADDRESS from apps.per_all_assignments_f  paa, apps.per_all_people_f       pap, apps.per_periods_of_service ppos where paa.person_id = pap.person_id and paa.period_of_service_id = ppos.period_of_service_id and TRUNC(sysdate) between pap.effective_start_date and pap.effective_end_date and LEAST(NVL(prior ppos.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between paa.effective_start_date and paa.effective_end_date and paa.primary_flag = 'Y'and pap.current_employee_flag = 'Y' and level = (select MIN(level) from apps.per_all_assignments_f  paa_in, apps.per_all_people_f       pap_in, apps.per_periods_of_service ppos_in where paa_in.person_id = pap_in.person_id and paa_in.period_of_service_id = ppos_in.period_of_service_id and TRUNC(sysdate) between pap_in.effective_start_date and pap_in.effective_end_date and LEAST(NVL(ppos_in.actual_termination_date, TRUNC(SYSDATE)),TRUNC(SYSDATE)) between paa_in.effective_start_date and paa_in.effective_end_date and paa_in.primary_flag = 'Y' and pap_in.current_employee_flag = 'Y' and level <> 1 start with pap_in.employee_number = ? connect by paa_in.person_id = prior paa_in.supervisor_id and prior paa_in.period_of_service_id = prior ppos_in.period_of_service_id and prior paa_in.primary_flag = 'Y' and LEAST(NVL(prior ppos_in.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between prior paa_in.effective_start_date and prior paa_in.effective_end_date and TRUNC(sysdate) between prior pap_in.effective_start_date and prior pap_in.effective_end_date) start with pap.employee_number = ? connect by paa.person_id = prior paa.supervisor_id and prior paa.period_of_service_id = prior ppos.period_of_service_id and prior paa.primary_flag = 'Y' and LEAST(NVL(prior ppos.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between prior paa.effective_start_date and prior paa.effective_end_date and TRUNC(sysdate) between prior pap.effective_start_date and prior pap.effective_end_date) a where 1 = 1 and trunc(sysdate) between papf_out.effective_start_date and papf_out.effective_end_date and papf_out.current_employee_flag = 'Y' and papf_out.employee_number = ?";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */    
/* 422 */         PreparedStatement ps = conn2.prepareStatement(query);
/* 423 */         ps.setString(1, userId);
/* 424 */         ps.setString(2, userId);
/* 425 */         ps.setString(3, userId);
/*     */         
/* 427 */         ResultSet rs = ps.executeQuery();
					System.out.println("Query executed successfully ");
/* 428 */         logger.info("--------- Query executed successfully ------------");
/* 429 */         if (rs.next()) {
/*     */           
/* 431 */           supervisorId = rs.getString("SUPERVISOR_EMPLOYEE_NUMBER");
/* 432 */           supervisorName = rs.getString("SUPERVISOR_NAME");
/*     */           
/* 434 */           superVisorEmailAddress = rs.getString("SUPERVISOR_EMAIL_ADDRESS");
/*     */         } 
/* 437 */         System.out.println("--- Query Results --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);

/* 437 */         logger.info("--- Query Results --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);
/*     */         
/* 439 */         String vaccationRuleSQL = "{Call apps.qfeq_vacation_rule_prc(:p_role, :x_emp_num, :x_emp_name)}";
/* 440 */         CallableStatement callableStatement = conn2.prepareCall(vaccationRuleSQL);
/* 441 */         callableStatement.setString("p_role", supervisorId);
/* 442 */         callableStatement.registerOutParameter("x_emp_num", 12);
/* 443 */         callableStatement.registerOutParameter("x_emp_name", 12);
/* 444 */         callableStatement.execute();
/*     */         
/* 446 */         supervisorId = callableStatement.getString("x_emp_num");
/* 447 */         supervisorName = callableStatement.getString("x_emp_name");
/*     */         System.out.println("--- Query Results after applying vaccation rules --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);

/* 449 */         logger.info("--- Query Results after applying vaccation rules --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);
/*     */ 
/*     */       
/*     */       }
/* 453 */       catch (Exception ex) {
/* 454 */         logger.info(ex);
/*     */       } finally {
/* 456 */         if (conn2 != null) {
/*     */           try {
/* 458 */             conn2.close();
/* 459 */           } catch (Exception ex) {}
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 470 */     if (supervisorId == null || (supervisorId != null && supervisorId.trim().equals(""))) {
/* 471 */       supervisorId = "eqadmin";
/* 472 */       supervisorName = "eqadmin";
/*     */     } 
/*     */     
/*     */     try {
	/* 476 */       System.out.println(" --- Updating Webcenter IPM ---");
	
/* 476 */       logger.info(" --- Updating Webcenter IPM ---");
/* 477 */       DocumentService docUpdateService = (new DocumentService_Service()).getDocumentServicePort();
/* 478 */       BindingProvider bindingProvider = (BindingProvider)docUpdateService;
/*     */       
/* 480 */       List<Handler> handlerChain = new ArrayList<Handler>();
/* 481 */       handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PRD"));
/* 482 */       bindingProvider.getBinding().setHandlerChain(handlerChain);
/* 483 */       List<FieldValue> fieldValues = new ArrayList<FieldValue>();
/*     */ 
/*     */       
/* 486 */       FieldValue fieldValue1 = new FieldValue();
/* 487 */       fieldValue1.setName("Certifier Name");
/* 488 */       TypedValue typedValue1 = new TypedValue();
/* 489 */       typedValue1.setType(FieldType.TEXT);
/* 490 */       typedValue1.setValue(supervisorName);
/* 491 */       fieldValue1.setValue(typedValue1);
/*     */       
/* 493 */       FieldValue fieldValue2 = new FieldValue();
/* 494 */       fieldValue2.setName("Username");
/* 495 */       TypedValue typedValue2 = new TypedValue();
/* 496 */       typedValue2.setType(FieldType.TEXT);
/* 497 */       typedValue2.setValue(supervisorId);
/* 498 */       fieldValue2.setValue(typedValue2);
/*     */ 
/*     */       
/* 501 */       fieldValues.add(fieldValue1);
/* 502 */       fieldValues.add(fieldValue2);
/*     */ 
/*     */       
/* 505 */       docUpdateService.updateDocument(new Holder<String>(documentId), null, fieldValues, false);
/* 506 */       logger.info(" --- Updating Webcenter IPM successful ---");
/* 507 */     } catch (Exception e) {
/* 508 */       logger.info(" --- Updating Webcenter IPM failed ---" + e.getMessage());
/* 509 */       logger.info(e);
/*     */     } 
/*     */ 
/*     */     
/* 513 */     Connection conn3 = null;
/*     */     
/* 515 */     logger.info(" --- Retured invoiceId ::" + invoiceId);
/*     */     
/*     */     try {
				System.out.println(" --- Updating EQFILES ---");
/* 518 */       logger.info(" --- Updating EQFILES ---");
/*     */       
/* 520 */       logger.info(" --- Updating supervisorId ---" + supervisorId);
/* 521 */       logger.info(" --- Updating supervisorName ---" + supervisorName + "where invoice_id ->>>>" + invoiceId);
/* 522 */       logger.info(" eqfilesDataSourceName --->" + eqfilesDataSourceName);
/*     */       
/* 524 */       Context ctx = new InitialContext();
/* 525 */       DataSource ds = (DataSource)ctx.lookup(eqfilesDataSourceName);
/* 526 */       conn3 = ds.getConnection();
/* 527 */       PreparedStatement ps = conn3.prepareStatement("update ap_invoice_table set EMPLOYEE_NUMBER=?, CERTIFIER_NAME=?, MODIFIED_ON=?, MODIFIED_BY=?, ATTR9=?,CERTIFIER_EMAIL_ADD=? , CERTIFICATION_DATE=?   where INVOICE_ID=?");
/* 528 */       ps.setString(1, supervisorId);
/* 529 */       ps.setString(2, supervisorName);
/* 530 */       ps.setDate(3, new Date(System.currentTimeMillis()));
/* 531 */       ps.setString(4, "BPM");
/* 532 */       ps.setString(5, "FROM_BPM");
/* 533 */       ps.setString(6, superVisorEmailAddress);
/* 534 */       ps.setDate(7, new Date(System.currentTimeMillis()));
/*     */ 
/*     */       
/* 537 */       ps.setString(8, invoiceId);
/* 538 */       ps.executeUpdate();
/* 539 */       //conn3.commit();
/* 540 */       logger.info(" --- Updating EQFILES successful ---");
/*     */     }
/* 542 */     catch (Exception e) {
/* 543 */       logger.info(" --- Updating EQFILES failed ---" + e.getMessage());
/* 544 */       logger.info(e);
/*     */     } finally {
/*     */       
/* 547 */       if (conn3 != null) {
/*     */         try {
/* 549 */           conn3.close();
/*     */         }
/* 551 */         catch (Exception ex) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 556 */     //logger.close();
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
/*     */     System.out.println("========== getTaskEscalationUser END ==========");
/* 583 */     logger.info("========== getTaskEscalationUser END ==========");
/* 584 */     return supervisorId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInvoiceIdFromPayload(Task task, CustomLogger logger) {
/* 591 */     logger.info("GEt task info from getInvoiceIdFromPayload" + task.getSystemAttributes().getTaskId());
/*     */     
/* 593 */     Element payload = task.getPayloadAsElement();
/* 594 */     NodeList nList = payload.getChildNodes();
/* 595 */     String invoiceid = null;
/* 596 */     if (nList.getLength() > 0) {
/*     */       
/* 598 */       for (int count = 0; count < nList.getLength(); count++) {
/*     */         
/* 600 */         Node currentNode = nList.item(count);
/* 601 */         if (currentNode.getNodeType() == 1) {
/*     */ 
/*     */           
/* 604 */           logger.info("currentNode Node Name =" + currentNode.getNodeName() + " [OPEN]");
/* 605 */           logger.info("currentNode Node Value =" + currentNode.getTextContent());
/*     */           
/* 607 */           if (currentNode.getNodeName().trim().contains("InvoiceID")) {
/* 608 */             invoiceid = currentNode.getTextContent();
/* 609 */             System.out.println("InvoiceID found  ::::NodeName :: " + currentNode.getNodeName() + "<-----NodeValue--->" + currentNode.getTextContent());
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 616 */       System.out.println("invoiceid :::" + invoiceid);
/* 617 */       return invoiceid;
/*     */     } 
/*     */     
/* 620 */     return invoiceid;
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
/*     */   public void setInitParams(Map<String, String> map) throws DynamicPatternException {}
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
/*     */   public String getName() {
/* 649 */     return "CustomEscalator";
/*     */   }
/*     */   
/*     */   public String getLabel(Locale locale) {
/* 653 */     return null;
/*     */   }
/*     */   
/*     */   public String getDescription(Locale locale) {
/* 657 */     return null;
/*     */   }
/*     */   
/*     */   public Set<IDynamicPattern.IDynamicPatternParameter> getPatternParameters() {
/* 661 */     return Collections.emptySet();
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\oracle\bpel\services\workflow\assignment\dynamic\CustomEscalator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */