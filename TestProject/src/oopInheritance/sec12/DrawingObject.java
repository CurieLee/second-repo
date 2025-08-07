package oopInheritance.sec12;

// 추상 클래스: 추상 메소드 포함
public abstract class DrawingObject {
	public String penColor;
	
	// 추상 메소드: draw 메소드는 subclass 에서 구현
	public abstract void draw();
}
