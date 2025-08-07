package InterfacePkg.sec05;
import java.util.ArrayList;

// 회원 관리를 위한 DAO 인터페이스
// 필요 기능:
// 1. 회원가입 1명의 회원 정보를 받아 데이터베이스에 저장-> return x 필요에 따라 예외처리
// 2. 회원탈퇴 1명의 회원 memID 전달 받아 DB 에서 정보 삭제-> return x
// 3. 회원정보검색 1명의 회원 memID 전달 받아 DB 에서 정보 select-> return 검색결과 
// 4. 회원정보수정 3에서 연결~select 결과 update 정보 전달 받아 DB memID 를 통해 수정-> return x

// ADMIN
// 5. 회원전체조회 DB 회원 테이블에서 전체 회원정보 검색-> return o
// 6. 이름으로 조회 memName 전달 받아서 DB 에서 일치하는 정보 검색-> 매개변수 return ooo
public interface iMemberDAO {
	// 1 회원가입
	public void insertMember(MemberDTO dto);
	// 2 회원탈퇴: id 값 필요함
	public void deleteMeber(String memID);
	// 3 회원정보 검색
	public MemberDTO selectMember(String memID);
	// 4 회원정보 수정
	public void updateMember(MemberDTO dto);
	
	// 5 전체회원 검색 
	public ArrayList<MemberDTO> getAllMember();
	// 6 이름으로 회원 검색
	public ArrayList<MemberDTO> getNameMember(String name);

}
