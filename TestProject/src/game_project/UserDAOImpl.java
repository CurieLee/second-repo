package game_project;

import java.util.Set;
import java.util.HashSet;

// Singletone 패턴으로 인스턴스 한번만 생성
public class UserDAOImpl implements UserDAO {
	private Set<UserDTO> users = new HashSet<> (); // 사용자 정보 저장
	
	private static UserDAOImpl instance; // Singletone 인스턴스 생성용 필드
	private UserDAOImpl() {} // 생성자 외부 접근 제한
	
	// 싱글톤 인스턴스 **최초 1회만 생성 후 재사용**
	public static UserDAOImpl getInstance() { 
		if (instance == null)
			instance = new UserDAOImpl();
		return instance;
	}
	
	// 사용자 등록 (회원가입)
	// 이미 등록된 회원인 경우 실패 처리
	public void insertUser(UserDTO user) {
		if (users.contains(user)) {
			System.out.println("회원가입 실패");
			System.out.println("이미 가입된 회원입니다.");
		} else {
			users.add(user);
			String userName = user.getUserName();
			System.out.println("회원가입 성공");
			System.out.println(userName+ "님, 회원가입이 완료되었습니다.");
		}
	}
	
	// 사용자 로그인
	public UserDTO loginUser(String userID, String userPWD) {
		for (UserDTO user : users) {
	        if (user.getUserID().equals(userID) && user.getUserPWD().equals(userPWD)) {
	            return user;
	        }
	    }
	    return null;
	}
	
	// 전체 회원 목록 출력: 회원 정상적으로 저장됐는지 확인용
	public void printAllUser() {
		System.out.println("======== 회원 목록 ========");
        for (UserDTO user : users) {
            System.out.println(user);
        }
	}
}
