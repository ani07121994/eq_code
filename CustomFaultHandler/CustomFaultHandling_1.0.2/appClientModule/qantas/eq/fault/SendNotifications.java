package qantas.eq.fault;


import com.oracle.bpel.client.BPELFault;

/*import email.notification.client.CommonNotification;
import email.notification.client.QantasCommonNotificationService;
*/
import src.com.*;
import java.util.HashMap;
import java.util.Properties;


public class SendNotifications {
    private static QantasCommonNotificationService qantasCommonNotificationService;
    public SendNotifications() {
        super();
    }

//    
    public static boolean sendMail(String finalUrl, BPELFault bpelFault,Properties prop,HashMap inputMap) 
    {
        boolean result=false;
       
        try 
        {
            System.out.println("Entering sendMail method of class SendNotifications");
            
            String toMail = prop.getProperty("toEmailAddr");//change accordingly
            
            String fromMail = prop.getProperty("fromEmailAddr");
            
            System.out.println("fromMail:::::::"+fromMail);
            
            String host = prop.getProperty("mailServerHost"); // IP address
            
            System.out.println("host:::::::"+host);
            
            String mailPort = prop.getProperty("mailServerPort");
            
            System.out.println("mailPort:::::::"+mailPort);
        
            prop.setProperty("mail.smtp.host", host);
            prop.setProperty("mail.smtp.port",mailPort);
//            ////        
//            Session session = Session.getDefaultInstance(prop);
//            session.setDebug(true);
        
        
            
            StringBuffer sbMailBody =  new StringBuffer();

            sbMailBody.append("Hi System Administrator,\n\n");
            sbMailBody.append("\n");
            sbMailBody.append("This is an autogenerated notification, please do not reply this email\n\n\n");
            sbMailBody.append("\n");
            sbMailBody.append(inputMap.get("_faultMessageBody"));
            
            sbMailBody.append("\n");
            sbMailBody.append("Error Details\n");
            sbMailBody.append("==============================================\n");
                        
            if(bpelFault != null)
            {
                System.out.println("BPEL fault:::::"+bpelFault.getMessage());
                sbMailBody.append(bpelFault.getMessage());
            }
            else
                sbMailBody.append("Test Message");
            
            sbMailBody.append("==============================================\n");
            sbMailBody.append("Click on the below URL\n");
            sbMailBody.append("-------------------------------------------------------\n");
            sbMailBody.append(finalUrl);
            sbMailBody.append("\n\n\n\n");
            sbMailBody.append("-------------------------------------------------------\n");
            sbMailBody.append("Regards\n");
            sbMailBody.append("Administrator");
            
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(fromMail));
//            message.addRecipient(Message.RecipientType.TO,new InternetAddress((String)inputMap.get("_adminMailId")));
            System.out.println("To Email ID in Notification class::::::"+(String)inputMap.get("_adminMailId"));
            
//            message.addRecipient(Message.RecipientType.TO,new InternetAddress("contact.debarshi@gmail.com"));
//            
            System.out.println("Subject:::"+(String)inputMap.get("_faultMessageSub"));
//            
//            message.setSubject((String)inputMap.get("_faultMessageSub"));
            //message.setSubject("Test Subject");     
//            message.setText(sbMailBody.toString());
            
            System.out.println("Before sending email:::::::::::::::::::::::::"+sbMailBody.toString());
            // Send message
            
            qantasCommonNotificationService = new QantasCommonNotificationService();
            CommonNotification commonNotification = qantasCommonNotificationService.getCommonNotificationPort();
            
            commonNotification.commonNotificationDetails("", (String)inputMap.get("_adminMailId"), sbMailBody.toString(), (String)inputMap.get("_faultMessageSub"), "", "", fromMail);
//            Transport.send(message);
            System.out.println("message sent successfully....");
            result=true;
            System.out.println("===================Done=in SendNotification======================================");
        } 

        catch (Exception e) 
        {
                result=false;
                e.printStackTrace();
                //throw new RuntimeException(e);
        }
        finally {
            
        }
        
        return result;
    }
    
    
//    public static void main(String args[]) 
//    {
//        try
//        {
//        sendMail(null,null,null,null);
//        }
//        catch(Exception ex) {
//            ex.printStackTrace();
//        }
//        
//    }
//    
    
    
    
}

