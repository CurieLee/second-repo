package algorithm_quiz.dp;

public class Q1 {
	
	public static void main(String[] args) {
		int[] arr = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        System.out.println(maxSum(arr));
	}	
	
	public static int maxSum(int[] arr) {
		
		int maxSum = 0;
        int currentSum = 0;

        for (int i : arr) {
            currentSum = Math.max(currentSum + i, i);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
	}
}
