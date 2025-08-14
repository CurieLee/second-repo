package jdbc.sec04;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ProductMain {

	public static void main(String[] args) {
		// Book 테이블의 data 조회
		// 필요 객체 생성
		PrdDBConn dbConn = new PrdDBConn();
		Connection conn = dbConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		// DB 와 통신 예외처리 필요함
		try {
			// Statement 객체 인스턴스 
			stmt = conn.createStatement(); // SQL 질의 반환
			// 쿼리 구문
			String sql = "SELECT  * FROM product ORDER BY prdNo";
			rs = stmt.executeQuery(sql);
			
			// 반환 받은 결과 처리
			System.out.println("------------------------------- 전체  상품 정보 조회 -------------------------------");
			System.out.format("%-5s %-20s %-15s %-15s %-10s %-5s%n",
								"PRDNO", "PRDNAME", "PRDPRICE", "PRDMAKER", "PRDCOLOR", "CTGNO");
			// ResultSet 객체 rs 는 2차원 테이블로 구성
			// rs.next(): 현재 포인팅 하는 튜플에서 다음 튜플로 이동-> 다음이 있으면 true, 아니면 false
			// rs.getXXX(컬럼번호/컬럼명): 현재 포인팅하는 튜플의 컬럼값 반환
			// XXX 에는 컬럼 타입 작성-> getString() getInt() getDouble() getDate()
			while (rs.next()) {
				String prdNo = rs.getString(1);
				String prdName = rs.getString(2);
				int prdPrice = rs.getInt(3);
				String prdMaker = rs.getString(4);
				String prdColor = rs.getString(5);
				String ctgNo = rs.getString(6);
				
				System.out.format("%-5s %-20s %-15d %-15s %-10s %-5s%n",
									prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
		
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
