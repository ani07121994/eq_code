/*    */ package ap.quantas.com;
/*    */ 
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import javax.mail.internet.AddressException;
/*    */ import javax.mail.internet.InternetAddress;
/*    */ 
/*    */ public class TestMail {
/*    */   public static void main2(String... args) throws AddressException {
/* 31 */     String to2 = "1@tcs.com";
/* 33 */     InternetAddress[] toia2 = InternetAddress.parse(to2);
/* 34 */     for (InternetAddress address : toia2)
/* 35 */       address.validate(); 
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws ParseException {
/* 45 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 46 */     Date date1 = sdf.parse("2009-12-31");
/* 47 */     Date date2 = sdf.parse("2017-11-31");
/* 49 */     System.out.println("date1 : " + sdf.format(date1));
/* 50 */     System.out.println("date2 : " + sdf.format(date2));
/* 52 */     Calendar cal1 = Calendar.getInstance();
/* 53 */     Calendar cal2 = Calendar.getInstance();
/* 54 */     cal1.setTime(new Date());
/* 55 */     cal2.setTime(date2);
/* 56 */     System.out.println(cal1.compareTo(cal2));
/* 58 */     if (cal1.after(cal2))
/* 59 */       System.out.println("Date1 is after Date2"); 
/* 62 */     if (cal1.before(cal2))
/* 63 */       System.out.println("Date1 is before Date2"); 
/* 66 */     if (cal1.equals(cal2))
/* 67 */       System.out.println("Date1 is equal Date2"); 
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\TestMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */