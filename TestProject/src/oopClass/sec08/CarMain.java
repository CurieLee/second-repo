package oopClass.sec08;

public class CarMain {
	public static void main(String[] args) {
		// 사용자 정의 클래스 Car 를 사용
		// 1. Car 클래스 객체 생성 2. 생성된 객체를 통해 멤버 변수나 메소드 사용
		
		// 객체 생성 c 인스턴스 생성
		Car c = new Car(); 
		
		// 객체를 통해 멤버 변수나 메소드 사용
		// carNo는 private <-클래스 외부에서 직접 접근 불가
		
		// 객체를 통해 public 메소드 호출 
		c.setCarInfo("11가1111", "k7", "기아", 2025, 1500);
		c.showCarInfo();
		
		Car b = new Car();
		b.setCarInfo("22나2222", " 그랜저", "현대", 2023, 2000);
		b.showCarInfo();
	}
}
