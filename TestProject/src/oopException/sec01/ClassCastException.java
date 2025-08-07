package oopException.sec01;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class ClassCastException {

	public static void main(String[] args) {
		// 사용자 정의 클래스 강제 형변환
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
	}
	
	public static void changeDog(Animal animal) {
		Dog dog = (Dog)animal;
	}
	
}

