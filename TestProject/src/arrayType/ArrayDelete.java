package arrayType;

public class ArrayDelete {
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5};
		int[] newNum = new int[10];
		
		for (int i = 0; i < num.length; i++) 
			newNum[i] = num[i];
		
		for (int i = 0; i < newNum.length; i++) 
			System.out.println(newNum[i]);
		
		for (int i = 0; i < num.length; i++) 
			System.out.println(num[i]);
		
		num = newNum;
		
		for (int i = 0; i < newNum.length; i++) 
			System.out.println(newNum[i]);
		
		for (int i = 0; i < num.length; i++) 
			System.out.println(num[i]);
		
		num = null;
		System.out.println(num);
	}
}
