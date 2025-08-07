package oopInheritance.sec12;

public class Rectangle extends DrawingObject {
	public Rectangle() {
		penColor = "Green";
	}
	
	@Override
	public void draw() {
		System.out.println(penColor + " 색상으로 사각형 그리기");
	}
}
