package oopClass.sec07;

public class ConstructorMain {
	public static void main(String[] args) {
		Constructor con = new Constructor(100);
		con.show();
		
		// 명시적 생성자가 없으면 x = 100; 코드가 진행되지 않아서 x: 0 출력
	}
}
