package jdbc.sec04;

import java.util.ArrayList;

public interface BookDAO {
	
	// 도서 등록
	public void insertBook(BookDTO dto);
	
	// 등록 도서정보 수정
	public void updateBook(BookDTO dto);
	
	// 도서 삭제
	public void deleteBook(String bookNo);
	
	// 전체 도서정보 조회
	public ArrayList<BookDTO> selectAllBook();
	
	// 도서 등록번호 조회
	public BookDTO selectBookByBookNo(String bookNo);
	
	// 특정 출판사 도서 조회
	public ArrayList<BookDTO> selectBookByPubName(String pubName);
}
