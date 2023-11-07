/*    */ package oracle.bpel.services.workflow.assignment.dynamic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Test
/*    */ {
/*    */   public static String formattedDecimalNumber(double d) {
/*  9 */     String retStr = String.format("%.2f", new Object[] { Double.valueOf(d) });
/*    */     
/* 11 */     if (retStr.endsWith(".00"))
/*    */     {
/* 13 */       retStr = retStr.substring(0, retStr.length() - 3);
/*    */     }
/*    */     
/* 16 */     return retStr;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 21 */     double d = 1.2818204E7D;
/* 22 */     System.out.println(formattedDecimalNumber(1.2818204E7D));
/* 23 */     System.out.println(formattedDecimalNumber(1.281820434E7D));
/* 24 */     System.out.println(formattedDecimalNumber(1.2818204567E7D));
/* 25 */     System.out.println(formattedDecimalNumber(12818.204D));
/* 26 */     System.out.println(formattedDecimalNumber(12818.0D));
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\oracle\bpel\services\workflow\assignment\dynamic\Test.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */