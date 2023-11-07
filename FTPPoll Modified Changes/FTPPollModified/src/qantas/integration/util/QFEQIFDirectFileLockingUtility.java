package qantas.integration.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QFEQIFDirectFileLockingUtility {
	

	
	private static final Logger logger = QFEQIFLogger.getLogger(QFEQIFFileLockingUtility.class.getName());
	private Connection          conn;
	private ResultSet           rs;
	private PreparedStatement   ps;
	
	/**
	 * This method will acquire lock on the file and prevent other threads to access the file
	 * @param  filename (Name of the file need to be locked)
	 * @param  time     (Timestamp of the file in the ftp directory)
	 * @return true     (If lock acquired successfully)
	 *         false    (If lock not acquired successfully)
	 */
	public boolean getLock(String filename, String time, String ifId){
		logger.info("Entering getLock(String filename, String time) method.");
		int rowCount = 0;
		try{
			conn = QFEQIFDatabaseConn.getConnection();
			
			/*Trying to check if the lock is already acquired by other thread or not*/
			ps   = conn.prepareStatement("SELECT COUNT(*) FROM QFEQIF_FTP_DIRECT_INTERFACES WHERE FILE_NAME = ? AND CREATED_DATE = ? AND STATUS IN ('WIP','COMPLETE')");
			ps.setString(1, filename);
			ps.setString(2, time);
			rs   = ps.executeQuery();
			while (rs.next()){
				rowCount = rs.getInt(1);
			}
			logger.info("Number of record matching the current file is " + rowCount);
			
			if(rowCount > 0){
				return false;
			}else{
				/*Acquiring lock on the file*/
				logger.info("Inserting the current file into database.");
				ps = conn.prepareStatement("INSERT INTO QFEQIF_FTP_DIRECT_INTERFACES(IF_ID, FILE_NAME, CREATED_DATE, STATUS, POLL_DATE) VALUES(?, ?, ?, ?, ?)");
				ps.setString   (1, ifId);
				ps.setString   (2, filename);
				ps.setString   (3, time);
				ps.setString   (4, "WIP");
				ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
				ps.execute();
				logger.info("Insertd the file successfully into database");
				logger.info("Successfully acuired locked in the file " + filename);
				
				return true;
			}
		}catch(Exception exception){
			logger.info("File name  = " + filename);
			logger.info("File time  = " + time);
			logger.info("File if id = " + ifId);
			logger.log(Level.WARNING, "Exception occured in getLock(String filename, String time, String ifId) method while trying to acuire lock for file");
        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			
			return false;
		}finally{
			try{
				if(null != rs){
					rs.close();
				}
				if(null != ps){
					ps.close();
				}
				if(null != conn){
					conn.close();
					QFEQIFDatabaseConn.closeConnection();
				}
			}catch(Exception exception){
				logger.log(Level.WARNING, "Exception occured in getLock(String filename, String time, String ifId) method while closing the resources ");
	        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
	}
	
	/**
	 * This method will release lock from the file
	 * @param  filename (Name of the file need to be locked)
	 * @param  time     (Timestamp of the file in the ftp directory)
	 * @param  status   (Status of the operation)
	 * @return true     (If lock released successfully)
	 * 		   false    (If lock not released successfully)
	 */
	public boolean releaseLock(String filename, String time, String status){
		logger.info("Entering releaseLock(String filename, String time, String status) method.");
		try{
			conn = QFEQIFDatabaseConn.getConnection();
			
			/*Releasing the lock from the file*/
			ps   = conn.prepareStatement("UPDATE QFEQIF_FTP_DIRECT_INTERFACES SET STATUS = ? WHERE FILE_NAME = ? AND CREATED_DATE = ? AND STATUS = 'WIP'");
			ps.setString(1, status);
			ps.setString(2, filename);
			ps.setString(3, time);
			ps.executeUpdate();
			
			return true;
		}catch(Exception exception){
			logger.info("File name  = " + filename);
			logger.info("File time  = " + time);
			logger.info("Status     = " + status);
			logger.log(Level.WARNING, "Exception occured in releaseLock(String filename, String time, String status) method while trying to release lock for file  ");
        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			
			return false;
		}finally{
			try{
				if(null != rs){
					rs.close();
				}
				if(null != ps){
					ps.close();
				}
				if(null != conn){
					conn.close();
					QFEQIFDatabaseConn.closeConnection();
				}
			}catch(Exception exception){
				logger.log(Level.WARNING, "Exception occured in getLock(String filename, String time) method while closing the resources ");
	        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
		
	}
	
	/**
	 * This method will delete the record from the locking table if file is not successfully uploaded
	 * to CMSDK, so that next time it should be picked up and processed.
	 * @param filename
	 * @param time
	 * @param ifId
	 */
	public void deleteFileEntry(String filename, String time, String ifId){
		logger.info("Entering deleteFileEntry(String filename, String time) method.");
		try{
			conn = QFEQIFDatabaseConn.getConnection();
			
			/*Deleting the file entry from the locking database*/
			ps   = conn.prepareStatement("DELETE FROM QFEQIF_FTP_DIRECT_INTERFACES WHERE FILE_NAME = ? AND CREATED_DATE = ? AND IF_ID = ? AND STATUS = 'WIP'");
			ps.setString(1, filename);
			ps.setString(2, time);
			ps.setString(3, ifId);
			ps.executeUpdate();
		}catch(Exception e){
			logger.log(Level.WARNING, "Exception occured in deleteFileEntry(String filename, String time, String ifId) method while trying to release lock for file");
        	logger.log(Level.SEVERE, e.getMessage(), e);
		}finally{
			try{
				if(null != rs){
					rs.close();
				}
				if(null != ps){
					ps.close();
				}
				if(null != conn){
					conn.close();
					QFEQIFDatabaseConn.closeConnection();
				}
			}catch(Exception exception){
				logger.log(Level.WARNING, "Exception occured in deleteFileEntry(String filename, String time, String ifId) method while closing the resources ");
	        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
	}



}
