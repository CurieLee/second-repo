package oopInheritance.sec06;

public class Computer extends Calculator {
	//@Override
	double areaCircle(double r) {
		System.out.println("Computer areaCircle() is running ...");
		return Math.PI * r * r;
	}
}
