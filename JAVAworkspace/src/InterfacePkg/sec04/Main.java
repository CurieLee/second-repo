package InterfacePkg.sec04;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementationC c = new ImplementationC();
		InterfaceA ia = c;
		ia.methodA();
		
		InterfaceB ib = c;
		ib.methodB();
		
		InterfaceC ic = c;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}

}
