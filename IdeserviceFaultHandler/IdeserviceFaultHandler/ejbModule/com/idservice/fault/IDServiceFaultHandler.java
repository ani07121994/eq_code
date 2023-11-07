/*     */ package com.idservice.fault;
/*     */ 
/*     */ import com.collaxa.cube.engine.fp.BPELFaultRecoveryContextImpl;
/*     */ import com.idservice.fault.mail.MailSender;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import oracle.integration.platform.faultpolicy.IFaultRecoveryContext;
/*     */ import oracle.integration.platform.faultpolicy.IFaultRecoveryJavaClass;
/*     */ import oracle.xml.parser.v2.XMLElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 

/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IDServiceFaultHandler
/*     */   implements IFaultRecoveryJavaClass
/*     */ {
/*     */   public void handleRetrySuccess(IFaultRecoveryContext iFaultRecoveryContext) {
/*  24 */     System.out.println("Retry Success");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String handleFault(IFaultRecoveryContext iFaultRecoveryContext) {
/*  30 */     StringBuffer mailBody = new StringBuffer();
/*  31 */     boolean notificationResult = false;
/*     */     
/*  33 */     String mailSubject = null;
/*  34 */     String fromMailId = null;
/*  35 */     String toMailId = null;
/*  36 */     String toMailIdEBS = null;
/*  37 */     Properties pro = new Properties();
/*  38 */     Map<Object, Object> faultMap = new HashMap<Object, Object>();
/*  39 */     String summary = null;
/*     */     
/*     */     try {
/*  42 */       String configFile = System.getenv("QFEQIF_CONFIG");
/*  43 */       pro.load(new FileInputStream(configFile));
/*  44 */       fromMailId = pro.getProperty("ausCheckFromMail");
/*  45 */       toMailId = pro.getProperty("ausCheckToMail");
/*  46 */       toMailIdEBS = pro.getProperty("ausCheckToMailEBS");
/*     */       
/*  48 */       System.out.println("****************Fault Metadata********************************");
/*  49 */       System.out.println("Fault policy id: " + iFaultRecoveryContext.getPolicyId());
/*     */       
/*  51 */       System.out.println("Fault type: " + iFaultRecoveryContext.getType());
/*     */       
/*  53 */       System.out.println("Partnerlink: " + iFaultRecoveryContext.getReferenceName());
/*     */       
/*  55 */       System.out.println("Port type: " + iFaultRecoveryContext.getPortType());
/*     */       
/*  57 */       System.out.println("**************************************************************");
/*     */       
/*  59 */       System.out.println("Properties Set for the Fault");
/*  60 */       Map props = iFaultRecoveryContext.getProperties();
/*  61 */       for (Object key : props.keySet()) {
/*  62 */         System.out.println("Key : " + key.toString() + " Value : " + props.get(key).toString());
/*     */       }
/*     */ 
/*     */       
/*  66 */       System.out.println("****************Fault Details********************************");
/*  67 */       if (iFaultRecoveryContext instanceof BPELFaultRecoveryContextImpl)
/*     */       {
/*  69 */         BPELFaultRecoveryContextImpl bpelCtx = (BPELFaultRecoveryContextImpl)iFaultRecoveryContext;
/*     */         
/*  71 */         System.out.println("Fault : " + bpelCtx.getFault());
/*  72 */         System.out.println("Activity: " + bpelCtx.getActivityName());
/*  73 */         System.out.println("Composite Instance: " + bpelCtx.getCompositeInstanceId());
/*     */         
/*  75 */         System.out.println("Composite Name: " + bpelCtx.getCompositeName());
/*     */ 
/*     */         
/*  78 */         System.out.println("FaultMessageBody From BPEL -- " + bpelCtx.getVariableData("FaultMessageBody"));
/*     */         
/*  80 */         System.out.println("FaultMessageSub From BPEL -- " + bpelCtx.getVariableData("FaultMessageSub"));
/*     */         
/*  82 */         System.out.println("AdminMailId From BPEL -- " + bpelCtx.getVariableData("AdminMailId"));
/*     */ 
/*     */ 
/*     */         
/*  86 */         faultMap = bpelCtx.getFault().getParts();
/*     */         
/*  88 */         System.out.println("FaultName  = " + bpelCtx.getFault().getFaultName().toString());
/*     */         
/*  90 */         System.out.println("Fault  getMessage = " + bpelCtx.getFault().getMessage().toString());
/*     */         
/*  92 */         System.out.println("Fault getMessageType = " + bpelCtx.getFault().getMessageType().toString());
/*     */         
/*  94 */         System.out.println("Fault getPart = " + bpelCtx.getFault().getPart("summary").toString());
/*     */         
/*  96 */         System.out.println("Fault StackTrace  = " + bpelCtx.getFault().getStackTrace().toString());
/*     */         
/*  98 */         System.out.println("Fault getParts  = " + bpelCtx.getFault().getParts().toString());
/*     */ 
/*     */ 
/*     */         
/* 102 */         faultMap = bpelCtx.getFault().getParts();
/*     */         
/* 104 */         for (Object faultMapKey : faultMap.keySet()) {
/* 105 */           if (faultMap.get(faultMapKey) instanceof XMLElement) {
/* 106 */             System.out.println(" FaultMap Key : " + faultMapKey.toString() + "    FaultMap Key Value :" + ((XMLElement)faultMap.get(faultMapKey)).getText());
/*     */ 
/*     */ 
/*     */             
/* 110 */             XMLElement value = (XMLElement)faultMap.get(faultMapKey);
/*     */ 
/*     */             
/* 113 */             if (faultMapKey.toString().equalsIgnoreCase("summary")) {
/* 114 */               summary = value.getText();
/* 115 */               System.out.println("---summary---" + summary);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 122 */         mailBody.append("\nHi Administrater\n");
/* 123 */         mailBody.append("\n\nPlease Find Fault Details For Composite : " + bpelCtx.getCompositeName());
/*     */         
/* 125 */         mailBody.append("\n\nComposite Instace : " + bpelCtx.getCompositeInstanceId());
/*     */         
/* 127 */         mailBody.append("\n\nError in Activity/Service " + bpelCtx.getActivityName());
/*     */         
/* 129 */         mailBody.append("\n\nFault Details : " + bpelCtx.getFault());
/* 130 */         mailBody.append("\n\nRegards");
/* 131 */         mailBody.append("\nQantas eQSOA Team");
/*     */ 
/*     */ 
/*     */         
/* 135 */         XMLElement inputXmlMailSub = (XMLElement)bpelCtx.getVariableData("FaultMessageSub");
/* 136 */         mailSubject = inputXmlMailSub.getText();
/*     */ 
/*     */         
/* 139 */         System.out.println("***********************************************************");
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 144 */     catch (Exception e) {
/* 145 */       e.printStackTrace();
/*     */     } finally {
/*     */       
/* 148 */       if (summary.equalsIgnoreCase("BEA-380001: Internal Server Error")) {
/*     */         
/* 150 */         notificationResult = MailSender.sendMail(toMailIdEBS, mailBody.toString(), mailSubject, fromMailId);
/*     */ 
/*     */         
/* 153 */         System.out.println("Mail Notification  Result is : " + notificationResult);
/*     */       }
/*     */       else {
/*     */         
/* 157 */         notificationResult = MailSender.sendMail(toMailId, mailBody.toString(), mailSubject, fromMailId);
/*     */ 
/*     */         
/* 160 */         System.out.println("Mail Notification  Result is : " + notificationResult);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     return "MANNUAL";
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\IdeserviceFaultHandler.jar!\com\idservice\fault\IDServiceFaultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */