package oopInheritance.sec10;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal ani = new Animal();
		ani.show();
		ani.sound();
		
		ani = new Cat();
		ani.show();
		ani.sound();
		
		ani = new Dog();
		ani.show();
		ani.sound();
	}

}
