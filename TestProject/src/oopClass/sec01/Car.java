package oopClass.sec01;

// 사용자 정의 클래스: 개발자가 필요한 변수(필드/속성) 함수정
// 데이터를 다루기 위한 변수: 멤버 변수
// 데이터를 조작하기 위, 기능을 수행하기 위한 멤버 함수
public class Car {
	// 멤버변수 데이터
	private String carNo;
	private String carName;
	private String carMaker;
	private int carYear;
	private int carCC;
	
	// private: 접근제한자-> 클래스 외부에서 변수 접근 불가능하게 숨김 (데이터 은닉)
	
	// 멤버 메소드
	// 멤버 변수에 데이터를 저장하는 메소드: 직접 저장
	public void setCarInfo() {
		carNo = "11가 1234";
		carName = "아반떼";
		carMaker = "현대";
		carYear = 2020;
		carCC = 1500;
	}
	
	public void setCarInfo(String no, String name, String maker, int year, int cc) {
		carNo = no;
		carName = name;
		carMaker = maker;
		carYear = year;
		carCC = cc;
	}
	
	// 멤버 변수 값을 출력하는 메소드 
	public void showCarInfo() {
		System.out.println("차량 번호: " + carNo);
		System.out.println("차종: " + carName);
		System.out.println("차량 제조사: " + carMaker);
		System.out.println("차량 연식: " + carYear);
		System.out.println("차량 배기량: " + carCC);
	}

}
