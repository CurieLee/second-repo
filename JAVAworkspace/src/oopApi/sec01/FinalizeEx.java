package oopApi.sec01;

public class FinalizeEx {

	public static void main(String[] args) {
		Count count = null;
		for (int i = 0; i < 50; i++) {
			count = new Count(i);
			count = null;
			System.gc();
		}

	}

}
