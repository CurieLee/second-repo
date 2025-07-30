package oopClass.sec15;

public class PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person("1234-5678", "홍길동", "0000");
		System.out.println(p1.nation);
		System.out.println(p1.name);
		System.out.println(p1.ssn);
		
		p1.nation = "USA"; // final 값 수정 불가능
		p1.name = "을지문덕";
		p1.ssn = "0000-0000";
		p1.tmp = "1234";
	}
}
