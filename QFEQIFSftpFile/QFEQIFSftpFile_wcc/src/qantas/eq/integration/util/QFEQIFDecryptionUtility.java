package qantas.eq.integration.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @purpose QFEQIFDecryptionUtility class contains all the required utility methods to
 *          decrypt a encrypted password and return the same
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */
public class QFEQIFDecryptionUtility {
	
	private static final Logger logger = QFEQIFSftpLogger.getLogger(QFEQIFDecryptionUtility.class.getName());
	
	/**
	 * This method is called to decrypt a encrypted text and return the same
	 * @param  encryptedText
	 * @return decryptedText (Decrypted text)
	 * @throws SQLException
	 */
	public String decryptText(String encryptedText) throws SQLException{
		String decryptedText       = null;
		String sStmt               = "{call QFEQIF_UTIL_PKG.DECRYPT(?, ?)}";
		CallableStatement procStmt = null;
		
		try{
			
			logger.info("Decryption Started");
			Connection conn = QFEQIFDatabaseUtil.getConnection();
		
			procStmt = conn.prepareCall(sStmt);
            procStmt.setString(1, encryptedText);
            procStmt.registerOutParameter(2, java.sql.Types.VARCHAR);

            procStmt.execute();
            logger.info("Executing stored procedure");
            logger.info("procStmt " + procStmt);
            decryptedText = procStmt.getString(2);
            logger.info("decryptedText " + decryptedText);
            logger.info("Decryption completed");
            
		}catch(SQLException sqlException){
			
			logger.log(Level.WARNING,"SQl Exception occured");
			logger.log(Level.SEVERE, sqlException.getMessage(), sqlException);
			throw new SQLException();
			
		}finally{
			
			if(null != procStmt)
				procStmt.close();
			QFEQIFDatabaseUtil.closeConnection();
			
		}
	
		return decryptedText;
	}
	//923018- Error file movement from error to original folder -Start -03_11_21
	
	public void updateWCCStatus(String ifId, String fileName, Timestamp ts) throws SQLException {

		Connection con = QFEQIFDatabaseUtil.getConnection();
		Timestamp lastModified = new Timestamp(System.currentTimeMillis());
		logger.info(fileName+"lastModified :: QFEQIFDecryptionUtility :: SFTPSendFile :: updateIPMId " + lastModified.toString());
		PreparedStatement stmt = con.prepareStatement("update QFEQIF_WCC set STATUS = ?,LAST_UP_DT = ? where IFID = ? AND FILE_NAME = ? AND FILE_CREATION_TIME = ?");
		stmt.setString(1, "INPROGRESS");
		stmt.setTimestamp(2, lastModified);
		stmt.setString(3, ifId);
		stmt.setString(4, fileName);
		stmt.setTimestamp(5, ts);
		logger.info("UPDATE QUERY::: IFID :: "+ifId+" File Name :: "+fileName+" QFEQIFImagingUtility :: updateIPMId :: SFTPSendFile " + stmt.toString());
		stmt.executeUpdate();

		QFEQIFDatabaseUtil.closeConnection();

	}
	//923018- Error file movement from error to original folder -End -03_11_21


}
