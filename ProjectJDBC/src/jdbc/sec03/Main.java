package jdbc.sec03;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		// Book 테이블의 data 조회
		// 필요 객체 생성
		DBConnect dbConn = new DBConnect();
		Connection conn = dbConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		// DB 와 통신 예외처리 필요함
		try {
			// Statement 객체 인스턴스 
			stmt = conn.createStatement(); // SQL 질의 반환
			// 쿼리 구문
			String sql = "SELECT  * FROM book ORDER BY bookno";
			// Statement 객체를 통해 질의어 전달-> 실행 결과 받아옴
			// 전달한 질의가 select 구문이므로 릴레이션 반환-> ResultSet 에 저장
			// Statement.executeQuery(String): 반환되는 결가 릴레이션일 때 쿼리를 실행하는 메소드
			// select 등 릴레이션을 반환하는 질의어일때 executeQuery 사용
			rs = stmt.executeQuery(sql);
			
			// 반환 받은 결과 처리
			System.out.println("-------------- 전체 도서 정보 조회 --------------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t  가격 \t\t 발행일  \t재고 \t출판사번호");
			// ResultSet 객체 rs 는 2차원 테이블로 구성
			// rs.next(): 현재 포인팅 하는 튜플에서 다음 튜플로 이동-> 다음이 있으면 true, 아니면 false
			// rs.getXXX(컬럼번호/컬럼명): 현재 포인팅하는 튜플의 컬럼값 반환
			// XXX 에는 컬럼 타입 작성-> getString() getInt() getDouble() getDate()
			while (rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n",
									bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
			}
			
			// 사용한 순서대로 객체 닫기
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
