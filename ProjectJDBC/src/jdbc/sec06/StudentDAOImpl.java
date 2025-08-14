package jdbc.sec06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

//CRUD 기능 구현 클래스: interface 구현
public class StudentDAOImpl implements StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StudentDTO std = null;
	ArrayList<StudentDTO> stdList = null;
	
	// 생성자에서 DB 연결
	public StudentDAOImpl() {
		conn = DBConnect.getConnection();
	}
	
	@Override
	public void insertStudent(StudentDTO dto) {
		// 학생 정보 입력
		try {
			String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 저장된 학생 정보는 DTO 매개변수로 전달
			pstmt.setString(1,  dto.getStdNo());
			pstmt.setString(2, dto.getStdName());
			pstmt.setInt(3, dto.getGrade());
			pstmt.setDate(4, new java.sql.Date(dto.getStdBirth().getTime()));
			pstmt.setString(5, dto.getDptNo());
			
			int result = pstmt.executeUpdate();
			
			if (0 < result) {
				System.out.println("학생정보 등록 성공");
			} else {
				System.out.println("학생정보 등록 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
		
	}

	@Override
	public ArrayList<StudentDTO> getAllStudent() {
		// 모든 학생정보 조회
		stdList = new ArrayList<StudentDTO> ();
		try {
			String sql = "SELECT * FROM student ORDER BY stdNo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int grade = rs.getInt(3);
				Date stdBirth = rs.getDate(4);
				String dptNo = rs.getString(5);
				
				// 각 컬럼의 정보를 dto 로 구성
				std = new StudentDTO(stdNo, stdName, grade, stdBirth, dptNo);
				// ArrayList 에 추가
				stdList.add(std);
			}
			
		} catch (SQLException e) {
			System.out.println("전체 학생정보 조회 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return stdList;
	}

	@Override
	public StudentDTO detailStudent(String stdNo) {
		// 1명 학생정보 조회
		try {
			String sql = "SELECT * FROM student WHERE stdNo=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  stdNo);
			
			rs = pstmt.executeQuery();
			
			// primary key 조회-> 0명/1명 조회 반복 필요없음
			// 릴레이션 반환
			// 존재하는 학생의 학번이 전달되었다고 가정
			// 첫번째 줄은 속성이기 때문에 무조건 next() 수행
			rs.next();
			
			stdNo = rs.getString(1);
			String stdName = rs.getString(2);
			int grade = rs.getInt(3);
			Date stdBirth = rs.getDate(4);
			String dptNo = rs.getString(5);
				
			// 각 컬럼의 정보를 dto 로 구성
			std = new StudentDTO(stdNo, stdName, grade, stdBirth, dptNo);
			
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return std;
	}

	@Override
	public void deleteStudent(String stdNo) {
		// 1명 학생정보 삭제
		try {
			// 삭제 쿼리 
			String sql = "DELETE FROM student WHERE stdNo=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  stdNo);
			
			int result = pstmt.executeUpdate();
			
			System.out.println("학생정보 삭제 성공");
			
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
		
	}

	@Override
	public void updateStudent(StudentDTO dto) {
		// 1명 학생정보 수정
		try {
			String sql = "UPDATE student SET stdName=?, grade=?,"
							+ "stdBirth=?, dptNo=? WHERE stdNo=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getStdName());
			pstmt.setInt(2, dto.getGrade());
			pstmt.setDate(3, new java.sql.Date(dto.getStdBirth().getTime()));
			pstmt.setString(4, dto.getDptNo());
			pstmt.setString(5, dto.getStdNo());
			
			pstmt.executeUpdate();
			
			System.out.println("학생정보 수정 성공");
			
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
		
	}

	@Override
	public ArrayList<StudentDTO> searchStudent(String dptNo) {
		// 특정과에 소속된 학생 조회
		stdList = new ArrayList<StudentDTO> ();
		try {
			String sql = "SELECT * FROM student WHERE dptNo=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  dptNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int grade = rs.getInt(3);
				Date stdBirth = rs.getDate(4);
				dptNo = rs.getString(5);
				
				// 각 컬럼의 정보를 dto 로 구성
				std = new StudentDTO(stdNo, stdName, grade, stdBirth, dptNo);
				// ArrayList 에 추가
				stdList.add(std);
			}
			
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return stdList;
	}

}
