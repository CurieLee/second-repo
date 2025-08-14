package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		// DB 연결
		DBConnect dbConn = new DBConnect();
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		
		// 저장할 데이터: 고정값
		String bookNo = "1020";
		String bookName = " 알고리즘 2";
		String bookAuthor = "김철수";
		int bookPrice = 25000;
		String bookDate = "2024-05-07";
		int bookStock = 10;
		String pubNo = "1";
		
		try {
			// insert 쿼리 작성 
			// 열의 value 자리에 '?' (placeholder) 로 지정-> 바인딩 변수
			String sql = "INSERT INTO book VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			// prepared statement 객체 생성시 바인딩 될 쿼리구문 전달
			pstmt = conn.prepareStatement(sql);
			// 바인딩 될 data 준비 되면 실제값 바인딩
			// PerparedStatement.setXXX(idx, 값) -> 해당 위치 idx에 값 바인딩
			// XXX 는 바인딩 될 실제값의 타임
			pstmt.setString(1,  bookNo);
			pstmt.setString(2, bookName);
			pstmt.setString(3,  bookAuthor);
			pstmt.setInt(4,  bookPrice);
			pstmt.setString(5,  bookDate);
			pstmt.setInt(6,  bookStock);
			pstmt.setString(7,  pubNo);
			
			// 쿼리 실행 
			// insert/update/delete: executeUpdate()
			// insert 문은 반환되는 결과가 수행된 횟수: 저장된 행 수 반환
			// 필요 없으면 저장 안해도 됨
			int result = pstmt.executeUpdate();
			
			// 제대로 저장 됐으면 result > 0 아니면 result = 0
			if (0 < result) {
				System.out.println("도서등록 성공");
			} else {
				System.out.println("도서등록 실패");
			}
			
			// resource 반환 
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
