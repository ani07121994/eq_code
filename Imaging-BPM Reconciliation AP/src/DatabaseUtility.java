import java.sql.Connection;
import java.util.Map;

import oracle.jdbc.pool.OracleDataSource;

public class DatabaseUtility {

	public Connection getConnection(Map<String, String> dbParams_imaging) {
		Connection con = null;
		try {
			OracleDataSource oracleDS = new OracleDataSource();
			oracleDS.setURL(dbParams_imaging.get("HOST"));
			oracleDS.setUser(dbParams_imaging.get("USER"));
			oracleDS.setPassword(dbParams_imaging.get("PASSWORD"));
			
			con = oracleDS.getConnection();
			//System.out.println("con in database:" + con);
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
	
		return con;
	}

}
