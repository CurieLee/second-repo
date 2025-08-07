package oopClass.sec18;

public class Main {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.driver(taxi); // taxi 전달-> Vehicle 타입의 매개변수 주입	
		driver.driver(bus);
	}
}
