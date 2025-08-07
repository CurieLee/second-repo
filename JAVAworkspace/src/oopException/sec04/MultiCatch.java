package oopException.sec04;

public class MultiCatch {

	public static void main(String[] args) {
		try {
			int []arr = {1, 2, 3};
			int a = arr[5];
			int var = Integer.parseInt("a100");
		} catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
			System.out.println("예외처리 1: 인덱스 범위 오류, 숫자 형태 오류" + e);
		} catch (Exception e) {
			System.out.println("예외처리 2");
		}

	}

}
