package oopApi;

public class StringAPI {

	public static void main(String[] args) {
		String snn = "010000-1230123";
		char gen = snn.charAt(7);
		
		switch(gen) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		}
		
		String title = "Java Programming";
		System.out.println(title.indexOf("Programming"));
		System.out.println(title.indexOf("자바"));
		System.out.println(title.replace("Java", "자바"));
		System.out.println(title.substring(3));
		System.out.println(title.substring(3, 5));
		System.out.println(String.valueOf(true));
		System.out.println(title.split(" ")[0]);
		
		String str = "홍길동&이몽룡,성춘향,김자바-김길동";
		String[] names = str.split("&|,|-");
		System.out.println(names[2]);
	}

}
