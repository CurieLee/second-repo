package genericCollection.sec06;
import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(100);
		list.add("홍길동");
		list.add(7.7);
		list.add("Java");
		list.add("Java");
		
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		System.out.println();
		list.add(0, "변경");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		System.out.println();
		list.remove(1);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		System.out.println();
		System.out.println(list.contains("홍길동"));
		if (!list.contains("이몽룡"))
			list.add("이몽룡");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

}
