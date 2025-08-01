package InterfacePkg.sec05;

// 데이터 교환에 사용될 클래스
// 회원 관리에 사용할 예쩡: 회원 한명을 표현하는 클래스
// 필요 필드: 회원가입 시 받아야할 정보 결정해서 생성
public class MemberDTO {
	// DTO 의 멤버 필드명은 DB table column 이름과 일치
	private String memID;
	private String memPWD;
	private String memName;
	private String memPhone;
	private String memAddress;
	
	// DTO 는 생성자 명시 
	public MemberDTO(String memID, String memPWD, String memName, String memPhone, String memAddress) {
		this.memID = memID;
		this.memPWD = memPWD;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memAddress = memAddress;
	}

	// DTO 는 getter/setter 구성함
	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getMemPWD() {
		return memPWD;
	}

	public void setMemPWD(String memPWD) {
		this.memPWD = memPWD;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemAddress() {
		return memAddress;
	}

	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	

}
