package algorithm_quiz.bruteforce;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("몇 번째 종말의 수를 구하시겠습니까? ");
		int n = scan.nextInt();
		
		doomNumber(n);
	}
	
	private static void doomNumber(int n) {
		int count = 0;
		int num = 666;
		
		while (true) {
			if (String.valueOf(num).contains("666")) {
				count++;
				if (count == n)
					break;
			}
			num++;
		}
		
		System.out.println(num);
	}
}
