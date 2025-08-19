package view;

import controller.Controller;
import java.util.Scanner;

public class BookDeleteView {
	Controller controller = Controller.getInstance();
	Scanner scan = new Scanner(System.in);
	
	public void delete() {
		String bookNo;
		
		System.out.println("\n*************************");
		System.out.println("도서정보 삭제");
		System.out.println("***************************");
		
		BookListView bls = new BookListView();
		bls.getAllBook();
		
		System.out.print("삭제할 도서번호 입력: ");
		bookNo = scan.nextLine();
		System.out.println("\n*************************");
		
		controller.delete(bookNo);
		
	}
}
