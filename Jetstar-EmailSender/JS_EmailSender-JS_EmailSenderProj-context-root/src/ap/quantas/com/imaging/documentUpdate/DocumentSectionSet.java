/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.DocumentSectionFlag;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "DocumentSectionSet", propOrder = {"flags"})
/*    */ public class DocumentSectionSet {
/*    */   @XmlElement(nillable = true)
/*    */   protected List<DocumentSectionFlag> flags;
/*    */   
/*    */   public List<DocumentSectionFlag> getFlags() {
/* 63 */     if (this.flags == null)
/* 64 */       this.flags = new ArrayList<DocumentSectionFlag>(); 
/* 66 */     return this.flags;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\DocumentSectionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */