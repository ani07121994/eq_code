import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class New {
	
	private static String url_11g;
	private static String uname_11g;
	private static String pass_11g;
	private static Connection con_11g;
	private static String query_11g_id;
	
    
    //String batch_id;
    //String invoice_no;
    
	//private static String url_12c = "jdbc:oracle:thin:@//eqtest-owc-db1.qantas.com.au:16010/TESTOWC"; //-- for 12c psp
	//private static String uname_12c = "owcview12c"; // 12c psp
	//private static String pass_12c = "owcview"; // 12c psp
	
	private static String url_12c = "jdbc:oracle:thin:@eqprod-owc-db1.qantas.com.au:16010:PRODOWC"; //12c PROD
	private static String uname_12c = "OWCPRDVIEW12C";  //12c PROD
	private static String pass_12c = "owcview"; //12c PROD
	private static Connection con_12c;
	//private static String query1_12c = "select a.*, b.ddocname from  OWCPSP12C_OCS.docmeta a,OWCPSP12C_OCS.revisions b where b.did=a.did and b.ddocname = ?"; // 12c psp
	private static String query1_12c = "select a.*, b.ddocname from  OWCPRD12C_OCS.docmeta a,OWCPRD12C_OCS.revisions b where b.did=a.did and b.ddocname = ?"; //12c PROD
	//private static String query2_12c = "select * from OWCPSP12C_OCS.docmeta where XIPM_APP_1_11 = ?";
	//PrintStream p = new PrintStream(new File("C:\\log_file\\log_details.txt"));

	
	
	public void getId()
	{
		//System.out.println("Entering into getId");
		
		//url_11g = "jdbc:oracle:thin:@eqtest-owc-db1.qantas.com.au:16010/TESTOWC"; // 11g psp
		//uname_11g = "owcview"; // 11g psp
		//pass_11g = "owcview123"; // 11g psp
		/*query_11g_id= "select a.*, b.ddocname from  TEST_OCS.docmeta a,TEST_OCS.revisions b where b.did=a.did and b.dindate between '01-JAN-2018' and '01-JAN-2019'\r\n" + 
				"and b. dindate is not null"; // 11g psp */		
		url_11g = "jdbc:oracle:thin:@eqprod-owc-db1.qantas.com.au:16010:PRODOWC";
		uname_11g = "owcview";
		pass_11g = "owcview123";
		query_11g_id = "select a.*, b.ddocname from  PROD_OCS.docmeta a,PROD_OCS.revisions b where b.did=a.did and a.XIPM_APP_1_11 is not null AND b.dindate between '16-MAY-2018' and '24-MAY-2018'\r\n" + 
				"and b. dindate is not null";
		
		
		try
		{	
			PrintStream p = new PrintStream(new File("C:\\log_file\\log_details.txt"));
			p.println("Start time : " +LocalDateTime.now());
			int count = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con_11g = DriverManager.getConnection(url_11g,uname_11g,pass_11g);
			PreparedStatement ps = con_11g.prepareStatement(query_11g_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				count ++;
				//System.out.println("Count is :" + count);
				p.println("Count is :" + count);
				//String source = rs.getString("XIPM_APP_1_32");
				//System.out.println("source: " + ipm_id);
				String ipm_id = rs.getString("ddocname");
				p.println("ipm id : " + ipm_id);
				
				//if(rs.getString("XIPM_APP_1_32")!= null) {
							/*if(rs.getString("XIPM_APP_1_32").contains("P2P INVOICE") || rs.getString("XIPM_APP_1_32").contains("INVOICE TEMPLATE QF") ||
						   rs.getString("XIPM_APP_1_32").contains("JETSTAR INVOICE"))
						{ */	
							//batch_id = rs.getString("XIPM_APP_1_19");
							//System.out.println("Batch id:" + batch_id);
							//p.println("Batch id:" + batch_id);
							try {
								boolean emptyResultsSet1 = true;
								Class.forName("com.mysql.cj.jdbc.Driver");
								con_12c = DriverManager.getConnection(url_12c,uname_12c,pass_12c);
								//System.out.println("con_12c: " + con_12c.toString() );
								PreparedStatement ps1 = con_12c.prepareStatement(query1_12c);
								//ipm_id = ipm_id + "LEGACY"; // legacy
								ps1.setString(1,ipm_id);
								ResultSet rs1 = ps1.executeQuery();
								
								
								while (rs1.next())
								{	
									//boolean isNotMatched = false; // legacy
									//System.out.println("for 12C");
									emptyResultsSet1 = false;
									
									if( rs.getString("XIPM_APP_1_0") != null ) {
										if( rs.getString("XIPM_APP_1_0").equals(rs1.getString("XIPM_APP_1_0")))
										{
											//System.out.println("Username is same for :" + batch_id);
										}
										else
										{
											//System.out.println("Username is not same for batch id :" + batch_id);
											p.println("Username is not same for :" + ipm_id);
											//isNotMatched = true;
										}
									}else {
										if(rs1.getString("XIPM_APP_1_0") !=null) {
											//System.out.println("Username is not same for batch id :" + ipm_id);
											p.println("Username is not same for :" + ipm_id);
											//isNotMatched = true;
											
										}
									}
									
									if( rs.getString("XIPM_APP_1_1") != null ) {
										if( rs.getString("XIPM_APP_1_1").equals(rs1.getString("XIPM_APP_1_1")))
										{
											//System.out.println("Activity is same for :" + ipm_id);
										}
										else
										{
											//System.out.println("Activity is not same for batch id :" + ipm_id);
											p.println("Activity is not same for :" + ipm_id);
											//isNotMatched = true;
										}
									}else {
										if(rs1.getString("XIPM_APP_1_1") !=null) {
											//System.out.println("Activity is not same for batch id :" + ipm_id);
											p.println("Activity is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_2") != null ) {
										if( rs.getString("XIPM_APP_1_2").equals(rs1.getString("XIPM_APP_1_2")))
										{
											//System.out.println("Document Type is same for :" + ipm_id);
										}
										else
										{
											//System.out.println("Document Type is not same for batch id:" + ipm_id);
											p.println("Document Type is not same for :" + ipm_id);
											//isNotMatched = true;
										}
									}else {
										if(rs1.getString("XIPM_APP_1_2") !=null) {
											//System.out.println("Document Type is not same for batch id :" + ipm_id);
											p.println("Document Type is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_3") != null ) {
										if( rs.getString("XIPM_APP_1_3").equals(rs1.getString("XIPM_APP_1_3")))
										{
											//System.out.println("Invoice Type is same for :" + ipm_id);
										}
										else
										{
											//System.out.println("Invoice Type is not same for batch id :" + ipm_id);
											p.println("Invoice Type is not same for :" + ipm_id);
											//isNotMatched = true;
										}
									}else {
										if(rs1.getString("XIPM_APP_1_3") !=null) {
											//System.out.println("Invoice Type is not same for batch id :" + ipm_id);
											p.println("Invoice Type is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_4") != null ) {
										if( rs.getString("XIPM_APP_1_4").equals(rs1.getString("XIPM_APP_1_4")))
										{
											//System.out.println("OrgID is same for :" + ipm_id);
										}
										else
										{
											//System.out.println("OrgID is not same for batch id :" + ipm_id);
											p.println("OrgID is not same for :" + ipm_id);
											//isNotMatched = true;
										}
									}else {
										if(rs1.getString("XIPM_APP_1_4") !=null) {
											//System.out.println("OrgID is not same for batch id :" + ipm_id);
											p.println("OrgID is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_5") != null ) {
										if( rs.getString("XIPM_APP_1_5").equals(rs1.getString("XIPM_APP_1_5")))
											{
												//System.out.println("PO Number is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("PO Number is not same for :" + ipm_id);
												p.println("PO Number is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_5") !=null) {
											//System.out.println("PO Number is not same for batch id :" + ipm_id);
											p.println("PO Number is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_6") != null ) {
										if( rs.getString("XIPM_APP_1_6").equals(rs1.getString("XIPM_APP_1_6")))
											{
												//System.out.println("Currency is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Currency is not same for :" + ipm_id);
												p.println("Currency is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_6") !=null) {
											//System.out.println("Currency is not same for batch id :" + ipm_id);
											p.println("Currency is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_7") != null ) {
										if( rs.getString("XIPM_APP_1_7").equals(rs1.getString("XIPM_APP_1_7")))
											{
												//System.out.println("Certifier Name is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Certifier Name is not same for batch id :" + ipm_id);
												p.println("Certifier Name is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_7") !=null) {
											//System.out.println("Certifier Name is not same for batch id :" + ipm_id);
											p.println("Certifier Name is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_8") != null ) {
										if( rs.getString("XIPM_APP_1_8").equals(rs1.getString("XIPM_APP_1_8")))
											{
												//System.out.println("Supplier ID is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Supplier ID is not same for batch id :" + ipm_id);
												p.println("Supplier ID is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_8") !=null) {
											//System.out.println("Supplier ID is not same for batch id :" + ipm_id);
											p.println("Supplier ID is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_9") != null ) {
										if( rs.getString("XIPM_APP_1_9").equals(rs1.getString("XIPM_APP_1_9")))
											{
												//System.out.println("Supplier Name is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Supplier Name is not same for batch id :" + ipm_id);
												p.println("Supplier Name is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_9") !=null) {
											//System.out.println("Supplier Name is not same for batch id :" + ipm_id);
											p.println("Supplier Name is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_10") != null ) {
										if( rs.getString("XIPM_APP_1_10").equals(rs1.getString("XIPM_APP_1_10")))
											{
												//System.out.println("Site ID is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Site ID is not same for batch id :" + ipm_id);
												p.println("Site ID is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_10") !=null) {
											//System.out.println("Site ID is not same for batch id :" + ipm_id);
											p.println("Site ID is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_11") != null ) {
										if( rs.getString("XIPM_APP_1_11").equals(rs1.getString("XIPM_APP_1_11")))
											{
												//System.out.println("Invoice Number is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Invoice Number is not same for batch id :" + ipm_id);
												p.println("Invoice Number is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_11") !=null) {
											//System.out.println("Invoice Number is not same for batch id :" + ipm_id);
											p.println("Invoice Number is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_12") != null ) {
										if( rs.getString("XIPM_APP_1_12").equals(rs1.getString("XIPM_APP_1_12")))
											{
												//System.out.println("Invoice Total is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Invoice Total is not same for batch id :" + ipm_id);
												p.println("Invoice Total is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_12") !=null) {
											//System.out.println("Invoice Total is not same for batch id :" + ipm_id);
											p.println("Invoice Total is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_13") != null ) {
										if( rs.getString("XIPM_APP_1_13").equals(rs1.getString("XIPM_APP_1_13")))
											{
												//System.out.println("Invoice Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Invoice Date is not same for batch id :" + ipm_id);
												p.println("Invoice Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_13") !=null) {
											//System.out.println("Invoice Date is not same for batch id :" + ipm_id);
											p.println("Invoice Date is not same for :" + ipm_id);
											//isNotMatched = true;
										

										}
									}
									
									if( rs.getString("XIPM_APP_1_14") != null ) {
										if( rs.getString("XIPM_APP_1_14").equals(rs1.getString("XIPM_APP_1_14")))
											{
												//System.out.println("Priority is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Priority is not same for batch id :" + ipm_id);
												p.println("Priority is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_14") !=null) {
											//System.out.println("Priority is not same for batch id :" + ipm_id);
											p.println("Priority is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_15") != null ) {
										if( rs.getString("XIPM_APP_1_15").equals(rs1.getString("XIPM_APP_1_15")))
											{
												//System.out.println("Invalid Reason Code is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Invalid Reason Code is not same for batch id :" + ipm_id);
												p.println("Invalid Reason Code is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_15") !=null) {
											//System.out.println("Invalid Reason Code is not same for batch id :" + ipm_id);
											p.println("Invalid Reason Code is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_16") != null ) {
										if( rs.getString("XIPM_APP_1_16").equals(rs1.getString("XIPM_APP_1_16")))
											{
												//System.out.println("Invalid Reason is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Invalid Reason is not same for batch id :" + ipm_id);
												p.println("Invalid Reason is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_16") !=null) {
											//System.out.println("Invalid Reason is not same for batch id :" + ipm_id);
											p.println("Invalid Reason is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_17") != null ) {
										if( rs.getString("XIPM_APP_1_17").equals(rs1.getString("XIPM_APP_1_17")))
											{
												//System.out.println("Scan Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Scan Date is not same for batch id :" + ipm_id);
												p.println("Scan Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_17") !=null) {
											//System.out.println("Scan Date is not same for batch id :" + ipm_id);
											p.println("Scan Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_18") != null ) {
										if( rs.getString("XIPM_APP_1_18").equals(rs1.getString("XIPM_APP_1_18")))
											{
												//System.out.println("Supplier Number is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Supplier Number is not same for :" + ipm_id);
												p.println("Supplier Number is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_18") !=null) {
											//System.out.println("Supplier Number is not same for batch id :" + ipm_id);
											p.println("Supplier Number is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_19") != null ) {
										if( rs.getString("XIPM_APP_1_19").equals(rs1.getString("XIPM_APP_1_19")))
											{
												//System.out.println("Capture Batch ID is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Capture Batch ID is not same for batch id :" + ipm_id);
												p.println("Capture Batch ID is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_19") !=null) {
											//System.out.println("Capture Batch ID is not same for batch id :" + ipm_id);
											p.println("Capture Batch ID is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_20") != null ) {
										if( rs.getString("XIPM_APP_1_20").equals(rs1.getString("XIPM_APP_1_20")))
											{
												//System.out.println("Document Last Update Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Document Last Update Date is not same for batch id :" + ipm_id);
												p.println("Document Last Update Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_20") !=null) {
											//System.out.println("Document Last Update Date is not same for batch id :" + ipm_id);
											p.println("Document Last Update Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_21") != null ) {
										if( rs.getString("XIPM_APP_1_21").equals(rs1.getString("XIPM_APP_1_21")))
											{
												//System.out.println("Document History is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Document History is not same for batch id :" + ipm_id);
												p.println("Document History is not same for :" + ipm_id);
												//isNotMatched = true;
											
											}
									}else {
										if(rs1.getString("XIPM_APP_1_21") !=null) {
											//System.out.println("Document History is not same for batch id :" + ipm_id);
											p.println("Document History is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_23") != null ) {
										if( rs.getString("XIPM_APP_1_23").equals(rs1.getString("XIPM_APP_1_22")))
											{
												//System.out.println("Due Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Due Date is not same for batch id :" + ipm_id);
												p.println("Due Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_22") !=null) {
											//System.out.println("Due Date is not same for batch id :" + ipm_id);
											p.println("Due Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_24") != null ) {
										if( rs.getString("XIPM_APP_1_24").equals(rs1.getString("XIPM_APP_1_23")))
											{
												//System.out.println("Approvar Name is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Approvar Name is not same for batch id :" + ipm_id);
												p.println("Approvar Name is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_23") !=null) {
											//System.out.println("Approvar Name is not same for :" + ipm_id);
											p.println("Approvar Name is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_25") != null ) {
										if( rs.getString("XIPM_APP_1_25").equals(rs1.getString("XIPM_APP_1_24")))
											{
												//System.out.println("Payment Number is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Payment Number is not same for batch id :" + ipm_id);
												p.println("Payment Number is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_24") !=null) {
											//System.out.println("Payment Number is not same for batch id :" + ipm_id);
											p.println("Payment Number is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_26") != null ) {
										if( rs.getString("XIPM_APP_1_26").equals(rs1.getString("XIPM_APP_1_25")))
											{
												//System.out.println("Payment Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Payment Date is not same for batch id :" + ipm_id);
												p.println("Payment Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_25") !=null) {
											//System.out.println("Payment Date is not same for batch id :" + ipm_id);
											p.println("Payment Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_27") != null ) {
										if( rs.getString("XIPM_APP_1_27").equals(rs1.getString("XIPM_APP_1_26")))
											{
												//System.out.println("Internal Status is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Internal Status is not same for batch id :" + ipm_id);
												p.println("Internal Status is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_26") !=null) {
											//System.out.println("Internal Status is not same for batch id :" + ipm_id);
											p.println("Internal Status is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_28") != null ) {
										if( rs.getString("XIPM_APP_1_28").equals(rs1.getString("XIPM_APP_1_27")))
											{
												//System.out.println("Last Update Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Last Update Date is not same for batch id :" + ipm_id);
												p.println("Last Update Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_27") !=null) {
											//System.out.println("Last Update Date is not same for batch id :" + ipm_id);
											p.println("Last Update Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_29") != null ) {
										if( rs.getString("XIPM_APP_1_29").equals(rs1.getString("XIPM_APP_1_28")))
											{
												//System.out.println("Certification Pending Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Certification Pending Date is not same for batch id :" + ipm_id);
												p.println("Certification Pending Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_28") !=null) {
											//System.out.println("Certification Pending Date is not same for batch id :" + ipm_id);
											p.println("Certification Pending Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_30") != null ) {
										if( rs.getString("XIPM_APP_1_30").equals(rs1.getString("XIPM_APP_1_29")))
											{
												//System.out.println("eQ Interface Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("eQ Interface Date is not same for batch id :" + ipm_id);
												p.println("eQ Interface Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_29") !=null) {
											//System.out.println("eQ Interface Date is not same for batch id :" + ipm_id);
											p.println("eQ Interface Date is not same for :" + ipm_id);
											//isNotMatched = true;
											
										}
									}
									
									if( rs.getString("XIPM_APP_1_31") != null ) {
										if( rs.getString("XIPM_APP_1_31").equals(rs1.getString("XIPM_APP_1_30")))
											{
												//System.out.println("AP Username is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("AP Username is not same for batch id :" + ipm_id);
												p.println("AP Username is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_30") !=null) {
											//System.out.println("AP Username is not same for batch id :" + ipm_id);
											p.println("AP Username is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_32") != null ) {
										if( rs.getString("XIPM_APP_1_32").equals(rs1.getString("XIPM_APP_1_31")))
											{
												//System.out.println("Source is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Source is not same for batch id :" + ipm_id);
												p.println("Source is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_31") !=null) {
											//System.out.println("Source is not same for batch id :" + ipm_id);
											p.println("Source is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_33") != null ) {
										if( rs.getString("XIPM_APP_1_33").equals(rs1.getString("XIPM_APP_1_32")))
											{
												//System.out.println("Operating Unit Name is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Operating Unit Name is not same for batch id :" + ipm_id);
												p.println("Operating Unit Name is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_32") !=null) {
											//System.out.println("Operating Unit Name is not same for batch id :" + ipm_id);
											p.println("Operating Unit Name is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_34") != null ) {
										if( rs.getString("XIPM_APP_1_34").equals(rs1.getString("XIPM_APP_1_33")))
											{
												//System.out.println("Freight is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Freight is not same for batch id :" + ipm_id);
												p.println("Freight is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_33") !=null) {
											//System.out.println("Freight is not same for batch id :" + ipm_id);
											p.println("Freight is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_35") != null ) {
										if( rs.getString("XIPM_APP_1_35").equals(rs1.getString("XIPM_APP_1_34")))
											{
												//System.out.println("AOG is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("AOG is not same for batch id :" + ipm_id);
												p.println("AOG is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_34") !=null) {
											//System.out.println("AOG is not same for batch id :" + ipm_id);
											p.println("AOG is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_36") != null ) {
										if( rs.getString("XIPM_APP_1_36").equals(rs1.getString("XIPM_APP_1_35")))
											{
												//System.out.println("Currency Equivalent is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Currency Equivalent is not same for batch id :" + ipm_id);
												p.println("Currency Equivalent is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_35") !=null) {
											//System.out.println("Currency Equivalent is not same for batch id :" + ipm_id);
											p.println("Currency Equivalent is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_37") != null ) {
										if( rs.getString("XIPM_APP_1_37").equals(rs1.getString("XIPM_APP_1_36")))
											{
												//System.out.println("WHT Amount is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("WHT Amount is not same for batch id :" + ipm_id);
												p.println("WHT Amount is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_36") !=null) {
											//System.out.println("WHT Amount is not same for batch id :" + ipm_id);
											p.println("WHT Amount is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_38") != null ) {
										if( rs.getString("XIPM_APP_1_38").equals(rs1.getString("XIPM_APP_1_37")))
											{
												//System.out.println("InvoiceFileName is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("InvoiceFileName is not same for batch id :" + ipm_id);
												p.println("SupplierEmailID is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_37") !=null) {
											//System.out.println("InvoiceFileName is not same for batch id :" + ipm_id);
											p.println("SupplierEmailID is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_39") != null ) {
										if( rs.getString("XIPM_APP_1_39").equals(rs1.getString("XIPM_APP_1_38")))
											{
											//	System.out.println("SupplierEmailID is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("SupplierEmailID is not same for batch id :" + ipm_id);
												p.println("InvoiceFileName is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_38") !=null) {
											//System.out.println("SupplierEmailID is not same for batch id :" + ipm_id);
											p.println("InvoiceFileName is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}  
									
									// change here
									
									if( rs.getString("XIPM_APP_1_40") != null ) {
										if( rs.getString("XIPM_APP_1_40").equals(rs1.getString("XIPM_APP_1_39")))
											{
												//System.out.println("Audit History is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Audit History is not same for batch id :" + ipm_id);
												p.println("Reason Type is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_39") !=null) {
											//System.out.println("Audit History is not same for batch id :" + ipm_id);
											p.println("Reason Type is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_41") != null ) {
										if( rs.getString("XIPM_APP_1_41").equals(rs1.getString("XIPM_APP_1_40")))
											{
												//System.out.println("Reason Type is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Reason Type is not same for batch id :" + ipm_id);
												p.println("WFR UserName is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_40") !=null) {
											//System.out.println("Reason Type is not same for batch id :" + ipm_id);
											p.println("WFR UserName is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_42") != null ) {
										if( rs.getString("XIPM_APP_1_42").equals(rs1.getString("XIPM_APP_1_41")))
											{
												//System.out.println("WFR UserName is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("WFR UserName is not same for batch id :" + ipm_id);
												p.println("Tax Registration Number is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_41") !=null) {
											//System.out.println("WFR UserName is not same for batch id :" + ipm_id);
											p.println("Tax Registration Number is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_43") != null ) {
										if( rs.getString("XIPM_APP_1_43").equals(rs1.getString("XIPM_APP_1_42")))
											{
												//System.out.println("Tax Registration Number is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Tax Registration Number is not same for batch id :" + ipm_id);
												p.println("BPM Comment is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_42") !=null) {
											//System.out.println("Tax Registration Number is not same for batch id :" + ipm_id);
											p.println("BPM Comment is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_47") != null ) {
										if( rs.getString("XIPM_APP_1_47").equals(rs1.getString("XIPM_APP_1_46")))
											{
												//System.out.println("BPM Comment is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("BPM Comment is not same for batch id :" + ipm_id);
												p.println("Additional field15 is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_46") !=null) {
											//System.out.println("BPM Comment is not same for batch id :" + ipm_id);
											p.println("Additional field15 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_44") != null ) {
										if( rs.getString("XIPM_APP_1_44").equals(rs1.getString("XIPM_APP_1_43")))
											{
												//System.out.println("Certifier Comment is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Certifier Comment is not same for batch id :" + ipm_id);
												p.println("Certifier Comment is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_43") !=null) {
											//System.out.println("Certifier Comment is not same for batch id :" + ipm_id);
											p.println("Certifier Comment is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_45") != null ) {
										if( rs.getString("XIPM_APP_1_45").equals(rs1.getString("XIPM_APP_1_44")))
											{
												//System.out.println("Extra2 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Extra2 is not same for batch id :" + ipm_id);
												p.println("PO_Hold_Release_Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_44") !=null) {
											//System.out.println("Extra2 is not same for batch id :" + ipm_id);
											p.println("PO_Hold_Release_Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_46") != null ) {
										if( rs.getString("XIPM_APP_1_46").equals(rs1.getString("XIPM_APP_1_45")))
											{
												//System.out.println("ReasonTypeCHK is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("ReasonTypeCHK is not same for batch id :" + ipm_id);
												p.println("findel_Hold_Release_Date is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_45") !=null) {
											//System.out.println("ReasonTypeCHK is not same for batch id :" + ipm_id);
											p.println("findel_Hold_Release_Date is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_50") != null ) {
										if( rs.getString("XIPM_APP_1_50").equals(rs1.getString("XIPM_APP_1_49")))
											{
												//System.out.println("On-Hold is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("On-Hold is not same for batch id :" + ipm_id);
												p.println("Additional field6 is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_49") !=null) {
											//System.out.println("On-Hold is not same for batch id :" + ipm_id);
											p.println("Additional field6 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_51") != null ) {
										if( rs.getString("XIPM_APP_1_51").equals(rs1.getString("XIPM_APP_1_50")))
											{
												//System.out.println("Small_Business is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Small_Business is not same for batch id :" + ipm_id);
												p.println("InvoiceDescription is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_50") !=null) {
											//System.out.println("Small_Business is not same for batch id :" + ipm_id);
											p.println("InvoiceDescription is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_52") != null ) {
										if( rs.getString("XIPM_APP_1_52").equals(rs1.getString("XIPM_APP_1_51")))
											{
												//System.out.println("PO_Hold_Release_Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("PO_Hold_Release_Date is not same for batch id :" + ipm_id);
												p.println("On-Hold is not same for:" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_51") !=null) {
											//System.out.println("PO_Hold_Release_Date is not same for batch id :" + ipm_id);
											p.println("On-Hold is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_53") != null ) {
										if( rs.getString("XIPM_APP_1_53").equals(rs1.getString("XIPM_APP_1_52")))
											{
												//System.out.println("findel_Hold_Release_Date is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("findel_Hold_Release_Date is not same for batch id :" + ipm_id);
												p.println("Small_Business is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_52") !=null) {
											//System.out.println("findel_Hold_Release_Date is not same for batch id :" + ipm_id);
											p.println("Small_Business is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_48") != null ) {
										if( rs.getString("XIPM_APP_1_48").equals(rs1.getString("XIPM_APP_1_47")))
											{
												//System.out.println("Additional field16 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field16 is not same for batch id :" + ipm_id);
												p.println("Additional field16 is not same for :" + ipm_id);
												//isNotMatched = true;
												
											}
									}else {
										if(rs1.getString("XIPM_APP_1_47") !=null) {
											//System.out.println("Additional field16 is not same for batch id :" + ipm_id);
											p.println("Additional field16 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_49") != null ) {
										if( rs.getString("XIPM_APP_1_49").equals(rs1.getString("XIPM_APP_1_48")))
											{
												//System.out.println("Additional field16 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field16 is not same for batch id :" + ipm_id);
												p.println("Additional field5 is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_48") !=null) {
											//System.out.println("Additional field16 is not same for batch id :" + ipm_id);
											p.println("Additional field5 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_54") != null ) {
										if( rs.getString("XIPM_APP_1_54").equals(rs1.getString("XIPM_APP_1_53")))
											{
												//System.out.println("Additional field10 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field10 is not same for batch id :" + ipm_id);
												p.println("Additional field10 is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_53") !=null) {
											//System.out.println("Additional field10 is not same for batch id :" + ipm_id);
											p.println("Additional field10 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_55") != null ) {
										if( rs.getString("XIPM_APP_1_55").equals(rs1.getString("XIPM_APP_1_54")))
											{
												//System.out.println("Additional field17 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field17 is not same for batch id :" + ipm_id);
												p.println("Additional field11 is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_54") !=null) {
											//System.out.println("Additional field17 is not same for batch id :" + ipm_id);
											p.println("Additional field11 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_56") != null ) {
										if( rs.getString("XIPM_APP_1_56").equals(rs1.getString("XIPM_APP_1_55")))
											{
												//System.out.println("Additional field10 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field10 is not same for batch id :" + ipm_id);
												p.println("Additional field12 is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_55") !=null) {
											//System.out.println("Additional field10 is not same for  batch id :" + ipm_id);
											p.println("Additional field12 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									if( rs.getString("XIPM_APP_1_57") != null ) {
										if( rs.getString("XIPM_APP_1_57").equals(rs1.getString("XIPM_APP_1_56")))
											{
												//System.out.println("Additional field11 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field11 is not same for batch id :" + ipm_id);
												p.println("Additional field13 is not same for :" + ipm_id);
												//isNotMatched = true;
											}
									}else {
										if(rs1.getString("XIPM_APP_1_56") !=null) {
											//System.out.println("Additional field11 is not same for  batch id :" + ipm_id);
											p.println("Additional field13 is not same for :" + ipm_id);
											//isNotMatched = true;

										}
									}
									
									/*if( rs.getString("XIPM_APP_1_58") != null ) {
										if( rs.getString("XIPM_APP_1_58").equals(rs1.getString("XIPM_APP_1_57")))
											{
												//System.out.println("Additional field12 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field12 is not same for batch id :" + ipm_id);
												p.println("Additional field12 is not same for :" + ipm_id);
											}
									}else {
										if(rs1.getString("XIPM_APP_1_57") !=null) {
											//System.out.println("Additional field12 is not same for  batch id :" + ipm_id);
											p.println("Additional field12 is not same for :" + ipm_id);

										}
									}*/
									
									/*if( rs.getString("XIPM_APP_1_59") != null ) {
										if( rs.getString("XIPM_APP_1_59").equals(rs1.getString("XIPM_APP_1_58")))
											{
												//System.out.println("Additional field13 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field13 is not same for batch id :" + ipm_id);
												p.println("Additional field13 is not same for :" + ipm_id);
											}
									}else {
										if(rs1.getString("XIPM_APP_1_58") !=null) {
											//System.out.println("Additional field13 is not same for  batch id :" + ipm_id);
											p.println("Additional field13 is not same for :" + ipm_id);

										}
									}*/
									
									/*if( rs.getString("XIPM_APP_1_60") != null ) {
										if( rs.getString("XIPM_APP_1_60").equals(rs1.getString("XIPM_APP_1_59")))
											{
												//System.out.println("Additional field14 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field14 is not same for batch id :" + ipm_id);
												p.println("Additional field14 is not same for :" + ipm_id);
											}
									}else {
										if(rs1.getString("XIPM_APP_1_59") !=null) {
											//System.out.println("Additional field14 is not same for  batch id :" + ipm_id);
											p.println("Additional field14 is not same for :" + ipm_id);

										}
									}*/
									
									/*if( rs.getString("XIPM_APP_1_61") != null ) {
										if( rs.getString("XIPM_APP_1_61").equals(rs1.getString("XIPM_APP_1_60")))
											{
												//System.out.println("Additional field15 is same for :" + ipm_id);
											}
										else
											{
												//System.out.println("Additional field15 is not same for batch id :" + ipm_id);
												p.println("Additional field15 is not same for :" + ipm_id);
											}
									}else {
										if(rs1.getString("XIPM_APP_1_60") !=null) {
											//System.out.println("Additional field15 is not same for  batch id :" + ipm_id);
											p.println("Additional field15 is not same for :" + ipm_id);

										}
									}*/
									
									/*if(!isNotMatched)
									{
										p.println("IPM ID Matched : " + ipm_id); 
									}*/
								}
								
								
								
									
								if(emptyResultsSet1) {
									//System.out.println("Record is not prsent in 12C for ipm id :" + ipm_id);
									p.println("Record is not present in 12C for ipm id :" + ipm_id);
								}
								
								rs1.close();
								con_12c.close();	
							
							}
							
							catch( Exception e)
							{
								e.printStackTrace();
							}
						//}
						
						//else
						
							//{
								/*
							}
							invoice_no = rs.getString("XIPM_APP_1_11");
							System.out.println("invoice_no:" + invoice_no);
							p.println("invoice_no:" + invoice_no);
							
							try {
								
								boolean emptyResultsSet2 = true;

								Class.forName("com.mysql.cj.jdbc.Driver");
								con_12c = DriverManager.getConnection(url_12c,uname_12c,pass_12c);
								PreparedStatement ps2 = con_12c.prepareStatement(query2_12c);
								ps2.setString(1,invoice_no);
								ResultSet rs2 = ps2.executeQuery();
								while (rs2.next())
								
								{	
									emptyResultsSet2 = false;	
									
									if( rs.getString("XIPM_APP_1_0") != null ) {
										if( rs.getString("XIPM_APP_1_0").equals(rs2.getString("XIPM_APP_1_0")))
										{
											//System.out.println("Username is same for :" + invoice_no);
										}
										else
										{
											//System.out.println("Username is not same for invoice no :" + invoice_no);
											p.println("Username is not same for invoice no :" + invoice_no);
										}
									}else {
										if(rs2.getString("XIPM_APP_1_0") !=null) {
											//System.out.println("Username is not same for invoice no :" + invoice_no);
											p.println("Username is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_1") != null ) {
										if( rs.getString("XIPM_APP_1_1").equals(rs2.getString("XIPM_APP_1_1")))
										{
											//System.out.println("Activity is same for :" + invoice_no);
										}
										else
										{
											//System.out.println("Activity is not same for invoice no :" + invoice_no);
											p.println("Activity is not same for invoice no :" + invoice_no);
										}
									}else {
										if(rs2.getString("XIPM_APP_1_1") !=null) {
											//System.out.println("Activity is not same for invoice no:" + invoice_no);
											p.println("Activity is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_2") != null ) {
										if( rs.getString("XIPM_APP_1_2").equals(rs2.getString("XIPM_APP_1_2")))
										{
											//System.out.println("Document Type is same for :" + invoice_no);
										}
										else
										{
											//System.out.println("Document Type is not same for invoice no :" + invoice_no);
											p.println("Document Type is not same for invoice no :" + invoice_no);
										}
									}else {
										if(rs2.getString("XIPM_APP_1_2") !=null) {
											//System.out.println("Document Type is not same for invoice no :" + invoice_no);
											p.println("Document Type is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_3") != null ) {
										if( rs.getString("XIPM_APP_1_3").equals(rs2.getString("XIPM_APP_1_3")))
										{
											//System.out.println("Invoice Type is same for :" + invoice_no);
										}
										else
										{
											//System.out.println("Invoice Type is not same for invoice no :" + invoice_no);
											p.println("Invoice Type is not same for invoice no :" + invoice_no);
										}
									}else {
										if(rs2.getString("XIPM_APP_1_3") !=null) {
											//System.out.println("Invoice Type is not same for invoice no :" + invoice_no);
											p.println("Invoice Type is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_4") != null ) {
										if( rs.getString("XIPM_APP_1_4").equals(rs2.getString("XIPM_APP_1_4")))
										{
											//System.out.println("OrgID is same for :" + invoice_no);
										}
										else
										{
											//System.out.println("OrgID is not same for invoice no :" + invoice_no);
											p.println("OrgID is not same for invoice no :" + invoice_no);
										}
									}else {
										if(rs2.getString("XIPM_APP_1_4") !=null) {
											//System.out.println("OrgID is not same for invoice no :" + invoice_no);
											p.println("OrgID is not same for invoice no :" + invoice_no);

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_5") != null ) {
										if( rs.getString("XIPM_APP_1_5").equals(rs2.getString("XIPM_APP_1_5")))
											{
												//System.out.println("PO Number is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("PO Number is not same for invoice no :" + invoice_no);
												p.println("PO Number is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_5") !=null) {
											//System.out.println("PO Number is not same for invoice no :" + invoice_no);
											p.println("PO Number is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_6") != null ) {
										if( rs.getString("XIPM_APP_1_6").equals(rs2.getString("XIPM_APP_1_6")))
											{
												//System.out.println("Currency is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Currency is not same for invoice no :" + invoice_no);
												p.println("Currency is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_6") !=null) {
											//System.out.println("Currency is not same for invoice no :" + invoice_no);
											p.println("Currency is not same for invoice no :" + invoice_no);

											
										}
									}
									
									
									if( rs.getString("XIPM_APP_1_7") != null ) {
										if( rs.getString("XIPM_APP_1_7").equals(rs2.getString("XIPM_APP_1_7")))
											{
												//System.out.println("Certifier Name is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Certifier Name is not same for invoice no :" + invoice_no);
												p.println("Certifier Name is not same for invoice no :" + invoice_no);
												
											}
									}else {
										if(rs2.getString("XIPM_APP_1_7") !=null) {
											//System.out.println("Certifier Name is not same for invoice no :" + invoice_no);
											p.println("Certifier Name is not same for invoice no :" + invoice_no);

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_8") != null ) {
										if( rs.getString("XIPM_APP_1_8").equals(rs2.getString("XIPM_APP_1_8")))
											{
												//System.out.println("Supplier ID is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Supplier ID is not same for invoice no :" + invoice_no);
												p.println("Supplier ID is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_8") !=null) {
											//System.out.println("Supplier ID is not same for invoice no :" + invoice_no);
											p.println("Supplier ID is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_9") != null ) {
										if( rs.getString("XIPM_APP_1_9").equals(rs2.getString("XIPM_APP_1_9")))
											{
												//System.out.println("Supplier Name is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Supplier Name is not same for invoice no :" + invoice_no);
												p.println("Supplier Name is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_9") !=null) {
											//System.out.println("Supplier Name is not same for invoice no :" + invoice_no);
											p.println("Supplier Name is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_10") != null ) {
										if( rs.getString("XIPM_APP_1_10").equals(rs2.getString("XIPM_APP_1_10")))
											{
												//System.out.println("Site ID is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Site ID is not same for invoice no :" + invoice_no);
												p.println("Site ID is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_10") !=null) {
											//System.out.println("Site ID is not same for invoice no :" + invoice_no);
											p.println("Site ID is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_11") != null ) {
										if( rs.getString("XIPM_APP_1_11").equals(rs2.getString("XIPM_APP_1_11")))
											{
												//System.out.println("Invoice Number is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Invoice Number is not same for invoice no :" + invoice_no);
												p.println("Invoice Number is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_11") !=null) {
											//System.out.println("Invoice Number is not same for invoice no :" + invoice_no);
											p.println("Invoice Number is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_12") != null ) {
										if( rs.getString("XIPM_APP_1_12").equals(rs2.getString("XIPM_APP_1_12")))
											{
												//System.out.println("Invoice Total is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Invoice Total is not same for invoice no :" + invoice_no);
												p.println("Invoice Total is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_12") !=null) {
											//System.out.println("Invoice Total is not same for invoice no :" + invoice_no);
											p.println("Invoice Total is not same for invoice no :" + invoice_no);

										}
									}
									
									
									if( rs.getString("XIPM_APP_1_13") != null ) {
										if( rs.getString("XIPM_APP_1_13").equals(rs2.getString("XIPM_APP_1_13")))
											{
												//System.out.println("Invoice Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Invoice Date is not same for invoice no :" + invoice_no);
												p.println("Invoice Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_13") !=null) {
											//System.out.println("Invoice Date is not same for invoice no :" + invoice_no);
											p.println("Invoice Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_14") != null ) {
										if( rs.getString("XIPM_APP_1_14").equals(rs2.getString("XIPM_APP_1_14")))
											{
												//System.out.println("Priority is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Priority is not same for invoice no :" + invoice_no);
												p.println("Priority is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_14") !=null) {
											//System.out.println("Priority is not same for invoice no :" + invoice_no);
											p.println("Priority is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_15") != null ) {
										if( rs.getString("XIPM_APP_1_15").equals(rs2.getString("XIPM_APP_1_15")))
											{
												//System.out.println("Invalid Reason Code is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Invalid Reason Code is not same for invoice no :" + invoice_no);
												p.println("Invalid Reason Code is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_15") !=null) {
											//System.out.println("Invalid Reason Code is not same for invoice no :" + invoice_no);
											p.println("Invalid Reason Code is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_16") != null ) {
										if( rs.getString("XIPM_APP_1_16").equals(rs2.getString("XIPM_APP_1_16")))
											{
												//System.out.println("Invalid Reason is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Invalid Reason is not same for invoice no :" + invoice_no);
												p.println("Invalid Reason is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_16") !=null) {
											//System.out.println("Invalid Reason is not same for invoice no :" + invoice_no);
											p.println("Invalid Reason is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_17") != null ) {
										if( rs.getString("XIPM_APP_1_17").equals(rs2.getString("XIPM_APP_1_17")))
											{
												//System.out.println("Scan Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Scan Date is not same for invoice no :" + invoice_no);
												p.println("Scan Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_17") !=null) {
											//System.out.println("Scan Date is not same for invoice no :" + invoice_no);
											p.println("Scan Date is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_18") != null ) {
										if( rs.getString("XIPM_APP_1_18").equals(rs2.getString("XIPM_APP_1_18")))
											{
												//System.out.println("Supplier Number is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Supplier Number is not same for invoice no :" + invoice_no);
												p.println("Supplier Number is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_18") !=null) {
											//System.out.println("Supplier Number is not same for invoice no :" + invoice_no);
											p.println("Supplier Number is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_19") != null ) {
										if( rs.getString("XIPM_APP_1_19").equals(rs2.getString("XIPM_APP_1_19")))
											{
												//System.out.println("Capture Batch ID is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Capture Batch ID is not same for invoice no :" + invoice_no);
												p.println("Capture Batch ID is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_19") !=null) {
											//System.out.println("Capture Batch ID is not same for invoice no :" + invoice_no);
											p.println("Capture Batch ID is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_20") != null ) {
										if( rs.getString("XIPM_APP_1_20").equals(rs2.getString("XIPM_APP_1_20")))
											{
												//System.out.println("Document Last Update Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Document Last Update Date is not same for invoice no :" + invoice_no);
												p.println("Document Last Update Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_20") !=null) {
											//System.out.println("Document Last Update Date is not same for invoice no :" + invoice_no);
											p.println("Document Last Update Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_21") != null ) {
										if( rs.getString("XIPM_APP_1_21").equals(rs2.getString("XIPM_APP_1_21")))
											{
												//System.out.println("Document History is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Document History is not same for invoice no :" + invoice_no);
												p.println("Document History is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_21") !=null) {
											//System.out.println("Document History is not same for invoice no :" + invoice_no);
											p.println("Document History is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_23") != null ) {
										if( rs.getString("XIPM_APP_1_23").equals(rs2.getString("XIPM_APP_1_22")))
											{
												//System.out.println("Due Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Due Date is not same for invoice no :" + invoice_no);
												p.println("Due Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_22") !=null) {
											//System.out.println("Due Date is not same for invoice no :" + invoice_no);
											p.println("Due Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_24") != null ) {
										if( rs.getString("XIPM_APP_1_24").equals(rs2.getString("XIPM_APP_1_23")))
											{
												//System.out.println("Approvar Name is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Approvar Name is not same for invoice no :" + invoice_no);
												p.println("Approvar Name is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_23") !=null) {
										//	System.out.println("Approvar Name is not same for invoice no :" + invoice_no);
											p.println("Approvar Name is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_25") != null ) {
										if( rs.getString("XIPM_APP_1_25").equals(rs2.getString("XIPM_APP_1_24")))
											{
												//System.out.println("Payment Number is same for :" + invoice_no);
											}
										else
											{
											//	System.out.println("Payment Number is not same for invoice no :" + invoice_no);
												p.println("Payment Number is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_24") !=null) {
											//System.out.println("Payment Number is not same for invoice no :" + invoice_no);
											p.println("Payment Number is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_26") != null ) {
										if( rs.getString("XIPM_APP_1_26").equals(rs2.getString("XIPM_APP_1_25")))
											{
												//System.out.println("Payment Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Payment Date is not same for invoice no :" + invoice_no);
												p.println("Payment Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_25") !=null) {
											//System.out.println("Payment Date is not same for invoice no :" + invoice_no);
											p.println("Payment Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_27") != null ) {
										if( rs.getString("XIPM_APP_1_27").equals(rs2.getString("XIPM_APP_1_26")))
											{
												//System.out.println("Internal Status is same for :" + invoice_no);
											}
										else
											{
											//	System.out.println("Internal Status is not same for invoice no :" + invoice_no);
												p.println("Internal Status is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_26") !=null) {
											//System.out.println("Internal Status is not same for invoice no :" + invoice_no);
											p.println("Internal Status is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_28") != null ) {
										if( rs.getString("XIPM_APP_1_28").equals(rs2.getString("XIPM_APP_1_27")))
											{
												//System.out.println("Last Update Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Last Update Date is not same for invoice no :" + invoice_no);
												p.println("Last Update Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_27") !=null) {
											//System.out.println("Last Update Date is not same for invoice no :" + invoice_no);
											p.println("Last Update Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_29") != null ) {
										if( rs.getString("XIPM_APP_1_29").equals(rs2.getString("XIPM_APP_1_28")))
											{
												//System.out.println("Certification Pending Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Certification Pending Date is not same for invoice no :" + invoice_no);
												p.println("Certification Pending Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_28") !=null) {
											//System.out.println("Certification Pending Date is not same for invoice no :" + invoice_no);
											p.println("Certification Pending Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_30") != null ) {
										if( rs.getString("XIPM_APP_1_30").equals(rs2.getString("XIPM_APP_1_29")))
											{
												//System.out.println("eQ Interface Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("eQ Interface Date is not same for invoice no :" + invoice_no);
												p.println("eQ Interface Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_29") !=null) {
											//System.out.println("eQ Interface Date is not same for invoice no :" + invoice_no);
											p.println("eQ Interface Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_31") != null ) {
										if( rs.getString("XIPM_APP_1_31").equals(rs2.getString("XIPM_APP_1_30")))
											{
												//System.out.println("AP Username is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("AP Username is not same for invoice no :" + invoice_no);
												p.println("AP Username is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_30") !=null) {
											//System.out.println("AP Username is not same for invoice no :" + invoice_no);
											p.println("AP Username is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_32") != null ) {
										if( rs.getString("XIPM_APP_1_32").equals(rs2.getString("XIPM_APP_1_31")))
											{
												//System.out.println("Source is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Source is not same for invoice no :" + invoice_no);
												p.println("Source is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_31") !=null) {
											//System.out.println("Source is not same for invoice no :" + invoice_no);
											p.println("Source is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_33") != null ) {
										if( rs.getString("XIPM_APP_1_33").equals(rs2.getString("XIPM_APP_1_32")))
											{
												//System.out.println("Operating Unit Name is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Operating Unit Name is not same for invoice no :" + invoice_no);
												p.println("Operating Unit Name is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_32") !=null) {
											//System.out.println("Operating Unit Name is not same for invoice no :" + invoice_no);
											p.println("Operating Unit Name is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_34") != null ) {
										if( rs.getString("XIPM_APP_1_34").equals(rs2.getString("XIPM_APP_1_33")))
											{
												//System.out.println("Freight is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Freight is not same for invoice no :" + invoice_no);
												p.println("Freight is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_33") !=null) {
											//System.out.println("Freight is not same for invoice no :" + invoice_no);
											p.println("Freight is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_35") != null ) {
										if( rs.getString("XIPM_APP_1_35").equals(rs2.getString("XIPM_APP_1_34")))
											{
												//System.out.println("AOG is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("AOG is not same for invoice no :" + invoice_no);
												p.println("AOG is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_34") !=null) {
											//System.out.println("AOG is not same for invoice no :" + invoice_no);
											p.println("AOG is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_36") != null ) {
										if( rs.getString("XIPM_APP_1_36").equals(rs2.getString("XIPM_APP_1_35")))
											{
												//System.out.println("Currency Equivalent is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Currency Equivalent is not same for invoice no :" + invoice_no);
												p.println("Currency Equivalent is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_35") !=null) {
											//System.out.println("Currency Equivalent is not same for invoice no :" + invoice_no);
											p.println("Currency Equivalent is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_37") != null ) {
										if( rs.getString("XIPM_APP_1_37").equals(rs2.getString("XIPM_APP_1_36")))
											{
												//System.out.println("WHT Amount is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("WHT Amount is not same for invoice no :" + invoice_no);
												p.println("WHT Amount is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_36") !=null) {
											//System.out.println("WHT Amount is not same for invoice no :" + invoice_no);
											p.println("WHT Amount is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_38") != null ) {
										if( rs.getString("XIPM_APP_1_38").equals(rs2.getString("XIPM_APP_1_37")))
											{
												//System.out.println("InvoiceFileName is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("InvoiceFileName is not same for invoice no :" + invoice_no);
												p.println("InvoiceFileName is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_37") !=null) {
											//System.out.println("InvoiceFileName is not same for invoice no :" + invoice_no);
											p.println("InvoiceFileName is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_39") != null ) {
										if( rs.getString("XIPM_APP_1_39").equals(rs2.getString("XIPM_APP_1_38")))
											{
												//System.out.println("SupplierEmailID is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("SupplierEmailID is not same for invoice no :" + invoice_no);
												p.println("SupplierEmailID is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_38") !=null) {
											//System.out.println("SupplierEmailID is not same for invoice no :" + invoice_no);
											p.println("SupplierEmailID is not same for invoice no :" + invoice_no);

										}
									}  
									
									if( rs.getString("XIPM_APP_1_40") != null ) {
										if( rs.getString("XIPM_APP_1_40").equals(rs2.getString("XIPM_APP_1_40")))
											{
												//System.out.println("Reason Type is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Reason Type is not same for invoice no :" + invoice_no);
												p.println("Reason Type is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_40") !=null) {
											//System.out.println("Reason Type is not same for invoice no :" + invoice_no);
											p.println("Reason Type is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_41") != null ) {
										if( rs.getString("XIPM_APP_1_41").equals(rs2.getString("XIPM_APP_1_41")))
											{
												//System.out.println("WFR UserName is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("WFR UserName is not same for invoice no :" + invoice_no);
												p.println("WFR UserName is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_41") !=null) {
											//System.out.println("WFR UserName is not same for invoice no :" + invoice_no);
											p.println("WFR UserName is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_42") != null ) {
										if( rs.getString("XIPM_APP_1_42").equals(rs2.getString("XIPM_APP_1_42")))
											{
												//System.out.println("Tax Registration Number is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Tax Registration Number is not same for invoice no :" + invoice_no);
												p.println("Tax Registration Number is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_42") !=null) {
											//System.out.println("Tax Registration Number is not same for invoice no :" + invoice_no);
											p.println("Tax Registration Number is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_43") != null ) {
										if( rs.getString("XIPM_APP_1_43").equals(rs2.getString("XIPM_APP_1_46")))
											{
												//System.out.println("BPM Comment is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("BPM Comment is not same for invoice no :" + invoice_no);
												p.println("BPM Comment is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_46") !=null) {
											//System.out.println("BPM Comment is not same for invoice no :" + invoice_no);
											p.println("BPM Comment is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_44") != null ) {
										if( rs.getString("XIPM_APP_1_44").equals(rs2.getString("XIPM_APP_1_47")))
											{
												//System.out.println("Certifier Comment is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Certifier Comment is not same for invoice no :" + invoice_no);
												p.println("Certifier Comment is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_47") !=null) {
											//System.out.println("Certifier Comment is not same for invoice no :" + invoice_no);
											p.println("Certifier Comment is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_51") != null ) {
										if( rs.getString("XIPM_APP_1_51").equals(rs2.getString("XIPM_APP_1_48")))
											{
												//System.out.println("InvoiceDescription is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("InvoiceDescription is not same for invoice no :" + invoice_no);
												p.println("InvoiceDescription is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_48") !=null) {
											//System.out.println("InvoiceDescription is not same for invoice no :" + invoice_no);
											p.println("InvoiceDescription is not same for invoice no :" + invoice_no);
											
										}
									}
									
									if( rs.getString("XIPM_APP_1_52") != null ) {
										if( rs.getString("XIPM_APP_1_52").equals(rs2.getString("XIPM_APP_1_49")))
											{
												//System.out.println("On-Hold is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("On-Hold is not same for invoice no :" + invoice_no);
												p.println("On-Hold is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_49") !=null) {
											//System.out.println("On-Hold is not same for invoice no :" + invoice_no);
											p.println("On-Hold is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_53") != null ) {
										if( rs.getString("XIPM_APP_1_53").equals(rs2.getString("XIPM_APP_1_50")))
											{
												//System.out.println("Small_Business is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Small_Business is not same for invoice no :" + invoice_no);
												p.println("Small_Business is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_50") !=null) {
											//System.out.println("Small_Business is not same for invoice no :" + invoice_no);
											p.println("Small_Business is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_45") != null ) {
										if( rs.getString("XIPM_APP_1_45").equals(rs2.getString("XIPM_APP_1_51")))
											{
												//System.out.println("PO_Hold_Release_Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("PO_Hold_Release_Date is not same for invoice no :" + invoice_no);
												p.println("PO_Hold_Release_Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_51") !=null) {
											//System.out.println("PO_Hold_Release_Date is not same for invoice no :" + invoice_no);
											p.println("PO_Hold_Release_Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_46") != null ) {
										if( rs.getString("XIPM_APP_1_46").equals(rs2.getString("XIPM_APP_1_52")))
											{
												//System.out.println("findel_Hold_Release_Date is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("findel_Hold_Release_Date is not same for invoice no :" + invoice_no);
												p.println("findel_Hold_Release_Date is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_52") !=null) {
											//System.out.println("findel_Hold_Release_Date is not same for invoice no :" + invoice_no);
											p.println("findel_Hold_Release_Date is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_48") != null ) {
										if( rs.getString("XIPM_APP_1_48").equals(rs2.getString("XIPM_APP_1_53")))
											{
												//System.out.println("Additional field16 is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Additional field16 is not same for invoice no :" + invoice_no);
												p.println("Additional field16 is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_53") !=null) {
											//System.out.println("Additional field16 is not same for invoice no :" + invoice_no);
											p.println("Additional field16 is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_54") != null ) {
										if( rs.getString("XIPM_APP_1_54").equals(rs2.getString("XIPM_APP_1_55")))
											{
												//System.out.println("Additional field10 is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Additional field10 is not same for invoice no :" + invoice_no);
												p.println("Additional field10 is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_55") !=null) {
											//System.out.println("Additional field10 is not same for invoice no :" + invoice_no);
											p.println("Additional field10 is not same for invoice no :" + invoice_no);
											
										}
									}
									
									if( rs.getString("XIPM_APP_1_55") != null ) {
										if( rs.getString("XIPM_APP_1_55").equals(rs2.getString("XIPM_APP_1_56")))
											{
												//System.out.println("Additional field11 is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Additional field11 is not same for invoice no :" + invoice_no);
												p.println("Additional field11 is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_56") !=null) {
											//System.out.println("Additional field11 is not same for invoice no :" + invoice_no);
											p.println("Additional field11 is not same for invoice no :" + invoice_no);

										}
									}
									
									if( rs.getString("XIPM_APP_1_56") != null ) {
										if( rs.getString("XIPM_APP_1_56").equals(rs2.getString("XIPM_APP_1_57")))
											{
												//System.out.println("Additional field12 is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Additional field12 is not same for invoice no :" + invoice_no);
												p.println("Additional field12 is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_57") !=null) {
											//System.out.println("Additional field12 is not same for invoice no :" + invoice_no);
											p.println("Additional field12 is not same for invoice no :" + invoice_no);

											
										}
									}
									
									if( rs.getString("XIPM_APP_1_57") != null ) {
										if( rs.getString("XIPM_APP_1_57").equals(rs2.getString("XIPM_APP_1_58")))
											{
												//System.out.println("Additional field13 is same for :" + invoice_no);
											}
										else
											{
												//System.out.println("Additional field13 is not same for invoice no :" + invoice_no);
												p.println("Additional field13 is not same for invoice no :" + invoice_no);
											}
									}else {
										if(rs2.getString("XIPM_APP_1_58") !=null) {
											//System.out.println("Additional field13 is not same for invoice no :" + invoice_no);
											p.println("Additional field13 is not same for invoice no :" + invoice_no);

										}
									}
									
								
									
								}
								if(emptyResultsSet2) {
									//System.out.println("Record is not prsent in 12C for invoice number :" + invoice_no);
									p.println("Record is not prsent in 12C for invoice number :" + invoice_no);
								}
								
								rs2.close();
								con_12c.close();
							}
							
							
							catch( Exception e)
							{
								e.printStackTrace();
							}
						*///}
			//}
				
		}
			
			rs.close();
			con_11g.close();
			p.println("End time : " +LocalDateTime.now());
			
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

	public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Start time : " +LocalDateTime.now());
		//p.println("Start time : " + LocalDateTime.now());
		New obj = new New();
		obj.getId();
        System.out.println("End time : " +LocalDateTime.now());


	} 

}
