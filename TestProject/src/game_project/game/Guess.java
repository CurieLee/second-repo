package game_project.game;

import java.util.Random;
import java.util.Scanner;

public class Guess {
	private int com;
	private int user;
	
	public Guess() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t    숫자맞히기 게임");
		System.out.println("------------------------------------");
		System.out.println("어떤 숫자일까요? 알아맞혀보세요 (1~10)");
		System.out.println("------------------------------------");
		System.out.print("숫자 입력: ");
		
		while (true) {
			com = getCom();
			user = scan.nextInt();
			if (user < 1 || 10 < user) {
				System.out.println("잘못된 입력값 입니다. 다시 입력 해주세요.");
				continue;
			}
			
			if (G(com, user) == true)  {
				System.out.println("------------------------------------");
				System.out.println("맞았습니다. 나의 숫자는 " + user + " 입니다.");
				System.out.println("------------------------------------");
				break;
			}
			else {
				System.out.println("------------------------------------");
				System.out.println("아닙니다. 다시 맞혀보세요");
				System.out.print("다시 입력: ");
			}
		}
	}
	
	public int getCom() {
		Random rand = new Random();
		com = rand.nextInt(10) + 1;
		
		return com;
	}
	
	public boolean G(int com, int user) {
		if (com == user)	return true;
		else				return false;
	}
	

}
