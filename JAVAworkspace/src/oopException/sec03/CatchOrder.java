package oopException.sec03;

public class CatchOrder {

	public static void main(String[] args) {
		try {
			String data = "a3";
			int arr[] = {1, 2, 3};
			int var1 = Integer.parseInt(data);
			int var2 = arr[5];
			System.out.println(var1 + 10);
		} catch (NumberFormatException e) {
			System.out.println("ERROR");
		} catch(Exception e) {
			System.out.println("ERROR::: upper class");
		} finally {
			
		}

	}

}
