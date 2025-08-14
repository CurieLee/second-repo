package jdbc.sec06;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// DAO 기능 확인
		// 필요 객체생성 및 변수 선언
		//StudentImpl impl = new StudentImpl(); // 객체 생성시 자동으로 DB 연결 
		StudentDAO dao = new StudentDAOImpl();
		Scanner scan = new Scanner(System.in);
		ArrayList<StudentDTO> stdList = null;
		String stdNo;
		String dptNo;
		
		try {
			// 1 학생정보 입력
			// StudentImpl 의 insertStudent(StudentDTO) 호출
			dao.insertStudent(ReadWrite.getStdInfo(scan));
			
			// 2 전체 학생 정보 조회
			// StudentImpl 의 getAllStudent() 호출
			stdList = dao.getAllStudent();
			ReadWrite.writeStdInfo(stdList);
			
			// 3 학생정보 수정-> 수정할 학생의 개인정보 출력
			System.out.print("수정할 학생의 학번을 입력하세요: ");
			stdNo = scan.nextLine();
			ReadWrite.writeStdInfo(dao.detailStudent(stdNo));
			// 수정할 내용 입력
			dao.updateStudent(ReadWrite.getStdInfo(scan));
			
			// 4 학과 번호를 통한 검색 
			System.out.println("학과번호를 입력하세요: ");
			dptNo = scan.nextLine();
			ReadWrite.writeStdInfo(dao.searchStudent(dptNo));
			
			// 5 학생정보 삭제
			System.out.print("삭제할 학생의 학번을 입력하세요: ");
			stdNo = scan.nextLine();
			dao.deleteStudent(stdNo);
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
		scan.close();
	}

}
