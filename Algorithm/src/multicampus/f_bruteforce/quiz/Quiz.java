package multicampus.f_bruteforce.quiz;

import java.util.Scanner;

public class Quiz {
	// DoomNumber
	// 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다
	// 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666 ... 6660, 6661
	// n 번째 종말의 수를 구하는 함수를 구현하시오
	
	// 입력값: 5
	// 결과: 4666
	
	public static void main(String[] args) {
		q1(5);
		q2();
	}
	
	private static void q1(int i) {
		int count = 0;
		int num = 666;
		
		while (true) {
			if (String.valueOf(num).contains("666")) {
				count++;
				if (count == i)
					break;
			}
			num++;
		}
		
		System.out.println("결과: " + num);
	}
	
	private static void q2() {
		
	}
}

