package qantas.integration.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class QFEQIFMailNotificationIOFilePoll {
	
	private static final Logger logger = QFEQIFLoggerIOFilePoll.getLogger(QFEQIFFileLockingUtilityIOFilePoll.class.getName());
	private Connection          conn;
	private ResultSet           rs;
	private PreparedStatement   ps;
	
	public boolean checkFileStuck(String filename, String time, String ifId) {
		logger.info("Inside checkFileStuck");
		Timestamp ts = null;
		try {
			conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
			ps   = conn.prepareStatement("SELECT POLL_DATE FROM QFEQIF_FTP_DETAIL_V1 WHERE FILE_NAME = ? AND CREATED_DATE = ? AND STATUS = 'WIP'");
			ps.setString(1, filename);
			ps.setString(2, time);
			rs   = ps.executeQuery();
			while (rs.next()){
				ts = rs.getTimestamp(1);
			}
			
			long ms = ts.getTime();
			long ms_current = (new Timestamp(System.currentTimeMillis())).getTime();
			logger.info("old time :" + ms + " and current time in timestamp " + ts.toString());
			logger.info("current time in ms:" + ms_current);
			long diff = ms_current - ms;
			long hours = diff / (60 * 60 * 1000);
			logger.info("Hours :" + hours);
			if(hours > 5)
			{
				mailNotification(filename , ifId);
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(null != rs){
					rs.close();
				}
				if(null != ps){
					ps.close();
				}
				if(null != conn){
					conn.close();
					QFEQIFDatabaseConnIOFilePoll.closeConnection();
				}
			}catch(Exception exception){
				logger.log(Level.WARNING, "Exception occured in getLock(String filename, String time, String ifId) method while closing the resources ");
	        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
		
		return false;
	}

	private void mailNotification(String filename, String ifId) {
		
		Properties mailProp = new Properties();
		
		Properties pro = getProperty();
        
		logger.info("mail.smtp.host.psp :" + pro.getProperty("mail.smtp.host.psp"));
		logger.info("mail.smtp.host :" + pro.getProperty("mail.smtp.host"));
		//logger.info("mail.smtp.host ip: 172.27.42.7");
		
		//mailProp.put("mail.smtp.auth", pro.getProperty("mail.smtp.auth"));
		mailProp.put("mail.smtp.port", pro.getProperty("mail.smtp.port"));
		//mailProp.put("mail.smtp.starttls.enable", pro.getProperty("mail.smtp.starttls.enable"));
		mailProp.put("mail.smtp.host", pro.getProperty("mail.smtp.host"));
		//mailProp.put("mail.smtp.host", "legacymail.qantas.com.au");
		mailProp.put("mail.transport.protocol", "smtp");

		logger.info("mailprop host value :" + mailProp.getProperty("mail.smtp.host"));
		
		Session session = Session.getDefaultInstance(mailProp);
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(pro.getProperty("mail.from.address")));
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(pro.getProperty("mail.receiver.list")));
		    msg.setSubject("File : " + filename + " Stuck in IFID : " + ifId);
		    msg.setSentDate(new java.util.Date());
		    msg.setContent("<p>Hi All,</p></br><p>File : " + filename + " Stuck in IFID : " + ifId +"</p></br><p>eQ OWC Support Team</p>", "text/html; charset=utf-8");
		        Transport.send(msg);
		    logger.info("Mail sent successfully ");    
		       
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured while sending mail ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
		}
		
	}

	private Properties getProperty() {
		
		String configFilePath = "";
        FileInputStream fis = null;
        Properties pro = new Properties();
		configFilePath = System.getenv("QFEQIF_CONFIG");
        try {
			fis = new FileInputStream(configFilePath);
			pro.load(fis);
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "Config File not found ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
		}catch(IOException e) {
        	logger.log(Level.WARNING, "Error reading IHub Config file ");
        	logger.log(Level.SEVERE, e.getMessage(), e);           
        }finally{
        	try{
        		if(null != fis){
            		fis.close();
            	}
        	}catch(Exception e){
        		logger.log(Level.WARNING, "Exception in readFromConfig() ");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        	
        }
		return pro;
	}

}
