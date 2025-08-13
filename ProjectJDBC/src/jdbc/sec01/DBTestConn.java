package jdbc.sec01;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTestConn {

	public static void main(String[] args) {
		// DB Connection test
		Connection conn = null;
		// 외부 서버 사용이므로 Try~catch 예외처리 진행
		try {
			// 1 Driver 로드: run time 로드 (자동로드: 생략가능)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 연결을 위한 주소, 사용자 계정, 비밀번호-> 문자열로 전달
			String url = "jdbc:oracle:thin:@localhost:1521:sdb";
			String user = "USER_SELECT";
			String pwd = "1234";
			
			// DB 연결 확립을 위한 객체 생성
			// DriverManager 클래스를 통해 Connection 객체 반환함
			conn = DriverManager.getConnection(url, user, pwd);
			
			// Connection 객체가 생성되면 (null 이 아니면) 연결 성공
			if (conn != null) {
				System.out.println("DB connect success");
			} else {
				System.out.println("DB connect fail");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
