/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.DocumentSectionSet;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getDocuments", propOrder = {"arg0", "sectionSet"})
/*    */ public class GetDocuments {
/*    */   protected List<String> arg0;
/*    */   
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected DocumentSectionSet sectionSet;
/*    */   
/*    */   public List<String> getArg0() {
/* 66 */     if (this.arg0 == null)
/* 67 */       this.arg0 = new ArrayList<String>(); 
/* 69 */     return this.arg0;
/*    */   }
/*    */   
/*    */   public DocumentSectionSet getSectionSet() {
/* 81 */     return this.sectionSet;
/*    */   }
/*    */   
/*    */   public void setSectionSet(DocumentSectionSet value) {
/* 93 */     this.sectionSet = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\GetDocuments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */