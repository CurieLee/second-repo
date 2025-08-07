package oopApi.sec04;

public class AutoBoxingUnBoxing {

	public static void main(String[] args) {
		// 자동 박싱
		Integer obj = 100;
		System.out.println(obj.intValue());
		
		// 자동 언박싱-> 객체 참조변수 기본 변수에 대입
		int value = obj;
		
		int result = obj + 100; // obj 객체 + 기본값 연산
		System.out.println(result);
		
		Short.parseShort("100");
		Double.parseDouble("3.5");
		Boolean.parseBoolean("true");
		
		

	}

}
