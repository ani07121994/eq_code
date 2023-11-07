//
// Copyright (c) 2002 Oracle Corp
// System       : eQ
// Subsystem    : Integration
// File         : QFEQIFCMSDKUtil.java
// Classes      : QFEQIFCMSDKUtil
//
// Change History
// Date     Version	Author      Description
// ----     ------- ------      ------------
// 21/07/04 1.3     Luke Lam    Added processStuckEmails.
// 04/12/03 1.2     Luke Lam    Added deleteobject fcn.
// 24/09/03 1.3     Luke Lam    Added get lob content. 
// 15/09/03 1.2     Luke Lam    Added update lobster. 
// 05/09/03 1.1     Luke Lam    Added email detachment. 
// 12/12/02 1.0	    Luke Lam    Created.
//

package qantas.integration.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.ifs.adk.filesystem.IfsFileSystem;
import oracle.ifs.beans.LibraryService;
import oracle.ifs.beans.LibrarySession;
import oracle.ifs.beans.PublicObject;
import oracle.ifs.common.CleartextCredential;
import oracle.ifs.common.IfsException;


/**
 * The QFEQIFCMSDKUtil class contains iFS utility functionalities such as move file etc.
 *
 * @author Oracle Consulting
 * @version $version$
 *
 * @see QFEQIFConstant
 */
public class QFEQIFCMSDKUtilSOA
{
	private static final Logger logger = QFEQIFLogger.getLogger(QFEQIFCMSDKUtilSOA.class.getName());
    private final String CLASS_NAME = getClass().getName();

    private LibraryService m_service = null;
    private LibrarySession m_session = null;
    private String m_ifsSysPwd;
    boolean m_errorFlag = false;

     /**
      * Default constructor
      *
      * @param p_ifsAdminUser the ifs admin user
      * @param p_ifsAdminPwd the ifs admin pwd
      * @param p_ifsService the ifs service
      * @param p_ifsSysPwd the ifs sys user pwd
      *
      */
	public QFEQIFCMSDKUtilSOA(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd)
	{
	    m_ifsSysPwd = p_ifsSysPwd;
	    m_session = createLibrarySession(p_ifsAdminUser, p_ifsAdminPwd, p_ifsService, p_ifsSysPwd);
	}

	public QFEQIFCMSDKUtilSOA(LibrarySession p_libs)
	{
		m_session = p_libs;
	}
	  
	public QFEQIFCMSDKUtilSOA()
	{
	}
	
 /**
  * This method is called by the constructor to create a LibrarySession.
  *
  * @param p_ifsAdminUser the ifs admin user
  * @param p_ifsAdminPwd the ifs admin pwd
  * @param p_ifsService the ifs service
  * @param p_ifsSysPwd the ifs sys user pwd
  * @return the libryary session
  *
  */
	private LibrarySession createLibrarySession(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd)
	{
	    final String METHOD_NAME = CLASS_NAME + ".createLibrarySession";
        logger.info(QFEQIFConstant.ENTER + METHOD_NAME);
	    LibrarySession lsession = null;
	    FileInputStream fis = null;
	    
	    try
	    {
                if(LibraryService.isServiceStarted(p_ifsService))
                {
                    m_service = LibraryService.findService(p_ifsService);
                    logger.info("Library Service for CMSDK has been started already");
                }
                else
                {
                	logger.info("Trying to start Library Service for CMSDK");
                    //Create an Oracle 9iFS LibrarySession.
                    String configPath = System.getenv("QFEQIF_CONFIG");
                    Properties pro = new Properties();
                    fis = new FileInputStream(configPath);
                    pro.load(fis);

                    String domain_name = pro.getProperty("IFS_DOMAIN_NAME");
                    domain_name = (domain_name == null ? "" : domain_name);
                    logger.info("Domain Name :" + domain_name);
                    m_service = LibraryService.startService(p_ifsService, p_ifsSysPwd, null, domain_name);
                    logger.info("Library Service for CMSDK started successfully");
                }
                CleartextCredential cred = new CleartextCredential(p_ifsAdminUser, p_ifsAdminPwd);
                lsession = m_service.connect(cred, null);
                lsession.setAdministrationMode(true);
	    }
	    catch (IfsException e)
	    {
                IfsException.setVerboseMessage(true);
                logger.log(Level.WARNING, "Exception in createLibrarySession(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd) method ");
            	logger.log(Level.SEVERE, e.getMessage(), e);
                m_errorFlag = true;
	    }
	    catch (Exception ex)
	    {
	    	logger.log(Level.WARNING, "Exception in createLibrarySession(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd) method ");
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
	    	m_errorFlag = true;
	    }
	    finally{
	    	try{
	    		if(null != fis)
		    		fis.close();
	    	}catch(Exception e){
	    		logger.log(Level.WARNING, "Exception while closing the property file ");
	        	logger.log(Level.SEVERE, e.getMessage(), e);
	    	}
	    	
	    }
	    
        return lsession;
 }

