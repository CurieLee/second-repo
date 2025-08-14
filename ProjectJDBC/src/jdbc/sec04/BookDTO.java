package jdbc.sec04;

import java.util.Date;

public class BookDTO {
	private String bookNo;
	private String bookName;
	private int bookPrice;
	private Date bookDate;
	private String pubName;
	
	public BookDTO(String bookNo, String bookName, int bookPrice, Date bookDate, String pubName) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDate = bookDate;
		this.pubName = pubName;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubNo(String pubName) {
		this.pubName = pubName;
	}
	
	
}
