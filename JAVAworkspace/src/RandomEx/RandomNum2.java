package RandomEx;
import java.util.Random;

public class RandomNum2 {
	public static void main(String[] args) {
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			int num1 = random.nextInt(10);
			int num2 = random.nextInt(10) + 1;
			
			System.out.println(num1);
			System.out.println(num2);
		}
	}
}