 /**
  * Creates the specified document from its stream.
  *
  * @param p_filePath Full path of the file
  * @param p_fileName just the file name
  * @param p_contentStream the content stream
  * @return true if successful
  *
  * @exception IfsException and/or IOException if an error occurs.
  */
	public boolean createDocStream(String p_filePath, String p_fileName, InputStream p_contentStream) throws IfsException, IOException
	{
	    final String METHOD_NAME = CLASS_NAME + ".createDocStream";
	    logger.info(QFEQIFConstant.ENTER + METHOD_NAME);
	
	  	IfsFileSystem ifs = new IfsFileSystem(m_session);
	
	    // Check if the file exists
	    PublicObject po = null;
	    try {
	    	po = ifs.findPublicObjectByPath(p_filePath + QFEQIFConstant.PATH_DELIMITER + p_fileName);
	    } catch(IfsException fex) {
	    	po = null;
	    	logger.info("Can't find this file. "+p_fileName);
	    	logger.log(Level.WARNING, "Exception occured in createDocStream(String p_filePath, String p_fileName, InputStream p_contentStream) method ");
        	logger.log(Level.SEVERE, fex.getMessage(), fex);
	    }
	
	    if(po != null) // file exists the remove it
	    {
	      try {
	        ifs.delete(po);
	        logger.info("Previous file deleted. "+p_fileName);
	      } catch(IfsException fex) {        
	        logger.info("Can't delete this file! "+p_fileName);
	        logger.log(Level.WARNING, "Exception occured in createDocStream(String p_filePath, String p_fileName, InputStream p_contentStream) method ");
        	logger.log(Level.SEVERE, fex.getMessage(), fex);
	      }
	    }
        // Now create the file.
	    ifs.createDocument(p_fileName, p_contentStream, p_filePath, null, false, null);
	    
	    logger.info("New file created. "+p_fileName);
	    logger.info(QFEQIFConstant.EXIT + METHOD_NAME);
	    
	    return true;
  }

  /**
    * Creates the specified document from local file
    *
    * @param p_filePath Full path of the file
    * @param p_fileName just the file name
    * @param p_conn the db conn where the lob is stored
    * @return true if successful
    *
    * @exception IfsException and/or IOException if an error occurs.
    */
    public boolean createDocRef(String p_filePath, String p_fileName, Connection p_conn, String localPath) throws Exception
    {
        final String METHOD_NAME = CLASS_NAME + ".createDocRef";
        logger.info(QFEQIFConstant.ENTER + METHOD_NAME);
        String FileGet = "" + localPath + "" + p_fileName;
        logger.info("File name " + FileGet);
        boolean bStatus = false;
        FileInputStream fis = null;
        File file = null;
        try {
            file = new File(FileGet);
            
            fis = new FileInputStream(file);
            createDocStream(p_filePath, p_fileName,fis);
            file.delete();
            bStatus = true;
            logger.info(QFEQIFConstant.EXIT + METHOD_NAME);
        } catch(IfsException ifex) {
        	logger.log(Level.WARNING, "createDocRef(String p_filePath, String p_fileName, Connection p_conn, String localPath) method");
        	logger.log(Level.SEVERE, ifex.getMessage(), ifex);
            throw new Exception("Error creating document in CM SDK.");
        } catch(IOException ioex) {
        	logger.log(Level.WARNING, "createDocRef(String p_filePath, String p_fileName, Connection p_conn, String localPath) method");
        	logger.log(Level.SEVERE, ioex.getMessage(), ioex);
            throw new Exception("Error reading file from local folder.");
        }finally{
        	if(null != fis){
        		fis.close();
        	}
        }
        return bStatus;
      }
  
    /**
    * Disconnects from iFS
    * @exception IfsException if an ifs error occurs.
    */
    public void disconnectSession() throws IfsException
    {
        if(m_session != null)
        {
            logger.info("About to disconnectSession");
            m_session.disconnect();
            m_session = null;
        }
    }

    /**
    * Dispose the service
    * @exception IfsException if an ifs error occurs.
    */
    public void disconnectService() throws IfsException
    {
        if(m_service != null)
        {
            m_service.dispose(m_ifsSysPwd);
            m_service = null;
        }
    }
    
    /**
     * Get error flag
     * @returns the error flag
     */
       public boolean getErrorFlag()
       {
               return m_errorFlag;
       }
}
