package genericCollection.sec03;

public class Main {
	public static void main(String[] args) {
		Product<Tv, String> prd1 = new Product<Tv, String> ();
		Product<Car, String> prd2 = new Product<> ();
		
		prd1.setKind(new Tv());
		prd1.setModel("smartTV");
		prd2.setKind(new Car());
		prd2.setModel("diesel");
		
		String tvModel = prd1.getModel();
		String carModel = prd2.getModel();
		
		System.out.println(tvModel + " " + carModel);
	}
}
