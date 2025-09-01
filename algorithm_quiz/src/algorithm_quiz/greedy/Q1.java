package algorithm_quiz.greedy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요: ");
		int input = scan.nextInt();
		
		Map<Integer, Integer> coinMap = getCoins(input);
        System.out.println(coinMap);
	}
	
	public static Map<Integer, Integer> getCoins(int input) {
		int[] coins = {500, 100, 50, 10, 1};
		Map<Integer, Integer> result = new LinkedHashMap<>();
		
		for (int coin : coins) {
            int count = input / coin;
            input %= coin;
            result.put(coin, count);
        }

        return result;
	}
	
	// 해설
	private static void q1(int price) {
		Map<Integer, Integer> coinMap = new LinkedHashMap<>();
		coinMap.put(500, 0);
		coinMap.put(100, 0);
		coinMap.put(50, 0);
		coinMap.put(10, 0);
		coinMap.put(1, 0);
	
		for (int coin : coinMap.keySet()) {
			coinMap.put(coin,price/coin);
			price%= coin;
		}
		
		for (int coin : coinMap.keySet()) {
			System.out.printf("%d 동전 %d개 \n", coin, coinMap.get(coin));
		}
	}
}
