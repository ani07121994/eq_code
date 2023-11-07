package qantas.integration.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


public class QFEQIFFtpPollIOFilePoll extends QFEQIFWorkflowBaseIOFilePoll {

	private static final Logger logger = QFEQIFLoggerIOFilePoll.getLogger(QFEQIFFtpPollIOFilePoll.class.getName());
	public static ArrayList<String> if_list = new ArrayList<String>();
	public static HashMap<String, String> if_map = new HashMap<String, String>();
	public static String temp_path = "";

	public static void readFromConfig() {
		Properties pro = new Properties();
		String configFilePath = "";
		FileInputStream fis = null;

		try {
			configFilePath = System.getenv("QFEQIF_CONFIG");
			fis = new FileInputStream(configFilePath);
			pro.load(fis);
			String interfaces_inbound = pro.getProperty("wcc.files.inbound");
			logger.info("interfaces to be polled for inbound are : " + interfaces_inbound);

			String[] list = interfaces_inbound.split(",");

			for (int i = 0; i < list.length; i++) {
				if_list.add(i, list[i]);
				if_map.put(list[i], "Inbound");
			}
			String interfaces_outbound = pro.getProperty("wcc.files.outbound");
			logger.info("interfaces to be polled for outbound are : " + interfaces_outbound);

			String[] list_out = interfaces_outbound.split(",");

			for (int i = 0; i < list_out.length; i++) {
				if_list.add(i, list_out[i]);
				if_map.put(list_out[i], "Outbound");
			}
		} catch (FileNotFoundException fnfex) {
			logger.log(Level.WARNING, "Config File not found ");
			logger.log(Level.SEVERE, fnfex.getMessage(), fnfex);
		} catch (IOException ioex) {
			logger.log(Level.WARNING, "Error reading IHub Config file ");
			logger.log(Level.SEVERE, ioex.getMessage(), ioex);
		} finally {
			try {
				if (null != fis) {
					fis.close();
				}
			} catch (Exception e) {
				logger.log(Level.WARNING, "Exception in readFromConfig() ");
				logger.log(Level.SEVERE, e.getMessage(), e);
			}

		}
	}

	public static String[] getInterfacePath(String ifId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String path = "";
		String fname = "";
		String keyid = null;
		String[] rVal = new String[3];

		try {
			conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
			String sql = "select qif.file_path, qif.remote_filename,qif.key_id from QFEQIF_INTERFACES qif where qif.if_id= '"
					+ ifId + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// path = rs.getString(1) + "/incoming";
				path = rs.getString(1);
				fname = rs.getString(2);
				keyid = rs.getString(3);
			}
			rVal[0] = path;
			rVal[1] = fname;
			rVal[2] = keyid;
		} catch (Exception e) {
			logger.log(Level.WARNING, "Database read occurs while reading interface paths ");
			logger.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (null != stmt) {
					stmt.close();
				}
				if (null != rs) {
					rs.close();
				}
				if (null != conn) {
					conn.close();
					QFEQIFDatabaseConnIOFilePoll.closeConnection();
				}

			} catch (Exception e) {
				logger.log(Level.WARNING,
						"Exception in getInterfacePath(String ifId) method while closing the resources ");
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}

