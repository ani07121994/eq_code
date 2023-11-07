/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.NameId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "listTargetApplicationsResponse", propOrder = {"appNameIds"})
/*    */ public class ListTargetApplicationsResponse {
/*    */   protected List<NameId> appNameIds;
/*    */   
/*    */   public List<NameId> getAppNameIds() {
/* 61 */     if (this.appNameIds == null)
/* 62 */       this.appNameIds = new ArrayList<NameId>(); 
/* 64 */     return this.appNameIds;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ListTargetApplicationsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */