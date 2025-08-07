package oopInheritance.sec07;

public class PartTimeMain {
	public static void main(String[] args) {
		PartTime pt = new PartTime("991111-1234567", "홍길동", 60, 15000);
		System.out.println(pt);
		
		Worker wk = pt; // sub class 객체 참조를 super class 참조변수에 대입
		System.out.println(wk);
	}
}
