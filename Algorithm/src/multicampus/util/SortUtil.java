package multicampus.util;

import java.util.Random;

public class SortUtil {

	public static int[] createRandomIntArray(int size) {
		int[] arr = new int[size];
		Random random = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(size * 5);
		}
		
		return arr;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void checkTime(Timer timer) {
		long start = System.currentTimeMillis();
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length - 1; j++) {
//				if (arr[j] > arr[j + 1]) {
//					SortUtil.swap(arr,  i,  j);
//				}
//			}
//		}
		
		timer.start();
		
		long end = System.currentTimeMillis();
		System.out.printf("소요시간: %s \n" , end - start);
	}
}
