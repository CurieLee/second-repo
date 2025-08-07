package oopException.sec02;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class TryCatchEx2 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		try {
			changeDog(dog);
			changeDog(cat);
		} catch (ClassCastException e) {
			System.out.println("변환할 수 없는 타입입니다. " + e);
		}
	}
	
	public static void changeDog(Animal animal) {
		Dog dog = (Dog)animal;
	}
	
}

