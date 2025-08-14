package jdbc.sec04;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

// 입출력 기능
public class ReadWrite {

	// 도서정보 입력 메소드 (insert/update 사용)
	public static BookDTO getBookInfo(Scanner scan) {
		BookDTO dto = null;
		try {
			System.out.print("도서번호 입력 (B000~B999): ");
			String bookNo = scan.nextLine();
			
			System.out.print("도서명 입력: ");
			String bookName = scan.nextLine();
			
			System.out.print("도서가격 입력: ");
			int bookPrice = scan.nextInt();
			scan.nextLine();
			
			System.out.print("도서 출판일 입력 (YYYY-MM-DD): ");
			String date = scan.nextLine();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-mm-dd");
			Date bookDate = fm.parse(date);
			
			System.out.print("출판사 번호 입력 (P000~P999): ");
			String pubNo = scan.nextLine();
			
			dto = new BookDTO(bookNo, bookName, bookPrice, bookDate, pubNo);
			
		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	// 출력 메소드
	public static void writeBookInfo(ArrayList<BookDTO> bookList) {
		System.out.println("--------------------------- 전체 도서 정보 조회 ---------------------------");
		System.out.format("%-10s %-20s %15s %-20s %-20s\n", 
			    			"도서번호", "도서명", "가격", "출간일", "출판사명");

			for (BookDTO book : bookList) {
			    System.out.format("%-10s %-20s %15s %-20s %-20s\n",
			        book.getBookNo(),
			        book.getBookName(),
			        book.getBookPrice(),
			        new SimpleDateFormat("yyyy-MM-dd").format(book.getBookDate()),
			        book.getPubName()
			    );
			}	
	}
	
	// 출력 메소드
	public static void writeBookInfo(BookDTO dto) {
		System.out.println("----------------------------- 도서 정보 조회 -----------------------------");
		System.out.format("%-10s %-20s %15s %-20s %-20s\n", 
    						"도서번호", "도서명", "가격", "출간일", "출판사명");
		
		System.out.format("%-10s %-20s %15s %-20s %-20s\n",
		        dto.getBookNo(),
		        dto.getBookName(),
		        dto.getBookPrice(),
		        new SimpleDateFormat("yyyy-MM-dd").format(dto.getBookDate()),
		        dto.getPubName());
	}
}
