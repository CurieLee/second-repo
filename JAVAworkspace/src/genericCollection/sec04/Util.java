package genericCollection.sec04;

public class Util {
	// 멤버 메소드 추가: generic type method 접근제한자:: static <> 반환값 타입 메소드명 (매개변수)
	// <T> 
	// Box <T>
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T> ();
		box.set(t);
		return box;
	}
}
