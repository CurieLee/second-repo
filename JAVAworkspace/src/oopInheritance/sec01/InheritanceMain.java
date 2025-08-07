package oopInheritance.sec01;

public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child ob = new Child();
		
		ob.setChild();
		ob.setParent();
		ob.showChild();
		ob.showParent();
		
		Parent pa = new Parent();
		pa.showParent();
		// pa.showChild();
	}

}
