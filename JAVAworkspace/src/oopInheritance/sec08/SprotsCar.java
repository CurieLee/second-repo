package oopInheritance.sec08;

public class SprotsCar extends MyCar {
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	@Override
	public void stop() {
		System.out.println("stop sportscar!!!");
		speed = 0;
	}
}
