package genericCollection;
import java.util.*;

public class SortCollection {

	static void printList(ArrayList<String> list) {
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String element = iter.next();
			String sep;
			if (iter.hasNext())
				sep = "-> ";
			else
				sep = "\n";
			
			System.out.print(element + sep);
		}
	}
	
	public static void main(String[] args) {
		// Collection 객체에 사용 가능한 sort reverse 메소드
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add("터미네이터");
		myList.add("아바타");

		System.out.println("리스트 순서: ");
		for (String m : myList)
			System.out.println(m);
		
		System.out.println("\n오름차순 정렬: "); // Collection static method-> sort
		Collections.sort(myList);
		printList(myList);
		
		System.out.println("\n내림차순 정렬: "); // Collection static method-> reverse
		Collections.reverse(myList);
		printList(myList);
		
		// sort/reverse 메소드는 실제 리스트 순서 변경
	}

}
