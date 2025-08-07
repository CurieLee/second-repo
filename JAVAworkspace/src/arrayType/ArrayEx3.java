package arrayType;

public class ArrayEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto = new int [6];
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
		}
		
		System.out.println("** 로또 번호 생성 **");
		for (int i = 0; i < lotto.length; i++)
			System.out.print(lotto[i] + " ");
			
	}

}
