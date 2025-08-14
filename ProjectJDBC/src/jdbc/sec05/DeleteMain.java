package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {

	public static void main(String[] args) {
		// WHERE 조건절을 통해 특정 튜플만 삭제되도록 구성
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnect dbConn = new DBConnect();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("도서정보 삭제");
		System.out.print("삭제할 도서 번호를 입력하세요: ");
		String bookNo = scan.nextLine();
		
		try {
			conn = dbConn.getConnection();
			
			String sql = "DELETE book WHERE bookNo=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			
			pstmt.executeUpdate();
			
			System.out.println("도서정보 삭제 성공");
			
		} catch (SQLException e) {
			System.out.println("도서정보 삭제 실패");
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt);
		}
		
		scan.close();

	}

}
