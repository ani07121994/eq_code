/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.PageChange;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "modifyPageOrder", propOrder = {"documentId", "pageChanges"})
/*    */ public class ModifyPageOrder {
/*    */   protected String documentId;
/*    */   
/*    */   protected List<PageChange> pageChanges;
/*    */   
/*    */   public String getDocumentId() {
/* 50 */     return this.documentId;
/*    */   }
/*    */   
/*    */   public void setDocumentId(String value) {
/* 62 */     this.documentId = value;
/*    */   }
/*    */   
/*    */   public List<PageChange> getPageChanges() {
/* 88 */     if (this.pageChanges == null)
/* 89 */       this.pageChanges = new ArrayList<PageChange>(); 
/* 91 */     return this.pageChanges;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ModifyPageOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */