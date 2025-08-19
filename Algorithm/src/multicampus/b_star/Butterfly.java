package multicampus.b_star;

import java.util.Scanner;

public class Butterfly {

	public static void main(String[] args) {
		System.out.print("입력: ");
		int input = new Scanner(System.in).nextInt();
		
		// i: 1, 2, ... input
		// star: i
		// blank: 2 * (input - i)
		
		// i: 1, 2, ... input - 1
		// star: input - i
		// blank: 2 * i
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < 2 * (input - i); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = input; 0 < i; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < 2 * (input - i); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}

	}

}
