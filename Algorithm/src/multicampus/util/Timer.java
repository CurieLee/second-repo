package multicampus.util;

@FunctionalInterface
public interface Timer {

	void start();
	// void end(); 오버라이드 해야할 메소드가 2개 이상이면 오류-> 람다 사용할때?
	
}
