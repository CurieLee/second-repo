package arrayType;

public class Array2D1 {
	public static void main(String[] args) {
		int[][] score = {{100, 100, 100},
						 {20, 20, 20}};
		
		System.out.println(score[1][1]);
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++)
				System.out.print(score[i][j] + "\t");
			System.out.println();
		}
		
	}
}
