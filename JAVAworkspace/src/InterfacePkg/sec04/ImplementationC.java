package InterfacePkg.sec04;

public class ImplementationC implements InterfaceC {
	// InterfaceC 가 상속받은 InterfaceA/B 메소드까지 모두 구현
	
	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		System.out.println("methodA() running ...");
	}
	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		System.out.println("methodB() running ...");
	}
	@Override
	public void methodC() {
		// TODO Auto-generated method stub
		System.out.println("methodC() running ...");
	}

}
