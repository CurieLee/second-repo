package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertInputBook {

	public static void main(String[] args) {
		// DB 연결 및 필요객체 생성
		DBConnect dbConn = new DBConnect();
		Connection conn = dbConn.getConnection();
		PreparedStatement pstmt = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			// 저장할 데이터 입력값 저장
			System.out.print("등록할 도서 번호를 입력하세요: ");
			String bookNo = scan.nextLine();
			System.out.print("등록할 도서명을 입력하세요: ");
			String bookName = scan.nextLine();
			System.out.print("등록할 도서의 저자명을 입력하세요: ");
			String bookAuthor = scan.nextLine();
			System.out.print("등록할 도서의 가격을 입력하세요: "); 
			int bookPrice = scan.nextInt(); 
			// 값을 입력하고 enter 신호가 들어오면 입력된 값만 정수처리 반환
			//다음 입력은 처리되지 않고 남은 enter 가 입력값으로 들어감
			scan.nextLine();
			
			System.out.print("등록할 도서의 출판일을 입력하세요: ");
			String bookDate = scan.nextLine();
			System.out.print("등록할 도서의 수량을 입력하세요: ");
			int bookStock = scan.nextInt();
			scan.nextLine(); // 처리되지 않은 enter 처리
			
			System.out.print("등록할 도서의 출판사 번호를 입력하세요: ");
			String pubNo = scan.nextLine();
			
			// insert 쿼리 작성 
			String sql = "INSERT INTO book VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			// data 바인딩
			pstmt.setString(1,  bookNo);
			pstmt.setString(2, bookName);
			pstmt.setString(3,  bookAuthor);
			pstmt.setInt(4,  bookPrice);
			pstmt.setDate(5, java.sql.Date.valueOf(bookDate));
			//pstmt.setString(5,  bookDate);
			pstmt.setInt(6,  bookStock);
			pstmt.setString(7,  pubNo);
			
			// 쿼리 실행 
			int result = pstmt.executeUpdate();
			
			if (0 < result) {
				System.out.println("도서등록 성공");
			} else {
				System.out.println("도서등록 실패");
			}
			
			// pstmt.close();
			// conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// resource 반환
			DBConnect.close(conn, pstmt);
		}
		
		scan.close();
	}

}
