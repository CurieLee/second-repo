package genericCollection.sec15;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashMapStudent {

	public static void main(String[] args) {
		// 3명의 학생 점수를 Map 에 저장
		// Student 클래스를 key 로 점수를 value 로 저장
		
		// Map<Student, Integer> map = new HashMap<Student, Integer>();
		Map<Student, Integer> map = new LinkedHashMap<Student, Integer>();
		
		map.put(new Student(1, "홍길동"), 90);
		map.put(new Student(2, "홍길동"), 85);
		map.put(new Student(3, "성춘향"), 95);
		
		// key 중복되면 value 를 update 진행
		// Student 클래스에 상속받은 hasCode(), equals() 객체를 따로 구성 update 진행되지 않고 추가됨
		// HashSet() 과 같은 내용
		map.put(new Student(3, "성춘향"), 100);
		
		// 순서 보장하지 않음-> 순서대로 하고싶으면 LinkedHashMap 사용
		for (Student k : map.keySet()) {
			System.out.println(k.getStdNo() + " " + k.getStdName() + " " + map.get(k));
		}
		
	}

}
