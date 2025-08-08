package oopInheritance.sec03;

public class Employee {
	private String empNo;
	private String name;
	private String part;
	
	public Employee(String empNo, String name, String part) {
		this.empNo = empNo;
		this.name = name;
		this.part = part;
	}
	
	// toString() method
	// Object 클래스가 구현한 메소드 모든 클래스에 상속
	// 객체가 텍스트 값으로 표시되거나 문자열이 예상되는 방식으로 참조될때
	
	// 오버라이딩 어노테이션 사용: 상속받은 메소드 재정의
	@Override
	public String toString() {
		return empNo + "\t" + name + "\t" + part;
	}
}
