/*    */ package ap.quantas.com;
/*    */ 
/*    */ import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
/*    */ import ap.quantas.com.imaging.authentication.LoginService;
/*    */ import ap.quantas.com.imaging.authentication.LoginService_Service;
/*    */ import ap.quantas.com.imaging.documentUpdate.DocumentService;
/*    */ import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
/*    */ import ap.quantas.com.imaging.documentUpdate.FieldType;
/*    */ import ap.quantas.com.imaging.documentUpdate.FieldValue;
/*    */ import ap.quantas.com.imaging.documentUpdate.TypedValue;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.ws.BindingProvider;
/*    */ import javax.xml.ws.Holder;
/*    */ import javax.xml.ws.handler.Handler;
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
/*    */ public class TestImagingWS
/*    */ {
/*    */   public static void main(String[] args) {
/*    */     try {
/* 38 */       LoginService loginService = (new LoginService_Service()).getLoginServicePort();
/* 39 */       BindingProvider bindingProvider = (BindingProvider)loginService;
/*    */       
/* 41 */       List<Handler> handlerChain = new ArrayList<Handler>();
/* 42 */       handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PRD"));
/* 43 */       bindingProvider.getBinding().setHandlerChain(handlerChain);
/* 44 */       loginService.login();
/* 45 */       System.out.println("--login done--");
/* 46 */     } catch (Exception ex) {
/* 47 */       ex.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 52 */       DocumentService docUpdateService = (new DocumentService_Service()).getDocumentServicePort();
/*    */ 
/*    */       
/* 55 */       BindingProvider bindingProvider = (BindingProvider)docUpdateService;
/*    */       
/* 57 */       List<Handler> handlerChain = new ArrayList<Handler>();
/* 58 */       handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PRD"));
/* 59 */       bindingProvider.getBinding().setHandlerChain(handlerChain);
/*    */       
/* 61 */       String documentId = "9.IPM_008257";
/* 62 */       List<FieldValue> fieldValues = new ArrayList<FieldValue>();
/*    */ 
/*    */       
/* 65 */       FieldValue fieldValue1 = new FieldValue();
/* 66 */       fieldValue1.setName("Certifier Name");
/* 67 */       TypedValue typedValue1 = new TypedValue();
/* 68 */       typedValue1.setType(FieldType.TEXT);
/* 69 */       typedValue1.setValue("Krishnendu Das");
/* 70 */       fieldValue1.setValue(typedValue1);
/*    */       
/* 72 */       FieldValue fieldValue2 = new FieldValue();
/* 73 */       fieldValue2.setName("Username");
/* 74 */       TypedValue typedValue2 = new TypedValue();
/* 75 */       typedValue2.setType(FieldType.TEXT);
/* 76 */       typedValue2.setValue("330132");
/* 77 */       fieldValue2.setValue(typedValue2);
/*    */ 
/*    */       
/* 80 */       fieldValues.add(fieldValue1);
/* 81 */       fieldValues.add(fieldValue2);
/*    */       
/* 83 */       docUpdateService.updateDocument(new Holder<String>(documentId), null, fieldValues, false);
/*    */       
/* 85 */       System.out.println("--document updation done--");
/* 86 */     } catch (Exception ex) {
/* 87 */       ex.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\TestImagingWS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */