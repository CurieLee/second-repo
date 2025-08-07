package genericCollection.sec02;

public class Main {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String> ();
		box1.set("helo");
		String str = box1.get();
		
		Box<Integer> box2 = new Box<Integer> ();
		box2.set(7);
		int num = box2.get();
		System.out.println(num);
	}
}
