package Package2;
import java.util.Scanner;

public class DoWhileEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		String answer;
		
		System.out.println("과정 안내 프로그램");
		
		do {
			System.out.println("\n 1~4 번호 입력: ");
			input = scan.nextInt();
			
			switch (input) {
				case 1: System.out.println("Java 프로그래밍"); break;
				case 2: System.out.println("데이터베이스"); break;
				case 3: System.out.println("빅데이터 분석"); break;
				case 4: System.out.println("AI"); break;
				default: System.out.println("잘못된 값 입니다.");
			}
			
			System.out.println("\n 계속 하시겠습니까? (y/n): ");
			answer = scan.next();
		} while (answer.contentEquals("y"));
		
		System.out.println("종료되었습니다.");
		scan.close();
	}
}
