package com.qantas.ap.quartz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import oracle.jdbc.pool.OracleDataSource;




public class DatabaseUtility {
	

	
	public Connection getConnection(Map<String, String> dbParams) {
		Connection con = null;
		try {
			OracleDataSource oracleDS = new OracleDataSource();
			oracleDS.setURL(dbParams.get("HOST"));
			oracleDS.setUser(dbParams.get("USER"));
			oracleDS.setPassword(dbParams.get("PASSWORD"));
			
			con = oracleDS.getConnection();
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
	
		return con;
	}
	
	public void closeConnection(Connection con) {
		try {
			if(null != con)
				con.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public void closePreparedStatement(PreparedStatement ps) {
		try {
			if(null != ps)
				ps.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs) {
		try {
			if(null != rs)
				rs.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}

}
