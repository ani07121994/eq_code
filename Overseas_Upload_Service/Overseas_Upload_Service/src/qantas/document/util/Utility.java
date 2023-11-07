package qantas.document.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//import qantas.document.exception.ServiceException;

public class Utility {

	
	public void trackAuditInfo(String soapMsg, String strStatusCode, String strInterfaceId,String operationName,String strSession) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0; 
    	System.out.println("Inside trackAuditInfo : operationName :"+operationName);		             
		
		try {
			conn = getConnection();
			//String strSession = new Handler1().getSession().toString();

			if(conn != null){
				if(operationName != null && !"".equals(operationName) && operationName.endsWith("URL"))
				{
					operationName = "UploadDocumentService";
				}else{
					operationName = "DownloadDocumentService";
				}
				
				StringBuilder sbQuery = new StringBuilder();
				
				
				sbQuery.append("INSERT INTO qfeqif_interface_audit VALUES(?,?,?,?,?,?,?,?,?,?)");
				pstmt = conn.prepareStatement(sbQuery.toString());
			
				
			    java.sql.Clob clob = oracle.sql.CLOB.createTemporary(conn, false, oracle.sql.CLOB.DURATION_SESSION);
			    clob.setString(1, soapMsg);
			    pstmt.setString(1, strInterfaceId);
			    pstmt.setString(2, strSession);
			    pstmt.setString(3, strSession);
			    pstmt.setString(4, strSession);
			    pstmt.setString(5, strInterfaceId);
			    pstmt.setString(6, operationName);
			    pstmt.setString(7, strStatusCode);
			    pstmt.setTimestamp(8, new java.sql.Timestamp(new java.util.Date().getTime()));
			    pstmt.setClob(9, clob);
			    pstmt.setString(10, "");
			    
			    rowCount = pstmt.executeUpdate();
			}
        	System.out.println("Record Inserted in Audit table :"+rowCount);		             

        } catch(Exception ex) {
        	System.out.println("Exception inside trackAuditInfo :"+ex.getMessage());		             
        } finally {
        	try {
	        	if(pstmt != null)
	        		pstmt.close();
	            if(conn!=null)
                    conn.close();
               } catch(Exception ex) { }
            }
	}
	public String handleControlChar(String val) throws Exception
	{
		//return val;
		if(val != null && !"".equals(val) && !val.equals("null")){
			
			StringBuilder sb = new StringBuilder(val);
			
			if(val.indexOf("&") > 0){
				sb.replace(val.indexOf("&"), val.indexOf("&")+1, "&amp;");
			}/*else if(val.indexOf("<") > 0){
				sb.replace(val.indexOf("<"), val.indexOf("<")+1, "&lt;");
			}else if(val.indexOf(">") > 0){
				sb.replace(val.indexOf(">"), val.indexOf(">")+1, "&gt;");
			}else if(val.indexOf("'") > 0){
				sb.replace(val.indexOf("'"), val.indexOf("'")+1, "&apos;");
			}else if(val.indexOf("\"") > 0){
				sb.replace(val.indexOf("\""), val.indexOf("\"")+1, "&quot;");
			}	*/		
			return sb.toString();
		}else
			return val;
			/*& = &amp;
			< = &lt;
			> = &gt;
			" = &quot;
			' = &apos;*/				
	}	
	public Map fetchValueFromDB() throws Exception
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> param = new HashMap<String,String>();
		try {
			conn = getConnection();
        	System.out.println("Connection inside fetchValueFromDB :"+conn);		             
			
			if(conn != null){
				String query = "select name,value from eqfiles.qfeqif_apinvoice_int_config";
				ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()) {
                	param.put(rs.getString("name"), rs.getString("value"));
                }				
			}
        	System.out.println("HashMap inside fetchValueFromDB :"+param);		             

        } catch(Exception ex) {
        	System.out.println("Exception inside fetchValueFromDB :"+ex.getMessage());		             
        } finally {
        	try {
	        	if(rs != null)
	        		rs.close();
	        	if(ps != null)
	        		ps.close();
	            if(conn!=null)
                    conn.close();
               } catch(Exception ex) { }
            }
        	
		return param;
	}	
	public Connection getConnection(){
        Connection conn = null;

        try {
            Context ctx = new InitialContext();   
            DataSource ds = (DataSource)ctx.lookup(getPropVal("Finesse_DS"));
            //DataSource ds = (DataSource)ctx.lookup("jdbc/EQFILES_DS");
            conn = ds.getConnection();
        } catch(Exception ex) {
        	System.out.println(ex.getMessage());            
        } 
	    return conn;
	}			
	private String getPropVal(String keyValue){

    	Properties prop = new Properties();
    	String strVal = "";
    	try {
    		System.out.println("Inside getPropVal");
    		
    		prop.load(new FileInputStream(System.getenv("QFEQIF_CONFIG")));
    		//System.out.println("Properties File=="+prop);
    		System.out.println("Properties Printed");
    		
    		//String filename = "config.properties";
    		//input = Utility.class.getClassLoader().getResourceAsStream(filename);
    		if(prop != null){
    			strVal = prop.getProperty(keyValue);
    		}
    		System.out.println("strVal=="+strVal);

    	} catch (IOException ex) {
    		ex.printStackTrace();
        } 
        
        return strVal;
    }
}	

