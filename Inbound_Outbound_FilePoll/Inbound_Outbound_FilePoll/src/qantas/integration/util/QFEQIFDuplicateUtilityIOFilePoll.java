package qantas.integration.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QFEQIFDuplicateUtilityIOFilePoll {
	
	private static final Logger logger = QFEQIFLoggerIOFilePoll.getLogger(QFEQIFFileLockingUtilityIOFilePoll.class.getName());
	private Connection          conn;
	private ResultSet           rs;
	private PreparedStatement   ps;
	
	public boolean getStatus(String filename, Timestamp time, String ifId){
		logger.info("Entering getStatus method. for the file "+ filename+"time stamp  "+time);
		int rowCount = 0;
		try{
			conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
			
			/*Trying to check if the lock is already acquired by other thread or not*/
			ps   = conn.prepareStatement("select COUNT(*) from QFEQIF_WCC where IFID = ? AND FILE_NAME = ? AND FILE_CREATION_TIME = ? AND STATUS IN ('ERROR','SUCCESS')");
			ps.setString(1, ifId);
			ps.setString(2, filename);
			ps.setTimestamp(3, time);
			rs   = ps.executeQuery();
			while (rs.next()){
				rowCount = rs.getInt(1);
			}
			logger.info("Number of record matching the current file is " + rowCount);
			if(rowCount > 0) {
				logger.info(" in if row count is for the file " + filename +"is  "+rowCount);
				return true;
			}
			else {
				logger.info("in else row count is for the file " + filename +"is  "+rowCount);
				return false;
			}
		}
		catch(Exception exception){
			logger.info("File name  = " + filename);
			logger.info("File time  = " + time);
			logger.info("File if id = " + ifId);
			logger.log(Level.WARNING, "Exception occured in getStatus method");
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
					QFEQIFDatabaseConnIOFilePoll.closeConnection();
				}
			}catch(Exception exception){
				logger.log(Level.WARNING, "Exception occured in getStatus method while closing the resources ");
	        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
	}

	public boolean getCurrentState(String fname, String fmod, String ifId) {
		logger.info("Entering getCurrentState method. for the file name "+fname+"fmod is  "+fmod);
		//int rowCount = 0;
		try{
			conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
			
			/*Trying to check if the lock is already acquired by other thread or not*/
			ps   = conn.prepareStatement("SELECT POLL_DATE FROM QFEQIF_FTP_DIRECT_INTERFACES WHERE FILE_NAME = ? AND CREATED_DATE = ? AND STATUS = 'COMPLETE'");
			ps.setString(1, fname);
			ps.setString(2, fmod);
			rs   = ps.executeQuery();			
			
			while (rs.next()){
				logger.info("result set in  getCurrentState method is "+fname+"rs is  "+rs.getTimestamp(1));
				logger.info("in while of getCurrentState "+fname+"rs is  "+rs.getTimestamp(1));
				Timestamp tsSql = rs.getTimestamp(1);
				Timestamp tsCurrent = new Timestamp(System.currentTimeMillis());
				logger.info("Poll Date " + tsSql);
				logger.info("Current System Date " + tsCurrent);
				Double d = ((double)(tsCurrent.getTime() - tsSql.getTime()))/(3600 * 1000);
				logger.info("Time difference " + d);
				
				if(d > 1)
				{
					logger.info("Time difference is more than 2 hours");
					return true;
				}
			}
			logger.info("Time difference is less than 2 hours");			
			return false;
		}catch(Exception exception){
			logger.info("File name  = " + fname);
			logger.info("File time  = " + fmod);
			logger.info("File if id = " + ifId);
			logger.log(Level.WARNING, "Exception occured in getCurrentState method");
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
					QFEQIFDatabaseConnIOFilePoll.closeConnection();
				}
			}catch(Exception exception){
				logger.log(Level.WARNING, "Exception occured in getCurrentState method while closing the resources ");
	        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
	}

	public void deleteCompleteStateEntry(String fname, String fmod, String ifId) {

		logger.info("Entering deleteCompleteStateEntry method.");
		try{
			conn = QFEQIFDatabaseConnIOFilePoll.getConnection();
			
			/*Deleting the file entry from the locking database*/
			ps   = conn.prepareStatement("DELETE FROM QFEQIF_FTP_DIRECT_INTERFACES WHERE FILE_NAME = ? AND CREATED_DATE = ? AND IF_ID = ?");
			ps.setString(1, fname);
			ps.setString(2, fmod);
			ps.setString(3, ifId);
			ps.executeUpdate();
		}catch(Exception e){
			logger.log(Level.WARNING, "Exception occured in deleteCompleteStateEntry method while trying to release lock for file");
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
					QFEQIFDatabaseConnIOFilePoll.closeConnection();
				}
			}catch(Exception exception){
				logger.log(Level.WARNING, "Exception occured in deleteCompleteStateEntry method while closing the resources ");
	        	logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
			
	}

}
