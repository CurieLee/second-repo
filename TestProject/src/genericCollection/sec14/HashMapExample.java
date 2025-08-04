package genericCollection.sec14;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		// 사용자로부터 영문단어,한글단어 형태의 Entry 를 입력받아 HashMap에 저장하는 로직 구현
		Map<String, String> map = new HashMap<String, String>();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("영어단어=한글단어 형태로 사전에 등록할 단어를 입력하세요");
		System.out.println("(종료하려면 exit)");
		
		while (true) {
			
			String input = scan.nextLine();
			
			if (input.equals("exit"))
				break;
			
			String[] word = input.split("=");
			map.put(word[0], word[1]);
		}
	
		// HashMap에 입력된 영단어 검색 로직 구현
		// exit 입력-> 종료
		// 없는 단어 검색-> 사전에 없는 단어 입니다
		
		while (true) {
			System.out.print("찾고 싶은 단어는? ");
			String input = scan.next();
			
			if (input.equals("exit"))  {
				System.out.println("종료합니다.");
				break;
			}
			
			if (map.containsKey(input))
				System.out.println(map.get(input));
			else
				System.out.println(input + "는 사전에 없는 단어입니다.");

		}
		
		scan.close();

	}

}
