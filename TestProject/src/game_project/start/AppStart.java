package game_project.start;
import game_project.info.AppInfo;
import game_project.game.*;

import java.util.Scanner;

public class AppStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("************************************");
		System.out.println("\t게임에 오신것을 환영합니다");
		System.out.println("************************************");
		
		boolean loop = true;
		while (loop) {
			System.out.println("------------------------------------");
			System.out.println("\t\t메뉴");
			System.out.println("------------------------------------");
			System.out.println("1. 애플리케이션 정보");
			System.out.println("2. 가위바위보 게임");
			System.out.println("3. 숫자맞히기 게임");
			System.out.println("4. 종료");
			System.out.println("------------------------------------");
			System.out.print("메뉴 번호 입력: ");
			int input = scan.nextInt();
			
			switch(input) {
			case 1:
				AppInfo appInfo = new AppInfo();
				break;
			case 2:
				GaBaBo gababo = new GaBaBo();
				break;
			case 3:
				Guess guess = new Guess();
				break;
			case 4:
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
