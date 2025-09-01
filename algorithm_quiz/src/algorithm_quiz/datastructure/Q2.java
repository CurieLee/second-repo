package algorithm_quiz.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("몇장의 카드를 가지고 있습니까? ");
		int input = scan.nextInt();
		
		cardGame(input);
	}
	
	public static void cardGame(int input) {
		
		Queue<Integer> queue = new LinkedList<>();
        List<Integer> trash = new ArrayList<>();
        
        for (int i = 1; i <= input; i++) {
            queue.offer(i);
        }
        
        while (1 < queue.size()) {
            trash.add(queue.poll());
            queue.offer(queue.poll());
        }

        int lastCard = queue.peek();

        System.out.print("trash: ");
        for (int i = 0; i < trash.size(); i++) {
            System.out.print(trash.get(i));
            if (i != trash.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("card: " + lastCard);
        
        
	}
}
