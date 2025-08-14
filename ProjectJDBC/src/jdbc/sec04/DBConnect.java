package jdbc.sec04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
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
	// 1 Connection, PreparedStatement, ResultSet 자원 3개 반환
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
					
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
					
			if (conn != null) {
				conn.close();
				conn = null;
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
	// 2 Connection, PreparedStatement 자원 2개 반환
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
					
			if (conn != null) {
				conn.close();
				conn = null;
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	// 3 Connection 자원 1개 반환
	public static void close(Connection conn) {
		try {	
			if (conn != null) {
			conn.close();
			conn = null;
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	// 4 PreparedStatement, ResultSet 자원 2개 반환
	public static void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
					
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	// 5 PreparedStatement자원 1개 반환
	public static void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
							
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}			

}
