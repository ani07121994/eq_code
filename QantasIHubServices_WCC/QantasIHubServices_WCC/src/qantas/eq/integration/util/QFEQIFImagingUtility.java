package qantas.eq.integration.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;
import java.util.logging.Logger;

import qantas.eq.integration.QFEQIFLogger;
import qantas.eq.integration.ifs.QFEQIFUpdateLobster;
import qantas.imaging.webservice.Exception_Exception;
import qantas.imaging.webservice.ImagingDoc;
import qantas.imaging.webservice.ImagingServiceImpl;

public class QFEQIFImagingUtility {
	
	private static Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFUpdateLobster.class.getName());
	
	public String getIPMId(String IFID, String file_Name, Timestamp ts) {
		
		Connection con = QFEQIFDatabaseConn.getConnection();
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
			_QFEQLogger.info("Exception for IFID " + IFID + " and filename " + file_Name+ " "+e.getMessage());
			e.printStackTrace();
			result = "error";
		} finally {
			QFEQIFDatabaseConn.closeConnection();
		}
		return result;

	}
	
	public List<String> searchimpid(String ifid, String file_Path, String file_Name, String rename_Filename) {

		_QFEQLogger.info("Search IPMID for ifId " + ifid + " and filename " + file_Name);
		_QFEQLogger.info("Starting...............");
		ImagingDoc imdoc = new ImagingDoc();
		ImagingServiceImpl serviceInterface = imdoc.getImagingServiceImplPort();
		_QFEQLogger.info("Calling imaging service for ifId " + ifid + " and filename " + file_Name);
		List<String> str = serviceInterface.searchIPM(ifid, file_Path, file_Name, rename_Filename);
		for (String s : str) {
			_QFEQLogger.info("for ifId " + ifid + " and filename " + file_Name + "element " + s);
		}
		return str;

	}

	public String uploadService(String ifId, String filePath, String fileName, String wccPath, String renameFilename,
			String errorMessage , String deleteFlag) {

		
		_QFEQLogger.info("Starting upload service for ifId " + ifId + " and filename " + fileName);
		ImagingDoc imdoc = new ImagingDoc();
		ImagingServiceImpl serviceInterface = imdoc.getImagingServiceImplPort();
		_QFEQLogger.info("Calling imaging upload service for ifId " + ifId + " and filename " + fileName);
		String str = serviceInterface.uploadFile(ifId, filePath, fileName, wccPath, renameFilename, errorMessage, deleteFlag);

		_QFEQLogger.info("for ifId " + ifId + " and filename " + fileName + "element"  + str);

		return str;

	}
	
	public String updateService(String ipm_id, String ifId, String filePath, String fileName, String wccPath, String renameFilename,
			String errorMessage, String deleteFlag) {
		_QFEQLogger.info("Starting update service for ifId " + ifId + " and filename " + fileName);
		ImagingDoc imdoc = new ImagingDoc();
		ImagingServiceImpl serviceInterface = imdoc.getImagingServiceImplPort();
		_QFEQLogger.info("Calling imaging update service for ifId " + ifId + " and filename " + fileName);
		String str = null;
		try {
			str = serviceInterface.updateService(ipm_id, ifId, filePath, fileName, deleteFlag, renameFilename, wccPath, errorMessage);
		} catch (Exception_Exception e) {
			e.printStackTrace();
			str = e.getMessage();
		}

		_QFEQLogger.info("for ifId " + ifId + " and filename " + fileName + "element " + str);

		return str;
	}

	public void updateIPMId(String ifId, String fileName, Timestamp ts, String ipmid) throws SQLException {

		Connection con = QFEQIFDatabaseConn.getConnection();
		Timestamp lastModified = new Timestamp(System.currentTimeMillis());
		_QFEQLogger.info("lastModified :: QFEQIFImagingUtility :: updateLobstar :: updateIPMId " + lastModified.toString() + " and filename " + fileName);
		PreparedStatement stmt = con.prepareStatement("update QFEQIF_WCC set IPM_ID = ?,STATUS = ?,LAST_UP_DT = ? where IFID = ? AND FILE_NAME = ? AND FILE_CREATION_TIME = ?");
		stmt.setString(1, ipmid);
		stmt.setString(2, "INPROGRESS");
		stmt.setTimestamp(3, lastModified);
		stmt.setString(4, ifId);
		stmt.setString(5, fileName);
		stmt.setTimestamp(6, ts);
		_QFEQLogger.info("UPDATE QUERY::: IFID :: "+ifId+"File Name :: "+fileName+" QFEQIFImagingUtility :: updateIPMId :: updateLobstar " + stmt.toString());
		stmt.executeUpdate();

		QFEQIFDatabaseConn.closeConnection();

	}
	
	public void insertIPMId(String IFID, String file_Name, Timestamp ts, String ipmid) throws SQLException {
		try {
		Connection con = QFEQIFDatabaseConn.getConnection();
		
		Timestamp lastModified = new Timestamp(System.currentTimeMillis());
		_QFEQLogger.info("lastModified :: QFEQIFImagingUtility :: updateLobstar :: insertIPMId " + lastModified.toString() + " and file_Name " + file_Name);
		/*PreparedStatement stmt = con.prepareStatement(
				"insert into QFEQIF_WCC (IFID, FILE_NAME, FILE_CREATION_TIME, IPM_ID, STATUS, LAST_UP_DT) VALUES (?,?,?,?,?,? )"); //923018 Added  STATUS, LAST_UP_DT changes
		stmt.setString(1, IFID);
		stmt.setString(2, file_Name);
		stmt.setTimestamp(3, ts);
		stmt.setString(4, ipmid);
		stmt.setString(5, "INPROGRESS");
		stmt.setTimestamp(6, lastModified);*/
		String s="{call insert_wcc(?,?,?,?,?,?,?)}";
		CallableStatement  stmt = con.prepareCall(s);
		stmt.setString(1, IFID);
		stmt.setString(2, file_Name);
		stmt.setTimestamp(3, ts);
		stmt.setString(4, ipmid);
		stmt.setString(5, "INPROGRESS");
		stmt.setTimestamp(6, lastModified);
		stmt.registerOutParameter(7,Types.VARCHAR);  
		stmt.executeUpdate();
		_QFEQLogger.info("Stored Procedure Returned ::  IFID :: "+IFID+" File Name :: "+file_Name+" QFEQIFImagingUtility :: updateLobstar :: insert_wcc :: result " + stmt.getString(7));
		
		QFEQIFDatabaseConn.closeConnection();
		
		}catch(Exception e) {
			_QFEQLogger.info(" file_Name " + file_Name+"   :: Exception "+e.getMessage());
			_QFEQLogger.info("Searching database after exception for IFID " + IFID + " and filename " + file_Name);
			String result = getIPMId(IFID, file_Name, ts);
			if ("norecord".equalsIgnoreCase(result)) {
				throw new SQLException(e.getMessage());
			}else {
				_QFEQLogger.info("Record found for IFID " + IFID + " and filename " + file_Name+" in DB is ::: "+result);
			}
			
		}

	}

}
