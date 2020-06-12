package dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dal.Settings;

public class JdbcTools {

	private static Connection conn;
	private static String urlDB, userDB, passDB;
	static {
		urlDB = Settings.getProPerty("url");
		userDB = Settings.getProPerty("user");
		passDB= Settings.getProPerty("pass");
	}
	
	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(urlDB, userDB, passDB);
		}		     
		return conn;		
	}

	
	
}
