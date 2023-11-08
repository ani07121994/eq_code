import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailNotification {
	public static Map<String, String> propMap1 =  Utility.getProperties();

	public  void sendMail(String file) {
			  
		System.out.println("Send Mail Started ");
		    String bodyText="";
			  Properties properties = System.getProperties();  
			  //properties.setProperty("mail.smtp.host", "172.27.42.7"); 
			  //properties.setProperty("mail.smtp.host", "172.27.45.4"); //sit 
			  properties.setProperty("mail.smtp.host", propMap1.get("SMTP_HOST")); //PSP
			  properties.setProperty("mail.smtp.port", propMap1.get("SMTP_PORT"));  
			  properties.put("mail.transport.protocol", propMap1.get("SMTP_PROTOCOL")); 
			  properties.put("mail.smtp.auth", propMap1.get("SMTP_AUTH")); 
			  properties.put("mail.smtp.starttls.enable", propMap1.get("SMTP_STARTLS_ENABLE"));
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				String date = simpleDateFormat.format(new Date());
				
				Session session = Session.getDefaultInstance(properties);
				Message msg = new MimeMessage(session);
				System. out. println("Current JVM version - " + System. getProperty("java.version"));

				try {
					msg.setFrom(new InternetAddress(propMap1.get("InternetAddress")));
					msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(propMap1.get("MAIL_RECEIVER_LIST")));
				    msg.setSubject("Employee_Report");
				    msg.setSentDate(new java.util.Date());
				    String tmp ="<p>Hi All,</p></br><p>Please find attached the today's Mismatch and Invalid Employee report for IDS and EQ.</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>";
				    System.out.println(tmp);
				    BodyPart messageBodyPart1 = new MimeBodyPart();  
				    messageBodyPart1.setContent(tmp, "text/html; charset=utf-8");; 
				    //messageBodyPart1.setText(tmp);
				    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

				   
				    //String filename = "C:/Users/eqtestowc/Desktop/Test Mail Chandra/EmployeeData_MissingRecords_EQ15-Dec-2022.xlsx";//change accordingly
				    String filename = file;
				    File tmpDir = new File(filename);
				    boolean exists = tmpDir.exists();
				    if(exists) {
				    	System.out.println("file attached");
				    	 DataSource source = new FileDataSource(filename);  
				    	 messageBodyPart2.setDataHandler(new DataHandler(source));
				    	 file = file.replace("/u03/app/oracle/Custom_Code/", "");
				    	 System.out.println("filename is"+file);
				    	 messageBodyPart2.setFileName(file);  
						    
				    }		    
				    Multipart multipart = new MimeMultipart(); 
				    multipart.addBodyPart(messageBodyPart1);
				    multipart.addBodyPart(messageBodyPart2);

				  //  msg.setContent(tmp, "text/html; charset=utf-8");
				    msg.setContent(multipart);
				     Transport.send(msg);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					//logger.error("Exception occured while sending email", e);
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					//.error("Exception occured while sending email", e);
					e.printStackTrace();
				}catch (Exception e) {
					System.out.println("error in sending mail");
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			   
			   System.out.println("mail sent successfully....");  
			   
		}
		
	}


