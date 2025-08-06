package game_project;

import java.util.Set;
import java.util.HashSet;

public class UserDAOImpl implements UserDAO {
	private Set<UserDTO> users = new HashSet<> ();
	
	private static UserDAOImpl instance;
	private UserDAOImpl() {}
	public static UserDAOImpl getInstance() {
		if (instance == null)
			instance = new UserDAOImpl();
		return instance;
	}
	
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
	
	public UserDTO loginUser(String userID, String userPWD) {
		for (UserDTO user : users) {
	        if (user.getUserID().equals(userID) && user.getUserPWD().equals(userPWD)) {
	            return user;
	        }
	    }
	    return null;
	}
	
	public void printAllUser() {
		System.out.println("======== 회원 목록 ========");
        for (UserDTO user : users) {
            System.out.println(user);
        }
	}
}
