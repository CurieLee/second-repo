package game_project.game;

import java.util.Scanner;
import java.util.Random;

public class GaBaBo {
	private Random rand = new Random();
	
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
			
			int com = rand.nextInt(3) + 1; // 1~3 랜덤 숫자 생성
			int user;
			
			try {
				user = Integer.parseInt(scan.nextLine()); // 사용자 입력값 저장 변수
			} catch (NumberFormatException e) { // 입력값 예외 처리
				System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                continue;
			}
			
			// 사용자 입력값 검증 범위 외 숫자 재입력
			if (user < 1 || 3 < user) {
				System.out.println("잘못된 입력입니다. 1, 2, 3 중 하나를 입력해주세요.");
				continue;
			}
			
			// 결과 출력
			printResult(com, user);
		
			System.out.print("계속 하시겠습니까? (y/n): ");
			String input = scan.next().trim().toLowerCase();
			if (input.equals("n")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}
	
	// 숫자에 따른 문자열 변환
	private String choiceToString(int choice) {
        switch (choice) {
            case 1: return "가위";
            case 2: return "바위";
            case 3: return "보";
            default: return "";
        }
    }
	
	// 가위바위보 결과 출력
	public void printResult(int com, int user) {
        if (com == user) {
            System.out.println("무승부 입니다.");
        } else if ((user == 1 && com == 3) ||
                   (user == 2 && com == 1) ||
                   (user == 3 && com == 2)) {
            System.out.println("당신이 이겼습니다.");
        } else {
            System.out.println("당신이 졌습니다.");
        }
		
        System.out.println("컴퓨터는 " + choiceToString(com) + " 입니다.");
        System.out.println("당신은 " + choiceToString(user) + " 를 선택했습니다.");
	}

}
