package jdbc.sec04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BookDAOImpl implements BookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BookDTO book = null;
	ArrayList<BookDTO> bookList = null;
	
	// 생성자에서 DB 연결
	public BookDAOImpl() {
		conn = DBConnect.getConnection();
	}

	@Override
	public void insertBook(BookDTO dto) {
		// 도서 등록
		try {
			String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  dto.getBookNo());
			pstmt.setString(2, dto.getBookName());
			pstmt.setInt(3, dto.getBookPrice());
			pstmt.setDate(4, new java.sql.Date(dto.getBookDate().getTime()));
			pstmt.setString(5, dto.getPubName());
			
			int result = pstmt.executeUpdate();
			
			if (0 < result) {
				System.out.println("도서 등록 성공");
			} else {
				System.out.println("도서 등록 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
		
	}

	@Override
	public void updateBook(BookDTO dto) {
		// 도서 등록정보 수정
		try {
			String sql = "UPDATE book SET bookName=?, bookPrice=?,"
					+ "bookDate=?, pubNo=? WHERE bookNo=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBookName());
			pstmt.setInt(2, dto.getBookPrice());
			pstmt.setDate(3, new java.sql.Date(dto.getBookDate().getTime()));
			pstmt.setString(4, dto.getPubName());
			pstmt.setString(5, dto.getBookNo());
			
			pstmt.executeUpdate();
			
			System.out.println("도서정보 수정 성공");
					
		} catch (SQLException e) {
			System.out.println("updateBook ERROR");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public void deleteBook(String bookNo) {
		// 도서 삭제
		try {
			String sql = "DELETE FROM book WHERE bookNo=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookNo);
			
			int result = pstmt.executeUpdate();
			
			System.out.println("도서정보 삭제 성공");
			
		} catch (SQLException e) {
			System.out.println("deleteBook ERROR");
			e.printStackTrace();
		} finally {
			
		}
	}

	@Override
	public ArrayList<BookDTO> selectAllBook() {
		// 전체 도서정보 조회
		bookList = new ArrayList<BookDTO> ();
		try {
			String sql = "SELECT B.bookNo, B.bookName, B.bookPrice, B.bookDate, P.pubName "
						+ "FROM book B "
						+ "INNER JOIN publisher P ON P.pubNo = B.pubNo "
						+ "ORDER BY B.bookNo";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				int bookPrice = rs.getInt(3);
				Date bookDate = rs.getDate(4);
				String pubName = rs.getString(5);
				
				book = new BookDTO(bookNo, bookName, bookPrice, bookDate, pubName);
				bookList.add(book);
			}
			
		} catch (SQLException e) {
			System.out.println("selectAllBook ERROR");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return bookList;
	}

	@Override
	public BookDTO selectBookByBookNo(String bookNo) {
		// 도서 등록번호 조회
		try {
			String sql = "SELECT B.bookNo, B.bookName, B.bookPrice, B.bookDate, P.pubName "
					+ "FROM book B "
					+ "INNER JOIN publisher P ON P.pubNo = B.pubNo "
					+ "WHERE B.bookNo=? "
					+ "ORDER BY B.bookNo";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  bookNo);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			bookNo = rs.getString(1);
			String bookName = rs.getString(2);
			int bookPrice = rs.getInt(3);
			Date bookDate = rs.getDate(4);
			String pubName = rs.getString(5);
				
			book = new BookDTO(bookNo, bookName, bookPrice, bookDate, pubName);
			
		} catch (SQLException e) {
			System.out.println("selectBookByBookNo ERROR");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return book;
	}

	@Override
	public ArrayList<BookDTO> selectBookByPubName(String pubName) {
		// 특정 출판사 도서 조회
		bookList = new ArrayList<BookDTO> ();
		try {
			String sql = "SELECT B.bookNo, B.bookName, B.bookPrice, B.bookDate, P.pubName "
						+ "FROM book B "
						+ "INNER JOIN publisher P ON P.pubNo = B.pubNo "
						+ "WHERE P.pubName=? "
						+ "ORDER BY B.bookNo";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  pubName);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				int bookPrice = rs.getInt(3);
				Date bookDate = rs.getDate(4);
				pubName = rs.getString(5);

				book = new BookDTO(bookNo, bookName, bookPrice, bookDate, pubName);
				bookList.add(book);
			}
			
		} catch (SQLException e) {
			System.out.println("selectBookByPubName ERROR");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		return bookList;
	}

}
