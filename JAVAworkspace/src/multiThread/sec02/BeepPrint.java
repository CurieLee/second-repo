package multiThread.sec02;

public class BeepPrint {
	public static void main(String[] args) {
		// 문자 출력 담당 쓰레드 기본쓰레드
		Runnable beepTask = new BeepTask(); 
		// 두번째 스레드 구성-> 작업 task 전달
		Thread thread = new Thread(beepTask);
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);} catch (Exception e) {}
		}
	}

}
