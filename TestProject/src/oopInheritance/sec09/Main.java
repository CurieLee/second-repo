package oopInheritance.sec09;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
		
		// 자동타입변환과 다형성
		// 부모 클래스 타입의 참조변수 선언 
		Parent parent = child;
		// subclass 객체가 superclass 객체로 자동 타입 변환
		// Parent 변수는 child 객체를 참조하지만 사용 가능한건 parent 멤버것만 사용 가
	
		parent.method1();
		// parent.method3();
		parent.method2();
	}

}
