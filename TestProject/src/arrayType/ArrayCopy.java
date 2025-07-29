package arrayType;

public class ArrayCopy {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		int b[] = a;
		
		for (int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		System.out.println();
		for (int i = 0; i < b.length; i++) 
			System.out.print(b[i] + " ");
		System.out.println();
		
		b[0] = 10;
		
		for (int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		System.out.println();
		for (int i = 0; i < b.length; i++) 
			System.out.print(b[i] + " ");
		System.out.println();
	}
}
