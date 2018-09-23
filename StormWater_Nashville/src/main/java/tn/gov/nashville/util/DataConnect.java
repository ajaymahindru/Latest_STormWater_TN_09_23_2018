package tn.gov.nashville.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.10.35.17:1521:test1", "BG_CROMERR_USER", "bkSFfZds3aaAJ9qfKnoh");
				//"jdbc:oracle:thin:@10.10.35.17:1521:d001", "bg01956", "tdec01956");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error Connecting Test database test1 -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}

