package oopInheritance.sec07;

public class Car {
	String carNo;
	String carName;
	String carMaker;
	int carYear;

	public Car(String no, String name, String maker, int year) {
		this.carNo = no;
		this.carName = name;
		this.carMaker = maker;
		this.carYear = year;
	}
	
	public String toString() {
		return "차량번호: " + carNo + "\n차종: " + carName + "\n제조사: " + carMaker + "\n연식: " + carYear;
	}
	
}
