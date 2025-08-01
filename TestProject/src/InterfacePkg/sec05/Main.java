package InterfacePkg.sec05;

public class Main {

	public static void main(String[] args) {
		// DTO/DAO 활용 예제
		// 회원가입을 위한 정보가 전달되었다고 가정
		MemberDTO dto = new MemberDTO("abcd", "1234", "김철수", "010-1234-5678", "서울");

		// DAO 에 전달해서 회원가입 메소드 실행
		iMemberDAO idao = new MemberDAO();
		MemberDAO dao = new MemberDAO();
		
		idao.insertMember(dto);
		dao.insertMember(dto);
		
		// 회원검색: 검색결과 반환 타입 DTO
		dto = idao.selectMember("123");
		// 검색된 결과 DTO-> view 전달 frontend/클라이언트 로 전달
		
	}

}
