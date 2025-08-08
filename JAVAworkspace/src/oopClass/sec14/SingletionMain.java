package oopClass.sec14;

public class SingletionMain {
	public static void main(String[] args) {
		// Singleton obj1 = new Singleton(); 생성자 private 접근제한
		
		// Singleton 객체가 필요한 경우 getInstance 메소드 활
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if (obj1 == obj2) 
			System.out.println("같은 Singleton 객체입니다.");
		else
			System.out.println("다른 Singleton 객체입니다.");
	}
}
