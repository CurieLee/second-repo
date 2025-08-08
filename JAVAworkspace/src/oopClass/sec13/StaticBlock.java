package oopClass.sec13;

public class StaticBlock {
	// static block: static 멤버만 모아놓은 영
	
	int a;
	void method() { /* ... */ }
	
	static int staticA;
	static void staticMethod1() { /* ... */ }
	
	static {
		int b = 1;
		// void method_ex() { /* ... */ } 인스턴스 메소드 사용 불가능
		staticA = 10;
		staticMethod1();
	}
	
	static { // 인스턴스 필드는 대부분 생성자를 통해 초기화-> 블록 사용 x
		int c = 0;
		double bc = 5.0;
	}
	
	static void staticMethod2() {
		StaticBlock s = new StaticBlock();
		s.a = 200;
		s.method();
	}
}
