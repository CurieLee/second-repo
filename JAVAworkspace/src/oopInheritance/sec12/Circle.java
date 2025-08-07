package oopInheritance.sec12;

public class Circle extends DrawingObject {
	public Circle() {
		penColor = "Blue";
	}
	
	@Override
	public void draw() {
		System.out.println(penColor + " 색상으로 원 그리기");
	}
}
