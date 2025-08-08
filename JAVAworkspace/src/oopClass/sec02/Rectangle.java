package oopClass.sec02;
import java.util.Scanner;

public class Rectangle {
	int width;
	int height;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("가로길이 입력: ");
		width = scan.nextInt();
		System.out.print("세로길이 입력: ");
		height = scan.nextInt();

		scan.close();
	}
	
	public void area() {
		System.out.println("사각형 면적: " + (width * height));
	}
}
