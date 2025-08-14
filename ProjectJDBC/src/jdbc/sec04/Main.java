package jdbc.sec04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BookDAO dao = new BookDAOImpl();
		Scanner scan = new Scanner(System.in);
		ArrayList<BookDTO> bookList = null;
		String bookNo;
		String pubName;
		
		try {
			// 도서 등록
			System.out.println("도서 등록");
			dao.insertBook(ReadWrite.getBookInfo(scan));
			
			// 전체 도서정보 조회
			bookList = dao.selectAllBook();
			ReadWrite.writeBookInfo(bookList);
			
			// 도서 등록정보 수정
			System.out.println("\n도서 등록정보 수정");
			System.out.print("수정할 도서의 등록번호를 입력하세요: ");
			bookNo = scan.nextLine();
			ReadWrite.writeBookInfo(dao.selectBookByBookNo(bookNo));
			
			System.out.println("\n수정할 도서의 정보를 입력하세요");
			dao.updateBook(ReadWrite.getBookInfo(scan));
			ReadWrite.writeBookInfo(bookList);
			
			// 특정 출판사 도서 조회
			System.out.println("\n특정 출판사 도서 조회");
			System.out.print("출판사 이름을 입력하세요: ");
			pubName = scan.nextLine();
			ReadWrite.writeBookInfo(dao.selectBookByPubName(pubName));
			
			// 도서 삭제
			System.out.println("\n도서 삭제");
			System.out.print("삭제할 도서의 등록번호를 입력하세요: ");
			bookNo = scan.nextLine();
			dao.deleteBook(bookNo);
			ReadWrite.writeBookInfo(bookList);
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}
