package multiThread.sec01;
import java.awt.Toolkit;

public class BeepPrint {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);} catch (Exception e) {}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("BEEP");
			try {Thread.sleep(500);} catch (Exception e) {}
		}

	}

}
