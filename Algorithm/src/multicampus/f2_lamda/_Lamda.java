package multicampus.f2_lamda;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import multicampus.f2_lamda.function.Consumer;
import multicampus.f2_lamda.function.Supplier;
import multicampus.f2_lamda.function.Function;
import multicampus.f2_lamda.function.Predicate;

public class _Lamda {
	
	// 1 매개변수의 타입은 생략한다
	// 2 매개변수가 하나라면 매개변수 선언부의 괄호는 생략한다 
	// 3 코드블록에 코드가 한줄이라면 {} 생략한다
	// 4 return 문 만 존재하는 함수라면 {} return 과 예약어를 생략한다
	public static void main(String[] args) {	
		testConsumer(username -> System.out.println(username + "님! 환영합니다."));
		testConsumer(username ->  {
			System.out.println("==========================");
			System.out.println(username + "님! 환영합니다.");
			System.out.println("==========================");
		});
		
		testSupplier(() -> "lamda supplier");
		testSupplier(() -> {
			System.out.println("==========================");
			return "lamda supplier";
		});
		
		testFunction((a, b) -> "결과: " +  (a + b));
		testFunction((a, b) -> {
			System.out.print("a + b = ");
			System.out.println(a + b);
			return "결과: " + (a + b);
		});
		
		testPredicate(n -> n % 2 == 0);
		testPredicate(n -> {
			System.out.println("짝수? ");
			return n % 2 == 0;
			
		});
		
		// 메소드 참조
		testConsumer(System.out::println);
		
		List<Integer> nums = new ArrayList<Integer>(List.of(11, 23, 415, 1, 656));
		//nums = nums.stream().map(e -> e * 10).toList();
		
		Collections.sort(nums, (e, f) -> e - f);
		System.out.println(nums);
		
	}
	
	public static void testConsumer(Consumer<String> fnc) {
		fnc.accept("MC_HMD");
	}
	
	public static void testSupplier(Supplier<String> fnc) {
		System.out.println(fnc.get());
	}
	
	public static void testFunction(Function<Integer, String> fnc) {
		System.out.println(fnc.apply(1000, 2000));
	}
	
	public static void testPredicate(Predicate<Integer> fnc) {
		System.out.println(fnc.test(9999));
	}
	
	
}
