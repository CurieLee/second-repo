package genericCollection.sec01;

public class Main {

	public static void main(String[] args) {
		// 반복적 자동형변환 (강제)-> 성능저하
		Box box1 = new Box();
		box1.set("홍길동"); //Object-> String 자동형변환
		// Box 클래스 object 필드는 Object type 문자열 저장된 상태
		String name = (String)box1.get();
		System.out.println(name);
		
		Box box2 = new Box();
		box2.set(7); //Object-> int 자동형변환
		int num = (int)box2.get();
		System.out.println(num);
	}

}
