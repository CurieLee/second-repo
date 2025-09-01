package algorithm_quiz.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열을 입력하시오: ");
		String input = scan.nextLine();
		
		System.out.println(frequentChars(input));
	}
	
	public static List<Character> frequentChars(String input) {
		Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (ch != ' ') {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }

        int maxFreq = 0;
        for (int freq : freqMap.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        return result;

	}
}
