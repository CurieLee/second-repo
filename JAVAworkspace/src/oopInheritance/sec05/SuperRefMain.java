package oopInheritance.sec05;

class SuperClass {
	int x;
	int y;
	
	public SuperClass() {
		x = 5;
		y = 50;
	}
}

class SubClass extends SuperClass {
	int x;
		
	public SubClass() {
		x = 10; 
	}
	
	public void show() {		
		System.out.println(x); // SubClass 의 x 값
		System.out.println("this.x: " + this.x); // SubClass 의 x 값
		System.out.println(x); // SuperClass 의 x 값
		System.out.println(y);
	}
}

public class SuperRefMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass sub = new SubClass();
		sub.show();
	}

}
