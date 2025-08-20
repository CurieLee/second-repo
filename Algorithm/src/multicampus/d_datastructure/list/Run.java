package multicampus.d_datastructure.list;

import java.util.Collections;
import java.util.ArrayList;

import multicampus.d_datastructure.dto.School;

public class Run {

	public static void main(String[] args) {
		System.out.println(init());
		// testGet();
		// testRemove();
		// testForEach();
		//testSet();
		testSort();
	}
	private static void testSort() {
		School seoulUni = new School("서울대", "관악구", "대학교");
		School yeonsaeUni = new School("연세대", "서울", "대학교");
		School minsa = new School ("민사고", "대전", "고등학교");
		School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");
		
		ArrayList<School> schools = new ArrayList<School>();
		schools.add(seoulUni);
		schools.add(yeonsaeUni);
		schools.add(minsa);
		schools.add(multicampus);
		
		//레벨을 기준으로 오름차순 정렬, 대학이 같다면 이름으로 내림차순 정렬
		Collections.sort(schools);
		Collections.sort(schools, (o1, o2) -> o1.getName().compareTo(o2.getName()));

		System.out.println(schools);
		// 반드시 구현해야하는 메소드가 하나인 인터페이스는 람다표현식으로 구현 가능
	}
	
	private static void testSet() {
		_ArrayList<Integer> list = init();
		list.set(0, 10);
		System.out.println(list);
	}
	
	private static void testForEach() {
		// 제어반전 IOC
		_ArrayList<Integer> list = init();
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		// Iterable
		// hasNext, Next
	}
	
	private static _ArrayList<Integer> init() {
		_ArrayList<Integer> list = new _ArrayList<Integer> ();
		for (int i = 0; i < 15; i++) {
			list.add(i);
		}
		
		return list;
	}
	
	private static void testGet() {
		_ArrayList<Integer> list = init();
		for (int i = 5; i < 8; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void testRemove() {
		_ArrayList<Integer> list = init();
		for (int i = 5; i < 8; i++) {
			list.remove(i);
		}
		
		System.out.println(list);
	}
}
