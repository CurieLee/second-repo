package genericCollection.sec13;
import java.util.*;
import java.util.Map.Entry;

public class HashMapEx {

	public static void main(String[] args) {
		// HasgMap 사용 예제
		// HashMap: key 중복 불가능 value 중복 가능
		// (key, value) key 를 통해 데이터 구분
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("홍길동", 90);
		map.put("이몽룡", 80);
		map.put("성춘향", 95);
		map.put("홍길동", 85); // key 중복값이 들어오는 경우-> value update
		
		System.out.println("총 객체수: " + map.size());
		System.out.println(map.get("홍길동"));
		
		System.out.println("-------------- 전체순회 1 ---------------");
		
		for (String k : map.keySet())
			System.out.println(k + " : " + map.get(k));
		
		// keyset 변수 저장
		Set<String> keyset = map.keySet();
		
		System.out.println("-------------- 전체순회 2 ---------------");
		// forEach 의 콜백함수에 key/value  인수로 전달
		map.forEach((key, value)-> {
			System.out.println(key + " : " + value);
		});

		System.out.println("-------------- 전체순회 3 ---------------");
		// entrySet() 메소드 활용-> key=value entry 를 Set 타입으로 반환
		for (Entry<String, Integer> entry : map.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
		
		System.out.println(map.entrySet());
		//map.get(key): map에 대항 키가 존재하지 않으면 반환값은?
		System.out.println(map.get("변학도")); // ERROR 발생 x null 반환
	}

}
