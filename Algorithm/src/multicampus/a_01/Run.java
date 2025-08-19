package multicampus.a_01;

public class Run {
	public static void main(String[] args) {
		swap();
		swapUsingBit();
	}
	
	public static void swapUsingBit() {
		// XOR
		// (a ^ b) ^ b = a
		// (a ^ b) ^ a = b
		
		int a = 11;
		int b = 16;
		
		a = a ^ b;
		b = a ^ b;
		a = b ^ a;
		
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void swap() {
		// a 에 담긴 값을 b에, b에 담긴 값을 a에 넣어주세요
		// 단, 대입 연산자만 사용해야합니다.
		// 값을 직접 변수에 할당할 수 없습니다.
		
		int a = 10;
		int b = 15;
		
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println(a);
		System.out.println(b);
	}

}