		return rVal;
	}

	public static List<Map<String, String>> getFTPPath(String ifId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Map<String, String>> ftpDetails = new ArrayList<Map<String, String>>();
		try {
			conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append(
					"select ftp.address, ftp.username, ftp.password, ftp.path, ftp.ftpport, ftp.ftpmode, ftp.attribute1, ftp.attribute2");
			sb.append(" from qfeqif_ftp_addr ftp");
			sb.append(" where ftp.id in (select addr_id from qfeqif_if_addr adr where adr.if_id='" + ifId + "'");
			sb.append(" and adr.addr_type='FTP')");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("host", rs.getString(1));
				map.put("user", rs.getString(2));
				map.put("password", rs.getString(3));
				map.put("path", rs.getString(4));
				map.put("port", rs.getString(5));
				map.put("mode", getAttribValue(rs.getString(6)));
				map.put("attrib1", getAttribValue(rs.getString(7)));
				map.put("attrib2", getAttribValue(rs.getString(8)));
				ftpDetails.add(map);
			}

		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured in getFTPPath(String ifId) method ");
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (null != stmt) {
					stmt.close();
				}
				if (null != rs) {
					rs.close();
				}
				if (null != conn) {
					conn.close();
					QFEQIFDatabaseConnIOFilePoll.closeConnection();
				}

			} catch (Exception e) {
				logger.log(Level.WARNING,
						"Exception occured in getFTPPath(String ifId) method while closing the resources ");
				logger.log(Level.SEVERE, e.getMessage(), e);
			}

		}
		return ftpDetails;
	}

	public static void execute() {
		String[] if_detl = new String[] {};
		List<Map<String, String>> ftpDetails = new ArrayList<Map<String, String>>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String TARGET_FOLDER = "";
		// String remoteFileName = "";

		try {
			conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
			/*String sql = "select * from qfeqif_properties qfe where qfe.name in ('IFS_ADMIN_USER','IFS_ADMIN_PWD','IFS_SERVICE','IFS_SYS_PWD')";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);*/

			Iterator<String> itr = if_list.iterator();
			logger.info("List of interface Ids :" + if_list);
			while (itr.hasNext()) {
				String ifId = itr.next().toString();
				logger.info("Current interface :: " + ifId);
				if_detl = getInterfacePath(ifId);

				if (if_map.get(ifId).equalsIgnoreCase("Inbound")) {

					TARGET_FOLDER = if_detl[0] + "/incoming";
				} else {
					TARGET_FOLDER = if_detl[0] + "/outgoing";
				}
				
				String keyid = "";
				keyid = if_detl[2];
				
				logger.info("TargetFolder " + TARGET_FOLDER);
				logger.info("key id value for the folder " + ifId + ""+"is" +keyid);
				// TARGET_FOLDER = if_detl[0] + "/incoming";
				// remoteFileName = getAttribValue(if_detl[1]);

				ftpDetails = getFTPPath(ifId);

				processDirectInterface(conn, TARGET_FOLDER, ifId, keyid);

			}
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error in execute ");
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (null != stmt) {
					stmt.close();
				}
				if (null != rs) {
					rs.close();
				}
				if (null != conn) {
					conn.close();
					QFEQIFDatabaseConnIOFilePoll.closeConnection();
				}
			} catch (Exception e) {
				logger.log(Level.WARNING, "Excpetion occured while closing the resources ");
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}

	private static void processDirectInterface(Connection conn, String location, String ifId, String keyid) throws IOException {

		logger.info(ifId + " is the current ifId");
		// String location = "/u02_psp_soa_ap/DATA" + loc;
		File folder = new File(location);
		File[] listOfFiles = folder.listFiles();
		if (null != listOfFiles) {
			for (File file : listOfFiles) {
				
				logger.info("size of the file..." + file.getName() +"  in bytes is.." +file.length());
				if(file.length() > 0) {

				String fname = file.getName();
				
				logger.info(fname + " is the current file name");
				SimpleDateFormat sdf_1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				String fmod_1 = sdf_1.format(file.lastModified()); 
				//conn = QFEQIFDatabaseConn.getConnection();
				QFEQIFDirectFileLockingUtilityIOFilePoll fService = new QFEQIFDirectFileLockingUtilityIOFilePoll();
				if (!(fService.getFileexistence(fname, fmod_1, ifId))) {//add if id 
					if (location.contains("incoming") && keyid == null) {
						logger.info("folder path contain incoming" + fname +"and keyid value is" +keyid);
						
							Process prc = null;
							String cmd = "dos2unix " + location + "/" + fname;
							logger.info(" File Name :: " + fname + " cmd:: " + cmd);
							prc = Runtime.getRuntime().exec(cmd);
							
							///////
							try {
								Thread.sleep(10000);
								logger.info(fname + " thread sleep");
								//logger.info(fname + " is the current file name");
								
								/*/////////////////////////////////////////////////
								String ff =  location + "/" + fname;
								
								File f= new File(ff);
								logger.info(" new file location is ff is"+f);
								logger.info(f.getName() + " is the current file name");
								
						
								
								SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
								String fnewTime= sdf1.format(f.lastModified());

								logger.info(fname + " is the current file name"+"new time stamp is "+fnewTime);*/
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							////////////
						} else
							logger.info("folder path does not contain incoming for the file "+fname);					

				} else {
					logger.info("file record is already exist in the table for the file" + fname + "with timestamp"
							+ fmod_1);
					
				}
				
				
				//File f= new File(location+File.pathSeparator+fname);
				
				
				
				////////////////////////////////////////////////////////////////////////
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				String fmod = sdf.format(file.lastModified());
		
				Timestamp ts = new Timestamp(file.lastModified());
				logger.info("Date formatted " + fmod);
				logger.info("Timestamp " + ts);
				logger.info("Checking Duplicate Entry");
				checkDuplicate(fname, fmod, ifId, ts);
				if (fService.getLock(fname, fmod, ifId)) {
					try {
						conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
						int rtVal = insertSoaQueue(conn, fname, ifId, location);
						logger.info("Return Value " + rtVal);
						if (rtVal == 0) {
							fService.releaseLock(fname, fmod, QFEQIFConstantIOFilePoll.FTP_DOWNLOAD_SUCCESS);
							logger.info("Lock has been released from " + fname);
						} else {
							logger.info(fname + " was unable to process from stored Procedure");
							fService.deleteFileEntry(fname, fmod, ifId);
							logger.info(fname + " is successfully deleted from locking table");
						}

					} catch (Exception ex) {
						logger.log(Level.WARNING, "Error getting/deleting the file");
						logger.log(Level.SEVERE, ex.getMessage(), ex);
						fService.deleteFileEntry(fname, fmod, ifId);
						logger.info(fname + " is successfully deleted from locking table");
					}

				} else {
					logger.info("File Already Read.");
				}

			}
		  }
		}
	}

	private static void checkDuplicate(String fname, String fmod, String ifId, Timestamp ts) {
		
		QFEQIFDuplicateUtilityIOFilePoll dupUtil = new QFEQIFDuplicateUtilityIOFilePoll();
		if(dupUtil.getStatus(fname, ts, ifId))
		{
			logger.info("entering into if block of getstatus with file name  "+fname+" timestamp is "+ts);
			System.out.println("entering into if block of getstatus with file name  "+fname+" timestamp is "+ts);
			if(dupUtil.getCurrentState(fname, fmod, ifId))
			{
				logger.info("entering into if block of getCurrentState with file name  "+fname+" timestamp fmod is "+fmod);
				System.out.println("entering into if block of getCurrentState with file name  "+fname+" timestamp is fmod "+fmod);
				dupUtil.deleteCompleteStateEntry(fname, fmod, ifId);
			}
		}
	}

	private static int insertSoaQueue(Connection conn, String fname, String ifId, String location) {

		CallableStatement cstmt = null;
		int rtnVal = 0;
		try {
			cstmt = conn.prepareCall("{? = call QFEQIF_CMSDK_WF_PKG.NewFile (?, ?, ?, ?)}");
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, fname);
			cstmt.setString(3, ifId);
			cstmt.setString(4, location);
			cstmt.setInt(5, 0);
			cstmt.execute();
			logger.info(fname + " corresponding procedure has been executed");
			rtnVal = cstmt.getInt(1);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error in insertQueue ");
			logger.log(Level.SEVERE, e.getMessage(), e);
			rtnVal = -1;
		} finally {
			if (null != cstmt) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return rtnVal;
	}

	public static boolean checkFilePattern(String fname, String regex) {
		if (regex != null) {
			if (regex.trim().equals("")) {
				return true;
			} else {
				regex = regex.replace(".", "\\.").replace("*", ".*");
				final Pattern pattern = Pattern.compile(regex);
				return pattern.matcher(fname).matches();
			}
		} else {
			return true;
		}
	}

	/**
	 * Returns the attribute value.
	 * 
	 * @param p_attrib the attrib name
	 * @return the attrib value or blank
	 */

	public static String getAttribValue(String p_attrib) {
		String attribVal = QFEQIFConstantIOFilePoll.BLANK;
		try {
			attribVal = QFEQIFUtilIOFilePoll.toBlank(p_attrib);
		} catch (Exception e) {
		}
		return attribVal;
	}

	private static String stackTraceToString(Throwable e) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		readFromConfig();
		execute();
	}
}
