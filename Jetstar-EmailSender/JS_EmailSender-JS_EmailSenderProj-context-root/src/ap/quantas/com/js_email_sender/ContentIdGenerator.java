/*    */ package ap.quantas.com.js_email_sender;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import java.net.UnknownHostException;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class ContentIdGenerator {
/* 10 */   static int seq = 0;
/*    */   
/*    */   static String hostname;
/*    */   
/*    */   static {
/*    */     try {
/* 15 */       hostname = InetAddress.getLocalHost().getCanonicalHostName();
/* 16 */     } catch (UnknownHostException e) {
/* 18 */       hostname = (new Random(System.currentTimeMillis())).nextInt(100000) + ".localhost";
/*    */     } 
/*    */   }
/*    */   
/*    */   public static synchronized int getSeq() {
/* 28 */     return seq++ % 100000;
/*    */   }
/*    */   
/*    */   public static String getContentId() {
/* 37 */     int c = getSeq();
/* 38 */     return c + "." + System.currentTimeMillis() + "@" + hostname;
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws InterruptedException {
/* 43 */     for (int i = 0; i < 5; i++) {
/* 44 */       for (int j = 0; j < 5; j++)
/* 45 */         System.out.println(getContentId()); 
/* 47 */       Thread.sleep(100L);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\js_email_sender\ContentIdGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */