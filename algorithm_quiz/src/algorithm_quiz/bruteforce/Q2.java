package algorithm_quiz.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q2 {

	public static void main(String[] args) {

	}
	
	private static void p2() {
		List<Integer> dwarfs = new ArrayList<Integer>(nineDwarfs());
		int sum = dwarfs.stream().mapToInt(e -> e).sum();
		int diff = sum - 100;
		
		boolean flag = false;
		for (int i = 0; i < dwarfs.size() - 1; i++) {
			if (flag) break;
			for (int j = 1; j < dwarfs.size(); j++) {
				Integer n = dwarfs.get(i);
				Integer k = dwarfs.get(j);
				if (diff == n + k) {
					dwarfs.remove(n);
					dwarfs.remove(k);
					flag = true;
					break;
				}
			}
		}
		
		System.out.println(dwarfs);
	}
	
	private static List<Integer> nineDwarfs() {
		List<Integer> dwarfs = new ArrayList<Integer>();
		Random random = new Random();
		
		int sum = 0;
		while (dwarfs.size() < 6) {
			int n = random.nextInt(9, 16);
			sum += n;
			dwarfs.add(n);
		}
		
		dwarfs.add(100 - sum);
		dwarfs.add(999999);
		dwarfs.add(9999999);
		return dwarfs;
	}
}
