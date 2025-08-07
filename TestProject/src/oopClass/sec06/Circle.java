package oopClass.sec06;

public class Circle {
	int radius;
	
	public void setCircle(int r) {
		radius = r;
	}
	
	public float area() {
		this.setCircle(5);
		return radius * radius * 3.14f;
	}
}
