//
// Copyright (c) 2002 Oracle Corp
// System       : eQ
// Subsystem    : Integration
// File         : QFEQIFFtpGetFile.java
// Classes      : QFEQIFFtpGetFile
//
// Change History
// Date     Version	Author      Description
// ----     ------- ------      ------------
// 03/02/04	1.2	    Luke Lam    Set resultOut to error if can't find or get the remote file. remoteFileName is not used.
// 15/12/03	1.1	    Luke Lam    Used WF_FTP_FILENAME for ftpget and FILE_NAME for ifs save.
// 10/1/03	1.0	    Luke Lam    Created.
//

package qantas.integration.util;

import java.io.BufferedInputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.ifs.common.IfsException;
import qantas.integration.util.ftp.QFEQIFFtpClientIOFilePoll;


/**
 * The QFEQIFFtpGetFile class extends the WFFunctionAPI class, which provides class variables and methods
 * that are essential to the operation of the external Java function activity. It provides the
 * ftp get file functionality from remote ftp server to iFS.
 *
 * @author Oracle Consulting
 * @version $version$
 *
 * @see QFEQIFMoveFile
 */
public class QFEQIFFtpGetFileIOFilePoll extends QFEQIFWorkflowBaseIOFilePoll
{
	private static final Logger logger = QFEQIFLoggerIOFilePoll.getLogger(QFEQIFFtpGetFileIOFilePoll.class.getName());
    private final String CLASS_NAME = getClass().getName();
    private static String resultOut = "";

    /**
    * Moves an Oracle 9iFS document from one folder to another.
    * The custom Java class must implement the boolean execute() method.
    * This method is the main entry point to call Oracle 9iFS APIs.
    *
    * @param p_WCtx the workflow context
    * @return true if it executes successfully.
    */
    public boolean execute(String FILE_NAME, String TARGET_FOLDER, String ifsAdminUser, String ifsAdminPwd, String ifsService, String ifsSysPwd, String wfFtpHost, String wfFtpPort, String wfFtpUser, String wfFtpPwd, String wfFtpPath, String attrib1, String attrib2, String xferMode)
    {
        final String METHOD_NAME = CLASS_NAME + ".execute";
        logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);
        
        resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_SUCCESS;
        
        // get an instance of iFS
        QFEQIFCMSDKUtilSOAIOFilePoll ifsUtil = null;
        
        //get crypto instance for pwd decryption
        Connection conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
        QFEQIFCryptoSOAIOFilePoll crypto = new QFEQIFCryptoSOAIOFilePoll(conn);
        Socket sock = null;
        QFEQIFFtpClientIOFilePoll ftpClient = null;
        BufferedInputStream reader = null;
        
        try
        {
            //Retrieve attributes from a Workflow instance
            m_fileName = FILE_NAME;
            
            m_targetFolder = TARGET_FOLDER;
        
            //get ifs credentials
            //ftp get the file first
            ftpClient = new QFEQIFFtpClientIOFilePoll(isBinaryXfer(xferMode), isPassive(attrib1));
            boolean l_isConnected = ftpClient.connect(wfFtpHost, Integer.parseInt(wfFtpPort), wfFtpUser, crypto.decrypt(wfFtpPwd));
            
            if(l_isConnected)
            {
                if(!wfFtpPath.equals(QFEQIFConstantIOFilePoll.BLANK))
                {
                    if(!ftpClient.changeDir(wfFtpPath))
                        resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR;
                }
                if(resultOut != QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR)
                {
                    //get the socket for file retrieve
                    sock = ftpClient.getDataSocket(ftpClient.FTP_CMD_RETR + m_fileName);
                    if(sock!=null)
                    {
                        // Read bytes from server
                        reader = new BufferedInputStream(sock.getInputStream());
        
                        // get an instance of iFS
                        ifsUtil = new QFEQIFCMSDKUtilSOAIOFilePoll(ifsAdminUser, crypto.decrypt(ifsAdminPwd), ifsService, crypto.decrypt(ifsSysPwd));
                        if(ifsUtil.getErrorFlag())
                        {
                            resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR;
                        } else {
                            //create the file in iFS
                            ifsUtil.createDocStream(m_targetFolder, m_fileName, reader);
                        }
                    }   
                    else // can't get/find the specified file.
                    {
                        // v1.2 update
                        logger.info("Cannot get/find the remote file: "+m_fileName);
                        resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR; 
                    }
                }
                //ftpClient.logout();
            }
            else //ftp connect fails
            {
                resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_FTP_ERROR;
            }
        } catch (IfsException ie) {
            resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR;
            logger.info("IfsException caught: "+ie.getMessage());
            return false; //don't return false! this will cause the workflow process to stall!
        } catch (Exception e) {
            resultOut = QFEQIFConstantIOFilePoll.WF_FTP_RCODE_ERROR;
            logger.info("Exception caught: "+e.getMessage());
       
            return false; //don't return false! this will cause the workflow process to stall!
        }finally{
        	/*Added by Subhadip - 09Sep2017*/
        	try{
        		if(null != sock){				// Closing Socket
        			sock.close();
        			logger.info("Socket closed successfully");
        		}
        			
        		if(null != ftpClient){			// Logout from FTP Client
        			ftpClient.logout();
        			logger.info("Logged out from FTP Client successfully");
        		}
        		if(null != reader){        		// Close the BufferedReader
        			reader.close();
        			logger.info("BufferedReader closed successfully");
        		}
        		if(null != ifsUtil){       		// Dispose iFS service
        			ifsUtil.disconnectSession();
        			logger.info("Ifs service disposed successfully");
        		}
        		if(null != conn){				// Closing DB connection
        			conn.commit();
        			conn.close();
        			QFEQIFDatabaseConnIOFilePoll.closeConnection();
        			logger.info("DB connection closed successfully");
        		}
        	}catch(Exception e){
        		logger.info("Method Name :" + METHOD_NAME);
        		logger.log(Level.WARNING, "Exception occured in while closing resources  ");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        }
        
        logger.info("resultOut: "+resultOut);
        logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
        if("ERROR".equals(resultOut.trim())){
        	return false;
        }
        
        return true;
    }
}

