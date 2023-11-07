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
/*     */ 
/*     */ public class CustomEscalator_Jetstar
/*     */   implements IDynamicTaskEscalationPattern
/*     */ {
/*     */   public String getTaskEscalationUser(Task task) throws DynamicPatternException {
/*  81 */     String eqfilesDataSourceName = Constants.getEqfilesDataSourceName();
/*  82 */     Connection conn1 = null;
/*  83 */     String logfilepath = null;
/*     */     try {
/*  85 */       Context ctx = new InitialContext();
/*  86 */       DataSource ds = (DataSource)ctx.lookup(eqfilesDataSourceName);
/*  87 */       conn1 = ds.getConnection();
/*  88 */       ResultSet rs = conn1.createStatement().executeQuery("select * from js_ap_properties_table where name='CUSTOM_ESCALATOR_LOG_FILE_LOCATION'");
/*  89 */       rs.next();
/*  90 */       logfilepath = rs.getString("value");
/*  91 */       rs.close();
/*  92 */     } catch (Exception ex) {
/*  93 */       ex.printStackTrace();
/*     */     } finally {
/*     */       
/*  96 */       if (conn1 != null) {
/*     */         try {
/*  98 */           conn1.close();
/*  99 */         } catch (Exception ex) {}
/*     */       }
/*     */     } 
/* 102 */     CustomLogger logger = new CustomLogger(logfilepath);
/* 103 */     logger.info("========== getTaskEscalationUser START ==========");
/* 104 */     logger.info("Inside CustomEscalator getTaskEscalationUser using NXA connection eqfilesDataSourceName..... " + eqfilesDataSourceName);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     String userId = null;
/* 171 */     String documentId = null;
/* 172 */     String invoiceId = null;
/*     */     
/* 174 */     String supervisorId = null;
/* 175 */     String supervisorName = null;
/* 176 */     String superVisorEmailAddress = null;
/* 177 */     Element payload = task.getPayloadAsElement();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     logger.info(payload.getTextContent());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     NodeList nodelist1 = payload.getChildNodes();
/* 194 */     for (int i = 0; i < nodelist1.getLength(); i++) {
/*     */       
/* 196 */       String nodeName = nodelist1.item(i).getNodeName();
/*     */ 
/*     */ 
/*     */       
/* 200 */       if (nodeName.toLowerCase().endsWith("flexdata")) {
/* 201 */         Node invoiceImport = nodelist1.item(i);
/* 202 */         NodeList nodelist2 = invoiceImport.getChildNodes();
/* 203 */         for (int j = 0; j < nodelist2.getLength(); j++) {
/* 204 */           String childNodeName1 = nodelist2.item(j).getNodeName();
/*     */           
/* 206 */           if (childNodeName1.toLowerCase().endsWith("flexinfo")) {
/*     */             
/* 208 */             Node header_outer = nodelist2.item(j);
/* 209 */             NodeList nodelist3_outer = header_outer.getChildNodes();
/*     */             
/* 211 */             for (int jj = 0; jj < nodelist3_outer.getLength(); jj++) {
/*     */               
/* 213 */               if (!nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("attr2"))
/*     */               {
/*     */ 
/*     */ 
/*     */                 
/* 218 */                 if (nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("invoiceID")) {
/* 219 */                   logger.info("\t\t\t\tMatched : " + nodelist3_outer.item(jj).getNodeName() + " : " + nodelist3_outer.item(jj).getTextContent());
/* 220 */                   invoiceId = nodelist3_outer.item(jj).getTextContent();
/* 221 */                 } else if (nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("attr1")) {
/*     */                   
/* 223 */                   documentId = nodelist3_outer.item(jj).getTextContent();
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 232 */         logger.info("-----Document ID : " + documentId);
/*     */       } 
/*     */     } 
/*     */     
/* 236 */     userId = ((IdentityType)task.getSystemAttributes().getAssignees().get(0)).getId();
/*     */     
/* 238 */     logger.info("userId for task :: " + userId);
/* 239 */     logger.info("task for task :: " + task.getTaskDefinitionId());
/*     */ 
/*     */     
/* 242 */     String ebsDataSourceName = Constants.getEbsDataSourceName();
/* 243 */     Connection conn2 = null;
/* 244 */     if (userId != null) {
/*     */       try {
/* 246 */         Context ctx = new InitialContext();
/* 247 */         DataSource ds = (DataSource)ctx.lookup(ebsDataSourceName);
/* 248 */         conn2 = ds.getConnection();
/*     */         
/* 250 */         String query = "select papf_out.employee_number \"EMPLOYEE_NUMBER\", DECODE(a.SUPERVISOR_EMPLOYEE_NUMBER, 961426, NULL, a.SUPERVISOR_NAME) \"SUPERVISOR_NAME\", DECODE(a.SUPERVISOR_EMPLOYEE_NUMBER, 961426,NULL,a.SUPERVISOR_EMPLOYEE_NUMBER) \"SUPERVISOR_EMPLOYEE_NUMBER\", DECODE(a.SUPERVISOR_EMAIL_ADDRESS,'ALANJOYCE@QANTAS.COM.AU',NULL,a.SUPERVISOR_EMAIL_ADDRESS) \"SUPERVISOR_EMAIL_ADDRESS\" from apps.per_all_people_f papf_out, (select pap.full_name       SUPERVISOR_NAME, pap.employee_number SUPERVISOR_EMPLOYEE_NUMBER, pap.email_address   SUPERVISOR_EMAIL_ADDRESS from apps.per_all_assignments_f  paa, apps.per_all_people_f       pap, apps.per_periods_of_service ppos where paa.person_id = pap.person_id and paa.period_of_service_id = ppos.period_of_service_id and TRUNC(sysdate) between pap.effective_start_date and pap.effective_end_date and LEAST(NVL(prior ppos.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between paa.effective_start_date and paa.effective_end_date and paa.primary_flag = 'Y'and pap.current_employee_flag = 'Y' and level = (select MIN(level) from apps.per_all_assignments_f  paa_in, apps.per_all_people_f       pap_in, apps.per_periods_of_service ppos_in where paa_in.person_id = pap_in.person_id and paa_in.period_of_service_id = ppos_in.period_of_service_id and TRUNC(sysdate) between pap_in.effective_start_date and pap_in.effective_end_date and LEAST(NVL(ppos_in.actual_termination_date, TRUNC(SYSDATE)),TRUNC(SYSDATE)) between paa_in.effective_start_date and paa_in.effective_end_date and paa_in.primary_flag = 'Y' and pap_in.current_employee_flag = 'Y' and level <> 1 start with pap_in.employee_number = ? connect by paa_in.person_id = prior paa_in.supervisor_id and prior paa_in.period_of_service_id = prior ppos_in.period_of_service_id and prior paa_in.primary_flag = 'Y' and LEAST(NVL(prior ppos_in.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between prior paa_in.effective_start_date and prior paa_in.effective_end_date and TRUNC(sysdate) between prior pap_in.effective_start_date and prior pap_in.effective_end_date) start with pap.employee_number = ? connect by paa.person_id = prior paa.supervisor_id and prior paa.period_of_service_id = prior ppos.period_of_service_id and prior paa.primary_flag = 'Y' and LEAST(NVL(prior ppos.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between prior paa.effective_start_date and prior paa.effective_end_date and TRUNC(sysdate) between prior pap.effective_start_date and prior pap.effective_end_date) a where 1 = 1 and trunc(sysdate) between papf_out.effective_start_date and papf_out.effective_end_date and papf_out.current_employee_flag = 'Y' and papf_out.employee_number = ?";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 395 */         PreparedStatement ps = conn2.prepareStatement(query);
/* 396 */         ps.setString(1, userId);
/* 397 */         ps.setString(2, userId);
/* 398 */         ps.setString(3, userId);
/*     */         
/* 400 */         ResultSet rs = ps.executeQuery();
/* 401 */         logger.info("--------- Query executed successfully ------------");
/* 402 */         if (rs.next()) {
/*     */           
/* 404 */           supervisorId = rs.getString("SUPERVISOR_EMPLOYEE_NUMBER");
/* 405 */           supervisorName = rs.getString("SUPERVISOR_NAME");
/*     */           
/* 407 */           superVisorEmailAddress = rs.getString("SUPERVISOR_EMAIL_ADDRESS");
/*     */         } 
/*     */         
/* 410 */         logger.info("--- Query Results --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);
/*     */         
/* 412 */         String vaccationRuleSQL = "{Call apps.qfeq_vacation_rule_prc(:p_role, :x_emp_num, :x_emp_name)}";
/* 413 */         CallableStatement callableStatement = conn2.prepareCall(vaccationRuleSQL);
/* 414 */         callableStatement.setString("p_role", supervisorId);
/* 415 */         callableStatement.registerOutParameter("x_emp_num", 12);
/* 416 */         callableStatement.registerOutParameter("x_emp_name", 12);
/* 417 */         callableStatement.execute();
/*     */         
/* 419 */         supervisorId = callableStatement.getString("x_emp_num");
/* 420 */         supervisorName = callableStatement.getString("x_emp_name");
/*     */         
/* 422 */         logger.info("--- Query Results after applying vaccation rules --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);
/*     */ 
/*     */       
/*     */       }
/* 426 */       catch (Exception ex) {
/* 427 */         logger.info(ex);
/*     */       } finally {
/* 429 */         if (conn2 != null) {
/*     */           try {
/* 431 */             conn2.close();
/* 432 */           } catch (Exception ex) {}
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
/* 443 */     if (supervisorId == null || (supervisorId != null && supervisorId.trim().equals(""))) {
/* 444 */       supervisorId = "eqadmin";
/* 445 */       supervisorName = "eqadmin";
/*     */     } 
/*     */     
/*     */     try {
/* 449 */       logger.info(" --- Updating Webcenter IPM ---");
/* 450 */       DocumentService docUpdateService = (new DocumentService_Service()).getDocumentServicePort();
/* 451 */       BindingProvider bindingProvider = (BindingProvider)docUpdateService;
/*     */       
/* 453 */       List<Handler> handlerChain = new ArrayList<Handler>();
/* 454 */       handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PRD"));
/* 455 */       bindingProvider.getBinding().setHandlerChain(handlerChain);
/* 456 */       List<FieldValue> fieldValues = new ArrayList<FieldValue>();
/*     */ 
/*     */       
/* 459 */       FieldValue fieldValue1 = new FieldValue();
/* 460 */       fieldValue1.setName("Certifier Name");
/* 461 */       TypedValue typedValue1 = new TypedValue();
/* 462 */       typedValue1.setType(FieldType.TEXT);
/* 463 */       typedValue1.setValue(supervisorName);
/* 464 */       fieldValue1.setValue(typedValue1);
/*     */       
/* 466 */       FieldValue fieldValue2 = new FieldValue();
/* 467 */       fieldValue2.setName("Username");
/* 468 */       TypedValue typedValue2 = new TypedValue();
/* 469 */       typedValue2.setType(FieldType.TEXT);
/* 470 */       typedValue2.setValue(supervisorId);
/* 471 */       fieldValue2.setValue(typedValue2);
/*     */ 
/*     */       
/* 474 */       fieldValues.add(fieldValue1);
/* 475 */       fieldValues.add(fieldValue2);
/*     */ 
/*     */       
/* 478 */       docUpdateService.updateDocument(new Holder<String>(documentId), null, fieldValues, false);
/* 479 */       logger.info(" --- Updating Webcenter IPM successful ---");
/* 480 */     } catch (Exception e) {
/* 481 */       logger.info(" --- Updating Webcenter IPM failed ---" + e.getMessage());
/* 482 */       logger.info(e);
/*     */     } 
/*     */ 
/*     */     
/* 486 */     Connection conn3 = null;
/* 487 */     invoiceId = getInvoiceIdFromPayload(task, logger);
/* 488 */     logger.info(" --- Retured invoiceId ::" + invoiceId);
/*     */     
/*     */     try {
/* 491 */       logger.info(" --- Updating EQFILES ---");
/*     */       
/* 493 */       logger.info(" --- Updating supervisorId ---" + supervisorId);
/* 494 */       logger.info(" --- Updating supervisorName ---" + supervisorName + "where invoice_id ->>>>" + invoiceId);
/* 495 */       logger.info(" eqfilesDataSourceName --->" + eqfilesDataSourceName);
/*     */       
/* 497 */       Context ctx = new InitialContext();
/* 498 */       DataSource ds = (DataSource)ctx.lookup(eqfilesDataSourceName);
/* 499 */       conn3 = ds.getConnection();
/* 500 */       PreparedStatement ps = conn3.prepareStatement("update js_ap_invoice_table set EMPLOYEE_NUMBER=?, CERTIFIER_NAME=?, MODIFIED_ON=?, MODIFIED_BY=?, HEADER_ATTR9=? ,CERTIFIER_EMAIL_ADD=? where INVOICE_ID=?");
/* 501 */       ps.setString(1, supervisorId);
/* 502 */       ps.setString(2, supervisorName);
/* 503 */       ps.setDate(3, new Date(System.currentTimeMillis()));
/* 504 */       ps.setString(4, "BPM");
/* 505 */       ps.setString(5, "FROM_BPM");
/* 506 */       ps.setString(6, superVisorEmailAddress);
/*     */       
/* 508 */       ps.setString(7, invoiceId);
/* 509 */       ps.executeUpdate();
/* 510 */       //conn3.commit();
/* 511 */       logger.info(" --- Updating EQFILES successful ---");
/*     */     }
/* 513 */     catch (Exception e) {
/* 514 */       logger.info(" --- Updating EQFILES failed ---" + e.getMessage());
/* 515 */       logger.info(e);
/*     */     } finally {
/*     */       
/* 518 */       if (conn3 != null) {
/*     */         try {
/* 520 */           conn3.close();
/*     */         }
/* 522 */         catch (Exception ex) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 527 */     //logger.close();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 554 */     logger.info("========== getTaskEscalationUser END ==========");
/* 555 */     return supervisorId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInvoiceIdFromPayload(Task task, CustomLogger logger) {
/* 562 */     logger.info("GEt task info from getInvoiceIdFromPayload" + task.getSystemAttributes().getTaskId());
/*     */     
/* 564 */     Element payload = task.getPayloadAsElement();
/* 565 */     NodeList nList = payload.getChildNodes();
/* 566 */     String invoiceid = null;
/* 567 */     if (nList.getLength() > 0) {
/*     */       
/* 569 */       for (int count = 0; count < nList.getLength(); count++) {
/*     */         
/* 571 */         Node currentNode = nList.item(count);
/* 572 */         if (currentNode.getNodeType() == 1) {
/*     */ 
/*     */           
/* 575 */           logger.info("currentNode Node Name =" + currentNode.getNodeName() + " [OPEN]");
/* 576 */           logger.info("currentNode Node Value =" + currentNode.getTextContent());
/*     */           
/* 578 */           if (currentNode.getNodeName().trim().contains("InvoiceID")) {
/* 579 */             invoiceid = currentNode.getTextContent();
/* 580 */             System.out.println("InvoiceID found  ::::NodeName :: " + currentNode.getNodeName() + "<-----NodeValue--->" + currentNode.getTextContent());
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 587 */       System.out.println("invoiceid :::" + invoiceid);
/* 588 */       return invoiceid;
/*     */     } 
/*     */     
/* 591 */     return invoiceid;
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
/* 620 */     return "CustomEscalator_Jetstar";
/*     */   }
/*     */   
/*     */   public String getLabel(Locale locale) {
/* 624 */     return null;
/*     */   }
/*     */   
/*     */   public String getDescription(Locale locale) {
/* 628 */     return null;
/*     */   }
/*     */   
/*     */   public Set<IDynamicPattern.IDynamicPatternParameter> getPatternParameters() {
/* 632 */     return Collections.emptySet();
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\oracle\bpel\services\workflow\assignment\dynamic\CustomEscalator_Jetstar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */