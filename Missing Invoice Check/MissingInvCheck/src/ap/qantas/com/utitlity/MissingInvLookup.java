package ap.qantas.com.utitlity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import ap.qantas.com.domain.InvoiceDetail;

public class MissingInvLookup {
	static final Logger logger = Logger.getLogger(MissingInvLookup.class);
	public static Map<String, String> propMap = null;
	public static final String DATA_FETCH_QUERY = "SELECT A.INVOICE_ID, A.INVOICE_NUMBER, B.INVOICE_NUMBER INV_NUM, TO_CHAR(A.MODIFIED_ON,'DD-MM-yyyy HH:MM:SS AM') MOD_BY ,COUNT(A.INVOICE_NUMBER) CNT "
			+ "FROM AP_INVOICE_OVERSEAS_TABLE A "
			+ "LEFT OUTER JOIN AP_INVOICE_TABLE B "
			+ "ON TRIM(A.INVOICE_NUMBER) = B.INVOICE_NUMBER "
			+ "WHERE A.INTERNAL_STATUS='SUBMITTED' AND "
			+ "A.MODIFIED_ON BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND "
			+ "TO_DATE(?, 'YYYY-MM-DD') "
			+ "GROUP BY A.INVOICE_ID, A.INVOICE_NUMBER,B.INVOICE_NUMBER,A.MODIFIED_ON "
			+ "ORDER BY A.INVOICE_NUMBER ";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		logger.debug("=============Starting Missing Invoice ("+dateFormat.format(cal.getTime())+") ==============");
		propMap = getProperties();

		/*System.out.println("Today's date is "
				+ dateFormat.format(cal.getTime()));*/
		
		logger.debug("Today's date is :::: "+ dateFormat.format(cal.getTime()));

		cal.add(Calendar.DATE, -1);
		String fromDt = dateFormat.format(cal.getTime());
		/*System.out.println("From Date is  "
				+ dateFormat.format(cal.getTime()));*/
		logger.debug("From date is ::::"+ dateFormat.format(cal.getTime()));
		cal2.add(Calendar.DATE, 0);

		String toDt = dateFormat.format(cal2.getTime());
		/*System.out.println("To Date is "
				+ dateFormat.format(cal2.getTime()));*/
		logger.debug("To Date is :::: "+ dateFormat.format(cal2.getTime()));
		List<InvoiceDetail> missingInvList = getMissingInvoiceLst(fromDt, toDt);

		if (missingInvList != null && missingInvList.size() > 0) {
			/*System.out
					.println(" Needs to trigger Mail for missing invoice list size "
							+ missingInvList.size());*/
			logger.debug("Needs to trigger Mail for missing invoice list size :::: "+ missingInvList.size());
			for (int i = 0; i < missingInvList.size(); i++) {
				/*System.out.println("missing Invoice Number "
						+ missingInvList.get(i).getInvoiceNo()+" Missing Invoice Submitted Date "+missingInvList.get(i).getModifiedOn());*/
				logger.debug("Missing Invoice Number  :::: "
						+ missingInvList.get(i).getInvoiceNo()+" Missing Invoice Submitted Date :::: "+missingInvList.get(i).getModifiedOn());
			}
			sendMail(missingInvList);
		}else{
			//System.out.println(" No Missing Invoice for Today");
			logger.debug(" :::: No Missing Invoice for Today ::::");
		}
		
