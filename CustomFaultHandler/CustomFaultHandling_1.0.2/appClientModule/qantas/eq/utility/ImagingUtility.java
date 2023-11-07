package qantas.eq.utility;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import qantas.imaging.webservice.Exception_Exception;
import qantas.imaging.webservice.ImagingDoc;
import qantas.imaging.webservice.ImagingServiceImpl;

public class ImagingUtility {

	private Connection con = null;
	/*public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@eqdr-db1:16010:SOAPSP1", "eqfiles", "soapSp009");
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return con;
	}*/

	public Connection getConnection() {
		
		Connection con = null;
		try {
		String configFile = System.getenv("QFEQIF_CONFIG");
		Properties pro = new Properties();
		pro.load(new FileInputStream(configFile));
		String dsName = pro.getProperty("IHUB_DATA_SOURCE");
		
		Context ic = new InitialContext();
		DataSource ds = (DataSource)ic.lookup(dsName);
		con = ds.getConnection();
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return con;
	}
	
	public String getIPMId(String IFID, String file_Name, Timestamp ts) {
		Connection con = getConnection();
		String result = null;
		try {

			PreparedStatement stmt = con.prepareStatement(
					"select IFID, IPM_ID from QFEQIF_WCC where IFID = ? AND FILE_NAME = ? AND FILE_CREATION_TIME = ?");
			stmt.setString(1, IFID);
			stmt.setString(2, file_Name);
			stmt.setTimestamp(3, ts);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(2) != null)
					result = rs.getString(2);
				else
					result = "noipmid";
			} else {
				result = "norecord";
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		} finally {
			closeConnection(con);
		}
		return result;

	}

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> searchimpid(String ifid, String file_Path, String file_Name, String rename_Filename) {

		System.out.println("Search IPMID");
		System.out.println("Starting...............");
		ImagingDoc imdoc = new ImagingDoc();
		ImagingServiceImpl serviceInterface = imdoc.getImagingServiceImplPort();
		System.out.println("Calling imaging service");
		List<String> str = serviceInterface.searchIPM(ifid, file_Path, file_Name, rename_Filename);
		for (String s : str) {
			System.out.println("element " + s);
		}
		return str;

	}

	public String uploadService(String ifId, String filePath, String fileName, String wccPath, String renameFilename,
			String errorMessage) {

		System.out.println("UploadService Method");
		ImagingDoc imdoc = new ImagingDoc();
		ImagingServiceImpl serviceInterface = imdoc.getImagingServiceImplPort();
		System.out.println("Calling imaging upload service");
		String str = serviceInterface.uploadFile(ifId, filePath, fileName, wccPath, renameFilename, errorMessage, "N");

		System.out.println("element " + str);

		return str;

	}
	
	public String updateService(String ipmid, String ifId, String filePath, String fileName, String wccPath, String renameFilename,
			String errorMessage) {

		System.out.println("UpdateService Method");
		ImagingDoc imdoc = new ImagingDoc();
		ImagingServiceImpl serviceInterface = imdoc.getImagingServiceImplPort();
		System.out.println("Calling imaging upload service");
		String str = null;
		try {
			str = serviceInterface.updateService(ipmid, ifId, filePath, fileName,"N" , renameFilename , wccPath , errorMessage);
		} catch (Exception_Exception e) {
			e.printStackTrace();
			str = e.getMessage();
		}

		System.out.println("element " + str);

		return str;

	}

	
	public void updateIPMId(String ifId, String fileName, Timestamp ts, String ipmid) throws SQLException {

		con = getConnection();
		Date date = new Date();
		
		PreparedStatement stmt = con.prepareStatement("update QFEQIF_WCC set IPM_ID = ? ,STATUS = ?,LAST_UP_DT = ? where IFID = ? AND FILE_NAME = ? AND FILE_CREATION_TIME = ?");
		//stmt.setString(1, ipmid);		
		
		stmt.setString(1, ipmid);
		stmt.setString(2, "ERROR");
		stmt.setTimestamp(3, new Timestamp(date.getTime()));
		stmt.setString(4, ifId);
		stmt.setString(5, fileName);
		stmt.setTimestamp(6, ts);		
	/*	
		stmt.setString(2, ifId);
		stmt.setString(3, fileName);
		stmt.setTimestamp(4, ts);
		stmt.setString(5, "ERROR");
		stmt.setTimestamp(6, new Timestamp(date.getTime()));*/
		System.out.println("UPDATE QUERY: " + stmt.toString());
		stmt.executeUpdate();

		closeConnection(con);

	}

	public void insertIPMId(String IFID, String file_Name, Timestamp ts, String ipmid) throws SQLException {
		con = getConnection();
		Date date = new Date();
		System.out.println(" Error Handling :: Before insert_wcc Stored Procedure call : IFID :: "+ IFID+" file_Name "+file_Name+" ipmid "+ipmid+" ts "+ts);
		/*PreparedStatement stmt = con.prepareStatement(
				"insert into QFEQIF_WCC (IFID, FILE_NAME, FILE_CREATION_TIME, IPM_ID, STATUS, LAST_UP_DT) VALUES (?,?,?,?,?,?)");
		stmt.setString(1, IFID);
		stmt.setString(2, file_Name);
		stmt.setTimestamp(3, ts);
		stmt.setString(4, ipmid);
		stmt.setString(5, "ERROR");
		stmt.setTimestamp(6, new Timestamp(date.getTime()));
		System.out.println("INSERT QUERY: " + stmt.toString());
		stmt.executeUpdate();*/
		
		String s="{call insert_wcc(?,?,?,?,?,?,?)}";
		CallableStatement  stmt = con.prepareCall(s);
		stmt.setString(1, IFID);
		stmt.setString(2, file_Name);
		stmt.setTimestamp(3, ts);
		stmt.setString(4, ipmid);
		stmt.setString(5, "ERROR");
		stmt.setTimestamp(6, new Timestamp(date.getTime()));
		stmt.registerOutParameter(7,Types.VARCHAR);  
		stmt.executeUpdate();
		System.out.println(" Error Handling :: insert_wcc Stored Procedure Result : " + stmt.getString(7));
	}

	public void closeConnection() {
		try {
			if(con != null)
			{
				con.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
