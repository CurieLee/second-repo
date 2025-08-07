package oopClass.sec15;

public class Person {
	// final:: 읽기전용 필드
	// 초기화는 클래스 내에서 끝내야함 아니면 문법 오류
	final String nation = "Korea";
	String name;
	final String ssn;
	final String tmp;
	
	public Person(String ssn, String name, String tmp) {
		this.ssn = ssn;
		this.name = name;
		this.tmp = tmp;
	}
}
