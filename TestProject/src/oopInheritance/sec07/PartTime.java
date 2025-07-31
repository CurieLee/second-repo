package oopInheritance.sec07;

public class PartTime extends Worker {
	private int hours;
	private int unitPrice;
	
	public PartTime(String name, String joominNo, int hours, int unitPrice) {
		super(name, joominNo);
		this.hours = hours;
		this.unitPrice = unitPrice;
	}
	
	public int calculatePay() {
		return hours * unitPrice;
	}
	
	public String toString() {
		return super.toString() +
				"\n시급: " + unitPrice + "원 " +
				"\n근무시간: " + hours + "시간 " + 
				"\n총 지불액: " + calculatePay() + "원 ";
	}
	
}
