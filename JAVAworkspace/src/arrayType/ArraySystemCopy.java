package arrayType;

public class ArraySystemCopy {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4};
		int[] b = new int [a.length];
		System.arraycopy(a,  0,  b,  1,  3);
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
	}
}
