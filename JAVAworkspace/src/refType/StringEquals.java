package refType;

public class StringEquals {
	public static void main(String[] args) {
		String strVar1 = "홍길동";
		String strVar2 = "홍길동";
		
		if (strVar1 == strVar2)	System.out.println("참조주소가 같음");
		else					System.out.println("참조주소가 다름");
	}
}
