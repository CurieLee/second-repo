package genericCollection.sec16;
import java.util.*;

import java.util.Map;

public class HashTableEx {

	public static void main(String[] args) {
		// HashTable HashMap 사용법 동일-> multi thread 동기화 구현
		// 동기화 구현이 되어있으므로 쓰레드 접근(main) 객체 잠금 발생
		// 멀티쓰레드가 아닌경우 매우 비효율적
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "123");
		map.put("winter", "123");

		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			System.out.print("아이디: ");
			String id = scan.nextLine();
			System.out.print("비밀번호: ");
			String pwd = scan.nextLine();
			
			// 아이디에 해당하는 키가 존재하는지 확인
			if (map.containsKey(id)) {
				// 비밀번호 일치 확인
				if (map.get(id).equals(pwd)) {
					System.out.println("로그인 되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else 
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
		}
	}

}
