package oopException.sec01;

public class NullPointerException {

	public static void main(String[] args) {
		String data = null;
		int[] arr = {1, 2, 3};
		// System.out.println(data.toString());
		// System.out.println(arr[5]);
		
		String data1 = "100";
		String data2 = "a100";
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
		System.out.println(value1);
		System.out.println(value2);
	}

}
