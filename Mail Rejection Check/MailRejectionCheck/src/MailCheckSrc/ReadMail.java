package MailCheckSrc;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.mail.*;
import javax.mail.search.FlagTerm;
public class ReadMail {

	public static HashMap<String,String> filePathList =  new HashMap<String, String>();
	public static SimpleDateFormat sdfformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static Calendar cal = Calendar.getInstance();
	public static String sysTime = sdfformat.format(cal.getTime());
	
	public static void loadProperties(){
		
		System.out.println("Inside : loadProperties executed at :"+sysTime);
		
		try{
			
			Properties prop = new Properties();
	        File file = new File("MAIL.properties");
	        FileInputStream fileInput = new FileInputStream(file);
	        
	        prop.load(fileInput);
	        
	        
	        filePathList.put("imap", prop.getProperty("IMAP"));
	        filePathList.put("password", prop.getProperty("OUTLOOKPWD"));
	        filePathList.put("userID", prop.getProperty("OUTLOOKUSER"));
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("End ::: loadProperties");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
