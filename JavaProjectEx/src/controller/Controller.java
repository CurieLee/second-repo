package controller;

import model.BookDAO;
import model.BookDAOImpl;
import model.BookDTO;

import view.BookListView;
import view.ResultView;

import java.util.Vector;

// View 별로 컨트롤러 구성-> DAO 접근 통로가 많아짐
// DB 사용 제어 불가능 
// Singleton 으로 구성: 단 하나의 객체만 생성 ~ 공유해서 사용
public class Controller {
	// 본인 객체 인스턴스를 본인이 제공: private static 객체 구성
	private static Controller instance = new Controller();
	
	private Controller() {
		// new 연산자로 생성자 호출 불가능하게 막음
	}
	
	// 외부호출 가능 클래스명으로 바로 호출 가능
	public static Controller getInstance() {
		return instance;
	}
	
	////////////////// 데이터 처리 메소드 //////////////////
	BookDAOImpl dao_impl = new BookDAOImpl(); // BookDAO 가 값고있는 모든 메소드 사용 가능
	BookDAO dao = new BookDAOImpl(); // BookImpl 가 갖고있는 메소드만 사용 가능
	
	// DAO 메소드들은 예외를 호출하는 쪽으로 throw 진행-> controller 예외처리
	public void insert(BookDTO newDto) {
		// dao 의 insert() 호출
		try {
			BookDTO dto = new BookDTO();
			dto.setBookNo(newDto.getBookNo());
			dto.setBookName(newDto.getBookName());
			dto.setBookAuthor(newDto.getBookAuthor());
			dto.setBookPrice(newDto.getBookPrice());
			dto.setBookDate(newDto.getBookDate());
			dto.setBookStock(newDto.getBookStock());
			dto.setPubNo(newDto.getPubNo());
			
			// dao_impl.insert(dto);
			if (dao.insert(dto)) {
				ResultView.successMsg("도서 정보가 등록되었습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 등록 오류");
		}
	}
	
	public void getAllBook() {
		try {
			Vector<BookDTO> dataSet = dao.getAllBook();
			
			if (dataSet.size() != 0) {
				BookListView.showAllBook(dataSet);
			} else {
				ResultView.successMsg("검색 결과가 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("잠시후에 재요청 바랍니다. ");
		}
	}
	
	public void update(BookDTO newDto) {
		try {
			BookDTO dto = new BookDTO();
			dto.setBookNo(newDto.getBookNo());
			dto.setBookName(newDto.getBookName());
			dto.setBookAuthor(newDto.getBookAuthor());
			dto.setBookPrice(newDto.getBookPrice());
			dto.setBookDate(newDto.getBookDate());
			dto.setBookStock(newDto.getBookStock());
			dto.setPubNo(newDto.getPubNo());
			
			if (dao.update(dto)) {
				ResultView.successMsg("도서 정보가 수정되었습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 수정 오류");
		}
	}
	
	public void delete(String bookNo) {
		try {
			BookDTO dto = new BookDTO();
			dto.setBookNo(bookNo);
			
			if (dao.delete(dto)) {
				ResultView.successMsg(bookNo + " 도서를 삭제했습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 삭제 오류");
		}
	}
}
