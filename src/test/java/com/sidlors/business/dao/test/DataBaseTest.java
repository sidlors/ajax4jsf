package com.sidlors.business.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.sidlors.util.Constant;

public class DataBaseTest {

	@Test
	public void goByJBDC() throws SQLException {

		String DB_DRIVER = "com.informix.jdbc.IfxDriver";
		String DB_CONNECTION = "jdbc:informix-sqli://192.168.253.153:1559/watch:INFORMIXSERVER=watch_bc_11";
		String DB_USER = "watprod";
		String DB_PASSWORD = "l1N#wAtP";

		Connection dbConnection = null;
		Statement statement = null;
		String selectTableSQL = Constant.QUERY;
		int k = 0;
		try {
			dbConnection = getDBConnection(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
			
			statement = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			//statement.setFetchSize(10000);
			ResultSet rs = statement.executeQuery(selectTableSQL);
			int countColumns = rs.getMetaData().getColumnCount();
			String[] nameColumns = new String[countColumns];
			for (int i = 1; i < countColumns + 1; i++) {
				nameColumns[i - 1] = rs.getMetaData().getColumnName(i);

			}
			// String sourcetable ;
			// String fieldchanges ;
			// String hitdate ;
			// String accountnumber;
			// String fid ;
			// String first ;
			// String paternal ;
			// String maternal ;
			// String rfc ;
			// String parent_id ;
			// String companyname ;
			// String type ;
			long inicio = System.currentTimeMillis();
			long paso = 0l;
			while (rs.next()) {
				if (k++ == (3000)) {
					System.out.println("Paso");
					k=0;
					paso = System.currentTimeMillis();
					System.out.println((paso-inicio)/1000);
				}
			}

			// while (rs.next()) {

			// sourcetable = rs.getString(nameColumns[0]);//0
			// fieldchanges = rs.getString(nameColumns[1]);//1
			// hitdate = rs.getString(nameColumns[2]);//2
			// accountnumber = rs.getString(nameColumns[3]);//3
			// fid = rs.getString(nameColumns[4]);//4
			// first = rs.getString(nameColumns[5]);//5
			// paternal = rs.getString(nameColumns[6]);//6
			// maternal = rs.getString(nameColumns[7]);//7
			// rfc = rs.getString(nameColumns[8]);//8
			// parent_id = rs.getString(nameColumns[9]);//9
			// companyname = rs.getString(nameColumns[10]);//10
			// type = rs.getString(nameColumns[11]);//11

			// WrapperHitDetail wrapperHitDetail =new WrapperHitDetail();
			//
			// wrapperHitDetail.setAccountNumber(accountnumber);
			// wrapperHitDetail.setCompanyid(1);
			// wrapperHitDetail.setCompanyName(companyname);
			// wrapperHitDetail.setHitDate(new LocalDate(hitdate));
			// wrapperHitDetail.setId(parent_id!=null?Integer.parseInt(parent_id):null);
			// wrapperHitDetail.setFid(fid!=null?Integer.parseInt(fid):null);
			// wrapperHitDetail.setFirst(first);
			// wrapperHitDetail.setPaternal(paternal);
			// wrapperHitDetail.setMaternal(maternal);
			// wrapperHitDetail.setRfc(rfc);
			// wrapperHitDetail.setSourceTable(sourcetable);
			//
			// hits.add(wrapperHitDetail);
			// }

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection(String DB_DRIVER, String DB_CONNECTION, String DB_USER,
			String DB_PASSWORD) {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
}
