package qantas.eq.fault;

//import client.MoveFileCMSDK;

//import client.QFEQIFMoveFileSOA;

import com.collaxa.cube.engine.fp.BPELFaultRecoveryContextImpl;

import com.oracle.bpel.client.BPELFault;

import java.io.File;

//import com.oracle.cmsdkMoveFile.MoveFileCMSDK;
//import com.oracle.cmsdkMoveFile.QFEQIFMoveFileSOAPortClient;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;

import oracle.integration.platform.faultpolicy.IFaultRecoveryContext;
import oracle.integration.platform.faultpolicy.IFaultRecoveryJavaClass;

//import oracle.xml.parser.v2.XMLElement;

import oracle.xml.parser.v2.XMLElement;
import qantas.eq.utility.ImagingUtility;
import qantas.imaging.webservice.ImagingDoc;
import qantas.imaging.webservice.ImagingServiceImpl;

public class FaultManagementSample implements IFaultRecoveryJavaClass {
	//private static MoveFileCMSDK moveFileCMSDK;

	public FaultManagementSample() {
		super();
		System.out.println(".....In FaultManagementSample..................................... ");
	}

	public void handleRetrySuccess(IFaultRecoveryContext iFaultRecoveryContext) {

		try {
			System.out.println("**** handleRetrySuccess() method called ...");

			String sourceFolder = null;
			String fileName = null;
			String targetFolder = null;

			BPELFaultRecoveryContextImpl faultImpl = (BPELFaultRecoveryContextImpl) iFaultRecoveryContext;

			XMLElement inputXMLElement = (XMLElement) faultImpl.getVariableData("FileDirectory");
			sourceFolder = inputXMLElement.getText();
			System.out
					.println("=========In retry Success==============" + sourceFolder + "===========================");

			String overWriteFlag = "Y";
			boolean returnStatus = true;
			XMLElement inputXMLElementForFileName = (XMLElement) faultImpl.getVariableData("FileName");
			fileName = inputXMLElementForFileName.getText();

			System.out.println("File Name::::from handleRetrySuccess::::::::::::::::::" + fileName);

			targetFolder = sourceFolder.substring(0, sourceFolder.lastIndexOf("/") + 1);

			targetFolder = targetFolder + "error";
			// Source Folder would be /Error and Target would be /archive
			sourceFolder = targetFolder;

			targetFolder = sourceFolder.substring(0, sourceFolder.lastIndexOf("/") + 1);

			targetFolder = targetFolder + "archive";

//            QFEQIFMoveFileSOA _QFEQIFMoveFileSOA = new QFEQIFMoveFileSOA(); 
//            returnStatus = _QFEQIFMoveFileSOA.execute(fileName,sourceFolder,targetFolder,overWriteFlag);;
			System.out.println("returnStatus:::in RETRY SUCCESS::::::" + returnStatus);
			System.out.println("================================================================================");
			this.printValues(iFaultRecoveryContext);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String handleFault(IFaultRecoveryContext iFaultRecoveryContext) {
		boolean notificationResult = false;
		String finalUrl = null;
		BPELFault bpelFault = null;
		HashMap returnMap = new HashMap();
		Properties _prop = new Properties();
		String ifsAdminUser = null;
		String ifsAdminPwd = null;
		String ifsService = null;
		String ifsSysPwd = null;
		String overWriteFlag = "Y";
		XMLElement faultMessageBodyXml = null;
		String errorCheck = null;

		try {

			System.out.println("**** handleFault() method called ...");
			System.out.println("iFaultRecoveryContext" + iFaultRecoveryContext);
			this.printValues(iFaultRecoveryContext);

			// To get the property values - getProperties() is an user defined method
			_prop = getProperties();

			StringBuffer sbQuery = new StringBuffer();
			sbQuery.append("http://");

			sbQuery.append(_prop.getProperty("adminServerIP"));
			sbQuery.append(":");
			sbQuery.append(_prop.getProperty("adminServerPort"));

			sbQuery.append("/em/faces/ai/soa/messageFlow?target=/");
			sbQuery.append("Farm_" + _prop.getProperty("domainName"));

			sbQuery.append("/");
			sbQuery.append(_prop.getProperty("domainName"));

			sbQuery.append("/");
			sbQuery.append(_prop.getProperty("managedServerName"));

			sbQuery.append("/");
			sbQuery.append(_prop.getProperty("partitionName"));

			sbQuery.append("/");

			if (iFaultRecoveryContext instanceof BPELFaultRecoveryContextImpl) {
				BPELFaultRecoveryContextImpl faultImpl = (BPELFaultRecoveryContextImpl) iFaultRecoveryContext;

				sbQuery.append(faultImpl.getCompositeName());
				sbQuery.append("%20");
				sbQuery.append("[");
				sbQuery.append(faultImpl.getProcessDN().getRevision());
				sbQuery.append("]");
				sbQuery.append("&type=oracle_soa_composite&soaContext=");
				sbQuery.append(_prop.getProperty("partitionName"));
				sbQuery.append("/");
				sbQuery.append(faultImpl.getCompositeName());
				sbQuery.append("!");
				sbQuery.append(faultImpl.getProcessDN().getRevision());
				sbQuery.append("/");
				sbQuery.append(faultImpl.getCompositeInstanceId());

				finalUrl = sbQuery.toString();

				System.out.println("finalUrl:::::::::::::::::::::::::::::::::::::" + finalUrl);

				// For logging
				System.out.println("-------------------------================------------------------");
				System.out.println("CompositeInstanceID :" + faultImpl.getCompositeInstanceId());
				System.out.println("CompositeName :" + faultImpl.getCompositeName());
				System.out.println("CompositeRevision :" + faultImpl.getProcessDN().getRevision());
				System.out.println("Title :" + faultImpl.getTitle());

				System.out.println("========================================================================");

				bpelFault = faultImpl.getFault();

				String _faultMessageBody = null;
				String _faultMessageSub = null;
				String _adminMailId = null;
				//////////////////////////////////// Moving a File /////////////////////////
				String sourceFolder = null;
				String targetFolder = null;
				String fileName = null;
				String fileDirectory = null;

				System.out.println("#######################################################################");

				System.out.println("Class fault body before ..........."
						+ faultImpl.getVariableData("FaultMessageBody").getClass());
				System.out.println(" fault body before ..........." + faultImpl.getVariableData("FaultMessageBody"));

				System.out.println(
						"Fault Message Body::::::::::" + faultImpl.getVariableData("FaultMessageBody").getClass());

				if (String.valueOf(faultImpl.getVariableData("FaultMessageBody")).equalsIgnoreCase("EBSERROR")) {
					System.out.println("in if block");
					_faultMessageBody = bpelFault.getMessage();
				} else {
					_faultMessageBody = (String) faultImpl.getVariableData("FaultMessageBody");
				}

				System.out.println("_faultMessageBody::::::" + _faultMessageBody);

				if (String.valueOf(faultImpl.getVariableData("FaultMessageBody")).equalsIgnoreCase("EBSERROR")) {
					System.out.println("In if block");
					_faultMessageSub = bpelFault.getMessage();
					_faultMessageSub = "Failure Notification of Inbound Interface";
				} else
					_faultMessageSub = (String) faultImpl.getVariableData("FaultMessageSub");

				System.out.println("_faultMessageSub::::::" + _faultMessageSub);

				XMLElement inputXmlAdminMailID;

				inputXmlAdminMailID = (XMLElement) faultImpl.getVariableData("AdminMailId");
				_adminMailId = inputXmlAdminMailID.getText();

				// _adminMailId = (String)faultImpl.getVariableData("AdminMailId");

				System.out.println("_adminMailId::::::::::::::::::::" + _adminMailId);

				System.out.println("#######################################################################");

				returnMap.put("_adminMailId", _adminMailId);
				returnMap.put("_faultMessageBody", _faultMessageBody);
				returnMap.put("_faultMessageSub", _faultMessageSub);

				// ------------------Commented Part to Send
				// Notifications--------------------------
				// SendNotifications.sendMail(finalUrl,bpelFault,_prop,returnMap);
				// -----------------------------------------------------------------------------

//            _adminMailId = (String)faultImpl.getVariableData("AdminMailId"); 
//            System.out.println("_adminMailId::after notofication call::::::"+_adminMailId);

				XMLElement elementTitle = (XMLElement) faultImpl.getVariableData("FileDirectory");
				fileDirectory = elementTitle.getText();

				System.out.println("fileDirectory::::::::::::" + fileDirectory);

				if (!"".equalsIgnoreCase(fileDirectory) && fileDirectory.startsWith("Inbound")) {

					System.out.println("INBOUND INTERFACE................");
				} else {
					System.out.println("OUTBOUND INTERFACE................");
				}

				XMLElement inputXMLElement = (XMLElement) faultImpl.getVariableData("FileDirectory");
				sourceFolder = inputXMLElement.getText();
				System.out.println("=======================" + sourceFolder + "===========================");

				boolean returnStatus = true;
				XMLElement inputXMLElementForFileName = (XMLElement) faultImpl.getVariableData("FileName");
				fileName = inputXMLElementForFileName.getText();

				System.out.println("File Name::::from BPEL::::::::::::::::::" + fileName);

				targetFolder = sourceFolder.substring(0, sourceFolder.lastIndexOf("/") + 1);

				targetFolder = targetFolder + "error";

				System.out.println("targetFolder:::::::::::::::::::::::::::::::::::" + targetFolder);

				XMLElement ifsAdminUserXml = (XMLElement) faultImpl.getVariableData("ifsAdminUser");
				ifsAdminUser = ifsAdminUserXml.getText();

				System.out.println("ifsAdminUser::::" + ifsAdminUser);

				XMLElement ifsAdminPwdXml = (XMLElement) faultImpl.getVariableData("ifsAdminPwd");
				ifsAdminPwd = ifsAdminPwdXml.getText();

				System.out.println("ifsAdminPwd::::" + ifsAdminPwd);

				XMLElement ifsServiceXml = (XMLElement) faultImpl.getVariableData("ifsService");
				ifsService = ifsServiceXml.getText();

				System.out.println("ifsService::::" + ifsService);

				XMLElement ifsSysPwdXml = (XMLElement) faultImpl.getVariableData("ifsSysPwd");
				ifsSysPwd = ifsSysPwdXml.getText();

				System.out.println("ifsSysPwd::::" + ifsSysPwd);

				System.out.println("Before File movement service");

				// For Testing

				/*
				 * XMLElement IFIDXml = (XMLElement) faultImpl.getVariableData("IFID"); String
				 * IFID = IFIDXml.getText();
				 */
				String errormessage = (String) faultImpl.getVariableData("errormessage");
				errorCheck = errormessage;
				System.out.println("errormessage :" + errormessage);
				if (!"ErrorHandlerSkip".equalsIgnoreCase(errormessage)) {
					String IFID = (String) faultImpl.getVariableData("IFID");
					System.out.println("IFID :" + IFID);
					XMLElement wccpathXml = (XMLElement) faultImpl.getVariableData("wccpath");
					String wcc_path = wccpathXml.getText();
					System.out.println("wccpath :" + wcc_path);
					String File_Path = sourceFolder;
					String File_Name = fileName;
					File srcfile = new File(File_Path + File.separator + File_Name);
					if (srcfile.exists()) {
						System.out.println(" File Exist ");
					} else {
						System.out.println(File_Path + File.separator + File_Name + "File does not exist ");
					}
					Timestamp ts = new Timestamp(srcfile.lastModified());
					String Rename_Filename = null;
					String IPM_ID = null;
					System.out.println("FilePath :" + File_Path);
					ImagingUtility iu = new ImagingUtility();
					try {
						System.out.println("Testing DB connection");
						System.out.println(" Time stamp ::::: " + ts);
						System.out.println("Error Message " + errormessage);
						if (("DUPLICATE FILE").equalsIgnoreCase(errormessage)) {
							System.out.println("Duplicate File scenario");
							System.out.println("IFID insert" + IFID);
							String value = iu.uploadService(IFID, File_Path, File_Name, wcc_path, Rename_Filename,
									errormessage);
							if (!"true".equalsIgnoreCase(value))
								throw new Exception();
							Thread.sleep(10000);
							List<String> response = iu.searchimpid(IFID, File_Path, File_Name, Rename_Filename);
							IPM_ID = response.get(0);
							if (!IPM_ID.contains("IPM")) {
								IPM_ID = null;
							}
							System.out.println("IFID " + IFID + " IPM_ID : " + IPM_ID);
							iu.insertIPMId(IFID, File_Name, ts, IPM_ID);
							
						} else {
							String result = iu.getIPMId(IFID, File_Name, ts);
							System.out.println("RESULT for ipmid search in database : " + result);
							if ("norecord".equalsIgnoreCase(result)) {
								System.out.println("IFID insert" + IFID);
								String value = iu.uploadService(IFID, File_Path, File_Name, wcc_path, Rename_Filename,
										errormessage);
								if (!"true".equalsIgnoreCase(value))
									throw new Exception();
								Thread.sleep(10000);
								List<String> response = iu.searchimpid(IFID, File_Path, File_Name, Rename_Filename);
								IPM_ID = response.get(0);
								if (!IPM_ID.contains("IPM")) {
									IPM_ID = null;
								}
								System.out.println("IFID " + IFID + " IPM_ID : " + IPM_ID);
								iu.insertIPMId(IFID, File_Name, ts, IPM_ID);

							} else if ("noipmid".equalsIgnoreCase(result)) {
								System.out.println("IFID update" + IFID);
								String value = iu.uploadService(IFID, File_Path, File_Name, wcc_path, Rename_Filename,
										errormessage);
								if (!"true".equalsIgnoreCase(value))
									throw new Exception();
								List<String> response = iu.searchimpid(IFID, File_Path, File_Name, Rename_Filename);
								System.out.println("IFID " + IFID + " IPM_ID" + response.get(0));
								IPM_ID = response.get(0);
								if (!IPM_ID.contains("IPM")) {
									IPM_ID = null;
								}
								System.out.println("IFID " + IFID + " IPM_ID : " + IPM_ID);
								iu.updateIPMId(IFID, File_Name, ts, IPM_ID);

							} else if (result != null && result.contains("IPM")) {
								System.out.println("Update Service called");
								String value = iu.updateService(result, IFID, File_Path, File_Name, wcc_path,
										Rename_Filename, errormessage);
								if (!"true".equalsIgnoreCase(value))
									throw new Exception();
								
								iu.updateIPMId(IFID, File_Name, ts, result);

							}

							if (errormessage.equalsIgnoreCase("SftpFtpSmtpFailure")
									|| errormessage.equalsIgnoreCase("encryption failure")
									|| errormessage.equalsIgnoreCase("updateLobStarFailure")
									|| errormessage.equalsIgnoreCase("Copy File Failure")) {
								System.out.println("Moving File to error folder for errormessage");
								System.out.println("Error message : " + errormessage);
								File file = new File(wcc_path + File.separator + File_Name);
								System.out.println(
										"source path " + srcfile.toPath() + " error destination path " + file.toPath());
								FileUtils.copyFile(srcfile, file);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Moving File to error folder for getting an exception");
						File file = new File(wcc_path + File.separator + File_Name);
						System.out.println(
								"source path " + srcfile.toPath() + " error destination path " + file.toPath());
						FileUtils.copyFile(srcfile, file);
					} finally {
						iu.closeConnection();
					}
					System.out.println("Source File Deleted");
					srcfile.delete();
					System.out.println("End of ipm id testing");
				}
				// End of testing
				/*
				 * moveFileCMSDK = new MoveFileCMSDK(); QFEQIFMoveFileSOA qFEQIFMoveFileSOA =
				 * moveFileCMSDK.getQFEQIFMoveFileSOAPort();
				 * qFEQIFMoveFileSOA.moveFile(fileName, sourceFolder, targetFolder,
				 * overWriteFlag, ifsAdminUser, ifsAdminPwd, ifsService, ifsSysPwd);
				 * System.out.println("After File movement service");
				 */

				// System.out.println("returnStatus::::::::::::::::::::::::::::::::::::::::::::::::::"+returnStatus);
				System.out.println("==========END =============================");
			}
		} catch (Exception ex) {
			System.out.println("=========here in catch of handlefault============");
			ex.printStackTrace();

			// return "MANNUAL";
		} finally {
			System.out.println("In Finally Block");
			if (!"ErrorHandlerSkip".equalsIgnoreCase(errorCheck)) {
				notificationResult = SendNotifications.sendMail(finalUrl, bpelFault, _prop, returnMap);
			}
			System.out.println("In finally block notificationResult:::::" + notificationResult);

		}
		System.out.println("============= end of this method=====of class FaultManagementSample======================");

		return "MANNUAL";

		/*
		 * NOTE: We didn't implement returning "TERMINATE" or "RETHROW" so the policy is
		 * simply an example that you can return multiple values from this method
		 * depending upon your needs.
		 */
	}

	private void printValues(IFaultRecoveryContext iFaultRecoveryContext) {
		String policyId = iFaultRecoveryContext.getPolicyId();
		QName portType = iFaultRecoveryContext.getPortType();
		Map properties = iFaultRecoveryContext.getProperties();
		String refName = iFaultRecoveryContext.getReferenceName();
		String type = iFaultRecoveryContext.getType();
		Iterator it = properties.entrySet().iterator();

		System.out.println("**** PolicyId:       " + policyId);
		System.out.println("**** PortType:       " + portType.toString());

		System.out.println("**** Properties:     ");
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println("     " + pairs.getKey() + " = " + pairs.getValue());
		}
		System.out.println("**** ReferenceName:  " + refName);
		System.out.println("**** Type:           " + type);

	}

	private static Properties getProperties() {

		final Properties _prop = new Properties();
		try {
			String configPath = System.getenv("QFEQIF_CONFIG");

			_prop.load(new FileInputStream(configPath));

			// For Standalone Testing
			// _prop.load(FaultManagementSample.class.getClassLoader().getResourceAsStream("properties/config.properties"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return _prop;

	}

}
