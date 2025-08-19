package multicampus.c_math;

public class MathQuiz {

	public static void main(String[] args) {
		System.out.printf("소수입니까?: %s\n", isPrime(11));
		System.out.printf("소수입니까?: %s\n", isPrime2(11));
		
		System.out.printf("12 18의 최대공약수: %d\n", gcd(12, 18));
		System.out.printf("12 18의 최대공약수: %d\n", gcd2(12, 18));
		System.out.printf("12 18의 최소공배수: %d\n", lcm(12, 18));
		
		System.out.printf("5!: %d\n", factorial(5));
		System.out.printf("5!: %d\n", factorialTail(5, 1));
	}
	
	private static int factorial(int n) {
		if (n < 0) throw new IllegalArgumentException("음수 팩터리얼은 존재하지 않습니다.");
		if (n <= 1) return 1;
		
		return n * factorial(n - 1);
	}
	
	// 꼬리재귀함수
	// 반환부에 연산이 없는 재귀함수
	// 컴파일러가 내부적으로 반복문으로 최적화-> 자바x
	private static int factorialTail(int n, int res) {
		if (n < 0) throw new IllegalArgumentException("음수 팩터리얼은 존재하지 않습니다.");
		if (n <= 1) return 1;
		
		res = n  * res;
		return factorialTail(--n, res);
	}
	
	// 최소공배수 
	// G * (a/G) * (b/G)
	// (a * b) / G
	private static int lcm(int a, int b) {
		return (a * b) / gcd2(a, b);
	}
	
	private static int gcd(int a, int b) {
		int min = Math.min(a,  b);
		
		for (int i = min; 0 < i; i--) {
			if (a % i == 0 && b % i == 0)
				return i;
		}
		return 1;
	}
	
	// 유클리드 호제법을 이용한 최대공약수 구하기
	// a > b
	// a 와 b 가 최대공약수 G 를 가질때, a 를 b 로 나눈 나머지는 G 의 배수
	// a = MG
	// b = NG
	// a = bq + r (q: 몫, r:나머지)
	// MG = NGq + r
	// r = MG - NGq
	// r = G(M - Nq)
	
	// b: NG
	// r: PG
	// b = rq + r2
	// NG = PGq + r2
	// r2 = G(Pq - N)
	private static int gcd2(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
	
	private static boolean isPrime(int num) {
		if (num == 2) 		return true;
		if (num % 2 == 0)	return false;
		
		for (int i = 3; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}
	
	// 약수
	// n % m = 0
	// 약수의 특징: 약수는 곱해서 피제수 (나누어지는 수) 가 되게끔 하는 쌍이 반드시 존재
	// 제곱근을 기준으로 작은 숫자들만 확인하면 됨
	// ex) 12=> 1, 2, 3, 4, 6, 12
	// ex) 16=> 1, 2, 4, 4, 8, 16
	private static boolean isPrime2(int num) {
		if (num == 2) 		return true;
		if (num % 2 == 0)	return false;
		
		for (int i = 3; i < Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}
}
