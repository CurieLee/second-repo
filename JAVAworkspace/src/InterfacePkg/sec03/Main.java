package InterfacePkg.sec03;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartTelevision stv = new SmartTelevision();
		stv.turnOn();
		stv.setVolume(4);
		stv.search("www.naver.com");
		
		//RemoteControl rc = new SmartTelevision();
		iSearchable se = new SmartTelevision();
		se.search("www.daum.net");
		
	}

}
