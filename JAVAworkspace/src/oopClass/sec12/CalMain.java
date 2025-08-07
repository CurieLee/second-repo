package oopClass.sec12;

public class CalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Calculator 클래스는 static 메소드로 이루어짐
		// 객체 인스턴스 멤버가 없으므로 객체 생성 불필요함 
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
	}

}
