package oopApi.sec01;

public class Count {
	private int no;
	
	public Count(int no) {
		this.no = no;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(no + " empty Object finalize() running");
	}

}
