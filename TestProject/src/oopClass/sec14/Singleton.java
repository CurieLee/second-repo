package oopClass.sec14;

public class Singleton {
	// singleton 패턴 클래스
	// 하나의 어플리케이션 내에서 객체가 하나만 생성되게 함
	// 클래스 내부에서 자신의 객체 생성-> 필요할때 만들어놓은 객체 반환
	// 자기 자신 클래스 타입으로 static 필드 생성
	private static Singleton singleton = new Singleton();
	
	// 생성자를 클래스 외부에서 사용할수 없도록 private 접근 제한
	private Singleton() {}
	
	// static 으로 위에서 생성한 객체참조변수 변환 메소드 생성
	static Singleton getInstance() {
		return singleton;
	}
}
