package genericCollection.Ex;

public class Product {
	private int prodID;
	private String prodName;
	private int prodPrice;
	
	public Product(int prodID, String prodName, int prodPrice) {
		this.prodID = prodID;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	
	@Override
	public String toString() {
		return "ID:" + prodID + " name:" + prodName + " price:" + prodPrice + "원";
	}
}
