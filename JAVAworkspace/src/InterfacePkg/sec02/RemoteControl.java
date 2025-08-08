package InterfacePkg.sec02;

public interface RemoteControl {
	//상수필드 선언: public static final 은 자동으로 컴파일러에 의해 추가됨
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 추상메소드 선언: public abstract 자동으로 컴파일러에 의해 추가됨
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴드 메소드 선언 
	// default 키워드를 반드시 (!) 붙여야함-> 접근제한자 아님
	// 다른건 구현 안해도 되는데 default 메소드의 경우 구현해야함
	// public 접근제한자
	default void setMute(boolean mute) {
		if (mute)
			System.out.println("무음 상태 입니다. ");
		else
			System.out.println("무음 상태가 아닙니다. ");
	}
	
	// 정적 메소드 선언 및 구현: 객체 없이 인터페이스만으로 호출 가능
	// static 키워드 사용
	// public 접근제한자
	static void showRemote() {
		System.out.println("static method running ...");
	}
	static void changeBattery() {
		System.out.println("change the Battery");
	}
}
