package secure.sec02.ErrorBasedSecure;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// 취약점이 있는 코드/잘못 개발된 코드
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("학생번호 입력: ");
			String studentNo = scan.nextLine();
			System.out.println(studentNo);
			// ' or 1=1 -- 입력하는 경우 -- <-해당 SQL 주석 기호 때문에 injection 발생
			
			// SQL 쿼리문 작성: 플레이스 홀더를 사용하지 않고 변수를 이용해 코딩 (전체컬럼 추출)
			// PreparedStatement 
			String sql = "SELECT * FROM student WHERE stdno='" + studentNo + "'";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 제목 출력
			System.out.println("============ 학생정보 조회 ============");
			System.out.println("학생번호 \t\t 학생이름 \t\t 학년 ");
			
			// 필요 내용만 추출 
			while (rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int grade = rs.getInt(3);
				
				// 한 행씩 출력
				System.out.format("%-10s\t %-10s\t %-6d \n", stdNo, stdName, grade);			
			}
			
			// 리소스 반환
			rs.close();
			pstmt.close();
			con.close();
			scan.close();
				
		} catch (SQLException e) {
			e.printStackTrace(); // 개발단계에서 개발자가 확인하기 위한 에러출력
		} finally {
			
		}
	}
}
