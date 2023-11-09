package com.fetch.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchData {

	public Object[][] call11gQuery(String startDate, String endDate, String docID) {
		// Imaging Detail
		Connection conImaging = null;
		PreparedStatement preparedStatementImaging = null;
		ResultSet resultSetImaging = null;
		Object[][] dataBaseData = null;
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object for Imaging DB

			conImaging = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-owc-db1.qantas.com.au:16010:PRODOWC",
					"owcview", "owcview123");

			String queryImaging = "SELECT A.*, B.DDOCNAME FROM  PROD_OCS.DOCMETA A,PROD_OCS.REVISIONS B WHERE B.DID=A.DID AND B.DINDATE between ? and ? and b. dindate is not null and B.DDOCNAME=?";
			preparedStatementImaging = conImaging.prepareStatement(queryImaging);
			preparedStatementImaging.setString(1, startDate);
			preparedStatementImaging.setString(2, endDate);
			preparedStatementImaging.setString(3, docID);
			resultSetImaging = preparedStatementImaging.executeQuery();
			while (resultSetImaging.next()) {
				System.out.println(resultSetImaging.getString(1));
				System.out.println(resultSetImaging.getString(2));
				System.out.println(resultSetImaging.getString(3));
				System.out.println(resultSetImaging.getString(4));
				System.out.println(resultSetImaging.getString(5));
				System.out.println(resultSetImaging.getString(6));
				System.out.println(resultSetImaging.getString(7));
				System.out.println(resultSetImaging.getString(8));
				System.out.println(resultSetImaging.getString(9));
				System.out.println(resultSetImaging.getString(10));
				System.out.println(resultSetImaging.getString(11));
				System.out.println(resultSetImaging.getString(12));
				System.out.println(resultSetImaging.getString(13));
				Object[][] dataBaseDataN = { { resultSetImaging.getString("XIPM_APP_1_0"),
						resultSetImaging.getString("XIPM_APP_1_1"), resultSetImaging.getString("XIPM_APP_1_2"),
						resultSetImaging.getString("XIPM_APP_1_3"), resultSetImaging.getString("XIPM_APP_1_4"),
						resultSetImaging.getString("XIPM_APP_1_5"), resultSetImaging.getString("XIPM_APP_1_6"),
						resultSetImaging.getString("XIPM_APP_1_7"), resultSetImaging.getString("XIPM_APP_1_8"),
						resultSetImaging.getString("XIPM_APP_1_9"), resultSetImaging.getString("XIPM_APP_1_10"),
						resultSetImaging.getString("XIPM_APP_1_11"), resultSetImaging.getString("XIPM_APP_1_12"),
						resultSetImaging.getString("XIPM_APP_1_13"), resultSetImaging.getString("XIPM_APP_1_14"),
						resultSetImaging.getString("XIPM_APP_1_15"), resultSetImaging.getString("XIPM_APP_1_16"),
						resultSetImaging.getString("XIPM_APP_1_17"), resultSetImaging.getString("XIPM_APP_1_18"),
						resultSetImaging.getString("XIPM_APP_1_19"), resultSetImaging.getString("XIPM_APP_1_20"),
						resultSetImaging.getString("XIPM_APP_1_21"), resultSetImaging.getString("XIPM_APP_1_23"),
						resultSetImaging.getString("XIPM_APP_1_24"), resultSetImaging.getString("XIPM_APP_1_25"),
						resultSetImaging.getString("XIPM_APP_1_26"), resultSetImaging.getString("XIPM_APP_1_27"),
						resultSetImaging.getString("XIPM_APP_1_28"), resultSetImaging.getString("XIPM_APP_1_29"),
						resultSetImaging.getString("XIPM_APP_1_30"), resultSetImaging.getString("XIPM_APP_1_31"),
						resultSetImaging.getString("XIPM_APP_1_32"), resultSetImaging.getString("XIPM_APP_1_33"),
						resultSetImaging.getString("XIPM_APP_1_34"), resultSetImaging.getString("XIPM_APP_1_35"),
						resultSetImaging.getString("XIPM_APP_1_36"), resultSetImaging.getString("XIPM_APP_1_37"),
						resultSetImaging.getString("XIPM_APP_1_38"), resultSetImaging.getString("XIPM_APP_1_39"),
						resultSetImaging.getString("XIPM_APP_1_40"), resultSetImaging.getString("XIPM_APP_1_41"),
						resultSetImaging.getString("XIPM_APP_1_42"), resultSetImaging.getString("XIPM_APP_1_43"),
						resultSetImaging.getString("XIPM_APP_1_44"), resultSetImaging.getString("XIPM_APP_1_45"),
						resultSetImaging.getString("XIPM_APP_1_46"), resultSetImaging.getString("XIPM_APP_1_47"),
						resultSetImaging.getString("XIPM_APP_1_48"), resultSetImaging.getString("XIPM_APP_1_49"),
						resultSetImaging.getString("XIPM_APP_1_50"), resultSetImaging.getString("XIPM_APP_1_51"),
						resultSetImaging.getString("XIPM_APP_1_52"), resultSetImaging.getString("XIPM_APP_1_53"),
						resultSetImaging.getString("XIPM_APP_1_54"), resultSetImaging.getString("XIPM_APP_1_55"),
						resultSetImaging.getString("XIPM_APP_1_56"), resultSetImaging.getString("XIPM_APP_1_57"), } };
				dataBaseData = dataBaseDataN;
			}
			return dataBaseData;
		} catch (Exception e) {
			try {
				resultSetImaging.close();
				preparedStatementImaging.close();
				conImaging.close();
				System.out.println("Imaging Connection Close Catch : " + conImaging.isClosed());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				resultSetImaging.close();
				preparedStatementImaging.close();
				conImaging.close();
				System.out.println("Imaging Connection Close : " + conImaging.isClosed());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dataBaseData;
	}

	public void insertData12C() {
		// Imaging12C Detail
		Connection conImaging12C = null;
		PreparedStatement preparedStatementImaging12C = null;
		ResultSet resultSetImaging12C = null;
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object for Imaging DB
			conImaging12C = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-owc-db1.qantas.com.au:16010:PRODOWC",
					"OWCPRDVIEW12C", "owcview");
			String sql = "";
			preparedStatementImaging12C = conImaging12C.prepareStatement(sql);
			int queryStatus = preparedStatementImaging12C.executeUpdate();
			if (queryStatus > 0) {

			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {

	}
}
