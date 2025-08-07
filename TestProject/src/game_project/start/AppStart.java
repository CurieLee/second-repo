package game_project.start;

import game_project.UserDAO;
import game_project.UserDAOImpl;
import game_project.info.AppInfo;
import game_project.game.*;

import java.util.Scanner;

public class AppStart {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 회원정보 관리용 UserDAO 생성
		UserDAO userDAO = UserDAOImpl.getInstance();
		
		System.out.println("************************************");
		System.out.println("\t게임에 오신것을 환영합니다");
		System.out.println("************************************");
		
		boolean loop = true; // while 반복문 제어용 변수
		while (loop) {
			System.out.println("************************************");
			System.out.println("------------------------------------");
			System.out.println("\t\t메뉴");
			System.out.println("------------------------------------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 애플리케이션 정보");
			System.out.println("4. 가위바위보 게임");
			System.out.println("5. 숫자맞히기 게임");
			System.out.println("6. 종료");
			System.out.println("------------------------------------");
			System.out.print("메뉴 번호 입력: ");
			
			// 사용자 입력 예외 처리
			int input = 0;
			try {
				input = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다. 다시 시도해주세요.");
				continue;
			}
			
			// 사용자 메뉴 선택 분기 처리
			switch(input) {
				case 1:
					// 회원가입
					new Join(userDAO);
					break;
				case 2:
					// 로그인
					new Login(userDAO);
					break;
				case 3:
					// 애플리케이션 정보 출력
					new AppInfo();
					break;
				case 4:
					// 가위바위보 게임 실행
					new GaBaBo();
					break;
				case 5:
					// 숫자 맞히기 게임 실행
					new Guess();
					break;
				case 6:
					// 프로그램 종료-> 반복문 탈출
					System.out.println("************************************");
					System.out.println("종료합니다!");
					System.out.println("************************************");
					loop = false;
					break;
				default:
					// 잘못된 메뉴 입력값 처리
					System.out.println("잘못된 입력값 입니다. 다시 입력 해주세요");
			}
		}
		
		scan.close();
		
	}

}
