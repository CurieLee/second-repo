package Package2;
import java.util.Scanner;

public class WhileEx {
	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.print("숫자 입력: ");
		num = scan.nextInt();
		
		while (num != 7) {
			System.out.print("다시 입력: ");
			num = scan.nextInt();
		}
		
		System.out.print("7 입력. 종료합니다. ");
		scan.close();
	}

}
