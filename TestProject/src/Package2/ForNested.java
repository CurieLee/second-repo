package Package2;

public class ForNested {
	
	public static void main(String[] args) {
		for (int i = 1; i < 10 ; i++) {
			for (int j = 1; j < 10; j++)
				System.out.print(j + " * " + i + " = " + (i * j) + "\t");
			System.out.println();
		}
	}
}
