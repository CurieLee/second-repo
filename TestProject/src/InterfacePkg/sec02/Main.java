package InterfacePkg.sec02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);
		rc.setMute(true);
		rc.setMute(false);
		
		System.out.println("--------------------------");
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(50);
		rc.setMute(true);
		
		RemoteControl.changeBattery();
		// rc.showRemote(); 인터페이스의 정적 메소드여도 참조변수를 통해 접근 불가능
	}

}
