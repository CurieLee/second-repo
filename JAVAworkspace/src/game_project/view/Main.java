package game_project.view;

import game_project.model.MemberDAO;
import game_project.model.MemberDAOImpl;
import game_project.info.AppInfo;
import game_project.game.*;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
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
			System.out.println("3. 회원정보 수정");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 애플리케이션 정보");
			System.out.println("6. 가위바위보 게임");
			System.out.println("7. 숫자맞히기 게임");
			System.out.println("8. 종료");
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
					JoinView join = new JoinView();
					join.join();
					break;
				case 2:
					// 로그인
					LoginView login = new LoginView();
					login.login();
					break;
				case 3:
					// 회원정보 수정
					MemberUpdateView muv = new MemberUpdateView();
					muv.update();
					break;
				case 4:
					// 회원 탈퇴
					MemberDeleteView mdv = new MemberDeleteView();
					mdv.delete();
					break;
				case 5:
					// 애플리케이션 정보 출력
					new AppInfo();
					break;
				case 6:
					// 가위바위보 게임 실행
					new GaBaBo();
					break;
				case 7:
					// 숫자 맞히기 게임 실행
					new Guess();
					break;
				case 8:
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
