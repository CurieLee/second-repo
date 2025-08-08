package oopException.sec02;

public class Main {

	public static void main(String[] args) {
		String data1 = "3";
		String data2 = "a3";
		
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다. ");
		}
		
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요");
		}
		
		// int result = value1 + value2;
	}

}
