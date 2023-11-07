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
/*     */ public class CustomEscalator_Jetstar
/*     */   implements IDynamicTaskEscalationPattern
/*     */ {
/*     */   public String getTaskEscalationUser(Task task) throws DynamicPatternException {
/*  80 */     System.out.println("Inside CustomEscalator getTaskEscalationUser ");
/*  81 */     String eqfilesDataSourceName = Constants.getEqfilesDataSourceName();
/*  82 */     Connection conn1 = null;
/*  83 */     String logfilepath = null;
/*     */     try {
/*  85 */       Context ctx = new InitialContext();
/*  86 */       DataSource ds = (DataSource)ctx.lookup(eqfilesDataSourceName);
/*  87 */       conn1 = ds.getConnection();
/*  88 */       ResultSet rs = conn1.createStatement().executeQuery("select * from ap_properties_table where name='CUSTOM_ESCALATOR_LOG_FILE_LOCATION'");
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
/*     */     
/* 169 */     String userId = null;
/* 170 */     String documentId = null;
/* 171 */     String invoiceId = null;
/*     */     
/* 173 */     String supervisorId = null;
/* 174 */     String supervisorName = null;
/* 175 */     Element payload = task.getPayloadAsElement();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     logger.info(payload.getTextContent());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     NodeList nodelist1 = payload.getChildNodes();
/* 187 */     for (int i = 0; i < nodelist1.getLength(); i++) {
/*     */       
/* 189 */       String nodeName = nodelist1.item(i).getNodeName();
/* 190 */       logger.info("\t\tOuter loop : " + nodeName);
/*     */ 
/*     */       
/* 193 */       if (nodeName.toLowerCase().endsWith("flexdata")) {
/* 194 */         Node invoiceImport = nodelist1.item(i);
/* 195 */         NodeList nodelist2 = invoiceImport.getChildNodes();
/* 196 */         for (int j = 0; j < nodelist2.getLength(); j++) {
/* 197 */           String childNodeName1 = nodelist2.item(j).getNodeName();
/*     */           
/* 199 */           if (childNodeName1.toLowerCase().endsWith("flexinfo")) {
/*     */             
/* 201 */             Node header_outer = nodelist2.item(j);
/* 202 */             NodeList nodelist3_outer = header_outer.getChildNodes();
/*     */             
/* 204 */             for (int jj = 0; jj < nodelist3_outer.getLength(); jj++) {
/*     */               
/* 206 */               if (!nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("attr2"))
/*     */               {
/*     */ 
/*     */ 
/*     */                 
/* 211 */                 if (nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("invoiceID")) {
/*     */                   
/* 213 */                   invoiceId = nodelist3_outer.item(jj).getTextContent();
/* 214 */                 } else if (nodelist3_outer.item(jj).getNodeName().toLowerCase().contains("attr1")) {
/*     */                   
/* 216 */                   documentId = nodelist3_outer.item(jj).getTextContent();
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     userId = ((IdentityType)task.getSystemAttributes().getAssignees().get(0)).getId();
/*     */     
/* 231 */     System.out.println("userId for task :: " + userId);
/* 232 */     System.out.println("task for task :: " + task.getTaskDefinitionId());
/*     */ 
/*     */     
/* 235 */     String ebsDataSourceName = Constants.getEbsDataSourceName();
/* 236 */     Connection conn2 = null;
/* 237 */     if (userId != null) {
/*     */       try {
/* 239 */         Context ctx = new InitialContext();
/* 240 */         DataSource ds = (DataSource)ctx.lookup(ebsDataSourceName);
/* 241 */         conn2 = ds.getConnection();
/* 242 */         String query = "select papf_out.employee_number \"EMPLOYEE_NUMBER\", DECODE(a.SUPERVISOR_EMPLOYEE_NUMBER,961426,NULL,a.SUPERVISOR_NAME) \"SUPERVISOR_NAME\", DECODE(a.SUPERVISOR_EMPLOYEE_NUMBER,961426,NULL,a.SUPERVISOR_EMPLOYEE_NUMBER) \"SUPERVISOR_EMPLOYEE_NUMBER\" from apps.per_all_people_f papf_out,      (select pap.full_name SUPERVISOR_NAME,       pap.employee_number SUPERVISOR_EMPLOYEE_NUMBER from apps.per_all_assignments_f  paa,      apps.per_all_people_f       pap,      apps.per_periods_of_service ppos where paa.person_id = pap.person_id and paa.period_of_service_id = ppos.period_of_service_id and TRUNC(sysdate) between pap.effective_start_date and pap.effective_end_date and LEAST(NVL(prior ppos.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between paa.effective_start_date and paa.effective_end_date and paa.primary_flag = 'Y' and pap.current_employee_flag = 'Y' and level = (select MIN(level) from apps.per_all_assignments_f  paa_in,      apps.per_all_people_f       pap_in,      apps.per_periods_of_service ppos_in where paa_in.person_id = pap_in.person_id and paa_in.period_of_service_id = ppos_in.period_of_service_id and TRUNC(sysdate) between pap_in.effective_start_date and pap_in.effective_end_date and LEAST(NVL(ppos_in.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between paa_in.effective_start_date and paa_in.effective_end_date and paa_in.primary_flag = 'Y' and pap_in.current_employee_flag = 'Y' and level <> 1 start with pap_in.employee_number = ? connect by paa_in.person_id = prior paa_in.supervisor_id and prior paa_in.period_of_service_id = prior ppos_in.period_of_service_id and prior paa_in.primary_flag = 'Y' and LEAST(NVL(prior ppos_in.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between prior paa_in.effective_start_date and prior paa_in.effective_end_date and TRUNC(sysdate) between prior pap_in.effective_start_date and prior pap_in.effective_end_date) start with pap.employee_number = ? connect by paa.person_id = prior paa.supervisor_id and prior paa.period_of_service_id = prior ppos.period_of_service_id and prior paa.primary_flag = 'Y' and LEAST(NVL(prior ppos.actual_termination_date, TRUNC(SYSDATE)), TRUNC(SYSDATE)) between prior paa.effective_start_date and prior paa.effective_end_date and TRUNC(sysdate) between prior pap.effective_start_date and prior pap.effective_end_date ) a where 1=1 and trunc(sysdate) between papf_out.effective_start_date and  papf_out.effective_end_date and papf_out.current_employee_flag='Y' and papf_out.employee_number= ?";
/*     */ 
/*     */          
/* 314 */         PreparedStatement ps = conn2.prepareStatement(query);
/* 315 */         ps.setString(1, userId);
/* 316 */         ps.setString(2, userId);
/* 317 */         ps.setString(3, userId);
/*     */         
/* 319 */         ResultSet rs = ps.executeQuery();
/* 320 */         logger.info("--------- Query executed successfully ------------");
/* 321 */         if (rs.next()) {
/*     */           
/* 323 */           supervisorId = rs.getString("SUPERVISOR_EMPLOYEE_NUMBER");
/* 324 */           supervisorName = rs.getString("SUPERVISOR_NAME");
/*     */         } 
/*     */         
/* 327 */         logger.info("--- Query Results --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);
/*     */         
/* 329 */         String vaccationRuleSQL = "{Call apps.qfeq_vacation_rule_prc(:p_role, :x_emp_num, :x_emp_name)}";
/* 330 */         CallableStatement callableStatement = conn2.prepareCall(vaccationRuleSQL);
/* 331 */         callableStatement.setString("p_role", supervisorId);
/* 332 */         callableStatement.registerOutParameter("x_emp_num", 12);
/* 333 */         callableStatement.registerOutParameter("x_emp_name", 12);
/* 334 */         callableStatement.execute();
/*     */         
/* 336 */         supervisorId = callableStatement.getString("x_emp_num");
/* 337 */         supervisorName = callableStatement.getString("x_emp_name");
/*     */         
/* 339 */         logger.info("--- Query Results after applying vaccation rules --- userId:" + userId + ", supervisorId:" + supervisorId + ", supervisorName:" + supervisorName);
/*     */ 
/*     */       
/*     */       }
/* 343 */       catch (Exception ex) {
/* 344 */         logger.info(ex);
/*     */       } finally {
/* 346 */         if (conn2 != null) {
/*     */           try {
/* 348 */             conn2.close();
/* 349 */           } catch (Exception ex) {}
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
/* 360 */     if (supervisorId == null || (supervisorId != null && supervisorId.trim().equals(""))) {
/* 361 */       supervisorId = "eqadmin";
/* 362 */       supervisorName = "eqadmin";
/*     */     } 
/*     */     
/*     */     try {
/* 366 */       logger.info(" --- Updating Webcenter IPM ---");
/* 367 */       DocumentService docUpdateService = (new DocumentService_Service()).getDocumentServicePort();
/* 368 */       BindingProvider bindingProvider = (BindingProvider)docUpdateService;
/*     */       
/* 370 */       List<Handler> handlerChain = new ArrayList<Handler>();
/* 371 */       handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PRD"));
/* 372 */       bindingProvider.getBinding().setHandlerChain(handlerChain);
/* 373 */       List<FieldValue> fieldValues = new ArrayList<FieldValue>();
/*     */ 
/*     */       
/* 376 */       FieldValue fieldValue1 = new FieldValue();
/* 377 */       fieldValue1.setName("Certifier Name");
/* 378 */       TypedValue typedValue1 = new TypedValue();
/* 379 */       typedValue1.setType(FieldType.TEXT);
/* 380 */       typedValue1.setValue(supervisorName);
/* 381 */       fieldValue1.setValue(typedValue1);
/*     */       
/* 383 */       FieldValue fieldValue2 = new FieldValue();
/* 384 */       fieldValue2.setName("Username");
/* 385 */       TypedValue typedValue2 = new TypedValue();
/* 386 */       typedValue2.setType(FieldType.TEXT);
/* 387 */       typedValue2.setValue(supervisorId);
/* 388 */       fieldValue2.setValue(typedValue2);
/*     */ 
/*     */       
/* 391 */       fieldValues.add(fieldValue1);
/* 392 */       fieldValues.add(fieldValue2);
/*     */ 
/*     */       
/* 395 */       docUpdateService.updateDocument(new Holder<String>(documentId), null, fieldValues, false);
/* 396 */       logger.info(" --- Updating Webcenter IPM successful ---");
/* 397 */     } catch (Exception e) {
/* 398 */       logger.info(" --- Updating Webcenter IPM failed ---" + e.getMessage());
/* 399 */       logger.info(e);
/*     */     } 
/*     */ 
/*     */     
/* 403 */     Connection conn3 = null;
/*     */     try {
/* 405 */       logger.info(" --- Updating EQFILES ---");
/* 406 */       Context ctx = new InitialContext();
/* 407 */       DataSource ds = (DataSource)ctx.lookup(eqfilesDataSourceName);
/* 408 */       conn3 = ds.getConnection();
/* 409 */       PreparedStatement ps = conn3.prepareStatement("update ap_invoice_table set EMPLOYEE_NUMBER=?, CERTIFIER_NAME=?, MODIFIED_ON=?, MODIFIED_BY=?, HEADER_ATTR9=? where INVOICE_ID=?");
/* 410 */       ps.setString(1, supervisorId);
/* 411 */       ps.setString(2, supervisorName);
/* 412 */       ps.setDate(3, new Date(System.currentTimeMillis()));
/* 413 */       ps.setString(4, "BPM");
/* 414 */       ps.setString(5, "FROM_BPM");
/* 415 */       ps.setString(6, invoiceId);
/* 416 */       ps.executeUpdate();
/* 417 */       conn3.commit();
/* 418 */       logger.info(" --- Updating EQFILES successful ---");
/*     */     }
/* 420 */     catch (Exception e) {
/* 421 */       logger.info(" --- Updating EQFILES failed ---" + e.getMessage());
/* 422 */       logger.info(e);
/*     */     } finally {
/*     */       
/* 425 */       if (conn3 != null) {
/*     */         try {
/* 427 */           conn3.close();
/* 428 */         } catch (Exception ex) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 433 */     //logger.close();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 460 */     logger.info("========== getTaskEscalationUser END ==========");
/* 461 */     return supervisorId;
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
/*     */   public String getName() {
/* 488 */     return "CustomEscalator_Qantas";
/*     */   }
/*     */   
/*     */   public String getLabel(Locale locale) {
/* 492 */     return null;
/*     */   }
/*     */   
/*     */   public String getDescription(Locale locale) {
/* 496 */     return null;
/*     */   }
/*     */   
/*     */   public Set<IDynamicPattern.IDynamicPatternParameter> getPatternParameters() {
/* 500 */     return Collections.emptySet();
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\oracle\bpel\services\workflow\assignment\dynamic\CustomEscalator_Jetstar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */