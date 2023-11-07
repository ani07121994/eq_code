package qantas.integration.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @purpose DecryptionUtility class contains all the required utility methods to
 *          decrypt a encrypted password and return the same
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */
public class DecryptionUtility {
	
	private static final Logger logger = SFTPLogger.getLogger(DecryptionUtility.class.getName());
	
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
			Connection conn = DatabaseConn.getConnection();
		
			procStmt = conn.prepareCall(sStmt);
            procStmt.setString(1, encryptedText);
            procStmt.registerOutParameter(2, java.sql.Types.VARCHAR);

            procStmt.execute();
            logger.info("Executing stored procedure");
            logger.info("procStmt " + procStmt);
            decryptedText = procStmt.getString(2);
            logger.info("decryptedText " + decryptedText);
            logger.info("Decryption completed");
            
		}
		catch(SQLException sqlException) {
			
			logger.log(Level.WARNING,"SQl Exception occured");
			logger.log(Level.SEVERE, sqlException.getMessage(), sqlException);
			throw new SQLException();
			
		}finally {
			
			if(null != procStmt)
				procStmt.close();
			DatabaseConn.closeConnection();
			
		}
	
		return decryptedText;
	}


}
