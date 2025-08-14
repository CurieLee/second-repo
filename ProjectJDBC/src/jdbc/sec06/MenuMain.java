package jdbc.sec06;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMain {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAOImpl();
		Scanner scan = new Scanner(System.in);
		ArrayList<StudentDTO> stdList = null;
		String stdNo;
		String dptNo;
		String dptName;
		
		try {
			boolean loop = true;
			while (loop) {
				System.out.println("------------------------------------");
				System.out.println("\t\t메뉴");
				System.out.println("------------------------------------");
				System.out.println("1. 학생 정보 등록");
				System.out.println("2. 학생 정보 수정");
				System.out.println("3. 학생 정보 삭제");
				System.out.println("4. 전체 학생 목록 조회");
				System.out.println("5. 학과별 학생 조회");
				System.out.println("6. 종료");
				System.out.println("------------------------------------");
				System.out.print("메뉴 번호 입력: ");
				int input = scan.nextInt();
				scan.nextLine();
				switch (input) {
				case 1:
					System.out.println("************************************");
					System.out.println("학생 정보 등록");
					dao.insertStudent(ReadWrite.getStdInfo(scan));
					System.out.println("************************************");
					break;
				case 2:
					System.out.println("************************************");
					System.out.println("학생 정보 수정");
					System.out.print("수정할 학생의 학번을 입력하세요: ");
					stdNo = scan.nextLine();
					ReadWrite.writeStdInfo(dao.detailStudent(stdNo));
					// 수정할 내용 입력
					System.out.println("\n수정할 학생의 정보를 입력하세요");
					dao.updateStudent(ReadWrite.getStdInfo(scan));
					System.out.println("************************************");
					break;
				case 3:
					System.out.println("************************************");
					System.out.println("학생 정보 삭제");
					System.out.print("삭제 학생의 학번을 입력하세요: ");
					stdNo = scan.nextLine();
					dao.deleteStudent(stdNo);
					System.out.println("************************************");
					break;
				case 4:
					System.out.println("************************************");
					System.out.println("전체 학생 목록 조회");
					stdList = dao.getAllStudent();
					ReadWrite.writeStdInfo(stdList);
					System.out.println("************************************");
					break;
				case 5:
					System.out.println("************************************");
					System.out.println("학과별 학생 목록 조회");
					System.out.print("학과이름을 입력하세요: ");
					dptName = scan.nextLine();
					ReadWrite.writeStdInfo(dao.searchStudent(dptName));
					System.out.println("************************************");
					break;
				case 6:
					System.out.println("************************************");
					System.out.println("학생 정보 시스템을 종료합니다");
					System.out.println("************************************");
					loop = false;
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요");
				}
			}
		} catch (Exception e) {
			System.out.println("예기치 못한 오류가 발생했습니다.");
			e.printStackTrace();
		} finally {
			scan.close();
	        dao.closeConnection();
		}

	}

}
