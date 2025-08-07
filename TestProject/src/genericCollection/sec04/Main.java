package genericCollection.sec04;

public class Main {
	public static void main(String[] args) {
		// Util 클래스 static method example
		// Util 클래스 boxing method Generic, static Box 타입 변환
		// 메소드 호출시 타입 구체화
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int intValue = box1.get();
		
		Box<String> box2 = Util.boxing("홍길동");
		String strValue = box2.get();
		
		System.out.println(intValue);
		System.out.println(strValue);
	}
}
