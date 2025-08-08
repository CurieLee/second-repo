package game_project.game;

import java.util.Random;
import java.util.Scanner;

public class Guess {
	public Guess() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t    숫자맞히기 게임");
		System.out.println("------------------------------------");
		System.out.println("어떤 숫자일까요? 알아맞혀보세요 (1~10)");
		System.out.println("------------------------------------");
		System.out.print("숫자 입력: ");
		
		// 1~10 사이 랜덤 숫자 생성
		Random rand = new Random();
		int answer = rand.nextInt(10) + 1;
		
		while (true) {
			int guess;
			try {
				guess = Integer.parseInt(scan.nextLine()); // 사용자 입력값 저장 변수
			} catch (NumberFormatException e) { // 입력값 예외 처리
				System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
				continue;
			}
			
			// 사용자 입력값 검증 범위 외 숫자 재입력
			if (guess < 1 || 10 < guess) {
				System.out.println("잘못된 입력값 입니다. 1~10 사이의 숫자를 입력해주세요.");
				continue;
			}
			
			// 정답 비교함수 isCorrect
			if (isCorrect(answer, guess) == true)  {
				System.out.println("------------------------------------");
				System.out.println("맞았습니다. 나의 숫자는 " + guess + " 입니다.");
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
	
	public boolean isCorrect(int answer, int guess) {
		return answer == guess;
	}
	

}