		logger.debug("============= End of  Missing Invoice ===============\n");

	}

	public static Map<String, String> getProperties() {
		Map<String, String> propMap = new HashMap<String, String>();
		try {
			//Class cls = Class.forName("MissingInvLookup");

	         // returns the ClassLoader object associated with this Class
	       //  ClassLoader cLoader = cls.getClassLoader();
	        // String rsc="//src//config.properties";
	         // input stream
	        // InputStream i = cLoader.getResourceAsStream(rsc);
			//InputStream is = Props.class.getResourceAsStream("/src/config/admin.properties");
	         InputStream reader = MissingInvLookup.class
				.getClassLoader().getResourceAsStream("config.properties");
			//FileReader reader = new FileReader("/src//config.properties");
			Properties p = new Properties();
			p.load(reader);
			//p.load(i);
			Set set = p.entrySet();

			Iterator itr = set.iterator();
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				propMap.put(entry.getKey().toString(), entry.getValue()
						.toString());
				//System.out.println(entry.getKey() + " = " + entry.getValue());
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			logger.error(" Exception Occured in getProperties method ",e1);
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(" Exception Occured in getProperties method ",e);
			e.printStackTrace();
		}
		return propMap;
	}

	public static List<InvoiceDetail> getMissingInvoiceLst(String fromDt,
			String toDate) {

		DatabaseUtility dbUtil = new DatabaseUtility();

		List<InvoiceDetail> missingInvList = new ArrayList<InvoiceDetail>();

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Map<String, String> dbParams = new HashMap<String, String>();
		
		String env = propMap.get("ENV");
		
		if (env != null) {
			dbParams.put("HOST", propMap.get("HOST_" + env));
			dbParams.put("USER", propMap.get("USER_" + env));
			dbParams.put("PASSWORD", propMap.get("PASSWORD_" + env));
		}
		// System.out.println(" ::: " + propMap.get("HOST"));

		con = dbUtil.getConnection(dbParams);
		try {
			ps = con.prepareStatement(DATA_FETCH_QUERY);

			ps.setString(1, fromDt);
			ps.setString(2, toDate);
			logger.debug(" getMissingInvoiceLst :: fromDt " + fromDt + " toDate " + toDate);
			//System.out.println(" fromDt " + fromDt + " toDate " + toDate);
			//System.out.println(" \nDATA_FETCH_QUERY \n" + DATA_FETCH_QUERY);
			rs = ps.executeQuery();
			String invNum = null;
			String invNumber = null;
			int counter=0;
			while (rs.next()) {
				counter++;
				InvoiceDetail invDtl = new InvoiceDetail();

				invNum = rs.getString("INV_NUM");
				invNumber = rs.getString("INVOICE_NUMBER");

				if (invNumber != null && invNum == null) {

					invDtl.setInvoiceId(rs.getString("INVOICE_ID"));
					invDtl.setInvoiceNo(invNumber);
					invDtl.setModifiedOn(rs.getString("MOD_BY"));
					invDtl.setCount(rs.getInt("CNT"));
					invDtl.setFrmDt(fromDt);
					invDtl.setToDt(toDate);
					missingInvList.add(invDtl);
				}

				/*System.out.println(" ******************** The Submitted List ***********");
				System.out.println("Overseas INVOICE_ID :::: "
						+ rs.getString("INVOICE_ID"));
				System.out.println("Overseas Invoice Number :::: "
						+ rs.getString("INVOICE_NUMBER"));
				System.out.println("BPM Invoice Number :::: "
						+ rs.getString("INV_NUM"));
				System.out.println("Invoice Submitted Date from Overseas :::: "
						+ rs.getString("MOD_BY"));
				System.out.println("Invoice Count :::: "
						+ rs.getInt("CNT"));*/
				
				invNum = null;
				invNumber = null;
			}
			
			/*System.out.println("Total Number of Submitted Invoice from OWC :::: "
					+ counter);*/
			logger.debug("Total Number of Submitted Invoice from OWC :::: "
					+ counter);
			
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
				//e.printStackTrace();
				
			}
		}

		return missingInvList;
	}
	
	public static void sendMail(List<InvoiceDetail> missingInvList){
		
		//System.out.println("Send Mail Started ");
		String bodyText="";
		for(int i=0;i<missingInvList.size();i++){
			bodyText=bodyText+"<p>"+missingInvList.get(i).getInvoiceNo()+"</p>";
		}
		logger.debug(":::: bodyText :::: "+bodyText);
		logger.debug(":::: Send Mail Started :::: ");
		Properties mailProp = new Properties();
		mailProp.put("mail.smtp.auth", propMap.get("mail.smtp.auth"));
		mailProp.put("mail.smtp.port", propMap.get("mail.smtp.port"));
		mailProp.put("mail.smtp.starttls.enable", propMap.get("mail.smtp.starttls.enable"));
		mailProp.put("mail.smtp.host", propMap.get("mail.smtp.host"));
		mailProp.put("mail.transport.protocol", propMap.get("mail.transport.protocol"));
		
		String env = propMap.get("ENV");
		
		
		Session session = Session.getDefaultInstance(mailProp);
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(propMap.get("mail.from.address")));
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(propMap.get("mail.receiver.list")));
		    msg.setSubject(propMap.get("mail.subject.line"));
		    msg.setSentDate(new java.util.Date());
		    String tmp ="<p>Hi All,</p></br><p>Total Number of Missing Invoices in "+env+" for the period "+missingInvList.get(0).getFrmDt()+" to "+missingInvList.get(0).getToDt()+" : " +missingInvList.size()+ "</p></br><p>Please find below the missing Invoice Number </p>"+bodyText+"</br><p>Kindly check logs for error occurred.</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>";
		    System.out.println(tmp);
		    msg.setContent("<p>Hi All,</p></br><p>Total Number of Missing Invoices in "+env+" for the period "+missingInvList.get(0).getFrmDt()+" to "+missingInvList.get(0).getToDt()+" : " +missingInvList.size()+ "</p></br><p>Please find below the missing Invoice Number </p>"+bodyText+"</br><p>Kindly check logs for error occurred.</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>", "text/html; charset=utf-8");
		        Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			logger.error("Exception occured while sending email", e);
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			logger.error("Exception occured while sending email", e);
			e.printStackTrace();
		}
	
       
        
       
		
	}

}
