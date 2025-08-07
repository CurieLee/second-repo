package arrayType;
import java.util.Scanner;

public class Array2DEx2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String answer;
		String[][] word = {
				{"chair", "의자"},
				{"computer", "컴퓨터"},
				{"integer", "정수"}
		};
				
		for (int i = 0; i < word.length; i++) {
			//System.out.print("Q" + (i + 1) + "." + word[i][0] + "의 뜻은? ");
			System.out.printf("Q%d. %s의 뜻은? " , i + 1, word[i][0]);
			answer = scan.next();
			
			if (answer.equals(word[i][1]))
				System.out.println("정답입니다.");
			else
				System.out.printf("틀렸습니다. 정답은 %s 입니다. \n", word[i][1]);
				//System.out.println("틀렸습니다. 정답은 " + word[i][1] + "입니다. ");
			
		}
		
		
	}
}
