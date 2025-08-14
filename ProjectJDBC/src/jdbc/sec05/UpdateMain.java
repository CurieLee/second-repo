package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {

	public static void main(String[] args) {
		// update 기능은 모든 컬럼에 대해 update 진행하도록 구성
		// 특정 튜플에 대해 update 가 진행되도록 where 조건절 구성
		DBConnect dbConn = new DBConnect();
		Connection conn = dbConn.getConnection();
		
		PreparedStatement pstmt = null;
		
		Scanner scan = new Scanner(System.in);
		
		// 수정 data 입력-> 모든 컬럼 데이터 입력
		System.out.print("수정할 도서 번호를 입력하세요: ");
		String bookNo = scan.nextLine();
		System.out.print("수정할 도서명을 입력하세요: ");
		String bookName = scan.nextLine();
		System.out.print("수정할 도서의 저자명을 입력하세요: ");
		String bookAuthor = scan.nextLine();
		System.out.print("수정할 도서의 가격을 입력하세요: "); 
		int bookPrice = scan.nextInt(); 
		scan.nextLine();
		System.out.print("수정할 도서의 출판일을 입력하세요: ");
		String bookDate = scan.nextLine();
		System.out.print("수정할 도서의 수량을 입력하세요: ");
		int bookStock = scan.nextInt();
		scan.nextLine(); 
		System.out.print("수정할 도서의 출판사 번호를 입력하세요: ");
		String pubNo = scan.nextLine();
		
		try {
			String sql = "UPDATE book SET bookName=?, bookAuthor=?,"
							+ "bookPrice=?, bookDate=?, bookStock=?, pubNo=? WHERE bookNo=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookName);
			pstmt.setString(2, bookAuthor);
			pstmt.setInt(3,  bookPrice);
			pstmt.setDate(4, java.sql.Date.valueOf(bookDate));
			pstmt.setInt(5,  bookStock);
			pstmt.setString(6, pubNo);
			pstmt.setString(7,  bookNo);
			
			// 수정된 행의 수 정수로 반환-> 필요시 변수 저장 사용
			pstmt.executeUpdate();
			
			System.out.println("도서정보 수정 성공");
			
		} catch (SQLException e) {
			System.out.println("도서정보 수정 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt);
		}

	}

}
