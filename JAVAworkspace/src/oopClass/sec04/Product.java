package oopClass.sec04;
import java.util.Scanner;

public class Product {
	String prdName;
	int prdPrice;
	int prdSold;
	int prdStock;
	
	int salesAmount;
	int stockAmount;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("**** 상품 정보 입력 ****");
		System.out.print("상품명: ");
		prdName = scan.next();
		System.out.print("가격: ");
		prdPrice = scan.nextInt();
		System.out.print("판매 수량: ");
		prdSold = scan.nextInt();
		System.out.print("재고 수량: ");
		prdStock = scan.nextInt();	
		
		System.out.println();
		scan.close();
	}
	
	public void show() {
		System.out.println("**** 상품 정보 출력 ****");
		System.out.println("상품명: " + prdName);
		System.out.println("가격: " + prdPrice);
		System.out.println("판매 수량: " + prdSold);
		System.out.println("재고 수량: " + prdStock);
	}
	
	public void showSalesAmount() {
		salesAmount = prdPrice * prdSold;
		
		System.out.println("매출액: " + salesAmount);
	}
	
	public void showStockAmount() {
		stockAmount = prdPrice * prdStock;
		
		System.out.println("재고액: " + stockAmount);	
	}

}
