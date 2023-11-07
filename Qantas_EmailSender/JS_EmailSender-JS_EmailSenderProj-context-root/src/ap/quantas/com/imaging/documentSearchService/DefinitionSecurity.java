/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.BaseSecurity;
/*    */ import ap.quantas.com.imaging.documentSearchService.DefinitionPermissions;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "DefinitionSecurity", propOrder = {"permissions"})
/*    */ public class DefinitionSecurity extends BaseSecurity {
/*    */   protected DefinitionPermissions permissions;
/*    */   
/*    */   public DefinitionPermissions getPermissions() {
/* 47 */     return this.permissions;
/*    */   }
/*    */   
/*    */   public void setPermissions(DefinitionPermissions value) {
/* 59 */     this.permissions = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\DefinitionSecurity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */