package oopClass.sec07;

public class Constructor {
	// 멤버변수
	private int x;
	private int y;
	
	// 생성자: 클래스 이름과 동일한 메소드-> 반환타입 x
	// 객체 생성될때 한번만 호출 가능
	// 멤버변수 값 초기화 역할
	
	// 명시적 생성자가 구현되었기 때문에 디폴트 생성자 구현할 필요 없음
	public Constructor(int x) {
		// 메소드의 바디 영역-> x는 매개변수 x (지역변수) 지칭
		// 멤버 변수 지칭할때 class 영역을 지칭하는 this 레퍼런스
		// this 레퍼런스 현 클래스를 참조하는 예약어
		this.x = x;
	}
	
	public void show() {
		System.out.println("x: " + this.x);
	}
}
