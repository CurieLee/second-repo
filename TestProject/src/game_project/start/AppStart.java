package game_project.start;

import game_project.UserDAO;
import game_project.UserDAOImpl;
import game_project.info.AppInfo;
import game_project.game.*;

import java.util.Scanner;

public class AppStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		UserDAO userDAO = UserDAOImpl.getInstance();
		
		System.out.println("************************************");
		System.out.println("\t게임에 오신것을 환영합니다");
		System.out.println("************************************");
		
		boolean loop = true; // 반복문 중단용 변수
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
			int input = scan.nextInt();
			
			switch(input) {
				case 1:
					new Join(userDAO);
					break;
				case 2:
					new Login(userDAO);
					break;
				case 3:
					new AppInfo();
					break;
				case 4:
					new GaBaBo();
					break;
				case 5:
					new Guess();
					break;
				case 6:
					System.out.println("************************************");
					System.out.println("종료합니다!");
					System.out.println("************************************");
					loop = false;
					break;
				default:
					System.out.println("잘못된 입력값 입니다. 다시 입력 해주세요");
			}
		}
		
		
	}

}
