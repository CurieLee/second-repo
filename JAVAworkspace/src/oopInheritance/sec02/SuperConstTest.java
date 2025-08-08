package oopInheritance.sec02;

class A {
	public A() {
		System.out.println("기본 생성자 A");
	}
	
	public A(int x) {
		System.out.println("매개변수 생성자 A: " + x);
	}
}

class B extends A {
	public B() {
		System.out.println("기본 생성자 B");
	}
	
	public B(int x) {
		System.out.println("매개변수 생성자 B: " + x);
	}
}

class C extends B {
	public C() {
		System.out.println("기본 생성자 C");
	}
	
	public C(int x) {
		super(x);
		System.out.println("매개변수 생성자 C: " + x);
	}
	
	public void tmp() {
		
	}
}



public class SuperConstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
		C c1 = new C(5);
	}

}
