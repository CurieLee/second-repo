package jdbc.sec02;

import java.sql.Connection;

public class DBConnMain {

	public static void main(String[] args) {
		// 사용자 정의 클래스 (DBConnect) 활용 DB 연결
		Connection conn = null;
		DBConnect dbConn = new DBConnect();
		conn = dbConn.getConnection();
	}

}
