package oopClass.sec13;

public class Share {
	int a;
	static int staticA; // 초기화 하지 않으면 default 0
	
	public void set(int n) {
		a += n;
		staticA += n;
	}
	
	public int showA() {
		return a;
	}
	
	static public int showStaticA() {
		return staticA;
	}
}
