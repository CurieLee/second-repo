package oopApi.sec05;
import java.util.Random;

public class RandomSeed {

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			int x = r.nextInt(10) + 1; // 1~10 까지 난수 발생
			System.out.print(x + " ");
		}
	}

}
