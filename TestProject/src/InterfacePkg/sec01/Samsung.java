package InterfacePkg.sec01;

public class Samsung implements iSmartPhone {
	// interface 에 구현된 모든 메소드가 구현되어야함
	String name;
	
	public Samsung() {
		name = "samsung phone";
	}
	
	@Override
	public void sendCall() {
		System.out.println(name + " send calling ...");
	}
	
	@Override
	public void receiveCall() {
		
	}
	
	@Override
	public void sendSMS() {
		
	}
	
	@Override
	public void receiveSMS() {
		System.out.println(" receive SMS ...");
	}
}
