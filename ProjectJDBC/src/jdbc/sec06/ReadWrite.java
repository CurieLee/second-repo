package jdbc.sec06;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

// 입출력 기능
public class ReadWrite {

	// 학생정보 입력 메소드 (insert/update 사용)
	// StudentDTO 타입 매개변수
	public static StudentDTO getStdInfo(Scanner scan) {
		StudentDTO dto = null;
		try {
			// 학생 데이터 입력 
			System.out.println("학생 정보 등록");
			System.out.print("학번 입력: ");
			String stdNo = scan.nextLine();
			
			System.out.print("이름 입력: ");
			String stdName = scan.nextLine();
			
			System.out.print("학년 입력: ");
			int grade = scan.nextInt();
			scan.nextLine();
			
			System.out.print("생년월일 입력: ");
			String stdBirth = scan.nextLine();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-mm-dd");
			Date date = fm.parse(stdBirth);
			
			System.out.print("학과번호 입력: ");
			String dptNo = scan.nextLine();
			
			dto = new StudentDTO(stdNo, stdName, grade, date, dptNo);
			
			
		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	// 출력 메소드
	public static void writeStdInfo(ArrayList<StudentDTO> stdList) {
		System.out.println("------ 전체 학생 정보 조회 ------");
		System.out.format("%-10s\t %-10s\t %-4s \t%13s %5s\n", 
				"학번", "이름", "학년", "생일", "학과번호");	
		
		for(StudentDTO dto : stdList) {
			String stdNo = dto.getStdNo();
			String stdName = dto.getStdName();
			int grade = dto.getGrade();
			Date stdBirth = dto.getStdBirth();
			String dptNo = dto.getDptNo();
			
			// 한 행씩 출력 
			System.out.format("%-10s\t %-10s\t %-4d \t%13s %5s\n", 
								stdNo, stdName, grade, stdBirth, dptNo);
		}
	}
	
	// 출력 메소드
	public static void writeStdInfo(StudentDTO dto) {
		System.out.println("------ 학생 정보 조회 ------");
		System.out.format("%-10s\t %-10s\t %-4s \t%13s %5s\n", 
				"학번", "이름", "학년", "생일", "학과번호");	
		
		String stdNo = dto.getStdNo();
		String stdName = dto.getStdName();
		int grade = dto.getGrade();
		Date stdBirth = dto.getStdBirth();
		String dptNo = dto.getDptNo();
			
		// 한 행씩 출력 
		System.out.format("%-10s\t %-10s\t %-4d \t%13s %5s\n", 
							stdNo, stdName, grade, stdBirth, dptNo);
		
	}
}
