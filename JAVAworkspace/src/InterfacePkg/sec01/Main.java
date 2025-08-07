package InterfacePkg.sec01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// interface 사용
		Samsung samsung = new Samsung();
		samsung.sendCall();
		
		iSmartPhone isp = new Samsung();
		isp.sendCall();
		// isp.name();
		
		// iPhone 참조변수를 통해 iPhone 객체 사용
		iSmartPhone iip = new iPhone();
		iip.sendCall();
	}

}
