package genericCollection.sec06;
import java.util.*;

public class ListGenMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String> ();
		
		list.add("Java");
		list.add("Database");
		list.add("HTML");
		list.add("Java");
		//list.add(100);

		System.out.println("총 객체수: " + list.size());
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		list.remove(1);
		System.out.println();
		for (String value : list)
			System.out.println(value);
		
		list.add("MultiMedia");
		System.out.println();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i) + ": " + list.get(i).length());
		for (String value : list)
			System.out.println(value.length());
	}

}
