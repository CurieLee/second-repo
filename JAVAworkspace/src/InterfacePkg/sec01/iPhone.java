package InterfacePkg.sec01;

public class iPhone implements iSmartPhone {
	String name;
	
	public iPhone() {
		name = "iPhone";
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
		
	}
}
