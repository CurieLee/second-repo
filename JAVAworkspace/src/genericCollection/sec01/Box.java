package genericCollection.sec01;

public class Box {
	// 필드 1개 getter/setter 필요한 클래스
	// 어떤 타입의 필드인지 결정하지 않고 모든 타입의 필드를 사용할 수 있도록 구성
	// 모든타입 포함하는 클래스 Object
	private Object object;
	
	public void set(Object obj) {
		this.object = obj;
	}
	
	public Object get() {
		return object;
	}
}
