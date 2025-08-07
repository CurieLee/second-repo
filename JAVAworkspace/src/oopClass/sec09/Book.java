package oopClass.sec09;

public class Book {
	String title;
	String author;
	int price;
	
	public Book () {
		// 생성자에서 다른 생성자 호출을 할수있는 메소드
		this("Javascript", "이몽룡", 18000);
	}
	public Book (String t, String au, int p) {
		title = t;
		author = au;
		price = p;
	}
	
	public void show() {
		System.out.println("도서명: " + title);
		System.out.println("저자명: " + author);
		System.out.println("가격: " + price);
	}
}
