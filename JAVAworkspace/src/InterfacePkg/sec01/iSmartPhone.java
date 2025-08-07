package InterfacePkg.sec01;

public interface iSmartPhone {
	// 생성자가 없는 인터페이스-> 상수 초기화
	String name = "smartphone";
	
	// 구현되는 클래스의 메소드 설계도 역할
	public void sendCall();
	public void receiveCall();
	public void sendSMS();
	public void receiveSMS();
}
