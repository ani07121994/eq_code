/*    */ package src.com;
/*    */ 
/*    */ import javax.xml.bind.JAXBElement;
/*    */ import javax.xml.bind.annotation.XmlElementDecl;
/*    */ import javax.xml.bind.annotation.XmlRegistry;
/*    */ import javax.xml.namespace.QName;
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
/*    */ @XmlRegistry
/*    */ public class ObjectFactory
/*    */ {
/* 27 */   private static final QName _CommonNotificationDetails_QNAME = new QName("http://com.src/", "commonNotificationDetails");
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
/*    */   public CommonNotificationDetails createCommonNotificationDetails() {
/* 41 */     return new CommonNotificationDetails();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @XmlElementDecl(namespace = "http://com.src/", name = "commonNotificationDetails")
/*    */   public JAXBElement<CommonNotificationDetails> createCommonNotificationDetails(CommonNotificationDetails value) {
/* 50 */     return new JAXBElement<CommonNotificationDetails>(_CommonNotificationDetails_QNAME, CommonNotificationDetails.class, null, value);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\IdeserviceFaultHandler.jar!\src\com\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */