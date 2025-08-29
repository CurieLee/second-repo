package com.mc.musiccoordinator.infra.QRcode.dto;

// 불변 데이터 클래스 (field: private final)
// equals, hashcode, toString, getter 
// canonical 생성자
public record QrCodeDTO(
		String text,
		String fileName,
		int width,
		int height,
		String format
		) {

	// canonical 생성자 이외의 다른 생성자 사용시
	// 반드시 다른 생성자에게 객체 생성을 위임 시켜야한다
	public QrCodeDTO(String text, String fileName) {
		this(text, fileName, 100, 100, "PNG");
	}
	
}
