package oopException.sec05;

public class Throws {

	public static void main(String[] args) {
		// findClass();
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("메소드에서 throws 로 떠넘긴 예외는 메소드 호출시 처리");
		}
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class class1 = Class.forName("java.lang.String2");
	}
}
