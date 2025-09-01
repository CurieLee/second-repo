package algorithm_quiz.divideandconquer;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("매개변수 A 입력: ");
		int a = scan.nextInt();
		System.out.print("매개변수 B 입력: ");
		int b = scan.nextInt();
		
		System.out.println(power(a, b));
	}
	
	public static int power(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;

        int half = power(a, b / 2);

        if (b % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }
	
}
