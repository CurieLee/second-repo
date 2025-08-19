package view;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 메뉴 구성 
		Scanner scan = new Scanner(System.in);
		int menuNum;
		System.out.println("===============도서관리 프로그램=============");
		
		boolean loop = true;
		while (loop) {
			System.out.println("1. 도서정보 등록");
			System.out.println("2. 도서정보 조회");
			System.out.println("3. 도서정보 수정");
			System.out.println("4. 도서정보 삭제");
			System.out.println("5. 종료");
			System.out.println("========================================");
			
			System.out.print("메뉴 번호 입력 : ");
			menuNum = scan.nextInt();
			
			switch (menuNum) {
				case 1:
					BookInsertView bis = new BookInsertView();
					bis.insert();
					break;
				case 2:
					BookListView bls = new BookListView();
					bls.getAllBook();
					break;
				case 3:
					BookUpdateView bus = new BookUpdateView();
					bus.updateBook();
					break;
				case 4:
					BookDeleteView bdv = new BookDeleteView();
					bdv.delete();
					break;
				case 5:
					loop = false;
					break;
				default:
					System.out.println("잘못된 입력입니다.");
			}
		}
		
		System.out.println("----------------------------------------");
		System.out.println("종료합니다");
		System.out.println("----------------------------------------");
		
		scan.close();
	}
}
