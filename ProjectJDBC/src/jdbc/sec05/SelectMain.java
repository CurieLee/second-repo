package jdbc.sec05;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain {

	public static void main(String[] args) {
		// 조건절이 있는 select 쿼리 실행 예제
		// DB 연결
		DBConnect dbConn = new DBConnect();
		Connection conn = dbConn.getConnection();
		// Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			// Statement 객체 사용 예시
			// System.out.print("조회할 도서 번호를 입력하세요: ");
			// String no = scan.nextLine();
			
			// String sql = "SELECT * FROM book WHERE bookNo = '" + no + "'";
			
			// stmt = conn.createStatement();
			// Statement 객체는 진행할 질의어가 executeXXX 메소드에 전달되기 이전에 전부 완성되어야 함
			// 고정값이 아닌 변동값이면 쿼리 구성이 복잡해짐 (문자열 연결이 복잡해짐)
			// rs = stmt.executeQuery(sql);
			
			
			// PreparedStatement 객체 사용 예시
			String sql = "SELECT * FROM book WHERE bookNo=?";
			
			pstmt = conn.prepareStatement(sql);
			
			System.out.print("조회할 도서 번호를 입력하세요: ");
			String no = scan.nextLine();
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				int bookStock = rs.getInt(6);
				
				System.out.format("%-10s \t %-20s\t %3d \n", bookNo, bookName, bookStock);
			}
			
			// rs.close();
			// stmt.close();
			// conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt, rs);
		}
		
	}	
}
