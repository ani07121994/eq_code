package qantas.integration.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QFEQIFCryptoSOA{

	private static final Logger logger = QFEQIFLogger.getLogger(QFEQIFCryptoSOA.class.getName());
    private Connection m_conn = null;
    private final String CLASS_NAME = getClass().getName();
	
    public QFEQIFCryptoSOA(Connection p_conn)
    {   
        m_conn = p_conn;
    }
	
    public QFEQIFCryptoSOA()
    {

    }
    
    public String decrypt(String p_encryptedText)
    {
        final String METHOD_NAME = CLASS_NAME + ".decrypt";
        logger.info(QFEQIFConstant.ENTER + METHOD_NAME);

        String decryptedText = null;
        CallableStatement procStmt = null;

        try {
            String sStmt = "{call QFEQIF_UTIL_PKG.DECRYPT(?, ?)}";

            procStmt = m_conn.prepareCall(sStmt);

            //set input parameters
            procStmt.setString(1, p_encryptedText);

            procStmt.registerOutParameter(2, java.sql.Types.VARCHAR);

            procStmt.execute();
            decryptedText = procStmt.getString(2);
        } catch (SQLException ex) {
        	logger.log(Level.WARNING, "Exception occured in decrypt(String p_encryptedText) method ");
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
        	logger.log(Level.WARNING, "Exception occured in decrypt(String p_encryptedText) method ");
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
        }finally{
        	try{
        		if(null != procStmt){
            		procStmt.close();
            	}
        	}catch(Exception e){
        		logger.log(Level.WARNING, "Exception occured in decrypt(String p_encryptedText) method while closing the Callable Statement");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        	
        }

      logger.info(QFEQIFConstant.EXIT + METHOD_NAME);
      return decryptedText;
    }
}
