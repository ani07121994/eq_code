/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
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
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "listTargetApplicationsResponse", propOrder = {"appNameIds"})
/*    */ public class ListTargetApplicationsResponse
/*    */ {
/*    */   protected List<NameId> appNameIds;
/*    */   
/*    */   public List<NameId> getAppNameIds() {
/* 61 */     if (this.appNameIds == null) {
/* 62 */       this.appNameIds = new ArrayList<NameId>();
/*    */     }
/* 64 */     return this.appNameIds;
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\ListTargetApplicationsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */