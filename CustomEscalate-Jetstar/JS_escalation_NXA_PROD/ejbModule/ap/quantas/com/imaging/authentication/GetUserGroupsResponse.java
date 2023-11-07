/*    */ package ap.quantas.com.imaging.authentication;
/*    */ 
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
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getUserGroupsResponse", propOrder = {"_return"})
/*    */ public class GetUserGroupsResponse
/*    */ {
/*    */   @XmlElement(name = "return")
/*    */   protected List<SecurityMember> _return;
/*    */   
/*    */   public List<SecurityMember> getReturn() {
/* 63 */     if (this._return == null) {
/* 64 */       this._return = new ArrayList<SecurityMember>();
/*    */     }
/* 66 */     return this._return;
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\authentication\GetUserGroupsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */