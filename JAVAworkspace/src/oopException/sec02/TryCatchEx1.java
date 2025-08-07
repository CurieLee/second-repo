package oopException.sec02;

public class TryCatchEx1 {
	
	public static void main(String[] args) {
		// try~catch~finally
		int[] arr = {1, 2, 3};
		try {
			System.out.println(arr[5]);
			Class class1 = Class.forName("java.lang.String1");
			System.out.println("클래스가 존재합니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("인덱스 범위가 아닙니다.");	
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
}
