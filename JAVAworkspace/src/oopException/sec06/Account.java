package oopException.sec06;

public class Account {
	private long balance;
	
	public Account() {}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	// 예외발생 코드를 가지고 있는 메소드
	// 호출한 곳에서 예외처리 하도록 떠넘기는 역할 throws
	public void withdraw(int money) throws BalanceInsufficientException {
		if (balance < money) {
			throw new BalanceInsufficientException("잔액 부족 " + (money - balance) + " 모자람");
		}
		balance -= money;
	}
}
