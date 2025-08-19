package view;

import java.util.Scanner;

import controller.Controller;
import model.BookDTO;

public class BookUpdateView {
	Controller controller = Controller.getInstance();
	Scanner scan = new Scanner(System.in);
	
	public void updateBook() {
		String bookNo, bookName, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;
		
		System.out.println();
		System.out.println("****************************************");
		System.out.println("도서정보 수정");
		System.out.println("****************************************");
		System.out.println();
		
		BookListView bls = new BookListView();
		bls.getAllBook();
		
		System.out.print("수정할 도서번호 입력 : ");		
		bookNo = scan.nextLine();
		
		System.out.print("도서제목 입력 : ");	
		bookName = scan.nextLine();
		
		System.out.print("도서저자 입력 : ");	
		bookAuthor = scan.nextLine();
		
		System.out.print("도서가격 입력 : ");	
		bookPrice = Integer.parseInt(scan.nextLine());
		
		System.out.print("발행일 입력 : ");	
		bookDate = scan.nextLine();
		
		System.out.print("도서재고 입력 : ");	
		bookStock = Integer.parseInt(scan.nextLine());
		
		// System.out.print("출판사번호 입력 : ");	
		// pubNo = scan.nextLine();	
		System.out.println("****************************************");
		
		// 컨트롤러 메소드에 입력받은 데이터 전달 ~ DAO 까지 전달되어야함
		//controller.update(new BookDTO(bookNo, bookName, bookAuthor,bookPrice, bookDate,bookStock, pubNo));
		controller.update(new BookDTO(bookNo, bookName, bookAuthor,bookPrice, bookDate,bookStock, null));
	}
}
