package RandomEx;

public class RandomNum1 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			double num1 = Math.random() * 10;
			int num2 = (int)(Math.random() * 10);
			int num3 = (int)(Math.random() * 10) + 1;
			
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
			
		}
	}
}
