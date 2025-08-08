package oopClass.sec09;

public class BookMain {
	public static void main(String[] args) {
		Book bk1 = new Book("Java", "홍길동", 20000);
		Book bk2 = new Book();
		
		bk1.show();
		bk2.show();
	}
}
