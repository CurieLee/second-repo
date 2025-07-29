package oopClass.sec10;

public class Reservation {
	String f_num;
	String name;
	String departure;
	String arrival;
	int price;
	String seat;
	
	public Reservation() {
		this("KE1001", "홍길동", "인천", "뉴욕", 1600000, "A38");
	}
	
	public Reservation(String f_num, String name, String dep, String arr, int price, String seat) {
		this.f_num = f_num;
		this.name = name;
		this.departure = dep;
		this.arrival = arr;
		this.price = price;
		this.seat = seat;
	}
	
	public void show() {
		System.out.println("** 항공권 예약 정보 **");
		System.out.println("항공기: " + f_num);
		System.out.println("예약자: " + name);
		System.out.println("출발지: " + departure);
		System.out.println("도착지: " + arrival);
		System.out.println("금액: " + price);
		System.out.println("좌석번호: " + seat);
		System.out.println();
	}
}
