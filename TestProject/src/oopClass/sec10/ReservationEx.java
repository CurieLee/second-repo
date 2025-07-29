package oopClass.sec10;

public class ReservationEx {
	public static void main(String[] args) {
		Reservation res1 = new Reservation();
		Reservation res2 = new Reservation("KE1004", "이몽룡", "김포", "도쿄", 10000, "E09");
		
		res1.show();
		res2.show();
	}
}
