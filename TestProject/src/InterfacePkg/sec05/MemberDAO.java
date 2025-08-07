package InterfacePkg.sec05;

import java.util.ArrayList;

public class MemberDAO implements iMemberDAO {
	// DB connection data 필드 
	// DB 연결코드: 연결 메소드
	
	// 실제 구현은 DB 연동에 의한 접근이 진행되어야 하고
	// 관련 쿼리를 전달해서 각 기능이 수행되게 해야함
	@Override
	public void insertMember(MemberDTO dto) {
		// 회원 정보를 DB 에 저장하려면 DTO 에서 개별 정보를 받아 저장
		String id = dto.getMemID();
		System.out.println("회원가입 성공");
		System.out.println(id + "님, 회원가입이 완료되었습니다. ");
	}

	@Override
	public void deleteMeber(String memID) {
		
	}

	@Override
	public MemberDTO selectMember(String memID) {
		// DB 에서 id 를 전달받아 회원정보 검색-> 정보 DTO 에 담아 반환
		MemberDTO dto = new MemberDTO("123", "abcd", "홍길동", "111", "서울");
		return dto;
	}

	@Override
	public void updateMember(MemberDTO dto) {
		
	}

	@Override
	public ArrayList<MemberDTO> getAllMember() {
		return null;
	}

	@Override
	public ArrayList<MemberDTO> getNameMember(String name) {
		return null;
	}
	
}
