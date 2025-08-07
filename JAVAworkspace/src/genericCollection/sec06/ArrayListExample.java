package genericCollection.sec06;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			System.out.print("단어를 입력하세요>> ");
			String input = scan.next();
			list.add(input);
		}
		
		System.out.println("----------------------------");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		
		String longest = "";
		for (String word : list) {
			if (longest.length() < word.length())
				longest = word;
		}
		
		System.out.println();
		System.out.println("가장 긴 단어는: " + longest);
		System.out.println("가장 긴 단어의 길이는: " + longest.length());
		
	}

}
