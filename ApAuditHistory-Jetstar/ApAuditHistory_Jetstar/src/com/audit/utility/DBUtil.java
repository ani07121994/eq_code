package com.audit.utility;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	public static Connection getEbsConnection() throws Exception {
        Context ctx = new InitialContext(); 
        DataSource ds = (DataSource)ctx.lookup(Constant.getEbsDataSourceName());
        return ds.getConnection();           
	}
	
	public static Connection getEqfilesConnection() throws Exception {
        Context ctx = new InitialContext(); 
        DataSource ds = (DataSource)ctx.lookup(Constant.getEqfilesDataSourceName());
        return ds.getConnection();           
	}
}
