package Package2;
import java.util.Scanner;

public class BreakEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int balance = 100000;
		int withdrawal;
		
		System.out.println("현재 잔액: " + balance);
		
		while (true) {
			System.out.print("인출액 입력: ");
			withdrawal = scan.nextInt();
			
			if (withdrawal <= balance) 
				balance -= withdrawal;
			else	break;
		}
		
		System.out.println("잔액부족. 현재 잔액: " + balance);
		scan.close();
	}
}
