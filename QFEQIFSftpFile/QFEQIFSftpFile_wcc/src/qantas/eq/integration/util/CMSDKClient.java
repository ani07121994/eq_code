package qantas.eq.integration.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import oracle.ifs.beans.LibraryService;
import oracle.ifs.beans.LibrarySession;
import oracle.ifs.common.CleartextCredential;
import oracle.ifs.common.IfsException;
import qantas.eq.integration.sftp.QFEQIFSftpFile;

/**
 * @purpose CMSDKClient class contains all the required utility methods to
 *          communicate with the CMSDK server 
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */
public class CMSDKClient {
	
	private LibraryService lService = null;
	private static final Logger logger = QFEQIFSftpLogger.getLogger(CMSDKClient.class.getName());
	
	/**
	 * Create a CMSDK library session and return the same
	 * @param  ifsService
	 * @param  ifsSysPwd
	 * @param  ifsAdminUser
	 * @param  ifsAdminPwd
	 * @return lSession (CMSDK library session to work with)
	 * @throws FileNotFoundException
	 * @throws IfsException
	 * @throws IOException
	 */
	public LibrarySession createLibrarySession(String ifsService, String ifsSysPwd, String ifsAdminUser, String ifsAdminPwd) throws FileNotFoundException, IfsException, IOException{
		
		LibrarySession lSession = null;
		
	    logger.info("LibraryService.isServiceStarted(IfsDefault) = " + LibraryService.isServiceStarted("IfsDefault"));
		if(LibraryService.isServiceStarted(ifsService)){
			lService = LibraryService.findService(ifsService);
		}else{
            String configPath = System.getenv("QFEQIF_CONFIG");
            Properties pro = new Properties();
            pro.load(new FileInputStream(configPath));
            String domain_name = pro.getProperty("IFS_DOMAIN_NAME");
            domain_name = (domain_name == null ? "" : domain_name);
            lService = LibraryService.startService(ifsService, ifsSysPwd, null, domain_name);
		}
		
		CleartextCredential cred = new CleartextCredential(ifsAdminUser, ifsAdminPwd);
		lSession = lService.connect(cred, null);
		lSession.setAdministrationMode(true);
		
		return lSession;
	}
	
	/**
	 * Close any opened library service
	 * @param ifsSysPwd
	 * @throws IfsException
	 */
	public void closeLibraryService(String ifsSysPwd) throws IfsException{
		
		if(null != lService){
			lService.dispose(ifsSysPwd);
		}
	}
	
	/**
	 * Close any opened library session
	 * @param ifsSysPwd
	 * @throws IfsException
	 */
	public void closeLibrarySession(LibrarySession lSession) throws IfsException{
		
		if(null != lSession){
			lSession.disconnect();
		}
	}

}
