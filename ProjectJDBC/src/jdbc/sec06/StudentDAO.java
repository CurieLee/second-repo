package jdbc.sec06;

import java.util.ArrayList;

//DAO 의 메소드 표준 정의
public interface StudentDAO {
	// 1명의 학생 정보 등록
	public void insertStudent(StudentDTO dto);
	
	// 전체 학생 정보 조회
	public ArrayList<StudentDTO> getAllStudent();
	
	// 상세 학생 정보 조회
	public StudentDTO detailStudent(String stdNo);
	
	// 1명 학생 정보 삭제 
	public void deleteStudent(String stdNo); 
	
	// 1명 학생 정보 수정
	public void updateStudent(StudentDTO dto);
	
	// 과별 학생 검색: 0~n명 반환 기준으로 메소드 생성
	public ArrayList<StudentDTO> searchStudent(String dptNo);
}
