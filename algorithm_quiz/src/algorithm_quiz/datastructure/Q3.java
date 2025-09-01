package algorithm_quiz.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("몇 명의 인원이 있습니까? ");
		int n = scan.nextInt();
		System.out.print("몇 번째 사람을 제거하시겠습니까? ");
		int k = scan.nextInt();
		
		List<Integer> order = josephus(n, k);
        System.out.println(order);
	}
	
	public static List<Integer> josephus(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }

            result.add(queue.poll());
        }

        return result;
	}
}
