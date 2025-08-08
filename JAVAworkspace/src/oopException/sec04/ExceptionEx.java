package oopException.sec04;
import java.util.*;

public class ExceptionEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("정수1 입력: ");
			int num1 = scan.nextInt();
			System.out.print("정수2 입력: ");
			int num2 = scan.nextInt();
			
			int result = num1 / num2;
			System.out.println("나누기 결과: " + result);
		} catch (InputMismatchException e) {
			System.out.println("잘못된 입력 값 입니다.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다. ");
		} catch (Exception e) {
			System.out.println("나머지 예외처리 " + e);
		} finally {
			scan.close();
		}
	}

}
