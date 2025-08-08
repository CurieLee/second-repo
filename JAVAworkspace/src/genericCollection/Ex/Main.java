package genericCollection.Ex;
import java.util.LinkedList;

import genericCollection.sec07.Employee;

public class Main {

	public static void main(String[] args) {
		LinkedList<Product> list = new LinkedList<> ();
		
		Product p1 = new Product(100, "새우깡", 1500);
		Product p2 = new Product(101, "꼬북칩", 1800);
		Product p3 = new Product(103, "고래밥", 1500);
		
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		for (Product p : list)
			System.out.println(p.toString());

	}

}
