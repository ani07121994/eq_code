//
// Copyright (c) 2002 Oracle Corp
// System       : eQ
// Subsystem    : Integration
// File         : QFEQIFFtpDeleteFile.java
// Classes      : QFEQIFFtpDeleteFile
//
// Change History
// Date     Version	Author      Description
// ----     ------- ------      ------------
// 03/02/04	1.0	    Luke Lam    Created.
//

package qantas.integration.util;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import qantas.integration.util.ftp.QFEQIFFtpClientIOFilePoll;


/**
 * The QFEQIFFtpDeleteFile class extends the WFFunctionAPI class.
 * It provides the ftp delete file functionality.
 *
 * @author Oracle Consulting
 * @version $version$
 *
 * @see QFEQIFMoveFile
 */
public class QFEQIFFtpDeleteFileIOFilePoll extends QFEQIFWorkflowBaseIOFilePoll
{
    private final String CLASS_NAME = getClass().getName();
    private static final Logger logger = QFEQIFLoggerIOFilePoll.getLogger(QFEQIFFtpDeleteFileIOFilePoll.class.getName());
    private static String resultOut = "";
    
    /**
    * Deletes the remote file.
    * The custom Java class must implement the boolean execute() method.
    * This method is the main entry point to call Oracle 9iFS APIs.
    *
    * @param p_WCtx the workflow context
    * @return true if it executes successfully.
    */

    public boolean execute(String remoteFileName, String wfFtpHost, String wfFtpPort, String wfFtpUser, String wfFtpPwd, String wfFtpPath, String attrib1, String attrib2, String xferMode)
    {
        final String METHOD_NAME = CLASS_NAME + ".execute";
        logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);
        
        resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_SUCCESS;
        
        //get crypto instance for pwd decryption
        Connection conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
        QFEQIFCryptoSOAIOFilePoll crypto = new QFEQIFCryptoSOAIOFilePoll(conn);
        QFEQIFFtpClientIOFilePoll	ftpClient = null;
    
        try
        {   
            //ftp get the file first
            ftpClient = new QFEQIFFtpClientIOFilePoll(isBinaryXfer(xferMode), isPassive(attrib1));
            boolean l_isConnected = ftpClient.connect(wfFtpHost, Integer.parseInt(wfFtpPort), wfFtpUser, crypto.decrypt(wfFtpPwd));
            
            if(l_isConnected) {
                if(!wfFtpPath.equals(QFEQIFConstantIOFilePoll.BLANK)) {
                    ftpClient.changeDir(wfFtpPath);
                }
                
                // Now delete the file
                if(!ftpClient.delete(remoteFileName))
                {
                    // can't delete ie permission denied or can't find the specified file.
                    logger.info("Cannot delete/find the remote file: "+(wfFtpPath.equals(QFEQIFConstantIOFilePoll.BLANK)?QFEQIFConstantIOFilePoll.BLANK:"/")+remoteFileName);
                    resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR;
                }
                
            }
            else //ftp connect fails
            {
                resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_FTP_ERROR;
            }
        } catch (Exception e) {
            resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR;
            logger.info("Exception caught: "+e.getMessage());
            logger.log(Level.WARNING, "Exception occured in execute(String remoteFileName, String wfFtpHost, String wfFtpPort, String wfFtpUser, String wfFtpPwd, String wfFtpPath, String attrib1, String attrib2, String xferMode) method");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        }
        finally{
        	try{
        		if(null != ftpClient)
        			ftpClient.logout();
        		if(null != conn){
        			conn.commit();
        			conn.close();
        			QFEQIFDatabaseConnIOFilePoll.closeConnection();
        		}
        	}catch(Exception e){
        		logger.info("Method Name :" + METHOD_NAME);
        		logger.log(Level.WARNING, "Exception occured while closing resources");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}	
        }
        
        logger.info("resultOut: "+resultOut);
        logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
        return true;
    }
}

