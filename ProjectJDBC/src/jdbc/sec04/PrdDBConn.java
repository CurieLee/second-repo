package jdbc.sec04;

import java.sql.Connection;
import java.sql.DriverManager;

public class PrdDBConn {
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:sdb";
			String user = "SQL_USER";
			String pwd = "1234";
			
			conn = DriverManager.getConnection(url, user, pwd);
			
			if (conn != null) {
				System.out.println("DB connect success");
			} else {
				System.out.println("DB connect fail");
			}
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
