/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.SectionFlag;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "SectionSet", propOrder = {"flags"})
/*    */ public class SectionSet
/*    */ {
/*    */   @XmlElement(nillable = true)
/*    */   protected List<SectionFlag> flags;
/*    */   
/*    */   public List<SectionFlag> getFlags() {
/* 63 */     if (this.flags == null) {
/* 64 */       this.flags = new ArrayList<SectionFlag>();
/*    */     }
/* 66 */     return this.flags;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SectionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */