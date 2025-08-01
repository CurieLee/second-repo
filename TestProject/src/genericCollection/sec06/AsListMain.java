package genericCollection.sec06;
import java.util.Arrays;
import java.util.List;

public class AsListMain {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("홍길동", "이몽룡", "성춘향");
		for (String name : list1)
			System.out.println(name);
		
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for (int num : list2)
			System.out.println(num);
		
		list2.set(1, 5);
		for (int num : list2)
			System.out.println(num);
		
		list2.add(10);
		for (int num : list2)
			System.out.println(num);
	}

}
