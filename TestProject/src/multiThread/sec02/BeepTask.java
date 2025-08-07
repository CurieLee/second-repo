package multiThread.sec02;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
	// beep 음 출력 담당-> Runnable 구현
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {Thread.sleep(500);} catch (Exception e) {}
		}
	}
}
