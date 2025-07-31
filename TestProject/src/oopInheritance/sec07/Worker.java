package oopInheritance.sec07;

public class Worker {
	String name;
	String joominNo;
	
	public Worker(String name, String joominNo) {
		this.name = name;
		this.joominNo = joominNo;
	}
	
	public String toString() {
		return "이름: " + name + "\n주민등록번호: " + joominNo;
	}
}
