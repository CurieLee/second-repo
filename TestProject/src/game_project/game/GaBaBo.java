package game_project.game;

import java.util.Scanner;
import java.util.Random;

public class GaBaBo {
	private int com;
	private int user;
	
	public GaBaBo() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t    가위바위보 게임");
		System.out.println("------------------------------------");
		System.out.println("1.가위 2.바위 3.보");
		
		while (true) {
			System.out.println("------------------------------------");
			System.out.print("번호 입력: ");
			com = getCom();
			user = scan.nextInt();
			if (user < 1 || 3 < user) {
				System.out.println("잘못된 입력값 입니다. 다시 입력 해주세요.");
				continue;
			}
			RSP(com, user);
		
			System.out.print("계속 하시겠습니까? (y/n): ");
			String input = scan.next();
			if (input.equals("n"))	break;
		}
	}
	
	public int getCom() {
		Random rand = new Random();
		com = rand.nextInt(3) + 1;
		
		return com;
	}
	
	public String getString(int com) {
		if (com == 1)
			return "가위";
		else if (com == 2)
			return "바위";
		else if (com == 3)
			return "보";
		return "";
	}
	
	public void RSP(int com, int user) {
		if (com == user)
			System.out.println("무승부 입니다.");
		else if (user == 1) {
			if (com == 2)
				System.out.println("당신이 졌습니다.");
			else if (com == 3)
				System.out.println("당신이 이겼습니다.");
		} else if (user == 2) {
			if (com == 3)
				System.out.println("당신이 졌습니다.");
			else if (com == 1)
				System.out.println("당신이 이겼습니다.");
		} else if (user == 3) {
			if (com == 1)
				System.out.println("당신이 졌습니다.");
			else if (com == 2)
				System.out.println("당신이 이겼습니다.");
		}
		
		System.out.println("컴퓨터는 " + getString(com) + " 입니다.");
		
	}

}
