package secure.sec01.Injection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*; // 정규식 클래스 추가

public class Main3 {

	public static void main(String[] args) {
		// 입력값 필터링 - 정규식 활용
		// 문자와 숫자를 제외한 나머지 특수기호 필터링 
		// union 삽입 공격에 사용하는 키워드 필터링
		
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		// 영어 소문자, 대문자, 숫자 아니면 불가능
		// SQL 질의어 불가능
		// Pattern pattern = Pattern.compile("[^a-zA-Z0-9]SELECT|DELETE|UPDATE|INSERT|CREATE|ALTER|DROP|ALL|UNION"); 
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9][SELECT|DELETE|UPDATE|INSERT|CREATE|ALTER|DROP|ALL|UNION]"); 
		Matcher matcher = null;
		
		try {
			System.out.print("학생번호 입력: ");
			String studentNo = scan.nextLine();
			System.out.println(studentNo);
			// ' or 1=1 -- 입력하는 경우 -- <-해당 SQL 주석 기호 때문에 injection 발생
			
			matcher = pattern.matcher(studentNo);
			boolean match = true;
			while (matcher.find()) { // 설정한 정규식 패턴과 전달된 문자열을 매칭시켜 문자열 확인되면 true 반환
				match = false;
				break;
			}
			
			System.out.println(match);
			
			// SQL 쿼리문 작성: 플레이스 홀더를 사용하지 않고 변수를 이용해 코딩 (전체컬럼 추출)
			// 필터링을 통해 취약점 제거
			if (match) {
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
			
			} else {
				System.out.println("잘못된 입력입니다.");
			}
				
		} catch (SQLException e) {
			e.printStackTrace(); // 개발단계에서 개발자가 확인하기 위한 에러출력
		} finally {
			
		}
	}
}
