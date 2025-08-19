package multicampus.b_star;

import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {
		System.out.print("입력: ");
		int input = new Scanner(System.in).nextInt();
		
		// input: 5
		// i: 1, 2, ... input
		// blank: input - i
		// star: 2 * i + 1
		
		// i: 1, 2, ... input
		// blank: i
		// star: 2 * input + 1
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < input - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = input - 2; 0 <= i ; i--) {
			for (int j = 0; j < input - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
