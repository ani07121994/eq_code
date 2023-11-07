package qantas.eq.integration.sftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import oracle.ifs.adk.filesystem.IfsFileSystem;
import oracle.ifs.beans.Document;
import oracle.ifs.beans.LibrarySession;
import oracle.ifs.common.IfsException;
import qantas.eq.integration.model.RequestParams;
import qantas.eq.integration.util.CMSDKClient;
import qantas.eq.integration.util.QFEQIFDecryptionUtility;
import qantas.eq.integration.util.QFEQIFSftpLogger;
import qantas.eq.integration.util.UnixUtility;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.FileUtils;

/**
 * @purpose SFTPSendFile webservice is used to copy any file from any given directory of
 *          Oracle CMSDk using cmsdk.jar and transfer the same to any designated directory 
 *          of any SFTP server using jcraft.jar 
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */
@WebService(serviceName = "SendFileToSFTP")
public class QFEQIFSftpFile {
	
	private static final Logger logger = QFEQIFSftpLogger.getLogger(QFEQIFSftpFile.class.getName());
	
	/**
	 * This method entry point of the web service and handles all the file moving activities form 
	 * CMSDK to SFTP
	 * @param  requestParams (A POJO contains all the required request parameters)
	 * @return True, if the file movement is successful end to end
	 *         False, if there is any exception happened during the file movement 
	 * @throws Exception
	 */
	@WebMethod(operationName = "SFTPSendFile")
	public boolean SFTPSendFile(@WebParam(name = "requestParams") RequestParams requestParams) throws Exception{
		
		Session session         = null;
		Channel channel         = null;
		ChannelSftp channelSftp = null;
		InputStream fis         = null;
		//LibrarySession lSession = null;
		
		SFTPClient sftpClient                  = new SFTPClient();
		//CMSDKClient cmsdkClient                = new CMSDKClient();
		QFEQIFDecryptionUtility decryptUtility = new QFEQIFDecryptionUtility();
		
		String fileNmae          = requestParams.getFILE_NAME();                                 // File name in CMSDK
		String sourceFolder      = requestParams.getSOURCE_FOLDER();                             // Folder name where the file present in CMSDK
		//String IFSAdminUser      = requestParams.getIFS_ADMIN_USER();                            // CMSDK admin user
		//String IFSAdminPwd       = decryptUtility.decryptText(requestParams.getIFS_ADMIN_PWD()); // CMSDK admin password
		//String IFSService        = requestParams.getIFS_SERVICE();                               // CMSDK service name
		//String IFSSysPwd         = decryptUtility.decryptText(requestParams.getIFS_SYS_PWD());   // CMSDK system password
		String SFTPHost          = requestParams.getSFTP_HOST();                                 // SFTP host
		int    SFTPPort          = requestParams.getSFTP_PORT();                                 // SFTP port
		String SFTPAuthType      = requestParams.getSFTP_AUTH_TYPE();                            // SFTP authentication type
		String SFTPUser          = requestParams.getSFTP_USER();                                 // SFTP user
		String SFTPPwd           = null;                                                         // SFTP password
		String SFTPSSHKey        = null;                                                         // SSH key path
		String destinationFolder = requestParams.getDESTINATION_FOLDER();                        // Destination folder where the file should be copied in SFTP server
		String SFTPFileName      = requestParams.getSFTP_FILENAME();                             // Name of the file appeared after copying the file in SFTP server
		String ifid				 =  requestParams.getIFID() ;////923018- Error file movement from error to original folder
		String absoultePath  	 = null;						 								 // Absolute File Path
		InputStream fileIns  	 = null;
		UnixUtility unixUtility  = new UnixUtility();
		boolean isDeleted		 = false;
		if(requestParams.getSFTP_PWD().length() > 0)
			SFTPPwd = decryptUtility.decryptText(requestParams.getSFTP_PWD());
		
		if(requestParams.getSFTP_SSH_KEY_LOCATION().length() > 0)
			SFTPSSHKey = requestParams.getSFTP_SSH_KEY_LOCATION();
		
		try{
			logger.info("source File name" + fileNmae);
			//Connecting to SFTP
			session = sftpClient.openSFTPSession(SFTPHost, SFTPUser, SFTPPwd, SFTPSSHKey, SFTPPort, SFTPAuthType);
			channel = sftpClient.openSFTPChannel(session);
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(destinationFolder);
			logger.info("Connected to SFTP host " + SFTPHost);
			
			//Connecting to Oracle CMSDK
			/*lSession = cmsdkClient.createLibrarySession(IFSService, IFSSysPwd, IFSAdminUser, IFSAdminPwd);
			logger.info("Connected to IFS service " + IFSService);*/
			
			//Getting the file from CMSDK
			//IfsFileSystem ifs = new IfsFileSystem(lSession);
			logger.info("SourceFolder " + sourceFolder);
			
			String origSourcFol=sourceFolder;  //923018- Error file movement from error to original folder
			File targetFile=null;  //923018- Error file movement from error to original folder
			File srcFile=null;//923018- Error file movement from error to original folder
			if(sourceFolder.endsWith("/")){
				try {
				//Document doc = (Document)ifs.findPublicObjectByPath(sourceFolder + fileNmae);
				//fis = ifs.getDocumentContent(doc);
				File file = new File(sourceFolder + fileNmae);
				
				 targetFile=file;
				fis = new FileInputStream(file);
				}
				catch(Exception e)
				{
					logger.log(Level.WARNING,"Exception occured while trying to read file from source location");
					logger.log(Level.SEVERE, e.getMessage(), e);
					sourceFolder = (sourceFolder.substring(0, sourceFolder.length()-1));
					sourceFolder = (sourceFolder.substring(0, sourceFolder.lastIndexOf("/") + 1) + "error");
					logger.info("Checking in Error Folder " + sourceFolder);
					//Document doc = (Document)ifs.findPublicObjectByPath(sourceFolder + File.separator + fileNmae);
					//fis = ifs.getDocumentContent(doc);
					File file = new File(sourceFolder + File.separator + fileNmae);
					srcFile=file;
					fis = new FileInputStream(file);
				}
				//Try Catch Block added
			}
			else{
				try {
				//Document doc = (Document)ifs.findPublicObjectByPath(sourceFolder + File.separator + fileNmae);
				//fis = ifs.getDocumentContent(doc);
				File file = new File(sourceFolder + File.separator + fileNmae);
				targetFile=file;
				fis = new FileInputStream(file);
				}
				catch(Exception e)
				{
					logger.log(Level.WARNING,"Exception occured while trying to read file from source location");
					logger.log(Level.SEVERE, e.getMessage(), e);
					sourceFolder = (sourceFolder.substring(0, sourceFolder.lastIndexOf("/") + 1) + "error");
					logger.info("Checking in Error Folder " + sourceFolder);
					//Document doc = (Document)ifs.findPublicObjectByPath(sourceFolder + File.separator + fileNmae);
					//fis = ifs.getDocumentContent(doc);
					File file = new File(sourceFolder + File.separator + fileNmae);
					srcFile=file;
					fis = new FileInputStream(file);
				}
				//Try Catch Block added
			}
			//logger.info("Acquired the file " + fileNmae + " from CMSDK");
			logger.info("Acquired the file " + fileNmae + " from source Location: " + sourceFolder);
			if(destinationFolder.endsWith("/"))
			{
				absoultePath = destinationFolder + SFTPFileName;	
			}
			else
			{
				absoultePath = destinationFolder + File.separator + SFTPFileName;
			}
			//Modified on 6th Nov 2019
			/*if(fileNmae.indexOf(".pgp") == -1)
			{
				fileIns = unixUtility.copyFile(fis,SFTPFileName);
			}
			else
			{
				fileIns = fis;
			}*/
			
			//Upload the file into SFTP 
			channelSftp.put(fis, SFTPFileName, channelSftp.OVERWRITE);
			//End of Modification
			channelSftp.chmod(Integer.parseInt("777", 8), absoultePath);  							//Setting the Permissions for individual files
			logger.info("Absolute Path" + absoultePath);
			logger.info("Uploaded the file " + fileNmae + " successfully into SFTP");
			logger.info("sourceFolder :: before contais :: "+sourceFolder);
			//923018- Error file movement from error to original folder -Start -03_11_21
			if(sourceFolder !=null && sourceFolder .contains("error")) {
				logger.info(" ::inside sourcefoler :: ");
				try {
					if (srcFile.exists()) {
						logger.info(" ::inside srcfile.exists :: ");
						Timestamp ts = new Timestamp(srcFile.lastModified());
						decryptUtility.updateWCCStatus(ifid, fileNmae, ts);
						logger.info(fileNmae+" Database Update successfull  srcFile ::" + srcFile.getName() + " targetFile ::: "
								+ targetFile.getName());
						// File sourceFile =new file(sourceFolder+"/"+)
						
						FileUtils.copyFile(srcFile, targetFile);

						srcFile.delete();
					} else {
						logger.info(fileNmae+" No File exist in Src location  " + sourceFolder);
					}
				} catch (Exception e) {
					logger.info(fileNmae+" Exception Occcured during copyFile " + e.getMessage());
				}
			}
			
			//923018- Error file movement from error to original folder -End -03_11_21
			/*if(fileNmae.indexOf(".pgp") == -1)
			{
				isDeleted = unixUtility.deleteFileFromLocal(SFTPFileName);
			}
			logger.info("File Deleted" + isDeleted);*/
			
			
		}catch(JSchException sftpException){
			
			logger.log(Level.WARNING,"SFTP exception occured");
			logger.log(Level.SEVERE, sftpException.getMessage(), sftpException);
			throw new JSchException(sftpException.getMessage(), sftpException);
			
		}catch(Exception exception){
			
			logger.log(Level.WARNING,"Exception occured");
			logger.log(Level.SEVERE, exception.getMessage(), exception);
			throw new Exception(exception.getMessage(), exception);
			
		}finally{
			
			try{
				if(null != fis)
					fis.close();
				if(null != fileIns)
					fileIns.close();
				sftpClient.closeSFTPSession(session);
				sftpClient.closeChannel(channel);
				sftpClient.closeChannelSFTP(channelSftp);
				//changed for CMSDK transition
				//cmsdkClient.closeLibrarySession(lSession);
				//cmsdkClient.closeLibraryService(IFSSysPwd);

			}catch(Exception exception){
				
				logger.log(Level.WARNING,"Exception while closing resources");
				logger.log(Level.SEVERE, exception.getMessage(), exception);
				
			}
		}
		
		return true;
	}
	
}
