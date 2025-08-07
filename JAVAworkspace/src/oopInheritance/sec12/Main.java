package oopInheritance.sec12;

public class Main {
	public static void main(String[] args) {
		Line line = new Line();
		line.draw();
		
		// DrawingObject dot = new DrawingObject(); 추상클래스 객체 생성 불가능
		Circle circle = new Circle();
		circle.draw();
		
		Rectangle rec = new Rectangle();
		rec.draw();
	
	}
}
